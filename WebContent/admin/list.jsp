<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>会员列表</TITLE> 
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<style type="text/css">
.u{
width:98%;border-top:1px solid #1C86EE;border-right:1px solid #1C86EE;
border-left:1px solid #1C86EE;border-bottom:1px solid #1C86EE;
box-shadow: 1px 0px 16px #1C86EE; border-radius:5px 5px 5px 5px;margin-bottom: 10px;

}
.utd{
text-align: center;padding-top: 2px;padding-bottom: 2px;
}
 table tr:hover{background-color:#B0E2FF;}
 a:HOVER {
	color:red;
}
</style>
   <%--删除会员 --%>
    <script type="text/javascript">
    function del(uid)
    {
    	if(confirm("你想确认删除吗？"))
    	{
    		location.href="${pageContext.request.contextPath}/UserDetServlet?id="+uid;
    	}
    }
    </script>
</HEAD>
<BODY>

<div class="u" target="main">
<div style="width:98%;padding-left:10px;background-color:#CAE1FF;font-weight: bold;  color: #000000;line-height: 20px" >查询会员</div>
	<div>
	<form method="get" id="newsletterform"
			action="${pageContext.request.contextPath}/SearchUserServlet">
			<input name="search" style="width: 20%; margin-top: 5px;margin-bottom: 5px;margin-left: 10px;
			border-color:#C4C4C4;" />
				<input width="50px" type="submit" value="查询" />
			</span>
	</form>
</div>	
<p style="width:98%;padding-left:10px;background-color:#CAE1FF;font-weight: bold;  color: #000000;line-height: 20px">
当前位置：会员管理 &gt; 查看会员列表</p></br>

<div>  
<table width="98%" border="1px" cellspacing="0" cellpadding="0" align="center"> 
<tr style="background-color: #C4C4C4"> 
<td width="100"  class="utd">用户名</td> 
<td width="112" class="utd">昵称</td> 
<td width="112" class="utd">密码</td> 
<td width="100" class="utd">操作</td> 
</tr> 
<c:if test="${not empty ulist }">
<c:forEach items="${ulist }" var="ul">
<tr> 

<td  class="utd">${ul.username }</td> 
<td  class="utd">${ul.nickname }</td> 
<td  class="utd">${ul.password }</td>
<td  class="utd"><a href="javascript:del(${ul.id });" >删除</a></td>
</tr> 
</c:forEach>
</c:if> 

<c:if test="${empty ulist }">
<div class="cart_null" >
		  没有会员！！
		</div>
</c:if>
</table> </div></div>

</BODY>
</HTML>
