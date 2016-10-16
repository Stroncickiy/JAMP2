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
	<h1> Mentors who mentors more than one mentee</h1>
	<div id="content">
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
				<c:forEach items="${mentors}" var="mentor">
					<tr>
						<td>${mentor.id}</td>
						<td>${mentor.assignee.email}</td>
						<td>${mentor.assignee.firstName}</td>
						<td>${mentor.assignee.lastName}</td>
						<td>${mentor.assignee.birthDate}</td>
						<td>${mentor.assignee.level}</td>
						<td>${mentor.assignee.primarySkill}</td>
						<td>${mentor.role}</td>
						<td>${mentor.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>