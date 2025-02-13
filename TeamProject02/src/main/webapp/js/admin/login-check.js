

console.log("login-check.js open");
/** 페이지 로드 시 로그인 상태 체크 */
let loginCheck = () => {

	const option = {method : "GET"};
	// Fetch 요청을 보내 세션 상태 확인
	fetch(`/TeamProject02/admin/check`, option)
	.then(response => response.json())
	.then(data => {
		console.log(data);
		console.log("실행1");
		if (data != null) {
			document.querySelector("#login-name").innerHTML = data;
		} else {
			alert("로그인이 필요합니다.");
			// 로그인 페이지 경로
			location.href = "/TeamProject02/admin/admin-login.jsp";
		}
	})
	.catch(error => { console.log("로그인 상태 확인 중 오류 발생:", error); });	
}
loginCheck();