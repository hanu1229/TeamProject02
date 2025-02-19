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
	<!-- estate 전체 div -->
	<div id="estate_main">
	 	<!-- 회원가입 부트스트랩 전체 div -->
		<div class="container col-xl-10 col-xxl-8 px-4 py-5">
			<!-- 상단 텍스트 공간 -->
		    <div class="g-lg-5 py-5">
		      <div class="col-lg-7 mx-auto">
		        <h1 class="col-lg-11 fw-bold lh-1 mb-5 text-center display-4 w-100">매물 신청 페이지</h1>
		        <p class="col-lg-11 fs-4 text-center w-100 ">매물에 대한 건축물대장 등본 파일을 첨부하시고</br>매물에 대한 상세내용을 적어주세요.</p>
		      </div>
		    </div>
		  <!-- 하단 form 공간 -->
		  <div class="row align-items-center g-lg-5 py-5">
		     <div class="col-md-10 mx-auto col-lg-7 mt-0">
		        <form class="Estateform p-4 p-md-5 border rounded-3 estate_bg1">
		          <div class="mb-3">
		            <label for="exampleFormControlTextarea1" class="form-label"></label>
		            <textarea class="form-control textarea" id="exampleFormControlTextarea1" name="sadd" rows="7" placeholder="상세내용"></textarea>
		          </div>
		          <div class="mb-3">
		            <label for="formFileLg" class="form-label mb-3 fw-bold">건축물대장 등본</label>
		            <input class="form-control form-control-lg" id="formFileLg" name="sfile" type="file">
		          </div>
		          <hr class="my-4">
		          <button onclick="estate_Write()" class="w-100 btn btn-lg btn-primary" type="button">신청하기</button>
		        </form>
		      </div>
		  </div>
		</div>
	</div>
	<!-- estate 전체 div end -->
	
	<!-- JS 파일 -->
	<script src="/TeamProject02/js/estate/estate_write.js" type="text/javascript"></script>
</body>
</html>