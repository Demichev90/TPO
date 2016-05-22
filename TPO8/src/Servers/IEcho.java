package Servers;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import Materials.TestClass;

public interface IEcho extends Remote, Serializable{
	
	Object sayHello(TestClass T) throws RemoteException;
	
}