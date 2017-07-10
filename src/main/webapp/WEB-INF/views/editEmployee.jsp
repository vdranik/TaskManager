<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <hr>
    <div class="container">
        <div class="page-header">
            <h1>Edit Employee</h1>

            <p class="lead">Please update the employee information here:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/employeeBase/editEmployee" method="post" commandName="employee" enctype="multipart/form-data">

            <form:hidden path="employeeId" value="${employee.employeeId}" />

            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="employeeName" id="name" class="form-Control" value="${employee.employeeName}"/>
                <form:errors path="employeeName" cssStyle="color:#ff0000;" />
            </div>


            <%--<div class="form-group">--%>
            <%--<label for="department">Department</label>--%>
            <%--<label class="checkbox-inline"><form:radiobutton path="employeeDepartment" id="department" value="console" />Console</label>--%>
            <%--<label class="checkbox-inline"><form:radiobutton path="employeeDepartment" id="department value="game" />Game</label>--%>
            <%--<label class="checkbox-inline"><form:radiobutton path="employeeDepartment" id="department" value="accessory" />Accessory</label>--%>
            <%--</div>--%>

            <%--<div class="form-group">--%>
            <%--<label for="description">Description</label>--%>
            <%--<form:textarea path="productDescription" id="description" class="form-Control" />--%>
            <%--</div>--%>

            <div class="form-group">
                <label for="phone">Phone</label>
                <form:input path="employeePhone" id="phone" class="form-Control" value="${employee.employeePhone}"/>
                <form:errors path="employeePhone" cssStyle="color:#ff0000;" />
            </div>

            <div class="form-group">
                <label for="employeeRole">Role</label>
                <form:input path="employeeRole" id="role" class="form-Control" value="${employee.employeeRole}"/>
                <form:errors path="employeeRole" cssStyle="color:#ff0000;" />
            </div>

            <div class="form-group">
                <label class="control-label" for="employeeImage">Upload Picture</label>
                <form:input id="employeeImage" path="employeeImage" type="file" class="form:input-large" />
            </div>

            <br/><br/>

            <input type="submit" value="submit" class="btn btn-default">
            <a href="<c:url value="/admin/employeeBase" />" class="btn btn-default">Cancel</a>

        </form:form>

    </div>
</div>
<!-- /container -->

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
