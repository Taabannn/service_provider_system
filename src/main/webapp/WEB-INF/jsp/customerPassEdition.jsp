<%--
  Created by IntelliJ IDEA.
  User: Taban
  Date: 1/24/2022
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>">

    <title>Password Edition</title>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Password Edition Page</p>
</div>

<div class="text-center" style="margin-bottom:0">
    <form:form cssClass="p-3 m-3" cssStyle="" action="customerPassEdition" method="post">
        <p class="text-danger">${wrongPassErrors}</p>

        <input type="text" class="fadeIn first" name="password" placeholder="Enter your current pass">

        <input type="text" class="fadeIn first" name="newPassword" placeholder="Enter new password">

        <input type="submit" class="fadeIn fourth" value="confirm">

    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
