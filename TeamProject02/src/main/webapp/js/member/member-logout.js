function logout() {
    fetch('/TeamProject02/afiliado/info', { method: 'DELETE' })
        .then(response => response.json())
        .then(data => {
            if (data) {
                alert("로그아웃 되었습니다.");
                location.href = "/TeamProject02/client/map.jsp";
            }
        })
        .catch(error => console.error('로그아웃 오류:', error));
}