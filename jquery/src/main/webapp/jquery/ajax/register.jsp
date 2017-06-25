<%--
  Created by IntelliJ IDEA.
  User: zhangyifa
  Date: 6/24/17
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检查注册用户名和密码是否存在</title>
    <script type="text/javascript" src="../../js/jquery-3.1.0.js"></script>
</head>
<body>

<form action="time.jsp" method="get">
    <table border="2" align="center">
        <tr>
            <th>用户名</th>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <th>密码</th>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="button" value="检查"/>
            </td>
        </tr>
    </table>
    <span></span>
</form>

<script type="text/javascript">
    $(":button").click(function () {
        var username = $(":text").val();
        var password = $(":password").val();
        var url = "${pageContext.request.contextPath}/jqueryAjaxUserServlet?time="+new Date().getTime();
//        var sendData = {
//             "username" : username,
//             "password" : password
//        };

        var sendData = $("form").serialize();

        $.post(url,sendData,function (backDate) {
            //backDate：
            //如果服务器返回html，即backDate就是string，不要解析
            //如果服务器返回json，即backDate就是object，要解析
            //如果服务器返回xml，即backDate就是object，要解析
            console.log(backDate);

            var $img = $("<img src='"+backDate+"' width='14px' height='14px'>");
            $("span").text("");
            $("span").append($img);

        });

    });
</script>

</body>
</html>
