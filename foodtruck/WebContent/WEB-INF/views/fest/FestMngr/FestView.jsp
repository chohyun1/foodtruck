<%@page import="com.foodtruck.fest.FestService.FestViewService"%>
<%@page import="com.foodtruck.fest.dto.FestDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>게시판 글보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
// 	alert("OK");
	// 버튼 이벤트 처리
// 	수정 & 수정취소 버튼을 일단 숨긴다. 
	
	$("#update").click(function(){
// 		location="update.do?festno="+$("#h2_festno").text();
		$("#dataForm").attr("action","FestUpdate.do");
		$("#dataForm").submit();
	});
	$("#delete").click(function(){
		if(confirm("정말 삭제하시겠습니까?"))
			location="FestDelete.do?festno="+$("#h2_festno").text();
	});
	$("#list").click(function(){
// 		location="list.do";
		$("#dataForm input[name='festno']").attr("disabled", "disabled");
		$("#dataForm").attr("action","FestList.do"). submit();
	});
});
</script>
<link rel="stylesheet" href="../css/board.css" />

<style type="text/css">
h3 a{
font-weight: bold;
color:#6a009e;
link
} 
h4 a{
font-weight: bold;
color:#6a009e;
}
a:hover{
text-decoration: none;
background-color: none;
}
</style>

</head>
<body>
<!-- 넘어온 데이터를 저장해 놓는 form tag 작성. 모든 input tag는 속성을 hidden으로 지정한다.  -->
<form id="dataForm">
	<input type ="hidden" name="festno" value="${FestDTO.festno }" />
	<input type ="hidden" name="page" value="${param.page }"/>
	<input type ="hidden" name="rowPerPage" value="${param.rowPerPage }"/>
</form>

  <!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">행사 일정
        <small>자세히 알아보기</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="../../main/main.do"  style="color:#4a4b4c;">메인</a>
        </li>
        <li class="breadcrumb-item active">행사일정 세부내용</li>
      </ol>

      <!-- Intro Content -->
      <div class="row">
        <div class="col-lg-6">
          <img class="img-fluid rounded mb-4" src="../../../img/festival1.jpg" alt="음악축제" style="width:550px; height:330px;">
        </div>
        <div class="col-lg-6">
          <h2 id="h2_festno">${FestDTO.festno }</h2>
          <h3><a>행사명:</a> ${FestDTO.festname }</h3>
          <h4><a>행사기관:</a> ${FestDTO.festcomp }</h4>
          <h4><a>행사날짜:</a> ${FestDTO.festdate }</h4>
          <h4><a >행사지역:</a> ${FestDTO.festloc }</h4>
          <h4><a >접수날짜:</a> ${FestDTO.applydate }</h4>
          <h4><a >조회수:</a> ${FestDTO.hit }</h4>          
        </div>
      </div>
      <!-- /.row -->
      
   <hr style="border: solid #dedede; border-width: 2px 0 0;">

      <!-- Team Members -->
      <h2>관련 행사 사진</h2>

      <div class="row">
        <div class="col-lg-4 mb-4">
          <div class="card h-100 text-center">
            <img class="card-img-top" src="../../../img/music1.jpg" alt="" style="width:300px;height:200px;">
            <div class="card-body">
              <h4 class="card-title">2017-02-12 [여의도 축제]</h4>
              <p class="card-text">젊음의 열기가 쏟아졌던 여의도 현장 사진</p>
            </div>
            <div class="card-footer">
              <a href="../../error/ing.jsp">더 자세히</a>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-4">
          <div class="card h-100 text-center">
            <img class="card-img-top" src="../../../img/music2.jpg" alt="" style="width:300px;height:200px;">
            <div class="card-body">
              <h4 class="card-title">2017-05-01 [강원도 축제]</h4>
              <p class="card-text">남녀노소 모두 음악에 미쳤던 강원도 현장 사진</p>
            </div>
            <div class="card-footer">
              <a href="../../error/ing.jsp">더 자세히</a>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-4">
          <div class="card h-100 text-center">
            <img class="card-img-top" src="../../../img/music3.jpg" alt="" style="width:300px;height:200px;">
            <div class="card-body">
              <h4 class="card-title">2017-08-12 [제주도 축제]</h4>
              <p class="card-text">돌하르방과 함께 춤을 추게 만들었던 제주도 축제</p>
            </div>
            <div class="card-footer">
              <a href="../../error/ing.jsp">더 자세히</a>
            </div>
          </div>
        </div>
      </div>
      <!-- /.row -->
    </div>
    
       <hr style="border: solid #dedede; border-width: 2px 0 0;">
    
    <!-- /.container -->
    <div class="container" align="center">
		<table>
		<tfoot>
			<tr>
				<td colspan="2">
					<button id="update" class="btn btn-warning">수정</button>
					<button id="delete" class="btn btn-danger">삭제</button>
					<button id="list" class="btn btn-success">리스트</button>
				</td>
			</tr>
		</tfoot>
		</table>
	</div>
	       <hr style="border: solid white; border-width: 2px 0 0;">
	
</body>
</html>