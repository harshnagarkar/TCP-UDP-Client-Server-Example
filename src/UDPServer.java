/* This is the Java code for the server program */
import java.io.*;
import java.net.*;

class UDPServer {
	
	public static void main(String argv[]) throws Exception {
		
		// create server socket
		DatagramSocket serverSocket = new DatagramSocket(7890);
	    byte[] receiveData = new byte[1024]; 
	    byte[] sendData  = new byte[1024]; 

	    System.out.println("Server running....");
		while(true) {
			// create space for received datagram and then receive datagram
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

			serverSocket.receive(receivePacket);
			
			
			// read sentence from received datagram
			String sentence = new String(receivePacket.getData(),0,receivePacket.getLength());

			InetAddress IPAddress = receivePacket.getAddress(); 
			  
	        int port = receivePacket.getPort(); 
			
	          String capitalizedSentence = sentence.toUpperCase(); 

	          sendData = capitalizedSentence.getBytes(); 
	  
	          DatagramPacket sendPacket = 
	             new DatagramPacket(sendData, sendData.length, IPAddress, 
	                               port); 
	  
	          serverSocket.send(sendPacket); 
	         
	        } 
	    } 
	}  