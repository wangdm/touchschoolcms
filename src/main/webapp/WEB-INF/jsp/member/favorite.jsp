<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML>
<html>
<head>
<title>拓奇在线学习系统 - 个人空间</title>
<c:import url="head.jsp"></c:import>
</head>

<body>
    <c:import url="top.jsp"></c:import>
    
    <div id="mainbody" class="container">
    <c:import url="sidebar.jsp"></c:import>    
    
    <div id="contentWrapper" class="col-xs-12 col-sm-8 col-md-9 col-lg-10">
      <!-- Nav tabs -->
      <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">课程</a></li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">视例</a></li>
      </ul>
    
      <!-- Tab panes -->
      <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="home">...</div>
        <div role="tabpanel" class="tab-pane" id="profile">...</div>
        <div role="tabpanel" class="tab-pane" id="messages">...</div>
        <div role="tabpanel" class="tab-pane" id="settings">...</div>
      </div>
    </div>
    
    </div>
    
    <c:import url="../footer.jsp"></c:import>
</body>
</html>