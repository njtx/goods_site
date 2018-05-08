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

import com.admin.serviceImp.GoodsServiceImp;
import com.admin.serviceImp.LoginServiceImp;
import com.nj.dom.Goods;
import com.nj.dom.Page;
import com.nj.dom.Searchgoods;
import com.nj.dom.User;
import com.nj.service.PageService;
import com.nj.service.imp.PageServiceImp;

/**
 * Servlet implementation class SearchUserServlet
 */
@WebServlet("/SearchGoodsServlet")
public class SearchGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//获取名称
				String name=request.getParameter("search");
				GoodsServiceImp service=new GoodsServiceImp ();
				List<Goods> glist=service.getByuName(name);
				//保存
				request.setAttribute("glist", glist);
				//转发
				request.getRequestDispatcher("/admin/glist.jsp").forward(request, response);*/
		
		String gname=request.getParameter("search");
		 Page page=new Page();
		 try {
			BeanUtils .populate(page, request.getParameterMap());
			//查询分页对象
			PageService service=new PageServiceImp();
			Searchgoods s=new Searchgoods();
			s.setPage(page);
			s.setGname(gname);
			service.searchqueryPage(s);
			//保存在request中
			request.setAttribute("page",s);
		//转发
		request.getRequestDispatcher("/admin/gslist.jsp").forward(request, response);
		 } catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
