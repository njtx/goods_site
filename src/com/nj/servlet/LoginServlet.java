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
  // 2.�����û��������룬����service��ѯ�û�
     UserService service=new UserServiceImp();
     User user=service.login(username,pwd);
     //3 �жϲ�ѯ��������Ϊnull,�򲻴��ڸ��û��������û������������
    if(user==null)
    {
    	request.setAttribute("msg","�û������������");
    	request.getRequestDispatcher("/login.jsp").forward(request, response);
        return;//ִ�д˴�����������ִ��
    }
    	//��¼�ɹ��������ݱ�����session�У��Ա��ڸ���ҳ����Ի�ȡ�û���Ϣ��
    request.getSession().setAttribute("loginUser",user);
    //����cookie���м�ס�û���Ϣ������ɾ���û���Ϣ
    String rmb=request.getParameter("remember");
    if(StringUtils.equals(rmb, "on"))
    {
     // ���û������б��룬��������
     			username = URLEncoder.encode(username, "UTF-8");
     			// ����Cookie����
     			Cookie c = new Cookie("username", username);
     			c.setPath("/");
     			c.setMaxAge(60 * 60 * 24);
     			response.addCookie(c);
     		}
     		// �û�û�й�ѡ�����cookie�б�����û�����Ϣ
     		else {
     			// ����Cookie����
     			Cookie c = new Cookie("username", null);
     			c.setPath("/");
     			c.setMaxAge(0);
     			response.addCookie(c);
     		}
    //��ʹ��request�еı��������ʱ�������ض���
	response.sendRedirect(request.getContextPath()+"/RandomGoodsServlet");
	}
	

}
