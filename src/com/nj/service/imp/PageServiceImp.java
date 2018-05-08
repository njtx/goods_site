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
//��ѯ��ҳ����
	@Override
	public void queryPage(Page page) {
		// TODO Auto-generated method stub
		//��ȡ�ܼ�¼��
		GoodDao goods=new GoodDaoImp();
	   int count=goods.getCount();
	    //����ܼ�¼��Ϊ0,ֱ�ӷ��أ���Ϊ0�����ȡ��ҳ��
	   if(count==0)
	   {
		   return;
	   }
	    page.setRecord(count);
		//��ȡ��ҳ��
	    int srecord=page.getSinglerecord();//ÿҳ�ļ�¼
	    int totalpage= count%srecord==0 ? count/srecord:count/srecord+1;
	    page.setTotal(totalpage);
	    //�жϵ�ǰҳ�Ƿ�Ϸ������Ϸ���Ҫǿ�Ƹ���
	    if(page.getCurrent()<1)
	    {
	    	page.setCurrent(1);
	    }
	    //�жϵ�ǰҳ�Ƿ������ҳ����������ڣ�Ҫ����
	    if(page.getCurrent()>totalpage)
	    {
	    	page.setCurrent(totalpage);
	    }
		
		//����ÿҳ����ʼ����
		int startpage=(page.getCurrent()-1)*srecord;
		//��ʾÿҳ������
		PageDao dao=new PageDaoImp();
		List result= dao.querypage(startpage,srecord);
		page.setResult(result);//���ݱ��浽pageʵ������
		
		/*//������ʼҳ��βҳ
		page.setStart(1);
		page.setEnd(totalpage);*/
	}
//ģ����ѯ
@Override
public void searchqueryPage(Searchgoods s) {
	// TODO Auto-generated method stub
	//��ȡ�ܼ�¼��
	GoodDao goods=new GoodDaoImp();
    int count=goods.getCount(s.getGname());
    //����ܼ�¼��Ϊ0,ֱ�ӷ��أ���Ϊ0�����ȡ��ҳ��
   if(count==0)
   {
	   return;
   }
    s.getPage().setRecord(count);
	//��ȡ��ҳ��
    int srecord= s.getPage().getSinglerecord();//ÿҳ�ļ�¼
    int totalpage= count%srecord==0 ? count/srecord:count/srecord+1;
    s.getPage().setTotal(totalpage);
    //�жϵ�ǰҳ�Ƿ�Ϸ������Ϸ���Ҫǿ�Ƹ���
    if( s.getPage().getCurrent()<1)
    {
    	 s.getPage().setCurrent(1);
    }
    //�жϵ�ǰҳ�Ƿ������ҳ����������ڣ�Ҫ����
    if( s.getPage().getCurrent()>totalpage)
    {
    	 s.getPage().setCurrent(totalpage);
    }
	
	//����ÿҳ����ʼ����
	int startpage=( s.getPage().getCurrent()-1)*srecord;
	//��ʾÿҳ������
	PageDao dao=new PageDaoImp();
	List result= dao.querysearchpage(startpage,srecord,s.getGname());
	 s.setList(result);//���ݱ��浽Searchgoodsʵ������
	
}
//�����ѯ
@Override
public void querygt(Searchgoods s) {
	//��ȡ�ܼ�¼��
		GoodDao goods=new GoodDaoImp();
	    int count=goods.getCountType(s.getGname());
	    //����ܼ�¼��Ϊ0,ֱ�ӷ��أ���Ϊ0�����ȡ��ҳ��
	   if(count==0)
	   {
		   return;
	   }
	    s.getPage().setRecord(count);
		//��ȡ��ҳ��
	    int srecord= s.getPage().getSinglerecord();//ÿҳ�ļ�¼
	    int totalpage= count%srecord==0 ? count/srecord:count/srecord+1;
	    s.getPage().setTotal(totalpage);
	    //�жϵ�ǰҳ�Ƿ�Ϸ������Ϸ���Ҫǿ�Ƹ���
	    if( s.getPage().getCurrent()<1)
	    {
	    	 s.getPage().setCurrent(1);
	    }
	    //�жϵ�ǰҳ�Ƿ������ҳ����������ڣ�Ҫ����
	    if( s.getPage().getCurrent()>totalpage)
	    {
	    	 s.getPage().setCurrent(totalpage);
	    }
		
		//����ÿҳ����ʼ����
		int startpage=( s.getPage().getCurrent()-1)*srecord;
		//��ʾÿҳ������
		PageDao dao=new PageDaoImp();
		List result= dao.querygt(startpage,srecord,s.getGname());
		s.setList(result);//���ݱ��浽Searchgoodsʵ������
	
}


}
