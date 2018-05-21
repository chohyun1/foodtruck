<%@page import="com.foodtruck.fest.dto.FestDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.foodtruck.fest.FestService.FestListService"%>
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
<title>게시판 리스트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
// 	alert("OK");
    $(".data").click(function(){
//         $(this).hide();
        var festno = $(this).find("li:first").text();
// 		alert("click");
// 		alert(festno);
		location = "FestView.do?festno="+festno+'&page=${pageObject.page}&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}';
    });
    $("#write").click(function(){
    	location = "FestWrite.do";
    });
    $("#reload").click(function(){
    	location = "FestList.do";
    });
});
</script>
<link rel="stylesheet" href="../css/board.css" />
</head>
<body>
<div class="container">
 <!-- Page Content -->
      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">행사일정표
        <small>일정표 메인 화면</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="../../main/main.do"  style="color:#4a4b4c;">메인</a>
        </li>
        <li class="breadcrumb-item active">행사일정표 </li>
      </ol>

      <!-- Project One -->
      <div class="row">
      	<c:forEach items="${list }" var="FestDTO">
  		<div class="col-md-7">
          <a href="#">
            <img class="img-fluid rounded mb-3 mb-md-0" src="../../../img/festival1.jpg" alt="음악축제" style="width:650px; height:350px;">
          </a>
        </div>
        <div class="col-md-5">
          <ul class="data" style="list-style: none; display:inline;" >
	         <li style="font-size:large; font-weight: bolder;">${FestDTO.festno }</li>
	         <li style="font-size:large; font-weight: bolder;">${FestDTO.festname }</li>
	         <li>${FestDTO.festdate }</li>
	         <li>${FestDTO.festloc }</li>
	         <li>올림픽 공원에서 2018년 5월5일 어린이날을 맞이하여 가족이 모여 음악을 즐길 수 있는 축제가 열립니다...</li>
         	</ul>
          <a class="btn btn-primary" href="FestView.do">행사 자세히 보러가기
            <span class="glyphicon glyphicon-chevron-right"></span>
          </a>
        </div>
        </c:forEach>
              <hr>
        
      </div>
      <!-- /.row -->

      <hr>

      <!-- Project Two -->
      <div class="row">
        <div class="col-md-7">
          <a href="../../error/ing.jsp">
            <img class="img-fluid rounded mb-3 mb-md-0" src="../../../img/festival2.jpg" alt="불꽃축제" style="width:650px; height:350px;">
          </a>
        </div>
        <div class="col-md-5">
          <h3>불꽃 축제</h3>
          	<p>2018-05-08</p>
          	<p>서울-송파구</p>
            <p>오는 어버이날에는 잠실나루에서 최고의 효도를 선물할 수 있는 불꽃 축제가 열립니다. 모두 함께 행복한 추억을 만들어 보세요...</p>
          <a class="btn btn-primary" href="../../error/ing.jsp">행사 자세히 보러가기
            <span class="glyphicon glyphicon-chevron-right"></span>
          </a>
        </div>        
      </div>
      <!-- /.row -->

      <hr>

      <!-- Project Three -->
      <div class="row">
        <div class="col-md-7">
          <a href="../../error/ing.jsp">
            <img class="img-fluid rounded mb-3 mb-md-0" src="../../../img/festival3.jpg" alt="장미축제" style="width:650px; height:350px;">
          </a>
        </div>
        <div class="col-md-5">
          <h3>장미 축제</h3>
            <p>2018-05-20</p>
          	<p>경기-용인</p>
            <p>나와 쌓은 10년의 우정의 고마움을 표현 할 수 있는 축제. 서로에게 장미를 선물하면서 소중한 시간을 보내세요...</p>
          <a class="btn btn-primary" href="../../error/ing.jsp">행사 자세히 보러가기
            <span class="glyphicon glyphicon-chevron-right"></span>
          </a>
        </div>
      </div>
      <!-- /.row -->

      <hr>

<div class=container align="center">
    <!-- /.container -->
	<table>
		<tr align="center">
			<td colspan="3">
				<ul class="pagination">
				<c:if test="${pageObject.startPage > 1 }">
				  <li>
				  	<a href='FestList.do?page=${pageObject.startPage -1 }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}'>
				  	<i class="glyphicon glyphicon-backward"></i></a></li>
				</c:if>
				<c:forEach begin="${pageObject.startPage }" end="${pageObject.endPage }"
				var="idx">
				  <li ${(pageObject.page == idx)?"class='active'":"" }>
				  	<a href='FestList.do?page=${idx }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}'>
				  	${idx }</a></li>
				</c:forEach>
				<c:if test="${pageObject.endPage != pageObject.totalPage}">
				  <li>
				  	<a href='FestList.do?page=${pageObject.endPage + 1 }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}'>
				  	<i class="glyphicon glyphicon-forward"></i></a></li>
				</c:if>
				</ul>
			</td>
				<td colspan="2">
					<div class="btn-group">
						<button id="write" class="btn btn-primary">글쓰기</button>
						<button id="reload" class="btn btn-info">새로고침</button>
					</div>
				</td>
		</tr>
	</table>
	</div>
</div>

    <!-- Bootstrap core JavaScript -->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>