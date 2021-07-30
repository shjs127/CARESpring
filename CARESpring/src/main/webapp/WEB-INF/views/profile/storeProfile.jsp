
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.*"%>


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
						data-toggle="tab">매장정보</a></li>
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
												<div class="panel-body">

														<!-- Registration Form Starts -->
													<form class="form-horizontal" action="/store/profile"
														method="post" id="registForm">
														<!-- Personal Information Starts -->
														<input type="hidden" name="storeNo" value="${storein.storeNo}" />
														<div class="form-group row">
															<label for="inputFname"
																class="col-sm-3 col-form-label text-right">매장 이름 :</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	name="storeName" placeholder="${storein.storeName}"
																	required readonly>

															</div>
														</div>
														<div class="form-group row">
															<label for="inputCurPassword"
																class="col-sm-3 col-form-label text-right">주 소
																:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	name="address" placeholder="${storein.address}">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputNewPassword"
																class="col-sm-3 col-form-label text-right">영업 시간
																:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	name="hours" placeholder="${storein.hours}">

															</div>
														</div>
														<div class="form-group row">
															<label for="inputFname"
																class="col-sm-3 col-form-label text-right">휴 무 일 :</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	name="closedDays" placeholder="${storein.closedDays}">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputBirth"
																class="col-sm-3 col-form-label text-right">전화번호 :</label>
															<div class="col-sm-9">
																<input type="text"
																	class="form-control" name="callNumber"
																	placeholder="${storein.callNumber}">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputEmail"
																class="col-sm-3 col-form-label text-right">등록 번호
																:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="manageNo"
																	placeholder="${storein.manageNo}" required readonly>
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
					<div id="information" class="tab-pane fade show active">
						<!-- Tab #1 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-12 col-sm-20">
								<section class="registration-area">
									<div class="row">
										<div class="col-sm-9">
											<!-- Registration Block Starts -->
									<%-- 		<div class="panel panel-smart">
												<div class="panel-heading">
													<h3 class="panel-title">내 리뷰 및 즐겨찾기</h3>
												</div>
												<br>
												<div class="panel-body">
									

									<h5>내 리뷰 목록</h5>
									<br>


								</div>

								<table border="1">
									<tr>

										<th><p>가게 이름</p></th>
										<th><p>리뷰 내용</p></th>
										<th><p>평점</p></th>

									</tr>
									<c:forEach var="reviewInfo" items="${reviewInfoList}">
										<tr>
											<td>${reviewInfo.storeName}</td>
											<td>${reviewInfo.reviewContents}</td>
											<td>${reviewInfo.avgScore}</td>
											
											
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
									<c:forEach var="favorite" items="${favorite}">
										<tr>
											<td>${favorite.storeNo }</td>
											<td>${storeInfo.storeName }</td>
										</tr>
									</c:forEach>
								</table>
							</div> --%>
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

<script>
	var result = '${msg}';

	if (result == 'fail') {
		alert("비밀번호가 틀렸습니다.");
	}
</script>


<%@ include file="../include/footer.jspf"%>