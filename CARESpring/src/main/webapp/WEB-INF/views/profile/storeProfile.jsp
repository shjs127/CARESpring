
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style type="text/css">
select {
	width: 100px;
}

.select_img img {
	margin: 20px 0;
	max-width: 200px !important;
	max-height: 100px !important;
}
</style>
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
						data-toggle="tab">매장 정보</a></li>
					<li class="nav-item"><a href="#information" class="nav-link"
						data-toggle="tab">매장 리뷰</a></li>
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
												<form class="form-horizontal"
													action="${pageContext.request.contextPath}/store/profile"
													method="post" id="registForm" enctype="multipart/form-data">
													<div class="panel-body">

														<!-- Registration Form Starts -->
														<!-- Personal Information Starts -->
														<input type="hidden" name="storeNo"
															value="${storein.storeNo}" />
														<div class="form-group row">
															<label for="inputFname"
																class="col-sm-3 col-form-label text-right">매장 이름
																:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="storeName"
																	placeholder="${storein.storeName}" required readonly>

															</div>
														</div>
														<div class="form-group row">
															<label for="inputCurPassword"
																class="col-sm-3 col-form-label text-right">주 소 :</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="address"
																	placeholder="${storein.address}">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputNewPassword"
																class="col-sm-3 col-form-label text-right">영업 시간
																:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="hours"
																	placeholder="${storein.hours}">

															</div>
														</div>
														<div class="form-group row">
															<label for="inputFname"
																class="col-sm-3 col-form-label text-right">휴 무 일
																:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	name="closedDays" placeholder="${storein.closedDays}">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputBirth"
																class="col-sm-3 col-form-label text-right">전화번호
																:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	name="callNumber" placeholder="${storein.callNumber}">
															</div>
														</div>
													</div>
													<div class="form-group row">
														<label for="preView"
															class="col-sm-3 col-form-label text-right">매장 사진
															:</label>
														<div class="col-sm-9">
															<c:if test="${storein.storePic ne null}">
																<input type="file" class="form-control" name="file"
																	id="preView" placeholder="${storein.storePic}">
																<div class="select_img">
																	<img
																		src="${pageContext.request.contextPath}/disFile?fileName=${storein.storePic}"
																		width="150" height="200" />

																</div>
															</c:if>
															<c:if test="${storein.storePic eq null}">

																<input type="file" class="form-control" name="file"
																	id="preView" placeholder="${storein.storePic}">
																<div class="select_img">
																	<img src="" />

																</div>
															</c:if>
														</div>
													</div>

													<div class="form-group row">
														<label for="inputEmail"
															class="col-sm-3 col-form-label text-right">등록 번호
															:</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" name="manageNo"
																placeholder="등록번호">
														</div>
													</div>

													<h3 class="panel-heading inner">매장 상세정보</h3>
													<div class="form-group row">
														<label for="inputFax"
															class="col-sm-3 col-form-label text-right">총 테이블수
															:</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" name="totalSeat"
																placeholder="${detail.totalSeat}">
														</div>
													</div>
													<div class="form-group row">
														<label for="inputFax"
															class="col-sm-3 col-form-label text-right">콘센트
															테이블 수 :</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" name="socketSeat"
																placeholder="${detail.socketSeat}">
														</div>
													</div>
													<div class="form-group row">
														<span class="col-sm-3 col-form-label text-right">디저트
															판매 :</span>
														<div class="col-sm-9">
															<div class="radio">
																<label> <input type="radio" name="dessertSales"
																	value="O"
																	<c:if test="${detail.dessertSales eq 'O'}"> checked="checked"</c:if>>
																	있음(가능) <input type="radio" name="dessertSales"
																	value="N"
																	<c:if test="${detail.dessertSales eq 'N'}"> checked="checked"</c:if>>
																	없음(불가능)
																</label>
															</div>
														</div>
													</div>
													<div class="form-group row">
														<span class="col-sm-3 col-form-label text-right">테라스
															:</span>
														<div class="col-sm-9">
															<div class="radio">
																<label> <input type="radio" name="terrace"
																	value="O"
																	<c:if test="${detail.terrace eq 'O'}"> checked="checked"</c:if>>
																	있음(가능) <input type="radio" name="terrace" value="N"
																	<c:if test="${detail.terrace eq 'N'}"> checked="checked"</c:if>>
																	없음(불가능)
																</label>
															</div>
														</div>
													</div>
													<div class="form-group row">
														<span class="col-sm-3 col-form-label text-right">루프탑
															:</span>
														<div class="col-sm-9">
															<div class="radio">
																<label> <input type="radio" name="roofTop"
																	value="O"
																	<c:if test="${detail.roofTop eq 'O'}"> checked="checked"</c:if>>
																	있음(가능) <input type="radio" name="roofTop" value="N"
																	<c:if test="${detail.roofTop eq 'N'}"> checked="checked"</c:if>>
																	없음(불가능)
																</label>
															</div>
														</div>
													</div>
													<div class="form-group row">
														<span class="col-sm-3 col-form-label text-right">와이파이
															:</span>
														<div class="col-sm-9">
															<div class="radio">
																<label> <input type="radio" name="wifi"
																	value="O"
																	<c:if test="${detail.wifi eq 'O'}"> checked="checked"</c:if>>
																	있음(가능) <input type="radio" name="wifi" value="N"
																	<c:if test="${detail.wifi eq 'N'}"> checked="checked"</c:if>>
																	없음(불가능)
																</label>
															</div>
														</div>
													</div>
													<div class="form-group row">
														<span class="col-sm-3 col-form-label text-right">애견동반:</span>
														<div class="col-sm-9">
															<div class="radio">
																<label> <input type="radio" name="companionDog"
																	value="O"
																	<c:if test="${detail.companionDog eq 'O'}"> checked="checked"</c:if>>
																	있음(가능) <input type="radio" name="companionDog"
																	value="N"
																	<c:if test="${detail.companionDog eq 'N'}"> checked="checked"</c:if>>
																	없음(불가능)
																</label>
															</div>
														</div>
													</div>
													<div class="form-group row">
														<span class="col-sm-3 col-form-label text-right">주차공간
															:</span>
														<div class="col-sm-9">
															<div class="radio">
																<label> <input type="radio" name="parkingSpace"
																	value="O"
																	<c:if test="${detail.parkingSpace eq 'O'}"> checked="checked"</c:if>>
																	있음(가능) <input type="radio" name="parkingSpace"
																	value="N"
																	<c:if test="${detail.parkingSpace eq 'N'}"> checked="checked"</c:if>>
																	없음(불가능)
																</label>
															</div>
														</div>
													</div>
													<div class="form-group row">
														<span class="col-sm-3 col-form-label text-right">노키즈존
															:</span>
														<div class="col-sm-9">
															<div class="radio">
																<label> <input type="radio" name="noKidsZone"
																	value="O"
																	<c:if test="${detail.noKidsZone eq 'O'}"> checked="checked"</c:if>>
																	있음(가능) <input type="radio" name="noKidsZone" value="N"
																	<c:if test="${detail.noKidsZone eq 'N'}"> checked="checked"</c:if>>
																	없음(불가능)
																</label>
															</div>
														</div>
													</div>
													<div class="form-group row">
														<span class="col-sm-3 col-form-label text-right">흡연구역
															:</span>
														<div class="col-sm-9">
															<div class="radio">
																<label> <input type="radio" name="smokingArea"
																	value="O"
																	<c:if test="${detail.smokingArea eq 'O'}"> checked="checked"</c:if>>
																	있음(가능) <input type="radio" name="smokingArea" value="N"
																	<c:if test="${detail.smokingArea eq 'N'}"> checked="checked"</c:if>>
																	없음(불가능)
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
								</section>
							</div>
						</div>
						<!-- Left Column Ends -->
					</div>
					<!-- Tab #1 Nested Row Ends -->
					<!-- Tab #1 Ends -->

					<!-- Tab #2 Starts -->
					<div id="information" class="tab-pane fade">
						<!-- Tab #1 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-12 col-sm-20">
								<section class="registration-area">
									<div class="row">
										<div class="col-sm-9">
											<!-- Registration Block Starts -->
											<div class="panel panel-smart">
												<div class="panel-heading">
													<h3 class="panel-title">매 장 리 뷰</h3>
												</div>
												<br>
												<div class="panel-body">
													<h5>내 리뷰 목록</h5>
													<br>
												</div>

												<table border="1">
													<tr>

														<th><p>유저닉네임</p></th>
														<th><p>리뷰 내용</p></th>
														<th><p>평점</p></th>
														<th><p>사진</p></th>

													</tr>
													<c:forEach var="reviewInfo" items="${reviewDTO}">
														<tr>
															<td>${reviewInfo.nickName}</td>
															<td>${reviewInfo.reviewContents}</td>
															<td>${reviewInfo.avgScore}</td>
															<td>
																<div class="select_img">
																	<c:if test="${reviewInfo.pFile eq null}">
																		<img
																			src=""
																			class="img-fluid img-center">
																	</c:if>
																	<c:if test="${reviewInfo.pFile ne null}">
																		<img
																			src="${pageContext.request.contextPath}/disFile?fileName=${reviewInfo.pFile}"
																			class="img-fluid img-center">
																	</c:if>
																</div>
															</td>
														</tr>
													</c:forEach>
												</table>
												<br>
												<hr>
												<br>
											</div>
										</div>

									</div>
								</section>
							</div>




						</div>
						<!-- Information Tab Pane Ends -->

					</div>
					<!-- Right Column Ends -->
				</div>
				<!-- Tab #2 Nested Row Ends -->
			</div>
		</div>
	</div>
</div>


<script>
	var result = '${msg}';

	if (result == 'fail') {
		alert("매장번호가 틀렸습니다.");
	}
</script>
<script>
	$("#preView").change(
			function() {
				if (this.files && this.files[0]) {
					var reader = new FileReader;
					reader.onload = function(data) {
						$(".select_img img").attr("src", data.target.result)
								.width(500);
					}
					reader.readAsDataURL(this.files[0]);
				}
			});
</script>

<%@ include file="../include/footer.jspf"%>
