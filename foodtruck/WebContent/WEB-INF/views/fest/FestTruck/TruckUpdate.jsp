<%@page import="com.foodtruck.fest.dto.FestDTO"%>
<%@page import="com.foodtruck.fest.FestService.FestUpdateService"%>
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
<title>푸드트럭 정보 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
// 	alert("OK");
	// 버튼 이벤트 처리
	$("#cancel").click(function(){
		history.go(-1);
	});
	$("#reload").click(function(){
	    location = "TruckUpdate.do";
	});
});
</script>
<link rel="stylesheet" href="../css/board.css" />
</head>
<body>
<div class="container" >
<form action="TruckUpdate.do" method="post">
<input name="page" type="hidden" value="${param.page }"/>
<input name="rowPerPage" type="hidden" value="${param.rowPerPage }"/>

 <!-- Page Content -->
    <div class="container" >

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">푸드트럭 정보 수정
        <small>푸드트럭용</small>
      </h1>

      <ol class="breadcrumb" >
        <li class="breadcrumb-item">
          <a href="../../main/main.do"  style="color:#4a4b4c;">메인</a>
        </li>
        <li class="breadcrumb-item active">푸드트럭수정-푸드트럭</li>
      </ol>

      <!-- Contact Form -->
      <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
      <div class="row" >
        <div class="col-lg-8 mb-4" >
            <div class="control-group form-group" >
       		 <div class="controls" >
                <label>푸드트럭번호:</label>
                <input type="text" class="form-control" name="truckno" id="truckno" placeholder="푸드트럭번호는 수정이 불가능합니다." readonly="readonly" value="${FestTruckDTO.truckno }" />
                <p class="help-block"></p>
              </div>
            </div>
              <div class="control-group form-group" >
              <div class="controls" >
                <label>푸드트럭명:</label>
                <input type="text" class="form-control" name="truckname" id="truckname" placeholder="행사기관명을 입력하세요." readonly="readonly"  value="${FestTruckDTO.truckname }" />
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
              <div class="controls" >
                <label>국적:</label>
                    <select class="form-control" name="country" id="country" required >
					  <option class="form-control" id="country" value="한국">한국</option>
					  <option class="form-control" id="country" value="미국">미국</option>
					  <option class="form-control" id="country" value="동남아">동남아</option>
					  <option class="form-control" id="country" value="일본">일본</option>
					  <option class="form-control" id="country" value="중국">중국</option>
					  <option class="form-control" id="country" value="유럽">유럽</option>
					  <option class="form-control" id="country" value="아프리카">아프리카</option>
					  <option class="form-control" id="country" value="러시아">러시아</option>
					  <option class="form-control" id="country" value="북한">북한</option>
					  <option class="form-control" id="country" value="기타">기타</option>
				</select><br/>
					<input type="text" class="form-control" name="country" id="country" placeholder="기타 국적을 입력하세요."  />
				</div>
            </div>
              <div class="control-group form-group" >
              <div class="controls" >
                <label>메뉴:</label>
            	 <select class="form-control" name="maindish" id="maindish" required >
					  <option class="form-control" id="maindish" value="비빔밥">비빔밥</option>
					  <option class="form-control" id="maindish" value="햄버거">햄버거</option>
					  <option class="form-control" id="maindish" value="핫도그">핫도글</option>
					  <option class="form-control" id="maindish" value="와플">와플</option>
					  <option class="form-control" id="maindish" value="나쵸">나쵸</option>
					  <option class="form-control" id="maindish" value="디저트">커피</option>
					  <option class="form-control" id="maindish" value="기타">기타</option>
				</select><br/>              
					<input type="text" class="form-control" name="maindish" id="maindish" placeholder="기타 메뉴를 입력하세요."  />
				</div>
            </div>
             <div class="control-group form-group" >
              <div class="controls">
              	 <label>예상인원: (명)</label>
	               <input type="number" class="form-control" name="predppl" id="predppl" placeholder="인원수를 입력하세요." required />
				</div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>신청 가능인원: (명)</label>
	               <input type="number" class="form-control" name="applyppl" id="applyppl" placeholder="인원수를 입력하세요." required />
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>준비된 판매량: (인분)</label>
   	               <input type="number" class="form-control" name="readyfood" id="readyfood" placeholder="판매량을 입력하세요." required />
              </div>
            </div>
         	 
         	     <hr style="border: solid #dedede; border-width: 2px 0 0;">
            
              <div class="control-group form-group" >
              <div class="controls" >
                <label>현장담당자 이름:</label>
                <input type="text" class="form-control" name="mngrname" id="mngrname" placeholder="현장담당자 이름을 입력하세요." required />
                <p class="help-block"></p>
              </div>
            </div>
            <div class="control-group form-group" >
              <div class="controls" >
                <label>현장담당자 연락처: (010-xxxx-xxxx)</label>
                <input type="text" class="form-control" name="mngrtel" id="mngrtel" placeholder="현장담당자 연락처를 입력하세요." required />
              </div>
            </div>
        </div>
        </div>

      <!-- /.row -->
	      <hr style="border: solid #dedede; border-width: 2px 0 0;">
    
    <!-- /.container -->
    <div class="container" align="left">
		<table>
			<tfoot>
				<tr>
					<td colspan="2">
							<button class="btn btn-success">수정</button>
							<button type="reset" class="btn btn-warning">새로고침</button>
							<button type="button" id="cancel" class="btn btn-danger">취소</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	       <hr style="border: solid white; border-width: 2px 0 0;">
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