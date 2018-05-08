package com.nj.servlet;

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
 * Servlet implementation class QueryGoodServlet
 */
@WebServlet({ "/QueryGoodServlet", "/queryGoodServlet" })
public class QueryGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /*//����service�鿴������Ʒ
		GoodService service=new GoodServiceImp();
		List<Goods>gList=service.queryall();
		//����Ϣ���浽request��
		 request.setAttribute("gList", gList);*/
		/*//ת����goods.jsp
		request.getRequestDispatcher("/goods.jsp").forward(request, response);*/
		
		//��װǰ̨�����������ݵ�Pageʵ������
		 Page page=new Page();
		 try {
			BeanUtils .populate(page, request.getParameterMap());
			//��ѯ��ҳ����
			PageService service=new PageServiceImp();
			service.queryPage(page);
			//������request��
			request.setAttribute("page",page);
			//ת��
			request.getRequestDispatcher("/goods.jsp").forward(request, response);
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
