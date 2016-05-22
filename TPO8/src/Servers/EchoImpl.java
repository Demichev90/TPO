package Servers;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

import Materials.TestClass;
 
public class EchoImpl implements IEcho {
 

	private static final long serialVersionUID = -7981618634629716005L;
	public static final String BINDING_NAME = "EchoService";
 
	public Object sayHello(TestClass T) {
		System.out.println("Client said: " + T.getEcho());
		return T.getEcho();
		
	}
	
 
	public static void main(String... args) throws Exception {
		
		System.out.print("Starting registry...");

	    if (System.getSecurityManager() == null) {
	        System.setSecurityManager(new SecurityManager());
	    }

		
		final Registry registry = LocateRegistry.createRegistry(2099);
		System.out.println(" OK");
 
		final IEcho service = new EchoImpl();
		Remote stub = UnicastRemoteObject.exportObject(service, 0);
 
		System.out.print("Binding service...");
		registry.bind(BINDING_NAME, stub);
		System.out.println(" OK");
 
		
	}
}