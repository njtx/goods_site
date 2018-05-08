<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="inc/common_head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人设置</title>
<script type="text/javascript">
 if("${msg}")
 {
	 alert("${msg}");
 }
</script>
</head>
<%@include file="inc/common_body_top.jsp"%>
<!--修改表单 -->
<div class="register_content">
	<div class="register_title_bg"><h3>个人资料设置</h3>您所提供的资料不会做其他用途，敬请安心填写。</div>
	<div class="register_dotted_bg"></div>
	<form action="${pageContext.request.contextPath}/EditInfoServlet">
	<div class="register_message">
			<dl class="register_row">
				<dt>用户名：</dt>
				<dd>
				<input  name="username" class="register_input" disabled="disabled" 
				value="${user.username }"></dd>
			</dl>
			<dl class="register_row">
				<dt>昵称：</dt>
				<dd><input  name="nickname" class="register_input" value="${user.nickname }"></dd>
				<dd></dd>
			</dl>
			<dl class="register_row">
				<dt>密码：</dt>
				<dd><input  name="password" type="password" class="register_input" value="${ user.password }"/></dd>
			</dl> 
			<dl class="register_row"> 
				<dt>确认密码：</dt>
				<dd><input  name="repassword" type="password" class="register_input" value="${ user.password }"/></dd>
			</dl>
			
			<div class="registerBtn"><input id="registerBtn" type="image" src="resource/images/edit_btn_out-(1).jpg"
			 /></div>
	</div>
	</form>
</div>
<!-- 修改表单结束 -->
<%@include file="inc/common_body_bottom.jsp"%>
</html>