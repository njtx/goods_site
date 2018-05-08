package com.nj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.dom.Orders;
import com.nj.service.OrderService;
import com.nj.service.imp.OrderServiceImp;

/**
 * Servlet implementation class deleteOrdersServlet
 */
@WebServlet("/deleteOrdersServlet")
public class deleteOrdersServlet extends HttpServlet {
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
		/*String s=request.getParameter("ostate");
		System.out.println(s);*/
		//获取订单编号
		String orderid=request.getParameter("oid");
		OrderService service=new OrderServiceImp();
		service.deleteOrder(orderid);
		//转发
		request.getRequestDispatcher("/queryOrdersServlet").forward(request, response);
	}

}
