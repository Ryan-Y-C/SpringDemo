<html xmlns="http://www.w3.org/1999/html">
<!-- 使用freemarker模板引擎渲染页面-->
<head>
    <title>排行榜</title>
</head>
<h1>排行榜</h1>
<body>
<table>
    <tr>
        <th>排名</th>
        <th>名字</th>
        <th>分数</th>
    </tr>
    <#list items as item>
        <tr>
            <td>${item?index}</td>
            <td>${item.user.name}</td>
            <td>${item.score}</td>
        </tr>
    </#list>
</table>
</body>
</html>