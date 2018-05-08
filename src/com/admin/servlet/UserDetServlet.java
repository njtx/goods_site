package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.serviceImp.LoginServiceImp;
import com.nj.dom.User;
import com.nj.service.CartService;
import com.nj.service.imp.CartServiceImp;

/**
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/UserDetServlet")
public class UserDetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("adminLogin");
		if(user==null)
		{
			response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
		    return;
		}
		int uid=Integer.parseInt(request.getParameter("id"));
		LoginServiceImp service=new LoginServiceImp();
        service.deleteUser(uid);
        response.sendRedirect(request.getContextPath()+"/QueryUserServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
