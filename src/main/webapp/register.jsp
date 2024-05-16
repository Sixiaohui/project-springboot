<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>注册页面</title>
    <link rel="icon" href="${ pageContext.request.contextPath}/assets/images/favicon.ico" type="image/ico">
    <link href="${ pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/assets/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/assets/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="${ pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
     <script>
        var ctx = '${ pageContext.request.contextPath}';
        console.log("ctx:"+ctx)
    </script>
    <script type="text/javascript" src="${ pageContext.request.contextPath}/assets/theme.js"></script>
    <style>
        .lyear-wrapper {
            position: relative;
        }
        .lyear-login {
            display: flex !important;
            min-height: 100vh;
            align-items: center !important;
            justify-content: center !important;
        }
        .lyear-login:after{
            content: '';
            min-height: inherit;
            font-size: 0;
        }
        .login-center {
            background: #fff;
            min-width: 29.25rem;
            padding: 2.14286em 3.57143em;
            border-radius: 3px;
            margin: 2.85714em;
        }
        .login-header {
            margin-bottom: 1.5rem !important;
        }
        .login-center .has-feedback.feedback-left .form-control {
            padding-left: 38px;
            padding-right: 12px;
        }
        .login-center .has-feedback.feedback-left .form-control-feedback {
            left: 0;
            right: auto;
            width: 38px;
            height: 38px;
            line-height: 38px;
            z-index: 4;
            color: #dcdcdc;
        }
        .login-center .has-feedback.feedback-left.row .form-control-feedback {
            left: 15px;
        }
    </style>
</head>

<body>
<div class="row lyear-wrapper" >
    <div class="lyear-login">
        <div class="login-center">

            <form action="${ pageContext.request.contextPath}/register" method="post">
                <div class="form-group has-feedback feedback-left">
                    <input maxlength="12" type="text" placeholder="请输入您的用户名" class="form-control" name="username" id="username" />
                    <span class="mdi mdi-account form-control-feedback" aria-hidden="true"></span>
                </div>
                <div class="form-group has-feedback feedback-left">
                    <input type="password" placeholder="请输入密码" class="form-control" id="password" name="password" />
                    <span class="mdi mdi-lock form-control-feedback" aria-hidden="true"></span>
                </div>
                <div class="form-group">
                    <select class="form-control"  name="usertype" >
                        <option value="">请选择注册角色</option>
                        <option  value="admin">管理员</option>
                        <option  value="ganbu">村干部</option>
                        <option  value="user">村民</option>
                    </select>
                </div>

                <div class="form-group">
                    <button class="btn btn-block btn-primary" type="submit">注册</button>
                </div>
                <footer class="text-center">
                    <p class="m-b-0">已有账号？<a href="login.jsp">立即登陆</a></p>
                </footer>
                <c:if test="${ not empty message}">
                    <div class="alert alert-danger" role="alert">${ message}</div>
                </c:if>
            </form>
            <hr>

        </div>
    </div>
</div>
</body>
</html>

