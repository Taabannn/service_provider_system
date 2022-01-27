<%--
  Created by IntelliJ IDEA.
  User: Taban
  Date: 1/20/2022
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>">

    <title>Expert Login Page</title>
</head>
<body>

<div class="wrapper fadeInDown">
    <div id="formContent">

        <div class="fadeIn first">
            <br>
            <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                 x="0px" y="0px"
                 width="170px" height="170px" viewBox="0 0 414.594 414.594"
                 style="enable-background:new 0 0 414.594 414.594;"
                 xml:space="preserve">
            <g>
            <path d="M357.594,298.009l-84.891-33.848l-19.881-16.748c-5.25-4.438-13.004-4.11-17.873,0.73l-27.64,27.481l-27.717-27.492
				c-4.874-4.832-12.618-5.146-17.864-0.722l-19.879,16.748l-84.895,33.854C29.622,308.9,29.644,405.708,27.297,414.594h360
				C384.955,405.73,384.941,308.885,357.594,298.009z"/>
            <path d="M314.002,87.668C308.106,38.434,262.505,0,207.297,0s-100.81,38.434-106.705,87.668
				c-4.898,3.137-8.153,8.613-8.153,14.859v39.996c0,9.743,7.899,17.646,17.646,17.646l15.942-0.04
				c9.848,51.453,44.795,80.728,81.27,80.728c36.475,0,57.666-17.339,71.719-49.293c-10.729,8.416-26.324,16.114-48.134,17.704
				c-2.004,2.985-5.411,4.951-9.276,4.951h-10.189c-6.167,0-11.167-4.999-11.167-11.167s5-11.167,11.167-11.167h10.189
				c3.611,0,6.813,1.723,8.854,4.383c35.067-2.815,51.558-24.083,58.134-36.091l15.916-0.006c9.746,0,17.646-7.903,17.646-17.646
				v-39.996C322.154,96.281,318.899,90.805,314.002,87.668z M287.961,89.47c-10.407-32.854-40.473-52.385-80.664-52.385
				c-40.192,0-70.276,19.519-80.694,52.357c-1.612-1.456-3.49-2.616-5.559-3.401C127.705,48.656,163.845,20,207.297,20
				s79.591,28.656,86.253,66.041C291.468,86.832,289.58,88,287.961,89.47z"/>
            </g>

            </svg>
        </div>

        <br>

        <form:form cssClass="p-3 m-3" cssStyle="" modelAttribute="expert" action="expertLogin" method="post">
            <p class="text-danger">${error}</p>

            <input type="text" id="login" class="fadeIn second" name="username" placeholder="username">
            <%--<form:input path="username" name="username" placeholder="username" class="fadeIn second"/>--%>

            <form:errors path="username" cssClass="text-danger"/>

            <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
            <%--<form:input path="password" name="password" placeholder="password" cssClass="fadeIn third"/>--%>

            <form:errors path="password" cssClass="text-danger"/>

            <input type="submit" class="fadeIn fourth" value="Login">
            <%--<form:button name="login" cssClass="btn btn-primary">Login</form:button>--%>

        </form:form>

    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

</body>
</html>
