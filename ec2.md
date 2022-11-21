# 서버 배포 시 유의할 점

# 서버 개발 환경 구축 및 API 테스트

```bash
cd /var/www/
rm -rf html
git clone https://github.com/@@@@@@
cd @@@@@
./gradlew clean build
java -jar build/libs/demo-0.0.1-SNAPSHOT.jar

```

- RDS 인바운드 규칙 확인

    9000,3600 포트 0.0.0.0 으로 했는지 확인ㄴ

- Postman으로 API 체크
    - Body 값 raw-json으로 체크하고
    - 서버 ip 넣고


