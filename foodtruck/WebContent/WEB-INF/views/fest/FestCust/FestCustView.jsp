<%@page import="com.foodtruck.fest.CustService.FestCustViewService"%>
<%@page import="com.foodtruck.fest.dto.FestCustDTO"%>
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

	$("#update").click(function(){
// 		location="update.do?no="+$("#td_no").text();
		$("#dataForm").attr("action","CustUpdate.do");
		$("#dataForm").submit();
	});
	$("#delete").click(function(){
		if(confirm("정말 삭제하시겠습니까?"))
			location="CustDelete.do?custno="+$("#td_custno").text();
	});
	$("#list").click(function(){
// 		location="list.do";
		$("#dataForm input[name='custno']").attr("disabled", "disabled");
		$("#dataForm").attr("action","FestCustList.do"). submit();
	});
});
</script>
<link rel="stylesheet" href="../css/board.css" />
</head>
<body>
<!-- 넘어온 데이터를 저장해 놓는 form tag 작성. 모든 input tag는 속성을 hidden으로 지정한다.  -->
<form id="dataForm">
	<input type ="hidden" name="custno" value="${FestCustDTO.custno }" />
	<input type ="hidden" name="page" value="${param.page }"/>
	<input type ="hidden" name="rowPerPage" value="${param.rowPerPage }"/>
</form>
<div class="container">
	<h1 class="mt-4 mb-3">소비자 신청서  
	        <small>글보기 화면</small>
	      </h1>
	
	      <ol class="breadcrumb">
	        <li class="breadcrumb-item">
	          <a href="../../main/main.do"  style="color:#4a4b4c;">메인</a>
	        </li>
	        <li class="breadcrumb-item active">소비자 신청서 글보기</li>
	      </ol>
<table class="table">
<tbody>
<!-- 데이터를 출력한다. -->
	<tr>
		<th>소비자 번호</th>
		<td id="td_custno">${FestCustDTO.custno}</td>
	</tr>
	<tr>
		<th>행사정보</th>
		<td>${FestCustDTO.festjoin}</td>
	</tr>
	<tr>
		<th>푸드트럭정보</th>
		<td>${FestCustDTO.truckjoin}</td>
	</tr>
	<tr>
		<th>신청자 이름</th>
		<td>${FestCustDTO.applyname}</td>
	</tr>
	<tr>
		<th>신청자 연락처</th>
		<td>${FestCustDTO.applytel}</td>
	</tr>
	<tr>
		<th>신청 인원</th>
		<td>${FestCustDTO.applyno} 명</td>
	</tr>
	<tr>
		<th>신청 지역</th>
		<td>${FestCustDTO.applyloc}</td>
	</tr>
	<tr>
		<th>참여 시간</th>
		<td>${FestCustDTO.applytime}</td>
	</tr>
	<tr>
		<th>접수 날짜</th>
		<td>${FestCustDTO.applydate}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${FestCustDTO.hit}</td>
	</tr>
</tbody>
</table>

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
	    
</div>
</body>
</html>