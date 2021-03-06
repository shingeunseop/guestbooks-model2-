package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbooksDao;
import com.javaex.vo.GuestbooksVo;



@WebServlet("/gs")
public class GuestbooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//이게 없으면 한글을 적을시 글자가 깨져 수가 넘침
		String actionName=request.getParameter("a");
		if("deleteform".equals(actionName)) {
			RequestDispatcher rd=request.getRequestDispatcher("deleteform.jsp");
			rd.forward(request, response);
			
			System.out.println("deleteform출력");
			
		}else if("add".equals(actionName)){
			System.out.println("저장관련");
			String name=request.getParameter("ln");
			String password=request.getParameter("ps");
			String content=request.getParameter("co");
			
			GuestbooksVo vo=new GuestbooksVo(name,password,content);
			
			GuestbooksDao dao=new GuestbooksDao();
			dao.insert(vo);
			
			response.sendRedirect("/guestbook2/gs");
			
		}else {
			System.out.println("기본값 리스트");
			GuestbooksDao dao=new GuestbooksDao();
			List<GuestbooksVo> list=dao.getList();
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
