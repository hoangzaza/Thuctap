<%--
  Created by IntelliJ IDEA.
  User: HoangNV
  Date: 7/5/2018
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--jstl--%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/test.css" >
    <link rel="stylesheet" href="../../resources/css/bootstrap.css" >
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<p style="color: red;">${errorString}</p>
<div class="card">
    <div class="card-header bg-success">
        <div class="row justify-content-between">
        <h3>Product list</h3>
        <form action="">
            <input type="text" name="contentSearch">
            <input type="submit" value="Search">
        </form>
        </div>
    </div>
    <div class="card-body">
<div class="table-responsive">
<table class="table table-hover">
    <thead>
    <tr class="bg-white">
        <th>Code</th>
        <th>Name</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="item" >
        <tr>
            <td>${item.getCode()}</td>
            <td>${item.getName()}</td>
            <td>${item.getPrice()}</td>
            <td><a href="editProduct?code=${item.getCode()}">Edit</a></td>
            <td><a href="deleteProduct?code=${item.getCode()}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
    </div>
</div>
<a href="createProduct">Create Product</a>
<jsp:include page="footer.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
</body>
</html>
