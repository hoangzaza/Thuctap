<%--
  Created by IntelliJ IDEA.
  User: HoangNV
  Date: 7/5/2018
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/test.css" >
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<h3>Hello: ${user.getUserName()}</h3>
<br />
Gender: ${user.isGender()} <br />
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
