package com.nj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.dom.User;
import com.nj.service.EditService;
import com.nj.service.imp.EditServiceImp;

/**
 * Servlet implementation class infoServlet
 */
@WebServlet("/infoServlet")
public class infoServlet extends HttpServlet {
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
		User user=(User) request.getSession().getAttribute("loginUser");
		EditService service=new EditServiceImp();
		User u=service.queryInfo(user.getUsername());
		request.getSession().setAttribute("user",u);
		request.getRequestDispatcher("/info.jsp").forward(request, response);
	}

}
