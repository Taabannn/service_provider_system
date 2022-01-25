<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Taban
  Date: 1/24/2022
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Expert Dashboard</title>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>${message}</p>
</div>

<c:set var="expert" value="${expert}"/>
<c:set var="services" value="${services}"/>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <%--<a class="navbar-brand" href="#">Navbar</a>--%>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link active" href="#">
                    <i class="fa fa-info"> Profile</i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="expertPassEdition">Edit Password</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="addProfilePicture">Add Profile Picture</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Add Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">See Related Orders</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Add Offer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Assigned Orders</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Confirm Payment</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container text-center" style="margin-top:30px">
    <table class="table table-sm">

        <tr class="table-primary">
            <th scope="row">first name</th>
            <td>${expert.firstName}</td>
        </tr>
        <tr class="table-secondary">
            <th scope="row">last name</th>
            <td>${expert.lastName}</td>
        </tr>
        <tr class="table-primary">
            <th scope="row">user name</th>
            <td>${expert.username}</td>
        </tr>
        <tr class="table-secondary">
            <th scope="row">email</th>
            <td>${expert.email}</td>
        </tr>
        <tr class="table-primary">
            <th scope="row">first access</th>
            <td>${expert.firstAccess}</td>
        </tr>
        <tr class="table-secondary">
            <th scope="row">last update</th>
            <td>${expert.lastUpdate}</td>
        </tr>
        <tr class="table-primary">
            <th scope="row">balance</th>
            <td>${expert.walletDto.wallet}</td>
        </tr>
        <tr class="table-secondary">
            <th scope="row">user status</th>
            <td>${expert.userStatus.status}</td>
        </tr>
    </table>

    <br>

    <c:if test="${services.size() != 0}">
        <table>
            <c:forEach items="${services}" var="service">
                <tr class="table-default">
                    <th scope="row">${services.indexOf(services) + 1}</th>
                    <td>${service.mainService}</td>
                    <td>${service.subServiceDescription}</td>
                    <td>${service.basePrice}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>