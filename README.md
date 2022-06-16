![header](https://capsule-render.vercel.app/api?type=transparent&color=auto&height=330&section=header&text=KYP-coffee%20프로젝트&fontSize=69&fontColor=a94b00)

***
원두를 판매하는 쇼핑몰 형태의 웹 사이트 입니다.

http://kyp-coffee.shop

http://kypcoffee.shop

http://wugawuga.shop

## 목차
+ 개발환경 
+ 사용기술
  + 백엔드
  + 프론트엔드
  + 기타 주요 라이브러리
+ 프로젝트 목표

+ 핵심 기능

+ 프로젝트 Issue



## 개발환경
+ IntelliJ
+ GitHub



## 사용기술
주요 프레임워크 / 라이브러리
+ JAVA 11 openjdk
+ Springboot 2.5.6
+ SpringBoot Security
+ Mybatis
+ Selenium

Build Tool
+ Gradle

DataBase
+ Oracle

Infra
+ AWS EC2

프론트엔드
+ JavaScript
+ Html/CSS
+ Thymeleaf
+ Bootstrap 5

기타 라이브러리
+ Lombok



## 프로젝트 목표
+ 스프링 부트, 스프링 시큐리티를 사용하여 웹 애플리케이션 기획부터 배포, 유지 보수까지 전 과정 경험 
+ 배포 인프라 구축 -  AWS / 우분투(UBUNTU) 기반
+ Spring MVC 프레임워크 기반 백엔드 서버 구축



## 핵심 기능
+ 메인 페이지
  ![](src/main/resources/static/img/project.png)
+ Selenium을 이용한 크롤링으로 SNS 정보 가져오기
+ 매출현황보기(일별, 월별)
+ 상품 판매, 재고 수정, 주문 취소 시 상품 정보 수정 등
+ 원데이클래스 강좌 OPEN 및 선착순 모집
+ 게시판 CRUD
+ 카카오 / Google 계정 로그인



## 프로젝트 Issue

- 구글 로그인 설정 후 http://localhost:8085로 접속시 구글 로그인 페이지로 강제이동하는 오류 발생
  - 해결: web security 설정에서 해결

- 게시판에서 글 쓰기후 첫번째글을 상세보기 후 ‘뒤로가기’ 누르면 에러페이지 발생
  - 해결 : 기존 POST아닌 GET방식의 전송으로 변경



## 팀원들
<img src="src/main/resources/static/img/testimonials/park_emoji.png" width="200px" height="200px" alt="park"></img>
### 박민영 팀장(MJguri)
#### [ 관리자 페이지(매출현황, 상품관리, 재고관리, 주문관리, 회원관리, 공지사항) ]
+ 매출현황
  + 일별, 월별 매출을 확인 할 수 있습니다.
  + 상세보기를 통하여 각 카테고리별 매출을 확인 할 수 있습니다.
+ 상품관리
  + 새로운 상품 입고시 상품을 등록 할 수 있습니다.
  + 상품의 이미지나 내용이 변경되었을 경우 수정할 수 있습니다.
+ 재고관리
  + 상품의 재고를 추가하거나 감소시킬수 있습니다.
+ 주문관리
  + 주문내역이 보여집니다.
  + 고객이 환불을 요청한 경우 환불을 진행 할 수 있습니다.
+ 회원관리
  + 회원정보의 수정, 삭제, 조회가 가능합니다.
+ 공지사항
  + 공지사항을 등록, 수정, 삭제 할 수 있습니다. 
#### [ 리뷰등록 ]
+ SNS에 있는 KYP Coffee 리뷰를  크롤링 하여 정보를 가져와서 리뷰글을 작성합니다.
  
#### [ 원데이클래스 ]

+ 원데이클래스를 등록할 수 있습니다(관리자)
+ 원데이클래스 강좌 신청할수 있습니다.(선착순, 회원만)
+ 관리자는 원데이클래스 수강생들의 정보를 확인 할 수 있으며, 취소할 수 있습니다.
#### [Springboot + Mybatis + Oracle 연동 ]

<img src="src/main/resources/static/img/testimonials/ko_emoji.png" width="200px" height="200px">

### 고은주(monica)

#### [ 로그인/회원가입/QNA게시판/회원목록/채팅/이메일문의/디자인담당 ]

#### 로그인/회원가입
+ 일반 고객과 사업자고객의 혜택이 다르기때문에 사업자고객은 사업자등록번호조회 API를 이용해 사업자 인증을 받아야만 회원가입이 가능합니다.
+ 사업자번호 입력시 받아오는 JSON 코드는 다음과 같습니다.“계속사업자” 상태인 “01” 이어야만 회원가입이 가능하게 했습니다.

<img src="https://user-images.githubusercontent.com/97489770/163091175-3ba72e74-5789-4988-be4a-f74e90d327f3.png" width="250">

+ 구글 로그인/회원가입 구현을 위해 스프링 시큐리티와 OAuth2 인증방식을 사용했으며, 카카오 로그인/회원가입은 자바스크립트를 이용해 구현했습니다. 
+ 구글 회원가입시 아이디는 google, 카카오 회원가입시 아이디는 kakao로 통일하여 소셜회원은 아이디를 구분했습니다.

+ 로그인화면의 비밀번호 찾기는 아이디와 핸드폰 번호 일치로 회원확인을 하며, 확인이 끝나면 새 비밀번호로 변경이 가능합니다.

#### QNA게시판
+ 일반,사업자,소셜회원 글쓰기 가능. 로그인 안했을시 열람 불가, 로그인시 질문내용은 회원 모두 볼 수 있되,관리자의 답변은 질문글쓴 당사자만 열람가능 합니다.
+ 제목, 내용, 회원아이디로 검색이 가능합니다.

#### 실시간 채팅
+ 디자인만 변경했습니다. 소스는 아래의 출처에 있습니다. 

#### 상품이미지
+ 이미지사이트 Pixabay, Shutterstock, Rawpixel, MockupCloud의 Free Mock up 이미지를 Photoshop CS6로 수정해 사용했습니다.


<img src="src/main/resources/static/img/testimonials/yun_emoji.png" width="200px" height="200px" alt="park"></img><p>우가우가 예~~~~~</p><br/>


## 출처
### Source
채팅어플리케이션 : https://34codefactory.medium.com/spring-boot-chat-application-with-websocket-code-factory-262d425a004b

부트스트랩 템플릿 : https://bootstrapmade.com/remember-free-multipurpose-bootstrap-template/

부트스트랩 로그인 템플릿 : https://freefrontend.com/bootstrap-login-forms/

### Reference
구글로그인 : https://mieumje.tistory.com/79
