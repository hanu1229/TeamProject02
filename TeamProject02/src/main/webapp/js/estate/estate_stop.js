console.log( 'estate_stop!!');

// 중지 버튼 클릭 시 삭제 모달에 pno 값 넣는 코드
document.addEventListener('click', (e) => {
    if (e.target.classList.contains('eStop')) {
        // 클릭된 버튼에서 data-pno 값 가져오기
        const pno = e.target.getAttribute('data-pno');

        // 콘솔 확인
        console.log('중지 버튼 클릭됨');
        console.log('data-pno:', pno);

        // 모달 내부의 입력 필드에 값 설정
        document.querySelector('.delete-pno').value = pno;  // 매물 번호
    }
});

const eStop = () => {
    const pno = document.querySelector('.delete-pno').value;  // 수정할 매물 번호

    console.log('수정 요청 보냄 - pno:', pno );
	
    const obj = { pno: pno };

    fetch(`/TeamProject02/estate/stop`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(obj)
    })
    .then(response => response.json())
    .then(data => {
        if (data === true) {
            alert('판매중지로 변경되었습니다.');
            location.reload();  // 페이지 새로고침하여 변경된 내용 반영
        } else {
            alert('판매중지로 변경을 실패하였습니다.');
        }
    })
    .catch(error => {
        console.log('오류 발생:', error);
    });
}
/* // 매물 삭제
const eDelete = () => {
	const pno = document.querySelector('.delete-pno').value; // 삭제할 번호
	
	console.log('삭제 요청 보냄 - pno ' , pno ); // 콘솔
	
	const option = { method : 'DELETE' }
	fetch(`/TeamProject02/estate/info?pno=${pno}` , option )
		.then( response => response.json() )
		.then( data => {
			if( data == true ){ alert('삭제 성공'); location.reload(); }
			else{ alert('삭제 실패'); }
		})
		.catch( error => { console.log( error ); } )
} // f end */