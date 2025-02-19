console.log('member-signup.js!!');

// 회원가입 js
const memberSignUp = ( ) => {
	
	//	입력한 값 가져오기
	const mid = document.querySelector('.midinput').value;
	const mpwd = document.querySelector('.mpwdinput').value;
	const mname = document.querySelector('.mnameinput').value;
	const mphone = document.querySelector('.mphoneinput').value;
	
	// 객체화
	const obj = { mid : mid , mpwd : mpwd , mname : mname , mphone : mphone }
	 
	// option
	const option = {
		method : 'POST' ,
		headers : { 'Content-Type' : 'application/json' },
		body : JSON.stringify( obj )
	}
	 
	// fetch
	fetch(`/TeamProject02/afiliado/signup` , option )
		.then( response => response.json() )
		.then( data => {
			if( data == true ){ alert('회원가입 성공'); location.href = "memberLogin.jsp"; }
			else{ alert('회원가입 실패'); }
		}) // thed end
		.catch( error => { console.log( error ); } )
	
} // f end