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
import org.apache.commons.lang3.StringUtils;

import com.admin.serviceImp.GoodsServiceImp;
import com.nj.dom.Goods;
import com.nj.dom.Page;
import com.nj.dom.Searchgoods;
import com.nj.service.PageService;
import com.nj.service.imp.PageServiceImp;

/**
 * Servlet implementation class GoodstTypeServlet
 */
@SuppressWarnings("all")
@WebServlet("/GoodstTypeServlet")

public class GoodstTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String type=request.getParameter("type");
		String name=type;
		String type1=request.getParameter("s");
		String name1=type1;
		String name2=name+name1;*/
		//获取options中的值
		/*String type=request.getParameter("type");
		String s=request.getParameter("s");
		if(StringUtils.equals(s,"0"))
		{
			GoodsServiceImp service=new GoodsServiceImp();
			List<Goods> glist=service.querytype(type);
			 request.setAttribute("gList", glist);
				//转发到goods.jsp
			request.getRequestDispatcher("/admin/gslist.jsp").forward(request, response);
			return;
		}*/
		String type=request.getParameter("type");
		String ss=request.getParameter("s");
		Page page=new Page();
		 try {
			 BeanUtils .populate(page, request.getParameterMap());
		//查询分页对象
		PageService service=new PageServiceImp();
		Searchgoods s=new Searchgoods();
		s.setPage(page);
		if(StringUtils.equals(ss,"0"))
		{
			s.setGname(type);
		}
		else
		{
			String ts=type+":"+ss;
			s.setGname(ts);
		}
		service.querygt(s);
		//保存在request中
		request.setAttribute("page",s);
		//转发
		request.getRequestDispatcher("/admin/gslist.jsp").forward(request, response); 
		}
		 catch (IllegalAccessException | InvocationTargetException e) {
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
