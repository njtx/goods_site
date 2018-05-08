<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">

<head>
    <%@include file="inc/common_head.jsp"%>
    <script type="text/javascript">
      function checkForm()
      {
    	  //获取用户名
    	  var username=document.getElementById("userName");
    	  if(username.value=="")
    	  {
    		  alert("用户名不能为空！");
    		  return false;
    	  }
    	  //获取昵称
    	  var nickname=document.getElementById("nickName");
    	  if(nickname.value=="")
    	  {
    		  alert("昵称不能为空！");
    		  return false;
    	  }
    	  //获取密码
    	  var pwd=document.getElementById("pwd");
    	  if(pwd.value=="")
    	  {
    		  alert("密码不能为空！");
    		  return false;
    	  }
    	  //获取确认密码
    	  var repwd=document.getElementById("repwd");
    	  if(repwd.value=="")
    	  {
    		  alert("确认密码不能为空！");
    		  return false;
    	  }
    	  //确保密码与确认密码一致
    	  if(pwd.value!=repwd.value)
    	  {
    		  alert("密码和确认密码不一致！");
    		  return false;
    	  }
    	  //判断验证码
    	  var code=document.getElementById("code").value;
    	  if(!code)
    	  {
    		  alert("验证码不能为空！");
    		  return false; 
    	  }
    	  if("${msg}")
    	  {
    		  alert("${msg}");
    	  }
    	// 判断用户名是否重复，为true则为重复，阻止提交表单
  		if (checkUser) {
  			return false;
  		}
  		return true;
      }
   	// 获取XMLHttpRequest对象
  	function getXMLHttpRequest() {
  		var XHR;
  		try {
				// IE7，FireFox、Chrome等标准浏览器
				if (window.XMLHttpRequest) {
					XHR = new XMLHttpRequest();
				}
				// IE5、IE6
				else {
					XHR = new ActiveXObject("Microsoft.XMLHTTP");
				}
				return XHR;
			} catch (e) {
				alert("您的浏览器不支持ajax!");
			}
  	}
  	
  	// 默认当前用户存在
  	var checkUser = true;
  	//使用ajax验证用户名是否存在
  	function checkUserName(username) {
  		document.getElementById("userNameMsg").innerHTML = "";
  		// 当用户名输入框再次失去焦点，认为当前用户已存在
  		checkUser = true;
  		//1. 获取XMLHttpRequest对象
  		var XHR = getXMLHttpRequest();
  		//2. 监听服务器返回状态
  		XHR.onreadystatechange = function() {
  			if (XHR.readyState == 4 && XHR.status == 200) {
  				// 服务器返回成功
  				var result = XHR.responseText;
  				// 数量不为0，已存在，不能注册
  				if (result != "0") {
  					var userNameMsg = document.getElementById("userNameMsg");
  	    			userNameMsg.innerHTML = "用户名已存在！";
  				} else {
  					// 将标记设置为可以注册
  					checkUser = false;
  				}
  			}
  		}
  		//3. 与服务器建立连接
  		var url = "${pageContext.request.contextPath}/checkUserNameServlet";
  		XHR.open("POST", url, true);
  		XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  		//4. 发送请求
  		XHR.send("username=" + username);
  	} 
     
    </script>
</head>

<%@include file="inc/common_body_top.jsp"%>
<!-- 注册表单 -->
<div class="register_content">
	<div class="register_title_bg"><h3>欢迎注册Goods商城</h3>您所提供的资料不会做其他用途，敬请安心填写。</div>
	<div class="register_dotted_bg"></div>
	<div class="register_message">
		<form action="${pageContext.request.contextPath}/registerServlet" method="post" onsubmit="return checkForm();">
			<dl class="register_row">
				<dt>用户名：</dt>
				<dd>
				<input id="userName" name="username" onblur="checkUserName(value);" class="register_input"/>
				<font id="userNameMsg" color="red"></font>
				</dd>
			</dl>
			<dl class="register_row">
				<dt>昵称：</dt>
				<dd><input id="nickName" name="nickname" class="register_input"/></dd>
				<dd></dd>
			</dl>
			<dl class="register_row">
				<dt>密码：</dt>
				<dd><input id="pwd" name="password" type="password" class="register_input"/></dd>
			</dl> 
			<dl class="register_row"> 
				<dt>确认密码：</dt>
				<dd><input id="repwd" name="repassword" type="password" class="register_input"/></dd>
			</dl>
			<dl class="register_row">
				<dt>验证码：</dt>
				<dd><input id="code" name="code" class="register_input" /></dd>
				<dd><img src="validatecode.jsp" onclick="src='validatecode.jsp?'+Math.random();" /></dd>
			</dl>
			<div class="registerBtn"><input id="registerBtn" type="image" src="resource/images/register_btn_out.gif" /></div>
		</form>
	</div>
</div>
<!-- 注册表单结束 -->
<%@include file="inc/common_body_bottom.jsp"%>
</html>