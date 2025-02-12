


console.log("admin-login.js open");
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
	fetch(`/TeamProject02/admin/member`, option)
	.then(response => response.json())
	.then(data => {
		if(data != 0) {
			alert("로그인 성공");
			location.href = "/TeamProject02/admin/admin.jsp"			
		} else  {
			alert("로그인 실패");
		}
	})
	.catch(error => { console.log(error); });
	
}