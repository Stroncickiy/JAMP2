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
<h3 class="text-center">All Groups Of Phase: ${targetMentorshipPhase.title}</h3>
<div id="content">
    <div class="bg-info text-center">
        <a class="btn btn-sm bg-success"
           href="${pageContext.request.contextPath}/groups/add/${targetMentorshipPhase.id}"><span
                class="glyphicon glyphicon-plus"></span> Add
            new Group</a>
    </div>
    <table class="table table-bordered table-condensed">
        <thead>
        <tr class="info">
            <th><i class="fa fa-sort-numeric-asc" aria-hidden="true"></i> Id</th>
            <th><i class="fa fa-user" aria-hidden="true"></i> Mentor</th>
            <th><i class="fa fa-user" aria-hidden="true"></i> Mentee</th>
            <th><i class="fa fa-calendar" aria-hidden="true"></i> Planned Start</th>
            <th><i class="fa fa-calendar" aria-hidden="true"></i> Planned End</th>
            <th><i class="fa fa-calendar" aria-hidden="true"></i> Actual Start</th>
            <th><i class="fa fa-calendar" aria-hidden="true"></i> Actual End</th>
            <th><i class="fa fa-line-chart" aria-hidden="true"></i> Status</th>
            <sec:authorize access="isAuthenticated() AND hasAuthority('ADMIN')">
                <th><i class="fa fa-wrench" aria-hidden="true"></i> Actions</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${groups}" var="group">
            <tr class="active">
                <td>${group.id}</td>
                <td>${group.mentor.assignee.fullName}</td>
                <td>${group.mentee.assignee.fullName}</td>
                <td>${group.plannedStart}</td>
                <td>${group.plannedEnd}</td>
                <td>${group.actualStart}</td>
                <td>${group.actualEnd}</td>
                <td>${group.status}</td>
                <sec:authorize access="isAuthenticated() AND hasAuthority('ADMIN')">
                    <td>
                        <c:if test="${group.status == 'INITIATION'}">
                            <a class="btn btn-sm bg-warning"
                               href="${pageContext.request.contextPath}/groups/start/${group.id}"><i class="fa fa-play"
                                                                                                     aria-hidden="true"></i>
                                Start</a>
                        </c:if>
                        <c:if test="${group.status == 'IN_PROGRESS'}">
                            <a class="btn btn-sm bg-success"
                               href="${pageContext.request.contextPath}/groups/complete/${group.id}"><i class="fa fa-check"
                                                                                                        aria-hidden="true"></i>
                                Complete</a>
                            <a class="btn btn-sm bg-danger"
                               href="${pageContext.request.contextPath}/groups/cancel/${group.id}"><i class="fa fa-ban"
                                                                                                      aria-hidden="true"></i>
                                Cancel</a>
                        </c:if>
                        <c:if test="${group.status != 'FINISHED'}">
                        <a class="btn btn-sm bg-success"
                           href="${pageContext.request.contextPath}/groups/update/${group.id}"><i class="fa fa-pencil"
                                                                                                  aria-hidden="true"></i>
                            Update</a>
                            <a class="btn btn-sm bg-danger"
                               href="${pageContext.request.contextPath}/groups/remove/${group.id}"><i class="fa fa-trash"
                                                                                                      aria-hidden="true"></i>
                                Remove</a>
                        </c:if>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>