<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
    <title>Spring APP</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="essentials/essentials.jsp"/>
</head>
<body>
<%@ include file="head.jsp" %>
<h3 class="text-center">All users</h3>
<div id="content">
    <table class="table table-bordered table-responsive ">
        <thead>
        <tr class="info">
            <th>ID</th>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birth Date</th>
            <th>Level</th>
            <th>Skill</th>
            <th>Creation Time</th>
            <th>Last Updated By</th>
            <th>Last Updated Time</th>
            <th>Control</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr class="active">
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.birthDate}</td>
                <td>${user.level}</td>
                <td>${user.primarySkill}</td>
                <td>${user.creationTime}</td>
                <td>${user.lastUpdatedBy.email}</td>
                <td>${user.lastUpdatedTime}</td>
                <td>
                    <sec:authorize access="isAuthenticated() AND hasAuthority('ADMIN')">
                        <a class="btn btn-sm bg-success" href="${pageContext.request.contextPath}/users/edit/${user.id}">Edit</a>
                        <a class="btn btn-sm bg-danger"
                           href="${pageContext.request.contextPath}/users/remove/${user.id}">Remove</a>
                    </sec:authorize>

                    <sec:authorize access="isAuthenticated() AND NOT hasAuthority('ADMIN')">
                        <c:if test="${loggedUser.username.equals(user.email)}">
                            <a class="btn btn-sm bg-success"
                               href="${pageContext.request.contextPath}/users/edit/${user.id}">Edit</a>
                            <a class="btn btn-sm bg-danger" href="${pageContext.request.contextPath}/users/remove/${user.id}">Remove</a>
                        </c:if>
                    </sec:authorize>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>