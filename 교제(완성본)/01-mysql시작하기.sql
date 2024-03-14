/* MYSQL 접속하기
 ------------------------------------ */

1) 명령프롬프트 실행
	--> WinKey + R --> cmd (엔터)

2) 한글처리가 가능하도록 명령어 수행하기
	--> chcp 949

2) MAMP 안의 MySQL 폴더로 이동.
	cd /d "이동할경로"
	--> cd /d C:\MAMP\bin\mysql\bin

3) MySQL 접속 명령어
	mysql -u사용자아이디 -p --default-character-set=utf8

	* DBMS는 자체적으로 아이디를 관리한다.
	* root --> 기본적으로 제공되는 전체 관리자 계정.

	--> mysql -uroot -p
	Enter Password: root



/* 사용할 DB 선택하기
 ------------------------------------ */

1) 현재 시스템 안의 DB목록 조회
	mysql> SHOW DATABASES;

2) 특정 데이터베이스 열기
	--> USE 데이터베이스이름;
	mysql> use myshool;

3) 데이터베이스 안의 테이블 목록 보기
	mysql> SHOW TABLES;

4) 특정 테이블의 구조를 확인
	--> DESC 테이블이름;

	* 학생 테이블의 구조를 확인
	mysql> DESC student;
	* ex) 교수테이블(professor)의 구조 확인
	mysql> DESC professor;
	* ex) 학과테이블(department)의 구조 확인
	mysql> DESC department;


/* SQL문의 종류
 -------------------------------------------------- */
1) DQL (Data Query Language)
   --> 데이터 질의어
   --> 데이터를 조회하기 위해서 사용되는 구문
   --> ex) SELECT

2) DML (Data Manipulation Laguage)
   --> 데이터 조작어
   --> 데이터 변경(입력,수정,삭제)시 사용되는 구문
   --> ex) INSERT (입력), UPDATE (수정), DELETE (삭제)

3) DDL (Data Definition Language)
   --> 데이터 정의어
   --> 데이터베이스나 테이블을 생성,변경,삭제 할 경우
   --> ex) CREATE (생성), ALTER (변경) DROP (삭제)

4) TCL (Transaction Control Language)
   --> 트랜잭션 처리어
   --> ex) COMMIT (트랜잭션의 정상 종료 처리)
           ROLLBACK (트랜젝션 취소)
           BEGIN TRANS (트랜젝션 시작)
