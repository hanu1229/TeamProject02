drop database if exists real_estate_brokerage;
create database real_estate_brokerage;
use real_estate_brokerage;

# 회원테이블
drop table if exists member;
create table member(
	# 회원번호
	mno int unsigned auto_increment,
    # 회원아이디
    mid varchar(30) not null unique,
    # 회원비밀번호
    mpwd varchar(30) not null,
    # 회원성명
    mname varchar(15) not null,
    # 회원전화번호
    mphone varchar(13) not null unique,
    # 가입날짜
    mdate datetime default now(),
    # 판매권한
    # 0 : false, 1 : ture, 3 : 권한신청, 9 : 관리자
    msell_state int default 0,
    constraint primary key(mno)
);

# 회원 추가 --> msell_state / 0 : 없음, 1 : 있음, 3 : 권한신청, 9 : 관리자
# 기본 : insert into member(mid, mpwd, mname, mphone) values ('qwe123', 'q123456', '서진석', '010-1111-1111');
insert into member(mid, mpwd, mname, mphone, msell_state) values ('qwe123', 'q123456', '서진석', '010-1111-1111', 1);
insert into member(mid, mpwd, mname, mphone) values ('asd123', 'w123456', '이민진', '010-2222-2222');
insert into member(mid, mpwd, mname, mphone) values ('zxc123', 'e123456', '최홍빈', '010-3333-3333');
insert into member(mid, mpwd, mname, mphone) values ('rty123', 'r123456', '한웅재', '010-4444-4444');
insert into member(mid, mpwd, mname, mphone, msell_state) values ('fgh123', 't123456', '홍길동', '010-5555-5555', 1);
insert into member(mid, mpwd, mname, mphone, msell_state) values ('admin', 'admin123', '관리자', '010-9999-9999', 9);

# 매물신청테이블
drop table if exists sell_request;
create table sell_request(
	# 신청번호
	sno int unsigned auto_increment,
    # 첨부파일
    sfile varchar(30) not null unique,
    # 신청날짜
    sdate datetime default now(),
    # 신청상태
    sstate int default 0,
    # 추가내용
    sadd text,
    # 회원번호
    mno int unsigned,
    constraint primary key(sno),
    constraint foreign key(mno) references member(mno) on delete set null
);

# 매물신청 추가 --> sstate / 0 : 대기, 1 : 수락, 2 : 거절, 3 : 취소
# 기본 : insert into sell_request(sfile, sadd, mno) values ('UUID_파일1.pdf', '최신식 엘리베이터', 5);
insert into sell_request(sfile, sadd, mno, sstate) values
('Sell_파일1.pdf', '올수리', 5, 1),
('Sell_파일2.pdf', '시스템에어컨2대', 5, 1),
('Sell_파일3.pdf', '부평시장역 도보 10분', 5, 1),
('Sell_파일4.pdf', '샷시 최근 교체', 5, 1),
('Sell_파일5.pdf', '아주 깨끗하고 조용하고 밝은 집', 5, 1),
('Sell_파일6.pdf', '부평구청역 도보 6분', 5, 1),
('Sell_파일7.pdf', '확장형, 7호선 초역세단', 5, 1),
('Sell_파일8.pdf', '역세권 도보 3분거리', 5, 1),
('Sell_파일9.pdf', '부평시작역 도보', 5, 1),
('Sell_파일10.pdf', '부평구청역 역세권', 5, 1),
('Sell_파일11.pdf', '시스템에어컨4대.줄눈.탄성.팬트리.서재', 5, 1),
('Sell_파일12.pdf', '내부 특올수리 남향 주차환경 우수함', 5, 1),
('Sell_파일13.pdf', '삼성 비스포크', 5, 1),
('Sell_파일14.pdf', '서울외곽고속도로 접근 수월', 5, 1),
('Sell_파일15.pdf', '남향, 주차환경 우수', 5, 1),
('Sell_파일16.pdf', '리모델링 완료, 남향', 5, 1),
('Sell_파일17.pdf', '대단지, 편의시설 완비', 5, 1),
('Sell_파일18.pdf', '"리모델링 완료, 남향', 5, 1),
('Sell_파일19.pdf', '남향, 주차환경 우수', 5, 1),
('Sell_파일20.pdf', '리모델링 완료, 남향', 5, 1),
('Sell_파일21.pdf', '쾌적한 편의시설', 1, 1),
('Sell_파일22.pdf', '나무 많음', 1, 1),
('Sell_파일23.pdf', '산책로', 1, 1),
('Sell_파일24.pdf', '꺠끗함', 1, 1),
('Sell_파일25.pdf', '쾌적한 편의시설', 1, 1),
('Sell_파일26.pdf', '시스템 에어컨', 1, 1),
('Sell_파일27.pdf', '조용함', 1, 1),
('Sell_파일28.pdf', '감각적인 인테리어', 1, 1),
('Sell_파일29.pdf', '정원 보유', 1, 1),
('Sell_파일30.pdf', '산책로', 1, 1),
('Sell_파일31.pdf', '방마다 시스템 에어컨', 1, 1),
('Sell_파일32.pdf', '남서향 고층 호수뷰', 1, 1),
('Sell_파일33.pdf', '올수리 및 김치냉장고', 1, 1),
('Sell_파일34.pdf', '넓은 동간 사이', 1, 1),
('Sell_파일35.pdf', '올수리 및 7호선 인접', 1, 1),
('Sell_파일36.pdf', '저층이지만 채광 좋음', 1, 1),
('Sell_파일37.pdf', '호수전망 , 펜트리', 1, 1),
('Sell_파일38.pdf', '에어컨 5대', 1, 1),
('Sell_파일39.pdf', '올수리 경기장뷰', 1, 1),
('Sell_파일40.pdf', '채광 좋음', 1, 0);


