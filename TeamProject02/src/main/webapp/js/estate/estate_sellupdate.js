console.log( "estate_sellupdate!!!");

// 판매권한 1 -> 3 js
const onSellUpdate = ( ) => {
 	
	const option = {
		method : 'PUT' ,
		headers : { 'Content-Type' : 'application/json' },
		body : JSON.stringify( {mno: 1} ) 
	}
	fetch(`/TeamProject02/estate/change` , option )
		.then( response => response.json() )
		.then( data => {
			if( data == true ) { alert('판매권한 신청되었습니다.'); location.reload(); }
			else{ alert('판매권한 신청을 실패했습니다.'); }
		})
		.catch( error => { console.log( error ); } )
		
} // f end