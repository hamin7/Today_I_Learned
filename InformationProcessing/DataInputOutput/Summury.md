## 1. 논리 데이터 모델링 개념

- 논리 데이터 모델링은 데이터베이스 설계 프로세스의 기초 설계 단계로 비즈니스 정보의 구조와 규칙을 명확하게 표현할 수 있는 기법이다.

## 2. 옵티마이저에서 활용되는 실행계획의 개념

- 실행 계획(Execution Plan)은 옵티마이저가 생성한 SQL 처리 경로이다. / 사용자가 작성한 SQL이 요구한 데이터를 추출하기 위해 옵티마이저가 작업의 방법과 순서를 결정하는 것을 실행계획이라고 한다.

## 3. 논리 데이터 모델링 속성

구조|설명
-|-
개체|관리할 대상이 되는 실체
속성|관리할 정보의 구체적 항목
관계|개체 간의 대응관계

## 4. JDBC란?

- JDBC는 자바에서 데이터베이스를 사용할 수 있도록 연결해주는 응용 프로그램 인터페이스이다.

## 5. 정규화란?

- 정규화는 관계형 데이터베이스의 설계에서 중복을 최소화하게 데이터를 구조화하는 프로세스이다.

## 6. 중복 데이터 중에서 특정 부분만 수정되어 중복된 값이 모순을 일으키는 데이터베이스 이상현상은?

- 갱신 이상

## 7. 데이터베이스 이상 현상

이상 현상|설명
-|-
삽입 이상|정보 저장 시 해당 정보의 불필요한 세부정보를 입력해야 하는 경우
삭제 이상|정보 삭제 시 원치 않는 다른 정보가 같이 삭제되는 경우
갱신 이상|중복 데이터 중에서 특정 부분만 수정되어 중복된 값이 모순을 일으키는 경우

## 8. 인덱스 컬럼 선정 기준

- 분포도가 좋은 컬럼은 단독적으로 생성
- 자주 조합되어 사용되는 컬럼은 결합 인덱스로 생성


## 9. 모든 결정자가 후보키가 되도록 하여 결정자 함수 종속성을 제거하는 단계에 대해 설명하시오

- 보이스-코드 정규형(BCNF)은 결정자 함수이면서 후보키가 아닌 것 제거하는 단계

## 10. 논리 데이터 모델링 특징

특징|설명
-|-
포용성|- 모든 엔티티 타입, 속성, 관계, 프로세스 등을 포함
정규화|- 모든 데이터를 정규화하여 모델링
완전성|- 모든 규칙과 관계를 완전하고 정확하게 표현
독립성|- 성능, 제약사항에 독립적인 모델<br>- 특정 DBMS로부터 독립적인 성질

## 11. 테이블 내의 속성 값은 원자값으로 구성하고, 이메일 주소가 속성에 2개 이상 가지고 있는 경우 원자값이 아니기 때문에 속성 1개만 가지도록 구성하는 데이터베이스 정규화 단계에 대해 설명하라.

- 1정규형(1NF)은 원자값으로 구성하는 데이터베이스 정규화 단계이다.

## 12. 데이터베이스 정규화 단계

단계|조건
-|-
1정규형(1NF)|원자값으로 구성
2정규형(2NF)|부분함수 종속 제거(완전 함수적 종속 관계)
3정규형(3NF)|이행함수 종속 제거
보이스-코드 정규형(BCNF)|결정자 함수이면서 후보키가 아닌 것 제거
4정규형(4NF)|다치 종속성 제거
5정규형(5NF)|조인 종속성 제거

## 13. 개체-관계(E-R) 모델이란?

- 현실 세계에 존재하는 데이터와 그들 간의 관계를 사람이 이해할 수 있는 형태로 명확하게 표현하기 위한 모델로 요구사항으로부터 얻어낸 정보들을 개체, 속성, 관계로 기술한 모델이다.

## 14. 인덱스 설계에서 인덱스 컬럼 선정 관련 사항

- 분포도가 좋은 컬럼은 단독적으로 생성한다.
- 자주 조합되어 사용되는 컬럼은 결합 인덱스로 생성한다.
- 결합 인덱스는 구성되는 컬럼 순서 선정(사용 빈도, 유일성, 정렬 등)에 유의한다.
- 가능한 한 수정이 빈번하지 않은 컬럼을 선정한다.

## 15. 인덱스란?

- 인덱스는 검색 연산의 최적화를 위해 데이터베이스 내 열에 대한 정보를 구성한 데이터구조이다.

## 16. 지정된 테이블들의 조인이 Nested-Loop 형식으로 일어나도록 유도하기 위한 힌트는?

- /* + USE_NL (table_name) */

## 17. 

- 파티션 키의 해시값에 의한 균등한 데이터 분할 가능한 파티션 기법 - 해시 파티셔닝

## 18. 파티션 종류 중 레인지 파티셔닝이란?

- 레인지 파티셔닝은 연속적인 숫자나 날짜를 기준으로 하는 파티셔닝 기법이다.
- 손쉬운 관리 기법을 제공하여 관리 시간의 단축이 가능하다.
- 우편번호, 일별, 월별, 분기별 등의 데이터에 적합하다.

