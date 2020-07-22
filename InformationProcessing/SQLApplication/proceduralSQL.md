# 8. SQL 응용

## 1. 
구성|설명
-|-
( 1 )|- 프로시저의 명칭, 변수와 인수 그리고 그에 대한 데이터 타입을 정의하는 부분
시작/종료부|- 프로시저의 시작과 종료를 표현<br>- 다수 실행을 제어하는 기본적 단위가 되며 논리적 프로세스를 구성
제어부|- 기본적으로는 순차적으로 처리<br>- 조건문과 반복문을 이용하여 문장을 처리
SQL|- DML을 주로 사용<br>- 자주 사용되지 않지만 DDL 중 TRUNCATE 사용
( 2 )|- BEGIN ~ END 절에서 실행되는 SQL 문이 실행 될 떄 예외 발생 시 예외 처리 방법을 정의하는 처리부
( 3 )|- 트리거에서 수행된 DML 수행 내역의 DBMS의 적용 또는 취소 여부를 결정하는 처리부

→<br>
(1) 선언부 DECLARE
(2) 예외부 EXCEPTION
(3) 실행부 TRANSACTION

프로시저 구성 -> 디비컨 SET

## 2. DB 프로시저란?
-> 절차형 SQL을 활용하여 특정 기능을 수행할 수 있는 트랜잭션 언어이다.

## 3. 프로시저 구성을 순서대로 나열하시오

선언부(DECLARE), 시작/종료부(BEGIN), 제어부(CONTROL), SQL, 예외부(EXCEPTION), 실행부(TRANSACTION)

## 4. 프로시저 선언부 모드
모드|설명
-|-
( 1 )|운영체제에서 프로시저로 값을 전달하는 모드
( 2 )|프로시저에서 처리된 결과를 운영체제로 전달하는 모드
( 3 )|( 1 )과/와 ( 2 )의 두 가지 기능을 동시에 수행하는 모드

→ <br>
(1) IN
(2) OUT
(3) INOUT

## 5. 다음은 프로시저 내부의 조건문에 대한 쿼리이다. 아래 조건에 맞는 쿼리를 완성하시오
~~~markdown
프로시저 이름은 CONTROL_SALARY이다. 입력값은 직원 사번(:v_ENO)에 입력 받는다. 직원 테이블(EMPLOYEE)에서 사번(:v_ENO)에 해당하는 직원의 급여(Salary)를 확인 한 후, 급여가 1000 이하면 3%, 1000 초과 2000 이하면 2%, 2000 초과는 1% 인상한다. 인상된 값은 직원 테이블(EMPLOYEE)에 갱신한다.
~~~

~~~SQL
CREATE PROCEDURE CONTROL_SALARY
( v_eno IN NUMBER)
IS
BEGIN
    v_salary NUMBER := 0;

    SELECT SALARY
        INTO v_salary
        FROM EMPLOYEE
    WHERE EMP_NO = :v_eno;

    ( 1 ) v_salary <= 1000 THEN
        v_salary = v_salary * 1.03;
    ( 2 ) 조건 THEN
        v_salary = v_salary * 1.02;
    ( 3 )
        v_salary = v_salary * 1.01;
    END ( 1 );

    UPDATE EMPLOYEE
        SET SALARY = :v_salary
    WHERE EMP_NO = :v_eno;
COMMIT;
END;
~~~

→ <br>
(1) IF<BR>
(2) ELSIF<BR>
(3) ELSE

## 6. 다음은 프로시저에 대한 예외부이다. 밑줄에 들어갈 가장 적합한 키워드는?
~~~sql
( 1 )
    ( 2 ) 조건 THEN
        ( 3 ) 명령어;
~~~

→ <br>
(1) EXCEPTION <br>
(2) WHEN <br>
(3) SET

