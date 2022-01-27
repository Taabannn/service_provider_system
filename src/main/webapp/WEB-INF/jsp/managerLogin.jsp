<%--
  Created by IntelliJ IDEA.
  User: Taban
  Date: 1/20/2022
  Time: 10:46 AM
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

    <title>Manager Login Page</title>
</head>
<body>

<div class="wrapper fadeInDown">
    <div id="formContent">

        <div class="fadeIn first">
            <br>
            <svg version="1.1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 297 297"
                 xmlns:xlink="http://www.w3.org/1999/xlink" enable-background="new 0 0 297 297"
                 width="170px" height="170px">
                <g>
                    <path d="m148.85,58.072c15.466,0 28.047-12.582 28.047-28.047 0-15.465-12.582-28.047-28.047-28.047-15.465,0-28.047,12.582-28.047,28.047 0,15.466 12.582,28.047 28.047,28.047z"/>
                    <path d="m104.631,144.108h88.428c5.759,0 10.427-4.669 10.427-10.428v-38.556c0-10.673-6.859-20.137-17.001-23.46l-.047-.016-14.835-2.456c-1.263-0.388-2.612,0.28-3.066,1.526l-16.832,46.185c-0.971,2.664-4.739,2.664-5.71,0l-16.833-46.185c-0.367-1.006-1.316-1.636-2.333-1.636-0.241,0-15.567,2.564-15.567,2.564-10.226,3.407-17.058,12.887-17.058,23.606v38.429c1.42109e-14,5.759 4.668,10.427 10.427,10.427z"/>
                    <path d="m276.738,215.266c-0.055-0.018-0.11-0.036-0.165-0.053l-8.028-2.462c-2.415-0.74-5.037-0.155-6.907,1.535l-17.307,15.647-17.307-15.647c-1.87-1.691-4.493-2.277-6.907-1.535l-8.029,2.462c-0.055,0.017-0.11,0.035-0.165,0.053-12.12,4.04-20.262,15.338-20.262,28.113v44.477c0,3.958 3.208,7.166 7.166,7.166h91.006c3.958,0 7.166-3.208 7.166-7.166v-44.477c0.001-12.775-8.142-24.073-20.261-28.113z"/>
                    <path d="m244.331,207.808c16.496,0 29.917-13.421 29.917-29.917s-13.421-29.917-29.917-29.917c-16.497,0-29.918,13.421-29.918,29.917s13.421,29.917 29.918,29.917z"/>
                    <path d="m85.076,215.266c-0.055-0.018-0.11-0.036-0.165-0.053l-8.028-2.462c-2.414-0.742-5.037-0.156-6.907,1.535l-17.308,15.647-17.307-15.647c-1.87-1.691-4.493-2.277-6.907-1.535 0,0-8.137,2.497-8.193,2.515-12.118,4.04-20.261,15.338-20.261,28.113v44.477c0,3.958 3.208,7.166 7.166,7.166h91.006c3.958,0 7.166-3.208 7.166-7.166v-44.477c0-12.775-8.142-24.073-20.262-28.113z"/>
                    <path d="M22.751,177.89c0,16.496,13.421,29.917,29.917,29.917c16.497,0,29.918-13.421,29.918-29.917s-13.421-29.917-29.918-29.917   C36.172,147.973,22.751,161.394,22.751,177.89z"/>
                    <path d="m252.506,98.996c-2.451-0.734-5.212-0.235-7.275,1.579-3.185,2.799-3.498,7.651-0.699,10.836l10.496,11.944c1.458,1.658 3.559,2.609 5.767,2.609 2.208,0 4.31-0.951 5.767-2.609l10.496-11.944c2.799-3.185 2.486-8.037-0.699-10.836-2.377-2.089-5.681-2.441-8.368-1.165-1.562-16.77-8.096-32.506-18.923-44.826-2.799-3.185-7.65-3.499-10.836-0.699-3.185,2.799-3.498,7.651-0.699,10.836 8.282,9.423 13.425,21.404 14.973,34.275z"/>
                    <path d="m31.128,123.355c1.458,1.658 3.559,2.609 5.767,2.609 2.208,0 4.31-0.951 5.767-2.609l10.496-11.944c2.799-3.185 2.486-8.037-0.699-10.836-2.064-1.813-4.824-2.312-7.275-1.578 1.548-12.871 6.691-24.852 14.972-34.275 2.799-3.185 2.486-8.037-0.699-10.836-3.186-2.799-8.037-2.485-10.836,0.699-10.826,12.32-17.36,28.056-18.923,44.825-2.688-1.277-5.991-0.924-8.368,1.165-3.185,2.799-3.498,7.651-0.699,10.836l10.497,11.944z"/>
                    <path d="m154.621,69.633c-0.647-0.705-1.594-1.06-2.551-1.06h-7.14c-0.957,0-1.904,0.355-2.551,1.06-1.002,1.092-1.147,2.669-0.436,3.902l3.817,5.754-1.787,15.073 3.518,9.36c0.343,0.941 1.674,0.941 2.017,0l3.518-9.36-1.787-15.073 3.817-5.754c0.712-1.233 0.567-2.81-0.435-3.902z"/>
                </g>
            </svg>
        </div>

        <br>

        <form:form cssClass="p-3 m-3" cssStyle="" modelAttribute="manager" action="managerLogin" method="post">
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

        <%--<form action="\login" method="post" modelAttribute="manager">
            <input type="text" id="login" class="fadeIn second" name="username" placeholder="username">
            <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>--%>

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
