<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 5/18/18
  Time: 00:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Заказ №${order.id}</h2>

<div class="container">
    <div class="row">
        <div class="col-4">
            <p align="left">Id</p>
        </div>

        <div class="col-4">
            <p align="left">${order.id}</p>
        </div>

    </div>

    <div class="row">
        <div class="col-4">
            <p align="left">Компания</p>
        </div>

        <div class="col-4">
            <p align="left">${order.customerByCustomerId1.name}</p>
        </div>
    </div>

    <div class="row">
        <div class="col-4">
            <p align="left">Количество груза</p>
        </div>

        <div class="col-4">
            <p align="left">${order.cargoQuantity}</p>
        </div>
    </div>


    <div class="row">
        <div class="col-4">
            <p align="left">Адрес заказа</p>
        </div>

        <div class="col-4">
            <p align="left">${order.address}</p>
        </div>
    </div>

<c:if test="${order.orderState eq 'Новый'}">
    <div class="row">
        <div class="col-4">
            <p align="left">Грузовая машина</p>
        </div>

        <div class="col-4">
            <p align="left">
            <select id = "truckForOrder" style="width: 9em">
                <c:forEach var="truck" items="${trucks}">
                    <option value="${truck.id}" ${order.truckByTruckId1.id == truck.id ? 'selected="selected"' : ''}>${truck.name}</option>

                 </c:forEach>
            </select>
            </p>
        </div>

        <div class="col-4">
            <form method="post" action="${pageContext.request.contextPath}/singleorder">
                <input type="hidden" name="method" value="set_truck">
                <input type="hidden" name="order_id" value="${order.id}">
                <input type="hidden" name="truck_id" id="truck_id">
            <input type="submit" class="btn-primary" style="width: 9em" value="Назначить"/>
            </form>
        </div>
    </div>
    <div class="row" style="margin-top: 10%">
        <h2>Свободные грузовые машины</h2>
        <jsp:include page="showTrucks.jsp"/>
    </div>
</c:if>
    <c:if test="${order.orderState eq 'Подтвержден'}">

    <div class="row">
        <div class="col-4">
            <p align="left">Грузовая машина</p>
        </div>

        <div class="col-4">
            <p align="left">${order.truckByTruckId1.name}</p>
        </div>
    </div>
        <div class="row">
            <div class="col-4">
                <form method="post" action="${pageContext.request.contextPath}/singleorder">
                    <input type="hidden" name="method" value="complete_order">
                    <input type="hidden" name="order_id" value="${order.id}">
                    <input type="submit" class="btn-primary" style="width: 9em" value="Завершить заказ">
                </form>
            </div>
        </div>
    </c:if>
</div>


<script>
    var e = document.getElementById("truckForOrder");
    var val = e.options[e.selectedIndex].value;
    document.getElementById("truck_id").value = val;
    function handler(){ var val = e.options[e.selectedIndex].value;
        document.getElementById("truck_id").value = val;}
    e.addEventListener("change",handler);
</script>


    <c:if test="${not empty check_set_truck and check_set_truck eq true}">
        <script>
            alert("Машина указана.");
        </script>
    </c:if>

    <c:if test="${not empty check_set_truck and check_set_truck eq false}">
        <script>
            alert("Недостаточно места в машине.");
        </script>
    </c:if>

    <c:if test="${not empty check_order_complete and check_order_complete eq true}">
        <script>
            alert("Заказ завершен.");
        </script>
    </c:if>

