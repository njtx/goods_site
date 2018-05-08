package com.nj.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.nj.dom.User;
import com.nj.service.UserService;
import com.nj.service.imp.UserServiceImp;





/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
@SuppressWarnings("all")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ʹ��BeanUtils��װuser����
		User user=new User();
		try {
			BeanUtils.populate(user,request.getParameterMap());//ʹ��BeanUtils�����Bean
			//ע�᲻��Ϊ��
			String repwd=request.getParameter("repassword");
			if(StringUtils.isNoneBlank(user.getUsername(),user.getNickname(),user.getPassword(),repwd))
			{
			//����һ��,ִ��ע�����
				if(StringUtils.equals(repwd, user.getPassword()))
				{
					//ִ�����
					UserService service=new UserServiceImp();
					service.register(user);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "������ȷ�����벻һ�£���������д��");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
					return;
				}
			 }
		    	else
			 {
				request.setAttribute("msg", "ע��ҳ�治��Ϊ�գ���");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			 }
			//�ж���֤���Ƿ���ȷ
			String code=request.getParameter("code");
			String code1=(String) request.getSession().getAttribute("code");
			if(!StringUtils.equals(code, code1)||StringUtils.isBlank(code))
			{
				request.setAttribute("msg", "��֤����󣡣�");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);	
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}

}
