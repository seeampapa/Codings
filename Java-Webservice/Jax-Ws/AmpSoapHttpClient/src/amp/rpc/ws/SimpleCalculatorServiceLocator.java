/**
 * SimpleCalculatorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package amp.rpc.ws;

public class SimpleCalculatorServiceLocator extends org.apache.axis.client.Service implements amp.rpc.ws.SimpleCalculatorService {

    public SimpleCalculatorServiceLocator() {
    }


    public SimpleCalculatorServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SimpleCalculatorServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SimpleCalculator
    private java.lang.String SimpleCalculator_address = "http://localhost:8080/AmpSoapHttpServ/services/SimpleCalculator";

    public java.lang.String getSimpleCalculatorAddress() {
        return SimpleCalculator_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SimpleCalculatorWSDDServiceName = "SimpleCalculator";

    public java.lang.String getSimpleCalculatorWSDDServiceName() {
        return SimpleCalculatorWSDDServiceName;
    }

    public void setSimpleCalculatorWSDDServiceName(java.lang.String name) {
        SimpleCalculatorWSDDServiceName = name;
    }

    public amp.rpc.ws.SimpleCalculator getSimpleCalculator() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SimpleCalculator_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSimpleCalculator(endpoint);
    }

    public amp.rpc.ws.SimpleCalculator getSimpleCalculator(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            amp.rpc.ws.SimpleCalculatorSoapBindingStub _stub = new amp.rpc.ws.SimpleCalculatorSoapBindingStub(portAddress, this);
            _stub.setPortName(getSimpleCalculatorWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSimpleCalculatorEndpointAddress(java.lang.String address) {
        SimpleCalculator_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (amp.rpc.ws.SimpleCalculator.class.isAssignableFrom(serviceEndpointInterface)) {
                amp.rpc.ws.SimpleCalculatorSoapBindingStub _stub = new amp.rpc.ws.SimpleCalculatorSoapBindingStub(new java.net.URL(SimpleCalculator_address), this);
                _stub.setPortName(getSimpleCalculatorWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SimpleCalculator".equals(inputPortName)) {
            return getSimpleCalculator();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.rpc.amp", "SimpleCalculatorService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.rpc.amp", "SimpleCalculator"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SimpleCalculator".equals(portName)) {
            setSimpleCalculatorEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
