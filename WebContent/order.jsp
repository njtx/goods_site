<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">

<head>
    <%@include file="inc/common_head.jsp"%>
    <script type="text/javascript">
      function del(orderID)
      {
    	  if(confirm("你确定取消订单吗？"))
      	{
      		location.href="${pageContext.request.contextPath }/deleteOrdersServlet?oid="+orderID;
      	}
      }
      function zhifu(orderState)
      {
      		location.href="${pageContext.request.contextPath }/NoZhifuServlet?state="+orderState;
      }
    </script>
</head>

<%@include file="inc/common_body_top.jsp"%>
<!-- 订单列表 -->
<table style="border-collapse:collapse;">
<c:if test="${empty olist }">
  当前没有订单信息，请先<a href="${pageContext.request.contextPath }/queryGoodServlet"><big>购买商品</big></a>
</c:if>
<c:if test="${not empty olist }">
<c:forEach items="${olist }" var="o">
	<tr>
		<td style="text-align:right;">订单编号：</td>
		<td>${o.orderID }</td>
	</tr>
	<tr>
		<td style="text-align:right;">订单金额：</td>
		<td><span style="color:red;">${o.orderMoney }</span></td>
	</tr>
	<tr>
		<td style="text-align:right;">下单用户：</td>
		<td>${sessionScope.loginUser.nickname}</td>
	</tr>
	<tr>
		<td style="text-align:right;">下单时间：</td>
		<td>${o.orderTime }</td>
	</tr>
	<tr>
		<td style="text-align:right;">支付状态：</td>
		<td>
		<input type="hidden" value="1" name="ostate">
			<c:if test="${o.orderState==1}">
			<font color="red">未支付</font>&nbsp;
			<a href="javascript:zhifu('${o.orderState }');">在线付款</a>&nbsp;
			<a href="javascript:del('${o.orderID }');" class="blue">取消订单</a>
			</c:if>
			<%-- <c:if test="${o.orderState==2}">
			<font color="red">已支付</font>&nbsp;
			<a href="javascript:del2('${o.orderID }');" class="blue">删除</a>
			</c:if>
			
			 --%>
		</td>
	</tr>
	<tr >
		<td>收货人信息：</td>
		<td>
		<p style="line-height: 20px;letter-spacing: 1px;font-size: 14px;font-family: '宋体';">
		${o.orderAddress }</p></td>
		</tr>
		<tr style="height:10px;"></tr>
		<tr style="height:1px; background-color:#cddbb8;" >
		 <td style="height:1px ;"/>
		 <td style="height:1px"/>
		 <td style="height:1px"/>
		</tr>
		<tr style="height:10px;"></tr>
	  </c:forEach>
	 </c:if>
</table>
<div class="cart_null" >
		 <a style="color: red;" href="${pageContext.request.contextPath }/queryZhifuGoodServlet"><big > 查看已支付订单</big></a>
		</div>
<!-- 订单结束
<div class="product_storyList_content_bottom"/> -->
<br>
<div class="shopping_list_top">未支付订单包含以下商品</div>
<div class="shopping_list_border">
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	 
		<tr class="shopping_list_title">
		    <td style="line-height: 30px;text-align: center;width: 80px">商品</td>
			<td style="line-height: 30px;text-align: center;width: 130px">商品名</td>
			<td class="shopping_list_title_2" width=130px>单品积分</td>
			<td class="shopping_list_title_3" width=120px>市场价</td>
			<td class="shopping_list_title_4" width=170px>商品打折价</td>
			<td class="shopping_list_title_5">数量</td>
		 </tr>
<c:choose>
	<c:when test="${ empty olist}">
		<div class="cart_null" >
		  当前没有订单信息，请先<a href="${pageContext.request.contextPath }/queryGoodServlet"><big>购买商品</big></a>
		</div></c:when>
		<c:otherwise>
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
				
				<input value="${c.cartNum }" readonly="readonly" style="background-color:#CCCCCC" width="100px"/>
			</td>
			<td class="shopping_product_list_6">
			</td> 
			</tr>
			</c:forEach>
	  </c:otherwise>
   </c:choose>
	</table>  
	 </div>

<!-- 订单列表结束 -->
<%@include file="inc/common_body_bottom.jsp"%>
</html>