<%--
  Created by IntelliJ IDEA.
  User: zyf
  Date: 2017/6/21
  Time: 上午11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码检查</title>
</head>
<body>
    <form>
        <table border="0" align="center">
            <tr>
                <th>验证码</th>
                <td><input type="text" name="checkcode" id="checkcodeID" maxlength="4"/></td>
                <td><img src="image.jsp"></td>
                <td id="res"></td>
            </tr>
        </table>
    </form>
    <script type="text/javascript">
        function createAJAX() {
            var xmlhttp;
            if (window.XMLHttpRequest) {
                // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            } else {
                // code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            return xmlhttp;
        }
    </script>

    <script type="text/javascript">
        function trim(str) {
           str = str.replace(/^\s*/,"");
           str = str.replace(/\s*$/,"");
           return str;
        }
    </script>

    <script type="text/javascript">
        document.getElementById("checkcodeID").onkeyup = function () {
            var checkcode = this.value;
            checkcode = trim(checkcode);
            if (checkcode.length == 4) {
                var xmlhttp = createAJAX();
                var method = "POST";
                var url = "${pageContext.request.contextPath}/checkRequest?time="+new Date().getTime();
                xmlhttp.open(method,url);
                xmlhttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
                xmlhttp.send("checkcode="+checkcode);

                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        var tip = xmlhttp.responseText;

                        //<img>
                        var img = document.createElement("img");
                        img.src = tip;
                        img.style.width = "14px";
                        img.style.height = "14px";
                        var td = document.getElementById("res");
                        td.innerHTML = "";
                        td.appendChild(img);
                    }
                }
            } else {
                var td = document.getElementById("res");
                td.innerHTML = "";
            }
        }
    </script>
</body>
</html>
