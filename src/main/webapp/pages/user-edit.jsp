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
    <title>村民 编辑页</title>
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
                                <h4>村民信息管理</h4>
                                <a href="list" style="color: cornflowerblue;float: right">返回</a>
                            </div>
                            <div class="card-body">
                                <form autocomplete="off" enctype="multipart/form-data" id="editForm" class="form-horizontal" action="${pageContext.request.contextPath}/user/save" method="post">
                                     <input   type="hidden" name="id"  value="${ item.id }">

<c:if test="${ not empty item.id }">
                                                              <div class="form-group">
                                                <label class="col-xs-12" >用户名</label>
                                                <div class="col-xs-12">
                                                    <input required readonly                                                        maxlength="20" class="form-control w200"
                                                         type="text"                                                        name="username" placeholder="请输入用户名" value="${ item.username }">
                                                </div>
                                            </div>
                                                                      <div class="form-group">
                                                <label class="col-xs-12" >密码</label>
                                                <div class="col-xs-12">
                                                    <input                                                          maxlength="20" class="form-control w200"
                                                         type="text"                                                        name="password" placeholder="请输入密码" value="${ item.password }">
                                                </div>
                                            </div>
                                                                      <div class="form-group">
                                                <label class="col-xs-12" >名称</label>
                                                <div class="col-xs-12">
                                                    <input required                                                         maxlength="18" class="form-control w200"
                                                         type="text"                                                        name="name" placeholder="请输入名称" value="${ item.name }">
                                                </div>
                                            </div>
                        
                                            <div class="form-group">
                                                <label class="col-xs-12">性别</label>
                                                <div class="col-xs-12">
                                                    <select   class="form-control w200"  name="gender" >
                                                                    <option <c:if test="${ item.gender == '男' }">selected</c:if> value="男">男</option>
                                                                    <option <c:if test="${ item.gender == '女' }">selected</c:if> value="女">女</option>
                                                                </select>
                                                </div>
                                            </div>

                                                                      <div class="form-group">
                                                <label class="col-xs-12" >电话</label>
                                                <div class="col-xs-12">
                                                    <input                                                          maxlength="11" class="form-control w200"
                                                         type="text"                                                        name="tele" placeholder="请输入电话" value="${ item.tele }">
                                                </div>
                                            </div>
                                                                      <div class="form-group">
                                                <label class="col-xs-12" >年龄</label>
                                                <div class="col-xs-12">
                                                    <input                                                           class="form-control w200"
                                                        type="number"                                                        name="age" placeholder="请输入年龄" value="${ item.age }">
                                                </div>
                                            </div>
                                                                      <div class="form-group">
                                                <label class="col-xs-12" >所在地址</label>
                                                <div class="col-xs-12">
                                                    <input                                                          maxlength="255" class="form-control w200"
                                                         type="text"                                                        name="place" placeholder="请输入所在地址" value="${ item.place }">
                                                </div>
                                            </div>
                                                 
                                        <div class="form-group">
                                            <label class="col-xs-12">所属网格</label>
                                            <div class="col-xs-12">
                                                <select    class="form-control w200" name="wanggeid">
                                                    <option value="">请选择所属网格</option>
                                                                                                        <c:forEach items="${ wanggeidFrnList }" var="i" varStatus="s">
                                                        <option <c:if test="${ item.wanggeid == i.id }">selected</c:if> value="${ i.id}">${ i.name }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                                                                    <div class="form-group">
                                                <label class="col-xs-12" >身份证</label>
                                                <div class="col-xs-12">
                                                    <input required                                                         maxlength="18" class="form-control w200"
                                                         type="text"                                                        name="idnum" placeholder="请输入身份证" value="${ item.idnum }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12">户籍信息</label>
                                                <div class="col-xs-12">
                                                    <textarea  class="form-control" style="height: 120px;width: 400px"                                                            name="huji" placeholder="请输入户籍信息">${ item.huji }</textarea>
                                                </div>
                                            </div>
            </c:if>
<c:if test="${ empty item.id }">
                                                            <div class="form-group">
                                                <label class="col-xs-12" >用户名</label>
                                                <div class="col-xs-12">
                                                    <input required maxlength="20"                                                        class="form-control w200"
                                                         type="text"                                                        name="username" placeholder="请输入用户名" value="${ item.username }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12" >密码</label>
                                                <div class="col-xs-12">
                                                    <input  maxlength="20"                                                        class="form-control w200"
                                                         type="text"                                                        name="password" placeholder="请输入密码" value="${ item.password }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12" >名称</label>
                                                <div class="col-xs-12">
                                                    <input required maxlength="18"                                                        class="form-control w200"
                                                         type="text"                                                        name="name" placeholder="请输入名称" value="${ item.name }">
                                                </div>
                                            </div>
                        
                                            <div class="form-group">
                                                <label class="col-xs-12">性别</label>
                                                <div class="col-xs-12">
                                                    <select  class="form-control w200"  name="gender" >
                                                                    <option <c:if test="${ item.gender == '男' }">selected</c:if> value="男">男</option>
                                                                    <option <c:if test="${ item.gender == '女' }">selected</c:if> value="女">女</option>
                                                                </select>
                                                </div>
                                            </div>

                                                                    <div class="form-group">
                                                <label class="col-xs-12" >电话</label>
                                                <div class="col-xs-12">
                                                    <input  maxlength="11"                                                        class="form-control w200"
                                                         type="text"                                                        name="tele" placeholder="请输入电话" value="${ item.tele }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12" >年龄</label>
                                                <div class="col-xs-12">
                                                    <input                                                          class="form-control w200"
                                                        type="number"                                                        name="age" placeholder="请输入年龄" value="${ item.age }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12" >所在地址</label>
                                                <div class="col-xs-12">
                                                    <input  maxlength="255"                                                        class="form-control w200"
                                                         type="text"                                                        name="place" placeholder="请输入所在地址" value="${ item.place }">
                                                </div>
                                            </div>
                                                 
                                        <div class="form-group">
                                            <label class="col-xs-12">所属网格</label>
                                            <div class="col-xs-12">
                                                <select  class="form-control w200" name="wanggeid">
                                                    <option value="">请选择所属网格</option>
                                                                                                        <c:forEach items="${ wanggeidFrnList }" var="i" varStatus="s">
                                                        <option <c:if test="${ item.wanggeid == i.id }">selected</c:if> value="${ i.id}">${ i.name }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                                                                  <div class="form-group">
                                                <label class="col-xs-12" >身份证</label>
                                                <div class="col-xs-12">
                                                    <input required maxlength="18"                                                        class="form-control w200"
                                                         type="text"                                                        name="idnum" placeholder="请输入身份证" value="${ item.idnum }">
                                                </div>
                                            </div>
                                                                    <div class="form-group">
                                                <label class="col-xs-12">户籍信息</label>
                                                <div class="col-xs-12">
                                                    <textarea  class="form-control" style="height: 120px;width: 400px"
                                                           name="huji" placeholder="请输入户籍信息">${ item.huji }</textarea>
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

