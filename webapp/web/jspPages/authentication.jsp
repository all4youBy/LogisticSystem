<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Sign in</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>

<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><h2>Logistic System</h2></a>
    </div>
</nav>
<br>


<div class="container" style="margin-top: 10em;width: 30%">
<h2>Вход в аккаунт</h2>
    <form action="${pageContext.request.contextPath}/authentication?method=auth" METHOD="post" id="autForm" name="Form" onsubmit="return validateForm()">
        <div class="form-group">
            <input type="hidden" name="command" value="authorization">
            <label for="login">Логин</label>
            <input type="text" class="form-control" name="login" id="login"  placeholder="Логин">

        </div>
        <div class="form-group">
            <label for="pass">Пароль</label>
            <input type="password" class="form-control" name="pass" id="pass" placeholder="Пароль">
        </div>

        <button type="submit" class="btn btn-primary" style="margin-left: 30%;width: 10em">Войти</button>
    </form>
</div> <!-- /container -->


<c:if test="${no_such_user eq true}">
    <script>
        alert("Неправильный логин или пароль.");
    </script>
</c:if>
</body>

<script>
    function validateForm() {
        var a = document.forms["Form"]["login"].value;
        var b = document.forms["Form"]["pass"].value;

        if(a==""||b==""){
            alert("Заполните все поля формы");
            return false;
        }
        return true;
    }
</script>
</html>

