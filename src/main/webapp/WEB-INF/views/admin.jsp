<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <hr>
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the administrator page</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcome: ${pageContext.request.userPrincipal.name} |
                <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
            </h2>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/employeeBase" />">Employees base</a>
        </h3>

        <p>Here you can view, check and modify the employee base</p>

        <h3>
            <a href="<c:url value="/admin/departmentBase" />">Department base</a>
        </h3>

        <p>Here you can view, check and modify the department base</p>

    </div>
</div>
<!-- /container -->

<%@ include file="/WEB-INF/views/template/footer.jsp" %>

