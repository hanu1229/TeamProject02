console.log('member-signup.js!!');

// 회원가입 js
const memberSignUp = ( ) => {
	
	//	1. form 을 한번에 가져오기
	//const msignupform = document.querySelector('#msignupform'); // form 전체 가져오기
	// console.log( msiupform );
	const mid = document.querySelector('#mid-input');
	const mpwd = document.querySelector('#mpwd-input');
	const mname = document.querySelector('#mname-input');
	const mphone = document.querySelector('#mphone-input');
	let obj = {mid: mid.value, mpwd : mpwd.value, mname : mname.value, mphone : mphone.value};
	// FormData
	//const msignupformData = new FormData( msignupform );
	// option
	const option = {
		method : 'POST' ,
		headers : {"Conetent-Type" : "aplication/json"},
		body : JSON.stringify(obj)
	}
	 
	// fetch
	fetch(`/TeamProject02/afiliado/signup` , option )
		.then( response => response.json() )
		.then( data => {
			if( data == true ){ alert('회원가입 성공'); location.reload(); }
			else{ alert('회원가입 실패'); }
		}) // thed end
		.catch( error => { console.log( error ); } )
	
} // f end