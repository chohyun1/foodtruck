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
<title>행사 일정 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
// 	alert("OK");
	// 버튼 이벤트 처리
	$("#cancel").click(function(){
		history.back();
	});
	$("#reload").click(function(){
	    location = "FestWrite.do";
	});
});
</script>
<link rel="stylesheet" href="../css/board.css" />
</head>
<body>
<div class="container" >
<form action="FestWrite.do" method="post">

 <!-- Page Content -->
    <div class="container" >

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">행사일정 등록
        <small>관리자용</small>
      </h1>

      <ol class="breadcrumb" >
        <li class="breadcrumb-item">
          <a href="../../main/main.do"  style="color:#4a4b4c;">메인</a>
        </li>
        <li class="breadcrumb-item active">행사일정등록-관리자</li>
      </ol>

      <!-- Contact Form -->
      <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
      <div class="row" >
        <div class="col-lg-8 mb-4" >
            <div class="control-group form-group" >
              <div class="controls" >
                <label>행사기관:</label>
                <input type="text" class="form-control" name="festcomp" id="festcomp" placeholder="행사기관명을 입력하세요." required />
                <p class="help-block"></p>
              </div>
            </div>
            <div class="control-group form-group" >
              <div class="controls" >
                <label>행사명:</label>
                <input type="text" class="form-control" name="festname" id="festname" placeholder="행사명을 입력하세요." required />
                <p class="help-block"></p>
              </div>
            </div>
            <div class="control-group form-group" >
              <div class="controls" >
                <label>행사날짜:</label>
                <input type="date" class="form-control" name="festdate" id="festdate" required />
                <p class="help-block"></p>
              </div>
            </div>
            <div class="control-group form-group" >
              <div class="controls" >
                <label>행사지역:</label>
                <input type="text" class="form-control" name="festloc" id="festloc" placeholder="지역명을 입력하세요." required />
                <p class="help-block"></p>
              </div>
            </div>
            <div class="control-group form-group" >
              <div class="controls" >
                <label>행사시간:</label>
                <input type="time" class="form-control" name="festtime" id="festtime" required />
                <p class="help-block"></p>
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
        </div>

      </div>

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