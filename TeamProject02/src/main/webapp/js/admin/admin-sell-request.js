

console.log("admin-sell-request.js open");
/** 신청한 매물 전체 출력 */
let printAll = () => {
	
	let tbody = document.querySelector("#sell-table > tbody");
	let html = ``;
	let option = {method : "GET"};
	
	fetch(`/TeamProject02/admin/sell`, option)
	.then(response => response.json())
	.then(data => {
		data.forEach(obj => {
			html += `
			<tr>
				<td>${obj.sno}</td>
				<td>${obj.sfile}</td>
				<td>${obj.sdate}</td>
				<td>${obj.sstate}</td>
				<td>${obj.sadd}</td>
				<td>${obj.mname} / ${obj.mno}</td>
				<td></td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
	})
	.catch(error => { console.log(error); });
}
printAll();