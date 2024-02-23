package org.nowr.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

// @애들 중 그 이외의 기능을 하는 애 @Component
@Component
public class Util {
	public int str2Int(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}
	}
	// 2024-02-21 psd 웹 표준
	public HttpServletRequest req() { // 리턴타입이 HttpServletRequest 입니다.
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		return request;
	
	
	}
	
	// 세션불러오는녀석
	public HttpSession getSession() {
		/*
		 * ServletRequestAttributes sra = (ServletRequestAttributes)
		 * RequestContextHolder.currentRequestAttributes(); HttpServletRequest request =
		 * sra.getRequest(); HttpSession session = request.getSession();
		 */
		HttpSession session = req().getSession(); // 위에 꺼를 줄였습니다.
		return session;
	}
	
	// ip잡기
	 public String getIP() {
		 HttpServletRequest request = req();
		 String ip = request.getHeader("X-FORWARDED-FOR");
         if(ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
         }
         if(ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");   
         }
         if(ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
         }
         if(ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
         }
         if(ip == null) {
            ip = request.getRemoteAddr();
         }
         return ip;
      }
	
	
	// 24.02.22 숫자인지 검사하는 메소드
	 public boolean intCheck(String str) {
		 try {
			 Integer.parseInt(str);
			 return true;
		 } catch(Exception e) {
			 return false;
		 }
	 }
	
	// 24.02.22 메일보내기
	 public void sendEmail(String email, String key) throws EmailException {
		 
		 //mail 보내기
			String emailAddr = "nws1993@naver.com";	// 이메일
			String name = "해킹범입니다";						 // 이름
			String password = "Blake21690!";						 // 패스워드
			String hostName = "smtp-mail.outlook.com"; // 메일
			int port = 587; 							 // 포트번호
			
			SimpleEmail simpleEmail = new SimpleEmail(); // 전송할 메일
			simpleEmail.setCharset("UTF-8");
			simpleEmail.setDebug(true);
			simpleEmail.setHostName(hostName);						// 보내는 서버 설정 = 고정
			simpleEmail.setAuthentication(emailAddr, password);		// 보내는 사람 인증 = 고정
			simpleEmail.setSmtpPort(port);							// 사용할 port = 고정
			simpleEmail.setStartTLSEnabled(true);					// 인증방법 = 고정
			simpleEmail.setFrom(emailAddr, name);					// 보내는 사람 email, 보내는 사람 ㅁ이름
			simpleEmail.addTo(email); 								// 받는사람 (변수로 집어넣었슴다)
			simpleEmail.setSubject("요청하신 인증번호 입니다."); 	// 제목
			simpleEmail.setMsg("인증번호는 ["+ key + "] 입니다.");	// 본문내용  text
			simpleEmail.send();										// 전송하기
			
	 }
	
	 // 인증번호 4자리 랜덤으로 뽑기
	 public String createKey() {
		 
		 Random r = new Random();
		 r.setSeed(System.currentTimeMillis());
		 String key = r.nextInt(10) + "" + r.nextInt(10) + r.nextInt(10) + r.nextInt(10);
		 return key;
	 }
	
	// 파일 업로드 유틸
	public String fileUpload(MultipartFile upFile) {
		
		// 경로 저장
		String root = req().getSession().getServletContext().getRealPath("/");
		String upfilePath = root + "resources\\upfile\\";
		
		// UUID 뽑기
		UUID uuid = UUID.randomUUID();
		
		// UUID를 포함한 파일명
		String newFileName = uuid.toString() + upFile.getOriginalFilename();
		
		// 실제 업로드 new File(경로명, 실제 파일명)
		File file = new File(upfilePath, newFileName);
		
		if(file.exists() == false) {
			file.mkdirs(); // 경로가 없다면 만들어주는 녀석
		}
		
		try {
			FileOutputStream thumbnail = new FileOutputStream(new File(upfilePath, "s_"+newFileName));
			Thumbnailator.createThumbnail(upFile.getInputStream(), thumbnail, 100, 100);
			thumbnail.close();
			upFile.transferTo(file); // 자바 밖으로가서 파일을 가져오기때문에 try/catch걸어야함
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} 
		
		return newFileName;
	}
	 
	
	

}
