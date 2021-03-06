<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML>
<html>
<head>
<title>User Register</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=application.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="<%=application.getContextPath()%>/assets/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
<link href="<%=application.getContextPath()%>/assets/iconfont/iconfont.css" rel="stylesheet" type="text/css"/>
<link href="<%=application.getContextPath()%>/assets/css/index.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="<%=application.getContextPath()%>/assets/js/jquery.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/assets/js/bootstrap.js"></script>
<style type="text/css">
.forget-password, .register {
	text-align: right;
}
.form-error{
    visibility:hidden;
}
</style>
</head>

<body>
    <c:import url="../fixnav.jsp"></c:import>
    <c:import url="../menu.jsp"></c:import>

  <div class="container">
    <div class="login-area" style="margin:50px 0px;background-color:rgb(255,255,255);padding:20px 10px;overflow:hidden;">

      <form class="form-horizontal" name="register" action=""
        method="post" novalidate="novalidate">
        <fieldset class="col-md-10 col-sm-12 col-xs-12">
          <legend>Register</legend>
          <div class="form-group">
            <div class="col-md-offset-1 col-md-6 col-sm-7 col-xs-12">
              <input type="text" name="username" class="form-control"
                id="username" placeholder="User Name" required="required" onblur='formcheck(this,"username", this.value)'>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-12">
            	<span class="label label-danger form-error">The username is already existed</span>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-offset-1 col-md-6 col-sm-7 col-xs-12">
              <input type="password" name="passwd" class="form-control"
                id="passwd" placeholder="Password" required="required" onblur='formcheck(this,"passwd", this.value)'>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-12">
            	<span class="label label-danger form-error">Password must be six char at least</span>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-offset-1 col-md-6 col-sm-7 col-xs-12">
              <input type="password" name="_passwd" class="form-control"
                id="_passwd" placeholder="Conform Password" required="required" onblur='formcheck(this,"_passwd", this.value)'>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-12">
            	<span class="label label-danger form-error">Password don't match</span>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-offset-1 col-md-6 col-sm-7 col-xs-12">
              <input type="email" name="email" class="form-control"
                id="email" placeholder="E-mail" required="required" onblur='formcheck(this,"email", this.value)'>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-12">
            	<span class="label label-danger form-error">The E-mail is taken by other</span>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-offset-1 col-md-6 col-sm-7 col-xs-12">
              <input type="text" name="fullname" class="form-control"
                id="fullname" placeholder="Full Name" required="required" onblur='formcheck(this,"fullname", this.value)'>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-12">
            	<span class="label label-danger form-error"></span>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-offset-1 col-md-6 col-sm-7 col-xs-12">
              <input type="text" name="phone" class="form-control"
                id="phone" placeholder="Phone" required="required" onblur='formcheck(this,"phone", this.value)'>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-12">
            	<span class="label label-danger form-error">The phone is taken by other</span>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-offset-1 col-md-2 col-sm-2 col-xs-2">
              <button type="button" class="btn btn-success col-sm-12" onclick="registerCheck()">Register</button>
            </div>
            <div class="col-md-4 col-sm-5 col-xs-10 register">
              Already have an account? <a href="login">Login</a>
            </div>
          </div>
        </fieldset>
      </form>

    </div>
  </div>
  
  <div class="bottom"></div>
  
  <script>
  var checkreslut = true;
  function formcheck(ele,type,value){
      if(type=="username"){
          if(value.length==0){
              $(ele).parent().parent().find("span").text("The username can't be empty!");
              $(ele).parent().parent().find("span").css("visibility", "visible");
              checkreslut =  false;
          }else
          if(value.length<6){
              $(ele).parent().parent().find("span").text("The username must be six word at least!");
              $(ele).parent().parent().find("span").css("visibility", "visible");
              checkreslut =  false;
         }else{
             $.ajax({
                 "url": "<%=application.getContextPath()%>/usermanager?op=check&type="+type+"&value="+value,
                 "type": "get",
             }).success(function(data){
                 if(data.result=="failed"){
                     $(ele).parent().parent().find("span").text(data.errorinfo);
                     $(ele).parent().parent().find("span").css("visibility", "visible");
                     checkreslut =  false;
                 }else{
                     $(ele).parent().parent().find("span").css("visibility", "hidden");
                 }
             });
         }
      }else if(type=="passwd"){
          if(value.length<6){
              $(ele).parent().parent().find("span").text("The password must be six word at least!");
              $(ele).parent().parent().find("span").css("visibility", "visible");
              checkreslut =  false;
         }else{
             $(ele).parent().parent().find("span").css("visibility", "hidden");
         }
          
      }else if(type=="_passwd"){
          if($("input[name=passwd]").val()!=$("input[name=_passwd]").val()){
              $(ele).parent().parent().find("span").text("Password don't match!");
              $(ele).parent().parent().find("span").css("visibility", "visible");
              checkreslut =  false;
         }else{
             $(ele).parent().parent().find("span").css("visibility", "hidden");
         }
      }else if(type=="fullname"){
          if(value.length==0){
              $(ele).parent().parent().find("span").text("The fullname can't be empty!");
              $(ele).parent().parent().find("span").css("visibility", "visible");
              checkreslut =  false;
          }else{
              $(ele).parent().parent().find("span").css("visibility", "hidden");
          }
          
      }else if(type=="email"){
          if(value.length==0){
              $(ele).parent().parent().find("span").text("The email can't be empty!");
              $(ele).parent().parent().find("span").css("visibility", "visible");
              checkreslut =  false;
          }else{
             $.ajax({
                 "url": "<%=application.getContextPath()%>/usermanager?op=check&type="+type+"&value="+value,
                 "type": "get",
             }).success(function(data){
                 if(data.result=="failed"){
                     $(ele).parent().parent().find("span").text(data.errorinfo);
                     $(ele).parent().parent().find("span").css("visibility", "visible");
                     checkreslut =  false;
                 }else{
                     $(ele).parent().parent().find("span").css("visibility", "hidden");
                 }
             });
         }
          
      }else if(type=="phone"){
          if(value.length==0){
              $(ele).parent().parent().find("span").text("The phone can't be empty!");
              $(ele).parent().parent().find("span").css("visibility", "visible");
              checkreslut =  false;
          }else{
             $.ajax({
                 "url": "<%=application.getContextPath()%>/usermanager?op=check&type="+type+"&value="+value,
                 "type": "get",
             }).success(function(data){
                 if(data.result=="failed"){
                     $(ele).parent().parent().find("span").text(data.errorinfo);
                     $(ele).parent().parent().find("span").css("visibility", "visible");
                     checkreslut =  false;
                 }else{
                     $(ele).parent().parent().find("span").css("visibility", "hidden");
                 }
             });
         }
      }
  }
  function registerCheck(){
      checkreslut = true;
      $("input").each(function(){
          var tmp = $(this).blur();
      });
      var register_info = $("form[name=register]").serialize();
      $.ajax({
          "url": "<%=application.getContextPath()%>/usermanager?op=add",
          "type": "get",
          "data": register_info,
          "dataType": "json",
      }).fail(function(){
          alert("connect "+this.url+" failed!");
      }).success(function(data){
          if(data.result=="success"){
              window.location.href="register.jsp?result=success";
              return true;
          }
          return false;
      });
      return checkreslut;
  }
  </script>
</body>
</html>