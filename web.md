- `Network 계층 :: IP`
    - 클라이언트와 서버에 IP 주소 부여
    - IP Packet에는 **출발지 IP, 목적지 IP** 등이 담겨 있다.
    - 여러 노드를 거쳐 Packet에 담긴 정보로 목적지 IP주소 찾아서 데이터 전달
    - IP 프로토콜의 한계
        - 비 연결성
            - 상대가 **서비스 불능** 상태여도 Packet 전송, 단방향
        - 비 신뢰성
            - **패킷 유실, 패킷 전달 순서 문제** 생겨도 해결 방안 없음
        - **프로세스 구분**
            - 같은 IP 사용하는 서버에서 통신하는 애플리케이션이 둘 이상이면 구분 불가능
    - `DNS(Domain Name System)`
        - IP는 기억하기 어렵다. IP는 변경될 수 있다.
        - IP주소에 이름을 붙임
            
- `Transport :: TCP(Transmission Control Protocol ; 전송 제어 프로토콜)` →  `PORT`
    - IP 자체는 패킷 손실, 패킷 전달 순서 문제 발생 등에 대처할 수 없음 이에대한 해결 방안이 TCP
    - TCP Segment에는 **출발지 PORT, 목적지 PORT, 전송 제어, 순서, 검증 정보** 등이 담겨있음
    - TCP 특징
        - 연결 지향 - 3 way handshake
            
            
            1️⃣ SYN : 접속 요청  2️⃣ SYN+ACK   3️⃣ ACK : 요청 수락
            
        - 데이터 전달 보증
            - 3 way handshake 방식으로 데이터 전달 보증 됨
        - 순서 보장
            - Segment에 담긴 정보로 순서 지켜지지 않으면 다시 요청
        
        → 신뢰할 수 있는 프로토콜
        
    - `PORT` → 프로세스 구별
        - IP를 아파트에 비유하면 PORT는 동 호수
        - TCP Segment에 담기는 정보
        - 동시에 진행되는 상황에서 애플리케이션을 구분해줌