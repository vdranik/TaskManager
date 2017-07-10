<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <hr>
    <div class="container">
        <div class="page-header">
            <h1>Employee detail</h1>

            <p class="lead">Here is the detail information of the employee</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                   <img src="<c:url value="/resources/images/${employee.employeeId}.png" />" alt="image" style="width:100%"/>
                </div>

                <div class="col-md-4">
                    <h3>${employee.employeeName}</h3>
                    <p><strong>Department</strong>: ${employee.employeeDepartment.departmentName}</p>
                    <p><strong>Phone</strong>: ${employee.employeePhone}</p>
                    <p><strong>Role</strong>: ${employee.employeeRole}</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /container -->

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
