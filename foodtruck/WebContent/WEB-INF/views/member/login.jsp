<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <div class="panel panel-primary">
   <div class="panel-heading">
     <h3>로그인</h3>
     <c:if test="${!empty reqURI }">
        <p style="color:red">요청하신 자원은 Login이 필요합니다.</p>
     </c:if>
    </div>
    <div class="panel-body">
   <!--   action 속성을 생략하면 같은 uri를 호출한다. 구분하기 위해 꼭 POST방식 전송하자. -->
     <form method="post" id="loginForm">
       <div class="form-group">
         <label for="id">아이디</label>
         <input type="text" class="form-control" id="id" name="id" required="required"
         pattern="^[A-Za-z][A-Za-z0-9]{3,49}" placeholder="아이디 입력" />
       </div>
       <div class="form-group">
         <label for="pw">암호</label>
         <input type="password" class="form-control" id="pw" name="pw"
         required="required" pattern=".{8,16}" maxlength="16">
       </div>
       <button type="submit" class="btn btn-default">로그인</button>
     </form>
    </div>
   </div>
</div>

</body>
</html>