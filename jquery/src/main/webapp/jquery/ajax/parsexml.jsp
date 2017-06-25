<%--
  Created by IntelliJ IDEA.
  User: zhangyifa
  Date: 6/24/17
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>解析服务器响应的xml文件</title>

    <script type="text/javascript" src="../../js/jquery-3.1.0.js"></script>
</head>
<body>

    <input type="button" value="解析服务器响应的xml文件"/>

    <script type="text/javascript">
        $(":button").click(function () {
            var url = "${pageContext.request.contextPath}/jquery/ajax/city.xml?time=" + new Date().getTime();
            var sendData = null;

            $.get(url,sendData,function (xml) {
                var $xml = $(xml).find("city");
                $xml.each(function () {
                   var city = $(this).text();
                   alert(city);
                });
            });
        });
    </script>


</body>
</html>
