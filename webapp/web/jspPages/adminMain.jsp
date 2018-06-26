<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 5/16/18
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Travel modes in directions</title>
    <title></title>

    <%--<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">--%>
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
        <a class="navbar-brand" href="${pageContext.request.contextPath}/route?menu=map"><h2>Logistic System</h2></a>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp?logout=true">
                    <h5>Logout</h5>
                </a>
            </li>
        </ul>
    </div>
</nav>
<br>

<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar " style="margin-top: 0;padding-top:0; ">
            <div class="sidebar-offcanvas">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="${pageContext.request.contextPath}/route?menu=map">
                            <span data-feather="home"></span>
                            Просмотр маршрутов <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/route?menu=orders">
                            <span data-feather="file"></span>
                            Заказы
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/viewtrucks?menu=showtrucks">
                            <span data-feather="shopping-cart"></span>
                            Грузовые машины
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/viewcustomers?menu=showcustomers">
                            <span data-feather="users"></span>
                            Клиенты
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-10 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            </div>

            <c:if test="${param.menu eq 'map'}">
                <jsp:include page="map.jsp"/>
                <jsp:include page="showOrders.jsp"/>
            </c:if>
            <c:if test="${param.menu eq 'orders'}">
                <jsp:include page="showOrders.jsp"/>
            </c:if>
            <c:if test="${param.menu eq 'showtrucks'}">
                <h2>Грузовые машины</h2>
                <jsp:include page="showTrucks.jsp"/>
            </c:if>
            <c:if test="${param.menu eq 'showcustomers'}">
                <jsp:include page="showCustomers.jsp"/>
            </c:if>
            <c:if test="${param.method eq 'show_order'}">
                <jsp:include page="singleOrder.jsp"/>
            </c:if>
        </main>
    </div>
</div>

</body>
</html>







