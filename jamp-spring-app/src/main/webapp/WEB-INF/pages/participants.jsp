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
	<h1>All Participants Of Phase: <b>${targetMentorshipPhase.title}</b></h1>
	<div id="content">
		<a href="${pageContext.request.contextPath}/participants/add/${targetMentorshipPhase.id}">Add
			new Participant</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>Email</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Birth Date</th>
					<th>Level</th>
					<th>Skill</th>
					<th>Role</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${participants}" var="participant">
					<tr>
						<td>${participant.id}</td>
						<td>${participant.assignee.email}</td>
						<td>${participant.assignee.firstName}</td>
						<td>${participant.assignee.lastName}</td>
						<td>${participant.assignee.birthDate}</td>
						<td>${participant.assignee.level}</td>
						<td>${participant.assignee.primarySkill}</td>
						<td>${participant.role}</td>
						<td>${participant.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>