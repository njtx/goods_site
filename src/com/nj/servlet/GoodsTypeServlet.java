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
		//����Ϣ���浽request��
		 request.setAttribute("gList", gList);
		//ת����goods.jsp
		request.getRequestDispatcher("/goods.jsp").forward(request, response);*/
		//��װǰ̨�����������ݵ�Pageʵ������
		String gt=request.getParameter("gtype");
		 Page page=new Page();
		 try {
			BeanUtils .populate(page, request.getParameterMap());
			//��ѯ��ҳ����
			PageService service=new PageServiceImp();
			Searchgoods s=new Searchgoods();
			s.setPage(page);
			s.setGname(gt);
			service.querygt(s);
			//������request��
			request.setAttribute("page",s);
		//ת��
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
