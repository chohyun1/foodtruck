<%@page import="com.foodtruck.review.service.ReviewListService"%>
<%@page import="java.util.List"%>
<%@page import="com.foodtruck.review.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<%
	String memberid = (String) session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		// 	alert("OK");
		// 버튼 이벤트 처리
		$("#cancel").click(function() {
			window.close();
		});
		$("#save").click(function() {
			setTimeout('window.close()', 2000);
		});
	});
</script>
</head>
<body>
	<h1 style="margin: 20px; margin-left:3.5cm; font-style: oblique;">&emsp;&emsp;리뷰 쓰기</h1>
	<script type="text/javascript">
		$(document).ready(function() {
			var i = 1;
			var htmlString = "";
			$("#bt1").click(function() {
				if (i < 5) {
					var x = $("#s").text();
					htmlString = "<span>" + x + "</span>";
					$("#star").append(htmlString);
					i++;
					$("#show").text(i);
					$("#star1").val(i);
					if (i == 2) {
						$("#starImg").val("★★☆☆☆");
						$("#show").val("2");

					} else if (i == 3) {
						$("#starImg").val("★★★☆☆");
						$("#show").val("3");

					} else if (i == 4) {
						$("#starImg").val("★★★★☆");
						$("#show").val("4");

					} else if (i == 5) {
						$("#starImg").val("★★★★★");
						$("#show").val("5");

					}
				}
			});

			$("#bt2").click(function() {
				if (1 < i) {
					$("#star span:last").remove();
					i--;
					$("#show").text(i);
					$("#star1").val(i);

					if (i == 2) {
						$("#starImg").val("★★☆☆☆");
						$("#show").val("2");
					} else if (i == 3) {
						$("#starImg").val("★★★☆☆");
						$("#show").val("3");

					} else if (i == 4) {
						$("#starImg").val("★★★★☆");
						$("#show").val("4");

					} else if (i == 1) {
						$("#starImg").val("★☆☆☆☆");
						$("#show").val("1");

					}

				}
			})
		});
	</script>
	<form action="reviewwrite.do" method="post" style="margin: auto;">
		<table class="table">
			<tbody>
				<tr>
					<th style="margin-left: 10px; font-size: 20px;">&emsp;회사명</th>
					<td><textarea rows="1" cols="20" name="content" style="border-color: purple;"readonly="readonly"></textarea>
					<select>						
					<c:forEach items="${list }" var="reviewDTO">
					<option value="${reviewDTO.fname }">--회사명--</option>
					
					</c:forEach>
					</select>
					</td>
					<td><input type="hidden" name="id" value="admin" /></td>
					</tr><tr>
					
					<th style="margin-left: 10px; font-size: 20px;">&emsp;행사장소</th>
					<td><textarea rows="1" cols="20" name="content" style="border-color: purple;" readonly="readonly"></textarea></td>
					<td><input type="hidden" name="id" value="admin" /></td>
					</tr><tr>
					
					<th style="margin-left: 10px; font-size: 20px;">&emsp;주요메뉴</th>
					<td><textarea rows="1" cols="20" name="content" style="border-color: purple;"readonly="readonly"></textarea></td>
					<td><input type="hidden" name="id" value="admin" /></td>
					</tr><tr>
					
					<th style="margin-left: 10px; font-size: 20px;">&emsp;행사날짜</th>
					<td><textarea rows="1" cols="20" name="content" style="border-color: purple;"readonly="readonly"></textarea></td>
					<td><input type="hidden" name="id" value="admin" /></td>
					</tr><tr>
					
					<th style="margin-left: 10px; font-size: 20px;">&emsp;리뷰내용</th>
					<td><textarea rows="10" cols="40" name="content" style="border-color: purple;"></textarea></td>
					<td><input type="hidden" name="id" value="admin" /></td>
				<tr />
			</tbody>
			</table>
		<input type="hidden" id="starImg" name="starscore" value="★">
		<input type="hidden" id="show" name="score1" value="1"> <input
			type="hidden" name="id" value="<%=memberid%>">
		<a style="margin-left: 30px; font-size: 20px;text-decoration: none; color: black;">평점</a>
		<button id="bt1" type="button" style="margin-left: 30px; font-size: 20px" class="btn btn-primary btn-sm" >+</button>
		<button id="bt2" type="button" style="font-size: 20px" class="btn btn-primary btn-sm" >-</button>&emsp;&emsp;
		<a style="color: red; font-size: 50px; text-decoration: none;" id="s">★</a>
		<a id="star"
			style="color: red; font-size: 50px; text-decoration: none;"></a>
			<br><br><br><br>
		<table>
			<tfoot>
				<tr>
					<td colspan="2">
						<button type="submit" class="btn btn-success" id="save" style="margin-left: 5cm;">등록</button>
						<button class="btn btn-warning" type="reset">새로고침</button>
						<button class="btn btn-danger" type="button" id="cancel">취소</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>