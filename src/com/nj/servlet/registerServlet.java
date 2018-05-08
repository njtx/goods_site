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
		// 使用BeanUtils封装user对象
		User user=new User();
		try {
			BeanUtils.populate(user,request.getParameterMap());//使用BeanUtils类调用Bean
			//注册不能为空
			String repwd=request.getParameter("repassword");
			if(StringUtils.isNoneBlank(user.getUsername(),user.getNickname(),user.getPassword(),repwd))
			{
			//密码一致,执行注册语句
				if(StringUtils.equals(repwd, user.getPassword()))
				{
					//执行语句
					UserService service=new UserServiceImp();
					service.register(user);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "密码与确认密码不一致，请重新填写！");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
					return;
				}
			 }
		    	else
			 {
				request.setAttribute("msg", "注册页面不能为空！！");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			 }
			//判断验证码是否正确
			String code=request.getParameter("code");
			String code1=(String) request.getSession().getAttribute("code");
			if(!StringUtils.equals(code, code1)||StringUtils.isBlank(code))
			{
				request.setAttribute("msg", "验证码错误！！");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);	
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}

}
