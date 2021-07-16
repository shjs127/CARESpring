<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../include/header.jspf"%>

<!-- Search Section Starts -->
<section class="search-area condensed parallax">
	<!-- Nested Container Starts -->
	<div class="container text-center">
		<h3 class="text-weight-normal">
			솔직한 리뷰, 믿을 수 있는 평점! <br> 카레
		</h3>
		<form class="top-search"
			action="${pageContext.request.contextPath }/store/storeList"
			method="post" name="frm" id="frm">
			<div class="input-group">
				<div class="input-group-prepend search-panel"></div>
				<input type="text" class="form-control input-lg rounded-0"
					name="Keyword" id="Keyword" placeholder="지역 또는 카페"
					value="${param.Keyword}">
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
			<li class="list-inline-item"><a href="${pageContext.request.contextPath }/main/index.do">홈</a></li>
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
					<option value="orderStoreNo" <c:if test="${param.orderBy == 'orderStoreNo'}" > selected </c:if>>번호순</option>
					<option value="orderAvgScore" <c:if test="${param.orderBy == 'orderAvgScore'}" > selected </c:if>>평점순</option>
					<option value="orderReviewCnt" <c:if test="${param.orderBy == 'orderReviewCnt'}" > selected </c:if>>리뷰순</option>
				</select>
				<!-- Sort By Field Ends -->
				<!-- Filter By Restaurants Starts -->
				<h6 class="sidearea-filter-title">Filter By cafe</h6>
				<div class="sidearea-filter-checkbox-list">
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option1"> 총 테이블 수
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option2"> 콘센트 테이블 수
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option3"> 디저트 판매
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option4"> 테라스
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option5"> 루프탑
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option6"> 와이파이
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option7"> 애견 동반
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option8"> 주차 공간
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option9"> 노키즈존
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option10"> 흡연구역
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

					<c:if test="${storePage.hasNoStores()}">
						<div>매장이 없습니다.</div>
					</c:if>

					<c:forEach var="storeinfo" items="${list}">
						<div class="col-lg-4 col-md-6 col-sm-12">
							<!-- Grid Box Starts -->
							<div class="grid-box">
								<!-- Images Starts -->
								<div class="image text-center">
									<img
										src="<%=request.getContextPath()%>/resources/images/hotels/thumb/hotel-grid-thumb-img1.jpg"
										alt="Eagle Boys Village Plaza" class="img-fluid img-center">
									<span class="delivery-time">${storeinfo.storeNo}</span>
								</div>

								<!-- Images Ends -->
								<!-- Content Starts -->
								<div class="content text-center text-lg-left">
									<!-- Title Starts -->
									<h6 class="grid-box-title">
										<a href="storeList/detail?storeNo=${storeinfo.storeNo}">${storeinfo.storeName}</a>
									</h6>
									<!-- Title Ends -->
									<!-- Tags Starts -->
									<ul class="list-unstyled list-inline grid-box-tags">
										<li class="list-inline-item">
								 			<c:choose>
											<c:when test = "${fn:length(storeinfo.address) gt 22}">
											<c:out value = "${fn:substring(storeinfo.address,0,21)}..."></c:out>
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
										<li class="float-lg-right text-lg-right"><a href="/storeList/detail?storeNo=${storeinfo.storeNo}"
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
			<%-- <c:if test="${storePage.hasStores()}">
				<div class="pagination-block clearfix">
					<ul class="pagination animation float-lg-right">
						<c:if test="${storePage.startPage > 5}">
							<c:if test="${Keyword == null}">
								<c:if test="${orderBy == null || orderBy != null}">
									<li class="page-item">
										<a href="storelist.do?pageNo=${storePage.startPage -5}&orderBy=${orderBy}"
											class="page-link">&laquo;</a></li>
								</c:if>
							</c:if>
							<c:if test="${Keyword != null}">
								<c:if test="${orderBy == null || orderBy != null}">
									<li class="page-item"><a
									href="storelist?pageNo=${storePage.startPage -5}&searchKeyword=${Keyword}&orderBy=${orderBy}"
									class="page-link">&laquo;</a></li>
								</c:if>
							</c:if>
						</c:if>
						<c:forEach var="pNo" begin="${storePage.startPage}"
							end="${storePage.endPage}">
							<c:if test="${Keyword == null}">
								<c:if test="${orderBy == null || orderBy != null}">
									<c:if test="${pNo == storePage.currentPage }">
										<li class="page-item active"><a href="storelist.do?pageNo=${pNo}&orderBy=${orderBy}"
									class="page-link">${pNo}</a></li>
									</c:if>
									<c:if test="${pNo != storePage.currentPage }">
										<li class="page-item"><a href="storelist.do?pageNo=${pNo}&orderBy=${orderBy}"
									class="page-link">${pNo}</a></li>
									</c:if>
								</c:if>
							</c:if>
							<c:if test="${Keyword != null}">
								<c:if test="${orderBy == null || orderBy != null}">
									<c:if test="${pNo == storePage.currentPage }">
										<li class="page-item active"><a href="storelist.do?pageNo=${pNo}&searchKeyword=${Keyword}&orderBy=${orderBy}"
									class="page-link">${pNo}</a></li>
									</c:if>
									<c:if test="${pNo != storePage.currentPage }">
										<li class="page-item"><a href="storelist.do?pageNo=${pNo}&searchKeyword=${Keyword}&orderBy=${orderBy}"
									class="page-link">${pNo}</a></li>
									</c:if>
								</c:if>
							</c:if>
							
						</c:forEach>
						<c:if test="${storePage.endPage < storePage.totalPages}">
							<c:if test="${Keyword == null}">
								<c:if test="${orderBy == null || orderBy != null}">
									<li class="page-item"><a
										href="storelist.do?pageNo=${storePage.startPage + 5}&orderBy=${orderBy}"
										class="page-link">&raquo;</a></li>
								</c:if>
							</c:if>
							<c:if test="${Keyword != null}">
								<c:if test="${orderBy == null || orderBy != null}">
									<li class="page-item"><a
									href="storelist.do?pageNo=${storePage.startPage + 5}&searchKeyword=${Keyword}&orderBy=${orderBy}"
									class="page-link">&raquo;</a></li>
								</c:if>
							</c:if>
						</c:if>
					</ul>
				</div>
			</c:if> --%>
			<!-- 페이징 처리 End -->
		</div>
		<!-- Mainarea Ends -->
	</div>
	<!-- Ends -->
</div>
<!-- Main Container Ends -->

<script type="text/javascript">
	$(function(){
		$("#frm").submit(function(){
			if($("#searchKeyword").val() == ""){
				alert("검색어를 입력하세요!");
				$("#searchKeyword").focus();
				return false;
			}
		});
	});
</script>

<script>
	$(function(){
		$("#orderBy").change(function(){
			var orderby = $(this).val();
			var searchKeyword = $('#searchKeyword').val();
			
			$(location).attr('href', '${pageContext.request.contextPath}/board/storelist.do?orderBy='+orderby+'&searchKeyword='+searchKeyword);
		});
	});
</script>
<%@ include file="../include/footer.jspf"%>