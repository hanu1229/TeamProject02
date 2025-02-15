

console.log("admin-member.js open");

/** 회원 목록 전체 출력 */
let printAll = () => {
	
	let tbody = document.querySelector("#member-table > tbody");
	let html = ``;
	
	const option = {method : "GET"};
	fetch(`/TeamProject02/admin/member`, option)
	.then(response => response.json())
	.then(data => {
		let count = 0;
		data.forEach(obj => {
			// 판매권한 숫자를 문자열 O, X, 관리자로 변경
			let msellString = msellToString(obj.msell);
			html = `
			<tr id = "member-${obj.mno}">
				<td>${obj.mno}</td>
				<td>${obj.mid}</td>
				<td>${obj.mname}</td>
				<td>${obj.mphone}</td>
				<td>${obj.mdate}</td>
				<td id = "msell-state${obj.mno}">${msellString}</td>
				<td>
					<button id = "msell-btn${obj.mno}" class = "btn btn-primary btn-enable" type = "button" onclick = "">
						변경
					</button>
				</td>
				<td>
					<button class = "btn btn-primary" type = "button" onclick = "requestDeleteMember(${obj.mno})">탈퇴</button>
				</td>
			</tr>
			`;
			// 판매권한을 가진 사람은 다시 권한을 갖지 않도록 버튼을 비활성화
			tbody.innerHTML += html;
			count++;
		});
		//tbody.innerHTML = html;
		for(let index = 0; index < data.length; index++) {
			let msell = document.querySelector(`#msell-state${data[index].mno}`);
			let btn = document.querySelector(`#msell-btn${data[index].mno}`)
			console.log(msell.innerHTML);
			let str = msell.innerHTML;
			if(str === "관리자") {
				btn.disabled = true;
			} else {
				btn.addEventListener("click", () => changeMsellState(data[index].mno));
			}
			//btn.onclick = function() {alert("활성화"); };
		}
	})
	.catch(error => { console.log(error); });
	
}
printAll();

/** 판매권한 문자열로 변경 */
function msellToString(msell) {
	let str = "";
	switch(msell) {
		case 0:
			str = "X";
			break;
		case 1:
			str = "O";
			break;
		case 9:
			str = "관리자";
			break;
	}
	return str;
}

/** 판매권한 변경 */
function changeMsellState(mno) {
	// str에 따라 다른 기능을 구현
	// O일 경우 판매권한을 없애기
	// X일 경우 판매권한을 주기
	let msellState = document.querySelector(`#msell-state${mno}`);
	let number = 0;
	let state = ``;
	if(msellState.innerHTML === "O") {
		number = 0;
		requestChangeMsell(mno, number)
		.then(data => {
			console.log(data);
			state = msellToString(data.msell);
			msellState.innerHTML = state;
		});
	} else if (msellState.innerHTML === "X") {
		number = 1;
		requestChangeMsell(mno, number)              
		.then(data => {			
			console.log(data);
			state = msellToString(data.msell);
			msellState.innerHTML = state;
		});
	}
	return alert("권한을 변경했습니다.");
	
}

/** 서버에게 판매권한 수정 요청 */
function requestChangeMsell(mno, number) {
	let obj = {mno : mno, msell : number};
	let option = {
		method : "PUT",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)
	};
	return fetch(`/TeamProject02/admin/member`, option)
	.then(response => response.json())
	.then(data => {
		return data;
	})
	.catch(error => { console.log(error); });
	
}

/** 서버에게 회원삭제 요청 */
function requestDeleteMember(mno) {
	
	let option = {method : "DELETE"};
	fetch(`/TeamProject02/admin/member?mno=${mno}`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {
			alert("정상적으로 탈퇴되었습니다.");
		} else {
			alert("탈퇴에 실패했습니다.");
		}
	})
	.catch(error => { console.log(error); });
	
}


