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

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

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

function createGroupTree(node){

    $.ajax({
        "url": contextPath+"/v1/allchildrengroups/"+0,
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


///////////////////////////////////////////////////////////////////////////////
/// Group
///////////////////////////////////////////////////////////////////////////////

function addGroup(name,parentId){
    $.ajax({
        "url": contextPath+"/v1/groups",
        "type": "POST",
        "data": JSON.stringify({"name":name,"parentGroup":{"gid":parentId}}),
        "dataType":"json",      
        "contentType":"application/json",
    }).success(function(data){
        $("#addGroupDialog").modal("hide");
        createGroupTree($(".grouptree"));
        getDirectChildrenGroup(parentId);
    }).fail(function(){
        console.log("connect "+this.url+" failed!");
        return null;
    });
}

function editGroup(name,groupId){
    $.ajax({
        "url": contextPath+"/v1/groups/"+groupId,
        "type": "PUT",
        "data": JSON.stringify({"gid":groupId,"name":name}),
        "dataType":"json",      
        "contentType":"application/json",
    }).success(function(data){
        $("#editGroupDialog").modal("hide");
        createGroupTree($(".grouptree"));
        parentId = $("#addGroupForm").find("[name='parentname']").attr("data-parentid");
        getDirectChildrenGroup(parentId);
    }).fail(function(){
        console.log("connect "+this.url+" failed!");
        return null;
    });
}

function delGroup(groupId){
    $.ajax({
        "url": contextPath+"/v1/groups/"+groupId,
        "type": "DELETE",
        "dataType":"json",      
        "contentType":"application/json",    
    }).success(function(data){
        $("#delGroupDialog").modal("hide");
        createGroupTree($(".grouptree"));
        parentId = $("#addGroupForm").find("[name='parentname']").attr("data-parentid");
        getDirectChildrenGroup(parentId);
    }).fail(function(){
        console.log("connect "+this.url+" failed!");
        return null;
    });
}

function getAllChildrenGroup(id){
    $.ajax({
        "url": contextPath+"/v1/allchildrengroups/"+id,
        "type": "GET",
    }).success(function(data){
    	//console.log(data);
    }).fail(function(){
    	console.log("connect "+this.url+" failed!");
    	return null;
    });
}

function createGroupTable(data){
	var tablestr = "<tr data-id=\""+data.id+"\" class=\"info\">"
		         + "  <td>"+data.name+"</td>"
		         + "  <td></td>"
		         + "  <td></td>"
		         + "  <td><button type=\"button\" class=\"btn btn-default btn-sm\" data-toggle=\"modal\" data-target=\"#editGroupDialog\">编辑</button></td>"
		         + "  <td><button type=\"button\" class=\"btn btn-danger btn-sm\" data-toggle=\"modal\" data-target=\"#delGroupDialog\">删除</button></td>"
		         + "</tr>";
	if(data.children){
		for(var i=0; i<data.children.length; i++){
			tablestr +="<tr data-id=\""+data.children[i].id+"\">"
			         + "  <td>"+data.children[i].name+"</td>"
			         + "  <td></td>"
			         + "  <td></td>"
			         + "  <td><button type=\"button\" class=\"btn btn-default btn-sm\" data-toggle=\"modal\" data-target=\"#editGroupDialog\">编辑</button></td>"
			         + "  <td><button type=\"button\" class=\"btn btn-danger btn-sm\" data-toggle=\"modal\" data-target=\"#delGroupDialog\">删除</button></td>"
			         + "</tr>";
		}
	}
	$(".table tbody").html(tablestr);
}

function getDirectChildrenGroup(id){
    $.ajax({
        "url": contextPath+"/v1/directchildrengroups/"+id,
        "type": "GET",
    }).success(function(data){
    	createGroupTable(data);
    	var input = $('#addGroupDialog').find("[name='parentname']");
    	input.val(data.name);
    	$(input).attr("data-parentId", data.id);
    }).fail(function(){
    	console.log("connect "+this.url+" failed!");
    	return null;
    });
}


///////////////////////////////////////////////////////////////////////////////
/// Role
///////////////////////////////////////////////////////////////////////////////

function addRole(name){
	$.ajax({
		"url": contextPath+"/v1/roles",
		"type": "POST",
		"data": JSON.stringify({"name":name}),
		"dataType":"json",      
		"contentType":"application/json",
	}).success(function(data){
		$("#addRoleDialog").modal("hide");
		getAllRole(0);
	}).fail(function(){
		console.log("connect "+this.url+" failed!");
	});
}

function editRole(name,roleId){
	$.ajax({
		"url": contextPath+"/v1/roles/"+roleId,
		"type": "PUT",
		"data": JSON.stringify({"id":roleId,"name":name}),
		"dataType":"json",      
		"contentType":"application/json",
	}).success(function(data){
		$("#editRoleDialog").modal("hide");
		getAllRole(0);
	}).fail(function(){
		console.log("connect "+this.url+" failed!");
	});
}

function delRole(roleId){
	$.ajax({
		"url": contextPath+"/v1/roles/"+roleId,
		"type": "DELETE",
		"dataType":"json",      
		"contentType":"application/json",    
	}).success(function(data){
		$("#delRoleDialog").modal("hide");
		getAllRole(0);
	}).fail(function(){
		console.log("connect "+this.url+" failed!");
	});
}

function getAllRole(page){
	$.ajax({
		"url": contextPath+"/v1/roles/?page="+page,
		"type": "GET",
	}).success(function(data){
		createRoleTable(data);
	}).fail(function(data){
		console.log(data);
		console.log("connect "+this.url+" failed!");
	});
}

function createRoleTable(data){
	tablestr = "";
	if(data.length){
		for(var i=0; i<data.length; i++){
			tablestr +="<tr data-id=\""+data[i].id+"\">"
					+ "  <td>"+data[i].name+"</td>"
					+ "  <td></td>"
					+ "  <td></td>"
					+ "  <td></td>"
					+ "  <td></td>"
					+ "  <td></td>"
					+ "  <td style=\"width:120px\">"
					+ "    <div class=\"btn-group dropup\">"
					+ "      <button type=\"button\" class=\"btn btn-default btn-sm\" data-toggle=\"modal\" data-target=\"#editRoleAuthorityDialog\">权限设置</button>"
					+ "      <button type=\"button\" class=\"btn btn-default btn-sm dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"
					+ "        <span class=\"caret\"></span>"
					+ "      </button>"
					+ "      <ul class=\"dropdown-menu\" style=\"min-width:0px\">"
					+ "        <li><a href=\"#editRoleDialog\" data-toggle=\"modal\">重命名</a></li>"
					+ "        <li><a href=\"#delRoleDialog\" data-toggle=\"modal\">删除</a></li>"
					+ "      </ul>"
					+ "    </div>"
					+ "  </td>"
					+ "</tr>";
		}
	}
	$(".table tbody").html(tablestr);
}


///////////////////////////////////////////////////////////////////////////////
/// User
///////////////////////////////////////////////////////////////////////////////

function addUser(user){
	$.ajax({
		"url": contextPath+"/v1/users",
		"type": "POST",
		"data": JSON.stringify(user),
		"dataType":"json",      
		"contentType":"application/json",
	}).success(function(data){
		$("#AddUserDialog").modal("hide");
	}).fail(function(){
		console.log("connect "+this.url+" failed!");
	});
}

function editUser(user){
	$.ajax({
		"url": contextPath+"/v1/users/"+user.uid,
		"type": "PUT",
		"data": JSON.stringify(user),
		"dataType":"json",      
		"contentType":"application/json",
	}).success(function(data){
		$("#editRoleDialog").modal("hide");
	}).fail(function(){
		console.log("connect "+this.url+" failed!");
	});
}

function delUser(uid){
	$.ajax({
		"url": contextPath+"/v1/users/"+uid,
		"type": "DELETE",
		"dataType":"json",      
		"contentType":"application/json",    
	}).success(function(data){
		$("#delRoleDialog").modal("hide");
	}).fail(function(){
		console.log("connect "+this.url+" failed!");
	});
}

function getAllUser(groupId,roleId,queryType,queryValue,page){
	$.ajax({
		"url": contextPath+"/v1/users/?gid="+groupId+"&rid="+roleId+"&"+queryType+"="+queryValue+"&page="+page,
		"type": "GET",
		"dataType":"json",      
		"contentType":"application/json",    
	}).success(function(data){
		userlist = data;
		createUserTable(data);
	}).fail(function(data){
		console.log(data);
		console.log("connect "+this.url+" failed!");
	});
}

function getRoleList(node){

	$.ajax({
		"url": contextPath+"/v1/roles/?page="+0,
		"type": "GET",
	}).success(function(data){
		liststr = "";
		if(data.length){
			for(var i=0; i<data.length; i++){
				liststr +="<ul>"
						+ "  <li data-id=\""+data[i].id+"\"><input type=\"checkbox\" name=\"role"+data[i].id+"\" />"+data[i].name+"</li>"
						+ "</ul>";
			}
		}
		node.html(liststr);
	}).fail(function(data){
		console.log(data);
		console.log("connect "+this.url+" failed!");
	});
}

function createUserTable(data){
	tablestr = "";
	if(data.length){
		for(var i=0; i<data.length; i++){
			tablestr +="<tr data-id=\""+data[i].uid+"\">"
			+ "  <td>"+data[i].username+"</td>"
			+ "  <td>"+data[i].nickname+"</td>"
			+ "  <td>"+data[i].email+"</td>"
			+ "  <td>"+data[i].phone+"</td>"
			+ "  <td>"+data[i].group.name+"</td>"
			+ "  <td>"+data[i].role.name+"</td>"
			+ "  <td style=\"width:140px\">"
			+ "    <div class=\"btn-group dropup\">"
			+ "      <button type=\"button\" class=\"btn btn-default btn-sm\" data-toggle=\"modal\" data-target=\"#EditUserAccountDialog\">修改账户资料</button>"
			+ "      <button type=\"button\" class=\"btn btn-default btn-sm dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"
			+ "        <span class=\"caret\"></span>"
			+ "      </button>"
			+ "      <ul class=\"dropdown-menu\" style=\"min-width:0px\">"
			+ "        <li><a href=\"#EditUserPasswordDialog\" data-toggle=\"modal\">修改密码</a></li>"
			+ "        <li><a href=\"#DelUserDialog\" data-toggle=\"modal\">删除</a></li>"
			+ "      </ul>"
			+ "    </div>"
			+ "  </td>"
			+ "</tr>";
		}
	}
	$(".table tbody").html(tablestr);
}
