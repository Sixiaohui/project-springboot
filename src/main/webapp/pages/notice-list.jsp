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
    <title>公告 列表</title>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" type="image/ico">
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/style.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.form.js"></script>
<%--    全局主题配置--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/theme.js"></script>
    <link href="${pageContext.request.contextPath}/assets/codeying.css" rel="stylesheet">
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
                            <div class="card-header"><h4>公告 列表</h4></div>

                            <div class="card-body">
                               <form id="dataForm" class="form-inline" action="${pageContext.request.contextPath}/notice/list" method="get">
                                <div class="row">
                                     <input id="pageIndex" type="hidden" name="pageIndex" value="1">


                                                            <div class="form-group">
                                    <label class="" >标题</label>
                                    <input maxlength="255" class="form-control" type="text" name="title" placeholder="请输入标题" >
                                </div>
                                                                    <div class="form-group">
                                    <select id="type" class="form-control"  name="type" >
                                        <option value="">类型</option>
                                                <option value="村级活动">村级活动</option>
                                                <option value="政策宣传">政策宣传</option>
                                                <option value="普通公告">普通公告</option>
                                                </select>
                                 </div>

                                                                                <div class="form-group">
                                                        <label class="">发布时间</label>
                                                        <input autocomplete="off" class="form-control js-datetimepicker" type="text"  name="createtimeL" placeholder="从此开始"  data-side-by-side="true" data-locale="zh-cn" data-format="YYYY-MM-DD HH:mm:ss" />
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="">~</label>
                                                        <input autocomplete="off" class="form-control js-datetimepicker" type="text"  name="createtimeR" placeholder="到此结束"  data-side-by-side="true" data-locale="zh-cn" data-format="YYYY-MM-DD HH:mm:ss" />
                                                    </div>
                
                                        <div class="form-group">
                                            <button class="btn btn-primary" type="submit">查 询</button>
                                        </div>

                                                                                <!-- <div class="form-group clearfix"><a target="_blank" class="btn btn-primary" href="excel">导出Excel</a></div> -->

                                         <!-- TODO 需要自定义可以导入数据的角色-->
                                        <c:if test="${ sessionScope.user.role == ''  }">
                                        <div class="form-group clearfix">
                                            <a class="btn btn-primary" href="javascript:modalBox.show()">从Excel导入</a>
                                        </div>
                                        </c:if>

                                        <c:if test="${ sessionScope.user.role == 'admin' ||   sessionScope.user.role == 'ganbu'  }">
                                        <div class="form-group clearfix">
                                            <a class="btn btn-success" href="edit">新 增</a>
                                        </div>
                                        </c:if>

                                </div>
                                ${statisticInfo}
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                              <th>标题
                                                                                                                            </th>
                                             <th>类型
                                                                                                                            </th>
                                             <th>内容
                                                                                                                            </th>
                                             <th>发布时间
                                                                                                                        ↓<input type="checkbox" name="orderby" value="createtime desc">
                                        ↑<input type="checkbox" name="orderby" value="createtime asc">
                                                                                    </th>
                                             <th>附件
                                                                                                                            </th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${ noticeList }" var="i" varStatus="s">
                                        <tr>
                                            <th scope="row">${s.count}</th>
                                                    <td>${ i.title }</td>
                                                        <td>${ i.type }</td>
                                                        <td>${ i.content }</td>
                                                        <td><fmt:formatDate value='${ i.createtime }'  pattern='yyyy-MM-dd HH:mm:ss'/></td>
                                                        <td>
                                                    <c:if test="${ not empty i.files}">
                                                        <c:choose>
                                                            <c:when test="${ fn:endsWith(i.files,'.jpg') or fn:endsWith(i.files,'.JPG')or fn:endsWith(i.files,'.png')or fn:endsWith(i.files,'.gif')or fn:endsWith(i.files,'.bmp')or fn:endsWith(i.files,'.tiff')}">
                                                                <!--图片-->
                                                                <img style="max-height: 50px;" src="${ pageContext.request.contextPath}/file?filename=${ i.files}"/>
                                                            </c:when>
                                                            <c:when test="${ fn:endsWith(i.files,'.mp4') or fn:endsWith(i.files,'.avi')or fn:endsWith(i.files,'.wmv')or fn:endsWith(i.files,'.WMV')or fn:endsWith(i.files,'.flv')}">
                                                                <!--视频-->
                                                                <video style="max-height: 100px;" src="${ pageContext.request.contextPath}/file?filename=${ i.files}" muted="muted"  loop="loop" controls></video>
                                                            </c:when>
                                                            <c:when test="${ fn:endsWith(i.files,'.mp3') or fn:endsWith(i.files,'.wma')or fn:endsWith(i.files,'.WMA')}">
                                                                <!--音频-->
                                                                <audio src="${ pageContext.request.contextPath}/file?filename=${ i.files}" controls="controls"></audio>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a style="color:#208b6b" href="${ pageContext.request.contextPath}/file?filename=${ i.files }" target="_blank">
                                                                    下载
                                                                </a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                </td>
                                                <td>
                                                <a href="detail?id=${i.id}" class="btn btn-xs btn-success">查看</a>
                                            <c:if test="${ sessionScope.user.role == 'admin' ||   sessionScope.user.role == 'ganbu'  }">
                                                <a href="edit?id=${i.id}" class="btn btn-xs btn-primary">编辑</a>
                                            </c:if>
                                            <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'ganbu'  }">
                                                <a href="javascript:del('${i.id}')" class="btn btn-xs btn-danger">删除</a>
                                            </c:if>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                 </form>
                                <div class="row">
                                    <jsp:include page="../pager.jsp"></jsp:include>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>


<!-- 模态框 -->
<div id="myModal" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <h3 style="float: left">从excel导入数据</h3>
            <span id="closeBtn" class="close">×</span>
        </div>
        <div class="modal-body">
            <p>提示：按照以下格式上传,第一行是表头</p>
            <table class="modal-table">
                <tr>
                      <td style="background-color: #0FB25F">标题</td>
                     <td style="background-color: #0FB25F">类型</td>
                     <td style="background-color: #0FB25F">内容</td>
                     <td style="background-color: #0FB25F">发布时间</td>
                     <td style="background-color: #0FB25F">附件</td>
                </tr>
                <tr>
                  <td>标题...</td>
                 <td>
                村级活动、                政策宣传、                普通公告                </td>
                 <td>内容...</td>
                 <td>格式例：1999年06月05日 12:15:00</td>
                 <td>附件...</td>
                </tr>
                <tr>
                              <td>...</td>
                         <td>...</td>
                         <td>...</td>
                         <td>...</td>
                         <td>...</td>
                </tr>
            </table>

            <form id="page_form" >
                <input type="file" value="选择Excel" name="file" id="fileExcel" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel " multiple="multiple">
                <a href="javascript:void(0);" style="cursor: pointer;background: rgb(21,195,119);color:white;padding: 10px;float: right" id="submitExcel">立即上传</a>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/project/js/list.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/main.min.js"></script>
<%--时间选择的插件--%>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker/locale/zh-cn.js"></script>
</body>
</html>
