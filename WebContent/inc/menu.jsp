<%@ page contentType="text/html; charset=UTF-8"%>

<div class="art-vmenublock">
	<div class="art-vmenublock-body">
		<div class="art-vmenublockheader">
			<div class="l"></div>
			<div class="r"></div>
			 <div class="t">导航菜单</div>
		</div>
		<div class="art-vmenublockcontent">
			<div class="art-vmenublockcontent-tl"></div>
			<div class="art-vmenublockcontent-tr"></div>
			<div class="art-vmenublockcontent-bl"></div>
			<div class="art-vmenublockcontent-br"></div>
			<div class="art-vmenublockcontent-tc"></div>
			<div class="art-vmenublockcontent-bc"></div>
			<div class="art-vmenublockcontent-cl"></div>
			<div class="art-vmenublockcontent-cr"></div>
			<div class="art-vmenublockcontent-cc"></div>
			<div class="art-vmenublockcontent-body">
				<!-- block-content -->
				<ul class="art-vmenu">
					<li>
						<a href="${pageContext.request.contextPath}/RandomGoodsServlet">
						<span class="l"></span><span class="r"></span><span class="t">主页</span></a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/queryGoodServlet">
						<span class="l"></span><span class="r"></span><span class="t">查看商品</span></a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/queryCartServlet">
						<span class="l"></span><span class="r"></span><span class="t">查看购物车</span></a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/queryOrdersServlet">
						<span class="l"></span><span class="r"></span><span class="t">查看订单</span></a>
					</li>
				</ul>
				<!-- /block-content -->
				<div class="cleared"></div>
			</div>
		</div>
		<div class="cleared"></div>
	</div>
</div>
