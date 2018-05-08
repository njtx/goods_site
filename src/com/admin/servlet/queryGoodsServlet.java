package com.admin.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.nj.dom.Page;
import com.nj.service.PageService;
import com.nj.service.imp.PageServiceImp;

/**
 * Servlet implementation class queryGoodsServlet
 */
@WebServlet("/queryGoodsServlet")
public class queryGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Page page=new Page();
		 try {
			BeanUtils .populate(page, request.getParameterMap());
			//查询分页对象
			PageService service=new PageServiceImp();
			service.queryPage(page);
			//保存在request中
			request.setAttribute("page",page);
			//转发
			request.getRequestDispatcher("/admin/glist.jsp").forward(request, response);
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
