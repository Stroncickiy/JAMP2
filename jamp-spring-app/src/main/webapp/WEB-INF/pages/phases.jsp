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
	<h1>All Mentorship Phases</h1>
	<div id="content">
		<a href="${pageContext.request.contextPath}/phases/add">Add new
			Phase</a>
		<table class="table table-bordered">
			<thead>
				<tr>
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
					<tr>
						<td>${phase.id}</td>
						<td>${phase.title}</td>
						<td>${phase.location}</td>
						<td>${phase.startDate}</td>
						<td>${phase.endDate}</td>
						<td><a
							href="${pageContext.request.contextPath}/groups/${phase.id}">${phase.groups.size()}</a></td>
						<td><a
							href="${pageContext.request.contextPath}/participants/${phase.id}">${phase.participants.size()}</a></td>
						<td><a
							href="${pageContext.request.contextPath}/lectures/${phase.id}">${phase.lectures.size()}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>