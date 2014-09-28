/**
 * SimpleCalculatorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package amp.rpc.ws;

public interface SimpleCalculatorService extends javax.xml.rpc.Service {
    public java.lang.String getSimpleCalculatorAddress();

    public amp.rpc.ws.SimpleCalculator getSimpleCalculator() throws javax.xml.rpc.ServiceException;

    public amp.rpc.ws.SimpleCalculator getSimpleCalculator(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
