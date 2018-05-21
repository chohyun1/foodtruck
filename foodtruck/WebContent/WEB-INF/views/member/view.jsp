<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<!--autoload=false 파라미터를 이용하여 자동으로 로딩되는 것을 막습니다.-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!--   데이터를 넘기기 전에 유효성검사를 시행한다. -->
<script type="text/javascript">
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('sample6_address').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('sample6_address2').focus();
        }
    }).open();
}

// 수정일을 위한 함수
   $(document).ready(function() {
   function getDate()
   {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm}
    today = yyyy+""+mm+""+dd;

    document.getElementById("todayDate").value = today;
}
getDate();
   });
   //업데이트form을 숨긴다.
   $(document).ready(function() {
      //       alert("OK");
      $("#updateInfoDiv").hide();
   });
   
   // 회원정보수정Btn을 누르면 업데이트form(show), viewInfo(hide).
   $(document).ready(function() {
      $("#goUpdateBtn").click(function() {
         $("#viewInfoDiv").toggle();
         $("#updateInfoDiv").toggle();
      });
      
      // 수정취소 버튼 click -> confirm
      $("#cancelUpdateBtn").click(function() {
         var con = confirm("수정을 취소하시겠습니까?");
         if (con) {
            $("#viewInfoDiv").toggle();
            $("#updateInfoDiv").toggle();
         } else
            return false;
   });
      // 수정하기 버튼 click -> confirm
      $("#completeUpdateBtn").click(function() {
         var con = confirm("수정하시겠습니까?");
         if(con) {
            alert("수정이 완료 되었습니다.");
            $("#completeUpdateBtn").submit();
         }
         else return false;
      });
   });


   
   
//       $("#completeUpdateBtn").click(function() {
//          var con = confirm("수정하시겠습니까?");
//          if(con){
//             return true;
//             else return false;
//          }
//       })
//    });

</script>
<script>
$(document).ready(function() {
	$("#sorry").click(function() {
		alert("공 사 중");
	});
});
</script>
</head>

<body>
   <div class="container" id="updateInfoDiv">
      <div class="page-header">
         <h2>나의 정보 수정</h2>
         <p>안내:회원 정보를 수정 할 수 있습니다.</p>
      </div>
      <div class="col-md-6 col-md-offset-3">

         <!--   <div class="panel panel-primary"> -->
      <form id="update" method="post" action="../member/update.do" >
         <input type="hidden" value="${memberDTO.id }" name="id" />   
            <div class="form-group">
               <label for="id">아이디 : </label> ${memberDTO.id }
            </div>

            <div class="form-group">
               <label for="name">이름</label> <input type="text"
                  class="form-control" id="name" name="name" required="required"
                  value="${memberDTO.name }" pattern="[A-Za-z가-힣]{2,20}">
            </div>

            <div class="form-group">
               <label for="birthDate">생년월일</label> <input type="date"
                  class="form-control" id="birthDate" name="birthDate" required="required"
                  value="${memberDTO.birthDate }" >
            </div>

            <div class="form-group">
               <label for="mobile">연락처</label> <input type="text" class="form-control"
                  id="mobile" name="mobile" value="${memberDTO.mobile }" required="required" pattern="[0-9]{10,12}">
            </div>

            <div class="form-group">
               <label for="email">이메일</label> <input type="email"
                  class="form-control" id="email" name="email"
                  value="${memberDTO.email }" />
            </div>

            <div>
				<label for="address">주소</label><br/>
				<input type="text" id="sample6_postcode" placeholder="우편번호">
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" class="form-control" id="sample6_address" name="address"
				 placeholder="우편번호 찾기를 통하여 주소를 찾아보세요." required="required" value="${memberDTO.address }">상세 주소
				<input type="text" class="form-control" id="sample6_address2" name="add2"
				 placeholder="나머지 주소를 입력하세요." required="required"value="${memberDTO.add2 }">
			</div><br/>

            

      <div class="form-group text-center">
         <div class="updateInfoBtn">
            <button type="submit" class="btn btn-info" id="completeUpdateBtn">
               수정 <i class="fa fa-check spaceLeft"></i>
            </button>
            <button type="button" class="btn" id="cancelUpdateBtn">
               돌아가기<i class="fa fa-times spaceLeft"></i>
            </button>
            
         </div>
       
         
         
      </div>
<!--      탈퇴하기 -->

</form>
<form action="">
<div class="form-group" align="right">        
          <a href="../member/changepw.do" class="btn btn-info" >
          <span class="glyphicon glyphicon-lock"  ></span> 비밀번호 변경</a>
</div>          
</form> 		
 <form id="withdraw.do" method="post" action="../member/withdraw.do" >
         <div class="form-group" align="right" >
         	 <button type="button" class="btn btn-warning"  id="sorry" >회원 탈퇴(공사중)</button>
         </div>
        
</form>
</div>
   </div>
   
   <!--   action 속성을 생략하면 같은 uri를 호출한다. 구분하기 위해 꼭 POST방식 전송하자. -->
   <div class="container" id="viewInfoDiv">
      <div class="page-header">
         <h2>My Page</h2>
         <p>안내:나의 회원 정보입니다.</p>
      </div>
      <div class="col-md-6 col-md-offset-3">

         <form method="post" id="viewInfo">
            <div class="form-group">
               <label for="id">아이디 : </label> ${memberDTO.id }
            </div>

            <div class="form-group">
               <label for="name"> 이름 : </label> ${memberDTO.name }
            </div>

            <div class="form-group">
               <label for="birth">생년월일 : </label> ${memberDTO.birthDate}
            </div>

            <div class="form-group">
               <label for="hp">연락처 : </label> ${memberDTO.mobile }
            </div>

            <div class="form-group">
               <label for="email">이메일 : </label> ${memberDTO.email }
            </div>

            <div class="form-group">
               <label for="address">주소 : </label> ${memberDTO.address }<br/>
               <label for="add2"></label> ${memberDTO.add2 }
            </div>

            

            <div class="form-group text-center">
               <button type="button" class="btn btn-info" id="goUpdateBtn">
                  회원정보 수정<i class="fa fa-check spaceLeft"></i>
               </button>
               <button type="button" class="btn"
                  onclick="history.back(-1)">
                  돌아가기<i class="fa fa-times spaceLeft"></i>
               </button>
            </div>
         </form>
      </div>
   </div>
</body>
</html>






