package amp.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;


public class CalculatorController {

  private amp.jsf.Calculator calculator;
  private UIPanel resultsPanel;  
  private UIInput firstNumberInput;
  private UIInput secondNumberInput;

  public String add() {
    FacesContext facesContext = FacesContext.getCurrentInstance();

    try {
      calculator.add();
      resultsPanel.setRendered(true);
      facesContext.addMessage(null, new FacesMessage(
          FacesMessage.SEVERITY_INFO, "Added successfully", null));

    } catch (Exception ex) {
      resultsPanel.setRendered(false);
      facesContext.addMessage(null, 
          new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
    }
    return null;
  }

  public String multiply() {
    FacesContext facesContext = FacesContext.getCurrentInstance();

    try {
      calculator.multiply();
      resultsPanel.setRendered(true);
      facesContext.addMessage(null, new FacesMessage(
          FacesMessage.SEVERITY_INFO, "Multiplied successfully", null));

    } catch (Exception ex) {
      resultsPanel.setRendered(false);
      facesContext.addMessage(null, 
          new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
    }
    return null;
  }

  public String divide() {
    FacesContext facesContext = FacesContext.getCurrentInstance();

    try {
      calculator.divide();
      resultsPanel.setRendered(true);
      facesContext.addMessage(null, new FacesMessage(
          FacesMessage.SEVERITY_INFO, "Divided successfully", null));

    } catch (Exception ex) {
      resultsPanel.setRendered(false);
      if (ex instanceof ArithmeticException) {
        secondNumberInput.setValue(Integer.valueOf(1));
      }
      facesContext.addMessage(null, 
          new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
    }
    return null;
  }

  public String clear() {
    FacesContext facesContext = FacesContext.getCurrentInstance();

    try {
      calculator.clear();
      resultsPanel.setRendered(false);
      facesContext.addMessage(null, new FacesMessage(
          FacesMessage.SEVERITY_INFO, "Results cleared", null));

    } catch (Exception ex) {
      resultsPanel.setRendered(false);      
      facesContext.addMessage(null, 
          new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
    }
    return null;
  }

  public String getFirstNumberStyleClass() {
    if (firstNumberInput.isValid()) {
      return "labelClass";
    } else {
      return "errorClass";
    }    
  }
  //remove simple props
}