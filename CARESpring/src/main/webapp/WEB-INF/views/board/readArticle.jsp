<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ include file="../include/header.jspf"%>


<h3 class="main title" align="center">게시판</h3>
<table class="table">
	<tbody>
		<tr>
			<th>제목</th>
			<td class="text-align-left text-indent text-strong text-orange"
				colspan="1">${boardInfo.boardTitle}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td class="text-align-left text-indent" colspan="3"><fmt:formatDate
					pattern="yyyy/MM/dd HH:mm" value="${boardInfo.boardDate}" /></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${nickName.nickName}</td>
			<th>조회수</th>
			<td>${boardInfo.viewCount}</td>
		</tr>
		<tr class="content">
			<td colspan="4"
				style="word-break: break-all; padding-left: 30px; padding-right: 100px;">
				<c:forEach var="file" items="${boardInfoList.files}">
					<c:set var="fname" value="${file.boardPic1}" />
					<c:choose>
						<c:when test="${fn:endsWith(fname, '.jpg')==true}">
							<img
								src="${pageContext.request.contextPath}/disFile?fileName=${file.boardPic1}"
								width="200" />
						</c:when>
						<c:when test="${fn:endsWith(fname, '.JPG')==true}">
							<img
								src="${pageContext.request.contextPath}/disFile?fileName=${file.boardPic1}"
								width="200" />
						</c:when>
						<c:when test="${fn:endsWith(fname, '.png')==true}">
							<img
								src="${pageContext.request.contextPath}/disFile?fileName=${file.boardPic1}"
								width="200" />
						</c:when>
						<c:when test="${fn:endsWith(fname, '.PNG')==true}">
							<img
								src="${pageContext.request.contextPath}/disFile?fileName=${file.boardPic1}"
								width="200" />
						</c:when>
						<c:when test="${fn:endsWith(fname, '.gif')==true}">
							<img
								src="${pageContext.request.contextPath}/disFile?fileName=${file.boardPic1}"
								width="200" />
						</c:when>
						<c:when test="${fn:endsWith(fname, '.GIF')==true}">
							<img
								src="${pageContext.request.contextPath}/disFile?fileName=${file.boardPic1}"
								width="200" />
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</c:forEach><br> ${boardInfo.boardContents}
			</td>
		</tr>
	</tbody>
</table>

<div class="margin-top">
	<table class="table border-top-default">
		<tbody>

			<tr>
				<c:choose>
					<c:when test="${prevBoardNo.prevNo == 0}">
						<td class="text-align-left text-indent"><a
							class="text-blue text-strong" href="#"
							onclick="alert('이전 글이 없습니다.');">이전글</a></td>
					</c:when>
					<c:otherwise>
						<td class="text-align-left text-indent"><a
							class="text-blue text-strong"
							href="readArticle?boardNo=${prevBoardNo.prevNo}">이전글</a></td>
					</c:otherwise>
				</c:choose>

				<td class=" text-align-center text-indent"><a
					class="btn btn-list" href="listArticle">목록</a></td>


				<c:choose>
					<c:when test="${nextBoardNo.nextNo == 0}">
						<td class="text-align-rigth text-indent"><a
							class="text-blue text-strong" href="#"
							onclick="alert('다음 글이 없습니다.');">다음글</a></td>
					</c:when>
					<c:otherwise>
						<td class="text-align-rigth text-indent"><a
							class="text-blue text-strong"
							href="readArticle?boardNo=${nextBoardNo.nextNo}">다음글</a></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</tbody>
	</table>
</div>
<!-- <form action="modify.do" method="post"> -->
<div style="text-align: right;">

	<c:if test="${boardInfo.userNo == login.userNo}">
		<form name="removefrm" action="delete.do" method="post">
			<!-- <td> -->
			<input type="button" onclick="removeCheck()" value="삭제"
				class="btn btn-prime text-weight-bold text-uppercase animation">
			<input type="hidden" name="boardContents"
				value="${boardInfo.boardContents}"> <input type="hidden"
				name="boardTitle" value="${boardInfo.boardTitle}"> <input
				type="hidden" name="boardNo" value="${boardInfo.boardNo}">

			<script>
				function removeCheck() {

					if (confirm("정말 삭제하시겠습니까??") == true) { //확인

						document.removefrm.submit();

					} else { //취소

						return false;

					}

				}
			</script>
		</form>

		<a href="modify?boardNo=${boardInfo.boardNo}"> <input
			type="button" value="수정"
			class="btn btn-prime text-weight-bold text-uppercase animation">
		</a>
		<!-- </td> -->
	</c:if>
