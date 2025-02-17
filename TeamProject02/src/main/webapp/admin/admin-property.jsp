<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>등록된 매물 목록</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel = "stylesheet" href = "/TeamProject02/css/admin/admin.css">
	</head>
	<body style = "height : 100%;">
		<div class = "wrap"> 		
			<jsp:include page = "/admin/admin-header.jsp"></jsp:include>
			<div id = "content" class = "content">
				<h1>등록된 매물 목록</h1>
				<table id = "property-table" class="table text-center table-bordered align-middle table-scroll">
					<thead class = "table-light align-middle">
						<tr>
							<th style ="width : 10%;">매물번호</th>
							<th style ="width : 10%;">카테고리</th>
							<th style ="width : 30%;">주소</th>
							<th style ="width : 10%;">준공년도</th>
							<th style ="width : 20%;">등록일</th>
							<th style ="width : 10%;">판매상태</th>
							<th style ="width : 10%;">판매자명/번호</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src = "/TeamProject02/js/admin/admin-login.js"></script>
		<script src = "/TeamProject02/js/admin/admin-property.js"></script>
	</body>
</html>