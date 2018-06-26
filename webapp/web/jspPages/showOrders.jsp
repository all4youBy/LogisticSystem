<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 5/17/18
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>


<h2>Заказы</h2>
<div class="btn-toolbar mb-2 mb-md-0">
<div class="dropdown">
    <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle" data-toggle="dropdown">
        <%--<span data-feather="calendar"></span>--%>
        Все заказы
    </button>

    <div class="dropdown-menu">
        <a class="dropdown-item" href="">Новые</a>
        <a class="dropdown-item" href="">Подтвержденные</a>
        <a class="dropdown-item" href="">Завершенные</a>
    </div>
</div>
</div>
<br>
<div class="table-responsive">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Состояние заказа</th>
            <th>Количество груза</th>
            <th>Дата заказа</th>
            <th>Дата доставки</th>
            <th>Адрес</th>
            <c:if test="${accountType eq 'admin'}">
            <th>Грузовик</th>
            <th>Заказчик</th>
             </c:if>
    <c:if test="${param.menu eq 'map'}">
            <th>Показать маршрут</th>
    </c:if>
        </tr>
        </thead>

        <c:forEach items="${orders}" var="order">

        <tbody>
        <tr class="clickable-row" data-href="${pageContext.request.contextPath}/singleorder?order_id=${order.id}&method=show_order">
            <td><p align="center"><c:out value="${order.id}"/></p></td>
            <td><p align="center"><c:out value="${order.orderState}" /></p></td>
            <td><p align="center"><c:out value="${order.cargoQuantity}"/></p></td>
            <td><p align="center"><c:out value="${order.dateOrder}"/></p></td>
            <td><p align="center"><c:out value="${order.dateDelivery}"/></p></td>
            <td><p align="center"><c:out value="${order.address}"/></p></td>
            <c:if test="${accountType eq 'admin'}">
            <td><p align="center"><c:out value="${order.truckByTruckId1.name}"/></p></td>
            <td><p align="center"><c:out value="${order.customerByCustomerId1.name}"/></p></td>
            </c:if>
            <c:if test="${param.menu eq 'map'}">
            <td><p align="center"><button class="btn btn-primary" type="submit" onclick="calcHandler('${order.address}')">Показать</button></p>
            </td>
            </c:if>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<c:if test="${param.menu eq 'orders'}">
<script>
    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {
            window.location = $(this).data("href");
        });
    });
</script>
</c:if>