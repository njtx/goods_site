package com.nj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.nj.dom.Cart;
import com.nj.dom.User;
import com.nj.service.CartService;
import com.nj.service.imp.CartServiceImp;



/**
 * Servlet implementation class queryCartServlet
 */
@SuppressWarnings("all")
@WebServlet(
		name = "QueryCartServlet", 
		urlPatterns = { 
				"/QueryCartServlet", 
				"/queryCartServlet"
		})
public class queryCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //判断登录
		User user=(User) request.getSession().getAttribute("loginUser");
		if(user==null)
		{
			//重定向
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		//调用service获取信息
		CartService service=new CartServiceImp();
		List<Cart>clist=service.queryCart(user.getId());
	//将信息保存到request中
		request.getSession().setAttribute("clist", clist);
	//转发
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
