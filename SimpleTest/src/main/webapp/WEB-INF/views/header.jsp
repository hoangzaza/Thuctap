<%--
  Created by IntelliJ IDEA.
  User: HoangNV
  Date: 7/5/2018
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
    <div style="float: left">
        <h1>My Site</h1>
    </div>
    <div style="float: right; padding: 10px; text-align: right;">
        Hello <b>${loginedUser.getUserName()}</b>
        <br>
    </div>
</div>
