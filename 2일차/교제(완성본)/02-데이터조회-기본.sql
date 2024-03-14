/* 데이터 조회하기
 ------------------------------------ */
 SELECT  * | 컬럼1이름, 컬럼2이름, ... 컬럼n이름
 FROM 테이블이름;

 '*' : 모든 컬럼의 데이터를 조회한다.
 컬럼이름을 나열한 경우 : 원하는 데이터만 조회한다.
                         순서 변경 가능.

 * 학과테이블의 모든 컬럼에 저장된 데이터 조회하기
    mysql> SELECT * FROM department;
    mysql> SELECT deptno, dname, loc
           FROM department;

    '*'의 사용은 금기!!!
     --> 컬럼이름을 모두 나열한 경우보다 성능이 느려짐.

 ex) 학생 테이블(student)의 학생이름(name)과
     학생번호(studno)를 출력하여라.
     mysql> SELECT name, studno FROM student;




/* 검색결과 중복 제거 옵션
 --------------------------------------------- */
SELECT DISTINCT * | column_list FROM table_name;

예제 : 단일칼럼에서 DISTINCT 키워드 사용
-학생 테이블에서 중복되는 행을 제외한 학과번호 출력
---------------------------------------------
 mysql> SELECT deptno FROM student;  ---- 1
mysql> SELECT DISTINCT deptno FROM student; ---- 2
---------------------------------------------

예제 : 복수칼럼에서 DISTINCT 키워드 사용
-학생 테이블에서 중복되는 행을 제외한 학과번호와 학년을 출력
---------------------------------------------
mysql> SELECT deptno, grade FROM student;  ---- 1
mysql> SELECT DISTINCT deptno, grade FROM student;  ----2
---------------------------------------------

위 1번과 2번 문장의 결과값의 차이점은?





/* 칼럼에 대한 별명 부여
 --------------------------------------------- */
컬럼이름과 별명사이를 공백처리 또는 AS 키워드사용

예제 : 부서테이블에서 부서이름 칼럼의 별명은 dept_name,
       부서번호 칼럼의 별명은 DN 으로 부여하여 출력
---------------------------------------------
mysql> SELECT dname `dept_name`, deptno `DN` FROM department;
---------------------------------------------

예제 : 학과테이블에서 학과이름 칼럼의 별명은 Department_Name,
       학과번호 칼럼의 별명은 Department_Number 로 부여하여 출력
---------------------------------------------
mysql> SELECT dname AS `DEPARTMENT_Name`,
              deptno AS `Department_Number` FROM department;
---------------------------------------------


ex) department 테이블을 사용하여 deptno 를 부서 ,
    dname 부서명 , loc 를 위치로 별명을 설정하여 출력하세요.
---------------------------------------------
mysql> SELECT deptno `부서`, dname `부서명`, loc `위치`
       FROM department;
---------------------------------------------
혹은
---------------------------------------------
mysql> SELECT deptno AS `부서`, dname AS `부서명`, loc AS `위치`
       FROM department;
---------------------------------------------


/* 산술연산자 사용
 --------------------------------------------- */
예제 : 교수 테이블(professor)에서 교수이름(name), 급여(sal)
      그리고 보너스를 포함한 연봉을 출력하여라.
      단 보너스를 포함한 연봉은 급여*12를 한 결과에 보너스 100을
      더한 값으로 계산한다.
---------------------------------------------
mysql> select name, sal, sal*12+100 from professor;
---------------------------------------------



