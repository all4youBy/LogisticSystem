<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 5/16/18
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Клиенты</h2>
<div class="table-responsive">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Компания</th>
        </tr>
        </thead>

        <c:forEach items="${customers}" var="customer">
        <tbody>
        <tr>
            <td><p align="center"><c:out value="${customer.id}"/></p></td>
            <td><p align="center"><c:out value="${customer.name}" /></p></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
