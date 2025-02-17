package brokerage.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.admin.AdminBrokerageDao;
import brokerage.model.dto.BrokerageDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/brokerage")
public class AdminBrokerageController extends HttpServlet {

	/** 중개한 매물 전체 출력 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminBrokerage 중개한 매물 전체 출력(doGet) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<BrokerageDto> result = AdminBrokerageDao.getInstance().findAll();
		System.out.println(">> result : " + result);
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> AdminBrokerage 중개한 매물 전체 출력(doGet) 종료\n");
	}
	
	/** 중개한 매물 파일 다운로드 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminBrokerage 중개한 매물 파일 다운로드(doPost) 실행");
		
		String fileName = req.getParameter("file");
		String filePath = "C:/Users/tj-bu-702-12/Desktop/hanu1229/tj2024b_web/.metadata/.plugins/"
				+ "org.eclipse.wst.server.core/tmp0/wtpwebapps/TeamProject02/upload/brokerage/" + fileName;
		File downloadFile = new File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);
		String mimeType = getServletContext().getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/pdf";
		}
		resp.setContentType(mimeType);
		resp.setContentLengthLong((int)downloadFile.length());
		
		// 파일 다운로드 헤더 설정
		String encodedFileName = URLEncoder.encode(downloadFile.getName(), "UTF-8").replaceAll("\\+", "%20");
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");
		
		// 클라이언트에 파일 전송
		OutputStream outStream = resp.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead;
		while((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		
		inStream.close();
		outStream.close();
		 
		System.out.println(">> AdminBrokerage 중개한 매물 파일 다운로드(doPost) 종료\n");		
	}
	
}
