<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
  <nav role="navigation" class="navbar navbar-default navbar-fixed-top"
    style="min-height: 30px;height: 30px;">
    <div class="container" style="height: 30px;">
      <div style="line-height: 30px;">
        <a style="float: left;" href="${contextPath}">lubocloud.com</a>
        <c:if test="{empty user}">  
        <div style="float: left;">&nbsp;|&nbsp;</div>
        <a style="float: left;" href="admin/setting.jsp">Setting</a>
        </c:if>  
      </div>
      <div style="line-height: 30px;">
      <c:if test="${! empty curuser}">
        <a style="float: right;" href="${contextPath}/logout">Logout</a>
        <div style="float: right;">&nbsp;|&nbsp;</div>
        <a style="float: right;" href="${contextPath}/member">${curuser.username}</a>
      </c:if>  
      <c:if test="${empty curuser}">
        <a style="float: right;" href="${contextPath}/register">Register</a>
        <div style="float: right;">&nbsp;|&nbsp;</div>
        <a style="float: right;" href="${contextPath}/login">Login</a>
      </c:if>  
      </div>
    </div>
  </nav>