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
    <title>村务项目 编辑页</title>
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
                                <h4>村务项目信息管理</h4>
                                <a href="list" style="color: cornflowerblue;float: right">返回</a>
                            </div>
                            <div class="card-body">
                                <form autocomplete="off" enctype="multipart/form-data" id="editForm" class="form-horizontal" action="${pageContext.request.contextPath}/proj/save" method="post">
                                     <input   type="hidden" name="id"  value="${ item.id }">

<c:if test="${ not empty item.id }">
                                                                 <c:if test="${ sessionScope.user.role == 'user'}">
                                        <input readonly  type="hidden" name="cunid" value="${ sessionScope.user.id }">
                                    </c:if>
                        <c:if test="${ sessionScope.user.role != 'user'}">
                                        <div class="form-group">
                                            <label class="col-xs-12">申报村民</label>
                                            <div class="col-xs-12">
                                                <select readonly style="pointer-events: none;" required  class="form-control w200" name="cunid">
                                                    <option value="">请选择申报村民</option>
                                                                                                        <c:forEach items="${ cunidFrnList }" var="i" varStatus="s">
                                                        <option <c:if test="${ item.cunid == i.id }">selected</c:if> value="${ i.id}">${ i.name }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

              </c:if>                                                                      <div class="form-group">
                                                <label class="col-xs-12" >项目名</label>
                                                <div class="col-xs-12">
                                                    <input required readonly                                                        maxlength="255" class="form-control w200"
                                                         type="text"                                                        name="name" placeholder="请输入项目名" value="${ item.name }">
                                                </div>
                                            </div>
                                                                      <div class="form-group">
                                                <label class="col-xs-12" >项目立项</label>
                                                <div class="col-xs-12">
                                                    <input required readonly                                                        maxlength="255" class="form-control w200"
                                                         type="text"                                                        name="lixiang" placeholder="请输入项目立项" value="${ item.lixiang }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12">项目进展</label>
                                                <div class="col-xs-12">
                                                    <textarea required class="form-control" style="height: 120px;width: 400px" readonly                                                           name="jinzhan" placeholder="请输入项目进展">${ item.jinzhan }</textarea>
                                                </div>
                                            </div>
                                                                      <div class="form-group">
                                                <label class="col-xs-12" >项目备注</label>
                                                <div class="col-xs-12">
                                                    <input required readonly                                                        maxlength="255" class="form-control w200"
                                                         type="text"                                                        name="remark" placeholder="请输入项目备注" value="${ item.remark }">
                                                </div>
                                            </div>
                                                                      <div class="form-group">
                                                <label class="col-xs-12" >项目经费</label>
                                                <div class="col-xs-12">
                                                    <input required                                                         maxlength="255" class="form-control w200"
                                                         type="text"                                                        name="jingfei" placeholder="请输入项目经费" value="${ item.jingfei }">
                                                </div>
                                            </div>
                        
                                            <div class="form-group">
                                                <label class="col-xs-12">审核状态</label>
                                                <div class="col-xs-12">
                                                    <select   class="form-control w200"  name="status" >
                                                                    <option <c:if test="${ item.status == '待审核' }">selected</c:if> value="待审核">待审核</option>
                                                                    <option <c:if test="${ item.status == '通过' }">selected</c:if> value="通过">通过</option>
                                                                    <option <c:if test="${ item.status == '拒绝' }">selected</c:if> value="拒绝">拒绝</option>
                                                                </select>
                                                </div>
                                            </div>

                    </c:if>
<c:if test="${ empty item.id }">
                                                                 <c:if test="${ sessionScope.user.role == 'user'}">
                                        <input readonly  type="hidden" name="cunid" value="${ sessionScope.user.id }">
                                    </c:if>
                        <c:if test="${ sessionScope.user.role != 'user'}">
                                        <div class="form-group">
                                            <label class="col-xs-12">申报村民</label>
                                            <div class="col-xs-12">
                                                <select required class="form-control w200" name="cunid">
                                                    <option value="">请选择申报村民</option>
                                                                                                        <c:forEach items="${ cunidFrnList }" var="i" varStatus="s">
                                                        <option <c:if test="${ item.cunid == i.id }">selected</c:if> value="${ i.id}">${ i.name }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

              </c:if>                                                                    <div class="form-group">
                                                <label class="col-xs-12" >项目名</label>
                                                <div class="col-xs-12">
                                                    <input required maxlength="255"                                                        class="form-control w200"
                                                         type="text"                                                        name="name" placeholder="请输入项目名" value="${ item.name }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12" >项目立项</label>
                                                <div class="col-xs-12">
                                                    <input required maxlength="255"                                                        class="form-control w200"
                                                         type="text"                                                        name="lixiang" placeholder="请输入项目立项" value="${ item.lixiang }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12">项目进展</label>
                                                <div class="col-xs-12">
                                                    <textarea required class="form-control" style="height: 120px;width: 400px"
                                                           name="jinzhan" placeholder="请输入项目进展">${ item.jinzhan }</textarea>
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12" >项目备注</label>
                                                <div class="col-xs-12">
                                                    <input required maxlength="255"                                                        class="form-control w200"
                                                         type="text"                                                        name="remark" placeholder="请输入项目备注" value="${ item.remark }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12" >项目经费</label>
                                                <div class="col-xs-12">
                                                    <input required maxlength="255"                                                        class="form-control w200"
                                                         type="text"                                                        name="jingfei" placeholder="请输入项目经费" value="${ item.jingfei }">
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

