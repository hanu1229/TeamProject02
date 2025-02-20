<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>중개한 매물 목록</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel = "stylesheet" href = "/TeamProject02/css/admin/admin.css">
		<link href="/TeamProject02/css/index.css" rel="stylesheet">
	</head>
	<body style = "height : 100%;">
		<div class = "wrap"> 		
			<jsp:include page = "/admin/admin-header.jsp"></jsp:include>
			<div id = "content" class = "content">
				<h1>중개한 매물 목록</h1>
				<table id = "brokerage-table" class="table text-center table-bordered align-middle table-scroll">
					<thead class = "table-light">
						<tr>
							<th style = "width : 5%;">번호</th>
							<th>파일</th>
							<th>날짜</th>
							<th>중개사</th>
							<th>내용</th>
							<th>회원명/회원번호</th>
							<th style = "width : 10%;">매물번호</th>
							<th>다운로드</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src = "/TeamProject02/js/admin/admin-login.js"></script>
		<script src = "/TeamProject02/js/admin/admin-brokerage.js"></script>
	</body>
</html>