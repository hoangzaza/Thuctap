<%--
  Created by IntelliJ IDEA.
  User: HoangNV
  Date: 7/5/2018
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/test.css" >
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<h3>Create Product</h3>
<p style="color: red;">${errorString}</p>
    <table border="0" action="${pageContext.request.contextPath}/createProduct">
        <tr>
            <td>Code :</td>
            <td><input type="text" name="code" value="${product.getCode()}"></td>
            <td><div style="color: red" id="errCode"></div></td>
        </tr>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="name" value="${product.getName()}"></td>
            <td><div style="color: red" id="errName"></div></td>
        </tr>
        <tr>
            <td>Price :</td>
            <td><input type="text" name="price" value="${product.getPrice()}"></td>
            <td><div style="color: red" id="errPrice"></div></td>
        </tr>
        <tr>
            <td>Category :</td>
            <td>
            <select name="category" id="slcategory">
                <option value="1">Mot</option>
                <option value="2">Hai</option>
                <option value="3">ba</option>

            </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input id = "btn-create" type="button" value="Submit">
                <a href="productList">Cancel</a>
            </td>
        </tr>

    </table>
<div id="txt1"></div>


<jsp:include page="footer.jsp"></jsp:include>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../../resources/js/createProduct.js"></script>
</body>
</html>
