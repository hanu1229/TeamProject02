

console.log("admin-property.js open");

/** 등록된 매물 목록 전체 출력 */
let printAll = () => {
	
	let page = new URL(location.href).searchParams.get("page");
	console.log("page : " + page);
	let tbody = document.querySelector("#property-table > tbody");
	let html = ``;
	let option = {method : "GET"};
	
	fetch(`/TeamProject02/admin/property`, option)
	.then(response => response.json())
	.then(data => {
		data.forEach(obj => {
			let pcategory = changeToCategory(obj.pcategory);
			let psell = changeToSell(obj.psell);;
			html += `
			<tr class = "text-center">
				<td style ="width : 10%;"><a style = "cursor : pointer;" onclick = "detail(${obj.pno})">${obj.pno}</a></td>
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
		case 2:
			str = "판매중지";
			break;
	}
	return str;
}

// ----------------------------------------------------

/** 등록된 매물 상세보기 */
function detail(pno) {
	let option = {method : "GET"};
	fetch(`/TeamProject02/admin/property/detail?pno=${pno}`, option)
	.then(response => response.json())
	.then(data => {
		console.log(data);
		let category = changeToCategory(data.pcategory);
		let psell = changeToSell(data.psell);
		let modalBtn = document.querySelector("#modal-btn");
		modalBtn.click();
		let SellModalTable = document.querySelector(`#property-modal`);
		SellModalTable.innerHTML = `
		<div class="modal-header">
			<h1 class="modal-title fs-5" id="staticBackdropLabel">매물 상세정보 / ${psell}</h1>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		</div>
		<div class="modal-body">
			<div style = "text-align : center;">
				<img src = "${data.photo}" style = "width: 450px; object-fit:cover;"/>
			</div>
			<table style = "width : 100%;">
				<tbody>
						<tr>
							<th class="py-3">카테고리</th>
							<td><input class= "form-control" readonly value = "${category}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">주소</th>
							<td><input class= "form-control" readonly value = "${data.paddress}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">위도</th>
							<td><input class= "form-control" readonly value = "${data.plat}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">경도</th>
							<td><input class= "form-control" readonly value = "${data.plong}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">동</th>
							<td><input class= "form-control" readonly value = "${data.pbuilding}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">층수</th>
							<td><input class= "form-control" readonly value = "${data.pstorey}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">가격</th>
							<td><input class= "form-control" readonly value = "${data.mprice}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">면적</th>
							<td><input class= "form-control" readonly value = "${data.parea}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">준공년도</th>
							<td><input class= "form-control" readonly value = "${data.pyear}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">구조</th>
							<td><input class= "form-control" readonly value = "${data.pstructure}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">소유권 대상</th>
							<td><input class= "form-control" readonly value = "${data.puser}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">회원이름 / 번호</th>
							<td><input class= "form-control" readonly value = "${data.mname} / ${data.mno}" type = "text"/></td>
						</tr>
						<tr>
							<th class="py-3">추가내용</th>
							<td><textarea id = "textarea-add" readonly class="form-control" rows="6">${data.padd}</textarea></td>
						</tr>
				</tbody>
			</table>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-primary" data-bs-dismiss="modal" style = "width : 100%">닫기</button>
		</div>
		`;
	})
	.catch(error => { console.log(error); });

}


