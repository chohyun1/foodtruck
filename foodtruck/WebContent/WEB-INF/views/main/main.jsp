<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>메인</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="description" content="">
<meta name="author" content="">

<!-- 제목 글씨체 css  -->
<style type="text/css">
.card-title a{
color: black;
font-weight:lighter;
}

</style>
</head>

<body>
 <header>
  	 <div class="container">
 
	  <div id="myCarousel" class="carousel slide" data-ride="carousel">
	    <!-- Indicators -->
	    <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	      <li data-target="#myCarousel" data-slide-to="1"></li>
	      <li data-target="#myCarousel" data-slide-to="2"></li>
	    </ol>
	
	    <!-- Wrapper for slides -->															
	    <div class="carousel-inner">
	      <div class="item active">
	        <img src="../../img/slide1.jpg" class="img-fluid" alt="Los Angeles" style="width:100%;">
	      </div>
	
	      <div class="item">
	        <img src="../../img/slide2.jpg" class="img-fluid" alt="Chicago" style="width:100%;">
	      </div>
	    
	      <div class="item">
	        <img src="../../img/slide3.jpg" class="img-fluid" alt="New york" style="width:100%;">
	      </div>
	    </div>
	
	    <!-- Left and right controls -->
	    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right"></span>
	      <span class="sr-only">Next</span>
	    </a>
	  </div>
	  </div>
   </header>
  
 <!-- Portfolio Section -->
 	 <div class="container">
 	 
 	 <h2 style="border: solid gray; border-width: 0 0 1px;">행사 알아보기</h2>
 	 
	      <div class="col-lg-4 col-sm-6 portfolio-item" align="right">
	          <div class="card h-100">
	            <a href="#"><img class="card-img-top" src="../../img/festival1.jpg" alt="뮤직페스티벌" style="width:300px; height:180px;"></a>
	            <div class="card-body" align="center">
	              <h4 class="card-title">
	                <a href="#">뮤직 페스티벌</a>
	              </h4>
	              <p class="card-text">행사이름: 올림픽 음악 페스티벌 <br/> 가수: 태선이와 아이들</p>
	            </div>
	          </div>
	        </div>
	         
	      <div class="col-lg-4 col-sm-6 portfolio-item" align="center">
	          <div class="card h-100">
	            <a href="#"><img class="card-img-top" src="../../img/festival2.jpg" alt="" style="width:300px; height:180px;"></a>
	            <div class="card-body" align="center">
	              <h4 class="card-title">
	                  <a href="#">불꽃 축제</a>
	              </h4>
	              <p class="card-text">행사이름: 잠실나루 불꽃축제 <br/> 불꽃축제와 치맥은 환상콤비</p> </div>
	          </div>
	        </div>
	         
	      <div class="col-lg-4 col-sm-6 portfolio-item" align="left">
	          <div class="card h-100">
	            <a href="#"><img class="card-img-top" src="../../img/festival3.jpg" alt="" style="width:300px; height:180px;"></a>
	            <div class="card-body" align="center">
	              <h4 class="card-title">
	                   <a href="#">장미 축제</a>
	              </h4>
	              <p class="card-text">행사이름: 우정 장미축제 <br/> 친구와 우정축제 가즈아!</p></div>
	          </div>
	        </div>
	        </div>
	        
	        <hr style="border: solid #dedede; border-width: 2px 0 0;">
	        
      <div class="container">
 	   <h2 style="border: solid gray; border-width: 0 0 1px;">푸드트럭 알아보기</h2>
 	 
	      <div class="col-lg-4 col-sm-6 portfolio-item" align="right">
	          <div class="card h-100">
	            <a href="#"><img class="card-img-top" src="../../img/portfolio_4 - waffle 700x400.jpg" alt="" style="width:300px; height:180px;"></a>
	            <div class="card-body" align="center">
	              <h4 class="card-title">
	                <a href="#">너와나플 푸드트럭</a>
	              </h4>
	              <p class="card-text">푸드트럭명: 너와나플 <br/> 메뉴: 와플 <br/> 소개글: 커플이라면 한번쯤 먹어본다는 와플</p>
	            </div>
	          </div>
	        </div>
	         
	      <div class="col-lg-4 col-sm-6 portfolio-item" align="center">
	          <div class="card h-100">
	            <a href="#"><img class="card-img-top" src="../../img/portfolio_4 - mexican 700x400.jpg" alt="" style="width:300px; height:180px;"></a>
	            <div class="card-body" align="center"> 
	              <h4 class="card-title">
	                <a href="#">신나쵸</a>
	              </h4>
	              <p class="card-text">푸드트럭명: 신나쵸 <br/> 메뉴: 나쵸 <br/> 소개글: 나 지금 나쵸먹고, 신나쵸?</p>
	            </div>
	          </div>
	        </div>
	         
	      <div class="col-lg-4 col-sm-6 portfolio-item" align="left">
	          <div class="card h-100">
	            <a href="#"><img class="card-img-top" src="../../img/portfolio_4 - burger 700x400.jpg" alt="" style="width:300px; height:180px;"></a>
	            <div class="card-body" align="center">
	              <h4 class="card-title">
	                <a href="#">버거운 버거</a>
	              </h4>
	              <p class="card-text">푸드트럭명: 버거운 버거 <br/> 메뉴: 수제 햄버거 <br/> 소개글: 배가 버거울 정도로 맛있는 버거운 버거!</p>
	            </div>
	          </div>
	        </div>    
	        </div>       
	     
	<hr style="border: solid #dedede; border-width: 2px 0 0;"/>
	        
      <div class="container"  >
 	   <h2 style="border: solid gray; border-width: 0 0 1px;">둥가둥가 푸드트럭 더 알아가기</h2>
	         
	            <a href="#"><img align="middle" class="card-img-top" src="../../img/slide3.jpg" alt="" style="width:100%"></a>
	            <div class="card-body" align="right">
	              <h4 class="card-title">
	                     <a class="btn btn-primary" href="#">지금 바로 알아보세요!
					          <span class="glyphicon glyphicon-chevron-right"></span>
					       </a>
	              </h4>
	            </div>        
	     
</div>

</body>
</html>
