

console.log("admin-haeder.js open");

let checkLogin = () => {
	
	const option = {method : "GET"};
	fetch(`/TeamProject02/admin/check`, option)
	.then(response => response.json())
	.then(data => {
		console.log("로그인 체크");
		if(data == false) {
			location.href = "admin-login.jsp";
		}
	})
	.catch(error => { console.log(error); });
	
}
//checkLogin();