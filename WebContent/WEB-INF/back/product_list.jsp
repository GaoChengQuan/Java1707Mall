<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/head.jsp" %>
<%@page import="com.situ.mall.pojo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ctx}/resources/thirdlib/bootstrap/css/bootstrap.css" />
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
	<!-- 中间内容部分 begin -->
	<div class="container">
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
						<c:if test="${fn:length(product.name)>25}">  
							<td>${fn:substring(product.name,0,25)}...</td>
						</c:if>
						<c:if test="${fn:length(product.name)<=25}">  
							<td>${product.name}</td>
						</c:if>
						<%-- <td>${product.subtitle}</td> --%>
						<td><img alt="" src="${product.fullUrl}" width="80" height="40" "></td>
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
	<!-- 中间内容部分 end -->
	
</body>
</html>