## 19. 옵티마이저가 비정상적인 실행계획을 수립 시 액세스 경로 및 조인 순서를 제어할 수 있도록 하기 위한 기법은?

- 힌트 또는 힌트 사용

## 20. 시스템 성능 향상과 개발 및 운영의 단순화를 위해 데이터 모델을 통합하는 데이터베이스 성능 향상 기법은?

- 반 정규화 기법

## 21. 프로시저(Procedure)란?

- 프로시저는 SQL을 이용해 생성된 데이터를 조작하는 프로그램으로 데이터베이스 내부에 저장되고 일정한 조건이 되면 자동으로 수행한다.

## 22. 정보 저장 시 해당 정보의 불필요한 세부정보를 입력해야 하는 경우 생기는 데이터베이스 이상현상은?

- 삽입 이상

이상 현상|특징
-|-
삽입 이상|정보 저장 시 해당 정보의 불필요한 세부 정보를 입력해야 하는 경우
삭제 이상|정보 삭제 시 원치 않는 다른 정보가 같이 삭제되는 경우
갱신 이상|중복 데이터 중에서 특정 부분만 수정되어 중복된 값이 모순을 일으키는 경우

## 23. 데이터 저장소 연결 절차

순서|절차|설명
-|-|-
1|드라이버 로딩|DB와 연결하기 위해 DBMS에서 제공하는 JAR 파일 드라이버를 메모리에 적재 <br> ex) oracle.jdbc.driver.OracleDriver;
2|데이터베이스 연결|해당 드라이버를 사용하여 데이터베이스를 연결<br>String url = "jdbc:oracle:thin:@localhost:1521:ORCL";<br>conn=DriverManager.getConnection(url,"scott","tiger");
3|쿼리 전달|쿼리를 DB로 전달하기 위해 Statement, PreparedStatement 객체를 생성<br> ex) pstmt = conn.prepareStatement(sql);
4|결과 수신|전달된 쿼리의 수행으로 인한 반환 값을 수신<br> ex) ResultSet rs = pstmt.executeQuery();

## 24. 데이터 저장소(테이블) 수정 쿼리

~~~query
ALTER TABLE DEPT MODIFY (DEPT_NAME VARCHAR2(20));
~~~

- 부서 데이터 저장소의 부서명 속성을 변경하는 수정 문법이다.

## 25. 물리 데이터 모델링 절차

- 개체를 테이블로 변환 → 속성을 컬럼으로 변환 → UID를 기본키로 변환 → 관계를 외래키로 변환 → 컬럼 유형과 길이 정의 → 반 정규화 수행
### 관계를 외래키로 변환하는 방법은 아래와 같다.
- 외래키 명은 기본키 이름을 그대로 사용하나 다른 의미를 가질 때 변경 가능
- 순환 관계에서 자신의 기본키는 외래키로 정의

## 26. 파티션의 장점

속성|설명
-|-
성능 향상|데이터 액세스 또는 접근 범위를 줄여 성능 향상
가용성 향상|전체 데이터의 훼손 가능성이 감소 및 데이터 가용성 향상
백업 가능|분할 영역을 독립적으로 백업하고 복구 가능
경합 감소|디스크 스트라이핑으로 입출력 성능을 향상<br>디스크 컨트롤러에 대한 경합의 감소

- 파티션의 장점 - 성가백합 (성능 향상/가용성 향상/백업 가능/경합 감소)

## 27. 메시지를 버퍼에 저장하고 버퍼로부터 메시지를 읽어오기 위한 인터페이스를 제공하는 패키지는?

- DBMS_OUTPUT 패키지

## 28. 옵티마이저의 힌트

명령어|설명
-|-
/* +RULE*/|규칙기반 접근 방식을 사용하도록 지정
/* +CHOOSE*/|오라클 옵티마이저 기본(디폴트) 값에 따름
/* +INDEX(테이블명 인덱스명)*/|지정된 인덱스롤 강제적으로 쓰게끔 지정
/* +USE_HASH(테이블명)*/|지정된 테이블들의 조인이 Hash Join 형식으로 일어나도록 유도
/* +USE_MERGE(테이블명)*/|지정된 테이블들의 조인이 Sort Merge 형식으로 일어나도록 유도
/* +USE_NL(테이블명)*/|지정된 테이블들의 조인이 Nested Loop 형식으로 일어나도록 유도

## 29. 개체-관계(E-R) 다이어그램 기호

구성|기호
-|-
개체|☐
관계|◇
속성|○
다중값 속성|◎
관계-속성 연결|-

## 30. 옵티마이저 유형

비교|규칙 기반 옵티마이저|비용 기반 옵티마이저
-|-|-
개념|통계 정보가 없는 상태에서 사전 등록된 규칙에 따라 질의 실행 계획을 선택하는 옵티마이저|통계 정보로부터 모든 접근 경로를 고려한 질의실행 계획을 선택하는 옵티마이저
핵심|우선 순위 기반|수행 시간 기반
평가기준|인덱스 구조, 연산자, 조건절 형태 등|레코드 개수, 블록 개수, 평균 행 길이, 컬럼 값의 수, 컬럼 값 문포, 인덱스 높이, 클러스터링 팩터 등