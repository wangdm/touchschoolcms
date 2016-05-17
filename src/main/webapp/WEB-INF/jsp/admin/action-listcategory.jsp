<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="lefttree">
    <c:import url="categorytree.jsp"></c:import>
</div>

<div class="rightcontent">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="operationbar">
                <div class="operation"><a href="#addCategoryDialog" data-toggle="modal"><img src="${contextPath}/assets/images/add_32.png"/><span>&nbsp;添加分类</span></a></div>
            </div>
        </div>
    </div>
        <table class="table table-bordered table-hover table-striped table-condensed">
        <thead>
             <tr>
               <th>分类名</th>
               <th>课程数目</th>
               <th>视频数目</th>
               <th>编辑</th>
               <th>删除</th>
             </tr>
        </thead>
        <tbody>
        <c:forEach var="lesson" items="${lessonList}">
            <tr>
                <td>${lesson.index}</td>
                <td>${lesson.name}</td>
                <td>${lesson.starttime}</td>
                <td>${lesson.endtime}</td>
                <td style="width:120px">
                  <div class="btn-group dropup">
                    <button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#editLessonDialog">编辑</button>
                    <button type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" style="min-width:0px">
                      <li><a href="#delLessonDialog" data-toggle="modal">删除</a></li>
                    </ul>
                  </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- 添加上课节次对话框 -->
<div class="modal fade" id="addCategoryDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">添加分类</h4>
      </div>
      <div class="modal-body">
          <form  class="form-horizontal" id="addCategoryForm" name="addCategoryForm">
              <div class="form-group">
                <label for="parentname" class="col-sm-3 control-label">父类目：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="parentname" readonly>
                </div>
              </div>
              <div class="form-group">
                <label for="catname" class="col-sm-3 control-label">分类名：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="catname">
                </div>
              </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary btn-sm" id="addCategoryBtn">确定</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 添加上课节次对话框 -->
<div class="modal fade" id="editCategoryDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">重命名分类</h4>
      </div>
      <div class="modal-body">
          <form  class="form-horizontal" id="editCategoryForm" name="editCategoryForm">
              <div class="form-group">
                <label for="catname" class="col-sm-3 control-label">分类名：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="catname">
                </div>
              </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary btn-sm" id="editCategoryBtn">重命名</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 添加上课节次对话框 -->
<div class="modal fade" id="delCategoryDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">删除分类</h4>
      </div>
      <div class="modal-body">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary btn-sm" id="delCategoryBtn">删除</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
$(function(){
	
	getDirectChildrenCategory(0);
	
    $(".lefttree").on("click",".node",function(){
        getDirectChildrenCategory($(this).attr("data-id"));
    });
    
    $('#editCategoryDialog').on('show.bs.modal', function (event) {
          var button = $(event.relatedTarget)
          var tr = $(button).parentsUntil("tbody").filter("tr");
          var id = tr.data('id');
          var name = $(tr).children("td:first").text();
          $(this).find("[name='catname']").val(name);
          $(this).find('#editCategoryBtn').attr("data-id",id);
    })
    
    $('#delCategoryDialog').on('show.bs.modal', function (event) {
    	  var button = $(event.relatedTarget)
    	  var tr = $(button).parentsUntil("tbody").filter("tr");
    	  var id = tr.data('id');
    	  var name = $(tr).children("td:first").text();
    	  $(this).find('.modal-body').text("是否删除  \""+name+"\" 分类?");
    	  $(this).find('#delCategoryBtn').attr("data-id",id);
    })
    	
    $("#addCategoryBtn").on("click",function(){
        name = $("#addCategoryForm").find("[name='catname']").val();
        parentId = $("#addCategoryForm").find("[name='parentname']").attr("data-parentid");
        $.ajax({
            "url": contextPath+"/v1/categorys",
            "type": "POST",
            "data": JSON.stringify({"name":name,"parentCategory":{"id":parentId}}),
            "dataType":"json",      
            "contentType":"application/json",
        }).success(function(data){
            $("#addCategoryDialog").modal("hide");
        	createTree($(".categorytree"));
        	getDirectChildrenCategory(parentId);
            //doAdminAction("${contextPath}/admin/listcoursecategory",$("#dashboard_content"));
        }).fail(function(){
            console.log("connect "+this.url+" failed!");
            return null;
        });

    });
    
    $("#editCategoryBtn").on("click",function(){
        parentId = $("#addCategoryForm").find("[name='parentname']").attr("data-parentid");
        name = $("#editCategoryForm").find("[name='catname']").val();
        catId = $(this).attr("data-id");
        $.ajax({
            "url": contextPath+"/v1/categorys/"+catId,
            "type": "PUT",
            "data": JSON.stringify({"id":catId,"name":name}),
            "dataType":"json",      
            "contentType":"application/json",
        }).success(function(data){
            $("#editCategoryDialog").modal("hide");
            createTree($(".categorytree"));
            getDirectChildrenCategory(parentId);
            //doAdminAction("${contextPath}/admin/listcoursecategory",$("#dashboard_content"));
        }).fail(function(){
            console.log("connect "+this.url+" failed!");
            return null;
        });
    });
    
    $("#delCategoryBtn").on("click",function(){
        parentId = $("#addCategoryForm").find("[name='parentname']").attr("data-parentid");
        catId = $(this).attr("data-id");
        $.ajax({
            "url": contextPath+"/v1/categorys/"+catId,
            "type": "DELETE",
            "dataType":"json",      
            "contentType":"application/json",    
        }).success(function(data){
            $("#delCategoryDialog").modal("hide");
            createTree($(".categorytree"));
            getDirectChildrenCategory(parentId);
            //doAdminAction("${contextPath}/admin/listcoursecategory",$("#dashboard_content"));
        }).fail(function(){
            console.log("connect "+this.url+" failed!");
            return null;
        });

    });
});
</script>