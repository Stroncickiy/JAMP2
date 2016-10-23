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
<h3 class="text-center">All Participants Of Phase: <b>${targetMentorshipPhase.title}</b></h3>
<div id="content">
    <div class="bg-info text-center">
        <a class="btn btn-sm bg-success "
           href="${pageContext.request.contextPath}/participants/add/${targetMentorshipPhase.id}">Add
            new Participant</a>
        <a class="btn btn-sm bg-success " href="${pageContext.request.contextPath}/participants/mentorsMoreThan1">Mentors
            who mentors more than 1
            mentee</a>
    </div>
    <table class="table table-bordered table-condensed ">
        <thead>
        <tr class="info">
            <th>id</th>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birth Date</th>
            <th>Level</th>
            <th>Skill</th>
            <th>Role</th>
            <th>Status</th>
            <sec:authorize access="isAuthenticated() AND hasAuthority('ADMIN')">
                <th>Actions</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${participants}" var="participant">
            <tr class="active">
                <td>${participant.id}</td>
                <td>${participant.assignee.email}</td>
                <td>${participant.assignee.firstName}</td>
                <td>${participant.assignee.lastName}</td>
                <td>${participant.assignee.birthDate}</td>
                <td>${participant.assignee.level}</td>
                <td>${participant.assignee.primarySkill}</td>
                <td>${participant.role}</td>
                <td>${participant.status}</td>
                <sec:authorize access="isAuthenticated() AND hasAuthority('ADMIN')">
                    <td>
                        <a class="btn btn-sm bg-success "
                           href="${pageContext.request.contextPath}/participants/update/${participant.id}">Update</a>
                        <a class="btn btn-sm bg-danger "
                           href="${pageContext.request.contextPath}/participants/remove/${participant.id}">Remove</a>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>