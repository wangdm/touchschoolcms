<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML>
<html>
<head>
<title>User Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${contextPath}/assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${contextPath}/assets/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
<link href="${contextPath}/assets/iconfont/iconfont.css" rel="stylesheet" type="text/css"/>
<link href="${contextPath}/assets/css/index.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="${contextPath}/assets/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/assets/js/bootstrap.js"></script>

<style type="text/css">
.forget-password, .register {
	text-align: right;
}
</style>
</head>

<body>
    <c:import url="../fixnav.jsp"></c:import>
    <c:import url="../menu.jsp"></c:import>
  
  <div class="container">
  
    <div class="col-sm-6 hidden-xs" style="margin:50px 0px;">
      <div class="login-ad">
      <a><img  src="assets/images/20151111153451.jpg" style="width:100%;"/></a>
      </div>
    </div>
    
    <div class="col-sm-5 col-xs-12" style="margin:50px 0px;">
      <div class="login-area" style="background-color:rgb(255,255,255);padding:20px 10px;overflow:hidden;">
        <form class="form-horizontal" role="form" name="login"
          action="${contextPath}/login" method="post">
          <fieldset class="col-xs-12">
            <legend>Sign in</legend>
            <input type="hidden"  name="from" value="{fromurl">
            <div class="form-group">
              <div class="col-sm-12 col-xs-12">
                <input type="text" name="username" class="form-control"
                  id="username" placeholder="Username" required="required">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-12 col-xs-12">
                <input type="password" name="passwd" class="form-control"
                  id="passwd" placeholder="Password" required="required">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-6 col-xs-6">
                <label><input type="checkbox" name="rememberme"
                  class="" id="rememberme"> Remember Me</label>
              </div>
              <div class="col-sm-6 col-xs-6 forget-password">
                <a>Forget Password</a>
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-6 col-xs-6">
                <button type="submit" class="btn btn-primary col-sm-10">Login</button>
              </div>
              <div class="col-sm-6 col-xs-6 register">
                <a href="register.jsp">Register Now</a>
              </div>
            </div>
          </fieldset>
        </form>
      </div>
    </div>
    
  </div>
  
    <div class="bottom"></div>
  
</body>
</html>