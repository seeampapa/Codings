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
    <h4>Calculator 3</h4>
    <h:messages infoClass="infoClass" errorClass="errorClass"
        layout="table" globalOnly="true"/>
    <h:panelGrid columns="3" rowClasses="oddRow, evenRow"
          styleClass="formGrid">
        <%-- First Number--%>
        <h:outputLabel value="First Number" for="firstNumber"
                styleClass="#{calculatorController.firstNumberStyleClass}"/>
        <h:inputText id="firstNumber" label="First Number"
          value="#{calculatorController.calculator.firstNumber}" required="true"
          binding="#{calculatorController.firstNumberInput}" />
        <h:message for="firstNumber" errorClass="errorClass"/>

        <%-- Second Number--%>
        <h:outputLabel id="snl" value="Second Number" for="secondNumber"
                styleClass="#{calculatorController.secondNumberStyleClass}"/>
        <h:inputText id="secondNumber" label="Second Number"
          value="#{calculatorController.calculator.secondNumber}" required="true"
          binding="#{calculatorController.secondNumberInput}"/>
        <h:message for="secondNumber" errorClass="errorClass"/>
    </h:panelGrid>
    <div>
      <h:commandButton action="#{calculatorController.add}"  value="Add" />
      <h:commandButton action="#{calculatorController.multiply}"  value="Multiply" />
      <h:commandButton action="#{calculatorController.divide}"  value="Divide" />
      <h:commandButton action="#{calculatorController.clear}"  value="Clear"
          immediate="true"/>
    </div>
  </h:form>


  <h:panelGroup binding="#{calculatorController.resultsPanel}" rendered="false">
  <h4>Results</h4>
   <h:panelGrid columns="1" rowClasses="oddRow, evenRow"
    styleClass="resultGrid">
    <h:outputText value="First Number  #{calculatorController.calculator.firstNumber}"/>
    <h:outputText value="Second Number #{calculatorController.calculator.secondNumber}"/>
    <h:outputText value="Result  #{calculatorController.calculator.result}"/>
   </h:panelGrid>
  </h:panelGroup>
</f:view>

</body>
</html>