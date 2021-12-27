package com.kh.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
//		location = "/tempRepo", 기본경로
		//아래 파일사이즈를 넘어서면 위의 location에 임시로 저장
//		fileSizeThreshold = 1024*1024, 기본값
		//파일 하나 당 최대 크기.. 50메가바이트
		maxFileSize = 1024*1024*50,
		//전체 request 크기.. 최대 50메가바이트를 5개까지
		maxRequestSize = 1024*1024*50*5
		)
@WebServlet("/fileTest")
public class FileTestController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		//파일이 여러 개일 때
		Collection<Part> parts = req.getParts();
		for(Part file : parts) {
			if(!file.getName().equals("f")) continue;
			
			//이하 내용은 part의 name이 "f"인 경우만 실행됨!!!!
//		Part file = req.getPart("f");
//			위는 하나일때만
		
		//사용자가 업로드한 파일 이름 알아오기(파일의 원래 이름)
		String originName = file.getSubmittedFileName();
		
		//사용자가 업로드한 파일에 input 스트림 연결
		InputStream fis = file.getInputStream();
		
		//저장할 경로
		//물리경로(c:../WebContent) + /upload
		String realPath = req.getServletContext().getRealPath("/upload");
		
		//파일 경로
		//File.separator : / 이런거
		String filePath = realPath + File.separator + originName;
		
		//파일 저장
		FileOutputStream fos = new FileOutputStream(filePath);
		
		byte[] buf = new byte[1024];
		int size = 0;
		//사이즈가 -1이면 아웃
		while((size = fis.read(buf)) != -1) {
			fos.write(buf, 0, size);
		}
		
		fis.close();
		fos.close();
		
		}
		System.out.println(id);
//		System.out.println(file);
		
		//화면에 보여주기
		req.setAttribute("path", "falling.png");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
