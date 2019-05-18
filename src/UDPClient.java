/* This is the Java code for the client program */
import java.io.*;
import java.net.*;

class UDPClient {
	
	public static void main(String argv[]) throws Exception {
		
		String sentence;
		DatagramPacket sendPacket;
		
		// create input stream from keyboard
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));	

		// create client socket
		DatagramSocket clientSocket = new DatagramSocket();
	
		// translate server's host name to IP address 
		InetAddress IPAddress = InetAddress.getByName("localhost");
		
	    byte[] sendData = new byte[1024]; 
	    byte[] receiveData = new byte[1024]; 
	  

		
		System.out.print("Enter something ");
		sentence = inFromUser.readLine();

		// create datagram for sentence with data-to-send, length, IP address and port number
		sendData = sentence.getBytes();

		sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,7890);

		// send datagram to server
		clientSocket.send(sendPacket);

		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
		  
		clientSocket.receive(receivePacket); 
		  
		String modifiedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength()); 
		  
		      System.out.println("FROM SERVER:" + modifiedSentence); 
		      clientSocket.close(); 
		      } 
		} 