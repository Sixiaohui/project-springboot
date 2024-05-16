<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .w200{width:200px}
</style>
 <script>
    var ctx = '${ pageContext.request.contextPath}';
    console.log("ctx:"+ctx)
     let userid = '${ sessionScope.user.id}'
     if(!userid){
         location.href = ctx + '/login.jsp'
     }
</script>
<!--头部信息-->
<header class="lyear-layout-header">

    <nav class="navbar navbar-default">
        <div class="topbar">

            <div class="topbar-left">
                <div class="lyear-aside-toggler">
                    <span class="lyear-toggler-bar"></span>
                    <span class="lyear-toggler-bar"></span>
                    <span class="lyear-toggler-bar"></span>
                </div>
<%--                <span class="navbar-page-title"> 表格 </span>--%>
            </div>

            <ul class="topbar-right">
                <li class="dropdown dropdown-profile">
                    <a href="javascript:void(0)" data-toggle="dropdown">
                        <span>欢迎您! ${ sessionScope.user.username} <span class="caret"></span></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li> <a href="${ pageContext.request.contextPath}/${ sessionScope.user.role}/edit?id=${ sessionScope.user.id}"><i class="mdi mdi-account"></i> 个人信息</a> </li>
                        <li class="divider"></li>
                        <li> <a href="${ pageContext.request.contextPath}/logout"><i class="mdi mdi-logout-variant"></i> 退出登录</a> </li>
                    </ul>
                </li>

            </ul>

        </div>
    </nav>

</header>
<!--End 头部信息-->

