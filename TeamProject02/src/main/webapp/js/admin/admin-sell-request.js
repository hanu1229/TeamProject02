

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
				<td style ="width : 13%;"><a style = "cursor : pointer;" onclick = "downloadFile('${obj.sfile}')">${obj.sfile}</a></td>
				<td style ="width : 20%;">${obj.sdate}</td>
				<td id = "sstate${obj.sno}" style ="width : 7%;">${sstate}</td>
				<td class = "ellipsis-text" style ="width : 20%;">${obj.sadd}</td>
				<td style ="width : 10%;">${obj.mname} / ${obj.mno}</td>
				<td style ="width : 20%;">
					<button id = "accept-btn${obj.sno}" class = "btn btn-primary" type = "button" onclick = "acceptSell('${obj.mname}', ${obj.mno}, ${obj.sno})">수락</button>
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
function acceptSell(mname, mno, sno) {
	let modalBtn = document.querySelector("#modal-btn");
	modalBtn.click();
	let SellModalTable = document.querySelector(`#sell-modal`);
	SellModalTable.innerHTML = `
	<div class="modal-header">
		<h1 class="modal-title fs-5" id="staticBackdropLabel">매물 등록</h1>
		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	</div>
	<div class="modal-body">
		<table id = "sell-modal-table" style = "width : 100%;">
			<tbody>
					<tr>
						<th class="py-3">카테고리</th>
						<td><input class= "form-control" placeholder = "0 : 아파트, 1 : 주택, 2 : 오피스텔" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">주소</th>
						<td><input class= "form-control" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">위도</th>
						<td><input class= "form-control" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">경도</th>
						<td><input class= "form-control" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">동</th>
						<td><input class= "form-control" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">층수</th>
						<td><input class= "form-control" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">가격</th>
						<td><input class= "form-control" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">면적</th>
						<td><input class= "form-control" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">준공년도 (20XX.XX)</th>
						<td><input class= "form-control" placeholder = "연도.월" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">구조</th>
						<td><input class= "form-control" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">소유권 대상</th>
						<td><input class= "form-control" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">회원이름 / 번호</th>
						<td><input class= "form-control" readonly value = "${mname} / ${mno}" type = "text"/></td>
					</tr>
					<tr>
						<th class="py-3">추가내용</th>
						<td><textarea id = "textarea-add" class="form-control" rows="6"></textarea></td>
					</tr>
			</tbody>
		</table>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
		<button id = "model-submit" type="button" class="btn btn-primary" onclick = "submitProperty(${sno})">등록</button>
	</div>
	`;
}

/** 매물 등록 정보 전송 */
function submitProperty(sno) {
	let inputType = document.querySelectorAll(`#sell-modal-table > tbody > tr > td > input`);
	let textareaType = document.querySelector(`#sell-modal-table > tbody > tr > td > textarea`);
	let list = makeData(inputType, textareaType);
	console.log(list);
	let obj = {
		pcategory : list[0],
		paddress : list[1],
		plat : list[2],
		plong : list[3],
		pbuilding : list[4],
		pstorey : list[5],
		mprice : list[6],
		parea : list[7],
		pyear : list[8],
		pstructure : list[9],
		puser : list[10],
		mno : list[12],
		padd : list[13],
		sno : sno
	};
	let option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)
	};
	fetch(`/TeamProject02/admin/sell`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {
			alert("매물이 등록되었습니다.");
			let acceptBtn = document.querySelector(`#accept-btn${sno}`);
			let refuseBtn = document.querySelector(`#refuse-btn${sno}`);
			acceptBtn.disabled = true;
			refuseBtn.disabled = true;
			location.href = "/TeamProject02/admin/admin-sell-request.jsp";
		} else {
			alert("매물 등록에 실패했습니다.");
		}
	})
	.catch(error => { console.log(error); });
	
}

/** 매물 등록을 위한 리스트 split 함수 */
function makeData(inputType, textareaType) {
	let str = ``;
	let tempList = [];
	let list = [];
	for(let index = 0; index < inputType.length; index++) {
		str = inputType[index].value;
		tempList = str.split("/");
		if(tempList.length == 2) {
			list.push(tempList[0]);
			list.push(tempList[1]);
		} else if(tempList.length == 1) {			
			list.push(str);
		}
	}
	list.push(textareaType.value);
	return list;
}

/** 다운로드 버튼 클릭 시 파일 다운로드 */
function downloadFile(sfile) {
	const option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify({file : sfile})
	};
    fetch(`/TeamProject02/admin/sell-download`, option)
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
        a.download = `${sfile}`;
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




