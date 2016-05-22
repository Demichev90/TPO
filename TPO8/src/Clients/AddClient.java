package Clients;
import java.rmi.registry.*;
import java.util.Scanner;

import Materials.TestClass;
import Servers.IAdd;

public class AddClient {

	public static void main(String... args) throws Exception {
		
		// Making access to our server - establishing pot and ip
		Registry registry = LocateRegistry.getRegistry("localhost", 2098);

		// Creating object of our TestClass
		TestClass bigT = new TestClass();
		
		//Telling that we are looking for a AddService at localhost 2098 (previous registry)
		IAdd service = (IAdd)registry.lookup("AddService");
		
		// Base for calculations
		Long a = null;
		Long b = null;
		boolean isLong = false;
		
		//Reading from console - only numbers, if not repeating the step
		while(!isLong){
			System.out.println("Enter first number : ");
			Scanner scanIn = new Scanner(System.in);
			try{
				a = scanIn.nextLong();
				System.out.println("Enter next number please :");
				b = scanIn.nextLong();
			} catch(Exception exc){
				//if is not a number starting from begin
				System.out.println("This is not a number, repeat please");
				continue;
			}
			//If we are here so our inputs are number and we dont need reassign it, so isLong will be true for not reentering the loop
			isLong = true;
			//closing our input scanner
			scanIn.close();            

		}
		//Setting values to ours test object
		bigT.setA(a);
		bigT.setB(b);
		// service.add(bigT) - remote ask to server with object
		System.out.println("Answer from server " + service.add(bigT));
	}

}