package brokerage.controller.estate;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.EstateDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet("/estate/info")
public class EstateController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("EstateController dopost!!");
		// 업로드 경로 가져오기
		String uploadPath = req.getServletContext().getRealPath("/upload");
		System.out.println( uploadPath );
		// 만일 해당 경로가 없으면 만들어주기.
		File file = new File(uploadPath);
		if( file.exists() ) {} // 경로가 존재하면 정적
		else { file.mkdir(); } // 경로가 존재하지 않으면 경로 생성 // .mkdir() : 지정된 경로 폴더 생성 메소드
		// 파일 업로드 설정 , DiskFileItemFactory클래스
		System.out.println( file );
		DiskFileItemFactory factory = new DiskFileItemFactory(); // 업로드 설정 객체 생성
		factory.setRepository(file); // 업로드된 파일을 임시로 저장할 디렉터리를 설정
		factory.setSizeThreshold( 1024 * 1024 * 1024 ); // 1gb
		factory.setDefaultCharset("UTF-8"); // 한글 인코딩 설정
		// 설정된 객체를 서블릿업로드 객체에 대입
		ServletFileUpload fileupload = new ServletFileUpload( factory );
		// HTTP 요청 객체 내 데이터 파싱/가져오기 ,
		String filename = "default.pdf";
		try {
			List<FileItem> fileList = fileupload.parseRequest(req);
			for( FileItem item : fileList ) { // 향상된 for문
				// 만약에 조회중인 자료가 일반 텍스트이면
				if( item.isFormField() ) {
				}else { // 아니면 , 조회중인 자료가 첨부파일이면
					if( !item.getName().isEmpty() ) { // 첨부파일이 비어있지 않으면
						// UUID 이용한 첨부파일명 조합하기.
						filename = UUID.randomUUID().toString() + "-" + item.getName().replaceAll("-", "_");
						// 업로드할 경로와 파일명 조합하여 경로 만들기
						File uploadFile = new File( uploadPath + "/" + filename );
						// 지정한 경로에 업로드하기
						item.write( uploadFile );
					}
				}
			} // for end
	}catch( Exception e ) { System.out.println( e ); }
		
		
	} // f end
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("EstateController doget!!");
		
		
		List< Map<String,String> > result = EstateDao.getInstance().findByPno();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString( );
		resp.getContentType("application/json");
		resp.getWriter().print( jsonResult );
		
	} // f end
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("EstateController doput!!");
	} // f end
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("EstateController dodelete!!");
	} // f end
	
} // c end
