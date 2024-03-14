/** 함수의 사용법
------------------------------------
SELECT 함수이름(컬럼이름) FROM 테이블이름 ...
------------------------------------


/** 문자열 관련 함수
------------------------------------ */

/** 1) 문자열의 좌측부터 주어진 길이만큼 잘라낸다 */
SELECT LEFT(name, 1) FROM student;

/** 2) 문자열의 우측부터 주어진 길이만큼 잘라낸다 */
SELECT RIGHT(name, 1) FROM student;

/** 3) 문자열 자르기 (mid, substring --> 같은 기능)
	두 번째 인수: 시작 위치 (1부터 시작)
	세 번째 인수: 잘라낼 글자 수
	세 번째 인수가 지정되지 않을 경우, 끝까지 */
SELECT mid(name, 2, 1), name FROM student;
SELECT substring(name, 2, 1), name FROM student;

/** 4) 문자열 변경하기 --> A를 B로 ... */
SELECT replace(name, '이', 'lee') FROM student;

/** 5) 문자열 합치기 */
-- 이름과 학년을 합치기
SELECT concat(name, grade) FROM student;
-- 이름과 공백, 학년과 '학년'이라는 문자열 결합
SELECT concat(name, ' ', grade, '학년') FROM student;

/** 6) 앞뒤 공백 제거 */
SELECT trim(name) FROM student;

/** 7) 앞 공백 제거 */
SELECT ltrim(name) FROM student;

/** 8) 뒤 공백 제거 */
SELECT rtrim(name) FROM student;

/** 9) 비밀번호 형식으로 암호화된 값으로 변환 */
SELECT password(name) FROM student;
-- 주의: 암호화 된 값은 다시 복호화 할 수 없습니다.
--	이 함수의 활용법은 PHP 시간에 소개합니다.

/** 10) 문자열 길이 */
SELECT char_length(name) FROM student;

/** 11) 문자열이 표시되는 위치를 리턴 */
-- name에서 '이'가 표시되는 위치를 찾기
SELECT instr(name, '이'), name FROM student;

/** 12) 대소문자 변환 */
SELECT upper(userid) FROM professor;
SELECT lower(userid) FROM professor;




/** 현재 시스템의 날짜를 획득
------------------------------------ */
-- 오늘 날짜 얻기
select now();

-- WHERE절의 조건으로 사용할 수 있다.
select name from student where birthdate < now();

-- insert나 update에서 값으로 사용할 수 있다.
select name, birthdate from student where studno=20101;
update student set birthdate=now() where studno=20101;
select name, birthdate from student where studno=20101;



/** 주어진 날짜에서 원하는 부분을 추출
------------------------------------ */
/** 3) 날짜 계산
  - DATE_ADD(date, INTERVAL expr type)

  [type값]
  SECOND, MINITE, HOUR, DAY, MONTH, YEAR
*/

-- 100일 후
select date_add(now(), INTERVAL 100 DAY);

-- 7일전
select date_add(now(), INTERVAL -7 DAY);


/** 4) 날짜 형식 지정
	- DATE_FORMAT(날짜데이터, 형식)

	[형식]
	달 이름		: %M
	요일이름	: %W
	YYYY형식의 년도	: %Y
	YY형식의 년도	: %y
	요일 이름의 약자: %a
	DD형식의 날짜	: %d
	D형식의 날짜	: %e
	MM형식의 월	: %m
	HH형식의 시간(24시간제)	: %H
	H형식의 시간(24시간제)	: %k
	HH형식의 시간(12시간제) : %h
	MM형식의 분	: %i
	SS형식의 초	: %s
	AM/PM		: %p
*/
select date_format(now(), '%Y%m%d%H%i%s');
