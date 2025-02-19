

console.log("admin-property.js open");

/** 등록된 매물 목록 전체 출력 */
let printAll = () => {
	
	let page = new URL(location.href).searchParams.get("page");
	console.log("page : " + page);
	let tbody = document.querySelector("#property-table > tbody");
	let html = ``;
	let option = {method : "GET"};
	
	fetch(`/TeamProject02/admin/property?page=${page}`, option)
	.then(response => response.json())
	.then(data => {
		data.forEach(obj => {
			let pcategory = changeToCategory(obj.pcategory);
			let psell = changeToSell(obj.psell);;
			html += `
			<tr class = "text-center">
				<td style ="width : 10%;">${obj.pno}</td>
				<td style ="width : 10%;">${pcategory}</td>
				<td class = "ellipsis-text" style ="width : 30%;">${obj.paddress}</td>
				<td style ="width : 10%;">${obj.pyear}</td>
				<td style ="width : 20%;">${obj.pdate}</td>
				<td style ="width : 10%;">${psell}</td>
				<td style ="width : 10%;">${obj.mname} / ${obj.mno}</td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
	})
	.catch(error => { console.log(error); });
}
printAll();

/** 카테고리를 문자열로 변경 */
function changeToCategory(pcategory) {
	let str = "";
	switch(pcategory) {
		case 0:
			str = "아파트";
			break;
		case 1:
			str = "주택";
			break;
		case 2:
			str = "오피스텔";
			break;
	}
	return str;
}

/** 판매상태 문자열로 변경 */
function changeToSell(psell) {
	let str = "";
	switch(psell) {
		case 0:
			str = "미판매";
			break;
		case 1:
			str = "판매";
			break;
	}
	return str;
}