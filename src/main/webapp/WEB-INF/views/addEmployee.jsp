<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <hr>
    <div class="container">
        <div class="page-header">
            <h1>Add Employee</h1>

            <p class="lead">Fill the below  information to add an employee</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/employeeBase/addEmployee" method="post" commandName="employee" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="employeeName" id="name" class="form-Control" />
                <form:errors path="employeeName" cssStyle="color:#ff0000;" />
            </div>

            <div class="form-group">
               <label for="department">Department: </label>
                <c:forEach var="department" items="${departmentList}">
                    <form:radiobutton path="department" id="department" value="${department}" label="${department.departmentName}" />
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="phone">Phone</label>
                <form:input path="employeePhone" id="phone" class="form-Control" />
                <form:errors path="employeePhone" cssStyle="color:#ff0000;" />
            </div>

            <div class="form-group">
                <label for="employeeRole">Role</label>
                <form:input path="employeeRole" id="role" class="form-Control" />
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
