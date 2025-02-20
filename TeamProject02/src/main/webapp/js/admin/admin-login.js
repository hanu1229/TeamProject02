


console.log("admin-login.js open");
/** 로그인 함수 */
let onLogin = () => {

	let midInput = document.querySelector("#mid-input");
	let mpwdInput = document.querySelector("#mpwd-input");
	let mid = midInput.value;
	let mpwd = mpwdInput.value;
	let object = {mid : mid, mpwd : mpwd};
	const option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(object)
	};
	fetch(`/TeamProject02/admin/login`, option)
	.then(response => response.json())
	.then(data => {
		if(data != 0) {
			alert("로그인 성공");
			location.href = "/TeamProject02/admin/admin-member.jsp";
		} else  {
			alert("로그인 실패");
		}
	})
	.catch(error => { console.log(error); });
	
}

/** 로그아웃 함수 */
let logOut = () => {
	
	let state = confirm("정말 로그아웃 하시겠습니까?");
	console.log(`state : ${state}`);
	if(state == true) {
		const option = {method : "DELETE"};
		fetch(`/TeamProject02/admin/login?state=${state}`, option)
		.then(response => response.json())
		.then(data => {
			if(data == true) {
				alert("로그아웃 성공");
				location.href = "admin-login.jsp";
			} else {
				alert("로그아웃 실패");
			}
		})
		.catch(error => { console.log(error); });
	}
	
}