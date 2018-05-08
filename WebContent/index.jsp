<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  <div class="index">
  <div class="art-postmetadataheader">
		<h2 class="art-postheader">热卖商品</h2>
	</div>
<!-- start table -->
		<div class="art-content-layout overview-table">
			<div class="art-content-layout-row" >
				<c:forEach items="${gList }" var="g"> 
				<div class="art-layout-cell">
					<div class="overview-table-inner">
					<h4>${g.goodName }</h4>
						<img src="${pageContext.request.contextPath}${g.goodPath }"
						 width="80px" height="80px" class="image" />
							<!-- alt="an image" --> 
						<p>价格: ${g.goodPrice }</p>
						<a href="${pageContext.request.contextPath }/goodDetailServlet?gid=${g.goodId }"><p>速速抢购</p></a>
					</div>
				</div>
				 </c:forEach> 
				</div>
				</div>
	 <div class="art-postmetadataheader">
		<h2 class="art-postheader">销量冠军</h2>
	</div>
<!-- start table -->
		<div class="art-content-layout overview-table">
			<div class="art-content-layout-row" >
			<c:forEach items="${gList }" var="g"> 
			<div class="art-layout-cell">
			<div class="overview-table-inner">
			<h4>${g.goodName }</h4>
			<img src="${pageContext.request.contextPath}${g.goodPath }"
			 width="80px" height="80px" class="image" />
				<!-- alt="an image" --> 
			<p>价格: ${g.goodPrice }</p>
			<a href="${pageContext.request.contextPath }/goodDetailServlet?gid=${g.goodId }"><p>速速抢购</p></a>
				</div>
			</div>
				 </c:forEach> 
				</div>
				</div>			
	</div>
<%@include file="inc/common_body_bottom.jsp"%> 
</html>

