package Servers;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

import Materials.TestClass;
 
public class AddImpl implements IAdd {

	private static final long serialVersionUID = -279368482872923739L;
	public static final String BINDING_NAME = "AddService";
 
	public Object add(TestClass T) {
		
		//Add implementation getting a and b from our recived class and adding it
		return T.getA() + T.getB();
		
	}
	
 
	public static void main(String... args) throws Exception {
		
		System.out.print("Starting registry...");
		
		
		//For such an operations we need to be secured, so we are using java security manager
		//The security manager is a class that allows applications to implement a security policy. 
		//It allows an application to determine, before performing a possibly unsafe or sensitive operation, 
		//what the operation is and whether it is being attempted in a security context that allows the operation
		//to be performed. The application can allow or disallow the operation. 
	    if (System.getSecurityManager() == null) {
	        System.setSecurityManager(new SecurityManager());
	    }

		//Making our service avalible at port 2098
		final Registry registry = LocateRegistry.createRegistry(2098);
		System.out.println(" OK");
		
		//we are using AddImpl implementation for IAdd Interface
		final IAdd service = new AddImpl();
		//Exporting remote object for be available to communicate with remote machines
		Remote stub = UnicastRemoteObject.exportObject(service, 0);
 
		System.out.print("Binding service...");
		//binding name to our service for be available by name
		registry.bind(BINDING_NAME, stub);
		System.out.println(" OK");
 
		
	}
}