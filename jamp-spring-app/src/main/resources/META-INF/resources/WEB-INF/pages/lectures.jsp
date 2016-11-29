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
<h3 class="text-center">All Lectures Of <b>${targetMentorshipPhase.title}</b></h3>
<div id="content">
    <div class="bg-info text-center">
        <a class="btn btn-sm bg-success"
           href="${pageContext.request.contextPath}/lectures/add/${targetMentorshipPhase.id}"><span
                class="glyphicon glyphicon-plus"></span> Add
            new Lecture</a>
    </div>
    <table class="table table-bordered table-condensed ">
        <thead>
        <tr class="info">
            <th><i class="fa fa-sort-numeric-asc" aria-hidden="true"></i> Id</th>
            <th><i class="fa fa-code" aria-hidden="true"></i> Domain Area</th>
            <th><i class="fa fa-bars" aria-hidden="true"></i> Topic</th>
            <th><i class="fa fa-user" aria-hidden="true"></i> Lector Email</th>
            <th><i class="fa fa-calendar" aria-hidden="true"></i> Start</th>
            <th><i class="fa fa-calendar" aria-hidden="true"></i> End</th>
            <sec:authorize access="isAuthenticated() AND hasAuthority('ADMIN')">
                <th><i class="fa fa-wrench" aria-hidden="true"></i> Actions</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lectures}" var="lecture">
            <tr class="active">
                <td>${lecture.id}</td>
                <td>${lecture.domainArea}</td>
                <td>${lecture.topic}</td>
                <td>${lecture.lector.assignee.email}</td>
                <td>${lecture.startTime}</td>
                <td>${lecture.endTime}</td>
                <sec:authorize access="isAuthenticated() AND hasAuthority('ADMIN')">
                    <td>
                        <a class="btn btn-sm bg-success"
                           href="${pageContext.request.contextPath}/lectures/update/${lecture.id}"><i class="fa fa-pencil" aria-hidden="true"></i> Update</a>
                        <a class="btn btn-sm bg-danger"
                           href="${pageContext.request.contextPath}/lectures/remove/${lecture.id}"><i class="fa fa-trash" aria-hidden="true"></i> Remove</a>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>