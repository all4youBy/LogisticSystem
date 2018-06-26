<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 5/16/18
  Time: 00:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="ru">

    <title>sign up</title>
    <head>

    </head>

<body>

<div class="container" style="margin-top: 3em;width: 70%;">
    <h2>Оформление заказа</h2>
    <form action="${pageContext.request.contextPath}/order" name="Form" onsubmit="return validateForm()">
        <%--<input type="hidden" name="command" value="registration">--%>
        <div class="form-group row">
            <label for="example-text-input" class="col-2 col-form-label">Количество груза</label>
            <div class="col-10">
                <input class="form-control" type="text" id="example-text-input" name="quantity">
            </div>
        </div>
        <div class="form-group row">
            <label for="example-search-input" class="col-2 col-form-label">Дата доставки</label>
            <div class="col-10">
                <input class="form-control" type="date"  id="example-search-input" name="date">
            </div>
        </div>
        <div class="form-group row">
            <label for="city" class="col-2 col-form-label">Город доставки</label>
            <div class="col-10">
               <input class="form-control" type="text" id="city" name="city">
            </div>
        </div>
            <div class="form-group row">
                <label for="street" class="col-2 col-form-label">Улица</label>
                <div class="col-10">
                    <input class="form-control" type="text" id="street" name="street">
                </div>
            </div>
        <button type="submit" class="btn btn-outline-primary" style="width: 10em ">Отправить заказ</button>
    </form>
</div>
</body>

    <script>
        function validateForm() {
            var a = document.forms["Form"]["quantity"].value;
            var b = document.forms["Form"]["date"].value;
            var c = document.forms["Form"]["city"].value;
            var d = document.forms["Form"]["street"].value;


            if(a==""||b==""||c==""||d==""){
                alert("Заполните все поля формы");
                return false;
            }
            return true;
        }
    </script>
</html>