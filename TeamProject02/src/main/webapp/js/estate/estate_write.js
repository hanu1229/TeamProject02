console.log( 'estate_write.js open');

// 매물 등록 요청 메소드
const estate_Write = ( ) => {
	
	// form 을 한번에 가져오기 // * from-data로 전송할 경우에는 속성명들을 'name' 속성으로 사용된다.
	const estateform = document.querySelector('.Estateform'); 
	console.log( estateform );
	
	// Fetch 함수 이용한 'multipart/form-data' 타입으로 전송
	const writeformData = new FormData( estateform );
	const option = {
		method : 'POST' ,
		body : writeformData
	}
	fetch( `/TeamProject02/estate/info` , option )
		.then( response => response.json() ) // 응답 자료를 json 타입으로 변환
		.then( data => {
			console.log( data );
			// 신청 성공시 메시지 출력 후 본인 매물 조회 페이지로 이동
			if( data == true ){ alert( '매물 신청 성공' ); location.href="estateview.jsp"; }
			else{ alert( '매물 신청 실패'); }
		})
		.catch( error => { console.log( error ); } )
} // f end