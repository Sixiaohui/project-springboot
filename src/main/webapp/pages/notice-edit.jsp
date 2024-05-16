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
    <title>公告 编辑页</title>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" type="image/ico">
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/style.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/project/js/edit.js"></script>
    <%--    全局主题配置--%>
    <link href="${pageContext.request.contextPath}/assets/codeying.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/theme.js"></script>

</head>
<%--translucent--%>
<%--dark--%>
<body  data-theme="default">
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
                                <h4>公告信息管理</h4>
                                <a href="list" style="color: cornflowerblue;float: right">返回</a>
                            </div>
                            <div class="card-body">
                                <form autocomplete="off" enctype="multipart/form-data" id="editForm" class="form-horizontal" action="${pageContext.request.contextPath}/notice/save" method="post">
                                     <input   type="hidden" name="id"  value="${ item.id }">

<c:if test="${ not empty item.id }">
                                                              <div class="form-group">
                                                <label class="col-xs-12" >标题</label>
                                                <div class="col-xs-12">
                                                    <input required                                                         maxlength="255" class="form-control w200"
                                                         type="text"                                                        name="title" placeholder="请输入标题" value="${ item.title }">
                                                </div>
                                            </div>
                        
                                            <div class="form-group">
                                                <label class="col-xs-12">类型</label>
                                                <div class="col-xs-12">
                                                    <select   class="form-control w200"  name="type" >
                                                                    <option <c:if test="${ item.type == '村级活动' }">selected</c:if> value="村级活动">村级活动</option>
                                                                    <option <c:if test="${ item.type == '政策宣传' }">selected</c:if> value="政策宣传">政策宣传</option>
                                                                    <option <c:if test="${ item.type == '普通公告' }">selected</c:if> value="普通公告">普通公告</option>
                                                                </select>
                                                </div>
                                            </div>

                                                                      <div class="form-group">
                                                <label class="col-xs-12" >内容</label>
                                                <div class="col-xs-12">
                                                    <input                                                          maxlength="255" class="form-control w200"
                                                         type="text"                                                        name="content" placeholder="请输入内容" value="${ item.content }">
                                                </div>
                                            </div>
                                                                        <div class="form-group">
                                                <label class="col-xs-12" >附件</label>
                                                <!-- 文件下载和查看 -->
                                                <c:if test="${ not empty item.files }">
                                                    <div class="col-xs-12">
                                                        <input type="text" name="files" readonly value="${ item.files }">
                                                         <input type="button" onclick="delFile(this)" value="删除已上传">                                                         <br>
                                                    </div>
                                                 </c:if>
                                                                                                <div class="col-xs-12">
                                                    <input style="margin-top: 10px" type="file"  name="filesFile">
                                                </div>
                                                                                            </div>
            </c:if>
<c:if test="${ empty item.id }">
                                                            <div class="form-group">
                                                <label class="col-xs-12" >标题</label>
                                                <div class="col-xs-12">
                                                    <input required maxlength="255"                                                        class="form-control w200"
                                                         type="text"                                                        name="title" placeholder="请输入标题" value="${ item.title }">
                                                </div>
                                            </div>
                        
                                            <div class="form-group">
                                                <label class="col-xs-12">类型</label>
                                                <div class="col-xs-12">
                                                    <select  class="form-control w200"  name="type" >
                                                                    <option <c:if test="${ item.type == '村级活动' }">selected</c:if> value="村级活动">村级活动</option>
                                                                    <option <c:if test="${ item.type == '政策宣传' }">selected</c:if> value="政策宣传">政策宣传</option>
                                                                    <option <c:if test="${ item.type == '普通公告' }">selected</c:if> value="普通公告">普通公告</option>
                                                                </select>
                                                </div>
                                            </div>

                                                                    <div class="form-group">
                                                <label class="col-xs-12" >内容</label>
                                                <div class="col-xs-12">
                                                    <input  maxlength="255"                                                        class="form-control w200"
                                                         type="text"                                                        name="content" placeholder="请输入内容" value="${ item.content }">
                                                </div>
                                            </div>
                                                                        <div class="form-group">
                                                <label class="col-xs-12" >附件</label>
                                                <div class="col-xs-12">
                                                    <input type="file"  name="filesFile">
                                                </div>
                                            </div>
            </c:if>
                                    <div class="form-group">
                                        <input class="btn btn-primary" type="submit">
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
<%--时间选择的插件--%>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker/locale/zh-cn.js"></script>
</body>
</html>

