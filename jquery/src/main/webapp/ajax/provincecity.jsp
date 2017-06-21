<%--
  Created by IntelliJ IDEA.
  User: zyf
  Date: 2017/6/21
  Time: 上午9:25
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>省份城市二级下拉</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
</head>
<body>

<h1>基于XML，POST方式，</h1>
<hr/>

<select id="provinceID" style="width: 130px;">
    <option>选择省份</option>
    <option>湖南</option>
    <option>广东</option>
</select>
&nbsp;&nbsp;&nbsp;&nbsp;
<select id="cityID" style="width: 130px;">
    <option>选择城市</option>
</select>

<script type="text/javascript">
    document.getElementById("provinceID").onchange = function () {

        //清空城市下拉框中的内容，除第一项外
        var cityElement = document.getElementById("cityID");
        cityElement.options.length = 1;

        //获取选中option标签的索引号，从0开始
        var index = this.selectedIndex;
        //获取选中option标签
        var optionElement = this[index];
        //获取选中option标签中的内容
        var province = optionElement.innerHTML;

        if ("选择省份" == province) return;

        //AJAX
        var xmlhttp = createAJAX();
        var method = "POST";
        var url = "${pageContext.request.contextPath}/ProvinceCityServlet?time="+new Date().getTime();
        xmlhttp.open(method,url);
        xmlhttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
        xmlhttp.send("province="+province);

        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
                var xmlDocument = xmlhttp.responseXML;

                var cityElementArray = xmlDocument.getElementsByTagName("city");
                var size = cityElementArray.length;
                for (var i = 0; i < size ; i++) {

                    //innerHTML只能用在html/jsp中，不能用在xml中
                    var city = cityElementArray[i].firstChild.nodeValue;
                    //<option></option>
                    var optionElement = document.createElement("option");
                    //<option>广州</option>
                    optionElement.innerHTML = city;
                    //<select><option>广州</option></select>
                    cityElement.appendChild(optionElement);
                }
            }
        }

    }
</script>

</body>
</html>
