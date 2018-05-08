package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.serviceImp.LoginServiceImp;
import com.nj.dom.User;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
@SuppressWarnings("all")
public class AdminLoginServlet extends HttpServlet {
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
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginServiceImp service=new LoginServiceImp();
		User user=service.login(username,password);
		if(user==null)
		{
			request.setAttribute("msg","用户名或密码错误！");
	    	request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
	        return;
		}
		request.getSession().setAttribute("adminLogin",user);
		response.sendRedirect(request.getContextPath()+"/admin/index.html");
		
	}

}
