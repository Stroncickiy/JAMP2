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
	<%@ include file="head.jsp" %>
	<h1>All users</h1>
	<div id="content">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Email</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Birth Date</th>
					<th>Level</th>
					<th>Skill</th>
					<th>Control</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.email}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.birthDate}</td>
						<td>${user.level}</td>
						<td>${user.primarySkill}</td>
						<td>
							<sec:authorize access="isAuthenticated() AND hasAuthority('ADMIN')"> 
								<a href="${pageContext.request.contextPath}/users/edit/${user.id}">Edit</a>
								<a	href="${pageContext.request.contextPath}/users/remove/${user.id}">Remove</a>
							</sec:authorize> 
							
							<sec:authorize access="isAuthenticated() AND NOT hasAuthority('ADMIN')"> 
							<c:if test="${loggedUser.username.equals(user.email)}">
								<a href="${pageContext.request.contextPath}/users/edit/${user.id}">Edit</a>
								<a	href="${pageContext.request.contextPath}/users/remove/${user.id}">Remove</a>
							</c:if>
							</sec:authorize> 
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>