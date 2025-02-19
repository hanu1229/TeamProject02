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
        const position = new kakao.maps.LatLng(property.plat, property.plong);

        const marker = new kakao.maps.Marker({
            position: position,
            title: property.paddress
        });

        // 마커 클릭 이벤트 추가
        kakao.maps.event.addListener(marker, 'click', function () {
            showPropertyDetail(property);
        });

        markers.push(marker);
    });

    // 클러스터러에 마커 추가
    clusterer.addMarkers(markers);
}

// 부동산 상세 정보 표시
function showPropertyDetail(property) {
    const detailContainer = document.querySelector('.property-detail');
    detailContainer.innerHTML = `
        <h3>${property.paddress}</h3>
        <p>${property.paddress}</p>
        <p>가격: ${property.mprice*10000}원</p>
        <p>설명: ${property.padd}</p>		
        <button onclick="closeDetail()">닫기</button>
		<button onclick="DetailOpen()">상세정보보기</button>
    `;
    detailContainer.style.display = "block";
}

// 상세 정보 닫기
function closeDetail() {
    document.querySelector('.property-detail').style.display = "none";
}

// 페이지 로드 후 실행
window.onload = function () {
    initMap();
};
