<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顶部</title>
<style type=text/css>
body {
	padding-right: 0px;
	padding-left: 0px;
	padding-bottom: 0px;
	margin: 0px;
	padding-top: 0px;
	background-color: #2a8dc8
}

body,td,div,p{
	font-size: 12px;
	color: #003366;
	font-family: verdana, arial, helvetica, sans-serif
}
.top{
  background-image: url('../admin/images/new_002.jpg');
  background-repeat: repeat;
}
</style>

<meta content="mshtml 6.00.2900.3492" name=generator>
</head>
<body>
	<form id=form1 name=form1 action="" method=post>
		<table cellspacing=0 cellpadding=0 width="100%" border=0>
			<tbody>
				<tr>
					<td width=10><img src="images/new_001.jpg" border=0></td>
					<td class="top"><font size=5><b>商品管理系统v1.0</b></font></td>
					<td class="top">
						<table cellspacing=0 cellpadding=0 width="100%" border=0>
							<tbody>
								<tr>
									<td  height=35 align=right></td>
								</tr>
								<tr><c:if test="${not empty adminLogin   }">
									<td height=35 align=right >
										当前用户:<b>${adminLogin.username }</b>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="${pageContext.request.contextPath }/InfoAdminServlet" target=main><font color=red>修改密码</font></a>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="${pageContext.request.contextPath }/admin/login.jsp" target=_top><font color=red>安全退出</font></a>
									</c:if>
									</td>
									<td height=35 align=right>
									<c:if test="${empty adminLogin   }">
									<a href="${pageContext.request.contextPath }/admin/login.jsp" target=main><font><strong>登录</strong></font></a>
										&nbsp;&nbsp;&nbsp;&nbsp;
									</c:if>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td width=10><img src="images/new_003.jpg" border=0></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>