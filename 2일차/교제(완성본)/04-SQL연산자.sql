/* SQL연산자 (1) - BETWEEN 연산자
 --------------------------------------------------- */
- BETWEEN 연산자는 특정 칼럼의 데이터 값이 하한값 `a`와
  상한값 `b`사이에 포함되는 행을 검색하기 위한 연산자이다.
 
예제 : BETWEEN 연산자를 사용하여 몸무게가 50kg에서 70kg사이인 학생의
      학번, 이름, 몸무게를 출력
mysql> SELECT studno, name, weight FROM student
       WHERE weight BETWEEN 50 AND 70;

/* SQL연산자 (2) - IN 연산자
 --------------------------------------------------- */
IN 연산자는 특정 칼럼의 데이터 값이 a,b,c,... 값 중에 하나라도 일치하면
참이 되는 연산자이다.

예제 : IN 연산자를 사용하여 102번 학과와 201번 학과 학생의 이름, 학년,
      학과번호를 출력
mysql> SELECT name, grade, deptno FROM student
       WHERE deptno IN (102, 201);

ex) 교수테이블(professor)에서 직급이 조교수 또는 전임강사인
    교수의 번호, 이름, 직급, 학과번호를 출력하여라.
mysql> SELECT profno, name, position, deptno FROM professor
       WHERE position IN ('조교수','전임강사');


/* SQL연산자 (3) - LIKE 연산자
 --------------------------------------------------- */
LIKE 연산자는 컬럼에 저장된 문자열 중에서 LIKE 연산자에서 지정한
문자패턴과 부분적으로 일치하면 참이 되는 연산자이다.
아래와 같은 특수문자를 이용할 수 있다.

‘%’: 임의의 길이의 문자열(길이가 0인 경우도 포함)에 대한 와일드 문자로
      윈도에서의 *와 동일의미 가짐.

      '%김' --> '김'으로 끝나는 모든 내용.
      '김%' --> '김'으로 시작하는 모든 내용
      '%김%' --> 앞 뒤 구분 없이 '김'을 포함하는 모든 내용.


예제 : 학생 테이블에서 성이 ‘김’씨인 학생의 이름,학년,학과번호를 출력
mysql> SELECT name, grade, deptno FROM  student
       WHERE name LIKE '김%';

ex) 학과이름에 '공학'이라는 단어가 포함된 모든 학과의 학과번호,이름,위치를
    조회하시오.
mysql> SELECT deptno, dname, loc FROM department
       WHERE dname LIKE '%공학%';


/* NULL 연산자
 --------------------------------------------------- */
- NULL 은 미확인 값이나 아직 적용되지 않은 값을 의미하는 것으로
  0과는 다른 의미를 가진다.
  예를 들어 학생 몸무게가 NULL 인 경우는 학생 몸무게가 0이 아니라
  현재 조회시점에서 그 학생의 몸무게를 모른다는 의미인 것이다.
  NULL 은 숫자 0이나 공백이 아니라는 점을 정확하게 이해해야 한다.

  예제 : 교수 테이블에서 이름 ,직급, 보직 수당을 출력

      mysql> SELECT name, position, comm FROM professor;

  설명: comm 칼럼의 데이터 중에서 NULL과 숫자 0은 의미가 다르다.
  숫자 0은 보직수당이 하나도 없음을 의미하지만, NULL은 보직수당이
  얼마인지 잘 모른다는 것을 의미한다.



/* IS NULL 연산자 / IS NOT NULL 연산자
 --------------------------------------------------- */
 - IS NULL 연산자는 칼럼 값중에서 NULL 을 포함하는 행을
   검색하기 위해 사용하는 연산자이다.
 - 반면 IS NOT NULL 연산자는 NULL을 포함하지 않는 행을
   검색하기 위해 사용한다.

예제 : 교수 테이블(professor)에서 보직수당이 없는 교수의
       이름, 직급, 보직수당을 출력
mysql> SELECT name, position, comm FROM professor
       WHERE comm IS NULL;

예제 : 교수 테이블에서 보직수당을 받고 있는 교수의
       이름과 급여, 보직수당을 출력하여라.
mysql> SELECT name, sal, comm FROM professor
       WHERE comm IS NOT NULL;

  ** 참고: DB에서 NULL데이터가 많아질 수록 성능 저하가 두드러진다.



/* 연산자 우선 순위
 --------------------------------------------------- */
1       비교연산자(=,!=,<>,>,>=,<,<=),
            SQL연산자(BETWEEN, IN, LIKE, IS NULL)
2       NOT
3       AND
4       OR

예제 : 102번 학과의 학생중에서 1학년 또는 4학년 학생의
       이름, 학년, 학과 번호를 출력
mysql>  SELECT name, grade, deptno
      FROM student
      WHERE deptno = 102
      AND (grade=4 OR grade=1);

ex) 102번 학과의 학생 중에서 4학년 학생이거나 소속학과에
    상관없이 1학년 학생들의 이름, 학년, 학과 번호를 출력하여라.
mysql> SELECT name, grade, deptno FROM student
       WHERE (deptno=102 AND grade=4) OR grade=1;

