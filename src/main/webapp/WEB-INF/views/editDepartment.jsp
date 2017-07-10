<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <hr>
    <div class="container">
        <div class="page-header">
            <h1>Edit Department</h1>

            <p class="lead">Please update the department information here:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/departmentBase/editDepartment" method="post" commandName="department">

            <form:hidden path="departmentId" value="${department.departmentId}" />

            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="departmentName" id="name" class="form-Control" value="${department.departmentName}"/>
                <form:errors path="departmentName" cssStyle="color:#ff0000;" />
            </div>


            <%--<div class="form-group">--%>
            <%--<label for="department">Department</label>--%>
            <%--<label class="checkbox-inline"><form:radiobutton path="employeeDepartment" id="department" value="console" />Console</label>--%>
            <%--<label class="checkbox-inline"><form:radiobutton path="employeeDepartment" id="department value="game" />Game</label>--%>
            <%--<label class="checkbox-inline"><form:radiobutton path="employeeDepartment" id="department" value="accessory" />Accessory</label>--%>
            <%--</div>--%>

            <div class="form-group">
                <label for="description">Description</label>
                <form:textarea path="departmentDescription" id="description" class="form-Control" />
                <form:errors path="departmentDescription" cssStyle="color:#ff0000;" />
            </div>

            <br/><br/>

            <input type="submit" value="submit" class="btn btn-default">
            <a href="<c:url value="/admin/departmentBase" />" class="btn btn-default">Cancel</a>
        </form:form>
    </div>
</div>
<!-- /container -->

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
