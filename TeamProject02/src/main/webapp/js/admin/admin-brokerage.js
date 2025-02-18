

console.log("admin-brokerage.js open");

/** 중개한 매물 전체 조회 */
let printAll = () => {
	
	let tbody = document.querySelector(`#brokerage-table > tbody`);
	let html = ``;
	let option = {method : "GET"};
	fetch(`/TeamProject02/admin/brokerage`, option)
	.then(response => response.json())
	.then(data => {
		console.log(data);
		data.forEach(obj => {
			html += `
			<tr>
				<td style = "width : 5%;">${obj.bno}</td>
				<td>${obj.bfile}</td>
				<td>${obj.bdate}</td>
				<td>${obj.bmanager}</td>
				<td class = "ellipsis-text">${obj.bcomment}</td>
				<td>${obj.mname}/${obj.mno}</td>
				<td style = "width : 10%;">${obj.pno}</td>
				<td>
					<button class = "btn btn-primary" type = "button" onclick = "downloadFile('${obj.bfile}')">다운로드</button>
				</td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
	})
	.catch(error => { console.log(error); });
	
}
printAll();

/** 다운로드 버튼 클릭 시 파일 다운로드 */
function downloadFile(bfile) {
	const option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify({file : bfile})
	};
    fetch(`/TeamProject02/admin/brokerage`, option)
	// response.bolb() : 서버에서 응답을 Blob(바이너리 데이터)로 변환
    .then(response => response.blob())  
    .then(blob => {
		// Bolb 데이터를 가리키는 임시 URL 생성
		const url = window.URL.createObjectURL(blob);
		console.log("url : " + url);
		// <a> 태그 생성
        const a = document.createElement("a");
		// <a> 태그의 링크를 임시 URL로 변경
        a.href = url;
		// 다운로드 될 파일명 지정
        a.download = `${bfile}`;
		// <a> 태그를 문서의 body에 추가 (클릭 이벤트를 실행하기 위함)
        document.body.appendChild(a);
		// <a> 태그를 자동으로 클릭하여 다운로드 실행
        a.click();
		// <a> 태그를 문서에서 제거
        a.remove();
		// 임시 URL을 삭제(해제)해서 메모리 누수 방지
        window.URL.revokeObjectURL(url);
    })
    .catch(error => console.error("파일 다운로드 오류:", error));
}