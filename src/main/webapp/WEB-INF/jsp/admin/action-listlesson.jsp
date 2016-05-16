<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="content-wrapper">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="operationbar">
                <div class="operation"><a href="#addLessonDialog" data-toggle="modal"><img src="${contextPath}/assets/images/add_32.png"/><span>&nbsp;添加上课节次</span></a></div>
            </div>
        </div>
    </div>
    <table class="table table-bordered table-hover">
        <thead>
             <tr>
               <th>序号</th>
               <th>节次名称</th>
               <th>开始时间</th>
               <th>结束时间</th>
               <th>操作</th>
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
<div class="modal fade" id="addLessonDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">添加上课节次</h4>
      </div>
      <div class="modal-body">
          <form  class="form-horizontal" id="addLessonForm" name="addLessonForm">
              <div class="form-group">
                <label for="lessonname" class="col-sm-3 control-label">名称：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="lessonname">
                </div>
              </div>
              <div class="form-group">
                <label for="lessonindex" class="col-sm-3 control-label">序号：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="lessonindex">
                </div>
              </div>
              <div class="form-group">
                <label for="starttime" class="col-sm-3 control-label">开课时间：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="starttime">
                </div>
              </div>
              <div class="form-group">
                <label for="endtime" class="col-sm-3 control-label">结束时间：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="endtime">
                </div>
              </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="addLessonBtn">确定</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 添加上课节次对话框 -->
<div class="modal fade" id="editLessonDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">编辑上课节次</h4>
      </div>
      <div class="modal-body">
          <form  class="form-horizontal" id="editLessonForm" name="editLessonForm">
              <div class="form-group">
                <label for="lessonname" class="col-sm-3 control-label">名称：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="lessonname">
                </div>
              </div>
              <div class="form-group">
                <label for="lessonindex" class="col-sm-3 control-label">序号：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="lessonindex">
                </div>
              </div>
              <div class="form-group">
                <label for="starttime" class="col-sm-3 control-label">开课时间：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="starttime">
                </div>
              </div>
              <div class="form-group">
                <label for="endtime" class="col-sm-3 control-label">结束时间：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="endtime">
                </div>
              </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="editLessonBtn">确定</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 导出课表对话框 -->
<div class="modal fade" id="delLessonDialog" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">删除上课节次</h4>
      </div>
      <div class="modal-body">
        <span>确认删除上课节次</span>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="delLessonBtn">确定</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
//$('#ChooseClassDialog').on('show.bs.modal', function (e) {
$(function(){
    
    $("#addLessonBtn").on("click",function(){
    	console.log( $("#addLessonForm").serialize() );
        //$("#addLessonForm").submit();
    });
    
    $("#editLessonBtn").on("click",function(){
        console.log("editLessonBtn");
    });
    
    $("#delLessonBtn").on("click",function(){
        console.log("delLessonBtn");
    });
});
</script>