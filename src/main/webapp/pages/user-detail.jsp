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
    <title>详情-村民</title>
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
                                <h4>村民详情</h4>
                                <a href="list" style="color: cornflowerblue;float: right">返回</a>
                            </div>
                            <div class="card-body">
                                <form class="form-horizontal" >
                                             <div class="form-group">
                                            <label class="col-xs-12" >用户名</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="username" value="${ item.username }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >名称</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="name" value="${ item.name }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >性别</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="gender" value="${ item.gender }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >电话</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="tele" value="${ item.tele }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >年龄</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="age" value="${ item.age }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >所在地址</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="place" value="${ item.place }">
                                            </div>
                                        </div>
                                             <div class="form-group">
                                        <label class="col-xs-12" >所属网格</label>
                                        <div class="col-xs-12">
                                            <div class="table-responsive">
                                            <c:if test="${ item.wanggeidFrn !=null}">
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                                                                  <th>网格名</th>
                                                                                         <th>网格编号</th>
                                                                                         <th>所属区域</th>
                                                                                                              <th>土地利用率</th>
                                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                                                                                       <td>${ item.wanggeidFrn.name }</td>
                                                                                                                             <td>${ item.wanggeidFrn.numb }</td>
                                                                                                                             <td>${ item.wanggeidFrn.quyu }</td>
                                                                                                                                                  <td>${ item.wanggeidFrn.liyong }</td>
                                                                                        </tr>
                                                    </tbody>
                                                </table>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >身份证</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="idnum" value="${ item.idnum }">
                                            </div>
                                        </div>
                                               <div class="form-group">
                                            <label class="col-xs-12">户籍信息</label>
                                            <div class="col-xs-12">
                                                <textarea class="form-control" style="height: 120px;width: 400px" readonly
                                                       name="huji" placeholder="请输入户籍信息">${ item.huji }</textarea>
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

