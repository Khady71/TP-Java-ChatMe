package TP1DevWeb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class AppServeur{
	
	public static ArrayList <Socket> listSocket = new ArrayList<Socket>();
	
	public static  String pseudo;
	
	
	
	public static void main(String[] args)
	{
		try {
			ServerSocket socketServer = new ServerSocket(1080);
			System.out.println("Attente de connexion...");
			while(true) {
			Socket client = socketServer.accept();
			listSocket.add(client);
			
			DataInputStream in = new DataInputStream(client.getInputStream());
			pseudo = in.readUTF();
			System.out.println("pseudo = "+pseudo);
			for(int j = 0; j < AppServeur.listSocket.size(); j++) {
		        DataOutputStream outc = new DataOutputStream(AppServeur.listSocket.get(j).getOutputStream());
		        outc.writeUTF(pseudo+" a rejoint le salon ");
			}
			/*
			pseudo = AppClient.pseudo;
			while(pseudo == null) {
				try {
				Thread.sleep(10);
				pseudo = AppClient.pseudo;	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}	*/
			//System.out.println("Client n° "+listSocket.size()+" connecté....");
			ServeurAppThread threadS = new ServeurAppThread(client,pseudo,in);
			threadS.start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	
		
	} 
	}
 


