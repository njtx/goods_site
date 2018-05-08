package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.serviceImp.GoodsServiceImp;
import com.nj.dom.Goods;
import com.nj.dom.User;

/**
 * Servlet implementation class InfoGoodServlet
 */
@WebServlet("/InfoGoodServlet")
public class InfoGoodServlet extends HttpServlet {
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
		User user=(User) request.getSession().getAttribute("adminLogin");
		if(user==null)
		{
			//重定向
			response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
		    return;
		}
		//查看商品详情
				GoodsServiceImp service=new GoodsServiceImp();
				String gid=request.getParameter("id");
				Goods g=service.Infog(gid);
				request.getSession().setAttribute("g",g);
				request.getRequestDispatcher("/admin/editgood.jsp").forward(request, response);
	}

}
