

console.log("admin-member.js open");

/** 회원 목록 전체 출력 */
let printAll = () => {
	
	let tbody = document.querySelector("#member-table > tbody");
	let html = ``;
	
	const option = {method : "GET"};
	fetch(`/TeamProject02/admin/member`, option)
	.then(response => response.json())
	.then(data => {
		data.forEach(obj =>{
			html += `
			<tr>
				<td>${obj.mno}</td>
				<td>${obj.mid}</td>
				<td>${obj.mname}</td>
				<td>${obj.mphone}</td>
				<td>${obj.mdate}</td>
				<td>${obj.msell}</td>
				<td>${obj.msell}</td>
				<td>${obj.msell}</td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
	})
	.catch(error => { console.log(error); });
	
}
printAll();