<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 5/13/18
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
  <body>

  <c:if test="${param.logout eq 'true'}">
      <% request.getSession().invalidate(); %>
  </c:if>

  <c:choose>
      <c:when test="${empty accountType}">
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
          <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><h2>Logistic System</h2></a>
      <ul class="navbar-nav justify-content-right">

            <li class="nav-item">
              <h5><a class="nav-link" href="${pageContext.request.contextPath}/jspPages/authentication.jsp">Войти</a></h5>
            </li>
            <li class="nav-item">
              <h5> <a class="nav-link" href="${pageContext.request.contextPath}/jspPages/registration.jsp">Создать аккаунт</a></h5>
            </li>
      </ul>
    </div>
  </nav>
  <br>

  <div class="jumbotron">
    <div class="container">
      <h4 class="display-4">Добро пожаловать в Logistic System!</h4>
      <p>Пожалуйста войдите в свой аккаунт или зарегистрируйтесь в системе.</p>
      <p><a class="btn btn-primary" href="${pageContext.request.contextPath}/jspPages/authentication.jsp" role="button">Войти</a> <a class="btn btn-primary" href="${pageContext.request.contextPath}/jspPages/registration.jsp" role="button">Зарегистрироваться</a></p>
    </div>
  </div>
      </c:when>
      <c:when test="${accountType eq 'admin'}">
          <jsp:include page="/route?menu=map"/>
      </c:when>
      <c:when test="${accountType eq 'customer'}">
          <jsp:include page="jspPages/customer.jsp?method=main"/>
      </c:when>
  </c:choose>
  </body>
</html>