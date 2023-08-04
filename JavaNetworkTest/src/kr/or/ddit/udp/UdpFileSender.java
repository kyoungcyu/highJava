package kr.or.ddit.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpFileSender {
	private DatagramSocket ds;
	private DatagramPacket dp;
	
	private InetAddress receiverAddr;
	private int port;
	private File file;
	
	public UdpFileSender(String receiveIp, int port) {
		
		try {
			ds = new DatagramSocket();
			this.port = port;
			receiverAddr = InetAddress.getByName(receiveIp);
			file = new File("D:\\A_teachingMaterial\\jQuery\\vs-code\\images\\정남.jpg");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
	}

	private void start() {

		long fileSize =file.length();
		long totalReadBytes= 0;
		
		long startTime = System.currentTimeMillis();
		
		try {
			// 전송시작을 알려준다.
			sendData("start".getBytes()); 
		
			// 파일명을 전송한다.
			sendData(file.getName().getBytes());
			
			// 총 파일크기를 알려준다 .
			sendData(String.valueOf(fileSize).getBytes());
			
			FileInputStream fis = new FileInputStream(file);
			byte[ ] buffer = new byte[1000];
			while(true) {
				Thread.sleep(10);// 패킷 전송간의 간격을 주기 위해서 .
				
				int readBytes = fis.read(buffer, 0, buffer.length);
				
				if(readBytes == -1) { // 다 읽은 경우 ...
					break; 
				}
				
				// 읽어온 파일내용 전송하기 
				sendData(buffer, readBytes);
				
				totalReadBytes += readBytes;
				
				System.out.println(" 진행 상태 : "
					+ totalReadBytes + "/" + fileSize + " Byte(s) ("
					+ (totalReadBytes * 100/ fileSize) + "%)");
			}
			long endTime = System.currentTimeMillis();
			long diffTime = endTime - startTime;
			double transferSpeed = fileSize / diffTime;
			
			System.out.println("걸린시간 :" + diffTime +  "(ms)");
			System.out.println("평균 전송속도 :" + transferSpeed 
					 + "(Bytes/ms)");
			System.out.println("전송완료");
			
			fis.close();
			ds.close();
		
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 바이트배열 데이터 전송하기 
	 * @param data 전송할 바이트배열
	 * @throws IOException
	 */
	public void sendData(byte[] data) throws IOException {
		sendData(data, data.length);
		
	}
	/**
	 * 바이트배열 데이터 전송하기
	 * @param data 전송할 바이트 배열
	 * @param length 배열의 크기
	 * @throws IOException
	 */
	public void sendData(byte[] data,int length) throws IOException {
		dp = new DatagramPacket(data, length, receiverAddr, port);
		ds.send(dp);
	}

	public static void main(String[] args) {
		new UdpFileSender("192.168.141.34", 8888).start();
	}

}
