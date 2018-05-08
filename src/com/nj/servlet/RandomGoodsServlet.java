package com.nj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.dom.Goods;
import com.nj.service.GoodService;
import com.nj.service.imp.GoodServiceImp;

/**
 * Servlet implementation class RandomGoodsServlet
 */
@WebServlet("/RandomGoodsServlet")
public class RandomGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //调用service随机查看3个商品
		GoodService service=new GoodServiceImp();
		List<Goods> glist=service.queryrandom();
		//将信息保存到request中
		 request.setAttribute("gList", glist);
		//转发到index.jsp
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
	}

}