</div>
<!-- 	</form> -->
<div class="col-md-6">
	<!-- Reviews Tab Pane Starts -->

	<!-- Reviews Form Box Starts -->
	<div class="reviews-form-box"
		style="padding-top: 10px; padding-left: 20px; padding-bottom: 40px;">

		<h6>댓글</h6>

		<form>
<div>
			<p>
				<textarea id="commentContents" style="width:100%"

					placeholder="답글을 작성하세요"></textarea>
			</p>
			
			
			<%
					if (session.getAttribute("login") != null) {
				%>
			<p>
				<button id="btn" type="button" style="float: right;">댓글쓰기</button>
			</p>
				<%
					}else{
						%>
						<button type="button" onclick = "location.href='${pageContext.request.contextPath}/login'" style="float: right;">로그인이 필요합니다</button>
						<%
					}
				%>
				
			</div>
		</form>
	</div>
</div>
<div id="commentList"></div>
<script type="text/javascript">
	$("#btn").click(
			function() {
				var comment= $("#commentContents").val();
				var boardNo = ${boardInfo.boardNo};
				$.ajax({
					url : '${pageContext.request.contextPath}/board/insertComment',
					type : 'post',
					dataType : 'text',
					data : {
						comment : comment,
						boardNo : boardNo
					},
					success : function(data) {
						alert("성공");
						getreplylist()
						
					},
					error : function(request, status, error) {
						alert("code=" + request.status + " message = "
								+ request.responseText + " error = " + error);
					}
				});
			});
	
	$(document).ready(function() {
		getreplylist();
	});

	function getreplylist() {
		var bno = ${boardInfo.boardNo};
		$.ajax({
			url : '${pageContext.request.contextPath}/board/comment',
			type : 'get',
			datatype : 'json',
			data : {
				boardNo : bno
			},
			success : function(result) {
				var comment = "";
				if (result.length < 1) {
					comment = "등록된 댓글이 없습니다";
				} else {
					$(result).each(function() {
						comment += '<br/>';
						comment += '<strong>';
						comment += '작성자 : ' + this.nickName;
						comment += '</strong>&nbsp;&nbsp;&nbsp;';
						comment += '작성날짜: ' + this.commentDate;
						if(this.userNo == ${user.userNo}){
						comment += '<a href="javascript:;" onclick="commentUpdate('+this.commentNo+');"> 수정</a>';
						comment += '<a href="javascript:;" onclick="commentDelete('+this.commentNo+');"> 삭제</a>';
						}
						comment += '<br/> <p>';
						comment += '댓글내용 : &nbsp;&nbsp;&nbsp;';
						comment += this.commentContents;
						comment += '</p>';
						comment += '<br/>';
						
					});
				};
				$("#commentList").html(comment);
			},
			error : function(request, status, error) {
				alert("code=" + request.status + " message = "
						+ request.responseText + " error = " + error);
			}
		});
	};
	
	function commentDelete(commentNo) {
		var boardNo = ${boardInfo.boardNo};
		var msg = confirm("정말로 삭제하시겠습니까?");
		if(msg == true){
		$.ajax({
			url : '${pageContext.request.contextPath}/board/commentDelete',
			type : 'post',
			data : {
				boardNo : boardNo,
				commentNo : commentNo
			},
			success : function(date){
				alert("삭제되었습니다.");
				getreplylist()
			}
	});
		}else{
			return false;
		}
	}
	
	function commentUpdate(commentNo) {
		var boardNo = ${boardInfo.boardNo};
		var comment = prompt("내용을 입력해주세요.");
		console.log("commentContents:" + comment);
		if(comment == ""){
			alert("내용을 입력해주세요");
			return true;
		}

		$.ajax({
			url : '${pageContext.request.contextPath}/board/commentUpdate',
			type : 'post',
			data : {
				boardNo : boardNo,
				commentNo : commentNo,
				commentContents : comment
			},
			success : function(date){
				alert("수정되었습니다.");
				getreplylist()
			}
	});
	}

</script>

<%@ include file="../include/footer.jspf"%>