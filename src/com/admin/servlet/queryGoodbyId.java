package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.serviceImp.GoodsServiceImp;
import com.nj.dom.Goods;
import com.nj.service.imp.GoodServiceImp;

/**
 * Servlet implementation class queryGoodbyId
 */
@WebServlet("/queryGoodbyId")
public class queryGoodbyId extends HttpServlet {
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
		String gid=request.getParameter("id");
		GoodsServiceImp service=new GoodsServiceImp();
		Goods g=service.Infog(gid);
		ServletContext application=this.getServletContext();
        application.setAttribute("gid",g);
		//ServletContext..setAttribute("gid", g);
		response.sendRedirect(request.getContextPath()+"/admin/good-ueditor.jsp");
	}

}
