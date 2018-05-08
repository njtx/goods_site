package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.service.OrderService;
import com.nj.service.imp.OrderServiceImp;

/**
 * Servlet implementation class DeleteOrdersServlet
 */
@WebServlet("/DeleteOrdersServlet")
public class DeleteOrdersServlet extends HttpServlet {
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
		//获取订单编号
		String orderid=request.getParameter("oid");
		OrderService service=new OrderServiceImp();
		service.deleteOrder(orderid);
		//转发
		request.getRequestDispatcher("/queryOrderServlet").forward(request, response);
	}

}
