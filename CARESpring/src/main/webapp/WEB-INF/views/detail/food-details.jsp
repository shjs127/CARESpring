<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jspf"%>

<style type="text/css">
#wrap {
	width: 800px;
	margin: 0 auto 0 auto;
}

#detailBoard {
	text-align: center;
}

#title {
	height: 16;
	font-family: '돋움';
	font-size: 12;
	text-align: center;
	background-color: #F7F7F7;
}

#btn {
	font-family: '돋움';
	font-size: 14;
	text-align: center;
}

#map {
	width: 100%;
	height: 450px;
	position: relative;
	overflow: hidden;
	/* background: url('./pages/image/loading_n.png'); */
	margin-top: 2%;
}

.inputArea {
	margin: 10px 0;
}

select {
	width: 100px;
}

label {
	display: inline-block;
	width: 70;
	padding: 5px;
}

input {
	width: 150px;
}

.select_img img {
	margin: 20px 0;
}
</style>

<!-- Search Section Starts -->
<section class="search-area condensed parallax">
	<!-- Nested Container Starts -->
	<div class="container text-center">
		<h3 class="text-weight-normal">
			솔직한 리뷰, 믿을 수 있는 평점! <br> 카레
		</h3>
		<form class="top-search"
			action="${pageContext.request.contextPath }/board/storelist.do"
			method="post" name="frm" id="frm">
			<div class="input-group">
				<div class="input-group-prepend search-panel"></div>
				<input type="text" class="form-control input-lg rounded-0"
					name="searchKeyword" id="searchKeyword" placeholder="지역 또는 카페"
					value="${param.searchKeyword}">
				<button class="btn btn-lg btn-prime animation text-uppercase"
					type="submit">검색</button>
			</div>
		</form>
	</div>
	<!-- Nested Container Ends -->
</section>
<!-- Search Section Ends -->

<!-- BreadCrumb Starts -->
<div class="breadcrumb rounded-0">
	<!-- Nested Container Starts -->
	<div class="container text-xs-center text-sm-center text-md-left">
		<ul class="list-unstyled list-inline">
			<li class="list-inline-item"><a
				href="${pageContext.request.contextPath }/main/index.do">홈</a></li>
			<li class="list-inline-item"><a
				href="${pageContext.request.contextPath }/board/storelist.do">매장
					리스트</a></li>
			<li class="active list-inline-item">매장 상세 정보</li>
		</ul>

	</div>
	<!-- Nested Container Ends -->
