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
 * Servlet implementation class UpdateOrdersServlet
 */
@WebServlet("/UpdateOrdersServlet")
public class UpdateOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取订单编号
				//Orders order=(Orders) request.getAttribute("oid");
				String orderID=request.getParameter("oid");
				Integer orderState=Integer.parseInt( (String) request.getSession().getAttribute("orderstate"));
				//System.out.println(s);
				//Integer orderState=Integer.parseInt(request.getParameter("state"));
				OrderService service=new OrderServiceImp();
				service.updateOrder(orderID,orderState+1);
				//转发
				request.getRequestDispatcher("/queryZhifuGoodServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
