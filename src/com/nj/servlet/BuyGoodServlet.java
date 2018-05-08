package com.nj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.dom.Cart;
import com.nj.dom.Goods;
import com.nj.dom.User;
import com.nj.service.CartService;
import com.nj.service.GoodService;
import com.nj.service.imp.CartServiceImp;
import com.nj.service.imp.GoodServiceImp;



/**
 * Servlet implementation class BuyGoodServlet
 */
@WebServlet({ "/BuyGoodServlet", "/buyGoodServlet" })
@SuppressWarnings("all")
public class BuyGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //�ж��û��Ƿ��¼
		User user=(User) request.getSession().getAttribute("loginUser");
		if(user==null)
		{
			//�ض���
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		//�ж���Ʒ�Ƿ�����������û�id����Ʒid��ѯ�����¼
		String gid=request.getParameter("id");
	    int uid=user.getId();
	    GoodService service=new GoodServiceImp();
	    Goods g=service.getById(gid);
	    CartService cartservice=new CartServiceImp();
		Cart c = cartservice.queryRecord(gid, uid);
		//���������������ĶԱ�
		if(c==null&&g.getGoodNum()>0)
		{
			//�����һ�ι��򣬽��в������
			c=new Cart();
			c.setGid(Integer.parseInt(gid));
			c.setUid(uid);
			c.setCartNum(1);
			service.addCart(c);
		}
		//������ﳵ�Ĺ�������С�ڿ���������и���
		else if(c.getCartNum()<g.getGoodNum())
		{
			c.setCartNum(c.getCartNum()+1);
			service.updateCart(c);
		}
		  else
		{
		request.setAttribute("msg","��治��");
		request.getRequestDispatcher("/QueryGoodServlet").forward(request, response);
		return;
		}
		//��ת�м�ҳ
		response.sendRedirect(request.getContextPath()+"/buyorcart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
