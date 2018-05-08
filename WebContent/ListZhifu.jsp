<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">

<head>
 <script type="text/javascript">
      function del2(orderID)
      {
      		location.href="${pageContext.request.contextPath }/deleteOrdersServlet?oid="+orderID;
      }
     </script>
    <%@include file="inc/common_head.jsp"%>
</head>

<%@include file="inc/common_body_top.jsp"%>
<!-- 订单列表 -->
<table style="border-collapse:collapse;">
<c:if test="${empty olist }">
  当前没有已支付订单信息，请先<a href="${pageContext.request.contextPath }/queryGoodServlet"><big>购买商品</big></a>
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
			<font color="red">已支付</font>&nbsp;
			<a href="javascript:del2('${o.orderID }');" class="blue">删除</a>
		</td>
	</tr>
	<tr >
		<td style="text-align:right;">收货人信息：</td>
		<td>${o.orderAddress }</td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="table-layout:fixed">
	
		<tr >
		<td style="text-align:right;padding-bottom: 10px"></td>
		</tr>
			<tr class="shopping_list_title">
		<td class="#" align="center">商品</td>
			<td class="shopping_list_title_1">商品名</td>
			<td class="shopping_list_title_2">单品积分</td>
			<td class="shopping_list_title_3">市场价</td>
			<td class="shopping_list_title_4" >Goods打折价</td>
			<td class="shopping_list_title_5">数量</td>
		</tr>
		 <c:choose>
	<c:when test="${ empty olist}">
		<div class="cart_null" >
		  当前没有支付订单信息，请先<a href="${pageContext.request.contextPath }/queryGoodServlet"><big>购买商品</big></a>
		</div>
	</c:when>
		<c:otherwise>
		<c:forEach items="${clist }" var="c">
		<tr class="shopping_product_list" id="shoppingProduct_01">
		    <td class="#">
		    <img width="80px" height="80px" src="${pageContext.request.contextPath}${c.goods.goodPath }"/>
			</td>
			<td class="shopping_product_list_1" >
			 <a href="${pageContext.request.contextPath }/GoodDetailServlet?gid=${c.goods.goodId}" class="blue">${c.goods.goodName }</a>
			</td>
			<td class="shopping_product_list_2" >
			<fmt:formatNumber maxFractionDigits="0" minFractionDigits="0"
			  value="${c.goods.goodYprice }"/> 积分</td>
			<td class="shopping_product_list_3">￥${c.goods.goodPrice }</td>
			<td class="shopping_product_list_4" style="width:130px;" >￥${c.goods.goodYprice}(<fmt:formatNumber maxFractionDigits="2" minFractionDigits="2"
			 value=" ${c.goods.goodYprice/c.goods.goodPrice*100 }"/>折)</td>
			<td class="shopping_product_list_5">
				<input value="${c.cartNum }" onblur="changeNum(${c.gid},this.value);" width="100px" readonly="readonly" style="background-color: #CCC"/>
			</td>
			
			</tr>
			</c:forEach>
	  </c:otherwise>
   </c:choose>
	  </c:forEach>
	 </c:if>
	 <tr >
		<td style="text-align:right;padding-bottom: 20px"></td>
		</tr>
</table>
<!-- 确认支付表单结束 -->
<%@include file="inc/common_body_bottom.jsp"%>
</html>