# 매물테이블
drop table if exists property;
create table property(
	# 매물번호
	pno int unsigned auto_increment,
    # 카테고리
    pcategory int not null,
    # 소재지(주소)
    paddress varchar(50) not null,
    # 지도(위도)
    plat double not null,
    # 지도(경도)
    plong double not null,
    # 동
    pbuilding int,
    # 층수
    pstorey int,
    # 면적
    parea decimal(10,2) not null,
    # 준공년도
    pyear varchar(10) not null,
    # 구조
    pstructure varchar(10) not null,
    # 등기부상 소유권 대상
    puser varchar(15),
    # 추가내용
    padd text,
    # 등록일
    pdate datetime default now(),
    # 판매상태
    psell int default 0,
    #회원번호
    mno int unsigned,
    constraint primary key(pno),
    constraint foreign key(mno) references member(mno)
);

# 매물 추가 --> pcategory / 0 : 아파트, 1 : 주택 , 2 오피스텔
# 변경해야할 사항 : 준공년도, 구조, 용적률 상한등등 실제 값으로 수정
# 변경해야할 사항 : 등기부상 소유권 대상을 가지고 있을 필요가 있는가? 회원번호가 있으니까 상관 없을거 같은데
# 용적률 빼기
-- 부평구 매물 (한웅재)
insert into property(pcategory, paddress, plat, plong, pbuilding, pstorey, parea, pyear, pstructure, puser, padd, psell, mno) values 
(0, '인천 부평구 부평문화로 37', 37.4927689553243, 126.719082567274, 2, 2, 76.74, '1986.09', '철근콘크리트', '홍길동', '올수리', 1, 5),
(0, '인천 부평구 부영로 35 e편한세상부평역센트럴파크', 37.4882700971426, 126.717135135567, 103, 5, 84.57, '2024.12', '철근콘크리트', '홍길동', '시스템에어컨2대', 1, 5),
(0, '인천 부평구 부영로 196', 37.5026526507224, 126.718118402099, 10, 2, 50.15, '1989.12', '철근콘크리트', '홍길동', '부평시장역 도보 10분', 1, 5),
(0, '인천 부평구 부영로 165 우성아파트', 37.5002788259456, 126.713048807847, 101, 2, 54.52, '1989.08', '철근콘크리트', '홍길동', '샷시 최근 교체', 1, 5),
(0, '인천 부평구 부흥로243번길 7', 37.4998000055664, 126.717938344817, 102, 12, 59.35, '1989.08', '철근콘크리트', '홍길동', '아주 깨끗하고 조용하고 밝은 집', 1, 5),
(0, '인천 부평구 원길로24번길 5', 37.5058391201221, 126.715630478675, 3, 3, 52.89, '1985.07', '철근콘크리트', '홍길동', '부평구청역 도보 6분', 1, 5),
(0, '인천 부평구 안남로 269', 37.5078041790846, 126.706738600308, 106, 5, 84.37, '2011.10', '철근콘크리트', '홍길동', '확장형, 7호선 초역세단', 0, 5),
(2, '인천 부평구 경원대로1344번길 34 e편한세상시티부평역', 37.4902833072023, 126.719138689116, 103, 16, 23.13, '2023.08', '철근콘크리트', '홍길동', '역세권 도보 3분거리', 0, 5),
(2, '인천 부평구 주부토로46번길 25', 37.4990198188142, 126.72682986713, 1, 10, 81.57, '2016.05', '철근콘크리트', '홍길동', '부평시작역 도보', 0, 5),
(2, '인천 부평구 부평대로 164', 37.5059872770484, 126.721620394141, 1, 9, 68.53, '2018.08', '철근콘크리트', '홍길동', '부평구청역 역세권', 0, 5);
-- 계양구 매물 (서진석)
INSERT INTO property (pcategory, paddress, plat, plong, pbuilding, pstorey, parea, pyear, pstructure, puser, padd, psell, mno) VALUES
(0, '인천시 계양구 작전동 765번지 일원', 37.53202893, 126.719124, 107, 13, 84.5, '2024.03', '철근콘크리트', '홍길동', '시스템에어컨4대.줄눈.탄성.팬트리.서재', 0, 5),
(0, '인천 계양구 계산동 941', 37.54299086, 126.7215723, 102, 15, 84, '2005.02', '철근콘크리트', '홍길동', '내부 특올수리 남향 주차환경 우수함', 0, 5),
(0, '인천 계양구 계산동 66', 37.53747578, 126.7328508, 107, 2, 84, '1992.01', '철근콘크리트', '홍길동', '삼성 비스포크', 0, 5),
(0, '인천 계양구 서운동 230', 37.52865087, 126.7452533, 110, 13, 72, '2010.09', '철근콘크리트', '홍길동', '서울외곽고속도로 접근 수월', 0, 5),
(0, '인천 계양구 효성동 301-1', 37.53333333, 126.7322222, 102, 15, 84, '1995.05', '철근콘크리트', '홍길동', '남향, 주차환경 우수', 0, 5),
(0, '인천 계양구 효성동 196-6', 37.53333333, 126.7322222, 104, 10, 72, '2003.03', '철근콘크리트', '홍길동', '리모델링 완료, 남향', 0, 5),
(0, '인천 계양구 작전동 912-5', 37.53333333, 126.7322222, 106, 12, 84, '1997.09', '철근콘크리트', '홍길동', '대단지, 편의시설 완비', 0, 5),
(0, '인천 계양구 작전동 856-75', 37.53333333, 126.7322222, 101, 8, 72, '1985.03', '철근콘크리트', '홍길동', '리모델링 완료, 남향', 0, 5),
(0, '인천 계양구 효성동 301-1', 37.53333333, 126.7322222, 103, 9, 84, '1995.05', '철근콘크리트', '홍길동', '남향, 주차환경 우수', 0, 5),
(0, '인천 계양구 효성동 196-6', 37.53333333, 126.7322222, 105, 11, 72, '003.03', '철근콘크리트', '홍길동', '리모델링 완료, 남향', 0, 5);
-- 남동구 매물 (이민진)
insert into property ( pcategory , paddress , plat , plong , pbuilding , pstorey , parea , pyear , pstructure , puser , padd, psell, mno ) values
( 0 , '인천 남동구 선수촌로 75' , 37.4463985532317 , 126.716391838161 , 108 , 19 , 84.26 , '2016' , '철근콘크리트' , '서진석' , '쾌적한 편의시설', 0, 1 ),
( 0 , '인천 남동구 호구포로 803' , 37.4549274337604 , 126.714969812649 , 2207 , 16 , 84.81 , '2007' , '철근콘크리트' , '서진석' , '나무 많음', 0, 1 ),
( 0 , '인천 남동구 논현로 235' , 37.4068598145872 , 126.731928907712 , 1004 , 22 , 101.42 , '2008' , '철근콘크리트' , '서진석' , '산책로', 0, 1 ),
( 0 , '인천 남동구 구월로 65' , 37.4575383900554 , 126.69810184689 , 102 , 14 , 105.14 , '2003' , '철근콘크리트' , '서진석' , '꺠끗함', 0, 5 ),
( 0 , '인천 남동구 서창남순환로 140' , 37.4276073440355 , 126.744464004405 , 208 , 4 , 59.98 , '2017' , '철근콘크리트' , '서진석' , '쾌적한 편의시설', 0, 1 ),
( 0 , '인천 남동구 서창남순환로 190-15' , 37.4232096600755 , 126.744960443984 , 701 , 10 , 120.42 , '2012' , '철근콘크리트' , '서진석' , '시스템 에어컨', 0, 1 ),
( 0 , '인천 남동구 청능대로718번길 7' , 37.405861281002 , 126.73831231379 , 113 , 2 , 59.7 , '2000' , '철근콘크리트' , '서진석' , '조용함', 0, 1 ),
( 0 , '인천 남동구 에코중앙로 96' , 37.3873145442259 , 126.722246192785 , 902 , 7 , 169.66 , '2011' , '철근콘크리트' , '서진석' , '감각적인 인테리어', 0, 1 ),
( 0 , '인천 남동구 논현로 106' , 37.4010473111072 , 126.72035966927 , 607 , 26 , 119.95 , '2007' , '철근콘크리트' , '서진석' , '정원 보유', 0, 1 ),
( 0 , '인천 남동구 만수서로105번길 40-18' , 37.4620603666966 , 126.739729100378 , 1105 , 3 , 84.9 , '1997' , '철근콘크리트' , '서진석' , '산책로', 0, 1 );
-- 서구 매물 (최홍빈)
INSERT INTO property (pcategory, paddress, plat, plong, pbuilding, pstorey, parea, pyear, pstructure, puser, padd, pdate, psell, mno) VALUES
(0, '인천시 서구 청라동 173-1', 37.52753293, 126.6387486, 901, 15, 84.92, '2012.07', '철근콘크리트', '서진석', '방마다 시스템 에어컨', '2025-02-10 14:21:03', 0, 1),
(0, '인천시 서구 청라동 103-15', 37.52863787, 126.6299452, 592, 22, 84.96, '2020.06', '철근콘크리트', '서진석', '남서향 고층 호수뷰', '2025-02-07 15:21:07', 0, 1),
(0, '인천시 서구 청라동 104-2', 37.52226231, 126.6233, 103, 2, 84.99, '2016.03', '철강 구조', '서진석', '올수리 및 김치냉장고', '2025-02-08 15:21:03', 0, 1),
(0, '인천시 서구 청라동 150-1', 37.53527889, 126.6384824, 363, 18, 114.1, '2013.06', '철근콘크리트', '서진석', '넓은 동간 사이', '2025-02-07 11:01:15', 0, 1),
(0, '인천시 서구 청라동 139-1', 37.53751155, 126.6384801, 376, 7, 100.51, '2012.03', '철근콘크리트', '서진석', '올수리 및 7호선 인접', '2025-02-10 21:07:55', 0, 1),
(0, '인천시 서구 청라동 107-1', 37.54032306, 126.6384662, 388, 3, 101.73, '2012.01', '철근콘크리트', '서진석', '저층이지만 채광 좋음', '2025-02-07 22:15:16', 0, 1),
(0, '인천시 서구 청라동 85-1', 37.53762971, 126.6298831, 647, 12, 84.39, '2019.01', '철근콘크리트', '서진석', '호수전망 , 펜트리', '2025-02-05 23:17:26', 0, 1),
(0, '인천시 서구 청라동 115-1', 37.53971878, 126.6469884, 312, 4, 115.98, '2012.04', '철근콘크리트', '서진석', '에어컨 5대', '2025-02-03 22:10:24', 0, 1),
(0, '인천시 서구 심곡동 336-1', 37.54294031, 126.6706986, 104, 12, 59.88, '1997.01', '철근콘크리트', '서진석', '올수리 경기장뷰', '2025-02-10 00:11:36', 0, 1),
(0, '인천시 서구 심곡동 259-2', 37.5407729, 126.673009, 101, 3, 84.86, '1997.08', '철근콘크리트', '서진석', '채광 좋음', '2025-02-10 15:31:16', 0, 1);

