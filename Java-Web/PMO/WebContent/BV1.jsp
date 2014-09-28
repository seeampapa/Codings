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
function calcLastDate(date){
	var y = date.split('/')[1], m = date.split('/')[0];
	var firstDay = new Date(y, m-1, 1);
	var lastDay = new Date(y, m, 0);
	var weekday=["Sun", "M", "Tu", "W", "Thu", "F", "Sat"];
	document.getElementById("form1:lastDate").value = lastDay.getDate();
	document.getElementById("form1:firstDay").value = firstDay.getDay();
	document.getElementById("form1:lastDay").value = lastDay.getDay();
	return;
}
</script>

</head>
<body>
<f:view>
  <jsp:include page="header.html" />
  
  <div id="content" class="displayNone">
    <h:form id="form1">
    	<h:outputText value="Select Manager" />
    	<h:selectOneRadio value="#{bv.selectedMngr}">
    		<f:selectItems value="#{bv.managerMap}"/>
    	</h:selectOneRadio>
    	
    	<h:outputText value="Month-Year" />
    	<h:inputText value="#{bv.period}" onfocus="$(this).monthpicker()" onchange="javascript:calcLastDate(this.value);"></h:inputText>
    	
    	<h:inputHidden id="lastDate" value="#{bv.lastDate}" />
    	<h:inputHidden id="firstDay" value="#{bv.firstDay}" />
    	<h:inputHidden id="lastDay" value="#{bv.lastDay}" />
    	
    	<h:commandButton styleClass="internSubmit" value="Request BV" action="#{bv.getTable}"></h:commandButton>
    </h:form>   
    <h:form id="bvtable">
	<h:dataTable value="#{bv.matrixRows}" var="rows" border="0">
    	<h:column>
    		<f:facet name="header">
    			<h:outputLabel value="Emp ID"/>
    		</f:facet> 
    		<h:outputText value="#{rows.empId}" />
    	</h:column>
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
	    		<h:outputLabel value="BEN for #{bv.period}"/>
	    	</f:facet>
    		<c:forEach items="#{bv.values}" var="i">
	    		<h:inputText rendered="#{bv.editable}" id="bv${i}" size="1" value="#{i}" />
	    		<h:outputText rendered="#{!bv.editable}" value="#{i}"  />
    		</c:forEach>
    	</h:column>
    	<h:column>
    		<h:commandButton styleClass="internSubmit" rendered="#{!bv.editable}" action="#{bv.toggleEdit}" value="Edit" />
    		<h:commandButton styleClass="internSubmit" rendered="#{!bv.bVavailable&&bv.editable}" action="#{bv.addTable}" value="Add" />
    		<h:commandButton styleClass="internSubmit" rendered="#{bv.bVavailable&&bv.editable}" action="#{bv.addTable}" value="Update" />
    	</h:column>
    </h:dataTable>
    </h:form>
  </div>
</f:view>
</body>
</html>