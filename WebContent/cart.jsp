<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">

<head>
    <%@include file="inc/common_head.jsp"%>
    <%--改变购物车商品数量，利用gid,cartNum --%>
    <script type="text/javascript">
     function changeNum(gid,cartNum)
     {
    	 location.href="${pageContext.request.contextPath}/cartChangeServlet?gid="+gid+
    			 "&cartnum="+cartNum;
     }
    </script>
   <%--删除商品 --%>
    <script type="text/javascript">
    function del(gid)
    {
    	if(confirm("你想确认删除吗？"))
    	{
    		location.href="${pageContext.request.contextPath}/cartDeleteServlet?id="+gid;
    	}
    }
    </script>
</head>

<%@include file="inc/common_body_top.jsp"%>
<!-- 购物车列表 -->
<div class="shopping_list_top">您已选购以下商品</div><br/>
<div class="shopping_list_border">
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="table-layout:fixed">
		<tr class="shopping_list_title">
		<td class="#" align="center">商品</td>
			<td class="shopping_list_title_1">商品名</td>
			<td class="shopping_list_title_2">单品积分</td>
			<td class="shopping_list_title_3">市场价</td>
			<td class="shopping_list_title_4" >Goods打折价</td>
			<td class="shopping_list_title_5">数量</td>
			<td class="shopping_list_title_6">操作</td>
		</tr>
		<c:choose>
		<c:when test="${ empty clist}">
		<div class="cart_null" >
		  您的购物车没有商品，请亲去<a href="${pageContext.request.contextPath }/queryGoodServlet"><big>逛逛</big></a>哦！
		</div></c:when>
		<c:otherwise>
		<c:set var="jiesheng" value="0"/>
	    <c:set var="total" value="0"/>
		<c:forEach items="${clist }" var="c">
		
		<tr class="shopping_product_list" id="shoppingProduct_01">
		    <td class="#">
		    <img width="80px" height="80px" src="${pageContext.request.contextPath}${c.goods.goodPath }"/>
			</td>
			<td class="shopping_product_list_1" >
			 <a href="${pageContext.request.contextPath }/GoodDetailServlet?gid=${c.goods.goodId}" 
			 class="blue">${c.goods.goodName }</a>
			</td>
			<td class="shopping_product_list_2">
			<fmt:formatNumber maxFractionDigits="0" minFractionDigits="0"
			  value="${c.goods.goodYprice }"/> 积分</td>
			<td class="shopping_product_list_3">￥${c.goods.goodPrice }</td>
			<td class="shopping_product_list_4">￥${c.goods.goodYprice}(<fmt:formatNumber maxFractionDigits="2" minFractionDigits="2"
			 value=" ${c.goods.goodYprice/c.goods.goodPrice*100 }"/>折)</td>
			<td class="shopping_product_list_5">
				
				<input value="${c.cartNum }" onblur="changeNum(${c.gid},this.value);" width="100px"/>
			</td>
			<td class="shopping_product_list_6">
			<!-- a标签的href属性中，可以执行js脚本，使用javascript:脚本
					在script标签中可以怎么写，这个脚本就可以怎么写
					
					而标签中的以on开头的事件，则不需要加javascript:脚本，而是直接写脚本
				 -->
			<a href="javascript:del(${c.gid });" class="blue">删除</a>
				
			</td> 
			</tr>
			<c:set var="jiesheng" value="${jiesheng+(c.goods.goodPrice-c.goods.goodYprice)*c.cartNum }"/>
		    <c:set var="total" value="${total+c.goods.goodYprice*c.cartNum }"/>
			</c:forEach>
	  </c:otherwise>
   </c:choose>
	</table>  
	<div class="shopping_list_end">
		 <ul>
		  
			 <li class="shopping_list_end_1">
			  <c:if test="${empty clist}">
				<input type="image" src="resource/images/shopping_balance.gif"
				 onclick="alert('购物车不能为空，请亲先去逛逛哦！');"/>
				 </c:if>
			  <c:if test="${not empty clist}">
				<input type="image" src="resource/images/shopping_balance.gif"
				 onclick="window.location='order_add.jsp';"/>
				 </c:if>
			 </li>
			
			<li class="shopping_list_end_2">您共节省：<span>￥${jiesheng }元</span></li>
			<li class="shopping_list_end_3">商品金额总计：<span>￥${total }元</span></li>
		 </ul>
		
	</div>
</div>
	    
<!-- 购物车列表结束 -->
<%@include file="inc/common_body_bottom.jsp"%>
</html>