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
      이 테이블은 웹 프로그램에서 회원가입을 구현할 때 사용될 예정입니다.
----------------------------------------------------------------
DROP TABLE IF EXISTS `members`;

CREATE TABLE `members` (
    `id`            INT             NOT NULL    AUTO_INCREMENT,
    `user_id`       VARCHAR(20)     NOT NULL,
    `user_pw`       VARCHAR(150)    NOT NULL,
    `user_name`     VARCHAR(10)     NOT NULL,
    `email`         VARCHAR(150)    NOT NULL,
    `tel`           VARCHAR(12)     NOT NULL,
    `post1`         VARCHAR(3)          NULL,
    `post2`         VARCHAR(3)          NULL,
    `addr`          VARCHAR(150)        NULL,
    `addr2`         VARCHAR(150)        NULL,
    `reg_date`      DATETIME        NOT NULL,
    `edit_date`     DATETIME        NOT NULL,
    PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET `UTF8`;



/** 테이블의 구조 변경하기
 -------------------------------------- */
Alter문에는 여러가지 연산자가 있다.
 - Add : 테이블에 열을 추가한다.
 - Rename to : 테이블의 이름을 바꾼다.
 - Change : 기존 열의 이름과 데이터 타입을 바꾼다.
 - Modify : 기존 열의 데이터 타입이나 위치를 변경한다.
 - Drop : 테이블의 열을 제거한다.


1. 테이블명 변경
- ATLER TABLE 테이블명 RENAME 변경할테이블명;
sql> ALTER TABLE `members` RENAME `member_list`;

2. 필드 추가
- ATLER TABLE 테이블명 ADD 추가할필드명 필드타입 [NOT NULL | NULL] [AFTER|BEFORE 기존컬럼이름];
sql> ALTER TABLE `member_list` ADD memo text NULL AFTER cellphone;


3. 필드명 및 타입 변경
- (기존의 속성을 유지할 경우에는 데이터 형 및 옵션들을 동일하게
   명시해 준다.)
- ALTER TABLE 테이블명 CHANGE 기존필드명 변경할필드명 변경할필드타입 [NOT NULL|NULL] [AUTO_INCREMENT]
sql> ALTER TABLE `member_list` CHANGE memo introduce varchar(512) NULL;

4. 필드 삭제
- ATLER TABLE 테이블명 DROP 제거할필드명
sql> ALTER TABLE `member_list` DROP introduce;


5. 기본키 설정 해제
- ALTER TABLE 테이블명 DROP PRIMARY KEY
sql> ALTER TABLE `member_list` CHANGE id id int NOT NULL;
sql> ALTER TABLE `member_list` DROP PRIMARY KEY;


6. 기본키 설정
- ALTER TABLE 테이블명 ADD PRIMARY KEY (필드1, 필드2, ...)
sql> ALTER TABLE `member_list` ADD PRIMARY KEY (id);
sql> ALTER TABLE `member_list` CHANGE id id int NOT NULL AUTO_INCREMENT;
sql> ALTER TABLE `member_list` RENAME `members`;



/** 비번변경, 사용자 추가
 -------------------------------------- */
사용자 비밀번호 변경하기
set password for 아이디@host이름=password('새 비밀번호');
mysql> set password for root@localhost=password('123qwe!@#');

특정 데이터베이스에 대한 사용자 추가하기
- GRANT ALL PRIVILEGES ON DB이름.* to 아이디@localhost IDENTIFIED BY '비밀번호' WITH GRANT OPTION;
mysql> GRANT ALL PRIVILEGES ON myschool2.* to myuser2@localhost IDENTIFIED BY '123qwe!@#' WITH GRANT OPTION;

권한 작업의 내용을 시스템에 반영하기
mysql> flush privileges;

예제) mycompany라는 이름의 새로운 데이터베이스를 생성하고,
    companyuser라는 이름의 사용자를 추가한 후, mycompany에 대한 접근 권한을
    부여하세요. companyuser 사용자의 비밀번호는 '123qwe!@#'입니다.
mysql> CREATE DATABASE mycompany DEFAULT CHARSET utf8;
mysql> GRANT ALL PRIVILEGES ON mycompany.* to companyuser@localhost IDENTIFIED BY '123qwe!@#' WITH GRANT OPTION;
mysql> flush privileges;



