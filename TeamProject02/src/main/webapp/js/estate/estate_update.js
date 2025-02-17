console.log('estate_update!!');

// 수정 버튼 클릭 시 수정 모달에 pno, padd 값 넣는 코드
document.addEventListener('click', (e) => {
    if (e.target.classList.contains('eUpdate')) {
        // 클릭된 버튼에서 data-pno와 data-padd 값 가져오기
        const pno = e.target.getAttribute('data-pno');
        const padd = e.target.getAttribute('data-padd');

        // 콘솔 확인
        console.log('수정 버튼 클릭됨');
        console.log('data-pno:', pno);
        console.log('data-padd:', padd);

        // 모달 내부의 입력 필드에 값 설정
        document.querySelector('.update-pno').value = pno;  // 매물 번호
        document.querySelector('.evalue').value = padd;  // 상세 내용
    }
});

const eUpdate = () => {
    const padd = document.querySelector('.evalue').value;  // 수정할 내용
    const pno = document.querySelector('.update-pno').value;  // 수정할 매물 번호

    console.log('수정 요청 보냄 - pno:', pno, ', padd:', padd);

    const obj = { pno: pno, padd: padd };

    fetch(`/TeamProject02/estate/info`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(obj)
    })
    .then(response => response.json())
    .then(data => {
        if (data === true) {
            alert('수정 성공');
            location.reload();  // 페이지 새로고침하여 변경된 내용 반영
        } else {
            alert('수정 실패');
        }
    })
    .catch(error => {
        console.log('오류 발생:', error);
    });
};

