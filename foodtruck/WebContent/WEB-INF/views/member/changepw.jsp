<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <script type="text/javascript">


         // 새 암호와 새암호 확인이 같아야한다.
$(document).ready(function(){
        $("#change").click(function(){
           if($("#newpw").val() != $("#confirmNewpw").val()){
              alert("새암호와 새암호확인은 같아야 합니다.");
              $("#pw").val("");
              $("#newpw").val("");
              $("#confirmNewpw").val("");
              $("#pw").focus();
              return false; // submit을 무시 시킨다. 반드시 submit 호출을한 함수에서 return false한다.
           }
           
         // db 비밀번호와 일치하는 지 확인한다.
           $.get("checkpw.do",{ pw: $("#pw").val()})
         .done(function(data) {
            alert(data);
            if(data==1){
               $("#checkPwd").html("1");
               if(confirm("비밀번호를 변경하시겠습니까?")){
                  $("#changePwForm").attr("action","changepw.do");
                    $("#changePwForm").submit();
                    alert("변경되었습니다. 마이페이지로 이동합니다.");
                    return true;
               }               
            }
            else{   
               alert("비밀번호가 틀립니다. 확인 후 다시 시도하세요.");
               $("#pw").val("");   
               $("#pw").focus();
            }
            
         });
            
        });
});
           
 
     </script>
<script>
$(document).ready(function() {
	$("#sorry").click(function() {
		alert("공 사 중");
	});
});
</script>

<title>비밀번호 변경</title>
</head>
<body>
<div class="container">
   <div class="col-md-6 col-md-offset-3">

   <div class="page-header">
      <h2>비밀번호 변경</h2>
      <p>보안을 위하여 3개월마다 비밀번호를 변경해주세요.</p>
      <p>공사중입니다.</p>
   </div>
   
     <form method="post" id="changePwdForm">
      <div class="form-group">
       <label for="pw">현재 비밀번호</label>
       <input type="password" class="form-control" id="pw" name="pw" required="required" placeholder="현재 비밀번호" />
       </div>
       <div id="checkPwd"></div>
       
        <div class="form-group">
       <label for="pw">새 비밀번호</label>
       
       <input type="password" class="form-control" id="newpw" name="newpw" required="required" placeholder="새 비밀번호" />
       </div>
       
        <div class="form-group">
       <label for="pw">새비밀번호 확인</label>
       <input type="password" class="form-control" id="confirmNewpw" name="confirmNewpw" required="required" placeholder="새 비밀번호 확인" />
       </div>
      
        <div class="form-group text-center">
         	 <button type="button" class="btn btn-warning"  id="sorry" >비밀번호 변경(공사중)</button>
<!--               <button type="button" class="btn btn-info" id="change">변경<i class="fa fa-check spaceLeft"></i></button> -->
              <button type="button" class="btn" onclick="history.back(-1)" >취소<i class="fa fa-times spaceLeft"></i></button>
            </div>
       
    </form>
    </div>
 </div>
</body>
</html>