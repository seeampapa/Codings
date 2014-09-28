package amp.rpc.ws;

public class SimpleCalculatorProxy implements amp.rpc.ws.SimpleCalculator {
  private String _endpoint = null;
  private amp.rpc.ws.SimpleCalculator simpleCalculator = null;
  
  public SimpleCalculatorProxy() {
    _initSimpleCalculatorProxy();
  }
  
  public SimpleCalculatorProxy(String endpoint) {
    _endpoint = endpoint;
    _initSimpleCalculatorProxy();
  }
  
  private void _initSimpleCalculatorProxy() {
    try {
      simpleCalculator = (new amp.rpc.ws.SimpleCalculatorServiceLocator()).getSimpleCalculator();
      if (simpleCalculator != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)simpleCalculator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)simpleCalculator)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (simpleCalculator != null)
      ((javax.xml.rpc.Stub)simpleCalculator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public amp.rpc.ws.SimpleCalculator getSimpleCalculator() {
    if (simpleCalculator == null)
      _initSimpleCalculatorProxy();
    return simpleCalculator;
  }
  
  public int add(int a, int b) throws java.rmi.RemoteException{
    if (simpleCalculator == null)
      _initSimpleCalculatorProxy();
    return simpleCalculator.add(a, b);
  }
  
  public int sub(int a, int b) throws java.rmi.RemoteException{
    if (simpleCalculator == null)
      _initSimpleCalculatorProxy();
    return simpleCalculator.sub(a, b);
  }
  
  
}