<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
    <title>Spring APP</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="essentials/essentials.jsp"/>
</head>
<body>
<%@ include file="head.jsp" %>
<h3 class="text-center">Update Participant</h3>
<div id="shell">
    <div id="main">
        <form:form action="${pageContext.request.contextPath}/participants/update"
                   commandName="participantToUpdate" method="post">
            <form:hidden path="phase.id"/>
            <form:hidden path="id"/>
            <div class="input-group input-md">
                <form:label cssClass="input-group-addon"  path="assignee">Assignee</form:label>
                <form:select cssClass="form-control" required="required"  path="assignee">
                    <form:options items="${users}" itemValue="id" itemLabel="fullName"/>
                </form:select>
            </div>
            <div class="input-group input-md">
                <form:label cssClass="input-group-addon"  path="role">Role</form:label>
                <form:select cssClass="form-control" required="required"  path="role">
                    <form:options items="${roles}" itemValue="title"/>
                </form:select>
            </div>
            <div class="input-group input-md">
                <form:label cssClass="input-group-addon"  path="status">Status</form:label>
                <form:select cssClass="form-control" required="required"  path="status">
                    <form:options items="${statuses}" itemValue="title"/>
                </form:select>
            </div>
            <form:button type="submit" class="btn right">Save</form:button>
        </form:form>
        <c:if test="${validationErrors != null}">
            <div class="alert alert-danger">
                <p>${validationErrors}</p>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>