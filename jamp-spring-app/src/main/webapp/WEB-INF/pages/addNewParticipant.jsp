<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
<title>Spring APP</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<jsp:include page="essentials/essentials.jsp" />
</head>
<body>
	<%@ include file="head.jsp"%>
	<h1>Add new Participant</h1>
	<div id="content">
		<form:form action="${pageContext.request.contextPath}/participants/add"
			commandName="participantToAdd" method="post">
			<form:hidden path="phase.id" />
			<form:label path="assignee">Assignee</form:label>
			<form:select path="assignee" >
				<form:options items="${users}"  itemValue="id"   itemLabel="fullName" />
			</form:select>

			<form:label path="role">Role</form:label>
			<form:select path="role" >
				<form:options items="${roles}"  itemValue="title"  />
			</form:select>

			<form:label path="status">Status</form:label>
			<form:select path="status" >
				<form:options items="${statuses}"  itemValue="title"  />
			</form:select>


			<form:button type="submit">Save</form:button>
			<form:errors></form:errors>
		</form:form>
		<c:if test="${validationErrors != null}">
			<div class="alert alert-danger">
				<p>${validationErrors}</p>
			</div>
		</c:if>
	</div>
</body>
</html>