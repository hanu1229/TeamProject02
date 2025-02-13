<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/TeamProject02/css/estate/estate.css" rel="stylesheet">
</head>
<body>
	
	<jsp:include page="/header.jsp" />
	
	<!-- 모달 버튼 -->
	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#applyModal">
	  신청
	</button>
	
	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#updateModal">
	  수정
	</button>
	
	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#deleteModal">
	  삭제
	</button>
	<!-- 모달 버튼 end -->
	
	<!-- 모달 내용 -->
	<!-- 신청 -->
	<div class="modal fade" id="applyModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5 fw-bold" id="staticBackdropLabel">신청</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        매물 거래 신청을 하시겠습니까?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary">신청</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 신청 end -->
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
		       	<div class="mb-3">
		          	<label for="exampleFormControlTextarea1" class="form-label"></label>
		            <textarea class="form-control textarea" id="exampleFormControlTextarea1" rows="7" placeholder="상세내용"></textarea>
		        </div>
		        <hr class="my-4">
		        <div class="mb-3">
		            <label for="formFileLg" class="form-label mb-3 fw-bold">건축물대장 등본</label>
		            <input class="form-control form-control-lg " id="formFileLg" type="file">
		        </div>
		   	</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary">수정</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 수정 end -->
	<!-- 삭제 -->
	<div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5 fw-bold" id="staticBackdropLabel">삭제</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        정말 매물을 삭제 하시겠습니까?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary">삭제</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 삭제 end -->
	<!-- 모달 내용 end -->
	
	<!-- wrap  -->
	<div id="estateview_wrap"> 
		<div class="table-responsive estate_box">
			<table class="table table-hover table-bordered table align-middle text-center estate_table">
			  <thead class="table-light align-middle ">
			    <tr>
			      <th scope="col">매물번호</th>
			      <th scope="col">
				      	<select class="form-select w-100 estateview_select" aria-label="Default select example">
						  <option selected>카테고리</option>
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
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td><a href="#">아파트</a></td>
			      <td>인천 연수구 컨벤시아대로274번길 62</td>
			      <td>1904</td>
			      <td>19</td>
			      <td>84.98</td>
			      <td>2023.03</td>
			      <td>철근콘크리트</td>
			      <td>홍길동</td>
			      <td>최신식 엘베</td>
			      <td>2025-02-06 13:20:05</td>
			      <td>0</td>
				  <td>
				  	<div class="btn-group" role="group" aria-label="Basic outlined example">
					  <button type="button" class="btn btn-outline-dark">신청</button>
					  <button type="button" class="btn btn-outline-dark">수정</button>
					  <button type="button" class="btn btn-outline-dark">삭제</button>
					</div>
				  </td>
			    </tr>
			  </tbody>
			</table>
		</div>
	</div> 
	<!-- wrap end -->
	
	<script src="/TeamProject02/js/estate/estateview.js"></script>
	
</body>
</html>