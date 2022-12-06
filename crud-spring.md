# 

1. enum 이란
2. Implement와 extends의 차이
3. extends에서 super() ?? 
    
    ```bash
    public class TokenValidFailedException extends RuntimeException {
    
        public TokenValidFailedException() {
            super("Failed to generate Token.");
        }
    
        private TokenValidFailedException(String message) {
            super(message); // super 클래스 (Runtime Exception 에 전달)
            //  super의 super의 ... throwable에서 fillInStackTrace();
            //        detailMessage = message;
        }
    }
    ```
    
4. filterChain.doFilter(request,response) 필수
5. provider의 역할
6. @value annotation의 역할
7. Claims 객체 역할 := Jwt 의 Payload에 담는 정보 한조각
    1. JWT(Json Web Token) 
    두 개체에서 JSON 객체를 사용해 가볍고 자가수용적인(필요한 모든 정보를 자체적으로 지니고 있음 토큰의 기본정보,전달할 정보,토큰 검증 signature)
    2. 회원 인증에서 jwt, 유저가 로그인 되었는지 유무를 신경쓸 필요가 없고 유저가 요청했을 때 토큰의 유효성만 확인하면 되니 세션 관리가 필요 없어 서버 자원을 아낄 수 있다. 
    3. 정보 교류에서 jwt, 두 개체에서 안정성있게 정보를 교환하기에 좋은 방법이다. 정보가 sign 되어있기 때문에 정보 조작 여부를 검증할 수 있다. 
    4. JWT의 생김새
        1. 헤더(Header)
            1. typ(토큰 타입) : jwt
            2. alg(해싱 알고리즘) : HMAC SHA256 || RSA 사용 
        2. 내용(Payload)
            1. 토큰에 담을 정보가 담김, 여기에 담는 정보 한조각을 Claim이라고 함. name/value 한 쌍으로 이루어져 있으며 토큰에는 여러개의 클레임들을 넣을 수 있음
            2. 클레임의 종류에는 세가지가 있음. registered Claim, public Claim, private Claim
        3. 서명(Signature)
            1. Hash (헤더의 인코딩 값 + 정보의 인코딩 값)
                
                ```bash
                HMACSHA256(
                  base64UrlEncode(header) + "." + // header incoding value
                  base64UrlEncode(payload),      // payload incoding value
                  secret).                      // 주어진 비밀키로 해쉬 
                ```
                
        4. 이후 Header,Payload,Signautre 값을 ‘.’ 을 중간자로 합쳐주면 하나의 토큰 완성
