<%--
  Created by IntelliJ IDEA.
  User: HoangNV
  Date: 7/6/2018
  Time: 1:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<h3>Delete Product</h3>
<p style="color: red;">${errorString}</p>
<a href="productList">Product List</a>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
