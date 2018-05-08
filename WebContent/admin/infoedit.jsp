<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title> 
<style type="text/css">
.u{
width:98%;border-top:1px solid #1C86EE;border-right:1px solid #1C86EE;
border-left:1px solid #1C86EE;border-bottom:1px solid #1C86EE;
box-shadow: 1px 0px 16px #1C86EE; border-radius:5px 5px 5px 5px;margin-bottom: 10px;

}
</style>
<script type="text/javascript">
 if("${msg}")
 {
	 alert("${msg}");
 }
</script>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/UEditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
 <script type="text/javascript" src="${pageContext.request.contextPath }/UEditor/third-party/jquery.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/UEditor/third-party/template.min.js"></script>
 <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/UEditor//umeditor.config.js"></script>
 <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/UEditor//umeditor.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/UEditor//lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<div class="u" target="main" style="height: 550px">
				<div align="left" style="margin-left: 50px">
					<span style="color:red;font-size:30px;">修改密码 </span>
				</div>
				<div>
					<form action="${pageContext.request.contextPath }/EditPwdServlet" method="post" 
					
					>
						<table align="left" style="margin-left: 40px">
							<tr>
							<td align="right">密码:</td>
							<td><input type="password" name="password" id="gname" value="${ user.password }" />
						
							
							</tr>
							<tr>
							<td align="right">确认密码:</td>
								<td><input type="password" name="repassword" id="gname" value="${ user.password }" />
							</tr>
						</table>
						<br><br><br>
						<div align="right" style="padding-left: 120px;float: left">
								<input  type="submit" value="修改" />
								<input  type="reset" value="重置" />
						</div> 
						
					</form>
				</div>
	</div>
	 <script type="text/javascript">
    	//UEDITOR_CONFIG.UEDITOR_HOME_URL = './baiduEditor/';
    	var um = UM.getEditor('myEditor');
    </script>
</body>
</html>

