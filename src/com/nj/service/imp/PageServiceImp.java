package com.nj.service.imp;

import java.util.List;

import com.nj.dao.GoodDao;
import com.nj.dao.PageDao;
import com.nj.dao.imp.GoodDaoImp;
import com.nj.dao.imp.PageDaoImp;
import com.nj.dom.Goods;
import com.nj.dom.Page;
import com.nj.dom.Searchgoods;
import com.nj.service.PageService;
@SuppressWarnings("all")
public class PageServiceImp implements PageService {
//查询分页对象
	@Override
	public void queryPage(Page page) {
		// TODO Auto-generated method stub
		//获取总记录数
		GoodDao goods=new GoodDaoImp();
	   int count=goods.getCount();
	    //如果总记录数为0,直接返回，不为0，则获取总页数
	   if(count==0)
	   {
		   return;
	   }
	    page.setRecord(count);
		//获取总页数
	    int srecord=page.getSinglerecord();//每页的记录
	    int totalpage= count%srecord==0 ? count/srecord:count/srecord+1;
	    page.setTotal(totalpage);
	    //判断当前页是否合法，不合法需要强制更正
	    if(page.getCurrent()<1)
	    {
	    	page.setCurrent(1);
	    }
	    //判断当前页是否大于总页数，如果大于，要更正
	    if(page.getCurrent()>totalpage)
	    {
	    	page.setCurrent(totalpage);
	    }
		
		//计算每页的起始数据
		int startpage=(page.getCurrent()-1)*srecord;
		//显示每页的数据
		PageDao dao=new PageDaoImp();
		List result= dao.querypage(startpage,srecord);
		page.setResult(result);//数据保存到page实体类中
		
		/*//设置起始页和尾页
		page.setStart(1);
		page.setEnd(totalpage);*/
	}
//模糊查询
@Override
public void searchqueryPage(Searchgoods s) {
	// TODO Auto-generated method stub
	//获取总记录数
	GoodDao goods=new GoodDaoImp();
    int count=goods.getCount(s.getGname());
    //如果总记录数为0,直接返回，不为0，则获取总页数
   if(count==0)
   {
	   return;
   }
    s.getPage().setRecord(count);
	//获取总页数
    int srecord= s.getPage().getSinglerecord();//每页的记录
    int totalpage= count%srecord==0 ? count/srecord:count/srecord+1;
    s.getPage().setTotal(totalpage);
    //判断当前页是否合法，不合法需要强制更正
    if( s.getPage().getCurrent()<1)
    {
    	 s.getPage().setCurrent(1);
    }
    //判断当前页是否大于总页数，如果大于，要更正
    if( s.getPage().getCurrent()>totalpage)
    {
    	 s.getPage().setCurrent(totalpage);
    }
	
	//计算每页的起始数据
	int startpage=( s.getPage().getCurrent()-1)*srecord;
	//显示每页的数据
	PageDao dao=new PageDaoImp();
	List result= dao.querysearchpage(startpage,srecord,s.getGname());
	 s.setList(result);//数据保存到Searchgoods实体类中
	
}
//分类查询
@Override
public void querygt(Searchgoods s) {
	//获取总记录数
		GoodDao goods=new GoodDaoImp();
	    int count=goods.getCountType(s.getGname());
	    //如果总记录数为0,直接返回，不为0，则获取总页数
	   if(count==0)
	   {
		   return;
	   }
	    s.getPage().setRecord(count);
		//获取总页数
	    int srecord= s.getPage().getSinglerecord();//每页的记录
	    int totalpage= count%srecord==0 ? count/srecord:count/srecord+1;
	    s.getPage().setTotal(totalpage);
	    //判断当前页是否合法，不合法需要强制更正
	    if( s.getPage().getCurrent()<1)
	    {
	    	 s.getPage().setCurrent(1);
	    }
	    //判断当前页是否大于总页数，如果大于，要更正
	    if( s.getPage().getCurrent()>totalpage)
	    {
	    	 s.getPage().setCurrent(totalpage);
	    }
		
		//计算每页的起始数据
		int startpage=( s.getPage().getCurrent()-1)*srecord;
		//显示每页的数据
		PageDao dao=new PageDaoImp();
		List result= dao.querygt(startpage,srecord,s.getGname());
		s.setList(result);//数据保存到Searchgoods实体类中
	
}


}
