<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
<title>Spring APP</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<jsp:include page="essentials/essentials.jsp" />
</head>
<body>
	<%@ include file="head.jsp"%>
	<h3 class="text-center">All users</h3>
	<div id="content">
		<div class="bg-info text-center">
			<a class="btn btn-sm bg-success "
				href="${pageContext.request.contextPath}/users/usageStatistics?from=2016-01-01&to=2017-01-01">Site
				usage statistics</a>
		</div>
		<table class="table table-bordered table-responsive ">
			<thead>
				<tr class="info">
					<th><i class="fa fa-sort-numeric-asc" aria-hidden="true"></i>
						Id</th>
					<th><i class="fa fa-envelope" aria-hidden="true"></i> Email</th>
					<th><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
						First Name</th>
					<th><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
						Last Name</th>
					<th><i class="fa fa-birthday-cake" aria-hidden="true"></i>
						Birth Date</th>
					<th><i class="fa fa-level-up" aria-hidden="true"></i> Level</th>
					<th><i class="fa fa-terminal" aria-hidden="true"></i> Skill</th>
					<th><i class="fa fa-clock-o" aria-hidden="true"></i> Creation
						Time</th>
					<th><i class="fa fa-user" aria-hidden="true"></i> Last Updated
						By</th>
					<th><i class="fa fa-clock-o" aria-hidden="true"></i> Last
						Updated Time</th>
					<th><i class="fa fa-bars" aria-hidden="true"></i> Control</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr class="active">
						<td>${user.id}</td>
						<td>${user.email}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.birthDate}</td>
						<td>${user.level}</td>
						<td>${user.primarySkill}</td>
						<td>${user.creationTime}</td>
						<td>${user.lastUpdatedBy.email}</td>
						<td>${user.lastUpdatedTime}</td>
						<td><sec:authorize
								access="isAuthenticated() AND hasAuthority('ADMIN')">
								<a class="btn btn-sm bg-success"
									href="${pageContext.request.contextPath}/users/edit/${user.id}"><i
									class="fa fa-pencil" aria-hidden="true"></i> Edit</a>
								<a class="btn btn-sm bg-danger"
									href="${pageContext.request.contextPath}/users/remove/${user.id}"><i
									class="fa fa-trash" aria-hidden="true"></i> Remove</a>
							</sec:authorize> <sec:authorize
								access="isAuthenticated() AND NOT hasAuthority('ADMIN')">
								<c:if test="${loggedUser.username.equals(user.email)}">
									<a class="btn btn-sm bg-success"
										href="${pageContext.request.contextPath}/users/edit/${user.id}"><i
										class="fa fa-pencil" aria-hidden="true"></i> Edit</a>
									<a class="btn btn-sm bg-danger"
										href="${pageContext.request.contextPath}/users/remove/${user.id}">Remove
										<i class="fa fa-trash" aria-hidden="true"></i>
									</a>
								</c:if>
							</sec:authorize></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>