<%--
  Created by IntelliJ IDEA.
  User: songt
  Date: 10/10/2024
  Time: 7:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addProduct" method="post">
    <input type="hidden" name="id" value="${product.productCode}">
    <label>Name:</label>
    <input type="text" name="name" value="${product.productName}">
    <label>Line:</label>
    <input type="text" name="line" value="${product.productLine}">
    <button type="submit">Update</button>
</form>

</body>
</html>
