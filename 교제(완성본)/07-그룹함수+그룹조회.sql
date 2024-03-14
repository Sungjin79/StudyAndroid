/* 그룹함수 익히기
 -------------------------------------------------- */
그룹함수는 테이블의 전체 행을 하나 이상의 칼럼을 기준으로
칼럼 값에 따라
그룹화하여 그룹별로 결과를 출력하는 함수이다.
그룹 함수는 SELECT 절이나
HAVING 절에서 사용할 수 있다. 그룹함수는 그룹별로 합계, 평균, 최대, 최소,
개수 등을 구하기 위해 주로 사용한다.

SELECT   column, group_function(column)
FROM	   table
[WHERE  condition]
[GROUP BY  group_by_expression]
[HAVING  group_condition]

종류		의미
--------------------------------------------------
COUNT	행의 갯수 출력
MAX		NULL을 제외한 모든행에서 최대값 출력
MIN		NULL을 제외한 모든 행에서 최소값 출력
SUM		NULL을 제외한 모든 행의 합계
AVG		NULL을 제외한 모든 행의 평균값


/* COUNT 함수
 -------------------------------------------------- */
테이블에서 조건을 만족하는 행의 개수를 반환하는 함수
COUNT ({* |[ DISTINCT | ALL] expr} )

/** 3학년 학생들은 총 몇명인가? */
SELECT studno FROM student WHERE grade='3';
SELECT COUNT(studno) FROM student WHERE grade='3';

예제 : 101번 학과 교수중에서 보직 수당을 받는 교수를 출력

SQL> SELECT COMM FROM professor WHERE deptno = 101;
SQL> SELECT COUNT(COMM) FROM professor WHERE deptno = 101;
SQL> SELECT COUNT(*) FROM professor WHERE deptno = 101;
SQL> SELECT COUNT(*) FROM   professor
     WHERE deptno = 101 AND comm IS NOT NULL

COUNT(*) 는 NULL을 가진 행을 포함하므로 두 문장의 결과는 다르게 나온다.


/* AVG, SUM, MIN, MAX 함수
 -------------------------------------------------- */
AVG([ DISTINCT | ALL]  expr)
SUM([ DISTINCT | ALL]  expr)
expr의 데이터 타입은 NUMBER만 가능함

/** 1) 가장 월급을 많이 받는 교수는 얼마를 받는가? */
SELECT MAX(sal) FROM professor;

/** 2) 가장 월급을 적게 받는 교수는 얼마를 받는가? */
SELECT MIN(sal) FROM professor;

/** 3) 한달에 지급되는 교수들의 총 급여는 얼마인가? */
SELECT SUM(sal) FROM professor;

/** 4) 학생들의 평균 키는 얼마인가? */
SELECT AVG(height) FROM student;

예제 : 101번 학과 학생들의 몸무게 평균과 합계를 출력

SQL> SELECT AVG(weight), SUM(weight) FROM  student
     WHERE  deptno = 101;

ex) 101번 학과 학생들 중에서 최대 키와 최소 키를 출력하여라.
mysql> SELECT MAX(height), MIN(height) FROM student
       WHERE deptno = 101;


/* 데이터 그룹 생성
 -------------------------------------------------- */
GROUP BY 절
- 특정 칼럼 값을 기준으로 테이블의 전체 행을 그룹별로 나누기 위한 절.

사용 규칙)
  * 그룹핑 전에 WHERE절을 사용하여 그룹 대상 집합을 먼저 선택가능.
  * GROUP BY 절에는 반드시 칼럼이름이 포함되어야 하며 별명 사용 불가.
  * (그룹별로 출력 순서는 오름차순으로 정렬됨.) - 정렬필요
  * SELECT 절에서 나열된 칼럼 이름이나 표현식은 GROUP BY절에 반드시
    포함 되어야 함.
  * GROUP BY 절에 나열된 칼럼 이름은 SELECT 절에 명시하지 않아도 됨.

예제 : 교수 테이블에서 학과별로 교수 수와 보직 수당을 받는 교수 수를 출력

SQL> SELECT deptno, COUNT(*), COUNT(comm)
     FROM professor
     GROUP BY deptno;

ex) 학과별로 소속 교수들의 평균 급여, 최소 급여, 최대 급여를 출력하여라.
SQL> SELECT deptno, AVG(sal), MIN(sal), MAX(sal)
     FROM professor
     GROUP BY deptno;


/* 다중 칼럼을 이용한 그룹별 검색
 -------------------------------------------------- */
예제 : 학생 테이블에서 전체 학생을 소속 학과별로 나누고, 같은 학과 학생은
      다시 학년별로 그룹핑하여, 학과와 학년별로 인원수, 평균 몸무게를 출력
SQL> SELECT deptno, grade, COUNT(*), AVG(weight)
         FROM  student
         GROUP BY deptno, grade;


/* HAVING 절
 -------------------------------------------------- */
SELECT 명령문의 WHERE절과 비슷한 기능을 하는 것으로 GROUP BY절에서
조건 검색을 할 경우 반드시 HAVING 절을 사용해야 한다.

 SELECT 	column, group_function(column)
 FROM 		table
 [WHERE 	condition]
 [GROUP BY 	group_by_expression]
 [HAVING 	group_condition]
 [ORDER BY  	column]

예제 : 학생 수가 4명 초과인 학년에 대해서 학년, 학생 수, 평균 키, 평균 몸무게를 출력. 단, 출력순서는 평균 키가 높은 순부터 내림차순으로 출력.

* HAVING 절을 사용하지 않은 경우 (학생수가 4명 이하인 경우도 출력된다.)
SQL>   SELECT grade, count(*), AVG(height) avg_height, AVG(weight) avg_weight
       FROM   student
       GROUP BY grade
       ORDER BY avg_height DESC;

* HAVING 절을 사용한 경우 (학생수가 4명 이하인 경우는 출력하지 않는다.)
SQL>   SELECT grade, count(*), AVG(height) avg_height, AVG(weight) avg_weight
       FROM   student
       GROUP BY grade
       HAVING  COUNT(*) > 4
       ORDER BY avg_height DESC;


ex) 학과별로 평균 몸무게와 학생수를 출력하되 평균 몸무게의 내림차순으로 정렬하세요.
SELECT deptno, AVG(weight) as avg_weight, COUNT(*)
FROM student
GROUP BY deptno
ORDER BY avg_weight DESC;

ex) 동일 학과 내에서 같은 학년에 재학중인 학생 수가 3명 이상인 그룹의 학과
번호, 학년, 학생 수, 최대 키, 최대 몸무게를 출력하세요.
SELECT
  deptno, grade, COUNT(*), MAX(height), MAX(weight)
FROM student
GROUP BY deptno, grade
HAVING COUNT(*) >= 3
ORDER BY deptno;

ex) 학과별 교수 수가 2명 이하인 학과 번호, 교수 수를 출력 하세요.
SELECT deptno, COUNT(*)
FROM PROFESSOR
GROUP BY deptno HAVING COUNT(*)<=2
ORDER BY deptno;
