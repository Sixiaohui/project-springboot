<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>主页</title>
    <link rel="icon" href="${ pageContext.request.contextPath}/assets/images/favicon.ico" type="image/ico">
    <link href="${ pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/assets/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/assets/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="${ pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <%--    全局主题配置--%>
    <script type="text/javascript" src="${ pageContext.request.contextPath}/assets/theme.js"></script>
    <script type="text/javascript" src="${ pageContext.request.contextPath}/assets/js/echarts.min.js"></script>
    <script>
        $(function () {
            getEcharts()
        })
        function getEcharts() {
            $.ajax({
                type: "POST",
                url: "${ pageContext.request.contextPath}/hello",
                success: function (data) {
                    if(data.success){
                        $("#echarts").html('')//清空
                        let l = data.data
                        //TODO 显示数据
                        for (let i = 0; i < l.length; i++) {
                            let e = l[i]
                            let divi = 'div'+i;
                            let html = `<div class="col-lg-6" >
                                            <div class="card">
                                                <div class="card-header"><h4>`+e.name+`</h4></div>
                                                <div class="card-body" style="height: 400px" id="`+divi+`">
                                                </div>
                                            </div>
                                        </div>`
                            $("#echarts").append(html);
                            //渲染数据
                            var myChart = echarts.init(document.getElementById(divi));
                            let option = {
                                xAxis: {
                                    data: e.names
                                },
                                yAxis: {},
                                series: [
                                    {
                                        type: 'bar',
                                        data: e.values,
                                        label: {
                                            show: true, //开启显示
                                            position: 'top', //在上方显示
                                            formatter: '{c}',//显示数据
                                        }
                                    }
                                ]
                            };
                            myChart.setOption(option);
                            window.addEventListener("resize",function(){
                                myChart.resize();
                            });
                        }
                    }else {
                        console.log(data.message)
                    }
                },
                error: function () {
                    alert("请求服务器失败，请检查Java控制台报错");
                }
            });
        }
    </script>
</head>
<%--translucent--%>
<%--dark--%>
<body data-theme="default" onLoad="getLangDate()">
<div class="lyear-layout-web">
    <div class="lyear-layout-container">

        <!-- 页面头部 -->
        <jsp:include page="header.jsp"></jsp:include>
        <!-- 导航侧栏 -->
        <jsp:include page="sidebar.jsp"></jsp:include>

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header"><h4>Welcome,dear ${ sessionScope.user.role}！</h4></div>
                            <div class="card-body">
                                <span id="dateStr"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <%--TODO 查询条件--%>
<%--                    <div class="form-group col-lg-3">--%>
<%--                        <select id="con2" class="form-control">--%>
<%--                            <c:forEach items="${ subidFrnList }" var="i" varStatus="s">--%>
<%--                                <option value="${ i.id}">${ i.cname }</option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                    <div class="form-group col-lg-3">--%>
<%--                        <label class="">用户名</label>--%>
<%--                        <input class="form-control" type="text" id="con1">--%>
<%--                    </div>--%>
                    <%--查询按钮--%>
                    <%--<div class="form-group col-lg-3">--%>
                    <%--    <button class="btn btn-primary" type="button" onclick="getEcharts()">刷新</button>--%>
                    <%--</div>--%>
                </div>
                <%--数据图表--%>
                <div class="row" id="echarts">

                </div>

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>
<script type="text/javascript" src="${ pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath}/assets/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath}/assets/js/main.min.js"></script>
<script type="text/javascript">
    /**
     *实时显示系统时间
     */
    function getLangDate(){
        var dateObj = new Date();			//表示当前系统时间的Date对象
        var year = dateObj.getFullYear();	//当前系统时间的完整年份值
        var month = dateObj.getMonth()+1;	//当前系统时间的月份值
        var date = dateObj.getDate();		//当前系统时间的月份中的日
        var day = dateObj.getDay();			//当前系统时间中的星期值
        var weeks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
        var week = weeks[day];				//根据星期值，从数组中获取对应的星期字符串
        var hour = dateObj.getHours();		//当前系统时间的小时值
        var minute = dateObj.getMinutes();	//当前系统时间的分钟值
        var second = dateObj.getSeconds();	//当前系统时间的秒钟值
        //如果月、日、小时、分、秒的值小于10，在前面补0
        if(month<10){
            month = "0"+month;
        }
        if(date<10){
            date = "0"+date;
        }
        if(hour<10){
            hour = "0"+hour;
        }
        if(minute<10){
            minute = "0"+minute;
        }
        if(second<10){
            second = "0"+second;
        }

        var newDate = year+"年"+month+"月"+date+"日  "+week+" "+hour+":"+minute+":"+second;
        document.getElementById("dateStr").innerHTML = "当前时间：[ "+newDate+" ]";
        //setTimeout("getLangDate()",1000);//每隔1秒重新调用一次
        window.setInterval("getLangDate()", 1000);
    }
</script>
</body>
</html>


