<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<script type="text/javascript">
	function query(target)
     {
		 /* var goodType=document. getElementById("gt").innerText; */ 
    	 location.href="${pageContext.request.contextPath}/GoodsTypeServlet?gtype="+target;
    			 
     }

	//获取服装..分类
	function getType()
	{
		 var goodType=document. getElementById("gt").innerText;
		query(goodType);
	}
	//获取图书..分类
	function getType1()
	{
		 var goodType=document. getElementById("gt1").innerText;
		query(goodType);
	}
	function getType2()
	{
		var g=document.getElementById("shuma").innerText;
		var goodType=document. getElementById("gt2").innerText;
		query(g+":"+goodType);
	}
	function getType3()
	{	var g=document.getElementById("shuma").innerText;
		 var goodType=document. getElementById("gt3").innerText;
		 query(g+":"+goodType);
	}
	function getType4()
	{	var g=document.getElementById("shuma").innerText;
		 var goodType=document. getElementById("gt4").innerText;
		 query(g+":"+goodType);
	}
	function getType5()
	{
		 var goodType=document. getElementById("gt5").innerText;
		query(goodType);
	}
       
    </script>
<body>
	<div id="art-main">
		<div class="art-sheet">
		    <div class="art-sheet-tl"></div>
		    <div class="art-sheet-tr"></div>
		    <div class="art-sheet-bl"></div>
		    <div class="art-sheet-br"></div>
		    <div class="art-sheet-tc"></div>
		    <div class="art-sheet-bc"></div>
		    <div class="art-sheet-cl"></div>
		    <div class="art-sheet-cr"></div>
		    <div class="art-sheet-cc"></div>
		    <div style="height: 20px;background-color:#FFB6C1">
		    <c:choose>
					 <c:when test="${loginUser==null }">
					 <b>您好，欢迎来到Goods购物商城！</b> <a href="login.jsp" style="color: black;">[登录]</a>
					 <a href="regist.jsp" style="color: black">[免费注册]</a>
					 <%-- <a href="${pageContext.request.contextPath }/admin/login.jsp" style="color: black">[管理员登录]</a> --%>
					 </c:when>
					 <c:otherwise>
					  欢迎<strong><font color="write">${loginUser.nickname }</font></strong>来到Goods购物网站!<a href="loginout.jsp">[退出]</a>
					 <a href="${pageContext.request.contextPath }/infoServlet">[个人设置]</a>
					 </c:otherwise>
					</c:choose>
				</div>
		    <div class="art-sheet-body">
		        <div class="art-header">
					<div class="art-header-png"></div>
					
					<div class="art-header-jpeg">
					<%--  --%>
					</div>
					<div class="art-logo">
						<h1 id="name-text" class="art-logo-name">Goods购物商城</h1>
						<div id="slogan-text" class="art-logo-text">快乐的购物天堂...</div>
					</div>
				</div>
				 <div class="art-nav">
					<div class="l"></div>
					<div class="r"></div>
					<ul class="art-menu">
						<li>
							<a href="${pageContext.request.contextPath}/RandomGoodsServlet" class="active"><span class="l"></span><span class="r"></span><span class="t">主页</span></a>
						</li>
						<li>
							<a><span class="l"></span><span class="r"></span><span class="t">商品分类</span></a>
							
							<ul>
                                <li><a id="gt" href="javascript:getType();" >服装</a></li>
								<li><a id="gt1" href="javascript:getType1();" >图书、电子书刊</a></li>
								<li><a id="shuma">电子数码</a>
									<ul>
										<li><a id="gt2" href="javascript:getType2();">家用电器</a></li>
										<li><a id="gt3" href="javascript:getType3();">手机数码</a></li>
										<li><a id="gt4" href="javascript:getType4();">电脑、办公</a></li>
									</ul>
								</li>
								<li><a id="gt5" href="javascript:getType5();">家居、家具、厨具</a></li>
							</ul>
							
						</li>		
						<li>
							<a href="javascript:;"><span class="l"></span><span class="r"></span><span class="t">关于我们</span></a>
						</li>
					</ul>
				</div>
		        <div class="art-content-layout">
		            <div class="art-content-layout-row">
		                <div class="art-layout-cell art-content">
		                    <div class="art-post">
		                        <div class="art-post-tl"></div>
		                        <div class="art-post-tr"></div>
		                        <div class="art-post-bl"></div>
		                        <div class="art-post-br"></div>
		                        <div class="art-post-tc"></div>
		                        <div class="art-post-bc"></div>
		                        <div class="art-post-cl"></div>
		                        <div class="art-post-cr"></div>
		                        <div class="art-post-cc"></div>
		                        <div class="art-post-body"> 