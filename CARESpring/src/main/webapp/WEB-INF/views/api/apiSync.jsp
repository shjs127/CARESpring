<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jspf"%>

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
					<li class="nav-item"><a href="#userinfomation" class="nav-link"
						data-toggle="tab">회원 정보</a></li>
					<li class="nav-item"><a href="#storeinfomation" class="nav-link"
						data-toggle="tab">매장 정보</a></li>
					<li class="nav-item"><a href="#storesync" class="nav-link active"
						data-toggle="tab">매장 동기화</a></li>
				
				</ul>
				
				<!-- Menu Tabs Content Starts -->
				<div class="tab-content">
					<!-- Tab #1 Starts -->
					<!-- <div id="userinfomation" class="tab-pane fade show active">
						Tab #1 Nested Row Starts
						<div class="row">
							Left Column Starts
							<div class="col-md-12 col-sm-20">
								<section class="registration-area">
									<div class="row">
										<div class="col-sm-8">
											Registration Block Starts
											<div class="panel panel-smart">
												<div class="panel-heading">
													<h3 class="panel-title">회원 정보</h3>
												</div>
												<div class="panel-body">
												<table>
													<tr>
														<th> No. </th>
														<th> 회원 아이디 </th>
														<th> 이름 </th>
														<th> 닉네임 </th>
														<th> 생일 </th>
														<th> 이메일 </th>
														<th> 성별 </th>
														<th> 관리자 여부 </th>
													</tr>
													<td>
													
													</td>
												</table>
												</div>
											</div>
										</div>
									</div>
								</section>
							</div>
						</div>
					</div> -->
					<!-- Tab #1 End -->
					<!-- Tab #2 Starts -->
					<!-- <div id="storeinfomation" class="tab-pane fade">
						Tab #1 Nested Row Starts
						<div class="row">
							Left Column Starts
							<div class="col-md-12 col-sm-20">
								<section class="registration-area">
									<div class="row">
										<div class="col-sm-8">
											Registration Block Starts
											<div class="panel panel-smart">
												<div class="panel-heading">
													<h3 class="panel-title">회원 정보</h3>
												</div>
												<div class="panel-body">
												<table>
													<tr>
														<th> No. </th>
														<th> 회원 아이디 </th>
														<th> 이름 </th>
														<th> 닉네임 </th>
														<th> 생일 </th>
														<th> 이메일 </th>
														<th> 성별 </th>
														<th> 관리자 여부 </th>
													</tr>
													<td>
													
													</td>
												</table>
												</div>
											</div>
										</div>
									</div>
								</section>
							</div>
						</div>
					</div> -->
					<!-- Tab #3 starts -->
					<div id="storesync" class="tab-pane fade show active">
			<!-- 	Tab #3 Nested Row Starts -->
						<div class="row">
			<!-- 				Left Column Starts -->
							<div class="col-md-12 col-sm-20">
								<section class="registration-area">
									<div class="row">
										<div class="col-sm-8">
			<!-- 								Registration Block Starts -->
											<div class="panel panel-smart">
												<div class="panel-heading">
													<h3 class="panel-title"></h3>
												</div>
												<div class="panel-body">
													<div>
														<form action="${pageContext.request.contextPath }/api/apiSync" method="post">
															<div>
																<button class="btn btn-prime text-uppercase animation text-right">동기화</button>
															</div>
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>
								</section>
							</div>
						</div>
					</div>
				</div>
				
			</div>
			<!-- Menu Tabs End -->
		</div>
		<!-- Mainarea End -->
	</div>
	<!-- Nested Row End -->
</div>
<!-- Main Container End -->	
	

<%@ include file="../include/footer.jspf"%>