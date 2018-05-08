package com.admin.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import com.admin.serviceImp.GoodsServiceImp;
import com.nj.dom.Goods;
import com.nj.dom.User;
import com.nj.service.EditService;
import com.nj.service.imp.EditServiceImp;
import com.nj.service.imp.GoodServiceImp;

/**
 * Servlet implementation class EditGoodServlet
 */
@WebServlet("/EditGoodServlet")
public class EditGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//ÐÞ¸ÄÉÌÆ·
	        	String gname=request.getParameter("gname");
				Double gprice=Double.parseDouble(request.getParameter("gprice"));
				Double gyprice=Double.parseDouble(request.getParameter("gyprice"));
				String gtype=request.getParameter("type");
				String ss=request.getParameter("s");
				String descript=request.getParameter("myEditor");
				int gnum=Integer.parseInt(request.getParameter("count"));
				Goods goods=new Goods();
				goods.setGoodPrice(gprice);
				goods.setGoodYprice(gyprice);
				if(StringUtils.equals(ss,"0"))
				{
					goods.setGoodType(gtype);
				}
				else
				{
					String ts=gtype+":"+ss;
					goods.setGoodType(ts);
				}
				goods.setGoodDescript(descript);
				goods.setGoodNum(gnum);
				GoodsServiceImp service=new GoodsServiceImp();
				service.editgoods(goods, gname);
				request.getRequestDispatcher("/queryGoodsServlet").forward(request, response);
				
				
			}
				
			

}
