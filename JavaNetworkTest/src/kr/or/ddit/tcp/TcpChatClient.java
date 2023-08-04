package kr.or.ddit.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpChatClient {
	
	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket("192.168.141.3", 7777);
		
		System.out.println("접속 성공...");
		
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		sender.start();
		receiver.start();
		
	}
}
