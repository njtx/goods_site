package com.admin.servlet;

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
 * Servlet implementation class InfoAdminServlet
 */
@WebServlet("/InfoAdminServlet")
public class InfoAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("adminLogin");
		EditService service=new EditServiceImp();
		User u=service.queryInfo(user.getUsername());
		request.getSession().setAttribute("user",u);
		request.getRequestDispatcher("/admin/infoedit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
