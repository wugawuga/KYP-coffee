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
+ 시스템 아키텍쳐
+ E-R 다이어그램
+ 핵심 기능
  + Selenium을 이용한 크롤링으로 SNS 정보 가져오기
  + 게시판 CRUD
  + 카카오 / Google 계정 로그인
  + 등등
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



## 시스템 아키텍쳐

[그림]



## E-R 다이어그램

[그림]



## 핵심 기능
  + Selenium을 이용한 크롤링으로 SNS 정보 가져오기
  + 메인 페이지
   ![](src/main/resources/static/img/project.png)
  + 게시판 CRUD
  + 카카오 / Google 계정 로그인
  + 등등



## 프로젝트 Issue
- gradle build 할 때, ouath2 compile
  - 1
  - 2
  - 3
- lombok 버전 안 맞아서 build 오류
  - 1
  - 2
  - 3
- th:replace="headerFooter.html :: top-bar"
  - 1
  - 2
  - 3
- 구글 로그인 설정 후 http://localhost:8085로 접속시 구글 로그인 페이지로 강제이동하는 오류 발생
해결: web security 설정에서 해결

- 게시판에서 글 쓰기후 첫번째글을 상세보기 후 ‘뒤로가기’ 누르면 에러페이지 발생
해결 : 기존 POST아닌 GET방식의 전송으로 변경



## 팀원들
<img src="src/main/resources/static/img/testimonials/park_emoji.png" width="200px" height="200px" alt="park"></img><p>박민영 팀장관리자 페이지
</p><br/>
<img src="src/main/resources/static/img/testimonials/ko_emoji.png" width="200px" height="200px" alt="park"></img><p>은저크 고 예~~~~~</p><br/>
<img src="src/main/resources/static/img/testimonials/yun_emoji.png" width="200px" height="200px" alt="park"></img><p>우가우가 예~~~~~</p><br/>

##출처
###Source
채팅어플리케이션 : https://34codefactory.medium.com/spring-boot-chat-application-with-websocket-code-factory-262d425a004b
부트스트랩 템플릿 : https://bootstrapmade.com/remember-free-multipurpose-bootstrap-template/

###Reference
구글로그인 : https://mieumje.tistory.com/79
