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


    <script type="text/javascript" src="../../js/jquery-3.1.0.js"></script>
</head>
<body>

<select id="province" style="width: 130px;">
    <option>选择省份</option>
    <option>湖南</option>
    <option>广东</option>
</select>
&nbsp;&nbsp;&nbsp;&nbsp;
<select id="city" style="width: 130px;">
    <option>选择城市</option>
</select>

<script type="text/javascript">
     $("#province").change(function () {
        var province = $("#province option:selected").text();
        $("#city option:gt(0)").remove();
        if ("选择省份" != province) {
            $.ajax({
                type    : "POST",
                url     : "${pageContext.request.contextPath}/jfindCityByProvinceRequest?time="+new Date().getTime(),
                data    : {"province":province},
                success : function (backDate,textStatus,ajax) {
                       //解析json
                       var array = backDate.setCity;
                       var size = array.length;
                       for (var i = 0; i < size; i ++) {
                           var city = array[i];
                           var $option = $("<option>"+city+"</option>");
                           $("#city").append($option);
                       }
                }
            });
        }
     });
</script>

</body>
</html>
