<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int gradeno;
	if(session.getAttribute("gradeno") != null){
		gradeno = (int)session.getAttribute("gradeno");
	} else{
		gradeno = 0;
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 리스트</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
// 	alert("OK");
    $(".data").click(function(){
//         $(this).hide();
        var no = $(this).find("td:first").text();
// 		alert("click");
// 		alert(no);
		location = "noticeView.do?no="+no
				+"&page=${pageObject.page}"
				+'&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}'
				+'&searchKey=${param.searchKey}&searchWord=${param.searchWord}';
    });
    $("#write").click(function(){
    	location = "noticeWrite.do";
    });
});
</script>
<link rel="stylesheet" href="../css/board.css" />
<style type="text/css">
.table{
	width: 65%;
	margin: 0 auto;
}
</style>
</head>
<body>
<div class="container">
<!-- <div class="panel_group"> -->
<!-- <div class="panel panel-primary"> -->
<!-- <div class="panel-heading"> -->
<h3>공지사항 리스트</h3>
<form class="navbar-form" action="/action_page.php">
	<input name="page" value="1" type="hidden" />
	<input name="rowPerPage" value='${(empty param.rowPerPage)?"10":param.rowPerPage}' type="hidden" />
  <div class="form-group navbar-left">
  	<select class="form-control navbar-left list-group" name="searchKey" >
  		<option value="title" ${(param.searchKey == "title")?"selected=\"selected\"":"" } 
  		>제목</option>
  		<option value="content"  ${(param.searchKey == "content")?"selected=\"selected\"":"" }
  		>내용</option>
  		<option value="id" ${(param.searchKey =="id")?"selected=\"selected\"":""}
  		>작성자</option>
  		<option value="title,content" ${(param.searchKey =="title,content")?"selected=\"selected\"":""} 
  		>제목/내용</option>
  		<option value="title,id" ${(param.searchKey =="title,id")?"selected=\"selected\"":""} 
  		>제목/작성자</option>
  		<option value="content,id" ${(param.searchKey =="content,id")?"selected=\"selected\"":""} 
  		>내용/작성자</option>
  		<option value="title,content,id" ${(param.searchKey =="title,content,id")?"selected=\"selected\"":""} 
  		>제목/내용/작성자</option>
  	</select>
    <input type="text" class="form-control navbar-left"  placeholder="Search"
     name="searchWord" value="${param.searchWord }">
    <div class="input-group-btn">
      <button class="btn btn-default" type="submit">
        <i class="glyphicon glyphicon-search"></i>
      </button>
    </div> 
  </div>
</form> 
</div>
<table class="table">
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
</thead>
<tbody>
<!-- 데이터를 출력하는 반복 처리 -->
<c:forEach items="${list }" var="noticeDTO">
	<tr class="data">
		<!-- boardDTO.getNo() 출력 -->
		<td>${noticeDTO.no }</td>
		<td>${noticeDTO.title }</td>
		<td>${noticeDTO.id }</td>
		<td>${noticeDTO.writeDate }</td>
		<td>${noticeDTO.hit }</td>
	</tr>
</c:forEach>
</tbody>
<tfoot>
	<tr>
		<td colspan="3">
			<ul class="pagination">
			<c:if test="${pageObject.startPage > 1 }">
			  <li>
			  	<a href='noticeList.do?page=${pageObject.startPage - 1 }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}'>
			  	<i class="glyphicon glyphicon-step-backward"></i></a></li>
			 </c:if>
			<c:forEach begin="${pageObject.startPage }" end="${pageObject.endPage }"
			var="idx">
			  <li ${(pageObject.page == idx)?"class='active'":"" }>
			  	<a href='noticeList.do?page=${idx }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}'>
			  	${idx }</a></li>
			</c:forEach>
			<c:if test="${pageObject.endPage != pageObject.totalPage }">
			  <li>
			  	<a href='noticeList.do?page=${pageObject.endPage + 1 }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}'>
			  	<i class="glyphicon glyphicon-step-forward"></i></a></li>
			 </c:if>
			</ul> 
		</td>
		<td colspan="2">
			<div class="btn-group">
				<%if(gradeno >= 9){ %>
					<button id="write" class="btn btn-primary">공지사항 작성</button>
				<%} %>
<!-- 				<button id="reload" class="btn btn-info">새로고침</button> -->
			</div>
		</td>
	</tr>
</tfoot>
</table>
</body>
</html>