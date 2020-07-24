# 현행 시스템 분석

## 01. 현행 시스템 파악
어떤 하위 시스템으로 구성되어 있고, 제공 기능 및 연계 정보는 무엇이며 어떤 기술요소를 사용하는지를 파악하는 활동.

## 02. 현행 시스템 파악 절차
### 구성/기능/인터페이스 파악
- 시스템 구성 현황 파악
- 시스템 기능 파악
- 시스템 인터페이스 현황 파악

### 아키텍쳐 및 소프트웨어 구성 파악
- 아키텍쳐 파악
- 소프트웨어 구성 파악

### 하드웨어 및 네트워크 구성 파악
- 시스템 하드웨어 현황 파악
- 네트워크 구성 파악

## 03. 현행 시스템 파악 절차 중 인터페이스 파악
정의|단위 업무 시스템이 다른 업무 시스템과 주고 받는 데이터의 종류, 데이터 형식, 프로토콜, 연계 유형, 주기 등을 명시한 현황
-|-
작성 시 고려 사항|데이터를 주고받는 데이터 형식(XML, 고정/가변), 연계 유형 (EAI 등), 통신 규약 (TCP/IP, X25 등)이 무엇인지 표시

## 04. 현행 시스템 파악 절차 중 소프트웨어 구성도 파악

- 단위 업무 시스템의 업무 처리를 위해 설치되어 있는 소프트웨어들의 제품명, 용도, 라이선스 적용 방식, 라이선스 수를 명시한 것.

구분 | 시스템명 | SW 제품명 | 용도 | 라이선스 적용 방식 | 라이선스 수
-|-|-|-|-|-
기간 업무|단위 업무 M 시스템|Apache Tomcat|WAS|오픈 소스 Apache License|
"|"|MySQL|데이터 베이스|GPL 또는 상용|

- 소프트웨어 구성 파악 시 가장 중요한 사항은 라이선스에 대한 파악이다.

## 05. 소프트웨어 아키텍처 개념
- 여러가지 소프트웨어 구성요소와 그 구성요소가 가진 특성 중에서 외부에 드러나는 특성. 그리고 구성 요소간의 관계를 표현하는 시스템의 구조이다.

## 06. 소프트웨어 아키텍처 프레임워크 구성요소.

구성요소 | 설명
-|-
아키텍처 명세서| - 아키텍처를 기록하기 위한 산출물들. <br> - 이해 관계자들의 시스템에 대한 관심을 관점에 맞추어 작성한 뷰로 표현. <br> - 개별 뷰, 뷰 개괄 문서, 인터페이스 명세 등이 있음.
이해관계자|- 시스템 개발에 관련된 모든 사람과 조직. <br> - 고객, 최종 사용자, 개발자, 프로젝트 관리자. 유지보수자, 마케팅 담당자 등을 포함.
관심사|시스템에 대해 이해관계자들의 서로 다른 의견과 목표<br> - 사용자 입장 : 기본적인 기능, 신뢰성, 보안, 사용성 등의 품질<br>- 유지 보수자 입장 : 유지 보수의 용이성 <br>- 개발자 입장 : 적은 비용과 인력으로 개발
관점 | - 개별 뷰를 개발할 때 토대가 되는 패턴이나 양식<br>- 이해 관계자들이 서로 다른 역할이나 책임으로 시스템이나 산출물들에 대해 보고 싶은 관점
뷰|- 서로 관련 있는 관심사들의 집합이라는 관점에서 전체 시스템을 표현 <br>- 시스템에 대한 아키텍처 설명에는 하나 이상의 뷰로 구성
근거|- 아키텍처 결정 근거<br>- 회의 결과, 보고 결과

## 07. 소프트웨어 아키텍처 4+1 뷰
뷰|설명
-|-
유즈케이스 뷰|- 아키텍처를 도출하고 설계하는 작업을 주도하는 뷰<br>- 다른 뷰를 검증하는 데 사용.
논리 뷰|- 설계 모델의 추상화이며, 주요 설계 패키지와 서브 시스템, 클래스를 식별하는 뷰<br>- 시스템의 기능적인 요구사항 지원<br>- 클래스와 이들 간 관계에 대한 집합을 보여주는 클래스 다이어그램으로 표현
프로세스 뷰|- 런타임 시의 시스템의 태스크, 스레드, 프로세스와 이들 사이의 상호작용 등의 관계를 표현하는 뷰<br>- 성능이나 가용성과 같은 시스템의 비기능적인 요구사항을 고려
구현 뷰|- 개발 환경 안에서 정적인 소프트웨어 모듈(소스 코드, 데이터 파일, 컴포넌트, 실행 파일 등)의 구성을 표현하는 뷰<br>- 개발자 관점에서 소프트웨어의 구현과 관리적인 측면을 컴포넌트 다이어그램으로 표현<br>- 컴포넌트 뷰라고도 함
배포 뷰|- 물리적인 노드의 구성과 상호 연결 관계를 배포 다이어그램으로 표현하는 뷰<br>- 다양한 실행 파일과 다른 런타임 컴포넌트가 해당 플랫폼 또는 컴퓨팅 노드에 어떻게 매핑되는가를 보여주며, 가용성, 신뢰성, 성능, 확장성 등의 시스템의 비기능적인 요구사항을 고려

소프트웨어 아키텍처 4+1 뷰|유논프구배
-|-

