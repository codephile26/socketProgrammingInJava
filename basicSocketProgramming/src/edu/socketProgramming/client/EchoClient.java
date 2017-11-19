package edu.socketProgramming.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	
	public static void main(String...ar){
		if (ar.length !=2){
			System.err.println("Usage: java EchoClient <hostName> <portNumber>");
			System.exit(1);
		}
		
		String hostName =  ar[0];
		int portNumber = Integer.parseInt(ar[1]);
		/*
		 * In try-with-resources block we are initiating three resources.
		 * PrintWriter out is to write the output to the Socket.  
		 * BufferedReader object in is to read the input from the socket
		 * BufferedReader object stdIn is used to read the input from the standard input console.
		 * 
		 * */
		try(
		  Socket echoSocket = new Socket(hostName,portNumber);		
		  PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),true);		
		  BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));		   	
		  BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));	
				){
			String userInput;
			while((userInput = stdIn.readLine()) != null){
				out.println(userInput);
				System.out.println("echo: " + in.readLine());
			}
		}
		catch(UnknownHostException e){
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		}
		catch(IOException e){
			System.err.println("Could not get I/O for the connection to " + hostName);
			System.exit(1);
		}
	}

}
