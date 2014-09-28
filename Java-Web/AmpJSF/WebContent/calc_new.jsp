<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="main.css" />
</head>
<body>
<f:view>
<h:form id="calcForm">
  <h4>Calculator</h4>
    <h:panelGrid columns="3" rowClasses="oddRow, evenRow" styleClass="formGrid">
      <%-- First Number--%>
      <h:outputLabel value="First Number" for="firstNumber" />
      <h:inputText id="firstNumber" label="FName" value="#{calculator.firstNumber}" required="true" />
      <h:message for="firstNumber" showSummary="true"  showDetail="false"/>
      <%-- Second Number--%>
      <h:outputLabel value="Second Number" for="secondNumber" />
      <h:inputText id="secondNumber" label="LName" value="#{calculator.secondNumber}" required="true" 
      			requiredMessage="required" converterMessage="not a valid no" />
      <h:message for="secondNumber" />
   </h:panelGrid>
   <div>
      <h:commandButton action="#{calculator.add}"  value="Add" />
      <h:commandButton action="#{calculator.multiply}"  value="Multiply" />
      <h:commandButton action="#{calculator.clear}"  value="Clear" immediate="true"/>
   </div>
</h:form>

<h:panelGroup rendered="#{calculator.result != 0}">
  <h4>Results</h4>
  <h:panelGrid columns="1" rowClasses="oddRow, evenRow" styleClass="resultGrid">
     <h:outputText value="First Number  #{calculator.firstNumber} " />
     <h:outputText value="Second Number #{calculator.secondNumber} " />
     <h:outputText value="Result        #{calculator.result} " />
  </h:panelGrid>
</h:panelGroup>

</f:view>

</body>
</html>