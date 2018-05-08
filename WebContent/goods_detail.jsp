<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">
<head>
    <%@include file="inc/common_head.jsp"%>
</head>

<%@include file="inc/common_body_top.jsp"%>
<!-- 商品详情-->
<h1 style="color: #D2B487;margin:10px 10px 10px 10px" >商品详细信息</h1>
<img src="${pageContext.request.contextPath }${goods.goodPath}" align="left" width="160" height="175" style="margin-right: 20px"/>
<h2 style="color: #DEB887">名称：${goods.goodName }</h2>
<h4 style="color: #D2B487">分类：${goods.goodType }</h4>
<h4 style="color: #D2B487">市场价：<font color="gray" style="text-decoration: line-through;">￥${goods.goodPrice }</font></h4>
<h4 style="color: #D2B487">优惠价：<font color="red">￥${goods.goodYprice }</font></h4>
<h4 style="color: #D2B487">库存量：<font color="green"> ${goods.goodNum}</font></h4>
<p style="text-indent: 2em;line-height: 20px;letter-spacing: 1px;width: 600px;font-size: 14px;font-family: '宋体' ;">
<b>描述：</b>${goods.goodDescript }</p>
<br clear="left"/>
<img src="resource/images/product_buy_01.gif" style="cursor:pointer;" align="right"
 onclick="location.href='${pageContext.request.contextPath }/buyGoodServlet?id='+${goods.goodId };"/>
<!-- 商品详情结束 -->
<%@include file="inc/common_body_bottom.jsp"%>
</html>