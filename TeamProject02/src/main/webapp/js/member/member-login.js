console.log( 'memberLogin open')

// [1] 로그인 요청 함수 
const memberLogin = ( ) => {
	// 1. HTML INPUT DOM 가져오기 
	const midinput = document.querySelector('#mid-input');
	const mpwdinput = document.querySelector('#mpwd-input');
	// 2. INPUT 입력값 가져오기 
	const mid = midinput.value;
	const mpwd = mpwdinput.value;
	// 3. 유효성검사
	// 4. fetch 
	// * 보낼 데이터를 객체(JSON) 화 
	const obj = { mid : mid , mpwd : mpwd }
	// * fetch 설정
	const option = {
		method : 'POST' , // - 요청할 http method 선택 
		headers : { 'Content-Type' : 'application/json'}, // - 요청할 http body 타입 설정 
		body : JSON.stringify( obj ) // - 요청할 http 자료 , 자료를 JSON형식의 문자열 타입 으로 변환 
		
	}
	// * fetch 
	fetch( '/TeamProject02/afiliado/login' , option )
		.then( response => response.json() )
		.then( data => { 
			if( data > 0 ){
				alert('로그인성공');
				location.href="/TeamProject02/client/map.jsp";
			}
			else{ alert('로그인실패'); }
		})
		.catch( error => { console.log(error )})
} // f end