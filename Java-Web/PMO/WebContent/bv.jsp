<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="headContent.html" />

<script type="text/javascript">

</script>

</head>
<body>
<f:view>
  <jsp:include page="header.html" />
  <div id="content" class="displayNone">
  	<h:form id="form1">
    	<h:outputText value="Select Manager" />
    	<h:selectOneRadio value="#{bv.selectedMngr}" styleClass="radio">
    		<f:selectItems value="#{bv.managerMap}"/>
    	</h:selectOneRadio>
    	
    	<h:outputText value="Month-Year" />
    	<h:inputText value="#{bv.periodSelected}" onfocus="$(this).monthpicker()" onchange="javascript:calcLastDate(this.value);"></h:inputText>
    	<h:inputHidden id="selectedPeriod" value="#{bv.periodSelected}" />
    	<h:inputHidden id="firstDay" value="#{bv.periodStartDay}" />
    	<h:inputHidden id="lastDate" value="#{bv.periodLastDate}" />
    	
    	<h:commandButton styleClass="internSubmit" value="Request BV" action="#{bvBean.loadTable}"></h:commandButton>
    </h:form>
    
    <h:form id="bvtable">
	<h:dataTable id="dt" value="#{bvBean.effortsList}" var="rows" border="1" >
		<h:column>
    		<f:facet name="header">
    			<h:outputLabel value="CT ID"/>
    		</f:facet> 
    		<h:outputText value="#{rows.ctId}" />
    	</h:column>
    	<h:column>
    		<f:facet name="header">
    			<h:outputLabel value="First Name"/>
    		</f:facet> 
    		<h:outputText value="#{rows.fName}" />
    	</h:column>
    	<h:column>
    		<f:facet name="header">
    			<h:outputLabel value="Bill"/>
    		</f:facet> 
    		<h:outputText value="#{rows.billRate}" />
    	</h:column>
    	<h:column>
    		<f:facet name="header">
    			<h:outputLabel id="days" value="BEN for #{bv.periodSelected}"/>
    		</f:facet>
     		<h:outputLabel styleClass="bv" value="#{rows.bvEffort}" />
     		<h:inputHidden value="#{rows.newVal}" />
    	</h:column>
    	<h:column>
    		<f:facet name="header">
    			<h:outputLabel value="Days"/>
    		</f:facet> 
    		<h:outputLabel value="#{rows.bvDaysEffort}" />
    		<h:inputHidden value="#{rows.bvDaysEffort}" />
    	</h:column>
    	<h:column>
    		<f:facet name="header">
    			<h:outputLabel value="Amount"/>
    		</f:facet> 
    		<h:outputLabel value="#{rows.bvBilledAmt}" />
    		<h:inputHidden value="#{rows.bvBilledAmt}" />
    	</h:column>
    	<h:column>
    		<f:facet name="header">
    			<h:outputLabel value="Adjus"/>
    		</f:facet> 
    		<h:inputText style="width:17px" maxlength="3" value="#{rows.bvAdjust}" />
    	</h:column>
    	<h:column>
    		<f:facet name="header">
    			<h:outputLabel value="AdjEffort"/>
    		</f:facet> 
    		<h:outputLabel value="#{rows.bvAdjustedDaysEff}" />
    		<h:inputHidden value="#{rows.bvAdjustedDaysEff}" />
    	</h:column>
    	<h:column>
    		<f:facet name="header">
    			<h:outputLabel value="AdjAmount"/>
    		</f:facet> 
    		<h:outputLabel value="#{rows.bvAdjustedBillAmt}" />
    		<h:inputHidden value="#{rows.bvAdjustedBillAmt}" />
    	</h:column>
    </h:dataTable>
    
    <h:commandButton actionListener="#{bvBean.updateTable}" value="Submit Changes" >
		<f:attribute name="rows" value="#{bvBean.effortsList}"/>
	</h:commandButton>
    </h:form>
  </div>
</f:view>
</body>
</html>