<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="lefttree">
    <c:import url="grouptree.jsp"></c:import>
</div>

<div class="rightcontent">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="operationbar">
                <div class="operationleft col-sm-6">
                    <div class="operation"><a href="#AddUserDialog" data-toggle="modal"><img src="${contextPath}/assets/images/add_32.png"/><span>&nbsp;添加用户</span></a></div>
                </div>
                <div class="operationright col-sm-6">
                    <div class="operation"><a href="#ImportUserDialog" data-toggle="modal"><img src="${contextPath}/assets/images/excel.png"/><span>&nbsp;导入用户</span></a></div>
                    <div class="operation"><a href="#ExportUserDialog" data-toggle="modal"><img src="${contextPath}/assets/images/excel.png"/><span>&nbsp;导出用户</span></a></div>
                </div>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="operationbar">
                <div class="col-md-5 col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon" id="inputHelpBlock"><strong>角色</strong></span>
                      <input type="text" id="inputHelpBlock" class="form-control" placeholder="选择角色" readonly>
                      <span class="input-group-btn">
                        <button class="btn btn-default" type="button" data-toggle="modal" data-target="#ChooseRoleDialog"><span class="glyphicon glyphicon-search"></span></button>
                      </span>
                    </div>
                </div>
                <div class="col-md-5 col-lg-4">
                    <div class="input-group">
                      <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">用户名<span class="caret"></span></button>
                        <ul class="dropdown-menu" style="min-width:0px">
                          <li style="display:none;"><a href="#">用户名</a></li>
                          <li><a href="#">电子邮箱</a></li>
                          <li><a href="#">电话</a></li>
                        </ul>
                      </div>
                      <input type="text" class="form-control" aria-label="...">
                      <span class="input-group-btn">
                        <button class="btn btn-default" type="button" id="QueryBtn"><span class="glyphicon glyphicon-search"></span></button>
                      </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <table class="table table-bordered table-hover table-striped table-condensed">
        <thead>
             <tr>
               <th>用户名</th>
               <th>姓名</th>
               <th>电子邮箱</th>
               <th>电话</th>
               <th>所属组</th>
               <th>角色</th>
               <th>操作</th>
             </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>

<!-- 添加用户对话框 -->
<div class="modal fade" id="AddUserDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">添加用户</h4>
      </div>
      <div class="modal-body">
          <form  class="form-horizontal" id="AddUserForm" name="AddUserForm">
              <div class="form-group">
                <label for="username" class="col-sm-3 control-label">用户名：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="username">
                </div>
              </div>
              <div class="form-group">
                <label for="password" class="col-sm-3 control-label">密码：</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" name="password">
                </div>
              </div>
              <div class="form-group">
                <label for="_password" class="col-sm-3 control-label">密码确认：</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" name="_password">
                </div>
              </div>
              <div class="form-group">
                <label for="email" class="col-sm-3 control-label">E-mail：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="email">
                </div>
              </div>
              <div class="form-group">
                <label for="phone" class="col-sm-3 control-label">电话：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="phone">
                </div>
              </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-sm btn-primary" id="AddUserBtn">添加</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 删除用户对话框 -->
<div class="modal fade" id="DelUserDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">删除用户</h4>
      </div>
      <div class="modal-body">
        <span>确认删除用户</span>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-sm btn-primary" id="DelUserBtn">删除</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 修改用户账户信息对话框 -->
<div class="modal fade" id="EditUserAccountDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改用户账户信息</h4>
      </div>
      <div class="modal-body">
          <form  class="form-horizontal" id="EditUserAccountForm" name="EditUserAccountForm">
              <div class="form-group">
                <label for="username" class="col-sm-3 control-label">用户名：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="username">
                </div>
              </div>
              <div class="form-group">
                <label for="email" class="col-sm-3 control-label">E-mail：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="email">
                </div>
              </div>
              <div class="form-group">
                <label for="phone" class="col-sm-3 control-label">电话：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="phone">
                </div>
              </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-sm btn-primary" id="EditUserAccountBtn">修改</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 修改用户密码对话框 -->
<div class="modal fade" id="EditUserPasswordDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改用户账户信息</h4>
      </div>
      <div class="modal-body">
          <form  class="form-horizontal" id="EditUserPasswordForm" name="EditUserPasswordForm">
              <div class="form-group">
                <label for="oldpassword" class="col-sm-3 control-label">旧密码：</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" name="oldpassword">
                </div>
              </div>
              <div class="form-group">
                <label for="password" class="col-sm-3 control-label">密码：</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" name="password">
                </div>
              </div>
              <div class="form-group">
                <label for="_password" class="col-sm-3 control-label">密码确认：</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" name="_password">
                </div>
              </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-sm btn-primary" id="EditUserPasswordBtn">修改密码</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 导入用户对话框 -->
