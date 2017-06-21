<%@page language="java" pageEncoding="utf-8" %>

<html>
<head>
    <title>时间</title>
</head>
<body>
    <h2>当前时间:${nowStr}</h2>
    <input id="buttonID" type="button" value="获取当前时间"/>

    使用EL表达式获取数据：${nowStr}

    <script type="text/javascript">
        //定位按钮，添加事件
        document.getElementById("buttonID").onclick = function () {
            //发送请求

            /*
            El表达式的写法：${pageContext.request.contextPath}
            jsp的写法：<%=request.getContextPath()%>
            */
            var url = "${pageContext.request.contextPath}/TimeServlet";
            <%--alert(url +"\n 22 \n" + "<%=request.getContextPath()%>");--%>
            window.location.href = url;
        }
    </script>



</body>
</html>
