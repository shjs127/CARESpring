
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.*"%>

<%-- 
<%@ page import="auth.service.Message"
	import="auth.service.MessageListView"  
	import="auth.service.GetMessageListViewService"%>
 --%>
<!-- Main Container Starts -->
<div class="main-container container">
	<!-- Nested Row Starts -->
	<div class="row">
		<!-- Mainarea Starts -->
		<div class="col-md-9 col-sm-12">
			<!-- Menu Tabs Starts -->
			<div class="menu-tabs-wrap">
				<!-- Menu Tabs List Starts -->
				<ul
					class="nav nav-tabs nav-menu-tabs text-xs-center text-sm-center text-md-left">
					<li class="nav-item"><a href="#menu" class="nav-link active"
						data-toggle="tab">개인정보</a></li>
					<li class="nav-item"><a href="#information" class="nav-link"
						data-toggle="tab">내 리뷰 및 즐겨찾기</a></li>

				</ul>
				<!-- Menu Tabs List Ends -->
				<!-- Menu Tabs Content Starts -->
				<div class="tab-content">
					<!-- Tab #1 Starts -->
					<div id="menu" class="tab-pane fade show active">
						<!-- Tab #1 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-12 col-sm-20">
								<section class="registration-area">
									<div class="row">
										<div class="col-sm-8">
											<!-- Registration Block Starts -->
											<div class="panel panel-smart">
												<div class="panel-heading">
													<h3 class="panel-title">Personal Information</h3>
												</div>
												<div class="panel-body">

													<script>
														$(function() {
															$("#registForm")
																	.submit(
																			function() {
																				var nameChk = /^[가-힣a-zA-Z]{0,10}$/;
																				if (!nameChk
																						.test($(
																								"#nickname")
																								.val())) {
																					alert("닉네임 - 1글자 미만 , 10글자 초과 사용 및 특수문자는 사용 불가입니다!");
																					$(
																							"#nickname")
																							.focus();
																					return false;
																				}
																			});
														});

														$(function() {
															$("#registForm")
																	.submit(
																			function() {
																				var nameChk = /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
																				if (!nameChk
																						.test($(
																								"#birth")
																								.val())) {
																					alert("생년월일 8자리를 입력하여 주세요!");
																					$(
																							"#birth")
																							.focus();
																					return false;
																				}
																			});
														});
													</script>
													<!-- Registration Form Starts -->
													<form class="form-horizontal" action="/login/change"
														method="post" id="registForm">
														<!-- Personal Information Starts -->
														<input type="hidden" name="userNo" value="${login.userNo}" />
														<div class="form-group row">
															<label for="inputFname"
																class="col-sm-3 col-form-label text-right">이 름 :</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	name="userName" placeholder="${login.userName}"
																	required readonly>

															</div>
														</div>
														<div class="form-group row">
															<label for="inputCurPassword"
																class="col-sm-3 col-form-label text-right">비밀번호
																:</label>
															<div class="col-sm-9">
																<input type="password" class="form-control"
																	name="password" placeholder="비밀번호">
															<%-- 	<c:choose>
																	<c:when test="${errors.badCurPwd}">현재 암호가 일치하지 않습니다..</c:when>
																	<c:otherwise>현재 암호를 입력하세요</c:otherwise>
																</c:choose> --%>
															</div>
														</div>
														<div class="form-group row">
															<label for="inputNewPassword"
																class="col-sm-3 col-form-label text-right">새비밀번호
																:</label>
															<div class="col-sm-9">
																<input type="password" class="form-control"
																	name="newPassword" placeholder="새비밀번호">

															</div>
														</div>
														<div class="form-group row">
															<label for="inputFname"
																class="col-sm-3 col-form-label text-right">닉네임 :</label>
															<div class="col-sm-9">
																<input id="nickname" type="text" class="form-control"
																	name="nickName" placeholder="${login.nickName}">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputBirth"
																class="col-sm-3 col-form-label text-right">생 일 :</label>
															<div class="col-sm-9">
																<input id="birth" max="9999-12-31" type="date"
																	class="form-control" name="birth"
																	placeholder="${login.birth}">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputEmail"
																class="col-sm-3 col-form-label text-right">Email
																:</label>
															<div class="col-sm-9">
																<input type="email" class="form-control" name="email"
																	placeholder="${login.email}">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputGender"
																class="col-sm-3 col-form-label text-right">성 별 :</label>
															<div class="col-sm-9">
																<div class="radio">
																	<label> <input type="radio" name="gender"
																		value="남성"
																		<c:if test="${login.gender eq '남성'}">checked="checked"</c:if>>남성
																	</label> <label> <input type="radio" name="gender"
																		value="여성"
																		<c:if test="${login.gender eq '여성'}">checked="checked"</c:if>>여성
																	</label>
																</div>
															</div>
														</div>
														<div class="form-group row">

															<button type="submit"
																class="btn btn-block btn-prime animation">
																저장 <i class="fa fa-caret-right"></i>
															</button>

														</div>
														<!-- Personal Information Ends -->
													</form>
												</div>
											</div>
										</div>
									</div>
								</section>
							</div>
							<!-- Left Column Ends -->
						</div>
						<!-- Tab #1 Nested Row Ends -->
					</div>
					<!-- Tab #1 Ends -->

					<!-- Tab #2 Starts -->
					<div id="information" class="tab-pane fade">
						<!-- Tab #2 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-4 col-sm-12"></div>



							<!-- Left Column Ends -->
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Information Tab Pane Starts -->
								<div class="information-tab-pane">
							<%-- 		<%
										// 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
									if (session.getAttribute("login") == null) {
									%>
									로그인을 해주세요.
									<li class="list-inline-item"><a
										href="${pageContext.request.contextPath }/login.do">로그인</a></li>
									<%
										}
									// 현재 로그인된 아이디가 있다면 (= session에 저장된 id가 있다면)
									else {
									%> --%>

									<h5>내 리뷰 목록</h5>
									<br>


								</div>

								<table border="1">
									<tr>

										<th><p>리뷰 번호</p></th>
										<th><p>리뷰 내용</p></th>
										<th><p>평점</p></th>
										<th><p>삭제</p></th>

									</tr>
									<c:forEach var="message" items="${messageListView.messageList}">
										<tr>
											<td>${message.reviewNo }</td>
											<td>${message.reviewContents }</td>
											<td>${message.avgScore }</td>
											<td>
												<form action='msgdelete.do' method="post">
													<input type="hidden" name="reviewNo"
														value="${message.reviewNo }" /> <input type="submit"
														value="삭제" />
												</form>
											</td>

										</tr>
									</c:forEach>
								</table>
								<br>
								<hr>
								<br>

								<h5>내 즐겨찾기 목록</h5>
								<br>


								<table border="1">
									<tr>

										<th><p>가게 번호</p></th>
										<th><p>가게 이름</p></th>
									</tr>
									<c:forEach var="storeInfo" items="${storeInfoList}">
										<tr>
											<td>${storeInfo.storeNo }</td>
											<td>${storeInfo.storeName }</td>
										</tr>
									</c:forEach>
								</table>
							</div>

						</div>
					</div>



				<%-- 	<%
						}
					%>
 --%>

				</div>
				<!-- Information Tab Pane Ends -->
			</div>
			<!-- Right Column Ends -->
		</div>
		<!-- Tab #2 Nested Row Ends -->
	</div>
</div>

<script>
	var result = '${msg}';

	if (result == 'fail') {
		alert("비밀번호가 틀렸습니다.");
	}
</script>


<!-- Tab #2 Ends -->
<!-- Tab #3 Starts -->

<!-- Tab #3 Ends -->
<!-- Tab #4 Starts -->


<%@ include file="../include/footer.jspf"%>