<div class="modal fade" id="ImportUserDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">导入用户</h4>
      </div>
      <div class="modal-body">
          <form  class="form-horizontal">
              <div class="form-group">
                <label for="exampleInputFile" class="col-sm-3 control-label">选择用户文件：</label>
                <div class="col-sm-8">
                    <input type="file" class="form-control" id="exampleInputFile">
                </div>
              </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-sm btn-primary" id="ImportUserBtn">导入</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 导出用户对话框 -->
<div class="modal fade" id="ExportUserDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">导出用户</h4>
      </div>
      <div class="modal-body">

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-sm btn-primary" id="ExportUserBtn">导出</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 选择角色对话框 -->
<div class="modal fade" id="ChooseRoleDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">选择角色</h4>
      </div>
      <div class="modal-body">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-sm btn-primary" id="ChooseRoleBtn">确定</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
var curGroup = {"id":0, "name":"在线学习平台"};
var curRole = {"id":0, "name":""};
var queryType = "usename";
var queryValue = "";
var userlist;
$(function(){

    $(".lefttree").on("click",".node",function(){
    	curGroup.id = $(this).attr("data-id");
        getAllUser(curGroup.id,curRole.id,queryType,queryValue,0);
    });
    
    $('#EditUserAccountDialog').on('show.bs.modal', function (event) {
        var id = $(event.relatedTarget).parentsUntil("tbody").filter("tr").data('id');
        var user;
        for(var i=0;i<userlist.length;i++){
        	if(id==userlist[i].uid){
        		user = userlist[i];break;
        	}
        }
        $(this).find("[name='username']").val(user.username);
        $(this).find("[name='email']").val(user.email);
        $(this).find("[name='phone']").val(user.phone);
        $(this).find('#EditUserAccount').attr("data-id",id);
    });
    
    $('#EditUserPasswordDialog').on('show.bs.modal', function (event) {
        var id = $(event.relatedTarget).parentsUntil("tbody").filter("tr").data('id');
        $(this).find('#EditUserPasswordBtn').attr("data-id",id);
    });
    
    $('#DelUserDialog').on('show.bs.modal', function (event) {
        var id = $(event.relatedTarget).parentsUntil("tbody").filter("tr").data('id');
        var user;
        for(var i=0;i<userlist.length;i++){
            if(id==userlist[i].uid){
                user = userlist[i];break;
            }
        }
        $(this).find('.modal-body').text("是否删除用户  \""+user.username+"\"?");
        $(this).find('#DelUserBtn').attr("data-id",id);
    });
    
    $('#ChooseRoleDialog').on('show.bs.modal', function (event) {
    	getRoleList($(this).find('.modal-body'));
    });
    
    $("#AddUserBtn").on("click",function(){
    	var user = {"uid":0,"username":"","password":"","email":"","phone":"","group":{"gid":0},"role":{"id":0}};
    	user.username = $("#AddUserForm").find("[name='username']").val();
    	user.password = $("#AddUserForm").find("[name='password']").val();
    	user.email = $("#AddUserForm").find("[name='email']").val();
    	user.phone = $("#AddUserForm").find("[name='phone']").val();
    	user.group.gid = curGroup.id;
    	user.role.id = curRole.id;
        addUser(user);
    });
    
    $("#EditUserAccountBtn").on("click",function(){
        var user = {"uid":0,"username":"","password":"","email":"","phone":""};
        user.username = $("#EditUserAccountForm").find("[name='username']").val();
        user.email = $("#EditUserAccountForm").find("[name='email']").val();
        user.phone = $("#EditUserAccountForm").find("[name='phone']").val();
        user.uid = $(this).attr("data-id",id);
        editUser(user);
    });
    
    $("#EditUserPasswordBtn").on("click",function(){
        var user = {"uid":0,"oldpassword":"","password":"","_password":""};
        user.oldpassword = $("#EditUserPasswordForm").find("[name='oldpassword']").val();
        user.password = $("#EditUserPasswordForm").find("[name='password']").val();
        user._password = $("#EditUserPasswordForm").find("[name='_password']").val();
        user.uid = $(this).attr("data-id",id);
        editUser(user);
    });
    
    $("#DelUserBtn").on("click",function(){
        var id = $(this).attr("data-id",id);
        delUser(id);
    });
    
    $("#ImportUserBtn").on("click",function(){
        rolename = $("#editRoleForm").find("[name='rolename']").val();
        roleId = $(this).attr("data-id");
        editRole(rolename,roleId);
    });
    
    $("#ExportUserBtn").on("click",function(){
        roleId = $(this).attr("data-id");
        delRole(roleId);
    });
    
    $("#ChooseRoleBtn").on("click",function(){
    });
    
    $("#QueryBtn").on("click",function(){
    });
});
</script>