<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="loggedUser" property="principal"/>
<sec:authorize access="isAuthenticated()">
    <div class="bg-warning">
        <label><span class="glyphicon glyphicon-user"></span> ${loggedUser.username}</label>
        <a class="btn btn-sm bg-warning" href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-home"></span> Main Page</a>
        <a class="btn btn-sm bg-danger" href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
    </div>
</sec:authorize>
