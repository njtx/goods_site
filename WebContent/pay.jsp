<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">

<head>
    <%@include file="inc/common_head.jsp"%>
    <style type="text/css">
    	table tr td input{position: relative;top:-15px;}
    	.right {display:inline-block;width:70px;text-align:right;}
    </style>
</head>


<%@include file="inc/common_body_top.jsp"%>
<!-- 在线支付 -->
<form action="${pageContext.request.contextPath }/payServlet" method="post">
<c:forEach items="${olist }" var="o">
<table width="100%">
	<tr>  
		<td bgcolor="#F7FEFF" colspan="3">
			 <input type="hidden" name="orderid" value="${o.orderID }"/>
			<input type="hidden" name="money" value="99"/> -->
			<span class="right" style="margin-bottom: 10px"><b>订单号：</b></span>${o.orderID }<br/>
			<span class="right" style="margin-right: 10px"><b>支付金额：</b></span>${o.orderMoney }元
			<input type="hidden" name="orderstate" value="${o.orderState }"/>
		</td>
	</tr>
	<tr style="height:20px;"></tr>
	<tr><td colspan="3">请您选择在线支付银行</td></tr>
	<tr>
	  <td><input type="radio" name="pd_FrpId" value="CMBCHINA-NET"/>
	  <img src="resource/images/banklogo/CMBCHINA-NET.png" alt="招商银行" /></td>
	  <td><input type="radio" name="pd_FrpId" value="ICBC-NET"/>
	  <img src="resource/images/banklogo/ICBC-NET.png" alt="工商银行" /></td>
	  <td><input type="radio" name="pd_FrpId" value="ABC-NET"/>
	  <img src="resource/images/banklogo/ABC-NET.png" alt="农业银行" /></td>
	</tr>
	<tr>
	  <td><input type="radio" name="pd_FrpId" value="CCB-NET"/>
	  <img src="resource/images/banklogo/CCB-NET.png" alt="建设银行" /> </td>
	  <td><input type="radio" name="pd_FrpId" value="CMBC-NET"/>
	  <img src="resource/images/banklogo/CMBC-NET.png" alt="中国民生银行总行" /></td>
	   <td><input type="radio" name="pd_FrpId" value="BOCO-NET"/>
	  <img src="resource/images/banklogo/BOCO-NET.png" alt="交通银行" /></td>

	</tr>
	<tr style="height:30px;"></tr>
	<tr>
	  <td colspan="3" style="text-align:right;padding-right:33px;padding-top:15px;">
		<input type="submit" value="确定支付" />
	  </td>
	</tr>
	<tr style="height:10px;"></tr>
		<tr style="height:1px; background-color:#cddbb8;" >
		 <td style="height:1px ;"/>
		 <td style="height:1px"/>
		 <td style="height:1px"/>
		</tr>
		<tr style="height:10px;"></tr>
</table></c:forEach>
</form>
<!-- 在线支付结束 -->
<%@include file="inc/common_body_bottom.jsp"%>
</html>