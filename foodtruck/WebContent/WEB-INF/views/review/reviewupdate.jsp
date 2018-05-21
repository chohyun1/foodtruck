<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>리뷰 글수정</title>
<body>
	<script>
		$(document).ready(function() {
			// 	alert("OK");
			// 버튼 이벤트 처리
			$("#cancel").click(function() {
				history.go(-1);
			});
			$("#reload").click(function() {
				location = "reviewupdate.do";
			});
		});
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

	<form action="reviewupdate.do" method="post" style="margin: auto;">
		<input type="hidden" id="starImg" name="starscore" value="★">
		<input type="hidden" id="show" name="score1" value="1"> 
	    <input type="hidden" name="rno" value="${reviewDTO.rno}" /> 
	    <input type="hidden" name="page" value="${param.page }">
	    <input type="hidden" name="rowPerPage" value="${param.rowPerPage }">
		<h3 style="margin: auto;">평점</h3>
		<button id="bt1" type="button">+</button>
		<button id="bt2" type="button">-</button>
		<a style="color: red; font-size: 50px; text-decoration: none;" id="s">★</a>
		<a id="star"
			style="color: red; font-size: 50px; text-decoration: none;"></a>
		<table class="table">
			<tbody>
				<tr>
					<th>내용</th>
					<td><textarea rows="5" cols="60" name="content"></textarea></td>
					<td><input type="hidden" name="content" value="${reviewDTO.content}" /></td>
				<tr />

			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<button type="submit" class="btn btn-success" id="reload">변경</button>
						<button class="btn btn-warning" type="reset">새로고침</button>
						<button class="btn btn-danger" type="button" id="cancel">취소</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>