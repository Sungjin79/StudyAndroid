/** 학생 테이블을 참조하여 다음 질문에 적절한 SQL문을 작성하여라(1-4)
 ------------------------------------------------------------ */

1. 키가 170보다 큰 학생의 이름, 학년 , 키를 출력하되 키가 큰 순으로 출력하여라.
SQL> SELECT NAME, GRADE, HEIGHT FROM STUDENT
     WHERE HEIGHT >= 170 ORDER BY HEIGHT DESC;

2. 101번 학과 학생 중에서 3학년 이상인 학생의 이름, 사용자 아이디, 학년을 출력하여라.
SQL> SELECT NAME, USERID, GRADE FROM STUDENT
     WHERE DEPTNO=101 AND GRADE >= 3;

3. 키가 165 이상인 175 이하인 학생의 이름, 학년, 키를 출력하여라.
SQL> SELECT NAME, GRADE, HEIGHT FROM STUDENT
     WHERE HEIGHT BETWEEN 165 AND 175;

SQL> SELECT NAME, GRADE, HEIGHT FROM STUDENT
     WHERE HEIGHT >= 165 AND HEIGHT <= 175;

4. 학생 중에서 성이 ‘이’ 씨인 학생의 이름, 사용자 아이디,
   학과 번호를 출력하여라.
SQL> SELECT NAME, USERID, DEPTNO FROM STUDENT
     WHERE NAME LIKE '이%';



/** 교수 테이블을 참조하여 다음 질문에 적절한 SQL 명령문을 작성하여라 (5-8)
 ------------------------------------------------------------ */
5. 보직수당(comm)의 값을 모르거나 없는 교수의 이름, 급여, 학과번호를 출력하여라.
SQL> SELECT NAME, SAL, DEPTNO FROM PROFESSOR
     WHERE COMM IS NULL;

6. 교수 번호, 이름, 급여, 보직수당을 급여가 많은 순으로 출력하여라.
SQL> SELECT PROFNO, NAME, SAL, COMM FROM PROFESSOR
     ORDER BY SAL DESC;

7. 교수번호, 이름, 급여, 연봉, 학과 번호를 출력하되
   학과 번호와 연봉 순으로 정렬하여 출력하여라,
   단, 학과 번호는 오름차순으로 연봉(sal * 12)은 내림차순으로 정렬하여라.
SQL> SELECT PROFNO, NAME, SAL, (SAL*12), DEPTNO FROM PROFESSOR
     ORDER BY DEPTNO, (SAL*12) DESC;

SQL> SELECT PROFNO, NAME, SAL, (SAL*12) AS `SAL_YEAR`, DEPTNO
     FROM PROFESSOR
	 ORDER BY DEPTNO, SAL_YEAR DESC;

8. 급여가 300 이상이면서 보직수당을 받거나 급여가 450 이상인
   교수 이름, 급여, 보직수당을 출력하여라.
SQL> SELECT NAME, SAL, COMM FROM PROFESSOR
     WHERE (SAL >= 300 AND COMM IS NOT NULL) OR SAL >= 450;


/* JOIN 종합문제
 ------------------------------------------------- */
문제1) 학번이 10101 인 학생의 학번, 이름, 학과이름과 학과 위치를 출력하세요.
SQL> SELECT s.studno, s.name, d.dname, d.loc
     FROM student s, department d
     WHERE s.deptno = d.deptno AND s.studno = 10101;

문제2) 몸무게가 80kg 이상인 학생의 학번, 이름,체중,학과이름,학과위치를 출력하여라.
SQL> SELECT s.studno, s.name, s.weight, d.dname, d.loc
     FROM student s, department d
     WHERE s.deptno = d.deptno AND s.weight >=80;

문제3) EQUI JOIN 을 이용하여 학생 이름과 소속 학과 이름을 학과 이름, 학생 이름순으로 정렬하여 출력하세요.
SQL> SELECT s.name, d.deptno, d.dname
     FROM student s, department d
     WHERE d.deptno=s.deptno
     ORDER BY d.dname, s.name;

문제4) 3번 문제를 Inner Join으로 처리하세요.
select
      s.name, d.dname
from
      student s
inner join
      department d
on
      s.deptno = d.deptno
order by
      d.dname, s.name;

문제5) OUTER JOIN을 이용하여 101번 학과에 소속된 학생들의 이름과 지도 교수
이름을 학번순으로 출력 하세요.
select
      s.name, p.name
from
      student s
left outer join
      professor p
on
      s.profno = p.profno
where
      s.deptno='101'
order by
      s.studno asc;
