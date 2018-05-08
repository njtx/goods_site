package com.nj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.dom.User;
import com.nj.service.CartService;
import com.nj.service.imp.CartServiceImp;



/**
 * Servlet implementation class CartChangeServlet
 */
@WebServlet({ "/CartChangeServlet", "/cartChangeServlet" })
public class CartChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=(User) request.getSession().getAttribute("loginUser");
		if(user==null)
		{
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		int gid=Integer.parseInt(request.getParameter("gid"));
		int carnum=Integer.parseInt(request.getParameter("cartnum"));
		int uid=user.getId();
		CartService service=new CartServiceImp();
		service.update(uid,gid,carnum);
		//Ìø×ªÒ³Ãæ
		response.sendRedirect(request.getContextPath()+"/queryCartServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
