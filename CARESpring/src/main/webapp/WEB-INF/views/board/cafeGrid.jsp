<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../include/header.jspf"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<!-- Search Section Starts -->
<section class="search-area condensed parallax">
	<!-- Nested Container Starts -->
	<div class="container text-center">
		<h3 class="text-weight-normal">
			솔직한 리뷰, 믿을 수 있는 평점! <br> 카레
		</h3>
		<form class="top-search"
			action="${pageContext.request.contextPath }/store/storeList"
			method="get" name="frm" id="frm">
			<div class="input-group">
				<div class="input-group-prepend search-panel"></div>
				<input type="text" class="form-control input-lg rounded-0"
					name="keyword" id="keyword" placeholder="지역 또는 카페"
					value="${scri.keyword}">
				<button class="btn btn-lg btn-prime animation text-uppercase" id="searchBtn"
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
			<li class="list-inline-item"><a href="${pageContext.request.contextPath }/index">홈</a></li>
			<li class="active list-inline-item">매장 리스트</li>
		</ul>
	</div>
	<!-- Nested Container Ends -->
</div>
<!-- BreadCrumb Ends -->
<!-- Main Container Starts -->
<div class="main-container container">
	<!-- Heading Starts -->
	<h4 class="main-heading-1 text-xs-center text-sm-center text-md-left">
		솔직한 평점과 리뷰를 구경해 보세요 !
		<!-- <br
			class="d-xs-block d-sm-block d-md-none"> <a href="#"
			class="btn btn-main animation" data-toggle="modal"
			data-target="#change-location">Change Location <i
			class="fa fa-angle-double-right"></i></a> -->
	</h4>
	<!-- Heading Ends -->
	<!-- Starts -->
	<div class="row">
		<!-- Sidearea Starts -->
		<div class="col-lg-3 col-md-4 col-sm-12">
			<!-- Sidearea Filters Starts -->
			<div class="sidearea-filter">
				<!-- Sort By Field Starts -->
				<select class="form-control rounded-0 sidearea-filter-sort" id="orderBy" name="orderBy">
					<option value="" disabled>정렬</option>
					<option value="STORENO" <c:if test="${scri.orderBy == 'STORENO'}" > selected </c:if>>번호순</option>
					<option value="AVGSCORE" <c:if test="${scri.orderBy == 'AVGSCORE'}" > selected </c:if>>평점순</option>
					<option value="REVIEWCNT" <c:if test="${scri.orderBy == 'REVIEWCNT'}" > selected </c:if>>리뷰순</option>
				</select>
				<!-- Sort By Field Ends -->
				<!-- Filter By Restaurants Starts -->
				<h6 class="sidearea-filter-title">Filter By cafe</h6>
				<div class="sidearea-filter-checkbox-list">
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="detailChk" value="totalSeat"> 총 테이블 수
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="detailChk" value="socketSeat"> 콘센트 테이블 수
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="detailChk" value="dessertSales"> 디저트 판매
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="detailChk" value="terrace"> 테라스
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="detailChk" value="rooftop"> 루프탑
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="detailChk" value="wifi"> 와이파이
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="detailChk" value="companionDog"> 애견 동반
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="detailChk" value="parkingSpace"> 주차 공간
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="detailChk" value="noKidsZone"> 노키즈존
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="detailChk" value="smokingArea"> 흡연구역
						</label>
					</div>
				</div>
				<!-- Filter By Restaurants Ends -->
			</div>
			<!-- Sidearea Filters Ends -->
			<!-- Spacer For Smaller Devices -->
			<p class="d-xs-block d-sm-block d-md-none">
				<br>
			</p>
			<!-- Spacer For Smaller Ends -->
		</div>
		<!-- Sidearea Ends -->
		<!-- Mainarea Starts -->
		<div class="col-lg-9 col-md-8 col-sm-12">
			<!-- Hotels Grid List Starts -->
			<div class="hotels-list-grid">
				<!-- Nested Row Starts -->
				<div class="row">
					<!-- List Box #1 Starts -->
					<!-- List 시작 -->

					<c:if test="${list == null}">
						<div>매장이 없습니다.</div>
					</c:if>
			
						<div id="cafeStoreDiv"></div>
					<c:forEach var="storeinfo" items="${list}">
						<div class="col-lg-4 col-md-6 col-sm-12 cafeStoreList">
							<!-- Grid Box Starts -->
							<div class="grid-box">
								<!-- Images Starts -->
									<div class="image text-center">
									<c:if test="${storeinfo.storePic ne null}">
							<img
							src="${pageContext.request.contextPath}/disFile?fileName=${storeinfo.storePic}"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
							</c:if>
							<c:if test="${storeinfo.storePic eq null}">
							<img
							src="${pageContext.request.contextPath}/resources/upLoad/imgnull.jpg"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
							</c:if>
									<span class="delivery-time">${storeinfo.storeNo}</span>
								</div>

								<!-- Images Ends -->
								<!-- Content Starts -->
								<div class="content text-center text-lg-left">
									<!-- Title Starts -->
									<h6 class="grid-box-title">
										<a href="${pageContext.request.contextPath}/store/storeList/detail?storeNo=${storeinfo.storeNo}">
										<c:choose>
										<c:when test = "${fn:length(storeinfo.storeName) gt 13}">
										<c:out value = "${fn:substring(storeinfo.storeName,0,12)}..."></c:out>
										</c:when>
										<c:otherwise>
										<c:out value="${storeinfo.storeName}"></c:out>
										</c:otherwise>
										</c:choose>
										</a>
									</h6>
									<!-- Title Ends -->
									<!-- Tags Starts -->
									<ul class="list-unstyled list-inline grid-box-tags">
										<li class="list-inline-item">
								 			<c:choose>
											<c:when test = "${fn:length(storeinfo.address) gt 16}">
											<c:out value = "${fn:substring(storeinfo.address,0,15)}..."></c:out>
											</c:when>
											<c:otherwise>
											<c:out value="${storeinfo.address}"></c:out>
											</c:otherwise>
											</c:choose>
										</li>
									</ul>
									<!-- Tags Ends -->
									<!-- Offer Details Starts -->
									<ul class="list-unstyled grid-box-info clearfix">
										<li class="float-lg-right text-lg-right"><a href="${pageContext.request.contextPath}/store/storeList/detail?storeNo=${storeinfo.storeNo}"
											class="btn btn-prime animation"> 자세히 보기 <i
												class="fa fa-chevron-right"></i>
										</a></li>
									</ul>
									<!-- Offer Details Ends -->
									<!-- Links Starts -->
									<div class="clearfix">
										<!-- Info Links Starts -->
										<ul
											class="list-unstyled list-inline grid-box-info-links float-lg-left">
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top" title="Coupons"><i
													class="fa fa-tag"></i></a></li>
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top"
												title="Information"><i class="fa fa-info-circle"></i></a></li>
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top" title="Reviews"><i
													class="fa fa-star-half-full"></i></a></li>
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top" title="Specials"><i
													class="fa fa-asterisk"></i></a></li>
										</ul>
										<!-- Info Links Ends -->
										<!-- Ratings Starts -->
										<ul
											class="list-unstyled list-inline grid-box-ratings float-lg-right text-lg-right">
											<li class="list-inline-item star-rating"><i
												class="fa fa-star"></i> 45</li>
											<li class="list-inline-item"><a href="#"
												class="badge animation"><i class="fa fa-heart"></i> 10</a></li>
										</ul>
										<!-- Ratings Ends -->
									</div>
									<!-- Links Ends -->
								</div>
								<!-- Content Ends -->
							</div>
							<!-- Grid Box Ends -->
						</div>
						<!-- List Box #1 Ends -->
					</c:forEach>
				</div>
				<!-- Nested Row Ends -->
			</div>
			<!-- Hotels Grid List Ends -->
			<!-- 페이징 처리 -->
			<div class="pagination-block clearfix">
				<ul class="pagination animation float-lg-right">
					<c:if test="${pageMaker.prev}">
						<li class="page-item"><a href="${pageContext.request.contextPath }/store/storeList${pageMaker.makeSearch(pageMaker.startPage - 1) }" class="page-link">&laquo;</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
						<li 
							<c:out value="${pageMaker.cri.page == idx?'class=page-item active':'class=page-item '}"/>>
							<a href="${pageContext.request.contextPath }/store/storeList${pageMaker.makeSearch(idx)}" class="page-link">${idx}</a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li class="page-item"><a
							href="${pageContext.request.contextPath }/store/storeList${pageMaker.makeSearch(pageMaker.endPage +1) }" class="page-link">&raquo;</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<!-- Mainarea Ends -->
	</div>
	<!-- Ends -->
