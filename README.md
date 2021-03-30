# SimpleLogin
JAVA로 회원가입, 로그인, 회원정보수정 만들기
언어는 html, Sevlet(JAVA), jsp를 사용했다.

**1. mainPage.html**

  이 프로젝트의 메인 페이지. 
  Welcome이라는 문구와 함께 Sing Up(회원가입), Sign In(로그인) 버튼을 제공한다.
  
**2. 회원가입**

  1. join.html
    
    메인 페이지에서 Sign Up 버튼을 누르면 접속하는 페이지
    Type your Information라는 문구와 함께
    이름, 아이디, 비밀번호, 전화번호, 성별을 입력받는다.
    Join 버튼을 누르면 JoinOk.java로 회원정보를 보낸다.
    
  2. JoinOk.java
  
    join.html에서 보낸 회원정보를 DB에 등록한다.
    회원정보 추가 작업이 수행되면, joinResult.jsp 페이지로 이동한다.
    
  3. joinResult.jsp

    Join has been done.이라는 문구와 함께 회원가입이 완료됨을 사용자에게 알리고, 
    To the Main Page라는 버튼을 누르면 1번의 메인페이지로 이동한다.
    
**3. 로그인**
  
  1. login.html

    메인 페이지에서 Sign In 버튼을 누르면 접속하는 페이지
    Enter Your Account라는 문구와 함께
    아이디, 비밀번호를 입력받고 Enter 버튼을 누르면 LoginOk.java로 로그인 정보를 보낸다.
    
  2. LoginOk.java

    DB에 접속해서 LoginOk.java에서 받은 로그인 정보로 회원을 검색한다.
    현재 세션에 이름, 아이디, 비밀번호를 등록하고 loginResult.jsp로 이동한다.
    
  3. loginResult.jsp

    현재 세션에서 이름, 아이디, 비밀번호 정보를 가져와서
    Hello, (이름)님. 이라는 문구와 함께
    Modify Account, To the Main Page 버튼을 제공한다.
    To the Main Page는 메인 페이지로 이동하고,
    Modify Account는 현재 로그인한 회원의 회원정보를 수정하기 위해 modify.jsp로 이동한다.
    
**4. 회원정보 수정**
  
  1. modify.jsp

    수정할 회원정보를 ModifyOk.java에 보낸다.
    
  2. Modify.java

    현재 세션에 로그인한 회원의 DB를 검색하고
    수정할 회원정보로 UPDATE한다.
    회원정보 수정이 실패하면 다시 Modify.java로 이동하고,
    회원정보 수정이 성공하면 modifyResult.jsp로 이동한다.

  3. modifyResult.jsp

    Modify has been done이라는 문구와 함께
    메인 페이지로 이동하는 To the Main Page 버튼을 제공한다.
