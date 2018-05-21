<%@page import="com.foodtruck.review.controller.ReviewController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	int gradeno;
	if (session.getAttribute("gradeno") != null) {
		gradeno = (int) session.getAttribute("gradeno");
	} else {
		gradeno = 0;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 리스트</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
$('document').ready(function() {
 var area0 = ["서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"];
  
 
 
 var area1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
   var area2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
   var area3 = ["대덕구","동구","서구","유성구","중구"];
   var area4 = ["광산구","남구","동구","북구","서구"];
   var area5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
   var area6 = ["남구","동구","북구","중구","울주군"];
   var area7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
   var area8 = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
   var area9 = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
   var area10 = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
   var area11 = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
   var area12 = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
   var area13 = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
   var area14 = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
   var area15 = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
   var area16 = ["서귀포시","제주시","남제주군","북제주군"];

 

 // 시/도 선택 박스 초기화

 $("select[name^=sido]").each(function() {
  $selsido = $(this);
  $.each(eval(area0), function() {
   $selsido.append("<option value='"+this+"'>"+this+"</option>");
  });
  $selsido.next().append("<option value=''>구/군 선택</option>");
 });

 

 // 시/도 선택시 구/군 설정

 $("select[name^=sido]").change(function() {
  var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
  var $gugun = $(this).next(); // 선택영역 군구 객체
  $("option",$gugun).remove(); // 구군 초기화

  if(area == "area0")
   $gugun.append("<option value=''>구/군 선택</option>");
  else {
   $.each(eval(area), function() {
    $gugun.append("<option value='"+this+"'>"+this+"</option>");
   });
  }
 });


});
</script>
	
	
	
<script>
	$(document)
			.ready(
					function() {
						$("#data")
								.click(
										function() {
											var no = $(this).find("td:first")
													.text();
											location = "reviewview.do?rno="
													+ rno
													+ "&page=${pageObject.page}"
													+ '&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}';
										});
					});
</script>
</head>
<div class="container">
	<h1 class="mt-4 mb-3">
		리뷰 <small>메인 화면</small>
	</h1>
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="../../main/main.do">메인</a></li>
		<li class="breadcrumb-item active">행사 리뷰</li>
		<li
			style="position: absolute; top: 97px; right: 500px; font-size: 18px;"><table>
				<tr>
					<td colspan="2">
						<div class="btn-group">
							<button id="write" class="btn btn-primary"
								onclick="window.open('reviewwrite.do','window_name','width=600,height=800,location=no,status=no,scrollbars=yes');">글쓰기</button>
							<button id="reload" class="btn btn-info">새로고침</button>
						</div> 
					</td>
				</tr>
			</table></li>
	</ol>
	<!-- Project One -->
	<table>
	<tr><td>
				<select style="margin-left: 0.5cm; width: 12cm" name="sido1" id="sido1">
							<option value="key1">--시/도 선택--</option>
<%-- 							<c:forEach items="${list }" var="BDTO"> --%>
<%-- 							</c:forEach> --%>
					</select>
				<select style="margin-left: 0.5cm; width: 12cm" >
							<option value="key1">--구/군 선택--</option>
<%-- 							<c:forEach items="${list }" var="BDTO"> --%>
<%-- 							</c:forEach> --%>
					</select>
					<button>검색</button>
					</td></tr>
			</table>
	<div class="row" style="border-bottom: 5px solid red; border-bottom-style: 5px solid black;">
	
			
			
		<c:forEach items="${list }" var="reviewDTO">
			<div class="col-md-7">
				<a href="#"> <c:if test="${reviewDTO.fname == '애경의푸드트럭'}">
						<img class="img-fluid rounded mb-3 mb-md-0"
							src="../../../img/portfolio_4 - beer 700x400.jpg" alt="맥쭈푸드트럭 리뷰"
							style="width: 600px; height: 300px;">

					</c:if> <c:if test="${reviewDTO.fname == '구로의푸드트럭'}">
						<img class="img-fluid rounded mb-3 mb-md-0"
							src="../../../img/portfolio_4 - burger 700x400.jpg"
							alt="버버푸드트럭 리뷰" style="width: 600px; height: 300px;">

					</c:if> <c:if test="${reviewDTO.fname == '경영기술의푸드트럭'}">
						<img class="img-fluid rounded mb-3 mb-md-0"
							src="../../../img/portfolio_4 - mexican 700x400.jpg"
							alt="맥찌깐푸드트럭 리뷰" style="width: 600px; height: 300px;">

					</c:if> <c:if test="${reviewDTO.fname == '송정민쌤의푸드트럭'}">
						<img class="img-fluid rounded mb-3 mb-md-0"
							src="../../../img/portfolio_4 - waffle 700x400.jpg"
							alt="와쁠푸드트럭 리뷰" style="width: 600px; height: 300px;">

					</c:if> <c:if test="${reviewDTO.fname == '이영환쌤의푸드트럭'}">
						<img class="img-fluid rounded mb-3 mb-md-0"
							src="../../../img/portfolio_4 - beer 700x400.jpg" alt="맥쭈푸드트럭 리뷰"
							style="width: 600px; height: 300px;">

					</c:if> <c:if test="${reviewDTO.fname == '백종원의푸드트럭'}">
						<img class="img-fluid rounded mb-3 mb-md-0"
							src="../../../img/portfolio_4 - burger 700x400.jpg"
							alt="버버푸드트럭 리뷰" style="width: 600px; height: 300px;">
					
					</c:if> 
					<c:if test="${reviewDTO.rno >= 33}">
						<img class="img-fluid rounded mb-3 mb-md-0"
							src="../../../img/gongsa.jpg" alt="버버푸드트럭 리뷰"
							style="width: 600px; height: 300px;">
					</c:if>
				</a><br>
			</div>
			<div class="col-md-5">


				<a style="font-size: 15px; text-decoration: none; color: blue;">${reviewDTO.id}님의
					작성글</a><br> <a
					style="font-size: 30px; text-decoration: none; color: black;">"${reviewDTO.fname }"&ensp;</a>
				<a style="text-decoration: none; color: black">행사날짜 :</a>${reviewDTO.festdate }<br>
				<a style="font-size: 12px; text-decoration: none; color: black;">행사지역
					: </a>${reviewDTO.festloc }<br> <a
					style="font-size: 12px; text-decoration: none; color: black;">메인음식
					:</a> ${reviewDTO.maindish }<br> <br> <br> <a
					style="font-size: 16px; text-decoration: none; color: black;">${reviewDTO.content }</a><br>
				<%
					if (gradeno < 1) {
				%>
				<a href="../member/join.do" style="color: orange;">자세한 리뷰가 보고
					싶다면? 회원가입하러 고고고!</a>
				<%
					}
				%>
				<a style="color: red; font-size: 40px; text-decoration: none;">${reviewDTO.starscore }&emsp;&emsp;</a>
<%-- 				<a style="font-size: 50px; text-decoration: none;">${reviewDTO.score } --%>
<%-- 					${reviewDTO.writedate }</a><br> --%>

				<%
					if (gradeno >= 1) {
				%>
				<a class="btn btn-primary" href="reviewview.do?rno=${reviewDTO.rno}">리뷰
					자세히 보러가기 <%
					}
				%> <span class="glyphicon glyphicon-chevron-right"></span>
				</a><br> <br> <br> <br> <br> <br>
			</div>
		</c:forEach>
	</div>
	<table>
		<tr>
			<td colspan="3">
				<ul class="pagination">
					<c:if test="${pageObject.startPage > 1 }">
						<li><a
							href='reviewlist.do?page=${pageObject.startPage - 1 }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}'>
								<i class="glyphicon glyphicon-step-backward"></i>
						</a></li>
					</c:if>
					<c:forEach begin="${pageObject.startPage }"
						end="${pageObject.endPage }" var="idx">
						<li ${(pageObject.page == idx)?"class='active'":"" }><a
							href='reviewlist.do?page=${idx }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}'>
								${idx }</a></li>
					</c:forEach>
					<c:if test="${pageObject.endPage != pageObject.totalPage }">
						<li><a
							href='reviewlist.do?page=${pageObject.endPage + 1 }&rowPerPage=${(empty param.rowPerPage)?"10":param.rowPerPage}'>
								<i class="glyphicon glyphicon-step-forward"></i>
						</a></li>
					</c:if>
				</ul>
			</td>

		</tr>
	</table>
</div>
</body>
</html>