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
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
					모달창
				</button>
				<!-- Button trigger modal -->
				<!-- Modal -->
				<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
					<div class="modal-dialog">
						<!-- modal-content -->
						<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title fs-5" id="staticBackdropLabel">매물 등록</h1>
								<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<table id = "sell-modal-table" style = "width : 100%;">
									<tbody>
										<tr>
											<th class="py-3">카테고리</th>
											<td><input class= "form-control" placeholder = "0 : 아파트, 1 : 주택, 2 : 오피스텔" type = "text"/></td>
										</tr>
										<tr>
											<th class="py-3">주소</th>
											<td><input class= "form-control" type = "text"/></td>
										</tr>
										<tr>
											<th class="py-3">위도</th>
											<td><input class= "form-control" type = "text"/></td>
										</tr>
										<tr>
											<th class="py-3">경도</th>
											<td><input class= "form-control" type = "text"/></td>
										</tr>
										<tr>
											<th class="py-3">동</th>
											<td><input class= "form-control" type = "text"/></td>
										</tr>
										<tr>
											<th class="py-3">층수</th>
											<td><input class= "form-control" type = "text"/></td>
										</tr>
										<tr>
											<th class="py-3">면적</th>
											<td><input class= "form-control" type = "text"/></td>
										</tr>
										<tr>
											<th class="py-3">준공년도</th>
											<td><input class= "form-control" type = "text"/></td>
										</tr>
										<tr>
											<th class="py-3">구조</th>
											<td><input class= "form-control" type = "text"/></td>
										</tr>
										<tr>
											<th class="py-3">소유권 대상</th>
											<td><input class= "form-control" type = "text"/></td>
										</tr>
										<tr>
											<th class="py-3">회원이름/번호</th>
											<td><input class= "form-control" type = "text"/></td>
										</tr>
										<tr>
											<th class="py-3">추가내용</th>
											<td><textarea class="form-control" rows="6"></textarea></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
								<button type="button" class="btn btn-primary">등록</button>
							</div>
						</div>
						<!-- modal-content -->
					</div>
				</div>
				<!-- Modal -->
				
			</div>
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src = "/TeamProject02/js/admin/admin-login.js"></script>
		<script src = "/TeamProject02/js/admin/admin-sell-request.js"></script>
	</body>
</html>