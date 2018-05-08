package com.nj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.nj.dom.User;
import com.nj.service.EditService;
import com.nj.service.imp.EditServiceImp;

/**
 * Servlet implementation class EditInfoServlet
 */
@WebServlet("/EditInfoServlet")
public class EditInfoServlet extends HttpServlet {
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
		User user=(User) request.getSession().getAttribute("loginUser");
		try {
			BeanUtils.populate(user,request.getParameterMap());//使用BeanUtils类调用Bean
			String repwd=request.getParameter("repassword");
			
				if(StringUtils.equals(repwd, user.getPassword()))
				{
					EditService service=new EditServiceImp();
					service.editInfo(user);
					//response.getWriter().write("<script>alert('个人资料修改成功！');history.back();</script>");
					request.setAttribute("msg","个人资料修改成功！请重新登录");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
				else{
					request.setAttribute("msg","密码不一致！");
					//response.getWriter().write("<script>alert('密码不一致！');history.back();</script>");
					request.getRequestDispatcher("/infoServlet").forward(request, response);
				}
			}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
		/*User user=new User();
		String username=request.getParameter("username");
		String nick=request.getParameter("nickname");
		String pwd=request.getParameter("password");
		String repwd=request.getParameter("repassword");
		if(pwd==repwd)
		{
			user.setNickname(nick);
			user.setPassword(pwd);
			EditService service=new EditServiceImp();
			service.editInfo(username);
			response.getWriter().write("<script>alert('个人资料修改成功！');history.back();</script>");
			//request.setAttribute("msg","个人资料修改成功！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		else{
			//request.setAttribute("msg","密码不一致！");
			response.getWriter().write("<script>alert('密码不一致！');history.back();</script>");
			request.getRequestDispatcher("/infoServlet").forward(request, response);
		}*/
		}
}
