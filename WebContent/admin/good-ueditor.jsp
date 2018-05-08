<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.u{
width:80%;border-top:1px solid #1C86EE;border-right:1px solid #1C86EE;
border-left:1px solid #1C86EE;border-bottom:1px solid #1C86EE;
box-shadow: 1px 0px 16px #1C86EE; border-radius:5px 5px 5px 5px;margin-bottom: 20px;

}
</style>
<title>商品描述</title> 
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
	<p style="margin-top:0px;width:98%;padding-left:10px;background-color:#CAE1FF;font-weight: bold;  color: #000000;line-height: 20px">
当前位置：商品管理 &gt; 查看商品描述</p></br>
				<div>
				<div><textarea name="myEditor" id="myEditor" style="width:1000px;height:240px;border:1px solid;border-color:#C0C0C0"
				>
			${gid.goodDescript }
				</textarea>
				</div>
				</div>
	
	 <script type="text/javascript">
    	//UEDITOR_CONFIG.UEDITOR_HOME_URL = './baiduEditor/';
    	var um = UM.getEditor('myEditor');
    </script>
</body>
</html>

