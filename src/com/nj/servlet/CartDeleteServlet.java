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
 * Servlet implementation class CartDeleteServlet
 */
@WebServlet({ "/CartDeleteServlet", "/cartDeleteServlet" })
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("loginUser");
		/*if(user==null)
		{
			request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request, response);
		    return;
		}*/
		int uid=user.getId();
		int gid=Integer.parseInt(request.getParameter("id"));
        CartService service=new CartServiceImp();
        service.deleteCart(uid,gid);
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
