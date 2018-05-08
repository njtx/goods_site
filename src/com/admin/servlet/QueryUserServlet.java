package com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.serviceImp.LoginServiceImp;
import com.nj.dom.User;

/**
 * Servlet implementation class QueryUserServlet
 */
@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=(User) request.getSession().getAttribute("adminLogin");
		if(user==null)
		{
			response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
		    return;
		}
		LoginServiceImp service=new LoginServiceImp();
		List<User> ulist=service.query();
		request.getSession().setAttribute("ulist", ulist);
		request.getRequestDispatcher("/admin/list.jsp").forward(request, response);
	}

}
