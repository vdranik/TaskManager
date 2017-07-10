<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <hr>
    <div class="container">
        <div class="page-header">
            <h1>Department detail</h1>

            <p class="lead">Here is the detail information of the department</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <h3>${department.departmentName}</h3>
                    <p><strong>Description</strong>: ${department.departmentDescription}</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /container -->

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
