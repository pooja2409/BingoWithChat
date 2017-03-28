import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static ServerSocket ssMan;
	static ServerSocket ssRand;
	static Socket sMan;
	static Socket sRand;
	static DataInputStream dinMan;
	static DataOutputStream doutMan;
	static DataInputStream dinRand;
	static DataOutputStream doutRand;
	
	static ServerSocket ssManChat;
	static ServerSocket ssRandChat;
	static Socket sManChat;
	static Socket sRandChat;
	static DataInputStream dinManChat;
	static DataOutputStream doutManChat;
	static DataInputStream dinRandChat;
	static DataOutputStream doutRandChat;
	//static String Servergot = "";
	//static int ServerSend1;
	public static void main(String[] args) {
		try {
			String Servergot = "";
			int ServerSend1;
			ssMan= new ServerSocket(2524);
			ssRand = new ServerSocket(2425);
			String ServergotChat = "";
			String ServerSend1Chat;
			ssManChat= new ServerSocket(1200);
			ssRandChat = new ServerSocket(1201);
			while(true){
			sMan = ssMan.accept();
			sRand = ssRand.accept();
			sManChat = ssManChat.accept();
			sRandChat = ssRandChat.accept();
			///new ServerThread(sMan).start();
			
			//////////////////////////////////////////////////////
			
			dinMan = new DataInputStream(sMan.getInputStream());
			doutMan = new DataOutputStream(sMan.getOutputStream());
			dinRand = new DataInputStream(sRand.getInputStream());
			doutRand = new DataOutputStream(sRand.getOutputStream());
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
			////////////////////////////////////////////////////////////////////
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
			
			//while (!Servergot.equals("exit")){
			//}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
