<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <hr>
    <div class="container">
        <div class="page-header">
            <h1>Department base</h1>

            <p class="lead">This is the department base</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${departments}" var="department">
                <tr>
                    <td>${department.departmentName}</td>
                    <td><a href="<spring:url value="/departmentList/viewDepartment/${department.departmentId}" />"><span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/departmentBase/deleteDepartment/${department.departmentId}" />"><span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url value="/admin/departmentBase/editDepartment/${department.departmentId}" />"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/departmentBase/addDepartment" />" class="btn btn-primary">Add department</a>
    </div>
</div>
<!-- /container -->

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
