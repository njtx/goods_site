package com.nj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.dom.Orders;
import com.nj.dom.User;
import com.nj.service.OrderService;
import com.nj.service.imp.OrderServiceImp;

/**
 * Servlet implementation class NoZhifuServlet
 */
@WebServlet("/NoZhifuServlet")
public class NoZhifuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int orderstate=Integer.parseInt(request.getParameter("state"));
		User user=(User) request.getSession().getAttribute("loginUser");
		if(user==null)
		{
			//÷ÿ∂®œÚ
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		OrderService service=new OrderServiceImp();
		List<Orders> orderlist=service.queryNozhifu(orderstate);
		request.getSession().setAttribute("olist", orderlist);
		//request.getSession().setAttribute("olist2", orderlist);
		request.getRequestDispatcher("/pay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
