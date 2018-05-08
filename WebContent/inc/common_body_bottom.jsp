<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="cleared"></div>
</div>
</div>
</div>
<div class="art-layout-cell art-sidebar1">
	<%@include file="menu.jsp"%>
	<div class="art-block">
		<div class="art-block-body">
			<div class="art-blockheader">
				<div class="l"></div>
				<div class="r"></div>
				<div class="t">查询商品</div>
			</div>
			<div class="art-blockcontent">
				<div class="art-blockcontent-tl"></div>
				<div class="art-blockcontent-tr"></div>
				<div class="art-blockcontent-bl"></div>
				<div class="art-blockcontent-br"></div>
				<div class="art-blockcontent-tc"></div>
				<div class="art-blockcontent-bc"></div>
				<div class="art-blockcontent-cl"></div>
				<div class="art-blockcontent-cr"></div>
				<div class="art-blockcontent-cc"></div>
				<div class="art-blockcontent-body">
					<!-- block-content -->
					<div>
						<form method="get" id="newsletterform"
							action="${pageContext.request.contextPath}/SearchgoodServlet">
							<input name="search" style="width: 60%; margin-top: 5px;" /> <span
								class="art-button-wrapper"> <span class="l"> </span> <span
								class="r"> </span> 
								<input class="art-button" type="submit" value="查询" /> 
							</span>
						</form>
					</div>
					<!-- /block-content -->
					<div class="cleared"></div>
				</div>
			</div>
			<div class="cleared"></div>
		</div>
	</div>

	<div class="art-block">
		<div class="art-block-body">
			<div class="art-blockheader">
				<div class="l"></div>
				<div class="r"></div>
				<div class="t">联系信息</div>
			</div>
			<div class="art-blockcontent">
				<div class="art-blockcontent-tl"></div>
				<div class="art-blockcontent-tr"></div>
				<div class="art-blockcontent-bl"></div>
				<div class="art-blockcontent-br"></div>
				<div class="art-blockcontent-tc"></div>
				<div class="art-blockcontent-bc"></div>
				<div class="art-blockcontent-cl"></div>
				<div class="art-blockcontent-cr"></div>
				<div class="art-blockcontent-cc"></div>
				<div class="art-blockcontent-body">
					<!-- block-content -->
					<div>
						<img src="resource/images/TB2.jpg" alt="an image"
							style="margin: 0 auto; display: block; width: 95%" /> <br /> <b>公司信息:</b>&nbsp;&nbsp;Goods网站<br />
						<br /> <b>公司地址:</b>&nbsp;苏州市独墅湖
			            <br /> <br /> 电话: (021)60717860 <br /> 传真:
						(021)60717861
						  <br/> <br/><br/>
						    </div>
					<!-- /block-content -->

					<div class="cleared"></div>
				</div>
			</div>
			<div class="cleared"></div>
		</div>
	</div>
</div>
</div>
</div>
<div class="cleared"></div>
<div class="art-footer">
	<div class="art-footer-t"></div>
	<div class="art-footer-l"></div>
	<div class="art-footer-b"></div>
	<div class="art-footer-r"></div>
	<div class="art-footer-body">
		<a href="javascript:;" class="art-rss-tag-icon" title="RSS"></a>
		<div class="art-footer-text">
			<p>
				<a href="http://sh.itcast.cn">关于我们</a> | <a
					href="http://sh.itcast.cn">联系我们</a> | <a href="javascript:;">人才招聘</a>
				| <a href="javascript:;">商家入驻</a><br /> 版权 &#169; 2017 ---. Goods网站
				版权所有.
			</p>
		</div>
		<div class="cleared"></div>
	</div>
</div>
<div class="cleared"></div>
</div>
</div>
<div class="cleared"></div>
</div>
</body>