<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script language="JavaScript" type="text/javascript">
    var s=[null,null,
    ["电脑、办公","家用电器","手机数码"],null];
    function gets(){
     var slttype=document.getElementById("type");
     var sltshuma=document.getElementById("s");
     var ts=s[slttype.selectedIndex-1];
     sltshuma.length=1;
     for(var i=0;i<ts.length;i++){
    	 sltshuma[i+1]=new Option(ts[i],ts[i]);
     }
    }
    function del(gid)
    {
    	if(confirm("你想确认删除吗？"))
    	{
    		location.href="${pageContext.request.contextPath}/goodsDeleteServlet?id="+gid;
    	}	
	}
    
    function getGoodId(gid)
    {
	  location.href="${pageContext.request.contextPath}/InfoGoodServlet?id="+gid;	
	}
    //查看商品描述
    function query(gid)
    {
	  location.href="${pageContext.request.contextPath}/queryGoodbyId?id="+gid;	
	}
    </script>
<style type="text/css">
.u{
width:98%;border-top:1px solid #1C86EE;border-right:1px solid #1C86EE;
border-left:1px solid #1C86EE;border-bottom:1px solid #1C86EE;
box-shadow: 1px 0px 16px #1C86EE; border-radius:5px 5px 5px 5px;margin-bottom: 20px;

}
#di table td{
text-align: center;padding-top: 2px;padding-bottom: 2px;
}
 table tr:hover{background-color:#B0E2FF;}
 a:HOVER {
	color:red;
}</style>
</head>
<body>
<html>



<body>
<div class="u" target="main">
<p style="margin-top:0px;width:98%;padding-left:10px;background-color:#CAE1FF;font-weight: bold;  color: #000000;line-height: 20px">
当前位置：商品管理 &gt; 查看商品列表</p></br>
<div>
 <c:if test="${empty page.list }">
当前没有任何商品，请进行 <a href="${pageContext.request.contextPath}/admin/add.jsp" style="text-decoration:none;">
添加商品
 </a>!
</c:if>

<div>
<div style="width: 300px;float: left;">
<form method="get" id="newsletterform" action="${pageContext.request.contextPath}/SearchGoodsServlet"> 
		<span style="margin-left: 10px;font-size: '黑体'"><b>商品:</b></span>
		<span><input name="search" style="width: 150px; margin-top: 5px;margin-bottom: 5px;margin-left: 10px;
		border-color:#C4C4C4;
		" />
	<input width="50px" type="submit" value="查询" />
</span>
</form>
</div>
<div style="float: right;width: 400px;margin-right: 10px">
<form method="get"  action="${pageContext.request.contextPath}/GoodstTypeServlet">
 <select name="type" id="type" onchange="gets();">
  <option value="0" >--请选择--</option>
   <option value="服装" >服装 </option> 
      <option value="图书、电子书刊 " >图书、电子书刊 </option>
      <option value="电子数码" > 电子数码 </option>
      <option value=" 家居、家具、厨具 " > 家居、家具、厨具 </option>
 </select>
 <select id="s" name="s">
  <option value="0">--请选择--</option>
 </select>
<input type="submit" name="test" value="分类查询" > 
</form></div>
<div
style="width:80px;margin-left: 550px;margin-bottom:10px; background-color:#CAE1FF;border-color:#C4C4C4;border:1px solid normal; padding: 10px 10px 10px 10px;">
 <a href="${pageContext.request.contextPath}/admin/add.jsp" style="text-decoration:none;">
<b>+</b>添加商品</div>
 </a> 
</div>
</div>
<c:if test="${not empty page.list }">
<div id="di">  
<table width="98%" border="1px" cellspacing="0" cellpadding="0" align="center"> 
<tr style="background-color: #CAE1FF"> 
<td width="100" >图片</td> 
<td width="100" >商品名称</td> 
<td width="112" >市场价</td> 
<td width="112" >优惠价</td> 
<td width="100" >商品描述</td> 
<td width="100" >库存量</td> 
<td width="100" >商品类别</td> 
<td width="100" >操作</td>
</tr> 

<c:forEach items="${page.list }" var="g">
<tr> 

<td >
<img width="70px" height="60px" src="${pageContext.request.contextPath}${g.goodPath }"/>
</td> 
<td style="font-size: 14px">${g.goodName }</td> 
<td style="font-size: 14px">￥${g.goodPrice }元</td>
<td style="font-size: 14px">￥${g.goodYprice }元</td> 
<td style="font-size: 14px">
<c:if test="${ fn:length(g.goodDescript) > 20 }">
<a href="javascript:query(${g.goodId });">${fn:substring(g.goodDescript, 0, 20) }...</a>
 </c:if>
<c:if test="${ fn:length(g.goodDescript) <= 20 }">
${g.goodDescript}
</c:if>
<%-- <textarea style="resize:none;width:200px; height:50px;font-size: 12px;">${g.goodDescript }</textarea></td> --%> 
<td style="font-size: 14px">${g.goodNum }</td>
<td style="font-size: 14px">${g.goodType }</td>
<td style="font-size: 14px">
<a href="javascript:getGoodId(${g.goodId});">修改</a>|
<a href="javascript:del(${g.goodId });" >删除</a></td>
</tr> 
</c:forEach>
</table> </div>
<div style="margin: 10px 10px 10px 0">
<!-- 分页控件 -->
	<center>
	  <%@include file="/admin/searchpage.jsp"%>
	 </center> 
</div>
</c:if>
</body>
</html>