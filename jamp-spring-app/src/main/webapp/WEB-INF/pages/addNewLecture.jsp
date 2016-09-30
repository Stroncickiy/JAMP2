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
	<h1>Add new Lecture</h1>
	<div id="content">
		<form:form action="${pageContext.request.contextPath}/lectures/add"
			commandName="lectureToAdd" method="post">

			<form:label path="lector">Lector</form:label>
			<form:select path="lector" >
				<form:options items="${lectors}"  itemValue="id"   itemLabel="assignee.fullName" />
			</form:select>
			<form:label path="domainArea">Domain Area</form:label>
			<form:input path="domainArea"></form:input>
			<form:hidden path="phase.id" />
			<form:label path="topic">Topic</form:label>
			<form:input path="topic"></form:input>

			<form:label path="startTime">Start Time [yyyy-MM-dd HH:mm]</form:label>
			<form:input path="startTime"></form:input>

			<form:label path="endTime">End Time [yyyy-MM-dd HH:mm]</form:label>
			<form:input path="endTime" ></form:input>

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