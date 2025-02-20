
        // 메시지 추가 함수
        function addMessage(message, isBot) {
            const messageArea = document.getElementById('messageArea');
            const messageDiv = document.createElement('div');
            messageDiv.className = `mb-4 flex ${isBot ? 'justify-start' : 'justify-end'}`;
            
            // 메시지가 추천 매물 목록인 경우 포맷팅
            const formattedMessage = isBot && message.includes('추천매물:') 
                ? formatPropertyList(message) 
                : message;
            
            messageDiv.innerHTML = `
                <div class="max-w-xs p-3 rounded-lg ${
                    isBot ? 'bg-white text-gray-800 shadow' : 'bg-blue-600 text-white'
                }">
                    ${formattedMessage}
                </div>
            `;
            messageArea.appendChild(messageDiv);
            messageArea.scrollTop = messageArea.scrollHeight;
        }

        // 매물 목록 포맷팅 함수
        function formatPropertyList(message) {
            if (!message.includes('추천매물:')) return message;
            
            const [intro, propertiesStr] = message.split('추천매물:');
            const properties = JSON.parse(propertiesStr);
            
            let formattedList = intro + '<br><br>';
            properties.forEach(property => {
                formattedList += `
                    <div class="mb-2">
                        <strong>${property.location}</strong><br>
                        ${property.type} - ${property.size}평<br>
                        ${formatPrice(property)}
                    </div>
                `;
            });
            
            return formattedList;
        }

        // 가격 포맷팅 함수
        function formatPrice(property) {
            const formatter = new Intl.NumberFormat('ko-KR');
            if (property.type === '매매') {
                return `매매가: ${formatter.format(property.price)}만원`;
            } else if (property.type === '전세') {
                return `전세가: ${formatter.format(property.deposit)}만원`;
            } else {
                return `보증금: ${formatter.format(property.deposit)}만원<br>
                        월세: ${formatter.format(property.monthlyRent)}만원`;
            }
        }

        // 메시지 전송 함수
        function sendMessage() {
            const userInput = document.getElementById('userInput');
            const message = userInput.value.trim();
            if (!message) return;

            // 사용자 메시지 추가
            addMessage(message, false);
            userInput.value = '';

            // 서버에 메시지 전송
            $.ajax({
                url: `/TeamProject02/api/chatbot`,
                method: 'POST',
                data: JSON.stringify({ message: message }),
                contentType: 'application/json',
                success: function(response) {
					console.log( response )
					let message = response.response.replaceAll('\n', '<br/>')
                    addMessage( message , true);
                },
                error: function(xhr, status, error) {
                    console.error('Error:', error);
                    addMessage('죄송합니다. 일시적인 오류가 발생했습니다.', true);
                }
            });
        }

        // Enter 키 이벤트 처리
        document.getElementById('userInput').addEventListener('keypress', function(e) {
            if (e.key === 'Enter') {
                sendMessage();
            }
        });

        // 세션 시작시 웰컴 메시지 표시
        $(document).ready(function() {
            // 세션 스토리지에서 대화 기록 복원
            const savedMessages = sessionStorage.getItem('chatMessages');
            if (savedMessages) {
                const messages = JSON.parse(savedMessages);
                messages.forEach(msg => addMessage(msg.text, msg.isBot));
            }
        });

        // 페이지 언로드시 대화 기록 저장
        window.addEventListener('beforeunload', function() {
            const messages = [];
            document.querySelectorAll('#messageArea > div').forEach(div => {
                const isBot = div.querySelector('div').classList.contains('bg-white');
                const text = div.querySelector('div').innerText;
                messages.push({ text, isBot });
            });
            sessionStorage.setItem('chatMessages', JSON.stringify(messages));
        });