</div>
<!-- Main Container Ends -->

<!-- ajax 리스트 -->
<script id="template" type="text/x-handlebars-template">
{{#each .}}
						<div class="col-lg-4 col-md-6 col-sm-12 cafeStoreList">
							<!-- Grid Box Starts -->
							<div class="grid-box">
								<!-- Images Starts -->
									<div class="image text-center">
									<c:if test="${storeinfo.storePic ne null}">
							<img
							src="${pageContext.request.contextPath}/disFile?fileName=${storeinfo.storePic}"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
							</c:if>
							<c:if test="${storeinfo.storePic eq null}">
							<img
							src="${pageContext.request.contextPath}/resources/upLoad/imgnull.jpg"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
							</c:if>
									<span class="delivery-time">{{storeNo}}</span>
								</div>

								<!-- Images Ends -->

								<!-- Content Starts -->
								<div class="content text-center text-lg-left">
									<!-- Title Starts -->
									<h6 class="grid-box-title">
										<a href="${pageContext.request.contextPath}/store/storeList/detail?storeNo={{storeNo}}">{{storeName}}</a>
									</h6>
									<!-- Title Ends -->
									<!-- Tags Starts -->
									<ul class="list-unstyled list-inline grid-box-tags">
										<li class="list-inline-item">
								 			<c:choose>
											<c:when test = "${fn:length({{address}}) gt 20}">
											<c:out value = "${fn:substring({{address}},0,19)}..."></c:out>
											</c:when>
											<c:otherwise>
											<c:out value="{{address}}"></c:out>
											</c:otherwise>
											</c:choose>
										</li>
									</ul>
									<!-- Tags Ends -->
									<!-- Offer Details Starts -->
									<ul class="list-unstyled grid-box-info clearfix">
										<li class="float-lg-right text-lg-right"><a href="${pageContext.request.contextPath}/store/storeList/detail?storeNo={{storeNo}}"
											class="btn btn-prime animation"> 자세히 보기 <i
												class="fa fa-chevron-right"></i>
										</a></li>
									</ul>
									<!-- Offer Details Ends -->
									<!-- Links Starts -->
									<div class="clearfix">
										<!-- Info Links Starts -->
										<ul
											class="list-unstyled list-inline grid-box-info-links float-lg-left">
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top" title="Coupons"><i
													class="fa fa-tag"></i></a></li>
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top"
												title="Information"><i class="fa fa-info-circle"></i></a></li>
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top" title="Reviews"><i
													class="fa fa-star-half-full"></i></a></li>
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top" title="Specials"><i
													class="fa fa-asterisk"></i></a></li>
										</ul>
										<!-- Info Links Ends -->
										<!-- Ratings Starts -->
										<ul
											class="list-unstyled list-inline grid-box-ratings float-lg-right text-lg-right">
											<li class="list-inline-item star-rating"><i
												class="fa fa-star"></i> 45</li>
											<li class="list-inline-item"><a href="#"
												class="badge animation"><i class="fa fa-heart"></i> 10</a></li>
										</ul>
										<!-- Ratings Ends -->
									</div>
									<!-- Links Ends -->
								</div>
								<!-- Content Ends -->
							</div>
							<!-- Grid Box Ends -->
						</div>
						<!-- List Box #1 Ends -->
{{/each}}
</script>

<script>
	var printData = function(storeArr, target, templateObject){
		
		var template = Handlebars.compile(templateObject.html());
	
		var html = template(storeArr)
		$(".cafeStoreList").remove();
		target.after(html);
	}
	
// 	var storeno = ${storeinfo.storeNo}
	
	var storePage = 1;
	
	function getPage(pageInfo){
	
		$.getJSON(pageInfo, function(data){
			printData(data.list, $("#cafeStoreDiv"), $('#template'));
			printPaging(data.pageMaker, $(".pagination"));
			
		});
	}
	
	var printPaging = function(pageMaker, target) {
		
		var str = "";
		
		if(pageMaker.prev) {
			str += "<li class='page-item'><a href='${pageContext.request.contextPath }/store/storeList?page=" + (pageMaker.startPage - 1) 
					+ "' class='page-link'> << </a></li>";
		}
		
		for(var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++){
			var strClass = pageMaker.cri.page == i ? 'class=page-item active' : 'class="page-item"';
			str += "<li " + strClass +"><a href='${pageContext.request.contextPath }/store/storeList?page=" + i +"' class='page-link'>" + i + "</a><li>";
		}
		
		if(pageMaker.next){
			str += "<li class='page-item'><a href='${pageContext.request.contextPath }/store/storeList?page=" + (pageMaker.endPage + 1)
					+ "' class='page-link'> >> </a></li>";
		}
		
		target.html(str);
		
	};

</script>

<script type="text/javascript">

	$(function(){
		$("#frm").submit(function(){
			if($("#keyword").val() == ""){
				alert("검색어를 입력하세요!");
				$("#keyword").focus();
				return false;
			}else{
				self.location = "${pageContext.request.contextPath}/store/storeList"
						+ '${pageMaker.makeQuery(1)}'
						+ '&keyword='+ $("#keyword").val();
			}
		});
	}); 

 	$(function(){
 		$("#orderBy").change(function(){
 			var orderby = $(this).val();
 			var keyword = $('#keyword').val();

 			self.location = "${pageContext.request.contextPath}/store/storeList"
						+ '${pageMaker.makeQuery(1)}'
						+ '&keyword='+$("#keyword").val()
						+ '&orderBy='+$("#orderBy").val();
 		});
 	});
 	
	$(function(){
		var chkArr = [];
		$(".detailCheckBox").change(function(){
			if($(this)[0].checked){
				chkArr.push($(this).val());
			}else{
				chkArr.splice(chkArr.indexOf($(this).val()), 1);
			}
			$.ajaxSettings.traditional = true;
			$.ajax({
				url: '${pageContext.request.contextPath}/store/storeList/detailChk'
				, type: 'get'
				, dataType: 'text'
				, data: {
					valueArr: chkArr
				}, success: function(data){
					var jdata = JSON.parse(data);
					printData(jdata.list, $("#cafeStoreDiv"), $('#template'));
					printPaging(jdata.pageMaker, $(".pagination"));
					
				}, error: function(request, status, error){
					alert("code="+request.status + " message = " + request.responseText + " error = " + error);
				}
			});
		});
		
 	}); 
</script>
	

<%@ include file="../include/footer.jspf"%>