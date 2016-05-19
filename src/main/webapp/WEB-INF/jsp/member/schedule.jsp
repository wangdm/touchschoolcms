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
    <table class="table table-bordered table-hover">
        <thead>
             <tr>
               <th>#</th>
               <th>星期一</th>
               <th>星期二</th>
               <th>星期三</th>
               <th>星期四</th>
               <th>星期五</th>
               <th>星期六</th>
               <th>星期日</th>
             </tr>
        </thead>
        <tbody>
        <c:forEach var="lesson" items="${lessonList}">
            <tr>
                <th>${lesson.name}</th>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
    </div>
    
    <c:import url="../footer.jsp"></c:import>
</body>
</html>