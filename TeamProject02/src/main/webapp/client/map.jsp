<!-- map.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>부동산 매물 지도</title>
    <%@ include file="../header.jsp" %>
    <style>
        .map-container {
            display: flex;
            height: calc(100vh - 60px);
        	justify-content: flex-end;
        	
        }
        #map {
            width: 60%;
            height: 100%;
        }
        .sidebar {
            width: 300px;
            height: 100%;
            background: white;
            position : fixed;
            left : 0; 
            overflow-y: auto;
            display: none;
            box-shadow: -2px 0 5px rgba(0,0,0,0.1);
        }	
        .property-item {
            padding: 15px;
            border-bottom: 1px solid #eee;
            cursor: pointer;
        }
        .property-item:hover {
            background: #f8f9fa;
        }
        .property-detail {
            position: fixed;
            left: 20px;
            top: 70px;
            width: 400px;
            background: white;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            padding: 25px;
            display: none;
            max-height: calc(100vh - 80px);
            overflow-y: auto;
            border-radius: 8px;
            z-index: 2;
        }
    </style>
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