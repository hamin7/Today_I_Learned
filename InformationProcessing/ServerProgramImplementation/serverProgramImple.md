# 03. 서버 프로그램 구현

- DAO(Data Access Object): 특정 타입의 데이터베이스에 추상 인터페이스를 제공하는 객체로 세부내용 노출 없이 데이터 조작
- DTO(Data Transfer Object): 프로세스 사이에서 데이터를 전송하는 객체로 데이터 저장, 회수 외에 다른 기능 없음
- VO(Value Object): 간단한 엔티티를 의미하는 작은 객체 가변 클래스인 DTO와 달리 고정 클래스를 가짐

## 1. 개발환경 구축 개념

<table>
    <tr>
        <td>백엔드(Back-end)</td>
        <td>• 사용자와 만나지 않고 프론트 엔드와 연동하여 핵심 로직을 처리하는 영역<br>• DB나 인터페이스 등을 통해 시스템 구성 실체에 접근</td>
    </tr>
    <tr>
        <td>프론트엔드(Front-end)</td>
        <td>• 사용자의 화면에 나타나는 웹 화면 영역<br>• 웹 페이지를 그리는 기술(JSP, 자바스크립트, CSS, HTML, Node.js, React.js, Angular.js 등) 활용</td>
    </tr>
</table>

~~~markdown
서버 프로그램을 구현할 때 프로그램을 백엔드와 프론트엔드를 구분하여 구현한다. 대형 서비스의 경우 백엔드와 프론트엔드는 고유의 개발 영역이다.
~~~

## 2. 다음은 회원정보를 데이터베이스에 저장할 객체인 VO(Value Object)이다. 빈칸에 들어갈 문법은?

~~~java
public class JoinVO{
    String id;  // 회원 아이디
    String pw;  // 회원 비밀번호
    String name;    // 회원 이름
    public void setId(String id) {
        // 회원 아이디 설정하기
        (__________)
    }
    public void getId() {
        // 회원 아이디 가져오기
        return id;
    }
    ...
}
~~~

→ 
~~~java
this.id = id;
~~~

- 회원 아이디를 설정하는 setter 문법으로 this.id = id; 코드 형태를 작성한다.

## 3. 다음은 회원정보 데이터베이스 테이블 정의 및 생성 예시이다. 밑줄에 들어갈 문법은?

~~~sql
___1️⃣____ CUSTOMER
(
    ID VARCHAR(20) NOT NULL COMMENT '아이디',
    PW VARCHAR(20) COMMENT '패스워드',
    NAME VARCHAR(10) COMMENT '이름',
    ____2️⃣____ (PK_ID)
) COMMENT '회원정보';
~~~

1️⃣ CREATE TABLE <br>
2️⃣ PRIMARY KEY

- CREATE TABLE 문법을 통해 CUSTOMER 테이블을 생성하고, PRIMARY KEY 문법을 통해 PK_ID를 PK로 설정한다.

## 4. ORM(Object Relation Mapping) 도구 중 하나인 Mybatis란?

- 객체 지향 언어인 자바의 관계형 DB 프로그래밍을 좀 더 쉽게 할 수 있게 도와주는 개발 프레임워크이다.

## 5. 다음은 SQL을 구현한 XML id를 호출하여 조작을 수행하는 DAO(Data Access Object)의 구현 예시이다. 밑줄 안에 들어갈 문법은?

~~~jSP
public JoinDAO() {
    // 회원가입 데이터 접근 오브젝트 프로토타입
}
public int selectJoin(joinVO vo) {
    throws Exception {
        return sqlSession.selectJoin("_____", joinVO);
        // 회원가입 데이터 조회 프로토타입
    }
}

<!--호출 대상 xml-->
<mapper namespace="com.soojebi.sql">
    <!-- 회원 이름을 통해 회원 테이블 조회 -->
    <select id="selectJoin"
            parameterType="com.soojebi.vo.JoinVO"
            resultType="com.soojebi.vo.JoinVO">
                SELECT * FROM CUSTOMER
                WHERE(name=#{name})
    </select>
</mapper>
~~~

→ 
~~~jsp
com.soojebi.sql.selectJoin
~~~

- 회원가입 데이터를 조회해오는 XML id를 호출해야 하므로 참고 XML에 있는 selectJoin을 호출해야 한다. 따라서 mapper 이름을 포함해 com.soojebi.sql.selectJoin으로 표현한다.

## 6. 데이터베이스에 조회, 수정, 삭제, 입력하기 위한 객체.

<table>
    <tr>
        <td>DAO<br>(Data Access Object)</td>
        <td>특정 타입의 데이터베이스에 추상 인터페이스를 제공하는 객체로 세부내용 노출 없이 데이터 조작.</td>
    </tr>
    <tr>
        <td>DTO<br>(Data Transfer Object)</td>
        <td>프로세스 사이에서 데이터를 전송하는 객체로 데이터 저장,회수 외에 다른 기능 없음</td>
    </tr>
    <tr>
        <td>VO<br>(Value Object)</td>
        <td>간단한 엔티티를 의미하는 작은 객체 가변 클래스인 DTO와 달리 고정 클래스를 가짐</td>
    </tr>
</table>

- DAO는 DB 질의를 통해 데이터에 접근하는 객체이며, DB 접근을 하기 위한 로직과 비즈니스 로직을 분리하기 위해서 사용한다.
- VO는 DB의 한 테이블에 존재하는 칼럼들을 Java에서 객체로 다루기 위해 사용한다.

## 7. 서비스 클래스 구현 예시이다. 밑줄에 들어갈 문법은?

~~~jsp
@Service
public class JoinService implements IMemberService {
    ____1️⃣____
    JoinDao dao;

    @Override
    public void insertJoin(JoinVO join) {
        JoinVO member = dao.selectionJoin
        ____2️⃣____;
        dao.insertJoin(member);
    }
}
~~~

→ <br>
1️⃣ @Autowired<br>
2️⃣ join

- @Autowired 어노테이션은 각 상황에 맞는 컨테이너 안에 존재하는 Bean을 자동으로 주입시켜준다.
- 쉽게 설명하면 다른 곳에 있는 클래스를 편하게 끌어다 쓸 수 있는 기능이다. JoinVO로 선언된 join 객체를 통해 insertJoinDAO에 값을 넘긴다.