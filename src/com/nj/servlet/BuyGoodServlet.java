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
     //判断用户是否登录
		User user=(User) request.getSession().getAttribute("loginUser");
		if(user==null)
		{
			//重定向
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		//判断商品是否购买过，根据用户id与商品id查询购物记录
		String gid=request.getParameter("id");
	    int uid=user.getId();
	    GoodService service=new GoodServiceImp();
	    Goods g=service.getById(gid);
	    CartService cartservice=new CartServiceImp();
		Cart c = cartservice.queryRecord(gid, uid);
		//购买数量与库存量的对比
		if(c==null&&g.getGoodNum()>0)
		{
			//如果第一次购买，进行插入操作
			c=new Cart();
			c.setGid(Integer.parseInt(gid));
			c.setUid(uid);
			c.setCartNum(1);
			service.addCart(c);
		}
		//如果购物车的购买数量小于库存量，进行更新
		else if(c.getCartNum()<g.getGoodNum())
		{
			c.setCartNum(c.getCartNum()+1);
			service.updateCart(c);
		}
		  else
		{
		request.setAttribute("msg","库存不足");
		request.getRequestDispatcher("/QueryGoodServlet").forward(request, response);
		return;
		}
		//跳转中间页
		response.sendRedirect(request.getContextPath()+"/buyorcart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
