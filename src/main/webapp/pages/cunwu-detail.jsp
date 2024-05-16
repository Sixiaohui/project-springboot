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
    <title>详情-村务信息</title>
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
                                <h4>村务信息详情</h4>
                                <a href="list" style="color: cornflowerblue;float: right">返回</a>
                            </div>
                            <div class="card-body">
                                <form class="form-horizontal" >
                                             <div class="form-group">
                                            <label class="col-xs-12" >村务信息名</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="name" value="${ item.name }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >分类</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="type" value="${ item.type }">
                                            </div>
                                        </div>
                                                <div class="form-group">
                                            <label class="col-xs-12" >村级文件</label>
                                            <!-- 文件下载和查看 -->
                                            <div class="col-xs-12">
                                                <c:if test="${ not empty item.wenj}">
                                                    <c:choose>
                                                        <c:when test="${ fn:endsWith(item.wenj,'.jpg') or fn:endsWith(item.wenj,'.JPG')or fn:endsWith(item.wenj,'.png')or fn:endsWith(item.wenj,'.gif')or fn:endsWith(item.wenj,'.bmp')or fn:endsWith(item.wenj,'.tiff')}">
                                                            <!--图片-->
                                                            <img style="max-height: 300px;" src="${ pageContext.request.contextPath}/file?filename=${ item.wenj}"/>
                                                        </c:when>
                                                        <c:when test="${ fn:endsWith(item.wenj,'.mp4') or fn:endsWith(item.wenj,'.avi')or fn:endsWith(item.wenj,'.wmv')or fn:endsWith(item.wenj,'.WMV')or fn:endsWith(item.wenj,'.flv')}">
                                                            <!--视频-->
                                                            <video src="${ pageContext.request.contextPath}/file?filename=${ item.wenj}" autoplay="autoplay" muted="muted"  loop="loop" controls></video>
                                                        </c:when>
                                                        <c:when test="${ fn:endsWith(item.wenj,'.mp3') or fn:endsWith(item.wenj,'.wma')or fn:endsWith(item.wenj,'.WMA')}">
                                                            <!--音频-->
                                                            <audio src="${ pageContext.request.contextPath}/file?filename=${ item.wenj}" controls="controls"></audio>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a style="color:#208b6b" href="${ pageContext.request.contextPath}/file?filename=${ item.wenj }" target="_blank">
                                                                下载${ item.wenj }
                                                            </a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:if>
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >会议纪要</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="huiyi" value="${ item.huiyi }">
                                            </div>
                                        </div>
                                                <div class="form-group">
                                            <label class="col-xs-12" >决策文件</label>
                                            <!-- 文件下载和查看 -->
                                            <div class="col-xs-12">
                                                <c:if test="${ not empty item.juece}">
                                                    <c:choose>
                                                        <c:when test="${ fn:endsWith(item.juece,'.jpg') or fn:endsWith(item.juece,'.JPG')or fn:endsWith(item.juece,'.png')or fn:endsWith(item.juece,'.gif')or fn:endsWith(item.juece,'.bmp')or fn:endsWith(item.juece,'.tiff')}">
                                                            <!--图片-->
                                                            <img style="max-height: 300px;" src="${ pageContext.request.contextPath}/file?filename=${ item.juece}"/>
                                                        </c:when>
                                                        <c:when test="${ fn:endsWith(item.juece,'.mp4') or fn:endsWith(item.juece,'.avi')or fn:endsWith(item.juece,'.wmv')or fn:endsWith(item.juece,'.WMV')or fn:endsWith(item.juece,'.flv')}">
                                                            <!--视频-->
                                                            <video src="${ pageContext.request.contextPath}/file?filename=${ item.juece}" autoplay="autoplay" muted="muted"  loop="loop" controls></video>
                                                        </c:when>
                                                        <c:when test="${ fn:endsWith(item.juece,'.mp3') or fn:endsWith(item.juece,'.wma')or fn:endsWith(item.juece,'.WMA')}">
                                                            <!--音频-->
                                                            <audio src="${ pageContext.request.contextPath}/file?filename=${ item.juece}" controls="controls"></audio>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a style="color:#208b6b" href="${ pageContext.request.contextPath}/file?filename=${ item.juece }" target="_blank">
                                                                下载${ item.juece }
                                                            </a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:if>
                                            </div>
                                        </div>
                                    </form>
                            </div>


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

