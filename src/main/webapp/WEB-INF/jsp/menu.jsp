<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <div class="navmenu-bg">
    <div class="navmenu container">
      <ul>
        <li><a class="${menu_index}" href="${contextPath}">首页</a></li>
        <li><a class="${menu_live}" href="${contextPath}/lives">直播课程</a></li>
        <li><a class="${menu_video}" href="${contextPath}/videos">点播课程</a></li>
        <li><a class="${menu_course}" href="${contextPath}/courses">专辑课程</a></li>
        <li><a class="${menu_book}" href="${contextPath}/books">同步课堂</a></li>
        <li style="float:right;padding:3px">
        <form name="search" action="search.jsp">
            <input name="keyword" type="search"  class="form-control" placeholder="Search Course"/>
        </form>
        </li>
      </ul>
    </div>
  </div>