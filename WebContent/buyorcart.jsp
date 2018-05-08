<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">

<head>
    <%@include file="inc/common_head.jsp"%>
</head>

<%@include file="inc/common_body_top.jsp"%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr class="shopping_product_list" id="shoppingProduct_06">
	   <td class="shopping_product_list_2">
		<!-- 显示提示信息 -->
		<font color="red">${msg}</font>
		<!-- 提示继续购物  应该是跳转到查询所有商品的Servlet程序-->
		<a href="${pageContext.request.contextPath}/queryGoodServlet" >继续购物</a>
	   </td>
	</tr>
	<tr class="shopping_product_list" id="shoppingProduct_06">
		<td class="shopping_product_list_3">
			<!-- 提示查看购物车 -->
			<a href="${pageContext.request.contextPath}/queryCartServlet">查看购物车</a>
		</td>
	</tr>
</table>
<%@include file="inc/common_body_bottom.jsp"%>
</html>