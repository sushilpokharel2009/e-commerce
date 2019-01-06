<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container" ng-app = "cartApp">
        <div class="page-header">
            <h1>Customer Mangement Page</h1>

            <p class="lead">This is the customer management page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
          
                <th>Name</th>
                <th>Email</th>
                <th>Phine Number</th>
                <th>Username</th>
                <th>Enabled</th>
            </tr>
            </thead>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerEmail}</td>
                    <td>${customer.customerPhone}</td>
                    <td>${customer.userName}</td>
                     <td>${customer.enabled}</td>                                        
                </tr>
            </c:forEach>
        </table>
         
 <script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