</div>
<!-- BreadCrumb Ends -->
<!-- Main Container Starts -->
<div class="main-container container">
	<!-- Heading Starts -->
	<h4 class="main-heading-1 text-xs-center text-sm-center text-md-left">
		${storeInfo.storeName}
		<ul class="list-unstyled float-lg-right text-lg-right">
			<li class="list-inline-item">${storeAvg}</li>
		</ul>

		<c:if test="${isExisFavoriteData}">
			<button id="starCheck">
				<ul class="list-unstyled list-inline rating-star-list">
					<li class="list-inline-item"><i class="fa fa-star"></i></li>
				</ul>
			</button>
		</c:if>
		<c:if test="${!isExisFavoriteData}">
			<button id="starCheck">
				<ul class="list-unstyled list-inline rating-star-list">
					<li class="list-inline-item"><i class="fa fa-star-o"></i></li>
				</ul>
			</button>
		</c:if>
	</h4>

	<!-- Heading Ends -->
	<!-- Main Banner Starts -->
	<div class="banner-area"></div>
	<!-- Main Banner Ends -->
	<!-- Nested Row Starts -->
	<div class="row">
		<!-- Mainarea Starts -->
		<div class="col-md-9 col-sm-12">
			<!-- Menu Tabs Starts -->
			<div class="menu-tabs-wrap">

				<!-- Menu Tabs List Starts -->
				<ul
					class="nav nav-tabs nav-menu-tabs text-xs-center text-sm-center text-md-left">
					<li class="nav-item"><a href="#information"
						class="nav-link active" data-toggle="tab">매장 정보</a></li>

					<li class="nav-item"><a href="#reviews" class="nav-link"
						data-toggle="tab">리뷰</a></li>

				</ul>
				<br> <br>


				<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
				<script
					src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
				<script
					src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


				<!-- Menu Tabs List Ends -->
				<!-- Menu Tabs Content Starts -->
				<div class="tab-content">
					<!-- Tab #1 Starts -->
					<div id="information" class="tab-pane fade show active">
						<!-- Tab #2 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-4 col-sm-12">
								<div class="side-block-1">
									<h6>정보</h6>
									<ul class="list-unstyled list-style-2">
										<li>주소 : ${storeInfo.address }</li>
										<li>영업시간 : ${storeInfo.hours }</li>
										<li>휴무일 : ${storeInfo.closedDays }</li>
										<li>전화번호 : ${storeInfo.callNumber }</li>
									</ul>
									<hr>
									&ensp;&ensp;총 좌석 수: <span class="float-right text-spl-color">${detailInfo.totalSeat }개&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;충전기가 있는 좌석 수: <span
										class="float-right text-spl-color">${detailInfo.socketSeat }개&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;디저트: <span class="float-right text-spl-color">${detailInfo.dessertSales }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;테라스: <span class="float-right text-spl-color">${detailInfo.terrace }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;루프탑: <span class="float-right text-spl-color">${detailInfo.roofTop }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;와이파이: <span class="float-right text-spl-color">${detailInfo.wifi }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;애견동반: <span class="float-right text-spl-color">${detailInfo.companionDog }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;주차공간: <span class="float-right text-spl-color">${detailInfo.parkingSpace }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;노키즈존: <span class="float-right text-spl-color">${detailInfo.noKidsZone }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;흡연존: <span class="float-right text-spl-color">${detailInfo.smokingArea }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
								</div>

							</div>
							<!-- Left Column Ends -->
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Information Tab Pane Starts -->
								<div class="information-tab-pane">
									<p class="text-center"></p>
									<!-- Spacer Starts -->
									<!-- Spacer Ends -->

									<!-- 지도를 보여주는 html -->
									<div id="map"></div>

									<!-- 자바스크립트 -->
									<script type="text/javascript"
										src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ecfa9545ea95f1247efbf60cf9429d4c&libraries=services"></script>
									<script>
										var storeAddress = "${storeInfo.address}";
										var storeName = "${storeInfo.storeName}";
										var mapContainer = document
												.getElementById('map'), // 지도를 표시할 div 
										mapOption = {
											center : new daum.maps.LatLng(
													33.450701, 126.570667), // 지도의 중심좌표 
											level : 3
										// 지도의 확대 레벨 
										};
										// 지도를 생성합니다 
										var map = new daum.maps.Map(
												mapContainer, mapOption);
										// 주소-좌표 변환 객체를 생성합니다 
										var geocoder = new daum.maps.services.Geocoder();

										// 주소로 좌표를 검색합니다 
										geocoder
												.addressSearch(
														storeAddress,
														function(result, status) {
															// 정상적으로 검색이 완료됐으면 
															if (status === daum.maps.services.Status.OK) {
																var coords = new daum.maps.LatLng(
																		result[0].y,
																		result[0].x);
																// 결과값으로 받은 위치를 마커로 표시합니다 
																var marker = new daum.maps.Marker(
																		{
																			map : map,
																			position : coords
																		});
																// 인포윈도우로 장소에 대한 설명을 표시합니다 
																var infowindow = new daum.maps.InfoWindow(
																		{
																			content : '<div style="width:150px;text-align:center;padding:6px 0;">'
																					+ storeName
																					+ '</div>'
																		});
																infowindow
																		.open(
																				map,
																				marker);

																// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다 
																map.relayout();
																map
																		.setCenter(coords);
																// 												map.setLevel(4);
																// 												map.setLevel(3);
																// 												map.relayout();
																// 												setTimeout(function(){ 
																// 													map.relayout(); 
																// 												}, 0);
															}
														});
									</script>


									<!-- Spacer Starts -->
									<!-- Spacer Ends -->
									<!-- Banners Starts -->
									<!-- Banners Ends -->
								</div>
								<!-- Information Tab Pane Ends -->
							</div>
							<!-- Right Column Ends -->
						</div>
						<!-- Tab #2 Nested Row Ends -->
					</div>
					<!-- Tab #1 Ends -->
					<!-- Tab #2 Starts -->
					<div id="menu" class="tab-pane fade">

						<!-- Tab #1 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-4 col-sm-12">
								<!-- 								<script> -->
								// function wishList1() { // let answer = confirm("로그인이
								필요합니다."); // if (answer == true) { // location.href =
								"/CARE/login.do"; // } else if (answer != true) { // } // } //
								$(function() { // $("#starCheck") // .on( // "click", //
								function() { // var storeNo = "${storeinfo[0].storeNo}"; // var
								userNo = "${authUser[0].userNo}"; // var sendData = 'storeNo='
								// + storeNo // + '&userNo=' // + userNo; // if (userNo == "") {

								// let answer = confirm("로그인이 필요합니다."); // if (answer == true) {
								// location.href = "/CARE/login.do"; // } else if (answer !=
								true) { // } // } // $ // .ajax({ // url : "favorite.do", //
								type : "POST", // data : sendData, // success : function() { //
								location // .reload(); // } // }); // }); // });
								<!-- 								</script> -->

								<br>
							</div>

							<!-- Left Column Ends -->
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Order Menu Tab Pane Starts -->
								<div
									class="order-menu-tab-pane text-xs-center text-sm-center text-md-left">
									<p class="text-center"></p>
									<!-- Order Menu List #1 Starts -->


									<div class="spacer"></div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<div class="order-menu-item clearfix"></div>
									<div class="order-menu-item clearfix"></div>
									<div class="order-menu-item clearfix"></div>
									<!-- Order Menu List #1 Ends -->
									<!-- Spacer Starts -->
									<div class="spacer big"></div>
									<!-- Spacer Ends -->
									<!-- Order Menu List #2 Starts -->

									<div class="order-menu-item clearfix"></div>
									<div class="order-menu-item clearfix"></div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<!-- Order Menu List #2 Ends -->
									<!-- Spacer Starts -->
									<div class="spacer big"></div>
									<!-- Spacer Ends -->
									<!-- Order Menu List #3 Starts -->

									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<!-- Order Menu List #3 Ends -->
								</div>
								<!-- Order Menu Tab Pane Ends -->
								<!-- Pagination Starts -->
								<div class="pagination-block clearfix"></div>
								<!-- Pagination Ends -->
								<!-- Banners Starts -->
								<div class="row text-center">
									<div class="col-6"></div>
									<div class="col-6"></div>
								</div>
								<!-- Banners Ends -->
							</div>
							<!-- Right Column Ends -->
						</div>
						<!-- Tab #1 Nested Row Ends -->

					</div>
					<!-- Tab #2 Ends -->


					<!-- Tab #3 Starts -->
					<div id="gallery" class="tab-pane fade">
						<!-- Image Gallery Starts -->

						<!-- Image Gallery Ends -->
					</div>
					<!-- Tab #3 Ends -->
					<!-- Tab #4 Starts -->
					<div id="reviews" class="tab-pane fade">

						<!-- Tab #4 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-4 col-sm-12">
								<div class="side-block-1">
									<h6>정보</h6>
									<ul class="list-unstyled list-style-2">
										<li>주소 : ${storeInfo.address }</li>
										<li>영업시간 : ${storeInfo.hours }</li>
										<li>휴무일 : ${storeInfo.closedDays }</li>
										<li>전화번호 : ${storeInfo.callNumber }</li>
									</ul>
									<hr>
									&ensp;&ensp;총 좌석 수: <span class="float-right text-spl-color">${detailInfo.totalSeat }개&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;충전기가 있는 좌석 수: <span
										class="float-right text-spl-color">${detailInfo.socketSeat }개&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;디저트: <span class="float-right text-spl-color">${detailInfo.dessertSales }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;테라스: <span class="float-right text-spl-color">${detailInfo.terrace }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;루프탑: <span class="float-right text-spl-color">${detailInfo.roofTop }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;와이파이: <span class="float-right text-spl-color">${detailInfo.wifi }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;애견동반: <span class="float-right text-spl-color">${detailInfo.companionDog }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;주차공간: <span class="float-right text-spl-color">${detailInfo.parkingSpace }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;노키즈존: <span class="float-right text-spl-color">${detailInfo.noKidsZone }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;흡연존: <span class="float-right text-spl-color">${detailInfo.smokingArea }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
								</div>
							</div>
							<!-- Left Column Ends -->
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Reviews Tab Pane Starts -->
								<div class="reviews-tab-pane">

									<!-- Reviews Form Box Starts -->
									<div class="reviews-form-box">
										<h6>리뷰쓰기</h6>

										<section class="content">

											<!-- Default box -->

											<div class="box-body">


												<div class="box-body">


													<%
														// 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
													if (session.getAttribute("login") == null && session.getAttribute("storein") == null) {
													%>
													<input type="submit" value="리뷰쓰기"
														class="btn btn-black animation text-uppercase float-right"
														onclick="rlogin()" /></a> <br>

													<%
														}
													// 현재 로그인된 아이디가 있다면 (= session에 저장된 id가 있다면)
													else if (session.getAttribute("login") != null) {
													%>


													<form
														action="/care/store/storeList/detail?storeNo=${storeInfo.storeNo}"
														method="post" id="writeForm" enctype="multipart/form-data">

														<p>
															<textarea name="reviewContents" cols="60" rows="10"
																placeholder="리뷰를 작성하세요"></textarea>
														</p>

														<h9>별점을 선택하세요.</h9>
														<select name="avgScore">

															<option value="1">★☆☆☆☆</option>
															<option value="2">★★☆☆☆</option>
															<option value="3">★★★☆☆</option>
															<option value="4">★★★★☆</option>
															<option value="5" selected>★★★★★</option>
														</select> <br> <br>
														<p>
															<input type="submit" value="리뷰쓰기"
																class="btn btn-black animation text-uppercase float-right" />
														</p>


														<div class="inputArea">
															<label for="preView">이미지</label> <input type="file"
																id="preView" name="file" />
															<div class="select_img">
																<img src="" />
															</div>
												
														</div>
													</form>

													<%
														}
													%>

												</div>
											</div>
										</section>


									</div>
									<!-- Content Wrapper. Contains page content -->
									<div class="content-wrapper">
										<!-- Content Header (Page header) -->
										<section class="content-header"></section>

										<!-- Main content -->

										<!-- Default box -->
										<div class="box">

											<div class="review-list">
												<c:if test="${view.isEmpty()}">
													<p>등록된 메시지가 없습니다.</p>
												</c:if>
												<c:if test="${!view.isEmpty()}">
													<table border="1">
														<div class="review-list-content">
															<c:forEach var="reviewInfo" items="${reviewDTO}">
																<p>
																	<i class="fa fa-calendar"> ${reviewInfo.reviewDate}</i>
																</p>
																<p>닉네임: ${reviewInfo.nickName}</p>
																<p>리뷰 내용: ${reviewInfo.reviewContents}</p>
																<p>평점: ${reviewInfo.avgScore}</p>
																<p>리뷰 번호: ${reviewInfo.reviewNo}</p>
																<p>
																	
																	<c:if test="${!reviewInfo.pFile.isEmpty()}">

																		<img
																			src="${pageContext.request.contextPath}/resources/upLoad/${reviewInfo.pFile}"
																			width="200" />

																	</c:if>
																</p>
																<p>
																<form action="storeList/deleteReview" method="post"
																	id="deleteForm" enctype="multipart/form-data">
																	<input type="button" value="수정"
																		onclick="modifyReview(${reviewInfo.reviewNo})">
																	<input type="button" value="삭제" onclick="deleteReview(${reviewInfo.reviewNo})">
																</form>
															</c:forEach>
														</div>
													</table>

												</c:if>
											</div>
										</div>

									</div>

								</div>
							</div>
						</div>
					</div>
					<!-- Reviews Form Box Ends -->
					<!-- Reviews List Starts -->
					<!-- Default box -->
					<div class="box">

						<div class="box-body">

							<div class="reviews-box">

								<!-- Review #1 Starts -->
								<div class="review-list">
									<div class="clearfix">
										<div class="float-left"></div>



									</div>
									<div class="review-list-content"></div>
								</div>
								<!-- Review #1 Ends -->
								<!-- Review #2 Starts -->
								<div class="review-list">
									<div class="clearfix">
										<div class="float-left"></div>

									</div>
									<div class="review-list-content"></div>
								</div>
								<!-- Review #2 Ends -->
								<!-- Review #3 Starts -->
								<div class="review-list">
									<div class="clearfix">
										<div class="float-left"></div>

									</div>
									<div class="review-list-content"></div>
								</div>
								<!-- Review #3 Ends -->
								<!-- Review #4 Starts -->
								<div class="review-list">
									<div class="clearfix">
										<div class="float-left"></div>

									</div>
									<div class="review-list-content"></div>
								</div>
								<!-- Review #4 Ends -->
							</div>
							<!-- Reviews List Ends -->
							<!-- Spacer Starts -->
							<div class="spacer-1 condensed"></div>
							<!-- Spacer Ends -->
							<!-- Banners Starts -->
							<div class="row text-center">
								<div class="col-6"></div>
								<div class="col-6"></div>
							</div>
							<!-- Banners Ends -->
						</div>
						<!-- Reviews Tab Pane Ends -->
					</div>
					<!-- Right Column Ends -->
				</div>
				<!-- Tab #4 Nested Row Ends -->
			</div>
			<!-- Tab #4 Ends -->
			<!-- Tab #5 Starts -->
			<div id="reachus" class="tab-pane fade">
				<!-- Tab #5 Nested Row Starts -->
				<div class="row">
					<!-- Left Column Starts -->

					<!-- Tab #5 Nested Row Ends -->
				</div>
				<!-- Tab #5 Ends -->
			</div>
		</div>
		<div class="col-md-3 col-sm-12">
			<!-- Spacer Starts -->
			<div class="spacer-1 medium d-xs-block d-sm-block d-md-none"></div>
			<!-- Spacer Ends -->
			<!-- Your Order Starts -->
			<div class="side-block-order border-radius-4">
				<!-- Heading Starts -->
				<h6 class="text-center">가게 메뉴</h6>


				<!-- Order Content Starts -->
				<div class="side-block-order-content">
					<c:forEach var="menuInfo" items="${menuInfo}">
						<ul class="list-unstyled order-item-list">
							<li class="clearfix"><span class="float-left">
									${menuInfo.menu} </span> <span class="float-right text-sql-color">${menuInfo.price}￦</span>
							</li>
						</ul>
					</c:forEach>
				</div>


			</div>
		</div>

	</div>
</div>




<script>

	function deleteReview(revReq) {
		var chk = confirm("정말 삭제하시겠습니까?");
		if (chk) {
			location.href='deleteReview?seq='+ revReq;
		}
		
	}	 
	
	function modifyReview(revReq) {
			location.href='modifyReview?seq='+revReq;
	}	 
	
	function rlogin(seq) {
		var chk = confirm("로그인이 필요합니다.");
		if (chk) {
			window.location.href='login';
			
		}
	}	
	
	$(function() {
		$("#writeForm").submit(function() {
			if ($("#reviewContents").val() == "") {
				alert("리뷰 내용을 입력하세요!");
				$("#reviewContents").focus();
				return false;
			}
		});
	});
</script>


<script>
  $("#preView").change(function(){
   if(this.files && this.files[0]) {
    var reader = new FileReader;
    reader.onload = function(data) {
     $(".select_img img").attr("src", data.target.result).width(500);        
    }
    reader.readAsDataURL(this.files[0]);
   }
  });
 </script>


<%@ include file="../include/footer.jspf"%>