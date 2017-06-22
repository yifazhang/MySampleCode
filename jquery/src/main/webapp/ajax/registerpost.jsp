<%@page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="../js/ajax.js"></script>
</head>
<body>

   用户名[POST]:<input id="usernameId" type="text" name="username" maxlength="4"/>
   <span id="resId">
       <%--<img src="" width="12px" height="12px"/>--%>
   </span>

</form>
    <hr/>

    <script type="text/javascript">
        document.getElementById("usernameId").onblur = function () {
            var  username = this.value;
            var xmlhttp = createAJAX();
            var method = "POST";
            var url = "${pageContext.request.contextPath}/UserServlet?time="+new Date().getTime();
            xmlhttp.open(method,url);
            //设置AJAX请求头为POST,会把请求体的汉字进行UTF-8的编码
            xmlhttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
            xmlhttp.send("username="+username);

            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var tip = xmlhttp.responseText;

                    //创建img标签
                    var imgElement = document.createElement("img");
                    //设置属性
                    imgElement.src = tip;
                    imgElement.style.width = "12px";
                    imgElement.style.height = "12px";
                    //将img标签加入到span标签中
                    var spanElement = document.getElementById("resId");
                    //清空span标签中的内容
                    spanElement.innerHTML = "";
                    //将标签加入到span标签中
                    spanElement.appendChild(imgElement);

                }
            }

        }

    </script>

</body>
</html>
