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
<!-- Intro Section Ends -->
<section class="welcome section">
	<!-- Nested Container Starts -->
	<div class="container">
		<hr>
		<h4>평점 Top
		<a href="${pageContext.request.contextPath}/store/storeList?page=1&perPageNum=9&keyword=&orderBy=AVGSCORE"
			class="btn btn-prime text-weight-bold text-uppercase animation">더보기</a>
			</h4>
		<div class="food-menu-grid row text-center">
			<!-- Food Menu #1 Starts -->
			<c:forEach var="storea" items="${sTop}">
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="hover-content">
						<a
							href="${pageContext.request.contextPath}/store/storeList/detail?storeNo=${storea.storeNo}">
							<c:if test="${storea.storePic eq null}">
							<img
							src="${pageContext.request.contextPath}/resources/upLoad/imgnull.jpg"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
							</c:if>
							<c:if test="${storea.storePic ne null}">
							<img
							src="${pageContext.request.contextPath}/disFile?fileName=${storea.storePic}"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
							</c:if>
						</a> <a
							href="${pageContext.request.contextPath}/store/storeList/detail?storeNo=${storea.storeNo}">
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
			리뷰 Top <a href="${pageContext.request.contextPath}/store/storeList?page=1&perPageNum=9&keyword=&orderBy=REVIEWCNT"
				class="btn btn-prime text-weight-bold text-uppercase animation">더보기</a>
		</h4>
		<div class="food-menu-grid row text-center">
			<!-- Food Menu #1 Starts -->
			<c:forEach var="reviewT" items="${reviewTop}">
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="hover-content">
						<a
							href="${pageContext.request.contextPath}/store/storeList/detail?storeNo=${reviewT.storeNo}">
							<c:if test="${reviewT.storePic ne null}">
							<img
							src="${pageContext.request.contextPath}/disFile?fileName=${reviewT.storePic}"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
							</c:if>
							<c:if test="${reviewT.storePic eq null}">
							<img
							src="${pageContext.request.contextPath}/resources/upLoad/imgnull.jpg"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
							</c:if>
						</a> <a
							href="${pageContext.request.contextPath}/store/storeList/detail?storeNo=${reviewT.storeNo}">
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
			게시판Top<a href="${pageContext.request.contextPath}/board/listArticle"
				class="btn btn-prime text-weight-bold text-uppercase animation">더보기</a>
		</h4>
		<div class="food-menu-grid row text-center">
			<c:forEach var="board" items="${boardTop}" varStatus="status">
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="hover-content">
						<a
							href="${pageContext.request.contextPath}/board/readArticle?boardNo=${board.boardNo}">
							<c:choose>
							<c:when test="${boardPic[status.index].boardPic1 == null}">
							<img height="350px" width="350px"
							src="${pageContext.request.contextPath}/resources/upLoad/imgnull.jpg"
								 >
							</c:when>
							<c:otherwise>
							<img height="350px" width="350px"
							src="${pageContext.request.contextPath}/disFile?fileName=${boardPic[status.index].boardPic1}"
							>
							</c:otherwise>
							</c:choose>
						</a> <a
							href="${pageContext.request.contextPath}/board/readArticle?boardNo=${board.boardNo}">
							<h5 class="text-uppercase">${board.boardTitle}
								(${board.viewCount})</h5>
						</a>
					</div>
				</div>
			</c:forEach>


		</div>
		<!-- Food Menu Grid Ends -->
	</div>
	<!-- Nested Container Ends -->
</section>

<script type="text/javascript">

	$(function(){
		$("#frm").submit(function(){
				self.location = "${pageContext.request.contextPath}/store/storeList"
						+ '${pageMaker.makeQuery(1)}'
						+ '&keyword='+ $("#keyword").val();
			}
		});
	}); 

</script>

<%@ include file="../include/footer.jspf"%>