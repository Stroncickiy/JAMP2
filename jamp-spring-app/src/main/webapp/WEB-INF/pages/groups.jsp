<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
<title>Spring APP</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<jsp:include page="essentials/essentials.jsp" />
</head>
<body>
	<%@ include file="head.jsp"%>
	<h1>All Groups Of Phase: ${targetMentorshipPhase.title}</h1>
	<div id="content">
		<a href="${pageContext.request.contextPath}/groups/add/${targetMentorshipPhase.id}">Add new Group</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>Mentor</th>
					<th>Mentee</th>
					<th>Planned Start</th>
					<th>Planned End</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${groups}" var="group">
					<tr>
						<td>${group.id}</td>
						<td>${group.mentor.assignee.fullName}</td>
						<td>${group.mentee.assignee.fullName}</td>
						<td>${group.plannedStart}</td>
						<td>${group.plannedEnd}</td>
						<td>${group.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>