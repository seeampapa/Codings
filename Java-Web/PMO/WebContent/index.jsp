<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="headContent.html" />
</head>
<body>
<f:view>
  <jsp:include page="header.html" />
  
  <div id="content" class="displayNone">
    <div id="loginText">
    <h2>Login</h2>
      <p class="loginFormText">Need a Login account? <a href="#">SignUp</a> <br/> 
			Have you forgotten your password? <a href="#">Reset your password</a> now.</p> 
    </div>
    <h:form id="login_form">
	    <div id="loginForm">
			<h:inputText value="#{login.username}" /> <br/>
			<h:inputSecret value="#{login.password}" /> <br/>
			<h:commandButton styleClass="mainSubmit" action="#{login.doLogin}" value="Log In" />
	    </div>
    </h:form>
  </div>
</f:view>
</body>
</html>