<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authentication var="loggedUser" property="principal" />
<sec:authorize access="isAuthenticated()">
	<label>${loggedUser.username}</label>
	<a href="${pageContext.request.contextPath}/">Main Page</a>
	<a href="${pageContext.request.contextPath}/logout">Logout</a>
</sec:authorize>
