import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
	static ServerSocket ssManChat;
	static ServerSocket ssRandChat;
	static Socket sManChat;
	static Socket sRandChat;
	static DataInputStream dinManChat;
	static DataOutputStream doutManChat;
	static DataInputStream dinRandChat;
	static DataOutputStream doutRandChat;

	public static void main(String[] args) {
		try {
			ssManChat= new ServerSocket(1200);
			ssRandChat = new ServerSocket(1201);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(true){
			try {
				sManChat = ssManChat.accept();
				sRandChat = ssRandChat.accept();
				String ServergotChat = "";
				String ServerSend1Chat="";

				dinManChat = new DataInputStream(sManChat.getInputStream());
				doutManChat = new DataOutputStream(sManChat.getOutputStream());
				dinRandChat = new DataInputStream(sRandChat.getInputStream());
				doutRandChat = new DataOutputStream(sRandChat.getOutputStream());
				
				while (!ServergotChat.equals("exit")){
					System.out.println("Receiving from Client Man");
					ServergotChat = dinManChat.readUTF();
					System.out.println("Sending to client Rand "+ServergotChat);
					doutRandChat.writeUTF(ServergotChat);
					System.out.println("Receiving from client Rand");
					ServergotChat = dinRandChat.readUTF();
					System.out.println("Sending to client Man "+ServergotChat);
					doutManChat.writeUTF(ServergotChat);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
	

	}

}
