<%--
  Created by IntelliJ IDEA.
  User: zyf
  Date: 2017/6/21
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省-城市-区域 struts2+json</title>
    <script type="text/javascript" src="../js/ajax.js"></script>
</head>
<body>

    <select id="provinceID"style="width: 111px;">
        <option>选择省份</option>
        <option>湖北</option>
        <option>湖南</option>
        <option>广东</option>
    </select>
    <select id="cityID"style="width: 111px;">
        <option>选择城市</option>
    </select>
    <select id="areaID"style="width: 111px;">
        <option>选择地区</option>
    </select>

    <form enctype="application/x-www-form-urlencoded"

    <script type="text/javascript">
        document.getElementById("provinceID").onchange = function () {
            var cityElement = document.getElementById("cityID");
            cityElement.options.length = 1;

            var areaElement = document.getElementById("areaID");
            areaElement.options.length = 1;

            var province = this[this.selectedIndex].innerHTML;
            if ("选择省份" != province) {
                var xmlhttp = createAJAX();

                var method = "POST";
                var url = "${pageContext.request.contextPath}/findCityByProvinceRequest?time="+new Date().getTime();
                xmlhttp.open(method,url);
                xmlhttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
                xmlhttp.send("bean.province="+province);


                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

                        //返回JAVA格式的JSON文本
                        var jsonJAVA = xmlhttp.responseText;

                        //所代表的是java格式的json文本，是不能直接被js执行的
                        //解决方案：将java格式的json文本，转成js格式的json文本
                        //如何做：用js提供的一个函数搞定
                        var jsonJS = eval("(" + jsonJAVA + ")");

                        var array = jsonJS.cityList;
                        var size = array.length;
                        for (var i = 0; i < size; i++) {
                            var city = array[i];
                            var option = document.createElement("option");
                            option.innerHTML = city;
                            cityElement.appendChild(option);
                        }
                    }
                }

            }
        }
    </script>

    <script type="text/javascript">
        document.getElementById("cityID").onchange = function () {
            var areaElement = document.getElementById("areaID");
            areaElement.options.length = 1;

            var city = this[this.selectedIndex].innerHTML;
            if ("选择城市" != city) {
                var xmlhttp = createAJAX();

                var method = "POST";
                var url = "<%=request.getContextPath()%>/findAreaByCityRequest?time="+ new Date().getTime();
                xmlhttp.open(method,url);
                xmlhttp.setRequestHeader("content-type","application/x-www-form-urlencoded");

            }

        }
    </script>


</body>
</html>










