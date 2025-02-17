

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
	const option = {method : "GET"};
    fetch(`/TeamProject02/admin/brokerage?file=${bfile}`, option)
    .then(response => response.blob())  // 파일 데이터를 Blob 형식으로 변환
    .then(blob => {
		const url = window.URL.createObjectURL(blob);
        const a = document.createElement("a");
        a.href = url;
        a.download = "sample.pdf";  // 저장할 파일명 지정
        document.body.appendChild(a);
        a.click();
        a.remove();
        window.URL.revokeObjectURL(url);
    })
    .catch(error => console.error("파일 다운로드 오류:", error));
}