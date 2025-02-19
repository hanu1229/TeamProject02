console.log( 'header.js!!' );

// 로그인 정보 요청 함수
const mgetLoginInfo = ( ) => {
	
	// option
	const option = { method : 'GET' }
	// 로그인 메뉴를 출력할 구역 가져오기
	let getmenu = document.querySelector('.getmenu');
	
	// html 변수
	let html = '';
	
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
			} // if end
			// 구성만 메뉴들 반영
			getmenu.innerHTML = html ;
		})
		.catch( error => { console.log( error ); } )
	
} // f end
mgetLoginInfo(); // 최초 실행