/* 데이터 정렬을 위한 ORDER BY
 --------------------------------------------------- */
* ORDER BY : 칼럼이나 표현식을 기준으로 출력 결과를 정렬할 때 사용

  SELECT   [DISTINCT] {* | 컬럼이름[ AS 별칭]......}
  FROM      테이블이름
  [ WHERE   검색조건 ]
  [ ORDER BY 컬럼이름 [정렬옵션] ]

* 정렬옵션
  ASC : 오름차순으로 정렬하는 경우에 사용하며 기본값임
            --> 순차 정렬 (기본값)
  DESC : 내림차순으로 정렬하는 경우에 사용하며 생략 불가능함
            --> 역순 정렬

기본적인 정렬방법
* 문자값: 알파벳순 출력, 한글은 가나다 순으로 출력됨
* 숫자값: 가장 작은 값부터 먼저 출력됨
* 날짜값: 과거의 날짜부터 출력됨

예제 : 학생 테이블에서 이름을 가나다 순으로 정렬하여 이름, 학년,
      전화번호를 출력
mysql> SELECT name, grade, tel FROM student ORDER BY name;


ex) 학생 테이블에서 학년을 내림차순으로 정렬하여 이름, 학년,
    주민등록번호를 출력하여라.
mysql> SELECT name, grade, idnum FROM student
       ORDER BY grade DESC;

ex) 학생 테이블에서 101번 학과에 소속된 학생들의 이름, 학년,
    학과번호를 생년월일이 빠른 순으로  출력하여라.
mysql> SELECT name, grade, deptno FROM student
       WHERE deptno = 101 ORDER BY birthdate ASC;

/* 다중 칼럼 및 컬럼 위치를 이용한 정렬
 --------------------------------------------------- */
ORDER BY 절에서 지정한 첫 번째 칼럼을 기준으로 정렬한 후
첫 번째 기준 컬럼에게 동일한 값이 있는 경우 두 번째 칼럼을
기준으로 다시 정렬한다.
이 때 각 컬럼별로 정렬 옵션은 따로 설정된다.

 예제 : 학생 테이블에서 모든 학생에 대해 학과번호를 오름차순으로
먼저 정렬하고, 같은 학과 학생들은 학년이 높은 순으로
다시 정렬하여 학번, 이름, 학년, 학과번호, 사용자 아이디를 출력하여라.
SQL> SELECT studno, name, grade, deptno, userid FROM  student
     ORDER BY deptno ASC, grade DESC;


/**
 LIMIT
------------------------------------
 조회 결과중에서 특정 위치의 데이터만 뽑아내는 구문.
 범위를 설정한다.

  SELECT ...
  FROM ...
  [WHERE]
  [ORDER BY]
  [HAVING]
  [GROUP BY]
  LIMIT 시작위치, 데이터수
*/

예제) 급여가 높은 교수의 이름과 급여를 조회.
      --> 상위 3명만 추려내기
SELECT name, sal FROM professor
ORDER BY sal DESC
LIMIT 0, 3;
