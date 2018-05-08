<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">

<head>
    <%@include file="inc/common_head.jsp"%>
   <!--   <script type="text/javascript">
    if("${msg}")
    {
    	alert("${msg}")
    }
    </script>-->
</head>

<%@include file="inc/common_body_top.jsp"%>
<!-- 登录表单 -->
<div class="login_main_mid">
	<div class="login_content_top">请登录Goods商场</div>
	<div class="login_content_line"></div>
	 <font color="red">${msg}</font>
	<form action="LoginServlet" method="post">
		<dl class="login_content">
			<dt>用户名：</dt>
			<dd><input id="username" name="username" class="login_content_input" /></dd>
		</dl>
		<script type="text/javascript">
		document.getElementById("username").value=decodeURI("${cookie.username.value}");
		</script>
		<dl class="login_content">
			<dt>密码：</dt>
			<dd>
				<input id="password" name="password" type="password" class="login_content_input" />
			</dd>
		</dl>
		<dl class="login_content">
			<dt></dt>
			<dd>
			<!-- input中checked="renyi值"，也可以写成三元，类似下面 -->
				<input type="checkbox" name="remember" 
				${cookie.username.value==null? "":"checked" } value="on"/>记住用户 
			</dd>
			
		</dl>
		<dl class="login_content">
			<dt></dt>
			<dd><input id="btn" value=" " type="submit" class="login_btn_out" /></dd>
		</dl>
	</form>
	<div class="login_content_dotted"></div>
	<div class="login_content_end_bg">
		<div class="login_content_end_bg_top">
			<label class="login_content_bold">还不是Goods商场用户？</label>快捷方便的免费注册，让你立刻尽享Goods商场提供的满意服务......
		</div>
		<div class="login_content_end_bg_end">
			<input class="login_register_out" value=" " type="button" onclick="window.location='regist.jsp';" />
		</div>
	</div>
</div>
<!-- 登录表单结束 -->
<%@include file="inc/common_body_bottom.jsp"%>
</html>