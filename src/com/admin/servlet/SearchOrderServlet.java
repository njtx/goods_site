package com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.serviceImp.LoginServiceImp;
import com.admin.serviceImp.OrdersServiceImp;
import com.nj.dom.Orders;
import com.nj.dom.OrdersAndUser;
import com.nj.dom.User;

/**
 * Servlet implementation class SearchOrderServlet
 */
@WebServlet("/SearchOrderServlet")
public class SearchOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("search");
		OrdersServiceImp service=new OrdersServiceImp();
		List<OrdersAndUser> order=service.getByuName(name);
		//±£´æ
		request.setAttribute("olist", order);
		//×ª·¢
		request.getRequestDispatcher("/admin/olist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
