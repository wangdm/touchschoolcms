<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<%=application.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="<%=application.getContextPath()%>/assets/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
<link href="<%=application.getContextPath()%>/assets/iconfont/iconfont.css" rel="stylesheet" type="text/css"/>
<link href="<%=application.getContextPath()%>/assets/css/admin.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="<%=application.getContextPath()%>/assets/js/jquery.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/assets/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/assets/js/admin.js"></script>

</head>
<body>

<div id="dashboard_top">

  <nav role="navigation" class="navbar navbar-default navbar-fixed-top"
    style="min-height: 50px;">
      <div style="line-height: 50px;">
        <a style="float: left;" href="<%=application.getContextPath()%>">
            <img src="<%=application.getContextPath()%>/assets/images/dashboard.png"/>
        </a>
      </div>
      <div style="line-height: 50px;">
        <a style="float: right;" href="logout.jsp">Logout</a>
        <div style="float: right;">&nbsp;|&nbsp;</div>
        <a style="float: right;" href="member.jsp">
        </a>
      </div>
  </nav>

</div>

<div id="dashboard_body">

<div id="dashboard_menu">
  <div class="nav-header" data-target="#dashboard" data-toggle="collapse">
          <i class="iconfont">&#xe606;</i> 后台首页
  </div>
  
  <div class="nav-header" data-target="#dashboard-user" data-toggle="collapse">
          <i class="iconfont">&#xe601;</i> 用户管理
  </div>
  <div id="dashboard-user" class="collapse" aria-expanded="true">
      <ul class="nav nav-list">
          <li data-action="listgroup"><a>用户组管理</a></li>
          <li data-action="listrole"><a>角色管理</a></li>
          <li data-action="listuser"><a>用户管理</a></li>
      </ul>
  </div>
  
  <div class="nav-header" data-target="#dashboard-course" data-toggle="collapse">
          <i class="iconfont">&#xe600;</i> 课程管理
  </div>
  <div id="dashboard-course" class="collapse" aria-expanded="true">
      <ul class="nav nav-list">
          <li data-action="listcoursecategory"><a>课程分类</a></li>
          <li data-action="listcourse"><a>课程管理</a></li>
          <li data-action="listvideo"><a>视频管理</a></li>
      </ul>
  </div>
  
  <div class="nav-header" data-target="#dashboard-schedule" data-toggle="collapse">
          <i class="iconfont">&#xe603;</i> 课表管理
  </div>
  <div id="dashboard-schedule" class="collapse" aria-expanded="true">
      <ul class="nav nav-list">
          <li data-action="listlesson"><a>课程节次</a></li>
          <li data-action="querygroupschedule"><a>班级课表</a></li>
          <li data-action="queryclassschedule"><a>教室课表</a></li>
          <li data-action="queryteacherschedule"><a>老师课表</a></li>
      </ul>
  </div>
  
  <div class="nav-header" data-target="#dashboard-subject" data-toggle="collapse">
          <i class="iconfont">&#xe604;</i> 学科管理
  </div>
  <div id="dashboard-subject" class="collapse" aria-expanded="true">
      <ul class="nav nav-list">
          <li data-action="listsubject"><a>学科管理</a></li>
          <li data-action="listpublisher"><a>出版社</a></li>
          <li data-action="listtextbook"><a>课本管理</a></li>
      </ul>
  </div>
  
  <div class="nav-header" data-target="#dashboard-device" data-toggle="collapse">
          <i class="iconfont">&#xe602;</i> 设备管理
  </div>
  <div id="dashboard-device" class="collapse" aria-expanded="true">
      <ul class="nav nav-list">
          <li data-action="listclassroom"><a>录播教室</a></li>
          <li data-action="listrbdevice"><a>录播设备</a></li>
      </ul>
  </div>

</div>

<div id="dashboard_content">
</div>

</div>

<script type="text/javascript">
$(function(){
    resizeDashboard();
	$(window).resize(function(){
	    resizeDashboard();
	});
	$("#dashboard_menu li").on("click", function(){
		var action = "<%=application.getContextPath()%>/admin/"+$(this).attr("data-action");
		doAdminAction(action);
	})
});
</script>
</body>
</html>