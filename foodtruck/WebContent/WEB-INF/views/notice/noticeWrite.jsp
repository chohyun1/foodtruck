<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
// 	alert("OK");
	// 버튼 이벤트 처리
	$("#cancel").click(function(){
		history.back();
	});
});
</script>
<link rel="stylesheet" href="../../css/board.css" />
</head>
<body>
<h1>게시판 글쓰기</h1>
<form method="post">
<div class="container">
<table class="table">
<tbody>
<!-- 데이터를 입력하는 -->
	<tr>
		<th>제목</th>
		<td><input name="title" size="60" maxlength="100"/></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="5" cols="60" name="content"></textarea></td>
		<td><input type="hidden" name="id" value="admin"/></td>
	<tr/>
<!-- 	<tr> -->
<!-- 		<th>작성자</th> -->
<!-- 		<td><input type="hidden" name="id" value="admin"/></td> -->
<!-- 	</tr> -->
</tbody>
<tfoot>
	<tr>
		<td colspan="2">
			<button class="btn btn-success">등록</button>
			<button class="btn btn-warning" type="reset">새로고침</button>
			<button class="btn btn-danger" type="button" id="cancel">취소</button>
		</td>
	</tr>
</tfoot>
</table>
</div>
</form>
</body>
</html>