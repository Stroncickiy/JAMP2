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
<h3 class="text-center">All Mentorship Phases</h3>
<div id="content">
    <div class="bg-info text-center"><a class="btn btn-sm bg-success "
                                        href="${pageContext.request.contextPath}/phases/add"><span
            class="glyphicon glyphicon-plus"></span>Add new
        Phase</a></div>
    <table class="table table-bordered table-condensed">
        <thead>
        <tr class="info">
            <th>id</th>
            <th>title</th>
            <th>location</th>
            <th>start date</th>
            <th>end date</th>
            <th>Groups</th>
            <th>Participants</th>
            <th>Lectures</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${phases}" var="phase">
            <tr class="active">
                <td>${phase.id}</td>
                <td>${phase.title}</td>
                <td>${phase.location}</td>
                <td>${phase.startDate}</td>
                <td>${phase.endDate}</td>
                <td><a class="btn btn-sm bg-success"
                       href="${pageContext.request.contextPath}/groups/${phase.id}">${phase.groups.size()}</a></td>
                <td><a class="btn btn-sm bg-success"
                       href="${pageContext.request.contextPath}/participants/${phase.id}">${phase.participants.size()}</a>
                </td>
                <td><a class="btn btn-sm bg-success"
                       href="${pageContext.request.contextPath}/lectures/${phase.id}">${phase.lectures.size()}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>