## 08. 현행 시스템 분석서 작성 및 검토 절차
1단계 : 현행 시스템 관련 자료 수집 단계<br>
2단계 : 자료 분석 단계<br>
3단계 : 산출물 작성 단계<br>
4단계 : 산출물에 대한 검토 수행 단계

## 09. 요구사항 확인을 위한 현행 시스템 분석 시 현행 시스템 아키텍처 구성 자료에 대한 분석 대상 2가지
→ 현행 시스템 아키텍처 구성 자료에서는 운영체제의 종류 (윈도우즈, 유닉스, 리눅스 등), 적용 프레임 워크, 계층별 적용 기술 (공통 기반 계층/화면 처리 계층/업무 처리 계층 등의 적용 기술), 데이터 연동 방식, 데이터 저장소 종류 및 위치, 외부 시스템과의 연계 방식 등이 분석 대상이다.

## 10. 아래의 분석 대상 자료는 어떤 취득 자료를 기반으로 도출해낸 것인가?
- 송,수신 시스템
- 연계 방식 및 연계 주기
- 연동 데이터 형식
- 주요 연동 데이터-산출물에 대한 검토 수행 단계

→ 인터페이스 현황

## 11. 현행 시스템 분석 결과를 기반으로 작성하는 산출물의 종류
→ 분석 산출물의 종류
현기인 아소하네|정보시스템 구성 현황/정보시스템 기능 구성도/인터페이스 현황/현행 시스템 아키텍처 구성도/소프트웨어 구성도/하드웨어 구성도/네트워크 구성도
-|-

## 12. 운영체제 현행 분석 시 성능측면의 고려 사항
→ 대규모 및 대량 파일 작업(Batch Job) 처리 가능 여부와 지원 가능한 메모리 크기(32bit, 64bit) 등의 성능을 고려해야 한다.

<table>
    <body>
        <tr>
            <td rowspan=2>품질 <br>측면</td><td>신뢰도</td><td>- 장기간 시스템 운영 시 운영체제의 장애 발생 가능성<br>- 운영체제의 버그로 인한 재 기동 여부
        </tr>
        <tr>
            <td>성능</td><td>- 대규모 및 대량 파일 작업(Batch job) 처리<br>- 지원 가능한 메모리 크기 (32비트, 64비트)
        </tr>
        <tr>
            <td rowspan=3>지원<br>측면</td><td>기술지원</td><td>- 공급사들의 안정적인 기술 지원<br>- 오픈 소스 여부</td>
        </tr>
        <tr>
            <td>주변기기</td><td>- 설치 가능한 하드웨어<br>- 다수의 주변 기기 지원 여부
        </tr>
        <tr>
            <td>구축비용</td><td>- 지원 가능한 하드웨어 비용<br>- 설치할 응용 프로그램의 라이선스 정책 및 비용<br>- 유지 및 관리 비용
        </tr>
    </body>
</table>

## 13. OSI 7계층
<table>
    <head>
        <tr>
            <td>계층</td><td>설명</td><td>프로토콜</td><td>전송단위</td>
        </tr>
    </head>
    <body>
        <tr>
            <td>응용<br>계층</td><td>- 사용자와 네트워크 간 응용서비스 연결, 데이터 생성</td><td>HTTP, FTP</td><td rowspan=3>데이터<br>(Data)</td>
        </tr>
        <tr>
            <td>표현<br>계층</td><td>- 데이터 형식 설정과 부호 교환, 암/복호화</td><td>JPEG, MPEG</td>
        </tr>
        <tr>
            <td>세션<br>계층</td><td>- 연결 접속 및 동기 제어</td><td>SSH, TLS</td>
        </tr>
        <tr>
            <td>전송<br>계층</td><td>- 신뢰성 있는 통신 보장<br>- 데이터 분할과 재조립, 흐름 제어, 오류 제어 등을 담당<br>- 오류제어, 혼잡제어 등</td><td>TCP, UDP</td><td>세그먼트<br>(Segment)</td>
        </tr>
        <tr>
            <td>네트워크<br>계층</td><td>- 단말 간 데이터 전송을 위한 최적화된 경로 제공</td><td>IP, ICMP</td><td>패킷<br>(Packet)</td>
        </tr>
        <tr>
            <td>데이터<br> 링크<br>(Data Link)</td><td>- 인접 시스템 간 데이터 전송, 전송 오류 제어<br>- 동기화, 오류 제어, 흐름 제어 등의 전송 에러를 제어<br>- 오류 검출 / 재전송 등</td><td>이더넷</td><td>프레임<br>(Frame)</td>
        </tr>
        <tr>
            <td>물리<br>계층</td><td>- 0과 1의 비트 정보를 회선에 보내기 위한 전기적 신호 변환</td><td>RS-232C</td><td>바트(Bit)</td>
        </tr>
    </body>
</table>

## 14. CPU 용량 산정 계산식

종류|산정식
-|-
OLTP/배치/데이터베이스 서버|CPU(tpmC 단위) = (분당 트랜잭션 수) * (기본 tpmC 보정) * (peak time 부하 보정) * (DB 크기 보정) * (앱 구조 보정) * (앱 부하 보정) * (클러스터 보정) * (시스템 여유율) / (시스템 목표 활용률)
WEB/WAS 서버| CPU(OPS 단위) = (동시 사용자 수) * (사용자당 operation 수) * (기본 OPS 보정) * (인터페이스 부하 보정) * (peak time 부하 보정) * (클러스터 보정) * (시스템 여유율) / (시스템 목표 활용률)
