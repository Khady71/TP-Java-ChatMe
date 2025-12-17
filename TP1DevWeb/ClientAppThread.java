package TP1DevWeb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;

import WindowBuilder.ChatMe;

public class ClientAppThread extends Thread{
	
	
	//public static String pseudo ;
	Socket client;
	String pseudo;
	
	//public static ChatMe frame = new ChatMe();

	
	ClientAppThread (Socket client){this.client = client;}

	
	public void run() {
		try {
			//frame.setVisible(true);
			/*
			while(pseudo == null) {
				try {
				Thread.sleep(10);
				pseudo = frame.pseudoclt;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
            System.out.println(ClientAppThread.pseudo +" est connecte");
            AppClient.listClient.add(ClientAppThread.pseudo);*/
			//Scanner scan = new Scanner(System.in); 
			System.out.println("Entrez votre message");
			//On attend que le client envoie son message
			/*while(frame.messageclt == null)
			try {
				Thread.sleep(100);
				;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			OutputStream out= new DataOutputStream(client.getOutputStream());
			byte b2[] = new byte[1024];
			out.write(frame.messageclt.getBytes());
		} catch (IOException e) {
	
			e.printStackTrace();
		}*/
		 
		 
		
		//try {
			while(client.isConnected()) {
			DataInputStream in = new DataInputStream(client.getInputStream()); 
			String recu = in.readUTF();	
			AppClient.frame.ecran.append(recu+"\n");
		}}catch (IOException e1) {
			e1.printStackTrace();}
		
	}
		
	
	
	
	public static void main(String[] args) {
		
	} 
	

}
