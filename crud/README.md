# makeserver
### spring to ec2

Spring 프로젝트에서 /build에서 ./gradlew clean build 하면 /build/libs에 jar 파일 생성

jar 파일은 .gitignore에 지정되어있기 때문에 올라가지 않음 그래서 git add -f crud-0.0.1-SNAPSHOT.jar 해서 git에 build 된 jar 파일 올리기

```bash
서버의 /var/www에서 git clone
/var/www/makeserver/crud/build/libs에서 jar 파일 실행
java -jar crud-0.0.1-SNAPSHOT.jar 하면 실행됨
```

그 전에 [nginx 설정](https://www.notion.so/spring-to-ec2-9aee29bc4c3c4a5989975db8d6d06f35) 등 할게 많음

내 생각에는 nginx 와 apache2 동시에 올려놓을 수 없음

이걸로 엄청 애먹었다. nginx 끄고 apache2 켜고 다시 nginx start 할라니까 안되고 근데 알고봤더니 원래 안되는것 이었다.

- nginx와 apache2의 차이

## 많은 설정할 것들

### EC2 보안그룹

- 인바운드 규칙 설정


    | ssh | tcp | 22 | @@@@@@@ |
    | --- | --- | --- | --- |
    | http | tcp | 80 | 0.0.0.0/0 |
    | http | tcp | 80 | ::/0 |
    | 사용자 지정 tcp | tcp | 8080 | ::/0 |
    | 사용자 지정 tcp | tcp | 8080 | 0.0.0.0/0 |
- 원래 git clone 프로젝트 해서 EC2에서 build 해야하는데 프리티어는 쓰레기라서 build가 너무 느리다. 그래서 로컬에서 build 하고 jar 파일 push pull 해서 사용한다.

### nginx

- 기존 nginx 설정 파일을 보면 forward proxy이다. 하지만 nginx 서버에서 Reverse Proxy 기능도 제공한다.
- forward proxy??

  Proxy란 두 호스트가 통신할 때 직접 통신하지 않고 중간에서 대리로 통신하도록 도와주는 것이다. 이런 중계 역할을 하는 서버를 프록시 서버라고 한다. 프록시 서버는 클라이언트와 서버 사이의 중계 서버로서 역할을 한다.

  프록시 서버의 위치에 따라 forward proxy , reverse proxy로 나뉜다.

  ## `Client` - `Forward Proxy` - `Internet` - `Server`

  포워드 프록시는 클라이언트 앞에 위치한다. 클라이언트의 요청을 포워드 프록시가 대신 받아 서버에게 전달(Forward) 해준다. 마찬가지로 서버의 응답을 포워드 프록시가 대신 받아 클라이언트에 전달(Forward) 해준다. 로컬 밖으로 나가지 않음

    - 접속 제한 회피
    - 특정 콘텐츠 제한
    - 캐싱 기능
        - 동일한 요청에 대해 캐싱된 내용 전달
    - IP 우회 및 보안
        - 클라이언트-프록시-서버. 서버측은 클라이언트의 정보가 아닌 포워드 프록시의 정보를 받게된다. 서버측에 클라이언트의 정보를 숨길 수 있다.

  ## `Client` - `Internet` - `Reverse Proxy` - `Server`

  리버스 프록시는 웹서버 앞에 위치한다. 포워드 프록시와 마찬가지로 클라이언트의 요청을 전달받아 서버에 전달하고 서버의 응답을 클라이언트에 전달한다. 로컬 밖으로 나감

  그렇다면 리버스와 포워드의 차이는 뭘까 ?

  리버스 프록시는 서버 앞에 위치한다. 포워드 프록시가 클라이언트들을 위한 중간 매개체인 반면, 리버스 프록시는 서버들을 위해 클라이언트가 해당 서버에 접속하는 중간 매개체 이다.

  쉽게 말해 포워드는 주로 클라이언트를 위해, 리버스는 서버를 위해 일한다.

    - 보안에 강함
    - 로드밸런싱
        - 내부 서버 정보를 알고 있으므로 수많은 클라이언트들의 요청을 다른 서버로 분배해줌
    - 캐싱
- nginx와 apache2의 비교
    - apache2는 프로세스를 fork하거나 스레드 사용, nginx는 IO를 Event Listener로 미루기때문에 흐름이 끊기지 않고 응답이 빠르게 가능 ?????
    - 추가적으로 nginx는 apache와 달리 동시 접속자 수가 많아져도 추가 생성 비용이 들지 않고 그래서 nginx가 더 좋다.
- nginx 명령어

    ```bash
    sudo nginx -t // nginx 설정 파일 문법 올바른지 확인
    sudo service nginx status
    sudo systemctl nginx restart
    sudo systemctl nginx stop
    ```

- nginx 웹 서버를 사용할 때 서버 블록을 사용해 구성 정보를 캡슐화하고 단일 서버에서 둘 이상의 도메인을 호스팅 할 수 있습니다.
- nginx 파일 및 디렉토리
    - /var/www/html : 기본적으로 nginx 페이지 존재. 기본 설정
    - /etc/nginx/nginx.conf : 기본 nginx 구성 파일

    - /etc/nginx/sites-available : 사이트별로 서버 블록 저장 디렉토리
    - /etc/nginx/sites-enabled : 활성화된 사이트별 서버 블록 저장 디렉토리 일반적으로 sites-available 과 연결되어 생성
        - 서버 블록?
    - /var/log/nginx/access.log : 웹 서버에 대한 모든 요청 기록
    - /var/log/nginx/error.log : nginx 로그 오류 기록

### nginx 서버 연동

- Proxy 설정

    ```bash
    sudo mkdir /var/log/nginx/proxy
    sudo vi /etc/nginx/proxy_params
    
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    proxy_set_header Host $http_host;
    proxy_set_header X-Forwarded-Proto $scheme;
    proxy_set_header X-NginX-Proxy true;
    
    client_max_body_size 256M;
    client_body_buffer_size 1m;
    
    proxy_buffering on;
    proxy_buffers 256 16k;
    proxy_buffer_size 128k;
    proxy_busy_buffers_size 256k;
    
    proxy_temp_file_write_size 256k;
    proxy_max_temp_file_size 1024m;
    
    proxy_connect_timeout 300;
    proxy_send_timeout 300;
    proxy_read_timeout 300;
    proxy_intercept_errors on;
    ```


### 도메인 연결

- 가비아에서 도메인 구매
- AWS Route 53에서 도메인 등록
    - 도메인 이름 : 구매한 도메인
    - 레코드 이름 : www
    - 값 : 퍼블릭 IPv4 주소 입력
    - 유형이 NS인 레코드의 총 4개 값 ns …  를 가비아 네임서버에 등록

### 서버 블록 생성

```bash
sudo vi /etc/nginx/sites-available/{donain}

server { # server 블록
	listen 80;

    server_name {domain} www.{domain};
    
    access_log /var/log/nginx/proxy/access.log;
    error_log /var/log/nginx/proxy/error.log;

    location / { # location 블록
        include /etc/nginx/proxy_params;
        proxy_pass http://{퍼블릭IP주소}:8088;	# reverse proxy의 기능
    }
}
```

이 코드로 location 블록의 proxy_pass로 8088번 포트로 접속해야 볼 수 있는 화면(Spring 프로젝트 화면)을 80번 포트에 접속했을 때 확인할 수 있도록 설정. Reverse proxy 기능 설정

nginx는 이제 listen 지시문에 의해 포트 80으로 들어오는 요청들에 대해 servername과 정확하게 일치하는 서버 블록을 찾으러고 시도한다. server_name 추가할 때 버킷 메모리 문제가 발 생할 수 있기에 아래와 같이 주석처리를 제거합니다.

/etc/nginx/nginx/nginx.conf

```bash
http { ...
	server_names hash_bucke_size 64;	# 주석 처리를 제거
	...
}
```

- 수정한 파일 활성화 sites-available 의 파일을 링크하여 sites-enabled에 추가

```bash
sudo ln -s /etc/nginx/sites-available/{domain} /etc/nginx/sites-enabled/
```

- 기본 구성 파일 삭제

  기존에 있던 Default 파일을 삭제한다.


```bash
sudo rm  /etc/nginx/sites-available/default
sudo rm  /etc/nginx/sites-enabled/default
```

- nginx 재시작

```bash
sudo nginx -t
sudo service nginx reload
java -jar {jar 파일명}.jar

nohup java -jar {jar 파일명}.jar & // 무중단 배포 (백그라운드 실행)
```