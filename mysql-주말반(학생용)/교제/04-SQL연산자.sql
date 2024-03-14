/* SQL연산자 (1) - BETWEEN 연산자
 --------------------------------------------------- */
- BETWEEN 연산자는 특정 칼럼의 데이터 값이 하한값 `a`와
  상한값 `b`사이에 포함되는 행을 검색하기 위한 연산자이다.
 
예제 : BETWEEN 연산자를 사용하여 몸무게가 50kg에서 70kg사이인 학생의
      학번, 이름, 몸무게를 출력
mysql>

/* SQL연산자 (2) - IN 연산자
 --------------------------------------------------- */
IN 연산자는 특정 칼럼의 데이터 값이 a,b,c,... 값 중에 하나라도 일치하면
참이 되는 연산자이다.

예제 : IN 연산자를 사용하여 102번 학과와 201번 학과 학생의 이름, 학년,
      학과번호를 출력
mysql>


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
mysql> 



/* IS NULL 연산자 / IS NOT NULL 연산자
 --------------------------------------------------- */
 - IS NULL 연산자는 칼럼 값중에서 NULL 을 포함하는 행을
   검색하기 위해 사용하는 연산자이다.
 - 반면 IS NOT NULL 연산자는 NULL을 포함하지 않는 행을
   검색하기 위해 사용한다.

예제 : 교수 테이블(professor)에서 보직수당이 없는 교수의
       이름, 직급, 보직수당을 출력
mysql> 

예제 : 교수 테이블에서 보직수당을 받고 있는 교수의
       이름과 급여, 보직수당을 출력하여라.
mysql>

  ** 참고: DB에서 NULL데이터가 많아질 수록 성능 저하가 두드러진다.

