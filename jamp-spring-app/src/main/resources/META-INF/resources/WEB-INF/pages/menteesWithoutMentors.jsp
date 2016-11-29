<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
    <title>Spring APP</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="essentials/essentials.jsp"/>
</head>
<body>
<%@ include file="head.jsp" %>
<h3 class="text-center"> Mentees without mentors in ${targetLocation}</h3>
<div id="content">
    <table class="table table-bordered table-condensed">
        <thead>
        <tr class="info">
            <th><i class="fa fa-sort-numeric-asc" aria-hidden="true"></i> Id</th>
            <th><i class="fa fa-envelope" aria-hidden="true"></i> Email</th>
            <th><i class="fa fa-pencil-square-o" aria-hidden="true"></i> First Name</th>
            <th><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Last Name</th>
            <th><i class="fa fa-birthday-cake" aria-hidden="true"></i> Birth Date</th>
            <th><i class="fa fa-level-up" aria-hidden="true"></i>  Level</th>
            <th><i class="fa fa-terminal" aria-hidden="true"></i> Skill</th>
            <th><i class="fa fa-list-alt" aria-hidden="true"></i> Role</th>
            <th><i class="fa fa-line-chart" aria-hidden="true"></i> Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${mentees}" var="mentee">
            <tr class="active">
                <td>${mentee.id}</td>
                <td>${mentee.assignee.email}</td>
                <td>${mentee.assignee.firstName}</td>
                <td>${mentee.assignee.lastName}</td>
                <td>${mentee.assignee.birthDate}</td>
                <td>${mentee.assignee.level}</td>
                <td>${mentee.assignee.primarySkill}</td>
                <td>${mentee.role}</td>
                <td>${mentee.status}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>