package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.serviceImp.GoodsServiceImp;
import com.nj.service.UserService;
import com.nj.service.imp.UserServiceImp;

/**
 * Servlet implementation class checkGoodsNameServlet
 */
@WebServlet("/checkGoodsNameServlet")
public class checkGoodsNameServlet extends HttpServlet {
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
		  String gname=request.getParameter("gname");
	      GoodsServiceImp service = new GoodsServiceImp();
	      int count = service.checkgoodsName(gname);
		  response.getWriter().write(count + "");
	}

}
