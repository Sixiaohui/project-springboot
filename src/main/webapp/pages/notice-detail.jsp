<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>详情-公告</title>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" type="image/ico">
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <%--    全局主题配置--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/theme.js"></script>
   <link href="${pageContext.request.contextPath}/assets/codeying.css" rel="stylesheet">
</head>
<%--translucent--%>
<%--dark--%>
<body data-theme="default">
<div class="lyear-layout-web">
    <div class="lyear-layout-container">

        <!-- 页面头部 -->
        <jsp:include page="../header.jsp"></jsp:include>
        <!-- 导航侧栏 -->
        <jsp:include page="../sidebar.jsp"></jsp:include>

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>公告详情</h4>
                                <a href="list" style="color: cornflowerblue;float: right">返回</a>
                            </div>
                            <div class="card-body">
                                <form class="form-horizontal" >
                                             <div class="form-group">
                                            <label class="col-xs-12" >标题</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="title" value="${ item.title }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >类型</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="type" value="${ item.type }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >内容</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="content" value="${ item.content }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >发布时间</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="createtime" value="<fmt:formatDate value='${ item.createtime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                            </div>
                                        </div>
                                                <div class="form-group">
                                            <label class="col-xs-12" >附件</label>
                                            <!-- 文件下载和查看 -->
                                            <div class="col-xs-12">
                                                <c:if test="${ not empty item.files}">
                                                    <c:choose>
                                                        <c:when test="${ fn:endsWith(item.files,'.jpg') or fn:endsWith(item.files,'.JPG')or fn:endsWith(item.files,'.png')or fn:endsWith(item.files,'.gif')or fn:endsWith(item.files,'.bmp')or fn:endsWith(item.files,'.tiff')}">
                                                            <!--图片-->
                                                            <img style="max-height: 300px;" src="${ pageContext.request.contextPath}/file?filename=${ item.files}"/>
                                                        </c:when>
                                                        <c:when test="${ fn:endsWith(item.files,'.mp4') or fn:endsWith(item.files,'.avi')or fn:endsWith(item.files,'.wmv')or fn:endsWith(item.files,'.WMV')or fn:endsWith(item.files,'.flv')}">
                                                            <!--视频-->
                                                            <video src="${ pageContext.request.contextPath}/file?filename=${ item.files}" autoplay="autoplay" muted="muted"  loop="loop" controls></video>
                                                        </c:when>
                                                        <c:when test="${ fn:endsWith(item.files,'.mp3') or fn:endsWith(item.files,'.wma')or fn:endsWith(item.files,'.WMA')}">
                                                            <!--音频-->
                                                            <audio src="${ pageContext.request.contextPath}/file?filename=${ item.files}" controls="controls"></audio>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a style="color:#208b6b" href="${ pageContext.request.contextPath}/file?filename=${ item.files }" target="_blank">
                                                                下载${ item.files }
                                                            </a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:if>
                                            </div>
                                        </div>
                                    </form>
                            </div>

                        <!--评论-->
                        <div id="comments" class="comments">
                            <input id="ctid" value="${ item.id}" type="hidden">
                            <h3 style="text-align: center">评论区</h3>
                            <div id="publishBox" class="comment">
                                <div class="comment-head">
                                    <img src="${ pageContext.request.contextPath}/assets/images/users/avatar.jpg">
                                    <c:if test="${ sessionScope.user!=null}">
                                        <span>【${ sessionScope.user.rolech}】${ sessionScope.user.username}</span>
                                    </c:if>
                                    <c:if test="${ sessionScope.user==null}">
                                        <span>【登录以后即可发表评论~】</span>
                                    </c:if>
                                </div>
                                <div class="comment-body">
                                    <textarea id="commentStr"></textarea>
                                    <button id="publishBtn" type="button">发表</button>
                                </div>
                            </div>
                        </div>
                        <script>
                            var comments = document.getElementById("comments");
                            $(function () {
                                //获取评论
                                $.ajax({
                                    url: "${ pageContext.request.contextPath}/userComment2/action",
                                    data: {'ctid': $("#ctid").val()},
                                    type: "GET",
                                    success: function (data) {
                                        if(data.data){
                                            data = data.data
                                            for (let i = 0; i < data.length; i++) {
                                                let d = data[i];
                                                let html = `<div class="comment">
                                                                    <div class="comment-head">
                                                                        <img src="`+ctx+`/assets/images/users/avatar.jpg">
                                                                        <span>【`+d.rolech+`】`+d.username+`</span>
                                                                        <span class="time">`+formatDate(d.createtime)+`</span>
                                                                    </div>
                                                                    <div class="comment-body">
                                                                        <p>`+d.content+`</p>
                                                                    </div>
                                                                </div>`
                                                comments.innerHTML+=html
                                                pubEvent()
                                            }
                                        }
                                    }
                                });
                                pubEvent()
                            })
                            //绑定发表事件
                            function pubEvent() {
                                $("#publishBtn").unbind("click");
                                $("#publishBtn").click(function () {
                                    publish()
                                })
                            }
                            //发表
                            function publish() {
                                $.ajax({
                                    url: ctx + "/userComment2/action",
                                    data: {'ctid': $("#ctid").val(),'content':$("#commentStr").val(),type:'notice'},
                                    type: "POST",
                                    success: function (data) {
                                        if(data.success){
                                            let html = $(`<div class="comment">
                                                                    <div class="comment-head">
                                                                        <img src="`+ctx+`/assets/images/users/avatar.jpg">
                                                                        <span>我</span>
                                                                        <span class="time">刚刚</span>
                                                                    </div>
                                                                    <div class="comment-body">
                                                                        <p>`+$("#commentStr").val()+`</p>
                                                                    </div>
                                                                </div>`)
                                            $("#commentStr").val('')
                                            $(html).insertAfter($("#publishBox"))
                                        }else {
                                            alert("请先登录")
                                        }
                                    }
                                });
                            }
                            //时间戳转字符串
                            function formatDate(value) {
                                var date = new Date(value);
                                var y = date.getFullYear(),
                                    m = date.getMonth() + 1,
                                    d = date.getDate(),
                                    h = date.getHours(),
                                    i = date.getMinutes(),
                                    s = date.getSeconds();
                                if (m < 10) { m = '0' + m; }
                                if (d < 10) { d = '0' + d; }
                                if (h < 10) { h = '0' + h; }
                                if (i < 10) { i = '0' + i; }
                                if (s < 10) { s = '0' + s; }
                                var t = y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s;
                                return t;
                            }
                        </script>

                        </div>
                    </div>
                </div>

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/main.min.js"></script>
</body>
</html>

