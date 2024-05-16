<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--左侧导航-->
<aside class="lyear-layout-sidebar">

    <div id="logo" class="sidebar-header">
        <a href="${ pageContext.request.contextPath}/"><h3>堤王村网格化村务管理系统</h3></a>
    </div>
    <div class="lyear-layout-sidebar-scroll">

        <nav class="sidebar-main">
            <ul class="nav nav-drawer">
                <li class="nav-item"> <a href="${ pageContext.request.contextPath}/hello"><i class="mdi mdi-home"></i> 首页</a> </li>
                <li class="nav-item"> <a href="${ pageContext.request.contextPath}/${ sessionScope.user.role}/edit?id=${ sessionScope.user.id}"><i class="mdi mdi-home"></i> 个人中心</a> </li>
                <c:if test="${sessionScope.user.role == ''  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/admin/list"><i class="mdi mdi-format-align-justify"></i>管理员</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'user'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/ganbu/list"><i class="mdi mdi-format-align-justify"></i>村干部</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'ganbu'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/user/list"><i class="mdi mdi-format-align-justify"></i>村民</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'user' ||  sessionScope.user.role == 'ganbu'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/wangge/list"><i class="mdi mdi-format-align-justify"></i>网格</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'ganbu' ||  sessionScope.user.role == 'user'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/zichan/list"><i class="mdi mdi-format-align-justify"></i>村资产信息</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'ganbu' ||  sessionScope.user.role == 'user'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/shiyong/list"><i class="mdi mdi-format-align-justify"></i>村土地使用</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'ganbu' ||  sessionScope.user.role == 'user'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/zjsy/list"><i class="mdi mdi-format-align-justify"></i>资金使用</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'ganbu' ||  sessionScope.user.role == 'user'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/cwsr/list"><i class="mdi mdi-format-align-justify"></i>财务收入</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'ganbu' ||  sessionScope.user.role == 'admin'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/cunwu/list"><i class="mdi mdi-format-align-justify"></i>村务信息</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'ganbu' ||  sessionScope.user.role == 'user'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/proj/list"><i class="mdi mdi-format-align-justify"></i>村务项目</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'ganbu' ||  sessionScope.user.role == 'user'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/shouru/list"><i class="mdi mdi-format-align-justify"></i>经济收入</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'ganbu' ||  sessionScope.user.role == 'user'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/tousu/list"><i class="mdi mdi-format-align-justify"></i>投诉建议</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin' ||  sessionScope.user.role == 'ganbu' ||  sessionScope.user.role == 'user'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/notice/list"><i class="mdi mdi-format-align-justify"></i>公告</a> </li>
                </c:if>
                <c:if test="${sessionScope.user.role == 'admin'  }">
                    <li class="nav-item"> <a href="${pageContext.request.contextPath}/userComment/list"><i class="mdi mdi-format-align-justify"></i>评论</a> </li>
                </c:if>

             <%--自定义查询--%>
                <c:if test="${ sessionScope.user.role == ''}">
                    <li class="nav-item"> <a href="${ pageContext.request.contextPath}/q?t=1">
                        <i class="mdi mdi-format-align-justify"></i>自定义查询</a>
                    </li>
                </c:if>

                            </ul>
        </nav>

    </div>

</aside>
<!--End 左侧导航-->


