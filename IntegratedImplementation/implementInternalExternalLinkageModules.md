# 03. 내외부 연계 모듈 구현

## 1. 연계 요구사항 분석 참고문서 분석

- 개발하고자 하는 응용 소프트웨어와 연계 모듈 간의 세부 설계서를 확인하여 일관되고 정형화된 연계 기능을 구현할 수 있다.
- 연계 모듈 기능 구현은 주로 EAI/ESB 방식과 웹 서비스 방식으로 구분된다.

## 2. 연계 모듈 기능 구현 방법 중 EAI 방식이란?

- 기업에서 운영되는 서로 다른 플랫폼 및 애플리케이션들 간의 정보 전달, 연계, 통합을 가능하게 해주는 솔루현이다.

## 3. 연계 모듈 구현 방법 중 웹서비스 방식이란?

- 네트워크에 분산된 정보를 서비스 형태로 개방하여 표준화된 방식으로 공유하는 기술로써 서비스 지향 아키텍처 개념을 실현하는 대표적인 기술이다.

## 4. 다음은 어떤 연계 방식인가?

- 기업에서 운영되는 서로 다른 플랫폼 및 애플리케이션들 간을 하나의 시스템으로 관리 운영할 수 있도록 서비스 중심의 통합을 지향하는 아키텍처 또는 기술이다.
- 버스를 중심으로 각각 프로토콜이 호환이 가능하도록 애플리케이션의 통합을 느슨한 결합방식으로 지원하는 방식이다.

→ ESB(Enterprise Service Bus) 방식

## 5. 트리거로 구현한 송신 시스템의 연계 응용 프로그램

~~~SQL
CREATE OR REPLACE TRIGGER 트리거명
AFTER INSERT OR UPDATE OR DELETE ON 테이블명
FOR EACH ROW
DECLARE AFTER_CODE VARCHAR2(5);
BEGIN
IF INSERTING THEN
SELECT [변환 후 코드 값]
INTO AFTER_CODE
FROM [코드 매핑 테이블]
WHERE [변환 전 코드 값] = :new.[코드1컬럼]
~~~

## 6. 트리거로 구현한 송신 시스템의 연계 응용 프로그램 일부

사례|설명
-|-
ELSE|데이터가 수정 된 경우
IF UPDATING('[코드1 컬럼]') OR UPDATUNG('[코드2 컬럼]')<br> THEN (...)<br>ELSIF UPDATING('[텍스트컬럼]') THEN(...)<br>ELSIF UPDATING THEN (...)<br>END IF;<br>END IF;|- 연계 데이터 중 코드 컬럼이 변경된 경우<br>- 연계 데이터 중 텍스트 컬럼이 변경된 경우<br>- 연계 데이터가 아닌 컬럼이 변경된 경우
EXCEPTION<br>WHEN NO_DATA_FOUND THEN<br>(...)<br>WHEN DUP_VAL_ON_INDEX THEN<br>(...)|- 오류 처리<br>- 등록된 코드에 매핑 코드가 없을 경우<br>- 테이블 등록 시 동일 PK 데이터 존재
END;| - 트리거 종료

## 7. SOAP 방식의 파일 전송 및 서비스 호출 처리 구현

구분|HTTP 요청 SOAP 메시지
-|-
Header|<SOAP_ENV:Envelope><br>xmlns:SOAP-ENV="http://schemas.<br>xmlsoap.org/soap/envelope/"SOAP-<br>ENV:encodingStyle="http://schemas.<br>xmlsoap.org/soap/encoding/"><br><soap:Header><br>(...)<br></soap:Header>
Body|<SOAP-ENV:Body><br><m:NoteSrch xmlns:m=""><br><NoteNo>202001011</NoteNo><br><m:NoteSrch><br></SOAP-ENV:Body><br></SOAP-ENV:Body>

- <Header>는 SOAP Envelope의 선택적 하위 요소이며 메시지 경로를 따라 SOAP 노드로만 처리될 애플리케이션 관련 정보를 전달하는 데 사용된다.
- <Envelope>는 모든 SOAP 메시지의 루트 요소이며 두 개의 하위 요소인 선택적 <Header> 요소 및 필수 <Body> 요소를 포함한다.
- <Body>는 SOAP Envelope의 필수 하위 요소이며 메시지의 최종 수신인을 대상아로 하는 정보를 포함한다.