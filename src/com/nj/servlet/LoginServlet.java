package com.nj.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.nj.dom.User;
import com.nj.service.UserService;
import com.nj.service.imp.UserServiceImp;



/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("all")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String username=request.getParameter("username");
     String pwd=request.getParameter("password");
  // 2.根据用户名和密码，调用service查询用户
     UserService service=new UserServiceImp();
     User user=service.login(username,pwd);
     //3 判断查询结果，如果为null,则不存在该用户，或者用户名、密码错误
    if(user==null)
    {
    	request.setAttribute("msg","用户名或密码错误！");
    	request.getRequestDispatcher("/login.jsp").forward(request, response);
        return;//执行此处，不在往下执行
    }
    	//登录成功，把数据保存在session中，以便在各个页面可以获取用户信息；
    request.getSession().setAttribute("loginUser",user);
    //利用cookie进行记住用户信息，否则删除用户信息
    String rmb=request.getParameter("remember");
    if(StringUtils.equals(rmb, "on"))
    {
     // 对用户名进行编码，保存中文
     			username = URLEncoder.encode(username, "UTF-8");
     			// 创建Cookie对象
     			Cookie c = new Cookie("username", username);
     			c.setPath("/");
     			c.setMaxAge(60 * 60 * 24);
     			response.addCookie(c);
     		}
     		// 用户没有勾选，清空cookie中保存的用户名信息
     		else {
     			// 创建Cookie对象
     			Cookie c = new Cookie("username", null);
     			c.setPath("/");
     			c.setMaxAge(0);
     			response.addCookie(c);
     		}
    //不使用request中的保存的数据时，利用重定向。
	response.sendRedirect(request.getContextPath()+"/RandomGoodsServlet");
	}
	

}
