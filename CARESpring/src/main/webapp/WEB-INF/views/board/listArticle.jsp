<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<!-- Search Section Ends BreadCrumb Starts -->
<div class="breadcrumb rounded-0">
	<!-- Nested Container Starts -->
	<div class="container text-xs-center text-sm-center text-md-left">
		<ul class="list-unstyled list-inline">
			<li class="list-inline-item"><a
				href="${pageContext.request.contextPath }/main/index.do">홈</a></li>
			<li class="active list-inline-item">게시판</li>
		</ul>

	</div>
	<!-- Nested Container Ends -->
</div>
<!-- BreadCrumb Ends -->
<!-- Main Container Starts -->
<div class="main-container container">
	<!-- Heading Starts -->
	<h2 style="text-align: center" class=main-heading-1>게 시 판</h2>
	<!-- Heading Ends -->
	<!-- Starts -->
	<div class="row">
		<!-- Sidearea Starts -->
		<div class="col-lg-3 col-md-4 col-sm-12">


			<!-- 검색창 Start -->
			<div class="sidearea-filter">
				<form class="teble-form" action="listArticle" method="post">
				<!-- Search Field Starts -->
					<div class="input-group sidearea-filter-search">
						<input type="text" id="searching" name="searching"
							class="form-control rounded-0" placeholder="검색..."
							value="${param.searching}"><span
							class="input-group-append">
							<button class="btn btn-default rounded-0" type="submit">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
					<select id="pageView" name="pageView"
						class="form-control rounded-0 sidearea-filter-sort"
						onchange="this.form.submit()">
						<option value="10"></option>
						<option value="3"
							<c:if test="${articlePage.pageV == 3}" > selected </c:if>>3개씩보기</option>
						<option value="5"
							<c:if test="${articlePage.pageV == 5}" > selected </c:if>>5개씩보기</option>
						<option value="10"
							<c:if test="${articlePage.pageV == 10}">selected</c:if>>10개씩
							보기</option>
					</select>
				</form>
				<!--  검색창 Ends -->

			</div>
		</div>
		<!-- Spacer For Smaller Ends -->
		<!-- Sidearea Ends -->
		<!-- Mainarea Starts -->
		<div class="col-lg-9 col-md-8 col-sm-12">
			<!-- Hotels List Starts -->
			<div class="hotels-list text-xs-center text-sm-center text-lg-left">
				<!-- List #1 Starts -->
				<!-- List Descriptions Starts -->
				<div class="float-center list-box-info">


					<%-- 					<c:if test="${articlePage.hasNoArticles()}"> --%>
					<!-- 						<tr> -->
					<!-- 							<td colspan="4">게시글이 없습니다.</td> -->
					<!-- 						</tr> -->
					<%-- 					</c:if> --%>
					<c:forEach var="article" items="${articlePage.list}">
						<div class="list-box clearfix">
							<%-- 							<c:set var="fname" value="${articlePage.picList.boardPic1}" /> --%>
							<%-- 							<c:choose> --%>
							<%-- 								<c:when test="${fn:endsWith(fname, '.jpg')==true}"> --%>
							<%-- 									<img src="/CARE/upload/${articlePage.picList.boardPic1}" --%>
							<!-- 										width="200" /> -->
							<%-- 								</c:when> --%>
							<%-- 								<c:when test="${fn:endsWith(fname, '.png')==true}"> --%>
							<%-- 									<img src="/CARE/upload/${articlePage.picList.boardPic1}" --%>
							<!-- 										width="200" /> -->
							<%-- 								</c:when> --%>
							<%-- 								<c:when test="${fn:endsWith(fname, '.gif')==true}"> --%>
							<%-- 									<img src="/CARE/upload/${articlePage.picList.boardPic1}" --%>
							<!-- 										width="200" /> -->
							<%-- 								</c:when> --%>
							<%-- 								<c:when test="${fn:endsWith(fname, '.GIF')==true}"> --%>
							<%-- 									<img src="/CARE/upload/${articlePage.picList.boardPic1}" --%>
							<!-- 										width="200" /> -->
							<%-- 								</c:when> --%>
							<%-- 								<c:otherwise> --%>
							<%-- 								</c:otherwise> --%>
							<%-- 							</c:choose> --%>
							<h5 class="list-box-info-title">
								<a href="readArticle?boardNo=${article.boardNo}"> <c:choose>
										<c:when test="${fn:length(article.boardTitle) gt 15}">
											<c:out value="${fn:substring(article.boardTitle,0,14)}...">
											</c:out>
										</c:when>
										<c:otherwise>
											<c:out value="${article.boardTitle}"></c:out>
										</c:otherwise>
									</c:choose>
								</a>
							</h5>
							<a href="readArticle?boardNo=${article.boardNo}"
								class="dropdown-item"><i class="fa fa-angle-right"></i> <c:choose>
									<c:when test="${fn:length(article.boardContents) gt 50}">
										<c:out value="${fn:substring(article.boardContents,0,49)}...">
										</c:out>
									</c:when>
									<c:otherwise>
										<c:out value="${article.boardContents}"></c:out>
									</c:otherwise>
								</c:choose></a>

							<ul class="list-unstyled list-inline list-box-info-links">
								<li class="list-inline-item"><i
									class="fa fa-star-half-full"></i> <a href="">글번호 :
										${article.boardNo}</a></li>

								<li class="list-inline-item"><i class="fa fa-info-circle"></i>${article.boardDate}</li>

								<li class="list-inline-item"><i class="fa fa-asterisk"></i>${article.viewCount}</li>
							</ul>
						</div>
					</c:forEach>
				</div>
				<!-- List Descriptions Ends -->
				<!-- Pagination Starts -->
				<%
					if (session.getAttribute("login") != null) {
				%>
				<div style="float: right;">
					<a href="write"
						class="btn btn-prime text-weight-bold text-uppercase animation"
						style="margin-bottom: 14px;">글쓰기</a>
				</div>
				<%
					}
				%>

				<div class="pagination">
					<ul style="margin: 0 auto;"
						class="pagination animation float-lg-right">
						<c:if test="${articlePage.startPage>1}">
							<li class="page-item"><a
								href="?p=${articlePage.startPage-5}&searching=${param.searching}&pageView=${articlePage.pageV}"
									class="page-link">&laquo;</a></li>
						</c:if>
						<c:if test="${articlePage.startPage<=1}">
							<li class="page-item" onclick="alert('이전 페이지가 없습니다.');"><a
									class="page-link">&laquo;</a></li>
						</c:if>
						<c:forEach var="pNo" begin="${articlePage.startPage}"
							end="${articlePage.endPage}">
							<c:choose>
								<c:when test="${pNo == articlePage.currentPage}">
									<li class="page-item active"><a
										href="?p=${pNo}&searching=${param.searching}&pageView=${articlePage.pageV}"
										class="page-link">${pNo}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										href="?p=${pNo}&searching=${param.searching}&pageView=${articlePage.pageV}"
										class="page-link">${pNo}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${articlePage.startPage+5 <= articlePage.totalPages}">
							<li class="page-item"><a
								href="?p=${articlePage.startPage+5}&searching=${param.searching}&pageView=${articlePage.pageV}"
								class="page-link">&raquo;</a></li>
						</c:if>
						<c:if test="${articlePage.startPage+5 > articlePage.totalPages}">
							<li class="page-item" onclick="alert('다음 페이지가 없습니다.');"><a
									class="page-link">&raquo;</a></li>
						</c:if>
					</ul>
				</div>
				<!-- Pagination Ends -->
				<!-- Banners Starts -->
			</div>
		</div>
		<!-- Mainarea Ends -->
	</div>
	<!-- Ends -->
</div>
<%@ include file="../include/footer.jspf"%>