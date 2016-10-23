<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="loggedUser" property="principal"/>
<sec:authorize access="isAuthenticated()">
    <div class="bg-warning">
        <label>${loggedUser.username}</label>
        <a class="btn btn-sm bg-warning" href="${pageContext.request.contextPath}/">Main Page</a>
        <a class="btn btn-sm bg-danger" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</sec:authorize>
