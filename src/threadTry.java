import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class game extends Thread{
	static ServerSocket ssMan;
	static ServerSocket ssRand;
	static Socket sMan;
	static Socket sRand;
	static DataInputStream dinMan;
	static DataOutputStream doutMan;
	static DataInputStream dinRand;
	static DataOutputStream doutRand;
	public void run() {
		try {
			String Servergot = "";
			int ServerSend1;
			ssMan= new ServerSocket(2524);
			ssRand = new ServerSocket(2425);
			/*String ServergotChat = "";
			String ServerSend1Chat="";
			ssManChat= new ServerSocket(1200);
			ssRandChat = new ServerSocket(1201);*/
			while(true){
			sMan = ssMan.accept();
			sRand = ssRand.accept();
			/*sManChat = ssManChat.accept();
			sRandChat = ssRandChat.accept();*/
			///new ServerThread(sMan).start();
			
			//////////////////////////////////////////////////////
			
			dinMan = new DataInputStream(sMan.getInputStream());
			doutMan = new DataOutputStream(sMan.getOutputStream());
			dinRand = new DataInputStream(sRand.getInputStream());
			doutRand = new DataOutputStream(sRand.getOutputStream());
			
		/*	dinManChat = new DataInputStream(sManChat.getInputStream());
			doutManChat = new DataOutputStream(sManChat.getOutputStream());
			dinRandChat = new DataInputStream(sRandChat.getInputStream());
			doutRandChat = new DataOutputStream(sRandChat.getOutputStream());*/
			while (!Servergot.equals("exit")){
				
				System.out.println("Receiving from Client Man");
				Servergot = dinMan.readUTF();
				System.out.println("Sending to client Rand "+Servergot);
				doutRand.writeUTF(Servergot);
				System.out.println("Receiving from client Rand");
				Servergot = dinRand.readUTF();
				System.out.println("Sending to client Man "+Servergot);
				doutMan.writeUTF(Servergot);
				
				
				
				////////////////////////////////////////
			}
		/*	while (!ServergotChat.equals("exit")){
				System.out.println("Receiving from Client Man");
				ServergotChat = dinManChat.readUTF();
				System.out.println("Sending to client Rand "+ServergotChat);
				doutRandChat.writeUTF(ServergotChat);
				System.out.println("Receiving from client Rand");
				ServergotChat = dinRandChat.readUTF();
				System.out.println("Sending to client Man "+ServergotChat);
				doutManChat.writeUTF(ServergotChat);
			}*/
			////////////////////////////////////////////////////////////////////
			
			
			//while (!Servergot.equals("exit")){
			//}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			Thread.sleep(100);
			}catch(Exception e){
				System.out.println("Error");
			}
	}
	
	
}
	

class chat extends Thread{
	static ServerSocket ssManChat;
	static ServerSocket ssRandChat;
	static Socket sManChat;
	static Socket sRandChat;
	static DataInputStream dinManChat;
	static DataOutputStream doutManChat;
	static DataInputStream dinRandChat;
	static DataOutputStream doutRandChat;
	public void run() {
		try {
			ssManChat= new ServerSocket(1200);
			ssRandChat = new ServerSocket(1201);
			while(true){
				
					
					sManChat = ssManChat.accept();
					sRandChat = ssRandChat.accept();
					String ServergotChat = "";
					String ServerSend1Chat="";

					dinManChat = new DataInputStream(sManChat.getInputStream());
					doutManChat = new DataOutputStream(sManChat.getOutputStream());
					dinRandChat = new DataInputStream(sRandChat.getInputStream());
					doutRandChat = new DataOutputStream(sRandChat.getOutputStream());
					
					while (!ServergotChat.equals("exit")||!ServerSend1Chat.equals("exit")){
						System.out.println("Receiving from Client Man");
						ServergotChat = dinManChat.readUTF();
						System.out.println("Sending to client Rand "+ServergotChat);
						doutRandChat.writeUTF(ServergotChat);
						System.out.println("Receiving from client Rand");
						ServerSend1Chat = dinRandChat.readUTF();
						System.out.println("Sending to client Man "+ServerSend1Chat);
						doutManChat.writeUTF(ServerSend1Chat);
					}
			
		} }catch (IOException e1) {
		
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
	e.printStackTrace();
}
	}

		
	
	}

public class threadTry {

	public static void main(String[] args) {
		game g1= new game();
		chat c1= new chat();
		g1.start();
		c1.start();

	}

}
