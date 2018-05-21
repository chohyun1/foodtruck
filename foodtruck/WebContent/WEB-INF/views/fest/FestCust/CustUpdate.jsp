<%@page import="com.foodtruck.fest.dto.FestCustDTO" %>
<%@page import="com.foodtruck.fest.CustService.CustUpdateService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>소비자 행사 신청서</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
// 	alert("OK");
	// 버튼 이벤트 처리
	$("#cancel").click(function(){
		history.go(-1);
	});
	$("#reload").click(function(){
	    location = "CustWrite.do";
	});
});
</script>
<link rel="stylesheet" href="../css/board.css" />
</head>
<body>
<div class="container" >
<form action="CustUpdate.do" method="post">
<input name="page" type="hidden" value="${param.page }"/>
<input name="rowPerPage" type="hidden" value="${param.rowPerPage }"/>
 <!-- Page Content -->
    <div class="container" >

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">소비자 신청서 수정
        <small>소비자용</small>
      </h1>

      <ol class="breadcrumb" >
        <li class="breadcrumb-item">
          <a href="../../main/main.do"  style="color:#4a4b4c;">메인</a>
        </li>
        <li class="breadcrumb-item active">행사신청서수정-소비자</li>
      </ol>
      
      <div class="row" >
        <div class="col-lg-8 mb-4" >
        <div class="control-group form-group" >
       		 <div class="controls" >
                <label>소비자번호:</label>
                <input type="text" class="form-control" name="custno" id="custno" placeholder="소비자신청번호는 수정이 불가능합니다." readonly="readonly" value="${FestCustDTO.custno }" />
                <p class="help-block"></p>
              </div>
            </div>            
          <div class="control-group form-group" >
              <div class="controls" >
              	 <label>행사 정보:</label>
	              <select class="form-control" name="festjoin" id="festjoin" required >
					  <option class="form-control" id="festjoin" value="올림픽,뮤직 페스티벌 ,2018-05-05">올림픽,뮤직 페스티벌 ,2018-05-05</option>
					  <option class="form-control" id="festjoin" value="잠실나루, 불꽃축제, 2018-05-08">잠실나루, 불꽃축제, 2018-05-08</option>
					  <option class="form-control" id="festjoin" value="에버랜드, 장미축제, 2018-05-20">에버랜드, 장미축제, 2018-05-20</option>
				</select>
				</div>
            </div>
         <div class="control-group form-group" >
              <div class="controls">
              	 <label>푸드트럭 정보:</label>
	              <select class="form-control" name="truckjoin" id="truckjoin" required>
	              		<option class="form-control" id="truckjoin" value="버버푸드트럭,햄버거">버버푸드트럭,햄버거</option>
					  <option class="form-control" id="truckjoin" value="신나쵸, 나쵸">신나쵸, 나쵸</option>
					  <option class="form-control" id="truckjoin" value="너와나플, 와플">너와나플, 와플</option>
				</select>
				</div>
            </div>
        </div>
      </div>
      
      	        <hr style="border: solid #dedede; border-width: 2px 0 0;">

      <!-- Contact Form -->
      <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
      <div class="row" >
        <div class="col-lg-8 mb-4" >
            <div class="control-group form-group" >
              <div class="controls" >
                <label>이름:</label>
                <input type="text" class="form-control" name="applyname" id="applyname" placeholder="이름을 입력하세요." required />
                <p class="help-block"></p>
              </div>
            </div>
            <div class="control-group form-group" >
              <div class="controls" >
                <label>연락처:  (010-xxxx-xxxx)</label>
                <input type="text" class="form-control" name="applytel" id="applytel" placeholder="연락처를 입력하세요." required />
              </div>
            </div>
            <div class="control-group form-group" >
              <div class="controls" >
                <label>동반인원: (명)</label>
                <input type="number" class="form-control" name="applyno" id="applyno" placeholder="인원수를 입력하세요." required />
              </div>
            </div>
            <div class="control-group form-group" >
              <div class="controls" >
                <label>거주 지역</label>
                    <select class="form-control" name="applyloc" id="applyloc" required >
					  <option class="form-control" id="applyloc" value="서울/경기">서울/경기</option>
					  <option class="form-control" id="applyloc" value="강원도">강원도</option>
					  <option class="form-control" id="applyloc" value="충청북도">충청북도</option>
					  <option class="form-control" id="applyloc" value="충청남도">충청남도</option>
					  <option class="form-control" id="applyloc" value="경상북도">경상북도</option>
					  <option class="form-control" id="applyloc" value="경상남도">경상남도</option>
					  <option class="form-control" id="applyloc" value="전라북도">전라북도</option>
					  <option class="form-control" id="applyloc" value="전라남도">전라남도</option>
					  <option class="form-control" id="applyloc" value="제주">제주</option>
					  <option class="form-control" id="applyloc" value="기타">기타</option>
				</select><br/>
					<input type="text" class="form-control" name="applyloc" id="applyloc" placeholder="기타 거주지역을 입력하세요."  />
				</div>             
            </div>
            <div class="control-group form-group" >
                <div class="controls" >
                <label>참여시간:</label>
                <input type="time" class="form-control" name="applytime" id="applytime" required />
                <p class="help-block"></p>
              </div>
            </div>
        </div>

      </div>
      	      <hr style="border: solid #dedede; border-width: 2px 0 0;">
    
    <!-- /.container -->
    <div class="container" align="left">
		<table>
		<tfoot>
			<tr>
				<td colspan="2">
						<button class="btn btn-success">등록</button>
						<button type="reset" class="btn btn-warning">새로고침</button>
						<button type="button" id="cancel" class="btn btn-danger">취소</button>
				</td>
			</tr>
		</tfoot>
		</table>
	</div>
	       <hr style="border: solid white; border-width: 2px 0 0;">

      <!-- /.row -->
	</div>
    </form>
    </div>
 
    <!-- /.container -->

    <!-- Bootstrap core JavaScript -->
    <script src="../../../vendor/jquery/jquery.min.js"></script>
    <script src="../../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Contact form JavaScript -->
    <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
    <script src="../../../js/jqBootstrapValidation.js"></script>
    <script src="../../../js/contact_me.js"></script>

</body>
</html>