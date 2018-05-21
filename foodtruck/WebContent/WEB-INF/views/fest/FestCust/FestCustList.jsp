<%@page import="com.foodtruck.fest.dto.FestCustDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.foodtruck.fest.CustService.FestCustListService"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
pageContext.setAttribute("absURI", request.getContextPath());

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>소비자 신청서 리스트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
// 	alert("OK");
    $(".data").click(function(){
//         $(this).hide();
        var custno = $(this).find("td:first").text();
// 		alert("click");
// 		alert(custno);
		location = "FestCustView.do?custno="+custno+'&page=${pageObject.page}&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}';
    });
    $("#reload").click(function(){
    	location = "FestCustList.do";
    });
});
</script>
<link rel="stylesheet" href="../css/board.css" />
</head>
<body>

<div class="container">

  <h1 class="mt-4 mb-3">소비자 신청서 
        <small>리스트 메인 화면</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="../../main/main.do"  style="color:#4a4b4c;">메인</a>
        </li>
        <li class="breadcrumb-item active">소비자 리스트</li>
      </ol>

 <h4>소비자 정보 검색창</h4>
  <p>원하는 정보를 검색하세요.</p>
 <form class="navbar-form">
 <input name="page" value="1" type="hidden" /> 
	<input name="rowPerPage" value='${(empty param.rowPerPage)?"10":param.rowPerPage}' type="hidden" />
 <div class="form-group navbar-left" align="center">
 <select class="form-control navbar-left list-group"  name="searchKey"  class="input-group-addon" >
<option value="applyname" ${(param.searchKey == "applyname")?"selected=\"selected\"":"" } 
  		>신청자 이름</option>
<option value="applytel" ${(param.searchKey == "applytel")?"selected=\"selected\"":"" } 
  		>신청자 연락처</option>
<option value="applydate" ${(param.searchKey == "applydate")?"selected=\"selected\"":"" } 
  		>접수 날짜</option>
<option value="applyname,applytel" ${(param.searchKey == "applyname,applytel")?"selected=\"selected\"":"" } 
  		>이름+연락처</option>
<option value="applyname,applydate" ${(param.searchKey == "applyname,applydate")?"selected=\"selected\"":"" } 
  		>이름+날짜</option>
<option value="applytel,applydate" ${(param.searchKey == "applytel,applydate")?"selected=\"selected\"":"" } 
  		>연락처+날짜</option>
 </select> 
 <input type="text" class="form-control navbar-left " placeholder="Search" name="searchWord">
 </div>
 <button type="submit" class="btn btn-default">
 <i class="glyphicon glyphicon-search"></i>
 </button> 
</form>

   <hr style="border: solid #dedede; border-width: 2px 0 0;">

<table class="table">
<thead>
	<tr>
		<th>소비자번호</th>
		<th>신청자 이름</th>
		<th>신청자 연락처</th>
		<th>접수 날짜</th>
		<th>조회수</th>
	</tr>
</thead>
<tbody>
<!-- 데이터를 출력하는 반복 처리 -->
<c:forEach items="${list }" var="FestCustDTO">
	<tr class="data">
		<td>${FestCustDTO.custno }</td>
		<td>${FestCustDTO.applyname }</td>
		<td>${FestCustDTO.applytel }</td>
		<td>${FestCustDTO.applydate }</td>
		<td>${FestCustDTO.hit }</td>
	</tr>
</c:forEach>
</tbody>
<tfoot>
	<tr>
		<td colspan="3">
			<ul class="pagination">
			<c:if test="${pageObject.startPage > 1 }">
			  <li>
			  	<a href='FestCustList.do?page=${pageObject.startPage -1 }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}'>
			  	<i class="glyphicon glyphicon-backward"></i></a></li>
			</c:if>
			<c:forEach begin="${pageObject.startPage }" end="${pageObject.endPage }"
			var="idx">
			  <li ${(pageObject.page == idx)?"class='active'":"" }>
			  	<a href='FestCustList.do?page=${idx }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}'>
			  	${idx }</a></li>
			</c:forEach>
			<c:if test="${pageObject.endPage != pageObject.totalPage}">
			  <li>
			  	<a href='FestCustList.do?page=${pageObject.endPage + 1 }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}'>
			  	<i class="glyphicon glyphicon-forward"></i></a></li>
			</c:if>
			</ul>
		</td>
			<td colspan="2">
				<div class="btn-group">
					<button id="reload" class="btn btn-info">새로고침</button>
				</div>
			</td>
	</tr>
</tfoot>
</table>
</div>
</body>
</html>