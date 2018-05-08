<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">
<head>
    <%@include file="inc/common_head.jsp"%>
    <script type="text/javascript">
    function buycart(gid)
    {
	  location.href="${pageContext.request.contextPath}/buyGoodServlet?id="+gid;	
	}
    </script>
    
</head>

<%@include file="inc/common_body_top.jsp"%>
<!-- 产品列表 -->
<div class="product_storyList_content">
<c:if test="${empty page.result }">
当前没有任何商品
    <!-- 分页控件 -->
	<center>
	  <%@include file="page.jsp"%>
	 </center>
</c:if>
	<!-- 列表开始 -->
	<c:if test="${not empty page.result }">
	<c:forEach items="${page.result }" var="g">
	  <div class="product_storyList_content_left" style="margin-right: 40px">
		<img width="100px" height="100px"  src="${pageContext.request.contextPath}${g.goodPath }"/>
	</div> 
	<div class="product_storyList_content_right" >
		<ul>
			<li class="product_storyList_content_dash">
			<a href="${pageContext.request.contextPath }/goodDetailServlet?gid=${g.goodId }" 
			class="blue_14"><Strong>${g.goodName } </Strong></a>
			</li>
			<li>库存情况：${g.goodNum<=0 ? "缺货" : "有货 " }</li>
			<li>
				<dl class="product_content_dd">
					<dd>原价：￥<span class="product_content_delete">${g.goodPrice }</span></dd>
				</dl>
			</li>
		</ul>
		<div style="margin-bottom:10px;text-align:right;">
		 <img src="resource/images/product_buy_01.gif" style="cursor:pointer;"
		  onclick="buycart(${g.goodId});" /></div>
	  </div>
	</c:forEach></c:if>
	<div class="product_storyList_content_bottom"></div>
	<!-- 列表结束 -->
	<!-- 分页控件 -->
	<center>
	  <%@include file="page.jsp"%>
	 </center>
</div>
<!-- 产品列表结束 -->
<%@include file="inc/common_body_bottom.jsp"%>
</html>