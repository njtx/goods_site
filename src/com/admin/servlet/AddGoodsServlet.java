package com.admin.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import com.admin.serviceImp.GoodsServiceImp;
import com.nj.dom.Goods;

/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet({ "/AddGoodsServlet", "/addGoodsServlet" })
@MultipartConfig
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String gname=request.getParameter("gname");
		Double gprice=Double.valueOf(request.getParameter("gprice"));
		Double gyprice=Double.valueOf(request.getParameter("gyprice"));
		String gtype=request.getParameter("type");
		String ss=request.getParameter("s");
		String descript=request.getParameter("myEditor");
		int gnum=Integer.parseInt(request.getParameter("count"));
		//���������ϴ����ļ���Part�ӿ�
		Part part=request.getPart("gimg");
		/*String header = part.getHeader("content-disposition");*/
		String header=part.getHeader("Content-Disposition");//��ȡ��ͷ��Ϣ
		String filename = this.getImageName(header);//��ȡ�ϴ��ļ���
		//filename=new String(filename.getBytes("ISO-8859-1"),"utf-8");
		// ָ���ļ��ڷ������еı���λ��
		String savePath = "/upload";
		String realpath =request.getServletContext().getRealPath("");//��ȡ��Ŀ�ڷ������е���ʵ·��
		String pathname = realpath + savePath ;
		File file = new File(pathname);
		// ����ļ��в����ڣ��򴴽�
		if (!file.exists()) {
			file.mkdirs();
		}
		// ��ʵ���ļ�ȫ·��
		String filepath = pathname + "/" + filename;
		//file = new File(filepath);
		// ���ļ����浽ָ����λ��
		//part.write(file);
		request.getSession().setAttribute("path", filepath);
		part.write( filepath);
		Goods goods=new Goods();
		goods.setGoodName(gname);
		goods.setGoodPrice(gprice);
		goods.setGoodYprice(gyprice);
		goods.setGoodPath(savePath+"/"+filename);
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
		service.addgoods(goods);
		response.sendRedirect(request.getContextPath()+"/queryGoodsServlet");
		
	}
	private String getImageName(String header) {
		//System.out.println(header);
		//form-data; name="bookImg"; filename="thumb3.gif"
		String str = header.split(";")[2];
		String s = str.split("=")[1];
		return s.substring(1, s.length()-1);
		
	}

}
