<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title> 
  <script type="text/javascript">
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
  	var checkgoods = true;
  	//使用ajax验证用户名是否存在
  	function checkgoodsName(gname) {
  		document.getElementById("goodsNameMsg").innerHTML = "";
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
  					var userNameMsg = document.getElementById("goodsNameMsg");
  	    			userNameMsg.innerHTML = "商品名已存在！";
  				} else {
  					// 将标记设置为可以注册
  					checkgoods = false;
  				}
  			}
  		}
  		//3. 与服务器建立连接
  		var url = "${pageContext.request.contextPath}/checkGoodsNameServlet";
  		XHR.open("POST", url, true);
  		XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  		//4. 发送请求
  		XHR.send("gname=" + gname);
  	} 
    var s=[null,null,
    ["电脑、办公","家用电器","手机数码"],null];
    function gets(){
     var slttype=document.getElementById("type");
     var sltshuma=document.getElementById("s");
     var ts=s[slttype.selectedIndex-1];
     sltshuma.length=1;
     for(var i=0;i<ts.length;i++){
    	 sltshuma[i+1]=new Option(ts[i],ts[i]);
     }
    }
    </script>
<style type="text/css">
table tr {
padding:0;
margin:0;
}
table tr td{
padding:0;
margin:0;
}
</style>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/UEditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
 <script type="text/javascript" src="${pageContext.request.contextPath }/UEditor/third-party/jquery.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/UEditor/third-party/template.min.js"></script>
 <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/UEditor//umeditor.config.js"></script>
 <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/UEditor//umeditor.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/UEditor//lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<div target="main">
	<p style="margin-top:0px;width:98%;padding-left:10px;background-color:#CAE1FF;font-weight: bold;  color: #000000;line-height: 20px">
    当前位置：商品管理 &gt; 新增商品</p></br>
	<div>
	<form action="${pageContext.request.contextPath }/addGoodsServlet" method="post" 
	enctype="multipart/form-data">
		<table align="left" style="margin-left: 10px">
			<tr>
				<td align="right"><div style="width:6em;">商品名称:</div></td>
				<td><input type="text" name="gname" id="gname" onblur="checkgoodsName(value);"/>
				<font id="goodsNameMsg" color="red"></font>
				</td>
			</tr>
			<tr>
				<td align="right">市场价:</td>
				<td><input type="text" name="gprice" /></td>
			</tr>
			<tr>
				<td align="right">优惠价:</td>
				<td><input type="text" name="gyprice" /></td>
			</tr>
			<tr>
				<td align="right">类型:</td>
				<td> <select name="type" id="type" onchange="gets();">
					  <option value="0" >--请选择--</option>
					   <option value="服装" >服装 </option> 
				      <option value="图书、电子书刊 " >图书、电子书刊 </option>
				      <option value="电子数码" > 电子数码 </option>
				      <option value=" 家居、家具、厨具 " > 家居、家具、厨具 </option>
					 </select>
					 <select id="s" name="s">
					  <option value="0">--请选择--</option>
					 </select></td>
			</tr>
			<tr>
				<td align="right">图片:</td>
				<td><input type="file" name="gimg" /></td>
			</tr>
			<tr>
				<td align="right">商品简介:</td>
				<td>
				<textarea name="myEditor" id="myEditor" style="width:700px;height:240px;border:1px solid;border-color:#C0C0C0"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">库存数量:</td>
				<td><input type="text" name="count" /></td>
			</tr>
			<tr>
				<td align="right"><input style="font-weight:bold;"  type="submit" value="提交 " /></td>
				<td><input style="font-weight:bold;" type="reset" value="重置 " /></td>
			</tr> 
			<tr style="height:4em;" >
				
			</tr> 
		</table>
	</form>
	</div>
	</div>
 <script type="text/javascript">
   	//UEDITOR_CONFIG.UEDITOR_HOME_URL = './baiduEditor/';
   	var um = UM.getEditor('myEditor');
   </script>
</body>
</html>

