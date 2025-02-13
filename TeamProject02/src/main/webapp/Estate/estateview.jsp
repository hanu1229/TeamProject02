<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="/header.jsp" />
	
	<!-- 모달 버튼 -->
	<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabindex="-1" role="dialog" id="modalChoice">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content rounded-3 shadow">
	      <div class="modal-body p-4 text-center">
	        <h5 class="mb-0">Enable this setting?</h5>
	        <p class="mb-0">You can always change your mind in your account settings.</p>
	      </div>
	      <div class="modal-footer flex-nowrap p-0">
	        <button type="button" class="btn btn-lg btn-link fs-6 text-decoration-none col-6 py-3 m-0 rounded-0 border-end"><strong>확인</strong></button>
	        <button type="button" class="btn btn-lg btn-link fs-6 text-decoration-none col-6 py-3 m-0 rounded-0" data-bs-dismiss="modal">취소</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<div id="estateview_wrap"> <!-- wrap  -->
		<div class="table-responsive estate_box">
			<table class="table table-hover table-bordered table align-middle text-center estate_table">
			  <thead class="table-light align-middle ">
			    <tr>
			      <th scope="col">매물번호</th>
			      <th scope="col">
			      	<div class="dropdown">
					  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
					    카테고리
					  </button>
					  <ul class="dropdown-menu">
					    <li><a class="dropdown-item" href="#">아파트</a></li>
					    <li><a class="dropdown-item" href="#">주택</a></li>
					    <li><a class="dropdown-item" href="#">오피스텔</a></li>
					  </ul>
					</div>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
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
					  <button type="button" class="btn btn-outline-primary">신청</button>
					  <button type="button" class="btn btn-outline-primary">수정</button>
					  <button type="button" class="btn btn-outline-primary">삭제</button>
					</div>
				  </td>
			    </tr>
			  </tbody>
			</table>
		</div>
	</div> <!-- wrap end -->
	
	<script src="/TeamProject02/js/estate/estateview.js"></script>
	
</body>
</html>