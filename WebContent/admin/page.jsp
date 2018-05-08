<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  function gopage(page)
  {
	  location.href="${pageContext.request.contextPath }/queryGoodsServlet?current="+page;
  }
</script>
</head>
<body>
	<!--分页栏-->
	<div>
	<c:if test="${page.current>1}">
		<a href="javascript:gopage(${1});" >首页</a> 
		<a href="javascript:gopage(${page.current-1});" >上一页</a>
	 </c:if>
		当前<span style="color: red">${page.current }/${page.total }</span>页&nbsp;
		<c:if test="${page.total>page.current }">
		<a href="javascript:gopage(${page.current+1 } );" >下一页</a> 
		<a href="javascript:gopage(${page.total } );">尾页</a>
	</c:if>
		
	</div>

</body>
</html>