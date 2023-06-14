<p align="middle"><img src="/img/logo.png" width="30%" /></p>
<h1 align="middle">statrip</h1>

## 프로젝트 소개
 statrip은 관광지 OpenAPI를 활용한 여행자 추천 커뮤니티입니다. 본인의 팔로인 기반으로 경로를 추천하고, 본인의 여행경로 및 인증을 바탕으로 여행 통계를 제공합니다.

## 멤버
<div align="middle">
| Developer | Developer |
| --- | --- |
| [이시영](https://github.com/swy0123) | [이원영](https://github.com/210-reverof) |
</div>

## 기술 스택

### 🧷 프론트엔드
<div align="middle">
<img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
<img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white">
<img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"> 
  
**Language |** HTML, CSS, Javascript

**Framework |** Vue.js

**Library |** axios, bootstrap-vue, chart.js, vue-chartjs, vue-router, vue-scroll-snap, vue-wordcloud, vuedraggable, vuex

  
</div>


### 🧷 백엔드

<div align="middle">

<img src="https://img.shields.io/badge/java-3a75b0?style=for-the-badge&logo=java&logoColor=black">
<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/spring boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/spring mvc-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/junit-25A162?style=for-the-badge&logo=junit5&logoColor=white">
<img src="https://img.shields.io/badge/spring test-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white">
<img src="https://img.shields.io/badge/mybatis-FF6F00?style=for-the-badge&logo=mybatis&logoColor=white">
  
**Language |** Java 8

**Framework |** Spring 5.3.21 (Spring Boot 2.7.1, Spring MVC 5.3.21)

**Data(RDBMS) |** MyBatis 5.6.9

**Build Tool |** Maven 7.4.1
  
</div>


### 🧷 인프라

<div align="middle">

<img src="https://img.shields.io/badge/AWS EC2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white">
<img src="https://img.shields.io/badge/maria DB-4479A1?style=for-the-badge&logo=mariadb&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  
**DB |** H2, MySQL 8

**Server |** Git, SSH
  
</div>

## 서비스 기획
### 🧷 데이터와 커뮤니티
기존 여행 프로젝트를 통해 데이터가 누적<br>
이를 활용한 다양한 서비스 기획<br>
커뮤니티 기능을 활용하여 더 다채로운 통계와 서비스 기획<br>

## 화면구성
### 🧷 1.회원 시스템
JWT를 활용한 로그인 구현<br>
초기 설문을 통한 회원 데이터 관리<br>
<img src="/img/로그인.png" align="middle"/>
<br>

### 2. 관광지 정보 검색
지역 및 카테고리 기반 검색<br>
지도에 위치 정보 확인 가능<br>
<img src="/img/관광지 검색.png" align="middle"/>
<br>

### 3. Kakao Map 경로 표시
항목 선택을 통한 간편한 경로 추가<br>
지도 상에 경로와 함께 표시<br>
<img src="/img/경로 표시.png" align="middle"/>
<br>

### 4. 인증샷과 함께 공유
사용자가 방문한 관광지 인증 시스템<br>
인스타그램의 스토리 형식으로 열람<br>
<img src="/img/핫스팟모달.png" align="middle"/>
<br>

## 추가 기능
### 1. 자동 통계 시스템
경로 추가, 공유, 댓글, 팔로우 등의 사용자 활동을 기반으로 자동 통계 시스템<br>
관심 카테고리를 실시간으로 시각화<br>
<img src="/img/마이페이지.png" align="middle"/>
<br>

### 2. 팔로잉 & 맞춤 피드
사용자들끼리의 팔로우 기능 지원<br>
메인 피드에서 팔로잉 사용자 게시물 쉽게 확인 가능<br>
<img src="/img/팔로워리스트.png" align="middle"/>
<br>

### 3. 경로 설정 도움
사용자들끼리의 팔로우 기능 지원<br>
메인 피드에서 팔로잉 사용자 게시물 쉽게 확인 가능<br>
<img src="/img/지도 위 경로.png" align="middle"/>
<br>

### 4. 친구 추천 시스템
사용자의 통계를 바탕으로 유사한 성격을 가지고 있는 사용자 실시간 추천<br>
코사인 유사도로 연산<br>
MSA : 친구 추천 서비스 독립
<br> 독립적 기능
<br> 성능 및 응답 시간 요구사항
<br> 개발 및 유지보수의 용이성 등
<img src="/img/친구추천.png" align="middle"/>
<br>

### 5. 다양한 시각화
카테고리 이외에도 다양한 나이 대, 성별 등 다양한 정보<br>
위 데이터 활용한 다양한 시각화<br>
<img src="/img/워드클라우드.png" align="middle"/>
<img src="/img/그래프.png" align="middle"/>




