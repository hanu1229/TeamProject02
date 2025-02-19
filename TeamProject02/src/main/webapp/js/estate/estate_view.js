// 페이지네이션 버튼 클릭 시 데이터만 로드
const getPageBtn = (response, pcategory) => {
    const page = parseInt(response.currentPage); // 현재 페이지
    const totalPage = response.totalPage; // 총 페이지 수
    const startbtn = response.startbtn; // 시작 페이지 번호
    const endbtn = response.endbtn; // 끝 페이지 번호

    const pagebtnbox = document.querySelector('.pagebtnbox');
    let html = '';

    // (1) 이전 버튼
    html += `<li class="page-item">
                <a class="page-link" href="#" data-page="${page <= 1 ? 1 : page - 1}" data-pcategory="${pcategory}">
                    이전
                </a>
            </li>`;

    // (2) 페이지 번호 버튼
    for (let index = startbtn; index <= endbtn; index++) {
        html += `<li class="page-item">
                    <a class="page-link" href="#" data-page="${index}" data-pcategory="${pcategory}">
                        ${index}
                    </a>
                </li>`;
    }

    // (3) 다음 버튼
    html += `<li class="page-item">
                <a class="page-link" href="#" data-page="${page >= totalPage ? page : page + 1}" data-pcategory="${pcategory}">
                    다음
                </a>
            </li>`;

    // 페이지 버튼 HTML 삽입
    pagebtnbox.innerHTML = html;

    // 페이지네이션 버튼에 클릭 이벤트 리스너 추가
    const pageLinks = document.querySelectorAll('.page-link');
    pageLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault(); // 기본 동작 방지 (페이지 이동 방지)
            const newPage = e.target.getAttribute('data-page'); // 클릭된 페이지
            const category = e.target.getAttribute('data-pcategory'); // 클릭된 카테고리

            // 페이지 변경 시 데이터를 다시 가져와서 테이블 갱신
            findAll(newPage, category);
        });
    });
};

// 페이지 데이터 가져오기
const findAll = (page = 1, pcategory) => {
    const mno = new URL(location.href).searchParams.get("mno"); // 현재 mno 값
    // pcategory가 10이면 모든 카테고리의 데이터를 요청
    const url = `/TeamProject02/estate/info?mno=${mno}&pcategory=${pcategory}&page=${page}`;  // 빈 문자열 대신 '10'으로 보내기

    fetch(url)
        .then((res) => res.json())  // 응답을 JSON 형태로 변환
        .then((response) => {
            // 페이지가 제대로 반영되었는지 확인
            console.log('Current Page:', response.currentPage);
            console.log('Total Pages:', response.totalPage);
            console.log('Properties:', response.properties);
            
            // 테이블 내용 갱신
            updateTable(response.properties);
            // 페이지 버튼 갱신
            getPageBtn(response, pcategory);
        })
        .catch((error) => {
            console.log(error);
            document.querySelector(".estate_table tbody").innerHTML = "<tr><td colspan='12'>Error loading data</td></tr>";
        });
};

// 셀렉트 박스 변경 시 데이터 갱신
document.querySelector(".estateview_select").addEventListener("change", (e) => {
    const pcategory = e.target.value;
    findAll(1, pcategory); // 페이지를 1로 리셋하고 새 카테고리 데이터 로드
});


// 테이블 내용 갱신
const updateTable = (properties) => {
    const estateTable = document.querySelector(".estate_table tbody");
    let html = '';

    // pcategory와 psell 변환용 매핑 객체
    const categoryMap = {
        0: "아파트",
        1: "주택",
        2: "오피스텔",
    };

    const sellStatusMap = {
        0: "판매중",
        1: "판매완료",
        2: "판매중지",
    };

    if (Array.isArray(properties) && properties.length > 0) {
        properties.forEach((property) => {
            html += `<tr>
                        <td>${property.pno}</td>
                        <td>${categoryMap[property.pcategory] || "기타"}</td>
                        <td>${property.paddress}</td>
                        <td>${property.pbuilding}</td>
                        <td>${property.pstorey}</td>
                        <td>${property.parea}</td>
                        <td>${property.pyear}</td>
                        <td>${property.pstructure}</td>
                        <td>${property.puser}</td>
                        <td>${property.padd}</td>
                        <td>${property.pdate}</td>
                        <td>${sellStatusMap[property.psell] || "알수없음"}</td>
                        <td>
                            <div class="btn-group" role="group">
                                <button type="button" class="eUpdate btn btn-primary" data-bs-toggle="modal" data-bs-target="#updateModal" 
                                    data-pno="${property.pno}" data-padd="${property.padd}">수정</button>
                                <button type="button" class="eStop btn btn-primary ms-1" data-bs-toggle="modal" data-bs-target="#deleteModal"
                                    data-pno="${property.pno}">중지</button>
                            </div>
                        </td>
                    </tr>`;
        });
    } else {
        html = "<tr><td colspan='12'>카테고리에 맞는 매물이 없습니다.</td></tr>";
    }

    estateTable.innerHTML = html;
};

// 초기 데이터 로드
const initialLoad = () => {
    const pcategory = document.querySelector(".estateview_select").value;
    findAll(1, pcategory);
};

// 셀렉트 박스 변경 시 데이터 갱신
document.querySelector(".estateview_select").addEventListener("change", (e) => {
    const pcategory = e.target.value;
    findAll(1, pcategory); // 페이지를 1로 리셋하고 새 카테고리 데이터 로드
});

// 페이지 로드 시 데이터 요청
initialLoad();


