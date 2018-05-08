package com.admin.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.admin.serviceImp.OrdersServiceImp;
import com.nj.dom.Orders;
import com.nj.dom.OrdersAndUser;
import com.nj.dom.User;
import com.nj.service.OrderService;
import com.nj.service.imp.OrderServiceImp;

/**
 * Servlet implementation class queryOrderServlet
 */
@WebServlet("/queryOrderServlet")
public class queryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		User user=(User) request.getSession().getAttribute("adminLogin");
		if(user==null)
		{
			//÷ÿ∂®œÚ
			response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
		    return;
		}
		    Orders o=new Orders();
			OrdersServiceImp service=new OrdersServiceImp();
			List<OrdersAndUser> orderlist=service.queryOrder();
			request.setAttribute("olist",orderlist );
			request.getRequestDispatcher("/admin/olist.jsp").forward(request, response);

		
	}

}
