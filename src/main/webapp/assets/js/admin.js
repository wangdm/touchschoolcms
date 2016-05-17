var contextPath;

function resizeDashboard(){
	var height = $(window).height()-58;
	var width = $(window).width()-$("#dashboard_menu").width();
	$("#dashboard_menu").css("height", height);
	$("#dashboard_menu").css("max-height", height);
	$("#dashboard_content").css("height", height);
	$("#dashboard_content").css("max-height", height);
	$("#dashboard_content").css("width", width);
	$("#dashboard_content").css("max-width", width);
	$(".rightcontent").css("width", width - $(".lefttree").width() - 80);
}

function doAdminAction(action,node){
    $.ajax({
        "url": action,
        "type": "get",
    }).success(function(data){
    	node.html(data);
    	resizeDashboard();
    }).fail(function(){
    	console.log("connect "+this.url+" failed!");
    });
}

function addCategory(name){
	var cat = {"name":name};
    $.ajax({
        "url": contextPath+"/v1/categorys",
        "type":"POST",
        "data":JSON.stringify(cat), 
        "dataType":"json",
        "contentType":"application/json",
    }).success(function(data){
    	console.log(data);
    }).fail(function(){
        console.log("connect "+this.url+" failed!");
    });
}

function editCategory(id,name){
	var cat = {"name":name,"id":id};
    $.ajax({
        "url": contextPath+"/v1/categorys/"+id,
        "type":"PUT",
        "data":JSON.stringify(cat), 
        "dataType":"json",
        "contentType":"application/json",
    }).success(function(data){
    	console.log(data);
    }).fail(function(){
        console.log("connect "+this.url+" failed!");
    });
}

function delCategory(id){
    $.ajax({
        "url": contextPath+"/v1/categorys/"+id,
        "type":"DELETE",
        "contentType":"application/json",
    }).success(function(data){
    	console.log(data);
    }).fail(function(){
        console.log("connect "+this.url+" failed!");
    });
}

function getAllChildrenCategory(id){
    $.ajax({
        "url": contextPath+"/v1/allchildrencategorys/"+id,
        "type": "GET",
    }).success(function(data){
    	//console.log(data);
    }).fail(function(){
    	console.log("connect "+this.url+" failed!");
    	return null;
    });
}

function createCategoryTable(data){
	var tablestr = "<tr data-id=\""+data.id+"\" class=\"info\">"
		         + "  <td>"+data.name+"</td>"
		         + "  <td></td>"
		         + "  <td></td>"
		         + "  <td><button type=\"button\" class=\"btn btn-default btn-sm\" data-toggle=\"modal\" data-target=\"#editCategoryDialog\">编辑</button></td>"
		         + "  <td><button type=\"button\" class=\"btn btn-danger btn-sm\" data-toggle=\"modal\" data-target=\"#delCategoryDialog\">删除</button></td>"
		         + "</tr>";
	if(data.children){
		for(var i=0; i<data.children.length; i++){
			tablestr +="<tr data-id=\""+data.children[i].id+"\">"
			         + "  <td>"+data.children[i].name+"</td>"
			         + "  <td></td>"
			         + "  <td></td>"
			         + "  <td><button type=\"button\" class=\"btn btn-default btn-sm\" data-toggle=\"modal\" data-target=\"#editCategoryDialog\">编辑</button></td>"
			         + "  <td><button type=\"button\" class=\"btn btn-danger btn-sm\" data-toggle=\"modal\" data-target=\"#delCategoryDialog\">删除</button></td>"
			         + "</tr>";
		}
	}
	$(".table tbody").html(tablestr);
}

function getDirectChildrenCategory(id){
    $.ajax({
        "url": contextPath+"/v1/directchildrencategorys/"+id,
        "type": "GET",
    }).success(function(data){
    	createCategoryTable(data);
    	var input = $('#addCategoryDialog').find("[name='parentname']");
    	input.val(data.name);
    	$(input).attr("data-parentId", data.id);
    }).fail(function(){
    	console.log("connect "+this.url+" failed!");
    	return null;
    });
}

function recursiveTree(tree,pid,data){
	tree.add(data.id,pid,data.name);
	if(data.children && data.children.length>0)
	{
		for(var i=0; i<data.children.length; i++)
		{
			recursiveTree(tree,data.id,data.children[i]);
		}
	}
}

function createTree(node){

    $.ajax({
        "url": contextPath+"/v1/allchildrencategorys/"+0,
        "type": "GET",
    }).success(function(data){
    	d = new dTree('d');
    	recursiveTree(d,-1,data);
    	node.html(d.toString());
    }).fail(function(){
        console.log("connect "+this.url+" failed!");
        return null;
    });
}


