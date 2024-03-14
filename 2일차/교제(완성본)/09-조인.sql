/* 조인 (Join)
 ------------------------------------------------- */

조인의 개념
	두 개 이상의 테이블을 결합하여 필요한 데이터를 조회하게 하는 기능
	예를 들어 학번이 10101인 학생의 이름과 소속 학과 이름을 출력하려
	할 때 student table 과 department table을 두 번 조회 해야 하지만
	조인을 이용하면 한번에 조회가 가능하다.

조인의 종류
	카티션 곱(cartesian product, cross join), EQUI JOIN,
	NON-EQUI JOIN OUTER JOIN, SELF JOIN 등이 있다.

조인 문법
	SELECT table1.column, table2.column
	FROM  table1, table2
	WHERE condition;



/* 카티션 곱 (Cartesian Product)
 ------------------------------------------------- */
- 두개 이상의 테이블에 대해 연결 가능한 행을 모두 결합하는 조인방법.
WHERE 절에서 조인 조건절을 생략하거나 조인 조건을 잘못 설정하여 양쪽
테이블을 연결하는 조건을 만족하는 행이 하나도 없는 경우에 발생한다.

예제 : 학생 테이블과 부서 테이블을 카티션 곱을 한 결과를 출력

 SQL> SELECT name, student.deptno, dname, loc
          FROM student, department;

위 문장을 실행하면 112개의 행이 나온다. 위 쿼리문에서 WHERE 조건이 없어서 생긴 문제이며 항상 이런 상황이 발생하지 않도록 주의해야 한다.


/* EQUI JOIN
 ------------------------------------------------- */
 - SQL 문에서 가장 많이 사용되는 조인으로 조인 대상 테이블에서 공통칼럼을 ‘=‘ 비교를 통해 같은 값을 갖는 행을 연결하여 결과를 생성하는 조인 방법임.

SELECT    table1.column, table2.column
FROM     table1, table2
WHERE    table1.column = table2.column;

예제 : 학생 테이블과 부서 테이블을 EQUI JOIN 하여 학번, 이름, 학과번호, 소속학과이름, 학과 위치를 출력

SQL>    SELECT s.studno, s.name, s.deptno, d.dname, d.loc
	FROM  student s, department d
	WHERE s.deptno = d.deptno;

ex) 학생테이블과 교수테이블을 조인하여 이름, 학년,지도교수 이름,직급을 출력하세요.
SELECT s.name, s.grade, p.name, p.position
FROM student s, professor p
WHERE s.profno=p.profno;


/* INNER JOIN
 ------------------------------------------------- */
- 조인하는 테이블의 ON 절의 조건이 일치하는 결과만 출력한다.

예제 : 학생 테이블과 부서 테이블을 EQUI JOIN 하여 학번, 이름, 학과번호, 소속학과이름, 학과 위치를 출력

SQL>    SELECT s.studno, s.name, s.deptno, d.dname, d.loc
	FROM  student s
	INNER JOIN department d
	ON s.deptno=d.deptno;

ex) 학생테이블과 교수테이블을 조인하여 이름, 학년,지도교수 이름,직급을 출력하세요.
    (앞의 예제를 INNER JOIN으로 표)
SELECT s.name, s.grade, p.name, p.position
FROM student s INNER JOIN professor p ON s.profno=p.profno;


/* OUTER JOIN
 ------------------------------------------------- */
NULL에 어떤 연산을 적용시켜도 결과는 null 이 된다. 따라서 조인 조건 중 하나의 값이 NULL일 경우 값이 NULL이 되어 출력되지 않는다. 하지만 결과가 NULL 일지라도 출력해야 할 경우가 발생하는데 이때 사용되는 것이 OUTER JOIN 이다.
 LEFT OUTER JOIN, RIGHT OUTER JOIN, FULL OUTER JOIN
 FULL OUTER는 성능 저하 문제 때문에 실무에서 사용하지는 않는다.

** 학생별 지도 교수의 이름을 보고자 하는 경우

1) EQUI Join
SELECT s.name `학생이름`, p.name `지도교수`
FROM student s, professor p
WHERE s.profno = p.profno;

2) INNER Join
SELECT s.name `학생이름`, p.name `지도교수`
FROM student s
INNER JOIN professor p
ON s.profno = p.profno;

3) LEFT OUTER Join (단, 지도교수가 없는 경우 학생의 이름만 출력하라.)
SELECT s.name `학생이름`, p.name `지도교수`
FROM student s
LEFT OUTER JOIN professor p
ON s.profno = p.profno;


4) RIGHT OUTER Join (단, 지도교수가 없는 경우 학생의 이름만 출력하라.)
SELECT s.name `학생이름`, p.name `지도교수`
FROM professor p
RIGHT OUTER JOIN student s
ON p.profno = s.profno;



