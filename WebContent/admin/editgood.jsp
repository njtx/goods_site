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
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/UEditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
 <script type="text/javascript" src="${pageContext.request.contextPath }/UEditor/third-party/jquery.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/UEditor/third-party/template.min.js"></script>
 <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/UEditor//umeditor.config.js"></script>
 <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/UEditor//umeditor.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/UEditor//lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<div class="u" target="main" style="height: 650px">
				<div>
                <p style="width:98%;padding-left:10px;background-color:#CAE1FF;font-weight: bold;  color: #000000;line-height: 20px">
               当前位置：商品管理 &gt; 修改商品</p>
				</div>
				<div>
					<form action="${pageContext.request.contextPath }/EditGoodServlet" method="post" >
		<table align="left" style="margin-left: 40px">
			<tr>
				<td align="right">商品名称:</td>
				<td><input type="text" name="gname" id="gname" value="${g.goodName }" readonly="readonly"
				style="background:#CCCCCC"/>
				</td>
			</tr>
			<tr>
				<td align="right">市场价:</td>
				<td><input type="text" name="gprice"  value="${g.goodPrice }"/></td>
			</tr>
			<tr>
				<td align="right">优惠价:</td>
				<td><input type="text" name="gyprice" value="${g.goodYprice }"/></td>
			</tr>
			<tr>
				<td align="right">类型:</td>
				
				<td> 
				<input type="text" name="gtype" style="margin-top: 10px" value="${g.goodType }"
				disabled="disabled" style="background:#CCCCCC"
				/>
				<select name="type" id="type" onchange="gets();">
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
				<td>
				<img src="${pageContext.request.contextPath }${g.goodPath}" align="left" width="30px" height="30px" style="margin-right:10px"/>
				<!-- <input type="file" name="gimg" style="margin-top: 10px"/> --></td>
			</tr>
			<tr>
				<td align="right">商品简介:</td>
				<td><!-- <textarea resize="none" rows="5" cols="25" name="introduce"></textarea> -->
				<textarea name="myEditor" id="myEditor" style="width:1000px;height:240px;border:1px solid;border-color:#C0C0C0"
				>
				${g.goodDescript }
				</textarea>
				</td>
			</tr>
			<tr>
				<td align="right">库存数量:</td>
				<td><input type="text" name="count" value="${g.goodNum }"/></td>
			</tr>
			<tr >
				<td><input style="font-weight:bold;" type="submit" value="修改" /></td>
			</tr> 
		</table>
		
	</form>
</div></div>
	 <script type="text/javascript">
    	//UEDITOR_CONFIG.UEDITOR_HOME_URL = './baiduEditor/';
    	var um = UM.getEditor('myEditor');
    </script>
</body>
</html>

