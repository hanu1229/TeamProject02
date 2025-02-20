let map;
let clusterer;
let markers = [];

// 지도 초기화
function initMap() {
    if (typeof kakao === 'undefined') {
        console.error('Kakao maps API not loaded');
        return;
    }

    const mapContainer = document.getElementById('map');
    const mapOption = {
        center: new kakao.maps.LatLng(37.4927689553243, 126.719082567274),
        level: 8
    };

    // 지도 생성
    map = new kakao.maps.Map(mapContainer, mapOption);

    // 클러스터러 생성
    clusterer = new kakao.maps.MarkerClusterer({
        map: map,
        averageCenter: true,
        minLevel: 6,
        disableClickZoom: true
    });

    // 마커 및 이벤트 등록
    loadProperties();
}

// 부동산 매물 데이터 불러오기
function loadProperties() {
	
	fetch( '/TeamProject02/client/view'  )
		.then( response => response.json() )
		.then( data => {
			console.log( data );
			addMarkers(data);
			
		})
		.catch( e => { console.log(e) })

}

// 지도에 마커 추가
function addMarkers(properties) {
    markers = [];

    properties.forEach(property => {
		if(property.psell == 0) {
	        const position = new kakao.maps.LatLng(property.plat, property.plong);
	
	        const marker = new kakao.maps.Marker({
	            position: position,
	            title: property.paddress
	        });
	
	        // 마커 클릭 이벤트 추가
	        kakao.maps.event.addListener(marker, 'click', function () {
	            showPropertyDetail1(property);
	        });
	
	        markers.push(marker);
		}
    });

    // 클러스터러에 마커 추가
    clusterer.addMarkers(markers);
}

// 부동산 상세 정보 표시1
function showPropertyDetail1(property) {
    const detailContainer = document.querySelector('.property-detail');
	
	let categoryName;
	   switch(property.pcategory) {
	       case 0:
	           categoryName = "아파트";
	           break;
	       case 1:
	           categoryName = "주택";
	           break;
	       case 2:
	           categoryName = "오피스텔";
	           break;
	       default:
	           categoryName = "기타";
	   }
	
	
    detailContainer.innerHTML = `
        <h3>${property.paddress}</h3>
		<img src="${property.photo}" style = "width: 300px; object-fit:cover;"/> 
        <p style = "margin : 5px 0px; font-weight:bold;">${categoryName}</p>
        <p style = "margin : 5px 0px; font-weight:bold;">가격: ${property.mprice*10000}원</p>
        <p style = "margin : 5px 0px; font-weight:bold;">동:${property.pbuilding}</p>		
		<p style = "margin : 5px 0px; font-weight:bold;">층수:${property.pstorey}</p>
		<p style = "margin : 5px 0px; font-weight:bold;">면적:${property.parea}</p>
		<p style = "margin : 5px 0px; font-weight:bold;">준공년도:${property.pyear}</p>
		<p style = "margin : 5px 0px; font-weight:bold;">구조:${property.pstructure}</p>
		<p style = "margin : 5px 0px; font-weight:bold;">등록일:${property.pdate}</p>
		<p style = "margin : 5px 0px; font-weight:bold; ">설명: ${property.padd}</p>		
		<button class="btn btn-primary" onclick="buy(${property.pno})">구매하기</button>
		<button class="btn btn-primary" onclick="closeDetail()">닫기</button>
		`;
    detailContainer.style.display = "block";
}

// 상세 정보 닫기
function closeDetail() {
    document.querySelector('.property-detail').style.display = "none";
}

// 매물 구매 함수
function buy(pno){
	let state = confirm("정말로 구매하시겠습니까?");
	if(state) {		
		let option={
			method:"POST",
			headers:{"Content-Type":"application/json"},
			body:JSON.stringify({pno:pno})
			
		}
		
		fetch('/TeamProject02/client/view',option)
		.then(r=>r.json())
		.then(data=>{
			if(data==true){
				alert("구매완료했습니다");
				initMap();
			}else{alert("구매실패했습니다.")}
		})
		.catch(e=>{console.log(e)});
	} else {
		
	}
}


// 페이지 로드 후 실행
window.onload = function () {
    initMap();
};





