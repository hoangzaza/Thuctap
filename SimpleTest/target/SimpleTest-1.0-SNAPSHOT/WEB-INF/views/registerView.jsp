<%--
  Created by IntelliJ IDEA.
  User: HoangNV
  Date: 7/5/2018
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/test.css" >
    <link rel="stylesheet" href="../../resources/css/bootstrap.css" >
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="container-fluid">
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="menu.jsp"></jsp:include>
    <h3 class="text-primary text-center">Login Page</h3>
    <p style="color: red;">${errorString}</p>
    <div class="row justify-content-center">
        <div class="col-lg-6">

            <form method="post" action="${pageContext.request.contextPath}/register">
                <table class="table" border="0">
                    <tr>
                        <div class="form-group">
                            <td><label class="form-text"><b>User Name</b></label></td>
                            <td><input type="text" class="form-control" placeholder="Username" name="userName" value="${user.getUserName()}"></td>
                        </div>
                    </tr>
                    <tr id="result" style="display: none">
                        <td colspan="2"><div>Username qua ngan</div></td>
                    </tr>
                    <tr>
                        <div class="form-group">
                            <td><label class="form-text"><b>Password </b></label></td>
                            <td><input type="password" class="form-control" placeholder="Password" name="password" value="${user.getPassword()}"></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="form-group">
                            <td><label class="form-text"><b>Male?</b></label></td>
                            <td><input type="checkbox" name="gender" value="Y"></td>
                        </div>
                    </tr>


                    <tr>
                        <td colspan="2">
                            <div class="row justify-content-around">
                                <div class="col-lg-3">
                                    <input id="btn-register" type="submit" class="btn btn-primary" value="Register">
                                </div>
                                <div class="col-lg-3">
                                    <button class="btn btn-danger">
                                        <a href="${pageContext.request.contextPath}/">Cancel</a>
                                    </button>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>

        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
<script src="../../resources/js/test.js"></script>


</body>
</html>
