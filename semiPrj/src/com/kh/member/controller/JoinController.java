package com.kh.member.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.MemberVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 5 * 5
)

@WebServlet("/join")
public class JoinController extends HttpServlet {
	
	//회원가입 화면 보여줌
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	
	//회원가입 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		
		//파일 읽을 준비
		Part part = req.getPart("profile");
		if(part != null) {
			String originName = part.getSubmittedFileName();
			InputStream fis = part.getInputStream();
			
			//파일 저장 준비
			//중복 피하기
	//		String changeName = new Date()같은 거 + UUID.randomUUID();
			String changeName = "" + UUID.randomUUID();
			
			//확장자 이름이 필요함
			String ext = originName.substring(originName.lastIndexOf("."), originName.length());	//abc.png
			String realPath = req.getServletContext().getRealPath("/upload");
			//upload/profile 등 하위폴더 만들어서 해도 된다.
			String filePath = realPath + File.separator + changeName + ext;
			FileOutputStream fos = new FileOutputStream(filePath);
			
			//확인용 출력
			System.out.println("origin : "+originName);
			System.out.println("changeName : "+changeName);
			
			//파일 기록(업로드파일 read -> write)
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			
			fis.close();
			fos.close();
		}
		
		MemberVo m = new MemberVo();
		m.setId(id);
		m.setPwd(pwd);
		m.setName(name);
		
		int result = new MemberService().join(m);
		
		if(result > 0) {
			//success
			req.setAttribute("msg", "회원가입 성공");
			req.getRequestDispatcher("WEB-INF/views/common/successPage.jsp").forward(req, resp);
		} else {
			//error
			req.setAttribute("msg", "회원가입 실패");
			req.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			
		}
	}
}
