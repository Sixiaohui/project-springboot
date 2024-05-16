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
    <title>详情-投诉建议</title>
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
                                <h4>投诉建议详情</h4>
                                <a href="list" style="color: cornflowerblue;float: right">返回</a>
                            </div>
                            <div class="card-body">
                                <form class="form-horizontal" >
                                         <div class="form-group">
                                        <label class="col-xs-12" >投诉人</label>
                                        <div class="col-xs-12">
                                            <div class="table-responsive">
                                            <c:if test="${ item.useirdFrn !=null}">
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                                                                  <th>用户名</th>
                                                                                                              <th>名称</th>
                                                                                         <th>性别</th>
                                                                                         <th>电话</th>
                                                                                         <th>年龄</th>
                                                                                         <th>所在地址</th>
                                                                                                              <th>身份证</th>
                                                                                         <th>户籍信息</th>
                                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                                                                                       <td>${ item.useirdFrn.username }</td>
                                                                                                                                                  <td>${ item.useirdFrn.name }</td>
                                                                                                                             <td>${ item.useirdFrn.gender }</td>
                                                                                                                             <td>${ item.useirdFrn.tele }</td>
                                                                                                                             <td>${ item.useirdFrn.age }</td>
                                                                                                                             <td>${ item.useirdFrn.place }</td>
                                                                                                                                                  <td>${ item.useirdFrn.idnum }</td>
                                                                                                                             <td>${ item.useirdFrn.huji }</td>
                                                                                        </tr>
                                                    </tbody>
                                                </table>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >投诉内容</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="jianjie" value="${ item.jianjie }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >投诉时间</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="createtime" value="<fmt:formatDate value='${ item.createtime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >回复</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="huifu" value="${ item.huifu }">
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

