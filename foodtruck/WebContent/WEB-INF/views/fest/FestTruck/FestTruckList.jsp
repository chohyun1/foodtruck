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
<title>푸드트럭 리스트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
// 	alert("OK");
    $(".data").click(function(){
//         $(this).hide();
        var truckno = $(this).find("li:first").text();
// 		alert("click");
// 		alert(festno);
		location = "FestTruckView.do?truckno="+truckno+'&page=${pageObject.page}&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}';
    });
    $("#write").click(function(){
    	location = "TruckWrite.do";
    });
    $("#reload").click(function(){
    	location = "FestTruckList.do";
    });
});
</script>
<link rel="stylesheet" href="../css/board.css" />
</head>
<body>
<div class="container">
 <!-- Page Content -->
      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">푸드트럭
        <small>알아보기</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="../../main/main.do" style="color:#4a4b4c;">메인</a>
        </li>
        <li class="breadcrumb-item active">푸드트럭 </li>
      </ol>

      <!-- Project One -->
      <div class="row">
      	<c:forEach items="${list }" var="FestTruckDTO">
  		<div class="col-md-7">
          <a href="#">
            <img class="img-fluid rounded mb-3 mb-md-0" src="../../../img/portfolio_4 - burger 700x400.jpg" alt="버버 푸드트럭" style="width:650px; height:350px;">
          </a>
        </div>
        <div class="col-md-5">
          <ul class="data" style="list-style: none; display:inline;" >
	         <li style="font-size:large; font-weight: bolder;">${FestTruckDTO.truckno}</li>  
	         <li style="font-size:large; font-weight: bolder;">${FestTruckDTO.truckname }</li>
	         <li>${FestTruckDTO.festjoin }</li>
	         <li>${FestTruckDTO.country }</li>
	         <li>${FestTruckDTO.maindish }</li>
         	</ul>
          <a class="btn btn-primary" href="../../fest/FestTruck/FestTruckView.do">푸드트럭 자세히 보러가기
	            <span class="glyphicon glyphicon-chevron-right"></span></a>
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
            <img class="img-fluid rounded mb-3 mb-md-0" src="../../../img/portfolio_4 - mexican 700x400.jpg" alt="신나쵸" style="width:650px; height:350px;">
          </a>
        </div>
        <div class="col-md-5">
          <h3>(3) 신나쵸</h3>
          	<p>잠실나루-불꽃축제-2018-05-08</p>
          	<p>멕시코</p>
          	<p>나쵸</p>
            <p>우리 다같이 나쵸를 먹고 신나쵸 푸드트럭을 외칩시다!!</p>
          <a class="btn btn-primary" href="../../error/ing.jsp">푸드트럭 자세히 보러가기
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
            <img class="img-fluid rounded mb-3 mb-md-0" src="../../../img/portfolio_4 - waffle 700x400.jpg" alt="너와나플" style="width:650px; height:350px;">
          </a>
        </div>
        <div class="col-md-5">
          <h3>(4) 너와나플</h3>
            <p>에버랜드-장미축제-2018-05-20</p>
          	 <p>기타</p>
          	<p>와플</p>
            <p>혼자 와플 먹으면, 슬프죠. 너도나도 함께 즐기는 너와나플 푸드트럭!</p>
          <a class="btn btn-primary" href="../../error/ing.jsp">푸드트럭 자세히 보러가기
            <span class="glyphicon glyphicon-chevron-right"></span>
          </a>
        </div>
      </div>
      <!-- /.row -->

      <hr>

<div class=container align="center">
    <!-- /.container -->
	<table >
		<tr align="center">
			<td colspan="3">
				<ul class="pagination">
				<c:if test="${pageObject.startPage > 1 }">
				  <li>
				  	<a href='FestTruckList.do?page=${pageObject.startPage -1 }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}'>
				  	<i class="glyphicon glyphicon-backward"></i></a></li>
				</c:if>
				<c:forEach begin="${pageObject.startPage }" end="${pageObject.endPage }"
				var="idx">
				  <li ${(pageObject.page == idx)?"class='active'":"" }>
				  	<a href='FestTruckList.do?page=${idx }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}'>
				  	${idx }</a></li>
				</c:forEach>
				<c:if test="${pageObject.endPage != pageObject.totalPage}">
				  <li>
				  	<a href='FestTruckList.do?page=${pageObject.endPage + 1 }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}&searchKey=${param.searchKey}&searchWord=${param.searchWord}'>
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
	</table>
	</div>
</div>

    <!-- Bootstrap core JavaScript -->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>