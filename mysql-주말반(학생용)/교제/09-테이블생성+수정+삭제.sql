/** DB만들기
 -------------------------------------- */
표준> CREATE DATABASE `DB이름`;

MySQL> CREATE DATABASE [IF NOT EXISTS] `DB이름`
       [DEFAULT CHARSET `utf8`];

  * IF NOT EXISTS : 동일한 이름의 DB가 없는 경우만 실행
  * DEFAULT CHARSET `utf8` : 사용할 기본 문자셋 설정

/** DB 삭제하기
 -------------------------------------- */
표준> DROP DATABASE `DB이름`;
MySQL> DROP DATABASE [IF EXISTS] `DB이름`;
  * IF EXISTS : 존재할 경우만 삭제하는 옵션


/** 테이블 만들기
 -------------------------------------- */
CREATE TABLE [IF NOT EXISTS] `테이블이름` (
  `컬럼이름` 데이터타입 [NOT NULL | NULL] [AUTO_INCREMENT],
  `컬럼이름` 데이터타입 [NOT NULL | NULL] [AUTO_INCREMENT],
  `컬럼이름` 데이터타입 [NOT NULL | NULL] [AUTO_INCREMENT],
  ...
  [, PRIMARY KEY (`기본키컬럼이름`)]
) [ENGINE=InnoDB] [DEFAULT CHARSET=utf8];

* IF NOT EXISTS : 테이블이 존재하지 않을 경우만 생성
* NOT NULL | NULL : NULL 데이터 허용여부 설정
          (명시하지 않을 경우 기본값=NULL)
    --> NULL 제약조건
* PRIMARY KEY (`기본키컬럼이름`) : 각 행을 구별하기 위한 고유값을
           저장하기 위한 컬럼의 이름을 명시 (=기본키,Primary Key)
           명시하지 않을 경우 중복데이터가 허용됨
        --> 데이터 무결성 제약조건
* ENGINE=InnoDB : MySQL 5.x에서 추가된 신규 엔진을 사용하는 옵션
        --> 엔진 설정 시, 다른 DBMS에서 지원되던 기능들을
            사용할 수 있음. (ex: 참조키, 프로시저 등...)
* DEFAULT CHARSET=utf8 : 테이블에서 사용할 문자셋 설정


/** 테이블 삭제하기
 -------------------------------------- */
표준> DROP TABLE `DB이름`;
MySQL> DROP TABLE [IF EXISTS] `DB이름`;
  * IF EXISTS : 존재할 경우만 삭제하는 옵션


예제) members라는 이름의 테이블을 다음과 같이 만들어 보세요.
----------------------------------------------------------------


