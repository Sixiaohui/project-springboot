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
    <title>详情-村务项目</title>
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
                                <h4>村务项目详情</h4>
                                <a href="list" style="color: cornflowerblue;float: right">返回</a>
                            </div>
                            <div class="card-body">
                                <form class="form-horizontal" >
                                         <div class="form-group">
                                        <label class="col-xs-12" >申报村民</label>
                                        <div class="col-xs-12">
                                            <div class="table-responsive">
                                            <c:if test="${ item.cunidFrn !=null}">
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
                                                                                                                       <td>${ item.cunidFrn.username }</td>
                                                                                                                                                  <td>${ item.cunidFrn.name }</td>
                                                                                                                             <td>${ item.cunidFrn.gender }</td>
                                                                                                                             <td>${ item.cunidFrn.tele }</td>
                                                                                                                             <td>${ item.cunidFrn.age }</td>
                                                                                                                             <td>${ item.cunidFrn.place }</td>
                                                                                                                                                  <td>${ item.cunidFrn.idnum }</td>
                                                                                                                             <td>${ item.cunidFrn.huji }</td>
                                                                                        </tr>
                                                    </tbody>
                                                </table>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >项目名</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="name" value="${ item.name }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >项目立项</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="lixiang" value="${ item.lixiang }">
                                            </div>
                                        </div>
                                               <div class="form-group">
                                            <label class="col-xs-12">项目进展</label>
                                            <div class="col-xs-12">
                                                <textarea class="form-control" style="height: 120px;width: 400px" readonly
                                                       name="jinzhan" placeholder="请输入项目进展">${ item.jinzhan }</textarea>
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >项目备注</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="remark" value="${ item.remark }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >项目经费</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="jingfei" value="${ item.jingfei }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >审核状态</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="status" value="${ item.status }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >开始时间</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="kais" value="<fmt:formatDate value='${ item.kais }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >结束时间</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="jies" value="<fmt:formatDate value='${ item.jies }' pattern='yyyy-MM-dd HH:mm:ss'/>">
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

