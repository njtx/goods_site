package com.nj.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.nj.dom.Goods;
import com.nj.dom.Page;
import com.nj.dom.Searchgoods;
import com.nj.service.GoodService;
import com.nj.service.PageService;
import com.nj.service.imp.GoodServiceImp;
import com.nj.service.imp.PageServiceImp;

/**
 * Servlet implementation class GoodsTypeServlet
 */
@WebServlet("/GoodsTypeServlet")
public class GoodsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String gt=request.getParameter("gtype");
		GoodService service=new GoodServiceImp();
		List<Goods>gList=service.querygt(gt);
		//将信息保存到request中
		 request.setAttribute("gList", gList);
		//转发到goods.jsp
		request.getRequestDispatcher("/goods.jsp").forward(request, response);*/
		//封装前台传过来的数据到Page实体类中
		String gt=request.getParameter("gtype");
		 Page page=new Page();
		 try {
			BeanUtils .populate(page, request.getParameterMap());
			//查询分页对象
			PageService service=new PageServiceImp();
			Searchgoods s=new Searchgoods();
			s.setPage(page);
			s.setGname(gt);
			service.querygt(s);
			//保存在request中
			request.setAttribute("page",s);
		//转发
		request.getRequestDispatcher("/searchgoods.jsp").forward(request, response);
		 } catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
