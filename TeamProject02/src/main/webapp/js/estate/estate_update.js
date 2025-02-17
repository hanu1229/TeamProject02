console.log('estate_update!!');

// 수정 버튼 클릭 시 수정 모달에 pno, padd 값 넣는 코드
const updateButtons = document.querySelectorAll('.eUpdate');
updateButtons.forEach(button => {
    button.addEventListener('click', (e) => {
        // 클릭된 버튼에서 data-pno와 data-padd 값 가져오기
        const pno = e.target.getAttribute('data-pno');
        const padd = e.target.getAttribute('data-padd');

        // console.log로 확인
        console.log('Button clicked');
        console.log('data-pno:', pno);
        console.log('data-padd:', padd);

        // 수정 모달에 있는 입력 필드에 pno와 padd 값을 채우기
        document.querySelector('.evalue').value = padd;  // 상세 내용에 padd 값을 채우기
        document.querySelector('.update-pno').value = pno;  // pno 값을 채우기
    });
});




const eUpdate = () => {
    const padd = document.querySelector('.evalue').value;  // 수정할 내용
    const pno = document.querySelector('.update-pno').value;  // 수정할 pno

    // 값을 콘솔로 출력하여 확인
    console.log('Updated padd:', padd);
    console.log('Updated pno:', pno);

    const obj = { pno: pno, padd: padd };

    const option = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(obj)
    };

    fetch(`/TeamProject02/estate/info`, option)
        .then(response => response.json())
        .then(data => {
            if (data === true) {
                alert('수정 성공');
                location.href = "estateview.jsp";
            } else {
                alert('수정 실패');
            }
        })
        .catch(error => {
            console.log(error);
        });
};