## 7. 다음은 프로시저이다. 밑줄에 들어갈 가장 적합한 키워드는?
~~~sql
( 1 ) PROCEDURE_NAME
( VARIABLE_NAME ( 2 ) CHAR(8)
BEGIN
...
END;
~~~

→ <br>
( 1 ) CREATE <br>
( 2 ) IN / OUT / INOUT

프로시저 선언부의 항목은 다음과 같다.
<table>
    <tr>
        <td>CREATE</td>
        <td>DBMS 내에 객체(트리거, 함수, 프로시저)를 생성</td>
    </tr>
    <tr>
        <td>PROCEDURE</td>
        <td>프로시저를 사용한다는 의미</td>
    </tr>
    <tr>
        <td>프로시저 명</td>
        <td>해당 프로시저를 지칭하는 이름</td>
    </tr>
    <tr>
        <td>파라미터 명</td>
        <td>프로시저와 운영체제 간 필요한 값을 전송하기 위한 인자</td>
    </tr>
    <tr>
        <td>[MODE]</td>
        <td>변수의 입출력을 구분하고, IN / OUT / INPUT 3가지로 구성(운영체제에서 프로시저로 값을 전달하기 위해서는 IN을 사용</td>
    </tr>
    <tr>
        <td>데이터 타입</td>
        <td>해당 파라미터에 대한 데이터 타입(용도에 따라 선택)</td>
    </tr>
    <tr>
        <td>IS [AS]</td>
        <td>PL/SQL의 블록을 시작<br>IS 또는 AS 키워드를 작성</td>
    </tr>
</table>

## 8. 프로시저 실행부.
구성|설명
-|-
( 1 )|하나의 트랜잭션이 성공적으로 끝났을 때 사용하는 연산
( 2 )|하나의 트랜잭션이 비정상적으로 종료되어 처음부터 다시 시작하거나, 부분적으로 연산을 취소하는 연산

→<br>
(1) COMMIT<br>
(2) ROLLBACK

## 9. DB 사용자 정의 함수란?

→ 절차형 SQL을 활용하여 일련의 SQL 처리를 수행하고, 수행 결과를 단일 값으로 반환할 수 있는 절차형 SQL이다.

## 10. 사용자 정의함수 구성

구성|설명
-|-
( 1 )|- 프로시저의 명칭, 변수와 인수 그리고 그에 대한 데이터 타입을 정의하는 부분
시작/종료부|- 프로시저의 시작과 종료를 표현하는 데 필수적이며, BEGIN/END를 쌍을 이루어 추가하므로 블록으로 구성<br>- 다수 실행을 제어하는 기본적 단위가 되며 논리적 프로세스를 구성
( 2 )|- 기본적으로는 순차적으로 처리<br>- 비교 조건에 따라 블록 또는 문장을 실행<br>- 조건에 따라 반복 실행
SQL|- DML을 주로 사용하고, 자주 사용되지 않지만 DOL(TRUNCATE 등)을 사용
예외부|- BEGIN~END 절에서 실행되는 SQL문이 실행될 때 예외 발생 시 예외 처리 방법을 정의하는 처리부
( 3 )|- 호출문에 대한 함수 값을 반환

→<br>
( 1 ) 선언부
( 2 ) 제어부
( 3 ) 반환부

→ 디비컨SER

## 11. 트리거란?

→ 특정 테이블에 삽입, 수정, 삭제 등의 데이터 변경 이벤트가 발생하면 DBMS에서 자동적으로 실행되도록 구현된 프로그램이다.

## 12. 트리거 선언이다. AAA라는 이름의 사용자 정의함수가 이미 존재할 때 컴파일 에러가 발생하지 않도록 하려면 사용해야 하는 키워드는?

~~~sql
CREATE (      ) TRIGGER AAA
...
~~~

→ OR REPLACE

- OR REPLACE 명령은 기존 프로시저 존재 시에 현재 컴파일하는 내용으로 덮어쓴다. (만약에 OR_REPLACE 명령이 없고, 같은 이름의 프로시저가 존재하면 에러 발생)

## 13. 트리거 이벤트
순서|설명
-|-
( 1 )|이벤트부의 테이블에 대한 INSERT/UPDATE/DELETE를 수행하기 전에 트리거가 실행되도록 지정하는 명령
( 2 )|이벤트부의 테이블에 대한 INSERT/UPDATE/DELETE가 성공적으로 실행되었을 때만 트리거가 실행되도록 지정하는 명령

→<br>
(1) BEFORE
(2) AFTER

- DML과 트리거가 실행되는 순서의 전후 관계를 BEFORE, AFTER 키워드를 이용하여 결정한다.