# 사진테이블
drop table if exists photo;
create table photo(
	# 사진번호
	phno int unsigned auto_increment,
    # 사진이름
    phname varchar(30) not null unique,
    # 매물번호
    pno int unsigned,
    constraint primary key(phno),
	constraint foreign key(pno) references property(pno)
);

# 사진 추가 --> sno / 0 : 
# 기본 : 
insert into photo(phname, pno) values ('photo_사진1.jpg', 1);
insert into photo(phname, pno) values ('photo_사진2.jpg', 2);
insert into photo(phname, pno) values ('photo_사진3.jpg', 4);
insert into photo(phname, pno) values ('photo_사진4.jpg', 5);
insert into photo(phname, pno) values ('photo_사진5.jpg', 1);
insert into photo(phname, pno) values ('photo_사진6.jpg', 4);

# 중개한매물테이블
drop table if exists brokerage;
create table brokerage(
	# 중개번호
	bno int unsigned auto_increment,
    # 파일명
    bfile varchar(30) not null unique,
    # 승인날짜
    bdate datetime default now(),
    # 담당자
    bmanager varchar(15) not null,
    # 추가내용
    bcomment text,
    # 회원번호
    mno int unsigned,
    # 매물번호
    pno int unsigned,
    constraint primary key(bno),
    constraint foreign key(mno) references member(mno),
    constraint foreign key(pno) references property(pno)
);

