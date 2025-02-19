console.log( 'header.js!!' );

// 헤더 높이 계산해서 body에 padding-top 추가해주는 함수
document.addEventListener("DOMContentLoaded", function () { // 웹페이지가 완전히 로드될때 실행
	// 헤더 요소 선택
    const header = document.querySelector(".header_nav");
    if (header) {
		// offsetHeight : 요소의 실제 높이( 패딩 + 보더 포함 ) 을 px로 반환
		// body에 paddingTop을 반환값으로 설정
        document.body.style.paddingTop = header.offsetHeight + "px";
        console.log("헤더 높이(px):", header.offsetHeight);
    }
});

// 로그인 정보 요청 함수
const mgetLoginInfo = ( ) => {
	
	// option
	const option = { method : 'GET' }
	// 로그인 메뉴를 출력할 구역 가져오기
	let getmenu = document.querySelector('.getmenu');
	// 마이페이지 구역 가져오기
	let msellbox = document.querySelector('.msellbox');
	
	// 로그인 메뉴 html
	let html = '';
	// 마이페이지 html
	let msellboxHtml = '';
	
	fetch( `/TeamProject02/afiliado/info` , option )
		.then( response => response.json() )
		.then( data => {
			console.log( data ); // 확인용
			if( data == null ) { console.log('비로그인상태');
				// 각 상태에 따라 로그인 메뉴 구성
				html += `<li class="nav-item">
							<a class="nav-link py-0" href="/TeamProject02/member/memberLogin.jsp">로그인</a>
				 		</li>
						<li class="nav-item">
							<a class="nav-link py-0" href="/TeamProject02/member/memberSignUp.jsp">회원가입</a>
						</li>`
			}
			else{ console.log('로그인상태');
				html += `<li class="nav-item">
							<a class="nav-link py-0" href="/TeamProject02/member/memberLogin.jsp"
							data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">마이페이지</a>
						</li>`
				// 로그인된 회원 정보에서 msell.state 값 확인
				console.log( data );
				console.log( data.msell );
				const msellState = data.msell;
				// 로그인한 회원의 판매권한 값이 1이거나 관리자(9)면 매물등록신청 버튼 유
				if( msellState === 1 || msellState === 9 ) {
					msellboxHtml += `<div class="d-grid gap-2">
								<button class="btn btn-primary" type="button">회원정보수정</button>
								<button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#saleModal">판매권한신청</button>
								<button class="btn btn-primary" type="button" onclick="window.location.href='/TeamProject02/estate/estateview.jsp'">본인매물조회</button>
								<button class="btn btn-primary" type="button" onclick="window.location.href='/TeamProject02/estate/estatewrite.jsp'">매물등록신청</button>
								<button class="btn btn-primary Hlogout" type="button" onclick="logout()">로그아웃</button>				  
							</div>`
				}else{ // 권한 값이 1이 아니면 매물등록 신청 버튼 무
					msellboxHtml += `<div class="d-grid gap-2">
								<button class="btn btn-primary" type="button">회원정보수정</button>
								<button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#saleModal">판매권한신청</button>
								<button class="btn btn-primary" type="button" onclick="window.location.href='/TeamProject02/estate/estateview.jsp'">본인매물조회</button>
								<button class="btn btn-primary Hlogout" type="button" onclick="logout()">로그아웃</button>				  
							</div>`
				}
				
			} // if end
			// 구성한 메뉴들 반영
			getmenu.innerHTML = html;
			msellbox.innerHTML = msellboxHtml;
		})
		.catch( error => { console.log( error ); } )
	
} // f end
mgetLoginInfo(); // 최초 실행
