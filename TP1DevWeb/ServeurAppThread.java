package TP1DevWeb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServeurAppThread  extends Thread {
	String messagerecu;
	Socket client;
	
	public   String pseudoclt ;
	DataInputStream in;

	
	public ServeurAppThread(Socket client, String pseudo,DataInputStream in) {this.client = client;this.pseudoclt = pseudo;
	                               this.in = in;}

	public void run() {
		
			
		
		
		try { 
			//DataInputStream in  = new DataInputStream(client.getInputStream());;
			while(client.isConnected()) {
			/*
			pseudo = in.readUTF();
			System.out.println("pseudo = "+pseudo);
			for(int j = 0; j < AppServeur.listSocket.size(); j++) {
		        DataOutputStream outc = new DataOutputStream(AppServeur.listSocket.get(j).getOutputStream());
		        outc.writeUTF(pseudo+" 	est connecté ");
				}*/
			messagerecu = in.readUTF();
			System.out.println("le message recu est "+messagerecu);
			if(messagerecu.contains("byebye")) {
				for(int i = 0; i < AppServeur.listSocket.size(); i++) {
		        	DataOutputStream out = new DataOutputStream(AppServeur.listSocket.get(i).getOutputStream());
		        	out.writeUTF(pseudoclt+" a quitté le salon ");
			}
			}else {
			
			for(int i = 0; i < AppServeur.listSocket.size(); i++) {
	        	DataOutputStream out = new DataOutputStream(AppServeur.listSocket.get(i).getOutputStream());
	        	out.writeUTF((pseudoclt+" a envoyé "+(messagerecu)));
			}
			}
			}}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		 
	}
	
	
}