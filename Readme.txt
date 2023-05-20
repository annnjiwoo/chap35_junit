
[순서]

1. chap31_spring_dao 프로젝트 생성
 - 기존 프로젝트 복사
 
2. 프로젝트 설명
 1) 환경설정파일 설명
 
 2) 컨트롤러/Dao 어노테이션 설명
  - @Controller
  - @Repository
 
 3) 의존성주입(Injection) 방법과 어노테이션 설명 
 - @Autowired
 - @Qualifier
 - @Resource
 - @Inject


3. 컨트롤러에서 메소드 만들고 Url 매핑하는 방법
 - @RequestMapping
 
4. 컨트롤러에서 생성된 데이터를 View쪽으로 보내는 방법
 - Model model에 저장하면 View단에서 찾아쓸 수 있다.
 
5. 컨트롤러에서 JSP에서 전달한 파라미터 받는 방법
 1) 단순하게 값 하나 받는 방법
  - @RequestParam("no") int no
 2) 객체로 받는 방법
  -	public String boardWrite(BoardVo vo, Model model){
 
6. 컨트롤러에서 Get/Post 방식으로 요청을 처리하는 방법
 - method = RequestMethod.POST 

7. 웹자원 경로 webapp/resource/CKEDITOR  
 - CKEDITOR 자바스크립트 라이브러리 추가
 - boardWrite.jsp에 자바스크립트 추가