<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <style type=text/css>
body {
	font-size: 12px;
	color: #ffffff;
	font-family: 宋体
}

td {
	font-size: 12px;
	color: #ffffff;
	font-family: 宋体
}
</style> 
</head>

<body>
	<form action="${pageContext.request.contextPath}/AdminLoginServlet" method=post target="_parent">
		<div id=updatepanel1>
			<div id=div1
				style="left: 0px; position: absolute; top: 0px; background-color: #0066ff"></div>
			<div id=div2
				style="left: 0px; position: absolute; top: 0px; background-color: #0066ff"></div>
			<div>&nbsp;&nbsp;</div>
			<div>
				<table cellspacing=0 cellpadding=0 width=900 align=center border=0>
					<tbody>
						<tr>
							<td style="height: 105px"><img src="images/login.jpg"
								border=0></td>
						</tr>
						<tr>
							<td background=images/login_2.jpg height=300>
								<table height=300 cellpadding=0 width=900 border=0>
									<tbody>
										<tr>
											<td colspan=2 height=35></td>
										</tr>
										<tr>
											<td width=360></td>
											<td>
												<table cellspacing=0 cellpadding=2 border=0>
													<tbody>
														<tr>
															<td style="height: 28px" width=80>登 录 名：</td>
															<td style="height: 28px" width=150><input id=txtname
																style="width: 130px" name="username"></td>
														</tr>
														<tr>
															<td style="height: 28px">登录密码：</td>
															<td style="height: 28px"><input id=txtpwd
																style="width: 130px" type=password name="password">
															</td>
														</tr>
														<tr>
															<td style="height: 18px"></td>
															<td style="height: 18px"></td>
															<td style="height: 18px"></td>
														</tr>
														<tr>
															<td></td>
															<td>
         <input id=btn
					style="border-top-width: 0px; border-left-width: 0px; border-bottom-width: 0px; border-right-width: 0px"
					type=image src="images/login_button.gif" name=btn>
				   </td>
				  </tr>
		    	 </tbody>
		        </table>
		    	</td>
		     </tr>
	       </tbody>
           </table>
          </td>
       </tr>
	   <tr>
			<td><img src="images/login_3.jpg" border=0></td>
		  </tr>
	   </tbody>
		</table>
	    </div>
		</div>
		<font>
			<script type="text/javascript">
    if("${msg}")
    {
    	alert("${msg}");
    	window.location="${pageContext.request.contextPath}/admin/login.jsp"; 
    	
    }
    </script>
		</font>
	</form>

</body>
</html>

