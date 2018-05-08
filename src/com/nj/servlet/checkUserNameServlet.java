package com.nj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.service.UserService;
import com.nj.service.imp.UserServiceImp;


/**
 * Servlet implementation class checkUserNameServlet
 */
@WebServlet("/checkUserNameServlet")
public class checkUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String username=request.getParameter("username");
      UserService service = new UserServiceImp();
		/*
		 * 根据用户名去数据库中匹配用户为username的数量
		 * 如果不为0，说明当前用户名已存在，否则不存在
		 */
		int count = service.checkUserName(username);
		response.getWriter().write(count + "");
	}

}
