package com.demichev.client;

import java.io.IOException;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
	
	private static SocketChannel client = null;
	
	public static void main(String[] args) {
			clientStart();

	}
	
	public static void clientStart(){
		
		try{
			InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8090);
			client = SocketChannel.open();
			client.connect(hostAddress);
			client.configureBlocking(false);
			System.out.println("Client... started");
			for(;;){
				System.out.println("Please enter command or data ");
				Scanner sc = new Scanner(System.in);
				String mes = sc.nextLine();
				if(mes.equals("quit")){
					break;
				}
				ByteBuffer buffer = ByteBuffer.wrap(mes.getBytes());
				client.write(buffer);

				buffer.flip();
				String arrc[] = mes.split(" ");
    	        if(arrc[0].equals("add")){
    	        	try {
    					Thread.sleep(2000);
    				} catch (InterruptedException e) {
    					
    					e.printStackTrace();
    				}
    	        	ByteBuffer bufferansw = ByteBuffer.allocate(4);
    				client.read(bufferansw);
    				buffer.flip();
    				String answ = new String(bufferansw.array()).trim();
    				System.out.println("Answer is " + answ);
    	        }
				
	            
	            
			}
			client.close();
		}
		catch (IOException exc){
			System.out.println("There is no server on localhost 8090");
		}
		
	}
	
	
	
	
	
}
