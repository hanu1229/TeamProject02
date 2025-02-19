<!-- map.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>부동산 매물 지도</title>
    <%@ include file="../header.jsp" %>
    <link rel="stylesheet" href="/TeamProject02/css/client/map.css">
   
</head>
<body>
    <div class="map-container">
        <div id="map"></div>
        <div class="sidebar">
            <div class="property-list"></div>
        </div>
        <div class="property-detail"></div>
    </div>


    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7be15cee355c36d1e316e018bafe0fc6&libraries=services,clusterer"></script>
   <script src="${pageContext.request.contextPath}/js/client/map.js"></script>
	
</body>
</html>