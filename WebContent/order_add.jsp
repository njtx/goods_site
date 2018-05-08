<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">

<head>
    <%@include file="inc/common_head.jsp"%>
   <script type="text/javascript">
    // 获取XMLHttpRequest对象
function getXMLHttpRequest() {
	var xmlhttp;
	// code for IE7+, Firefox, Chrome, Opera, Safari
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	}
	// code for IE6, IE5
	else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}
//页面加载完成后，使用ajax加载省市县信息
window.onload=function(){
	load("province","0");
	
}
//加载省市县的所有信息的方法
function load(target,pid)
{
	// 1. 获取XMLHttpRequest对象
	var xmlhttp = getXMLHttpRequest();
	// 获取省市县的下拉框
	var target = document.getElementById(target);
	 target.options.length=1;//清空下拉框中选项值
	//判断选项的有效值,如果pid为空，就直接停止
	 if(!pid) return;
	// 2. 监听服务器返回状态
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			// 获取后台返回的结果
			var result = xmlhttp.responseText;
			// 获取所有的省份信息，以json字符串的形式获取，注意：arr为数组
			var arr=eval("("+result+")");
			//遍历数组
			for(var i in arr)
			{
				var p=arr[i];
				//创建option对象，指定结点值并放入到下拉框中
				var opt=document.createElement("option");
				opt.setAttribute("value",p.id);
				opt.innerHTML=p.name;
				target.appendChild(opt);
			}
		}
	}
	//3. 打开连接
	xmlhttp.open("POST", "${pageContext.request.contextPath}/loadPCDServlet", true);
	// 使用表单的方式 POST 数据
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	// 4. 发送请求
	xmlhttp.send("pid="+pid);
	}
//获取市的下拉框中的选项
function loadCity(pid){
	document.getElementById("district").options.length = 1;//清空县的选择项
	load("city",pid);
	}
//获取县的下拉框中的选项
function loadDist(pid){
	load("district",pid);
}
</script>
</head>

<%@include file="inc/common_body_top.jsp"%>
<!-- 生成订单表单 -->
<!-- 收货人表单 -->
<form action="${pageContext.request.contextPath }/SubmitOrderServlet" method="post">
	<table>
		<tr>
			<td style="text-align:right;">所在区域 <font color=red>*</font></td>
			<td>
				<!-- 省 -->
				<select id="province" onchange="loadCity(value);
				document.getElementById('provincename').value=options[selectedIndex].innerHTML;" >
					<option value="" >-- 请选择省 --</option>
				</select>&nbsp;&nbsp;&nbsp;
				<input type="hidden" name="p" id="provincename" /> 
				<!-- 市 -->
				<select id="city" onchange="loadDist(value);
				document.getElementById('city_name').value=options[selectedIndex].innerHTML;">
					<option value="" >-- 请选择市 --</option>
				</select>&nbsp;&nbsp;&nbsp;
				<input type="hidden" name="c" id="city_name" />
				<!-- 县(区) -->
				<select id="district" onchange="document.getElementById('district_name').value=options[selectedIndex].innerHTML;">
					<option value="">-- 请选择县(区) --</option>
				</select>
				<input type="hidden" id="district_name" name="d">
			</td>
		</tr>
		<tr>
			<td style="text-align:right;">详细地址 <font color=red>*</font></td>
			<td>
				<input name="address" style="width:318px;" type="text"/>
			</td>
		</tr>
		<tr>
			<td style="text-align:right;">邮政编码</td>
			<td><input name="zipcode" /></td>
			
		</tr>
		<tr>
			<td style="text-align:right;">收货人姓名 <font color=red>*</font></td>
			<td><input name="reciver"/></td>
		</tr>
		<tr>
			<td style="text-align:right;">手机号码 <font color=red>*</font></td>
			<td><input name="telephone"  /></td>
		</tr>
	</table>
	<!-- 购物车中商品信息 -->
	<h3>购物车信息</h3>
	<div class="shopping_list_border">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr class="shopping_list_title">
		<td class="#" align="center">商品</td>
			<td class="shopping_list_title_1">商品名</td>
			<td class="shopping_list_title_2">单品积分</td>
			<td class="shopping_list_title_3">市场价</td>
			<td class="shopping_list_title_4" >Goods打折价</td>
			<td class="shopping_list_title_5">数量</td>
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
				
				<input value="${c.cartNum }"  width="100px" style="background-color:#CCCCCC"/>
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
				<li class="shopping_list_end_1"></li>
				<li class="shopping_list_end_2">您共节省：<span>￥${jiesheng }元</span></li>
				<li class="shopping_list_end_3">商品金额总计：<span>￥${total }元</span></li>
			</ul>
		</div>
	</div>
	<input style="margin:0px 0px 0px 560px;font-size: 15px" type="submit" value="提交订单" />
</form>
<!-- 生成订单结束 -->
<%@include file="inc/common_body_bottom.jsp"%>
</html>