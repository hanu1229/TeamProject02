

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
			let sstate = changeToStringSstate(obj.sstate);
			html += `
			<tr>
				<td style ="width : 10%;">${obj.sno}</td>
				<td style ="width : 13%;">${obj.sfile}</td>
				<td style ="width : 20%;">${obj.sdate}</td>
				<td id = "sstate${obj.sno}" style ="width : 7%;">${sstate}</td>
				<td class = "ellipsis-text" style ="width : 20%;">${obj.sadd}</td>
				<td style ="width : 10%;">${obj.mname} / ${obj.mno}</td>
				<td style ="width : 20%;">
					<button id = "accept-btn${obj.sno}" class = "btn btn-primary" type = "button" onclick = "">수락</button>
					<button id = "refuse-btn${obj.sno}" class = "btn btn-primary" type = "button" onclick = "refuseSell(${obj.sno}, 2)">거절</button>
				</td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
		for(let index = 0; index < data.length; index++) {
			let sstate = document.querySelector(`#sstate${data[index].sno}`);
			let acceptBtn = document.querySelector(`#accept-btn${data[index].sno}`);
			let refuseBtn = document.querySelector(`#refuse-btn${data[index].sno}`);
			if(sstate.innerHTML === "수락" || sstate.innerHTML === "거절" || sstate.innerHTML === "취소") {
				acceptBtn.disabled = true;
				refuseBtn.disabled = true;
			} else {
				acceptBtn.disabled = false;
				refuseBtn.disabled = false;
			}
		}
	})
	.catch(error => { console.log(error); });
}
printAll();

/** 신청상태 문자로 변경 */
function changeToStringSstate(sstate) {
	
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

/** 신청 매물 목록 거절 클릭 시 */
function refuseSell(sno, newState) {
	let state = confirm("정말로 거절하시겠습니까?");
	if(state == true) {		
		let option = {
			method : "PUT",
			headers : {"Content-Type" : "application/json"},
			body : JSON.stringify({sno : sno, sstate : newState})
		};
		fetch(`/TeamProject02/admin/sell`, option)
		.then(response => response.json())
		.then(data => {
			let value = document.querySelector(`#sstate${sno}`);
			let str = changeToStringSstate(data.sstate);
			value.innerHTML = str;
			if(value.innerHTML === "수락") {
				alert("수락하셨습니다.");
				let acceptBtn = document.querySelector(`#accept-btn${sno}`);
				let refuseBtn = document.querySelector(`#refuse-btn${sno}`);
				acceptBtn.disabled = true;
				refuseBtn.disabled = true;
			} else if(value.innerHTML === "거절") {
				alert("거절하셨습니다.");
				let acceptBtn = document.querySelector(`#accept-btn${sno}`);
				let refuseBtn = document.querySelector(`#refuse-btn${sno}`);
				acceptBtn.disabled = true;
				refuseBtn.disabled = true;
			}
		})
		.catch(error => { console.log(error); });
	}
}

/** 신청 매물 목록 수락 버튼 클릭 시 */
function acceptSell() {
	let SellModalTable = document.querySelector(`#sell-modal-table > tbody`);
}






