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
<h3 class="text-center">Add new Group</h3>
<div id="shell">
    <div id="main" >
        <form:form action="${pageContext.request.contextPath}/groups/add/"
                   commandName="groupToAdd" method="post">
            <form:hidden path="status"></form:hidden>
            <form:hidden path="phase.id"/>
            <div class="input-group input-md">
                <form:label path="mentor" cssClass="input-group-addon">Mentor</form:label>
                <form:select path="mentor" cssClass="form-control" required="required">
                    <form:options items="${mentors}" itemValue="id" itemLabel="assignee.fullName"/>
                </form:select>
            </div>
            <div class="input-group input-md">
                <form:label cssClass="input-group-addon" path="mentee">Mentee</form:label>
                <form:select path="mentee" cssClass="form-control" required="required">
                    <form:options items="${mentees}" itemValue="id" itemLabel="assignee.fullName"/>
                </form:select>
            </div>
            <div class="input-group input-md">
                <form:label cssClass="input-group-addon"
                            path="plannedStart">Planned Start Date [yyyy-MM-dd]</form:label>
                <form:input path="plannedStart" cssClass="form-control" required="required"></form:input>
            </div>
            <div class="input-group input-md">
                <form:label cssClass="input-group-addon" path="plannedEnd">Planned End Date [yyyy-MM-dd]</form:label>
                <form:input path="plannedEnd" cssClass="form-control" required="required"></form:input>
            </div>
            <form:button type="submit" class="btn right ">Save</form:button>
        </form:form>
        <c:if test="${validationErrors != null}">
            <div class="alert alert-danger">
                <c:forEach items="${validationErrors}" var="error">
                    <p>${error}</p>
                </c:forEach>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>