<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//함부로 삭제 혹은 수정하는 것을 막기 위한 if
	int gradeno;
	if(session.getAttribute("gradeno")!=null){
		gradeno = (int)session.getAttribute("gradeno");
	} else{
		gradeno = 0 ;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 글보기</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
// 	alert("OK");
	$("#update").click(function(){
// 		location="update.do?no="+$("#td_no").text();
		$("#dataForm").attr("action","noticeUpdate.do");
		$("#dataForm").submit();
	});
	$("#delete").click(function(){
		if(confirm("정말 삭제하시겠습니까?"))
			location="noticeDelete.do?no="+$("#td_no").text();
	});
	$("#list").click(function(){
// 		location="list.do";
		$("#dataForm input[name='no']").attr("disabled","disabled")
		$("#dataForm").attr("action","noticeList.do");
		$("#dataForm").submit();
	});
});
</script>
</head>
<body>
<!-- 넘어온 데이터를 저장해 놓는 form tag 작성. 모든 input tag는 type 속성을 hidden -->
<form id="dataForm">
	<input type="hidden" name="no" value="${noticeDTO.no }" />
	<input type="hidden" name="page" value="${param.page }" />
	<input type="hidden" name="rowPerPage" value="${param.rowPerPage }" />
	<input type="hidden" name="searchKey" value="${param.searchKey }" />
	<input type="hidden" name="searchWord" value="${param.searchWord }" />
</form>
<div class="container">
<h1>공지사항 글보기</h1>
<table class="table">
<tbody>
<!-- 데이터를 출력한다. -->
	<tr>
		<th>번호</th>
		<td id="td_no">${noticeDTO.no}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${noticeDTO.title}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><pre>${noticeDTO.content}</pre></td>
	<tr/>
	<tr>
		<th>작성자</th>
		<td>${noticeDTO.id}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${noticeDTO.writeDate}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${noticeDTO.hit}</td>
	</tr>
</tbody>
<tfoot>
	<tr>
		<td colspan="2">
			<%if(gradeno >= 9){ %>
				<button id="update" class="btn btn-primary">수정</button>
				<button id="delete" class="btn btn-danger">삭제</button>
			<%} %>
			<button id="list" class="btn btn-success">리스트</button>
		</td>
	</tr>

</tfoot>
</table>
</div>
</body>
</html>