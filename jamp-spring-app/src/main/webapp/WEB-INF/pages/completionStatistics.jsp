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
<h3 class="text-center"> Completions statistics for period from ${param.from} to ${param.to} </h3>
<div id="content">
    <table class="table table-bordered table-condensed">
        <thead>
        <tr class="info">
            <th><i class="fa fa-group" aria-hidden="true"></i> All mentees</th>
            <th><i class="fa fa-check" aria-hidden="true"></i> Successfully graduated</th>
            <th><i class="fa fa-percent " aria-hidden="true"></i> Percent of successful</th>
        </tr>
        </thead>
        <tbody>
        <tr class="active">
            <td>${completionStatistics.countOfAllMentees}</td>
            <td>${completionStatistics.countOfSuccessfulGraduations}</td>
            <td>${completionStatistics.successPercentage}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>