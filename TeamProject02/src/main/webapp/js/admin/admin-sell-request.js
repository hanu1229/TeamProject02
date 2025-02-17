

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
			let sstate = changeToSstate(obj.sstate);
			html += `
			<tr>
				<td style ="width : 10%;">${obj.sno}</td>
				<td style ="width : 13%;">${obj.sfile}</td>
				<td style ="width : 20%;">${obj.sdate}</td>
				<td id = "sstate${obj.sstate}" style ="width : 7%;">${sstate}</td>
				<td class = "ellipsis-text" style ="width : 20%;">${obj.sadd}</td>
				<td style ="width : 10%;">${obj.mname} / ${obj.mno}</td>
				<td style ="width : 20%;">
					<button class = "btn btn-primary" type = "button">수락</button>
					<button class = "btn btn-primary" type = "button">거절</button>
				</td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
		for(let index = 0; index < data.length; index++) {
			let sstate = document.querySelector(`#sstate${data[index].sstate}`);
			
		}
	})
	.catch(error => { console.log(error); });
}
printAll();

/** 신청상태 문자로 변경 */
function changeToSstate(sstate) {
	
	let str = "";
	switch(sstate) {
		case 0:
			str = "대기"
			break;
		case 1:
			str = "수락";
			break;
		case 2:
			str = "거절";
			break;
		case 3:
			str = "취소";
			break;
	}
	return str;
}