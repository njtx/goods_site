package com.nj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.dom.Goods;
import com.nj.service.GoodService;
import com.nj.service.imp.GoodServiceImp;



/**
 * Servlet implementation class GoodDetailServlet
 */
@WebServlet({ "/GoodDetailServlet", "/goodDetailServlet" })
public class GoodDetailServlet extends HttpServlet {
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
     //获取商品 ID
		String gid=request.getParameter("gid");
		GoodService service=new GoodServiceImp();
		Goods good=service.getById(gid);
		//保存
		request.setAttribute("goods", good);
		//转发
		request.getRequestDispatcher("/goods_detail.jsp").forward(request, response);
	}

}
