

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
				<td>${obj.bno}</td>
				<td>${obj.bfile}</td>
				<td>${obj.bdate}</td>
				<td>${obj.bmanager}</td>
				<td class = "ellipsis-text">${obj.bcomment}</td>
				<td>${obj.mname}/${obj.mno}</td>
				<td>${obj.pno}</td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
	})
	.catch(error => { console.log(error); });
	
}
printAll();