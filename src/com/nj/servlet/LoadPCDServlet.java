package com.nj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.dom.PCD;
import com.nj.service.LoadService;
import com.nj.service.imp.LoadServiceImp;


import flexjson.JSONSerializer;

/**
 * Servlet implementation class LoadPCDServlet
 */
@WebServlet({ "/LoadPCDServlet", "/loadPCDServlet" })
@SuppressWarnings("all")
public class LoadPCDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //根据pid查询所有的子级集合
		String pid=request.getParameter("pid");
		LoadService service=new LoadServiceImp();
		List<PCD>pcdList=service.load(pid);
		//将java对象即pcdList转换成json对象
		JSONSerializer Json=new JSONSerializer();
		Json=Json.exclude("class","pid");//移出json字符串中不要的数据
		String json=Json.serialize(pcdList);
		//把json写进前台
		response.getWriter().write(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
	}

}
