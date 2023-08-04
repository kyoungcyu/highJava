package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClient {
	private DatagramSocket ds;
	private DatagramPacket dp;
	
	private byte[] msg; //데이터가 저장될 공간으로 byte배열 생성(패킷수신용)
	
	public UdpClient() {
		msg = new byte[100];
		
		try{
			// 소켓객체 생성(포트번호를 명시하지않으면 이용가능한 임의의 포트번호가 할당됨)
			ds = new DatagramSocket();
		}catch(SocketException ex){
			ex.printStackTrace();
		}
	}
	
	public void start() {
		try {
			InetAddress serverAddr = 
					InetAddress.getByName("192.168.141.34");
			
			// 임의의 1 byte데이터 전송 
			dp = new DatagramPacket(msg, 1, serverAddr, 8888); //port 번호는 1234 번이상만 사용하셈
			ds.send(dp);
			
			// 서버가 보내준 문자열 수신
			dp = new DatagramPacket(msg, msg.length);
			ds.receive(dp);
			
			System.out.println("현재 서버 시간 =>" + new String(dp.getData()));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			ds.close();
		}
	}
	public static void main(String[] args) {
		new UdpClient().start();
	}
}
