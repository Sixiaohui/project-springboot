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
    <title>详情-财务收入</title>
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
                                <h4>财务收入详情</h4>
                                <a href="list" style="color: cornflowerblue;float: right">返回</a>
                            </div>
                            <div class="card-body">
                                <form class="form-horizontal" >
                                             <div class="form-group">
                                            <label class="col-xs-12" >收入标题</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="title" value="${ item.title }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >收入金额</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="price" value="${ item.price }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >收入说明</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="describtion" value="${ item.describtion }">
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
                                                 <div class="form-group">
                                            <label class="col-xs-12" >收入时间</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="createtime" value="<fmt:formatDate value='${ item.createtime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
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

