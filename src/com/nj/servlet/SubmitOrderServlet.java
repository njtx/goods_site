package com.nj.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.dom.Cart;
import com.nj.dom.OrderDetails;
import com.nj.dom.Orders;
import com.nj.dom.User;
import com.nj.service.CartService;
import com.nj.service.GoodService;
import com.nj.service.OrderService;
import com.nj.service.imp.CartServiceImp;
import com.nj.service.imp.GoodServiceImp;
import com.nj.service.imp.OrderServiceImp;
import com.nj.util.UUIDUtils;


/**
 * Servlet implementation class SubmitOrderServlet
 */
@WebServlet("/SubmitOrderServlet")
@SuppressWarnings("all")
public class SubmitOrderServlet extends HttpServlet {
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
		    if(user==null)
		    {
		    	response.sendRedirect(request.getContextPath()+"/login.jsp");
		    	return;
		    }
		//判断购物车中的商品(即遍历所有商品)是否还有库存，若没有就要提示库存不足，请选购别的商品
		CartService service=new CartServiceImp();
		List<Cart> list=service.queryCart(user.getId());
		boolean cartnum=true;//默认购买的商品数量库存充足
		
		//遍历
		for(Cart cart:list)
		{
			if(cart.getCartNum()>cart.getGoods().getGoodNum())
			{
				cartnum=false;
				//break;
				response.getWriter().write("<script>alert('库存不足！');history.back();</script>");
				return;
			}
		}
	String province=request.getParameter("p");
    String city=request.getParameter("c");
    String district=request.getParameter("d");
    String detailaddress=request.getParameter("address");
    String zipcode=request.getParameter("zipcode");
    String name=request.getParameter("reciver");
    String tel=request.getParameter("telephone");
    String address=province+city+district+detailaddress+" "+"邮编:"+zipcode+" "+"姓名:"
    +name+" "+"手机号:"+tel+" ";
    
    String oid=UUIDUtils.getUUID();//自动获取编号
    Orders orders=new Orders();
    orders.setOrderID(oid);
    orders.setuId(user.getId());
    orders.setOrderAddress(address);
    orders.setOrderState(1);
    orders.setOrderTime(new Date());
    //订单金额
    double total=0;
  //获取订单明细表集合
    List< OrderDetails> olist=new ArrayList<OrderDetails>();
    for(Cart cart:list)
    {
    	total+=cart.getCartNum()*cart.getGoods().getGoodYprice();
    	OrderDetails od=new OrderDetails();
    	od.setOid(oid);
    	od.setGid(cart.getGid());
    	od.setCarNum(cart.getCartNum());
    	olist.add(od);
    }
     orders.setOrderMoney(total);
     orders.setOdlist(olist);
     OrderService orderservice=new OrderServiceImp();
     orderservice.addOrders(orders);
     request.getRequestDispatcher("/queryOrdersServlet").forward(request, response);
	}

}
