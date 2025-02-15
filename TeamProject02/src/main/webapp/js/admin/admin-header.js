

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

function changeList(name) {
	console.log(name);
	if(name === "admin-member"){
		location.href = "/TeamProject02/admin/admin-member.jsp";
	} else if(name === "admin-brokerage") {
		location.href = "/TeamProject02/admin/admin-brokerage.jsp";
	} else if(name === "admin-sell-request") {
		location.href = "/TeamProject02/admin/admin-sell-request.jsp"
	} else if(name === "admin-property") {
		location.href = "/TeamProject02/admin/admin-property.jsp";
	}
}

function checkList() {
	let url = location.href;
	console.log(url);
	url = url.split("/");
	console.log(url);
	let adminMember = document.querySelector("#admin-member");
	let adminBrokerage = document.querySelector("#admin-brokerage");
	let adminSellRequest = document.querySelector("#admin-sell-request");
	let adminProperty = document.querySelector("#admin-property");
	// link-body-emphasis
	if(url[5] === "admin-member.jsp") {
		adminMember.classList.toggle("active");
		adminBrokerage.classList.toggle("link-body-emphasis");
		adminSellRequest.classList.toggle("link-body-emphasis");
		adminProperty.classList.toggle("link-body-emphasis");
	} else if(url[5] === "admin-brokerage.jsp") {
		adminMember.classList.toggle("link-body-emphasis");
		adminBrokerage.classList.toggle("active");
		adminSellRequest.classList.toggle("link-body-emphasis");
		adminProperty.classList.toggle("link-body-emphasis");
	} else if(url[5] === "admin-sell-request.jsp") {
		adminMember.classList.toggle("link-body-emphasis");
		adminBrokerage.classList.toggle("link-body-emphasis");
		adminSellRequest.classList.toggle("active");
		adminProperty.classList.toggle("link-body-emphasis");
	} else if(url[5] === "admin-property.jsp") {
		adminMember.classList.toggle("link-body-emphasis");
		adminBrokerage.classList.toggle("link-body-emphasis");
		adminSellRequest.classList.toggle("link-body-emphasis");
		adminProperty.classList.toggle("active");
	}
	
}
checkList();

