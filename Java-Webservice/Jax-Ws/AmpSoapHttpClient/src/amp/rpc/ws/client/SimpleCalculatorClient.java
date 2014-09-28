package amp.rpc.ws.client;

import java.rmi.RemoteException;

import amp.rpc.ws.SimpleCalculator;
import amp.rpc.ws.SimpleCalculatorProxy;

public class SimpleCalculatorClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleCalculatorProxy proxy = new 
				SimpleCalculatorProxy("http://localhost:8079/AmpSoapHttpServ/services/SimpleCalculator");
		SimpleCalculator srv = proxy.getSimpleCalculator();
		try {
			System.out.println(srv.add(12, 23));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
