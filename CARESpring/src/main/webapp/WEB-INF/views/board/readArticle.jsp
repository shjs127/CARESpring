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
			<td class="text-align-left text-indent" colspan="3">
			<fmt:formatDate pattern="yyyy/MM/dd HH:mm"
									value="${boardInfo.boardDate}" /></td>
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
							<img src="${pageContext.request.contextPath}/resources/upload/${file.boardPic1}" width="200" />
						</c:when>
						<c:when test="${fn:endsWith(fname, '.JPG')==true}">
							<img src="${pageContext.request.contextPath}/resources/upload/${file.boardPic1}" width="200" />
						</c:when>
						<c:when test="${fn:endsWith(fname, '.png')==true}">
							<img src="${pageContext.request.contextPath}/resources/upload/${file.boardPic1}" width="200" />
						</c:when>
						<c:when test="${fn:endsWith(fname, '.PNG')==true}">
							<img src="${pageContext.request.contextPath}/resources/upload/${file.boardPic1}" width="200" />
						</c:when>
						<c:when test="${fn:endsWith(fname, '.gif')==true}">
							<img src="${pageContext.request.contextPath}/resources/upload/${file.boardPic1}" width="200" />
						</c:when>
						<c:when test="${fn:endsWith(fname, '.GIF')==true}">
							<img src="${pageContext.request.contextPath}/resources/upload/${file.boardPic1}" width="200" />
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
					class="btn btn-list" href="list.do">목록</a></td>


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
<input type="hidden" name="boardNo">
<div style="text-align: right;">

	<c:if test="${boardInfo.userNo == login.userNo}">
		<form name="removefrm" action="delete.do" method="post">
			<!-- <td> -->
			<input type="button" onclick="removeCheck()" value="삭제" class="btn btn-prime text-weight-bold text-uppercase animation"> <input
				type="hidden" name="boardContents"
				value="${boardInfo.boardContents}"> <input
				type="hidden" name="boardTitle"
				value="${boardInfo.boardTitle}"> <input
				type="hidden" name="boardNo"
				value="${boardInfo.boardNo}">

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
			type="button" value="수정" class="btn btn-prime text-weight-bold text-uppercase animation">
		</a>
		<!-- </td> -->
	</c:if>
</div>
<!-- 	</form> -->



<%@ include file="../include/footer.jspf"%>