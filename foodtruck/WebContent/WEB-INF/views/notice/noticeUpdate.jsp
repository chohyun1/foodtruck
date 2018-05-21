<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>공지사항 글수정</title>
<script>
	$(document).ready(function() {
		// 	alert("OK");
		// 버튼 이벤트 처리
		$("#cancel").click(function() {
			history.go(-1);
		});
		$("#reload").click(function(){
		    location = "noticeUpdate.do";
		});
	});
</script>
<link rel="stylesheet" href="../css/board.css" />
</head>
<body>
	<div class="container">
		
					<h1>공지사항 글수정</h1>
				
				<div class="panel-body">
					<form action="noticeUpdate.do" method="post">
						<input type="hidden" name="page" value="${param.page }" /> <input
							type="hidden" name="rowPerPage" value="${param.rowPerPage }" />
						<table>
							<tbody>
								<!-- 데이터를 입력하는 -->
								<tr>
									<th>번호</th>
									<td><input name="no" size="10" readonly="readonly"
										value="${noticeDTO.no }" class="form-control" /></td>
								</tr>
								<tr>
									<th>제목</th>
									<td><input name="title" size="60" maxlength="100"
										value="${noticeDTO.title }" class="form-control" /></td>
								</tr>
								<tr>
									<th>내용</th>
									<td><textarea rows="5" cols="60" name="content"
											class="form-control">${noticeDTO.content }</textarea></td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="2">
										<button class="btn btn-primary">수정</button>
										<button type="reset" class="btn btn-info">새로고침</button>
										<button type="button" id="cancel" class="btn btn-warning">취소</button>
									</td>
								</tr>
							</tfoot>
						</table>
					</form>
				</div>
			</div>
</body>
</html>