<%@page language="java" pageEncoding="utf-8" %>

<html>
<head>
    <title>时间</title>
</head>
<body>
<h2>当前时间:<span id="time" style="color:red;"></span></h2>


<input id="buttonID" type="button" value="获取当前时间"/>



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
    //定位按钮，添加事件
    document.getElementById("buttonID").onclick = function () {
        //发送请求
        var xmlhttp = createAJAX();
        xmlhttp.open("GET","${pageContext.request.contextPath}/AjaxTimeServlet?time="+new Date().getTime());
        xmlhttp.send();

        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("time").innerHTML = xmlhttp.responseText;
            }
        }

    }
</script>



</body>
</html>
