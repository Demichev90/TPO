package Servers;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import Materials.TestClass;

public interface IAdd extends Remote, Serializable{
	
	Object add(TestClass T) throws RemoteException;
	
}