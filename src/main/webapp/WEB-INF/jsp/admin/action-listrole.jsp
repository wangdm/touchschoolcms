<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="content-wrapper">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="operationbar">
                <div class="operation"><a href="#addRoleDialog" data-toggle="modal"><img src="${contextPath}/assets/images/add_32.png"/><span>&nbsp;添加用户角色</span></a></div>
            </div>
        </div>
    </div>
    <table class="table table-bordered table-hover">
        <thead>
             <tr>
               <th>角色名</th>
               <th>用户数</th>
               <th>权限1</th>
               <th>权限2</th>
               <th>权限3</th>
               <th>权限4</th>
               <th>操作</th>
             </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>

<!-- 添加角色对话框 -->
<div class="modal fade" id="addRoleDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">添加角色</h4>
      </div>
      <div class="modal-body">
          <form  class="form-horizontal" id="addRoleForm" name="addRoleForm">
              <div class="form-group">
                <label for="rolename" class="col-sm-3 control-label">角色名：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="rolename">
                </div>
              </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-sm btn-primary" id="addRoleBtn">添加</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 重命名角色名对话框 -->
<div class="modal fade" id="editRoleDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">重命名角色</h4>
      </div>
      <div class="modal-body">
          <form  class="form-horizontal" id="editRoleForm" name="editRoleForm">
              <div class="form-group">
                <label for="rolename" class="col-sm-3 control-label">新角色名：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="rolename">
                </div>
              </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-sm btn-primary" id="editRoleBtn">重命名</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 删除角色对话框 -->
<div class="modal fade" id="delRoleDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">删除角色</h4>
      </div>
      <div class="modal-body">
        <span>确认删除角色</span>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-sm btn-primary" id="delRoleBtn">删除</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 角色权限编辑对话框 -->
<div class="modal fade" id="editRoleAuthorityDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">权限修改</h4>
      </div>
      <div class="modal-body">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-sm btn-primary" id="editRoleAuthorityBtn">确定</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
$(function(){
	getAllRole(0);
    $('#editRoleDialog').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var tr = $(button).parentsUntil("tbody").filter("tr");
        var id = tr.data('id');
        var name = $(tr).children("td:first").text();
        $(this).find("[name='rolename']").val(name);
        $(this).find('#editRoleBtn').attr("data-id",id);
    });
    
    $('#delRoleDialog').on('show.bs.modal', function (event) {
          var button = $(event.relatedTarget)
          var tr = $(button).parentsUntil("tbody").filter("tr");
          var id = tr.data('id');
          var name = $(tr).children("td:first").text();
          $(this).find('.modal-body').text("是否删除角色  \""+name+"\"?");
          $(this).find('#delRoleBtn').attr("data-id",id);
    });
    
    $("#addRoleBtn").on("click",function(){
        rolename = $("#addRoleForm").find("[name='rolename']").val();
        addRole(rolename);
    });
    
    $("#editRoleBtn").on("click",function(){
        rolename = $("#editRoleForm").find("[name='rolename']").val();
        roleId = $(this).attr("data-id");
        editRole(rolename,roleId);
    });
    
    $("#delRoleBtn").on("click",function(){
        roleId = $(this).attr("data-id");
        delRole(roleId);
    });
    
    $("#editRoleAuthorityBtn").on("click",function(){
    });
});
</script>