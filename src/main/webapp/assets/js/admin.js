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
}

function doAdminAction(action,node){
    $.ajax({
        "url": action,
        "type": "get",
    }).success(function(data){
    	node.html(data);
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

function getDirectChildrenCategory(id){
    $.ajax({
        "url": contextPath+"/v1/directchildrencategorys/"+id,
        "type": "GET",
    }).success(function(data){
    	console.log(data);
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

function createTree(node,data){
	d = new dTree('d');
	recursiveTree(d,-1,data);
	node.html(d.toString());
}


