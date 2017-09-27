<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.situ.mall.pojo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../common/head.jsp" %>
<script type="text/javascript">
	function del(id){
		var isDel = confirm("您确认要删除么");
		if(isDel) {
			location.href="/ShiXun09/student?method=deleteById&id="+id;
		}
	}
</script>
</head>
<body>
	<!-- 顶部导航条 begin -->
	<nav class="navbar navbar-default">
	  <div class="container">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">教务管理系统</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;商品管理 </a></li>
	        <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;班级管理</a></li>
	        <li><a href="#"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;课程管理</a></li>
	        <li><a href="#"><span class="glyphicon glyphicon-tag"></span>&nbsp;&nbsp;教务管理</a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="/ShiXun09/login?method=logout"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	<!-- 顶部导航条 end -->
	
	<!-- 中间内容部分 begin -->
	<div class="container">
		<div class="row">
			<!--左边列表占12份中的2份-->
			<div class="col-md-2">
				<div class="list-group">
				  <a href="/ShiXun09/student?method=findAll" class="list-group-item active">商品管理</a>
				  <a href="student_search.jsp" class="list-group-item">商品搜索</a>
				  <a href="${ctx}/product/getAddPage.action" class="list-group-item">添加商品</a>
				</div>
			</div>
			<!--左边列表占12份中的10份-->
			<div class="col-md-10">
				<ul class="nav nav-tabs">
				  <li role="presentation" class="active"><a href="/ShiXun09/student?method=findAll">商品管理</a></li>
				  <li role="presentation"><a href="student_search.jsp">商品搜索</a></li>
				  <li role="presentation"><a href="/ShiXun09/student?method=getAddPage">添加商品</a></li>
				</ul>
				
				<table class="table  table-condensed table-hover">
					<thead>
						<tr>
							<th>商品id</th>
							<th>分类id</th>
							<th>名称</th>
							<!-- <th>商品副标题</th> -->
							<th>产品主图</th>
							<!-- <th>图片地址</th> -->
							<!-- <th>商品详情</th> -->
							<th>价格</th>
							<th>库存</th>
							<th>状态</th>
							<!-- <th>创建时间</th> -->
							<th>更新时间</th>
							<th>删除</th>
							<th>修改</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="product">
							<tr>
								<td>${product.id}</td>
								<td>${product.categoryId}</td>
								<td>${product.name}</td>
								<%-- <td>${product.subtitle}</td> --%>
								<td><img alt="" src="/pic/${product.mainImage}" width="80" height="60" "></td>
								<%-- <td>${product.subImages}</td> --%>
								<%-- <td>${product.detail}</td> --%>
								<td>${product.price}</td>
								<td>${product.stock}</td>
								<td>${product.status}</td>
								<%-- <td>${product.createTime}</td>
								<td>${product.updateTime}</td> --%>
								<%-- <td><fmt:formatDate value="${product.createTime}" pattern="yyyy-MM-dd"/></td> --%>
								<td><fmt:formatDate value="${product.updateTime}" pattern="yyyy-MM-dd"/></td>
								
								<td><a
									href="${ctx}/student/deletById.action?id=${product.id}">删除</a></td>
								<td><a
								href="${ctx}/student/toUpdate.action?id=${product.id}">修改</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
		</div>
	</div>
	<!-- 中间内容部分 end -->
	
</body>
</html>