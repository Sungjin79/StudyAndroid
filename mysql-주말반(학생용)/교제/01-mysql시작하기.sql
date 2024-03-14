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
	mysql -u사용자아이디 -p

	* DBMS는 자체적으로 아이디를 관리한다.
	* root --> 기본적으로 제공되는 전체 관리자 계정.

	--> mysql -uroot -p
	Enter Password: root



/* 사용할 DB 선택하기
 ------------------------------------ */

1) 현재 시스템 안의 DB목록 조회
	mysql>

2) 특정 데이터베이스 열기
	--> USE 데이터베이스이름;
	mysql>

3) 데이터베이스 안의 테이블 목록 보기
	mysql>

4) 특정 테이블의 구조를 확인
	--> DESC 테이블이름;

	* 학생 테이블의 구조를 확인
	mysql>
	* ex) 교수테이블(professor)의 구조 확인
	mysql>
	* ex) 학과테이블(department)의 구조 확인
	mysql>
