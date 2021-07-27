<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ include file="../include/header.jspf"%>

<style>
* {
	margin: 4px 0;
}

.controller {
	padding: 25px 0;
	margin: auto;
	width: 840px;
}

#wriTitle {
	text-align: center;
	background-color: rgb(100, 100, 100);
	width: 800px;
	padding-top: 10px;
	padding-bottom: 10px;
	color: white;
}

table {
	width: 840px;
	margin: 25px 0;
	padding: 20px;
	border-collapse: collapse;
}

#boardTitle {
	width: 693px;
}

textarea {
	width: 800px;
	height: 400px;
}

.button {
	width: 100px;
	padding: 5px 12px;
	border: none;
	background-color: rgb(150, 60, 60);
	color: white;
}
</style>

<script>
console.log("${reviewInfo[0].reviewNo}")
</script>

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
					<li class="nav-item"><a href="#reviews" class="nav-link active"
						data-toggle="tab">리뷰 수정</a></li>
				</ul>
				<section class="content">

					<!-- Default box -->
					<div class="box-body">
						<div class="box-body">
							<form action="/care/store/storeList/modifyReview" method="post" id="writeForm" enctype="multipart/form-data">
								<div>리뷰 내용: </div>
								<p>
									<textarea name="reviewContents" cols="100" rows="20" placeholder="리뷰를 작성하세요">${reviewInfo[0].reviewContents}</textarea>
								</p>
								<div> 
								<h9>별점을 선택하세요</h9> 
									<select name="avgScore" value="${reviewInfo[0].avgScore}">
										<option value="1">★☆☆☆☆</option>
										<option value="2">★★☆☆☆</option>
										<option value="3">★★★☆☆</option>
										<option value="4">★★★★☆</option>
										<option value="5" selected>★★★★★</option>
									</select>
								</div>
								<input type="hidden" name="reviewNo" value="${reviewInfo[0].reviewNo}">
								<input type="hidden" name="storeNo" value="${reviewInfo[0].storeNo}">
								<p>
									<input id="submitBtn" type="button" value="리뷰수정" class="btn btn-black animation text-uppercase float-right" />
								</p>
								<div class="inputArea">
									<label for="preView">이미지</label> <input type="file"
										id="preView" name="file" />
									<div class="select_img">
										<img src="" />
									</div>
								</div> 
							</form> 
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
</div>
			
			
<script src="//code.jquery.com/jquery.min.js"></script>
<script>
$("#submitBtn").click(function(e) {
	e.preventDefault();
	if(!confirm('수정하시겠습니까?')) return;
	$('#writeForm').submit();
});
 


</script>
<br>
<br>

<%@ include file="../include/footer.jspf"%>