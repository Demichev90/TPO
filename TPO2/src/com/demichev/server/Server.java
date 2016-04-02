package com.demichev.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;


public class Server {
	private static Selector selector;
	private static final InetSocketAddress listenAddress = new InetSocketAddress("localhost", 8090);
	
	public static void main(String[] args) {
		startServer();

	}
	 private static void startServer(){
		 try {
			selector = Selector.open();
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
	        serverChannel.configureBlocking(false);
	        
	        serverChannel.socket().bind(listenAddress);
	        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
	        System.out.println("Server started...");
	        while (true) {
	        selector.select();
	        
	        Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey key = (SelectionKey) keys.next();

                // this is necessary to prevent the same key from coming up 
                // again the next time around.
                keys.remove();

                if (!key.isValid()) {
                    continue;
                }

                if (key.isAcceptable()) {
                	SocketChannel client = serverChannel.accept();
                    client.configureBlocking(false);
                    SelectionKey clientkey = client.register(selector, SelectionKey.OP_READ);
                    SocketAddress remoteAddr = client.getRemoteAddress();
                    System.out.println("Client connected from: " + remoteAddr);
                	//accept(key);
                }
                else if (key.isReadable()) {
                	SocketChannel channel = (SocketChannel) key.channel();
        	        ByteBuffer buffer = ByteBuffer.allocate(1024);
        	        int numRead = -1;
        	        numRead = channel.read(buffer);
        	        
        	        
        	        if (numRead == -1) {
        	            Socket socket = channel.socket();
        	            SocketAddress remoteAddr = socket.getRemoteSocketAddress();
        	            System.out.println("Connection closed by client: " + remoteAddr);
        	            channel.close();
        	            key.cancel();
        	            return;
        	        }
        	        SocketAddress remoteAddr = channel.getRemoteAddress();
        	        String read = new String(buffer.array()).trim();
        	        
        	        
        	        String arrc[] = read.split(" ");
        	        if(arrc[0].equals("add")){
        	        	
        	        	try{
        	        	int a = Integer.parseInt(arrc[1]);
        	        	int b = Integer.parseInt(arrc[2]);
        	        	a = a + b;
        	        	
        	        	String sum = "" + a;
        	        	System.out.println(sum);
        	        	

        	        	ByteBuffer bufferansw = ByteBuffer.wrap(sum.getBytes());
        	        	
        	        	
        	        	channel.write(bufferansw);
        	        	channel.close();
        	            key.cancel();
        	        	}catch (Exception e){
        	        		String error = "Wrong format, example: add 'number' 'number' ";
        	        		System.out.println(error);
        	        	}
        	        }  
        	        System.out.println(remoteAddr + ": " + read);
                	
                	
                }
            }
	        }
	        
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Server not started");
			
		}
	 }
}
