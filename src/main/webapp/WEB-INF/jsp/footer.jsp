<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="bottom">
    <div class="container">
        <div style="width:100%;height:160px;">
            <div class="website">
                <h4>网站相关</h4>
                <ul>
                    <li><a>关于我们</a></li>
                    <li><a>建议反馈</a></li>
                    <li><a>网站地图</a></li>
                </ul>
            </div>
            <div class="links">
                <h4>友情链接</h4>
                <a target="_blank" href="http://www.touchrnb.com/">拓奇录播</a>
                <a target="_blank" href="http://www.jxnsy.com/">南湖思益</a>
            </div>
            <div class="qrcode">
                <div class="qr-image">
                    <img class="show" src="${contextPath}/assets/images/qrcode_qq.png">
                    <img src="">
                    <img src="">
                </div>
                <div class="qr-title">
                    <ul>
                        <li>拓奇微信</li>
                        <li>拓奇QQ</li>
                        <li>拓奇微博</li>
                    </ul>
                </div>
            </div>
        </div>
        <div style="width:100%;height:50px;">
            <div style="float:left;height:100%;">
                <a>粤ICP备15037391号</a>
            </div>
            <div style="float:right;height:100%;">
                <div>Copyright © 2014-2016 深圳市拓奇录播技术有限公司 All rights reserved</div>
                <div style="float:right;">深圳市南山区科技南十二路方大大厦1405室</div>
            </div>
        </div>
    </div>
</div>

<script>
var height = $(window).height()-210-100;
$("#mainbody").css("min-height", height);
</script>