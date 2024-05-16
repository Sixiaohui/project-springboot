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
    <title>详情-村资产信息</title>
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
                                <h4>村资产信息详情</h4>
                                <a href="list" style="color: cornflowerblue;float: right">返回</a>
                            </div>
                            <div class="card-body">
                                <form class="form-horizontal" >
                                         <div class="form-group">
                                        <label class="col-xs-12" >所属网格</label>
                                        <div class="col-xs-12">
                                            <div class="table-responsive">
                                            <c:if test="${ item.wgidFrn !=null}">
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
                                                                                                                       <td>${ item.wgidFrn.name }</td>
                                                                                                                             <td>${ item.wgidFrn.numb }</td>
                                                                                                                             <td>${ item.wgidFrn.quyu }</td>
                                                                                                                                                  <td>${ item.wgidFrn.liyong }</td>
                                                                                        </tr>
                                                    </tbody>
                                                </table>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                             <div class="form-group">
                                        <label class="col-xs-12" >村干部</label>
                                        <div class="col-xs-12">
                                            <div class="table-responsive">
                                            <c:if test="${ item.ganbuidFrn !=null}">
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                                                                  <th>用户名</th>
                                                                                                              <th>姓名</th>
                                                                                         <th>性别</th>
                                                                                         <th>电话</th>
                                                                                         <th>年龄</th>
                                                                                         <th>职称</th>
                                                                                         <th>个人简介</th>
                                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                                                                                       <td>${ item.ganbuidFrn.username }</td>
                                                                                                                                                  <td>${ item.ganbuidFrn.name }</td>
                                                                                                                             <td>${ item.ganbuidFrn.gender }</td>
                                                                                                                             <td>${ item.ganbuidFrn.tele }</td>
                                                                                                                             <td>${ item.ganbuidFrn.age }</td>
                                                                                                                             <td>${ item.ganbuidFrn.zhic }</td>
                                                                                                                             <td>${ item.ganbuidFrn.describtion }</td>
                                                                                        </tr>
                                                    </tbody>
                                                </table>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >资产名</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="name" value="${ item.name }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >资产编号</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="numb" value="${ item.numb }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >价值</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="jiazhi" value="${ item.jiazhi }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >数量</label>
                                            <div class="col-xs-12">
                                                <input readonly class="form-control w200" type="text" name="count" value="${ item.count }">
                                            </div>
                                        </div>
                                                 <div class="form-group">
                                            <label class="col-xs-12" >创建时间</label>
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

