<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="auth.service.Message"
	import="auth.service.MessageListView"
	import="auth.service.GetMessageListViewService"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jspf"%>

<%-- <%
	GetMessageListViewService viewService = GetMessageListViewService.getInstance();
String pageStr = request.getParameter("page");
int pageNum = pageStr == null ? 1 : Integer.parseInt(pageStr);
MessageListView view = viewService.getMessageListView(pageNum);
%> --%>
<%-- <c:set var="view" value="<%=view%>" /> --%>

<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header"></section>

	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border">

				<div class="box-tools pull-right"></div>
			</div>

			</table>
			<div class="review-list">
				<c:if test="${!view.isEmpty()}">
					<table border="1">
						<c:forEach var="message" items="${view.messageList}">
							<div class="clearfix">
								<div class="float-left">
									<h6>
										<i class="fa fa-calendar"></i> ${message.reviewDate}
									</h6>
									<h6>By ${message.userNo}</h6>


									<ul class="list-unstyled list-inline rating-star-list">
										<li class="list-inline-item"><i class="fa fa-star"></i></li>
										<li class="list-inline-item"><i class="fa fa-star"></i></li>
										<li class="list-inline-item"><i class="fa fa-star"></i></li>


										<li class="list-inline-item"><i class="fa fa-star-o"></i></li>
										<li class="list-inline-item"><i class="fa fa-star-o"></i></li>
									</ul>

								</div>
								<img src="images/coffee-image1.jpg" alt="Image"
									class="img-fluid float-right">
							</div>
							<div class="review-list-content">
								<p>리뷰내용: ${message.reviewContents}</p>
								<p>평점: ${message.avgScore}</p>
								<p>메시지 번호: ${message.reviewno}</p>
							</div>
							</div>
						</c:forEach>
						<tr>
							<td>

								<p>
									<a href="confirmDeletion.jsp?messageId=${message.reviewno}">[삭제하기]</a>
								</p>
							</td>
						</tr>

						<div>
							<c:forEach var="pageNum" begin="1" end="${view.totalPages}">
								<span><a href="list.jsp?page=${pageNum}">[${pageNum}]</a></span>
							</c:forEach>
						</div>
						</c:if>
						</div>
						</div>
						<!-- /.box-body -->

						<!-- /.box-footer-->
						</div>
						<!-- /.box -->

						</section>
						<!-- /.content -->
						</div>

						<script>
							// 제이쿼리로 form submit 이벤트 처리
							$(function() {
								$("#writeForm")
										.submit(
												function() {
													var formData = { // Plain Object 변수에 form의 data 저장
														reviewcontents : this.reviewcontents.value
													};

													$
															.ajax({
																url : "/CAREIT/CARE/view/guestbook/writeMessage.jsp",
																method : "POST",
																data : formData,
																success : function() { // 요청 성공 시 (HTTP 200 OK)
																	$(
																			"#writeForm [name=reviewcontents]")
																			.val(
																					""); // 입력했던 정보 비우기
																	$("#list")
																			.load(
																					window.location.href
																							+ " #list"); // 글목록만 새로고침
																}
															});

													event.preventDefault(); // submit 시 페이지 이동하지 않게
												});
							});
						</script>
					</table>
			</div>
		</div>
	</section>
</div>
