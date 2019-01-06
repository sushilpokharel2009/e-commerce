<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>

            <p class="lead">Customer Details</p>
        </div>
       
        <!--  command name can be order, or order.cart (and any other deep level) -->
        <form:form commandName="order.cart"  class="form-horizontal">
                   
        <h3> Basic Info</h3>           
        
        <div class="form-group">
            <label for="name">Name</label>             
            <form:input path="customer.customerName" id="name" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>             
            <form:input path="customer.customerEmail" id="email" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>             
            <form:input path="customer.customerPhone" id="phone" class="form-Control"/>
        </div>
         
        
        <h3>Billing Address</h3>
        
        <div class="form-group">
            <label for="billingStreet">Street Name</label>             
            <form:input path="customer.billingAddress.streetName" id="billingAddress" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="billingApartmentNumber">Apartment Number</label>             
            <form:input path="customer.billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="billingCity">City</label>             
            <form:input path="customer.billingAddress.city" id="billingCity" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="billingState">State</label>             
            <form:input path="customer.billingAddress.state" id="billingState" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="billingCountry">Country</label>             
            <form:input path="customer.billingAddress.country" id="billingCountry" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="billingZipCode">ZipCode</label>             
            <form:input path="customer.billingAddress.zipCode" id="billingZip" class="form-Control"/>
        </div>      
            
        <!--  Each flow execution is identified by flow execution key at runtime. During the flow execution, 
        when the view state is entered, the flow execution pauses and waits for the user to perform some action. 
        When the use submits the form or chooses to cancel, the key is sent along with the form data, inorder
        for the flow to resume where it left off.  -->
        <input type="hidden" name="_flowExecutionKey" /> 
              
        <br><br>
        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected">
        <button class="btn btn-default" name="_eventId_cancel"> Cancel</button>
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
