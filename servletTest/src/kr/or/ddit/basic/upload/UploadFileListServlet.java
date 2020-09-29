package kr.or.ddit.basic.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UploadFileListServlet.do")
public class UploadFileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String UPLOAD_DIR = "d:/d_other/uploadFiles";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File(UPLOAD_DIR);
		
		if(!file.exists()){
			file.mkdirs();
		}
		
		File[] allFiles = file.listFiles();
		List<UploadDetail> fileList = new ArrayList<>();
		
		for(File f : allFiles){
			if(!f.isFile()) continue;
			UploadDetail details = new UploadDetail();
			details.setFileName(f.getName());
			details.setFileSize(f.length()/1024);
			details.setUploadStatus("");
			
			fileList.add(details);
		}
		request.setAttribute("uploadFileList", fileList);
		String view = "/basic/04/fileList.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
