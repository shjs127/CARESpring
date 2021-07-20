<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ include file="../include/header.jspf"%>

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
</style>

<div class="controller">
	<div id="wriTitle">
		<b>게시글 수정</b>
	</div>
	<script>
		function modify() {
			if (document.getElementById('boardTitle').value == '') {
				alert("제목을 입력하세요");
				document.getElementById('boardTitle').focus();
				return false;
			} else if (document.getElementById('boardContents').value == '') {
				alert("내용을 입력하세요");
				document.getElementById('boardContents').focus();
				return false;
			} else
				return true;
		}
	</script>
	<form onsubmit="return modify()" action="modify" method="post" enctype="multipart/form-data">
		<table class="table">
			<tbody>
				<tr>
					<td>파일명 :</td>
					<td><input type="file" name="file"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td class="text-align-left text-indent text-strong text-orange"
						colspan="2"><input style="width: 700px; height: 24px;"
						type="text" name="boardTitle" id="boardTitle"
						value="${modReq.boardTitle}" /></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${nickName.nickName}</td>
				</tr>
				<tr class="content">
					<td colspan="4"><textarea name="boardContents" rows="12"
							cols="50" id="boardContents">${modReq.boardContents}</textarea></td>
				</tr>
			</tbody>
		</table>
		<div class="margin-top">
			<table class="table border-top-default">
				<tr>
					<td align="left"><input type="submit" value="작성"
						class="button"></td>
					<td style="padding-right: 40px;" align="right"><input
						type="reset" value="내용 초기화" class="button"></td>
				</tr>
			</table>
		</div>
		<div style="display: none;">
			<input type="text" name="userNo" value="${modReq.userNo}" /> <input
				type="text" name="boardNo" value="${modReq.boardNo}" />
		</div>
	</form>
</div>

<%@ include file="../include/footer.jspf"%>