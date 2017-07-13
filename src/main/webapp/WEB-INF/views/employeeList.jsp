<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <hr>
    <div class="container">
        <div class="page-header">
            <h1>All employees</h1>

            <p class="lead">All awesome employees</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Name</th>
                <th>Department</th>
                <th>Phone</th>
                <th>Role</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${employeeList}" var="employee">
                <tr>
                    <td><img src="<c:url value="/resources/images/${employee.employeeId}.png" />" alt="image" style="width:100%"/></td>
                    <td>${employee.employeeName}</td>
                    <td>${employee.department.departmentName}</td>
                    <td>${employee.employeePhone}</td>
                    <td>${employee.employeeRole}</td>
                    <td><a href="<spring:url value="/employeeList/viewEmployee/${employee.employeeId}" />"><span class="glyphicon glyphicon-info-sign"></span></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<!-- /container -->

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
