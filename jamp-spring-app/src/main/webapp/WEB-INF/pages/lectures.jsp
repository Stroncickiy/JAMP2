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
	<h1>All Lectures Of Phase ${targetMentorshipPhase.title}</h1>
	<div id="content">
		<a
			href="${pageContext.request.contextPath}/lectures/add/${targetMentorshipPhase.id}">Add
			new Lecture</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Domain Area</th>
					<th>Topic</th>
					<th>Lector Email</th>
					<th>Start</th>
					<th>End</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lectures}" var="lecture">
					<tr>
						<td>${lecture.id}</td>
						<td>${lecture.domainArea}</td>
						<td>${lecture.topic}</td>
						<td>${lecture.lector.assignee.email}</td>
						<td>${lecture.startTime}</td>
						<td>${lecture.endTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>