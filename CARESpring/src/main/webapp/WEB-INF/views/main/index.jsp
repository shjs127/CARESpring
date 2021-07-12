<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jspf"%>
<!-- Header Ends -->
<!-- Main Menu Starts -->

<!-- Main Menu Ends -->
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
<!-- Intro Section Ends -->
<section class="welcome section">
	<!-- Nested Container Starts -->
	<div class="container">
		<hr>
		<h4>평점 Top
		<a href="${pageContext.request.contextPath}/board/storelist.do?orderBy=orderAvgScore"
			class="btn btn-prime text-weight-bold text-uppercase animation">더보기</a>
			</h4>
		<div class="food-menu-grid row text-center">
			<!-- Food Menu #1 Starts -->
			<c:forEach var="storea" items="${storageAvgTop}">
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="hover-content">
						<a
							href="${pageContext.request.contextPath}/main/foodDetail.do?storeno=${storea.storeNo}">
							<img
							src="<%=request.getContextPath()%>/CARE/images/hotels/thumb/hotel-grid-thumb-img1.jpg"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
						</a> <a
							href="${pageContext.request.contextPath}/main/foodDetail.do?storeno=${storea.storeNo}">
							<h5 class="text-uppercase">${storea.storeName}
								${storea.storeAvg}</h5>
						</a>
					</div>
				</div>
			</c:forEach>
			<!-- Food Menu #1 Ends -->
		</div>
		<hr>
		<h4>
			리뷰 Top <a href="${pageContext.request.contextPath}/board/storelist.do?orderBy=orderReviewCnt"
				class="btn btn-prime text-weight-bold text-uppercase animation">더보기</a>
		</h4>
		<div class="food-menu-grid row text-center">
			<!-- Food Menu #1 Starts -->
			<c:forEach var="reviewT" items="${reviewTop}">
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="hover-content">
						<a
							href="${pageContext.request.contextPath}/main/foodDetail.do?storeno=${reviewT.storeNo}">
							<img
							src="<%=request.getContextPath()%>/CARE/images/hotels/thumb/hotel-grid-thumb-img1.jpg"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
						</a> <a
							href="${pageContext.request.contextPath}/main/foodDetail.do?storeno=${reviewT.storeNo}">
							<h5 class="text-uppercase">${reviewT.storeName}
								(${reviewT.reviewCount})</h5>
						</a>
					</div>
				</div>
			</c:forEach>
			<!-- Food Menu #1 Ends -->

		</div>

		<hr>
		<h4>
			게시판Top<a href="${pageContext.request.contextPath}/board/list.do"
				class="btn btn-prime text-weight-bold text-uppercase animation">더보기</a>
		</h4>
		<div class="food-menu-grid row text-center">
			<c:forEach var="board" items="${boardTop}">
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="hover-content">
						<a
							href="${pageContext.request.contextPath}/board/read.do?boardNo=${board.boardNo}">
							<img
							src="<%=request.getContextPath()%>/CARE/images/hotels/thumb/hotel-grid-thumb-img1.jpg"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
						</a> <a
							href="${pageContext.request.contextPath}/board/read.do?boardNo=${board.boardNo}">
							<h5 class="text-uppercase">${board.boardTitle}
								${board.viewCount}</h5>
						</a>
					</div>
				</div>
			</c:forEach>


		</div>
		<!-- Food Menu Grid Ends -->
	</div>
	<!-- Nested Container Ends -->
</section>

<%@ include file="../include/footer.jspf"%>