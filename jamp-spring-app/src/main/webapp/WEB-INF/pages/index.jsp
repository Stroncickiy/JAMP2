<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
    <title>Spring APP</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="essentials/essentials.jsp"/>
</head>
<body>
<%@ include file="head.jsp" %>
<sec:authorize access="isAuthenticated()">
    <div id="content" class="bg-success" style="height: 100%">
        <a class="btn btn-md bg-success" href="users/all"><i class="fa fa-users" aria-hidden="true"></i> Users</a>|
        <a class="btn btn-md bg-success" href="phases/all"><i class="fa fa-graduation-cap" aria-hidden="true"></i> Phases</a>
    </div>
</sec:authorize>
</body>
</html>