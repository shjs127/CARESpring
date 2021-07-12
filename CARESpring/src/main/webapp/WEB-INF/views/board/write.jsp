<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style>
* {
	margin: 4px 0;
}

.controller {
	padding: 25px 0;
	margin: auto;
	width: 840px;
}

#wriTitle {
	text-align: center;
	background-color: rgb(100, 100, 100);
	width: 800px;
	padding-top: 10px;
	padding-bottom: 10px;
	color: white;
}

table {
	width: 840px;
	margin: 25px 0;
	padding: 20px;
	border-collapse: collapse;
}

#boardTitle {
	width: 693px;
}

textarea {
	width: 800px;
	height: 400px;
}

.button {
	width: 100px;
	padding: 5px 12px;
	border: none;
	background-color: rgb(150, 60, 60);
	color: white;
}

button {
	padding: 5px 12px;
	background-color: white;
	border-color: rgb(180, 180, 180);
	border-width: 1px;
}
</style>
</head>
<%@ include file="../include/header.jspf"%>
<body>

	<div class="controller">
		<div id="wriTitle">
			<b>게시글 작성</b>
		</div>
		<script>
			function writeConfirm() {
				if (document.getElementById('boardTitle').value == '') {
					alert("글 제목을 작성해주세요");
					document.getElementById('boardTitle').focus();
					return false;
				} else if (document.getElementById('boardContents').value == '') {
					alert("글 내용을 작성해주세요");
					document.getElementById('boardContents').focus();
					return false;
				} else
					return true;
			}
		</script>
		<form onsubmit="return writeConfirm();" action="write.do"
			method="post" enctype="multipart/form-data">

			<table>
				<tr>
					<td>파일명 :</td>
					<td><input type="file" name="fileName1"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="boardTitle" id="boardTitle" /></td>
				</tr>
				<tr>
					<td style="padding-top: 20px;" colspan="2"><textarea rows="12"
							cols="50" id="boardContents" name="boardContents"></textarea></td>
				</tr>
				<tr>
					<td align="left"><input type="submit" value="작성"
						class="button"></td>
					<td style="padding-right: 40px;" align="right"><input
						type="reset" value="내용 초기화" class="button"></td>
				</tr>
			</table>
		</form>
		<div>
			<a href="${pageContext.request.contextPath }/board/list.do">
				<button>게시판</button>
			</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath }/main/index.do">
				<button>홈으로</button>
			</a>
		</div>
	</div>
</body>
<%@ include file="../include/footer.jspf"%>
</html>