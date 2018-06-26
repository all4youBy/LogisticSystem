<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 5/16/18
  Time: 00:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <title>sign up</title>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">


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
    </div>
</nav>
<br>
<div class="container" style="margin-top: 10%;width: 30%">
<form action="${pageContext.request.contextPath}/authentication?method=registrate" method="post" name="Form" onsubmit="return validateForm()">
    <input type="hidden" name="command" value="registration">
<div class="form-group row">
    <label for="example-text-input">Новый Логин</label>
    <input class="form-control" type="text" id="example-text-input" name="userName">
</div>
<div class="form-group row">
    <label for="example-search-input">Пароль</label>
    <input class="form-control" type="password"  id="example-search-input" name="pass">
</div>
    <div class="form-group row">
        <label for="example-search-input">Название компании</label>
        <input class="form-control" type="text"  name="name">
    </div>
        <button type="submit" class="btn btn-primary" style="margin-left: 25%">Зарегистироваться</button>
</form>
    </div>

</body>

<script>
    function validateForm() {
        var a = document.forms["Form"]["userName"].value;
        var b = document.forms["Form"]["pass"].value;
        var c = document.forms["Form"]["name"].value;

        if(a==""||b==""||c==""){
            alert("Заполните все поля формы");
            return false;
        }
        return true;
    }
</script>

</html>