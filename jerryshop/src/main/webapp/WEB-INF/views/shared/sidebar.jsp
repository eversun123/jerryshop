<!-- 

<h1 class="my-4">Shop Name</h1>


<div class="list-group">
	<c:forEach items="${categories }" var="category">
		<a href="#" class="list-group-item">${category.name}</a>
	</c:forEach>
 
 
</div>
-->

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<p class="lead">富裕商店</p>
<c:forEach items="${categories }" var="category">
	<a href="${contextRoot }/show/category/${category.id}/products"
		class="list-group-item" id="a_${category.name }">${category.name}</a>
</c:forEach>
