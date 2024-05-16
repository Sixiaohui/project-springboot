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
    <title>网格 编辑页</title>
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
                                <h4>网格信息管理</h4>
                                <a href="list" style="color: cornflowerblue;float: right">返回</a>
                            </div>
                            <div class="card-body">
                                <form autocomplete="off" enctype="multipart/form-data" id="editForm" class="form-horizontal" action="${pageContext.request.contextPath}/wangge/save" method="post">
                                     <input   type="hidden" name="id"  value="${ item.id }">

<c:if test="${ not empty item.id }">
                                                              <div class="form-group">
                                                <label class="col-xs-12" >网格名</label>
                                                <div class="col-xs-12">
                                                    <input required                                                         maxlength="18" class="form-control w200"
                                                         type="text"                                                        name="name" placeholder="请输入网格名" value="${ item.name }">
                                                </div>
                                            </div>
                                                                      <div class="form-group">
                                                <label class="col-xs-12" >网格编号</label>
                                                <div class="col-xs-12">
                                                    <input required                                                         maxlength="32" class="form-control w200"
                                                         type="text"                                                        name="numb" placeholder="请输入网格编号" value="${ item.numb }">
                                                </div>
                                            </div>
                                                                      <div class="form-group">
                                                <label class="col-xs-12" >所属区域</label>
                                                <div class="col-xs-12">
                                                    <input                                                          maxlength="255" class="form-control w200"
                                                         type="text"                                                        name="quyu" placeholder="请输入所属区域" value="${ item.quyu }">
                                                </div>
                                            </div>
                                                                         <c:if test="${ sessionScope.user.role == 'ganbu'}">
                                        <input readonly  type="hidden" name="fuzeid" value="${ sessionScope.user.id }">
                                    </c:if>
                        <c:if test="${ sessionScope.user.role != 'ganbu'}">
                                        <div class="form-group">
                                            <label class="col-xs-12">负责人</label>
                                            <div class="col-xs-12">
                                                <select  required  class="form-control w200" name="fuzeid">
                                                    <option value="">请选择负责人</option>
                                                                                                        <c:forEach items="${ fuzeidFrnList }" var="i" varStatus="s">
                                                        <option <c:if test="${ item.fuzeid == i.id }">selected</c:if> value="${ i.id}">${ i.name }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

              </c:if>                                                                      <div class="form-group">
                                                <label class="col-xs-12" >土地利用率</label>
                                                <div class="col-xs-12">
                                                    <input                                                          maxlength="255" class="form-control w200"
                                                         type="text"                                                        name="liyong" placeholder="请输入土地利用率" value="${ item.liyong }">
                                                </div>
                                            </div>
            </c:if>
<c:if test="${ empty item.id }">
                                                            <div class="form-group">
                                                <label class="col-xs-12" >网格名</label>
                                                <div class="col-xs-12">
                                                    <input required maxlength="18"                                                        class="form-control w200"
                                                         type="text"                                                        name="name" placeholder="请输入网格名" value="${ item.name }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12" >网格编号</label>
                                                <div class="col-xs-12">
                                                    <input required maxlength="32"                                                        class="form-control w200"
                                                         type="text"                                                        name="numb" placeholder="请输入网格编号" value="${ item.numb }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12" >所属区域</label>
                                                <div class="col-xs-12">
                                                    <input  maxlength="255"                                                        class="form-control w200"
                                                         type="text"                                                        name="quyu" placeholder="请输入所属区域" value="${ item.quyu }">
                                                </div>
                                            </div>
                                                                         <c:if test="${ sessionScope.user.role == 'ganbu'}">
                                        <input readonly  type="hidden" name="fuzeid" value="${ sessionScope.user.id }">
                                    </c:if>
                        <c:if test="${ sessionScope.user.role != 'ganbu'}">
                                        <div class="form-group">
                                            <label class="col-xs-12">负责人</label>
                                            <div class="col-xs-12">
                                                <select required class="form-control w200" name="fuzeid">
                                                    <option value="">请选择负责人</option>
                                                                                                        <c:forEach items="${ fuzeidFrnList }" var="i" varStatus="s">
                                                        <option <c:if test="${ item.fuzeid == i.id }">selected</c:if> value="${ i.id}">${ i.name }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

              </c:if>                                                                    <div class="form-group">
                                                <label class="col-xs-12" >土地利用率</label>
                                                <div class="col-xs-12">
                                                    <input  maxlength="255"                                                        class="form-control w200"
                                                         type="text"                                                        name="liyong" placeholder="请输入土地利用率" value="${ item.liyong }">
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

