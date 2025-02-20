<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>본인 매물 조회</title>
	<link href="/TeamProject02/css/estate/estate.css" rel="stylesheet">
</head>
<body>
	
	<jsp:include page="/header.jsp" />
	
	<!-- 모달 내용 -->
	<!-- 수정 -->
	<div class="modal fade" id="updateModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered estateview_bg1">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5 fw-bold" id="staticBackdropLabel">수정</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <form class="p-2 p-md-3 border rounded-3">
	        	<!-- 수정할 주소 입력 필드 -->
		       	<div class="mb-3">
		          	<label for="exampleFormControlTextarea1" class="form-label"></label>
		            <textarea class="evalue form-control textarea" id="exampleFormControlTextarea1" rows="7" placeholder="상세내용"></textarea>
		        </div>
		        
		        <!-- 수정할 매물 번호를 전달하기 위한 hidden input 추가 -->
		        <input type="hidden" class="update-pno" name="pno">
		        
		        <hr class="my-4">
		        <div class="text-center">
		            <label for="formFileLg" class="form-label fw-bold">첨부파일 수정을 원하시면 관리자에게 문의</label>
		        </div>
		   	</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary" onclick="eUpdate()">수정</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 수정 end -->
	<!-- 중지 -->
	<div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5 fw-bold" id="staticBackdropLabel">판매중지</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	<!-- 판매중지할 매물 번호를 전달하기 위한 hidden input 추가 -->
	      	<input type="hidden" class="delete-pno" name="pno">	
	        정말 매물판매를 중지하시겠습니까? (번복불가)
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary" onclick="eStop()">중지</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 중지 end -->
	<!-- 모달 내용 end -->
	
	<!-- wrap  -->
	<div id="estateview_wrap"> 
		<div class="estate_box table-responsive">
			<table class="estate_table table table-hover table-bordered table align-middle text-center ">
			  <thead class="table-light align-middle ">
			    <tr>
			      <th scope="col">매물번호</th>
			      <th scope="col">
				      	<select class="estateview_select form-select w-100" aria-label="Default select example">
				      	  <option value="10">전체</option>
						  <option value="0">아파트</option>
						  <option value="1">주택</option>
						  <option value="2">오피스텔</option>
						</select>
			      </th>
			      <th scope="col">주소</th>
			      <th scope="col">동</th>
			      <th scope="col">층</th>
			      <th scope="col">면적</th>
			      <th scope="col">준공년도</th>
			      <th scope="col">구조</th>
			      <th scope="col">등기부상 소유권 대상</th>
			      <th scope="col">추가내용</th>
			      <th scope="col">등록일</th>
			      <th scope="col">판매상태</th>
			      <th scope="col">기능</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			    
			  </tbody>
			</table>
		</div>
		<div class="d-flex justify-content-center mt-3">
			<!-- 부트스트랩 : 페이지네이션 -->
			<nav aria-label="Page navigation example">
				<ul class="pagination pagebtnbox"> <!-- pagebtnbox -->
					  
				</ul>
			</nav>
		</div>
	</div> 
	<!-- wrap end -->
	
	<script src="/TeamProject02/js/estate/estate_view.js"></script>
	<script src="/TeamProject02/js/estate/estate_update.js"></script>
	<script src="/TeamProject02/js/estate/estate_stop.js"></script>
	
</body>
</html>