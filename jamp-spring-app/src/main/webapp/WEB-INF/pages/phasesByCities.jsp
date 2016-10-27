<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
    <title>Spring APP</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="essentials/essentials.jsp"/>
</head>
<body>
<%@ include file="head.jsp" %>
<h3 class="text-center">Statistics by cities</h3>
<div id="content">
    <table class="table table-bordered table-condensed">
        <thead>
        <tr class="info">
            <th><i class="fa fa-tag" aria-hidden="true"></i> City</th>
            <th><i class="fa fa-number" aria-hidden="true"></i> Count of Phases</th>
            <th><i class="fa fa-number" aria-hidden="true"></i> Count of Participants</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${statistics}" var="statistic">
            <tr class="active">
                <td>${statistic.cityName}</td>
                <td>${statistic.countOfPhases}</td>
                <td>${statistic.countOfParticipants}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>