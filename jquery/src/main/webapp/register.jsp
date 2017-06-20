<%@page language="java" pageEncoding="utf-8" %>

<html>
<head>
    <title>注册</title>
</head>
<body>

    <form>
        用户名:<input id="usernameId" type="text" name="username" maxlength="4"/>
        光标移出后，立即检查结果
    </form>
    <br/>
    <span id="resId"></span>

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
                username = decodeURI(username);
                var xmlhttp = createAJAX();
                xmlhttp.open("GET","<%=request.getContextPath()%>/UserServlet?time="+ new Date().getTime()+"&username="+username);
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
