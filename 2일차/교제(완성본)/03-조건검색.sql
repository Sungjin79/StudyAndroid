/* where절을 이용한 조건 지정
 ------------------------------------------------------- */

SELECT [DISTINCT] { * | 컬럼이름 [AS `별칭`] ... }
FROM 테이블이름
[WHERE  검색조건];

-------------------------------------------------------
예제 : 학생 테이블에서 1학년 학생만 검색하여 학번, 이름, 학과 번호를 출력
 -------------------------------------------------------
mysql> SELECT studno, name, deptno FROM student WHERE grade = 1;


ex) 학생테이블에서 학과번호가 101번인 학생들의 학번 , 이름, 학년을 출력하세요 ~
mysql> SELECT studno, name, grade FROM student WHERE deptno=101;

ex) 교수테이블에서 학과번호가 101번인 교수들의 교수번호 , 이름, 급여를 출력하세요 ~
mysql> SELECT profno, name, sal FROM professor WHERE deptno=101;


/*  연산자 의미
 ------------------------------------------------------- */
	=			같다
	!= , <>		같지 않다
	>			크다
	>=			크거나 같다
	<			작다
	<=			작거나 같다

/* 비교 연산자를 이용한 조건 검색
 ------------------------------------------------------- */
예제 : 학생 테이블에서 몸무게가 70kg 이하인 학생만 검색하여 학번, 이름,
      학년, 학과번호, 몸무게를 출력
mysql> SELECT studno, name, grade, deptno, weight
       FROM student
       WHERE weight <= 70;

ex) 학생테이블에서 키가 170 이상인 학생의 학번, 이름, 학년, 학과번호,
   키를 출력하여라.


mysql> SELECT studno, name, grade, deptno, height
        FROM student
        WHERE height >= 170;


/* 논리 연산자
 --------------------------------------------------- */
 AND :   모든 조건이 참 일 때 참 값을 반환 (PHP=>&&)
 OR  :   모든 조건 중 하나라도 참 일 때 참 값을 반환 (PHP=>||)
 NOT :   조건과 반대되는 결과를 반환 (PHP=>!)

/* 논리 연산자를 이용하여 조건 검색
 --------------------------------------------------- */
예제: 학생 테이블에서 1학년이면서 몸무게가 70kg 이상인 학생만 검색하여
      이름, 학년, 몸무게, 학과 번호를 출력
mysql> SELECT name, studno, grade, weight, deptno
       FROM student
       WHERE grade = '1' AND weight >= 70;

ex) 학생 테이블에서 1학년 이거나 몸무게가 70kg 이상인 학생만 검색하여
    이름, 학번, 학년, 몸무게, 학과 번호를 출력하여라.
mysql> SELECT name, studno, grade, weight, deptno
       FROM student
       WHERE grade='1' OR weight >= 70;



