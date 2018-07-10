<%--
  Created by IntelliJ IDEA.
  User: HoangNV
  Date: 7/5/2018
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>

</script>
<div style="padding: 5px">
    <ul class="nav nav-tabs">
    <li class="nav-item"><a href="${pageContext.request.contextPath}/" class="nav-link">Home</a></li>
    <li class="nav-item"><a href="${pageContext.request.contextPath}/productList" class="nav-link">Product List</a></li>
    <li class="nav-item"><a href="${pageContext.request.contextPath}/userInfo" class="nav-link">My Account Info</a></li>
    <c:choose>
        <c:when test="${loginedUser != null}">
            <li class="nav-item"><a href="${pageContext.request.contextPath}/logout" class="nav-link">Logout</a></li>
        </c:when>
        <c:otherwise>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/login" class="nav-link">Login</a></li>
        </c:otherwise>
    </c:choose>

    </ul>
</div>
