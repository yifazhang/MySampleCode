<%@page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>

    <form>
        用户名[GET]:<input id="usernameId" type="text" name="username" maxlength="4"/>
        光标移出后，立即检查结果
    </form>
    <hr/>
    <span id="resId"></span>
    <br/>
    <script type="text/javascript">
        function createAJAX() {
            var xmlhttp = null;
            if (window.XMLHttpRequest) {
                xmlhttp = new XMLHttpRequest();
            } else {
                xmlhttp = ActiveXObject("Microsoft.XMLHTTP");
            }
            return xmlhttp;
        }
    </script>
    <script type="text/javascript">

        document.getElementById("usernameId").onblur = function () {
            //获取文本框的值
            var username = this.value;
            if (username.length == 0) {
                document.getElementById("resId").innerHTML = "用户名必填";
            } else {
                //对姓名中文转码 utf-8
                username = encodeURI(username);
                var xmlhttp = createAJAX();
                var url = "<%=request.getContextPath()%>/UserServlet?time="+ new Date().getTime()+"&username="+username;
                xmlhttp.open("GET",url);
                xmlhttp.send();

                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState = 4 && xmlhttp.status == 200) {
                        document.getElementById("resId").innerHTML = xmlhttp.responseText;
                    }
                }

            }
        }


    </script>

</body>
</html>
