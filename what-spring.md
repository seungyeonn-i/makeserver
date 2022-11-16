1. 회원 도메인 생성
    1. domain / User interface → user class
    2. repository / UserRepository interface →  MemoryuserRepository
        1. save,findById,findAll()
2. 회원 도메인 생성 테스트
    1. afterEach, BeforeEach 수행
        1. afterEach는 테스트 메소드 실행 후 실행된다.
        2. beforeEach는 테스트 메소드 실행 전 실행된다.
        3. Test case 작성
            
            각각의 테스트 메소드는 독립적으로 실행되어야한다. 테스트는 각 테스트끼리 순서가 관계 없어야하고, 의존관계가 없어야한다. 따라서 테스트가 끝날 때마다 공용 데이터를 깔끔하게 지워야한다.
            
            `@Transactional`
            
            테스트 케이스에 @Transactional를 붙이는 경우 테스트 시작 전 트랙잭션을 시작하고, 테스트 완료 후 항상 롤백한다. 따라서 데이터베이스에 테스트 때 변경 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.
            
            `@AfterEach`
            
            위 어노테이션이 명시되어있는 메소드는 각 테스트 메소드 실행 후 무조건 실행된다. 각 테스트가 끝나고 공용 데이터를 깔끔하게 지우기 위해 MemoryUserRepository에서 respository.clearStore(); 메소드를 사용하려 사용한다.
            
            하지만, AfterEach()를 이용해 clearStore() 하면 UserService 에서 생성한 MemoryUserRepository 객체와 UserServiceTest에서 생성한 MemoryUserRepository가 다르게 된다. 이에 따라 UserService에서 Dependency Injection을 사용해 userRepository를 저장하고, 
            
            `@BeforeEach`
            
            테스트 메소드 실행 전에 무조건 실행되는 beforeEach 부분에 UserService와 MemoryUserRepository 객체 생성 부분을 넣어준다.
            
3. 회원 컨트롤러
    1. 회원 컨트롤러에 의존 관계 추가
        1. 생성자에 @Autowired 스프링이 연관된 객체를 스프링 컨테이너에 찾아 넣어준다.
        2. @Controller // 스프링 컨테이너가 컨트롤러 객체를 생성해 스프링에 넣어둔다.
        3. @Controller 한 컨트롤러는 스프링빈에 등록되어있지만 userService는 아직 스프링빈에 등록되어있지 않다. @Service를 이용해 스프링빈에 등록한다.

