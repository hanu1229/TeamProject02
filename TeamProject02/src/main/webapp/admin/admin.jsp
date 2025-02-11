<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel = "stylesheet" href = "/css/admin/admin.css">
	</head>
	<body style = "height : 100%;">
		<div class = "wrap">
			<div class = "sidebar">			
				<jsp:include page = "/admin/adminHeader.jsp"></jsp:include>
			</div>
			<div class = "content">
				<h1>두번쨰 열의 제목</h1>
				<p>두번째 열의 본문</p>
			</div>
		</div>

		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>