<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 5/18/18
  Time: 00:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="table-responsive">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Название</th>
            <th>Текущая загруженность</th>
            <th>Общая вместимость</th>
            <th>Статус занятости</th>
            <th>Id Склада</th>
        </tr>
        </thead>

        <c:forEach items="${trucks}" var="truck">
        <tbody>
        <tr>
            <td><p align="center"><c:out value="${truck.id}"/></p></td>
            <td><p align="center"><c:out value="${truck.name}" /></p></td>
            <td><p align="center"><c:out value="${truck.currentCapacity}"/></p></td>
            <td><p align="center"><c:out value="${truck.carryingCapacity}"/></p></td>
            <td><p align="center"><c:out value="${truck.onTheWay}"/></p></td>
            <td><p align="center"><c:out value="${truck.stockByStockId.id}"/></p></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>