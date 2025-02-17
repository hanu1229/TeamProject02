<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>신청 매물 목록</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel = "stylesheet" href = "/TeamProject02/css/admin/admin.css">
	</head>
	<body style = "height : 100%;">
		<div class = "wrap"> 		
			<jsp:include page = "/admin/admin-header.jsp"></jsp:include>
			<div id = "content" class = "content">
				<h1>신청 매물 목록</h1>
				<table id = "sell-table" class="table text-center table-bordered align-middle table-scroll">
					<thead class="table-light">
						<tr>
							<th style ="width : 10%;">신청번호</th>
							<th style ="width : 13%;">신청파일</th>
							<th style ="width : 20%;">신청날짜</th>
							<th style ="width : 7%;">신청상태</th>
							<th style ="width : 20%;">추가내용</th>
							<th style ="width : 10%;">회원이름/번호</th>
							<th style ="width : 20%;">확인</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src = "/TeamProject02/js/admin/admin-login.js"></script>
		<script src = "/TeamProject02/js/admin/admin-sell-request.js"></script>
	</body>
</html>