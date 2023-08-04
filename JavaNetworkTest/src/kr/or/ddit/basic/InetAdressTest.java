package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressTest {
	public static void main(String[] args) throws UnknownHostException {
		
	// InetAdress 클래스 => IP주소를 다루기 위한 클래스
		
	// 네이버 사이트 IP정보 가져오기
	InetAddress naverIp = InetAddress.getByName("www.naver.com");
	System.out.println("Host Name => "+ naverIp.getHostName());
	System.out.println("Host Address =>" + naverIp.getHostAddress());
	System.out.println();
	
	// 자기자신 컴퓨터의 IP정보 가져오기
	InetAddress localIp = InetAddress.getLocalHost();
	System.out.println("내 컴퓨터의 Host Name => " + localIp.getHostName());
	System.out.println("내 컴퓨터의 Host Address => " + localIp.getHostAddress());
	System.out.println();
	
	// IP주소가 여러개인 호스트의 정보 가져오기 
	InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
	for(InetAddress iAddr : naverIps) {
		System.out.println(iAddr.toString());
	}
	
	
	
	}
}
