package TP1DevWeb;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import WindowBuilder.ChatMe;

public class AppClient {
	
	public Socket client;
	public static String message;
	
	public static ChatMe frame = new ChatMe();
	
	public  String pseudo ;
	public static DataOutputStream out;
	public static ArrayList <String> listClient = new ArrayList<String>();

	
	public AppClient() {
		try {
			
			client= new Socket("localhost",1080);
			frame.setVisible(true);
			
			while(AppClient.frame.pseudoclt == null) {
				try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
			pseudo = AppClient.frame.pseudoclt;
			ClientAppThread threadC = new ClientAppThread(client);
			threadC.start();
			
            System.out.println(pseudo +" est connecte");
            
            AppClient.listClient.add(pseudo);
			out= new DataOutputStream(client.getOutputStream());
			out.writeUTF(pseudo);
			
			//while(client.isConnected()) {
			/*
			 while(message == null) {
				try {
					Thread.sleep(100);
					message = AppClient.frame.messageclt;
					;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}}
			 //System.out.println("jesuisla");
			if(message != null) {
				out.writeUTF(message);	
			}message = AppClient.frame.messageclt;*/
		 }catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		}
		
	
	public static void main(String[] args) {
		AppClient clt1 = new AppClient();
				
	
	}
	
}
