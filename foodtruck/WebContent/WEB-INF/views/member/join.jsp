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

	$(document).ready(function() {
		$("#joinForm").submit(function() {
			// 암호와 암호확인이 같아야한다..
			if ($("#password").val() != $("#confirmPassword").val()) {
				alert("암호와 암호확인은 같아야 합니다.");
				$("#password").val("");
				$("#confirmPassword").val("");
				$("#password").focus();
				return false; // submit을 무시 시킨다. 반드시 submit호출을한 함수에서 return false한다.
			}
			//   			alert($("#resCheck").text());
			if ($("#resCheck").text() == "중복된 아이디 입니다.") {
				alert("중복된 아이디 입니다. 다른 아이디를 선택하세요.");
				$("#id").focus();
				return false;
			}
		});
		$("#id").keyup(function() {
			//   			alert($(this).val());
			var data = $(this).val();
			if (data != "")
				$("#resCheck").load("checkId.do?id=" + data);
			else
				$("#resCheck").text("");
		});
	});

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
</script>
<title>회원가입</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3>회원가입</h3>
				<p>안내:회원가입을 하면 더 많은 정보와 혜택을 만날 수 있습니다.</p>
			</div>
			<div class="panel-body">
				<!--   action 속성을 생략하면 같은 uri를 호출한다. 구분하기 위해 꼭 POST방식 전송하자. -->
				<form method="post" id="joinForm">
					<div class="form-group">
						<label for="id">아이디</label> <input type="text"
							class="form-control" id="id" name="id" required="required"
							pattern="^[A-Za-z][A-Za-z0-9]{3,49}" placeholder="아이디 입력" />
						<div id="resCheck"></div>
					</div>
					<div class="form-group">
						<label for="password">암호</label> <input type="password"
							class="form-control" id="password" name="pw"
							required="required" placeholder="8자리 이상, "
							pattern="^(?=.*?[a-zA-Z]+)(?=.*?[!@#$%^*+=-]|.*?[0-9]+).{8,16}$"
							maxlength="16">
					</div>
					<div class="form-group">
						<label for="confirmPassword">암호확인</label> <input type="password"
							class="form-control" id="confirmPassword" name="comfirmPassword">
					</div>
					<div class="form-group">
						<label for="name">이름</label> <input type="text"
							class="form-control" id="name" name="name" required="required"
							pattern="[A-Za-z가-힣]{2,20}">
					</div>
					<div class="form-group">
						<label for="birthDate">생년월일 </label> <input type="date"
							class="form-control" id="birthDate" name="birthDate"
							required="required">
					</div>
					<div class="form-group">
						<label for="gender">성별</label> <input type="radio" id="gender"
							name="gender" value="남자"> 남자 <input type="radio"
							id="gender" name="gender" value="여자" checked="checked">여자
					</div>
					<div>
						<label for="mobile">휴대전화</label> <input type="tel" class="form-control"
						id="mobile" name="mobile" pattern="[0-9]{10,12}" placeholder="숫자만 입력 가능합니다."
						required="required">
					</div>
					<div class="form-group">
						<label for="email">이메일</label>
						<input type="email" class="form-control" id="email" name="email" 
						pattern="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$" 
						required="required">
					</div>
					<div>
						<label for="address">주소</label><br/>
						<input type="text" id="sample6_postcode" placeholder="우편번호">
						<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
						<input type="text" class="form-control" id="sample6_address" name="address"
						 placeholder="우편번호 찾기를 통하여 주소를 찾아보세요." required="required">상세 주소
						<input type="text" class="form-control" id="sample6_address2" name="add2"
						 placeholder="나머지 주소를 입력하세요." required="required">
					</div><br/>
					<button type="submit" class="btn btn-default" >가입</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>