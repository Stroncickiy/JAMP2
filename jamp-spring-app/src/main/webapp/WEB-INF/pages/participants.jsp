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
           href="${pageContext.request.contextPath}/participants/add/${targetMentorshipPhase.id}"><span
                class="glyphicon glyphicon-plus"></span>Add
            new Participant</a>
        <a class="btn btn-sm bg-success " href="${pageContext.request.contextPath}/participants/mentorsMoreThan1">Mentors
            who mentors more than 1
            mentee</a>
        <a class="btn btn-sm bg-success " href="${pageContext.request.contextPath}/participants/menteesWithoutMentors/${targetMentorshipPhase.location}">Mentees without mentors in ${targetMentorshipPhase.location}</a>
        <a class="btn btn-sm bg-success " href="${pageContext.request.contextPath}/participants/menteesStatistics?page=1">Mentees statistics</a>
    </div>
    <table class="table table-bordered table-condensed ">
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
            <sec:authorize access="isAuthenticated() AND hasAuthority('ADMIN')">
                <th><i class="fa fa-wrench" aria-hidden="true"></i> Actions</th>
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
                           href="${pageContext.request.contextPath}/participants/update/${participant.id}"><i class="fa fa-pencil" aria-hidden="true"></i> Update</a>
                        <a class="btn btn-sm bg-danger "
                           href="${pageContext.request.contextPath}/participants/remove/${participant.id}"><i class="fa fa-trash" aria-hidden="true"></i> Remove</a>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>