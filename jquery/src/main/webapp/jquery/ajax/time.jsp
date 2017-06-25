<%--
  Created by IntelliJ IDEA.
  User: zhangyifa
  Date: 6/24/17
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>服务器当前时间</title>
    <script type="text/javascript" src="../../js/jquery-3.1.0.js"></script>
</head>
<body>
    当前时间:<span id="time"></span>
    <input type="button" value="获取当前时间"/>

    <script type="text/javascript">
        $(":button").click(function () {
            var url = "${pageContext.request.contextPath}/jquryAjaxTimeServlet?time="+new Date().getTime();
            console.log(url);
            var sendDate = {
                "name" : "哈哈",
                "sal"  : 12000
            };



            $("#time").load(url,sendDate,function (backData,textStatus,xmlHttpRequest) {
                //回调函数中参数一：backData表示返回的数据，它是js对象
                //回调函数中参数二：textStatus表示返回状态的文本描述，例如：success，error，
                //回调函数中参数三：xmlHttpRequest表示ajax中的核心对象
                alert("backData = " + backData);//js对象
                alert("textStatus = " + textStatus);
                alert("xmlHttpRequest.readyState = " + xmlHttpRequest.readyState);
                alert("xmlHttpRequest.status = " + xmlHttpRequest.status);
                alert("xmlHttpRequest.responseText = " + xmlHttpRequest.responseText);//字符串
            });
            
        });
    </script>

</body>
</html>