# 중개한매물 추가
# 주의할 점 : 파일에 적힌 날짜랑 승인날짜는 다를 수 있음. 파일에 적힌 날짜는 실제 소유주가 바뀐 날짜이고 데이터베이스의 승인날짜는 계약한 날짜이다
insert into brokerage(bfile, bmanager, bcomment, mno, pno) values ('brokerage_파일1.pdf', '김철수', '집주인 깐깐함', 5, 1);
insert into brokerage(bfile, bmanager, bcomment, mno, pno) values ('brokerage_파일2.pdf', '김철수', '누수문제 숨김', 5, 2);
insert into brokerage(bfile, bmanager, bcomment, mno, pno) values ('brokerage_파일3.pdf', '김철수', '하부장 문제 있음', 5, 3);
insert into brokerage(bfile, bmanager, bcomment, mno, pno) values ('brokerage_파일4.pdf', '김철수', '곰팡이 심함', 1, 4);
insert into brokerage(bfile, bmanager, bcomment, mno, pno) values ('brokerage_파일5.pdf', '김철수', '곰팡이 심함', 1, 5);
insert into brokerage(bfile, bmanager, bcomment, mno, pno) values ('brokerage_파일6.pdf', '김철수', '곰팡이 심함', 1, 6);

ALTER TABLE property ADD COLUMN mprice INT UNSIGNED;
UPDATE property SET mprice = 
CASE 
    pno
    WHEN 1 THEN 32000  -- 3억 2천
    WHEN 2 THEN 48500  -- 4억 8천 5백
    WHEN 3 THEN 25000  -- 2억 5천
    WHEN 4 THEN 29800  -- 2억 9천 8백
    WHEN 5 THEN 31500  -- 3억 1천 5백
    WHEN 6 THEN 27500  -- 2억 7천 5백
    WHEN 7 THEN 42000  -- 4억 2천
    WHEN 8 THEN 38500  -- 3억 8천 5백
    WHEN 9 THEN 44000  -- 4억 4천
    WHEN 10 THEN 35000  -- 3억 5천
    WHEN 11 THEN 47500  -- 4억 7천 5백
    WHEN 12 THEN 39900  -- 3억 9천 9백
    WHEN 13 THEN 28500  -- 2억 8천 5백
    WHEN 14 THEN 33500  -- 3억 3천 5백
    WHEN 15 THEN 41500  -- 4억 1천 5백
    WHEN 16 THEN 36800  -- 3억 6천 8백
    WHEN 17 THEN 45500  -- 4억 5천 5백
    WHEN 18 THEN 29500  -- 2억 9천 5백
    WHEN 19 THEN 34500  -- 3억 4천 5백
    WHEN 20 THEN 38000  -- 3억 8천
    WHEN 21 THEN 42500  -- 4억 2천 5백
    WHEN 22 THEN 31000  -- 3억 1천
    WHEN 23 THEN 49500  -- 4억 9천 5백
    WHEN 24 THEN 26500  -- 2억 6천 5백
    WHEN 25 THEN 37500  -- 3억 7천 5백
    WHEN 26 THEN 43500  -- 4억 3천 5백
    WHEN 27 THEN 28000  -- 2억 8천
    WHEN 28 THEN 46500  -- 4억 6천 5백
    WHEN 29 THEN 33000  -- 3억 3천
    WHEN 30 THEN 39500  -- 3억 9천 5백
    WHEN 31 THEN 44500  -- 4억 4천 5백
    WHEN 32 THEN 27000  -- 2억 7천
    WHEN 33 THEN 36000  -- 3억 6천
    WHEN 34 THEN 47000  -- 4억 7천
    WHEN 35 THEN 32500  -- 3억 2천 5백
    WHEN 36 THEN 41000  -- 4억 1천
    WHEN 37 THEN 35500  -- 3억 5천 5백
    WHEN 38 THEN 48000  -- 4억 8천
    WHEN 39 THEN 30500  -- 3억 5백
    WHEN 40 THEN 43000  -- 4억 3천
END
WHERE pno BETWEEN 1 AND 40;

select * from member;
select * from sell_request;
select * from property;
select * from photo;
select * from brokerage;

select p.pno, p.pcategory, p.paddress, p.pbuilding, p.pstorey, p.parea, p.pyear, p.pstructure, p.pdate, p.padd, p.psell, m.mid, ph.phname
from property as p 
inner join member as m on m.mno = p.mno 
inner join photo as ph on ph.pno = p.pno where psell = 0;

select p.*, m.*, ph.* from property as p 
inner join member as m on m.mno = p.mno 
inner join photo as ph on ph.pno = p.pno;
