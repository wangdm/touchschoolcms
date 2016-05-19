<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="sidebar hidden-xs col-sm-4 col-md-3  col-lg-2">
        <div class=""></div>
        <div class="sidebar-menu">
            <ul class="menu">
                <li class="${menu_index}"><a href="${contextPath}/member">
                    <span><i class="iconfont">&#xe607;</i></span>
                    <span>个人主页</span>
                </a></li>
                <li class="${menu_message}"><a href="${contextPath}/member/message">
                    <span><i class="iconfont">&#xe609;</i></span>
                    <span>我的消息</span>
                </a></li>
                <li class="${menu_favorite}"><a href="${contextPath}/member/favorite">
                    <span><i class="iconfont">&#xe608;</i></span>
                    <span>我的收藏</span>
                </a></li>
                <li class="${menu_schedule}"><a href="${contextPath}/member/schedule">
                    <span><i class="iconfont">&#xe603;</i></span>
                    <span>我的课表</span>
                </a></li>
                <li class="${menu_live}"><a href="${contextPath}/member/live">
                    <span><i class="iconfont">&#xe602;</i></span>
                    <span>我的直播</span>
                </a></li>
                <li class="${menu_course}"><a href="${contextPath}/member/course">
                    <span><i class="iconfont">&#xe604;</i></span>
                    <span>我的专辑</span>
                </a></li>
                <li class="${menu_video}"><a href="${contextPath}/member/video">
                    <span><i class="iconfont">&#xe600;</i></span>
                    <span>我的视频</span>
                </a></li>
                <li class="${menu_profile}"><a href="${contextPath}/member/profile">
                    <span><i class="iconfont">&#xe60a;</i></span>
                    <span>我的资料</span>
                </a></li>
            </ul>
        </div>
</div>