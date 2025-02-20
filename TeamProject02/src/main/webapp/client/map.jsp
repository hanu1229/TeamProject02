<!-- map.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>부동산 매물 지도</title>
    <%@ include file="../header.jsp" %>
    <link rel="stylesheet" href="/TeamProject02/css/client/map.css">
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   
</head>
<body>
    <div class="map-container">
    <div style="padding:15px; " class="property-detail">
    	<div class="property-images"></div>
    </div>
        <div id="map"></div>
        <div class="sidebar">
            <div class="property-list"></div>
        </div>
        
    </div>
    
    <!--  챗봇  -->
   <div  style="position: fixed; right: 10px; bottom: 5px; z-index: 99;" class="w-full max-w-md mx-auto h-96 flex flex-col bg-gray-50 rounded-lg shadow-md mt-10">
      <!-- 챗봇 헤더 -->
      <div class="bg-blue-600 text-white p-4 rounded-t-lg flex items-center gap-2">
          <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 10h.01M12 10h.01M16 10h.01M9 16H5a2 2 0 01-2-2V6a2 2 0 012-2h14a2 2 0 012 2v8a2 2 0 01-2 2h-5l-5 5v-5z" />
          </svg>
          <h2 class="font-semibold">부동산 상담 챗봇</h2>
      </div>

      <!-- 메시지 영역 -->
      <div id="messageArea" class="flex-1 p-4 overflow-y-auto">
          <div class="mb-4 flex justify-start">
              <div class="max-w-xs p-3 rounded-lg bg-white text-gray-800 shadow">
                  안녕하세요! 부동산 관련 문의사항이 있으시다면 편하게 말씀해주세요.
              </div>
          </div>
      </div>

      <!-- 입력 영역 -->
      <div class="p-4 border-t border-gray-200">
          <div class="flex gap-2">
              <input type="text" id="userInput" 
                     class="flex-1 p-2 border border-gray-300 rounded-lg focus:outline-none focus:border-blue-500"
                     placeholder="메시지를 입력하세요...">
              <button onclick="sendMessage()" 
                      class="p-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 focus:outline-none">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                      <path d="M10.894 2.553a1 1 0 00-1.788 0l-7 14a1 1 0 001.169 1.409l5-1.429A1 1 0 009 15.571V11a1 1 0 112 0v4.571a1 1 0 00.725.962l5 1.428a1 1 0 001.17-1.408l-7-14z" />
                  </svg>
              </button>
          </div>
      </div>
  </div>
  <script src="../js/client/Chatbot.js"></script>

    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7be15cee355c36d1e316e018bafe0fc6&libraries=services,clusterer"></script>
   <script src="${pageContext.request.contextPath}/js/client/map.js"></script>
	
</body>
</html>