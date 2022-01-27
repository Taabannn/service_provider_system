<%--
  Created by IntelliJ IDEA.
  User: Taban
  Date: 1/24/2022
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Customer Dashboard</title>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>${message}</p>
</div>

<c:set var="customer" value="${customer}"/>
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
                <a class="nav-link" href="customerPassEdition">Edit Password</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Add New Order</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Show all orders</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="depositWallet">Deposit Wallet</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Add New Address</a>
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
            <td>${customer.firstName}</td>
        </tr>
        <tr class="table-secondary">
            <th scope="row">last name</th>
            <td>${customer.lastName}</td>
        </tr>
        <tr class="table-primary">
            <th scope="row">user name</th>
            <td>${customer.username}</td>
        </tr>
        <tr class="table-secondary">
            <th scope="row">email</th>
            <td>${customer.email}</td>
        </tr>
        <tr class="table-primary">
            <th scope="row">first access</th>
            <td>${customer.firstAccess}</td>
        </tr>
        <tr class="table-secondary">
            <th scope="row">last update</th>
            <td>${customer.lastUpdate}</td>
        </tr>
        <tr class="table-primary">
            <th scope="row">balance</th>
            <td>${customer.wallet.wallet}</td>
        </tr>
        <tr class="table-secondary">
            <th scope="row">user status</th>
            <td>${customer.userStatus.status}</td>
        </tr>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>
