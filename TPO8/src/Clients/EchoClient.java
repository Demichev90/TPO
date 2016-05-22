package Clients;
import java.rmi.registry.*;
import java.util.Scanner;

import Materials.TestClass;
import Servers.IEcho;
 
public class EchoClient {
 
	public static void main(String... args) throws Exception {
		Registry registry = LocateRegistry.getRegistry("localhost", 2099);
		
		TestClass bigT = new TestClass();
		IEcho service = (IEcho) registry.lookup("EchoService");
		
		String echo;
	     while(true){
	    	 System.out.println("Enter something here or " + "stop" + " for closing program: ");
	    	 @SuppressWarnings("resource")
			Scanner scanIn = new Scanner(System.in);
		       echo = scanIn.nextLine();
          
			if(echo.equals("stop")){
				scanIn.close();
				break;
			}
			bigT.setEcho(echo);
			
			
			System.out.println(service.sayHello(bigT));
	    	 
	    	 
	    	 
	     }
	       
		
	}
 
}