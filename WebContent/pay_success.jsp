<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">

<head>
  <script type="text/javascript">
      function del(orderID)
      {
    	  
      location.href="${pageContext.request.contextPath }/UpdateOrdersServlet?oid="+orderID; 
    	 /*  location.href="${pageContext.request.contextPath }/UpdateOrdersServlet"; */
      	
      }
    </script> 
    <%@include file="inc/common_head.jsp"%>
</head>

<%@include file="inc/common_body_top.jsp"%>
<h1><font color="red">支付成功！</font></h1>
<h4><a href="javascript:del('${oid }');">请返回已支付订单页面！</a></h4>
<%@include file="inc/common_body_bottom.jsp"%>
</html>