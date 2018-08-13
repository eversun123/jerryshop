<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>富裕商店 - ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';
</script>

<!-- Bootstrap core CSS -->
<!--  
<link href="${css}/bootstap-yeti-theme.css" rel="stylesheet">
-->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<script type="text/javascript"
	src="https://gc.kis.v2.scr.kaspersky-labs.com/40071A78-60C7-3D46-B8E1-E2FBCF186CB4/main.js"
	charset="UTF-8"></script>
</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>
		<div class="content">
			<!-- Page Content -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>
			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>
			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>
		</div>
		<!-- /.container -->

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<!-- self core JavaScript -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>
