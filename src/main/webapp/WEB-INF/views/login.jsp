<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div id="login-box">

            <h2>Login with Username and Password</h2>

            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
                <c:if test="${not empty error}">
                    <div class="error" style="color: #ff0000;">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">User: </label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" />
                </div>

                <input type="submit" value="Submit" class="btn btn-default">
                
<!--                 this ensures that when you are logged in and when you click some evil site, the  -->
<!--                 hacker wont be able to do anything in the admin page because their malicious code won't have  -->
<!--                 the csrf code that is being generated here. The server checks if the this code is equal to the  -->
<!--                 code in server.  -->
<%--                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
            </form>

        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>
