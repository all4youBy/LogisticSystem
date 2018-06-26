<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 23.05.2018
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
        <meta charset="utf-8">
        <title>Travel modes in directions</title>
        <title></title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

    </head>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><h2>Logistic System</h2></a>
        <ul class="navbar-nav justify-content-right">

        </ul>
    </div>
</nav>
<br>
    <div class="container">
        <div class="row">
                <div class="col-6">
    <H2>Успешная регистрация!</H2>
        <button class="btn btn-outline-primary" onclick="window.location= '${pageContext.request.contextPath}/index.jsp'">Вернуться на главную</button>
                </div>
        </div>
    </div>
</body>
</html>
