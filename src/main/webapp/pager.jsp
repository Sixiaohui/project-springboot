<%@ page import="com.codeying.component.PagerVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<style>
    *{
        margin: 0;padding: 0;
    }
    .pager-ul{
        margin: 0;display: flex;
        list-style: none;
    }
    .pager-ul li{
        width: 30px;
        height: 30px;
        border: 1px solid #e1e1e1;
        text-align: center;
        line-height: 30px;
        margin: 0 5px;
        color:rgba(0,0,0,.6);
    }
    .active{
        background-color: rgb(27,154,247)!important;
        color: white!important;
    }

</style>
<!--万能分页模板。本页样式为nifty-admin模板样式渲染。-->
<div style="width: 100%;height: 40px;">
    <div style=" float: left;">
        <span style="color: rgba(0,0,0,.6)">共${pager.itemCount}条记录 | 共${pager.pageCount}页 | 当前第${pager.pageIndex}页</span>
    </div>
    <div style=" float: right;">
        <ul class="pager-ul">
            <% PagerVO pagerVO = ((PagerVO)(request.getAttribute("pager"))); %>
<%--最前页和左箭头--%>
            <c:if test="${pager.isFirst}"><li style="width: 50px">最前页</li></c:if>
            <c:if test="${pager.isFirst}"><li> < </li></c:if>

            <c:if test="${pager.isFirst == false}">
                <li style="width: 50px"><a href="<%=String.format(pagerVO.getPagingFormat(),1)%>" >最前页</a></li>
            </c:if>
            <c:if test="${pager.isFirst == false}">
                <li><a href="<%=String.format(pagerVO.getPagingFormat(),pagerVO.getPageIndex()-1)%>" > < </a></li>
            </c:if>
<%--开始页-1,...--%>
            <c:if test="${pager.hasLessStart}">
            <li>
                <a href="<%=String.format(pagerVO.getPagingFormat(),pagerVO.getPageStart()-1)%>" title="<%=String.format("第%s页",pagerVO.getPageStart()-1)%>" >...</a>
            </li>
            </c:if>
<%--开始页到结束页码--%>
            <%
                for (int i = pagerVO.getPageStart() ; i<=pagerVO.getPageEnd() ;i++){
                    if (i == pagerVO.getPageIndex()){
            %>
                        <li class="active" ><%=i%></li>
            <%
                    }else {
            %>
                        <li><a href="<%=String.format(pagerVO.getPagingFormat(), i)%>" title="<%=String.format("第%s页", i)%>" ><%=i%></a></li>
            <%
                    }
                }
            %>
<%--结束页+1,...--%>

            <c:if test="${pager.hasGreaterEnd}">
                <li>
                    <a href="<%=String.format(pagerVO.getPagingFormat(), pagerVO.getPageEnd()+1)%>" title="<%=String.format("第%s页", pagerVO.getPageEnd()-1)%>" >...</a>
                </li>
            </c:if>
<%--最末页--%>
            <c:if test="${pager.isLast}">
                <li> > </li>
            </c:if>
            <c:if test="${pager.isLast}">
                <li style="width: 50px">最末页</li>
            </c:if>

            <c:if test="${pager.isLast == false}">
            <li>
                <a href="<%=String.format(pagerVO.getPagingFormat(), pagerVO.getPageIndex()+1)%>" > > </a>
            </li>
            </c:if>
            <c:if test="${pager.isLast == false}">
            <li style="width: 50px">
                    <a href="<%=String.format(pagerVO.getPagingFormat(), pagerVO.getPageCount())%>"  > 最末页 </a>
            </li>
            </c:if>
        </ul>
    </div>
</div>
