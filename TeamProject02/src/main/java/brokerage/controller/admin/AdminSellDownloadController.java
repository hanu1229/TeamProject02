package brokerage.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/sell-download")
public class AdminSellDownloadController extends HttpServlet {

	/** sell_파일 다운로드 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminSellDownloadController sell_파일 다운로드(doPost) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = mapper.readValue(req.getReader(), new TypeReference<HashMap<String, String>>() {});
		String fileName = map.get("file");
		System.out.println("fileName : " + fileName);
		// 톰캣 서버의 경로를 가져와서 + /upload/brokerage/ 경로를 붙이고 + fileName을 붙임
		String filePath = req.getServletContext().getRealPath("/upload/sell/") + fileName;
		System.out.println("filePath : " + filePath);
		File downloadFile = new File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);
		// PDF MIME 타입 설정
		String mimeType = getServletContext().getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/pdf";
		}
		resp.setContentType(mimeType);
		// 파일의 크기
		resp.setContentLengthLong((int)downloadFile.length());
		
		// 파일 다운로드 헤더 설정
		String encodedFileName = URLEncoder.encode(downloadFile.getName(), "UTF-8").replaceAll("\\+", "%20");
		// Content-Disposition : attachment 설정으로 강제 다운로드
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");
		// GZip 압축 방지--> pdf 파일을 보내기 위해서는 필수
		resp.setHeader("Content-Encoding", "identity");
		
		// 클라이언트에 파일 전송
		OutputStream outStream = resp.getOutputStream();
		byte[] buffer = new byte[8192];
		int bytesRead;
		// 파일을 끝까지 읽었는지 확인
		while((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		
		inStream.close();
		outStream.flush();
		outStream.close();
		
		System.out.println(">> AdminSellDownloadController sell_파일 다운로드(doPost) 종료\n");
	}
	
}
