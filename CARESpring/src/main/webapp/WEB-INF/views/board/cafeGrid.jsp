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
							class="form-check-input detailCheckBox" id="detailChk" name="totalSeat" value="totalSeat"> 총 테이블 수
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="socketSeat" value="socketSeat"> 콘센트 테이블 수
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="dessertSales" value="dessertSales"> 디저트 판매
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="terrace" value="terrace"> 테라스
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="rooftop" value="rooftop"> 루프탑
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="wifi" value="wifi"> 와이파이
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="companionDog" value="companionDog"> 애견 동반
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="parkingSpace" value="parkingSpace"> 주차 공간
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="noKidsZone" value="noKidsZone"> 노키즈존
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input detailCheckBox" id="detailChk" name="smokingArea" value="smokingArea"> 흡연구역
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
				<div class="row storeLi">
					<!-- List Box #1 Starts -->
					<!-- List 시작 -->

					<c:if test="${list == null}">
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
										<a href="${pageContext.request.contextPath}/store/storeList/detail?storeNo=${storeinfo.storeNo}">${storeinfo.storeName}</a>
									</h6>
									<!-- Title Ends -->
									<!-- Tags Starts -->
									<ul class="list-unstyled list-inline grid-box-tags">
										<li class="list-inline-item">
								 			<c:choose>
											<c:when test = "${fn:length(storeinfo.address) gt 20}">
											<c:out value = "${fn:substring(storeinfo.address,0,19)}..."></c:out>
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

<script type="text/javascript">

	$(function(){
		$("#frm").submit(function(){
			if($("#keyword").val() == ""){
				alert("검색어를 입력하세요!");
				$("#keyword").focus();
				return false;
			}else{
				alert("keyword="+$("#keyword").val());
				
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
 	
	/* $(function(){
		$("#detailChk").change(function(){
			if($("#detailChk").is(":checked")){
				self.location = "${pageContext.request.contextPath}/store/storeList"
						+ '${pageMaker.makeQuery(1)}'
						+ '&keyword='+$("#keyword").val()
						+ '&orderBy='+$("#orderBy").val()
						+ '&detailChk='+$("#detailChk").val();
			}
		});
	}); */
	
	$(function(){
		var chkArr = [];
		$(".detailCheckBox").change(function(){
			console.log($(this)[0].checked);
			if($(this)[0].checked){
				console.log($(this));
				console.log("1");
				chkArr.push($(this).val());
			}else{
				console.log("2");
				console.log(chkArr.indexOf($(this).val()));
				chkArr.splice(chkArr.indexOf($(this).val()), 1);
			}
			alert(chkArr);
			$.ajax({
				url: '${pageContext.request.contextPath}/store/storeList/detailChk'
				, type: 'post'
				, dataType: 'text'
				, data: {
					valueArr: chkArr
				}, success: function(data){
					console.log("data: "+data);
				}
			});
		});
		
		 
 	}); 
	
	
	/* $(function(){
		
		var locationUrl = "${pageContext.request.contextPath}/store/storeList"
					+ '${pageMaker.makeQuery(1)}'
					+ '&keyword='+$("#keyword").val()
					+ '&orderBy='+$("#orderBy").val()
			 
		$("#detailChk").change(function(){
			if($('input:checkbox[name=totalSeat]').is(":checked")){
				alert($('input:checkbox[name="totalSeat"]').val());
				locationUrl += '&detail1='+$('input:checkbox[name="totalSeat"]').val();
				self.location = locationUrl
			}else if($('input:checkbox[name=socketSeat]').is(":checked")){
				locationUrl += '&detail2='+$('input:checkbox[name="socketSeat"]').val();
				self.location = locationUrl
			}else if($('input:checkbox[name=dessertSales]').is(":checked")){
				locationUrl += '&detail3='+$('input:checkbox[name="dessertSales"]').val();
				self.location = locationUrl
			}else if($('input:checkbox[name=terrace]').is(":checked")){
				locationUrl += '&detail4='+$('input:checkbox[name="terrace"]').val();
				self.location = locationUrl
			}else if($('input:checkbox[name=rooftop]').is(":checked")){
				locationUrl += '&detail5='+$('input:checkbox[name="rooftop"]').val();
				self.location = locationUrl
			}else if($('input:checkbox[name=wifi]').is(":checked")){
				locationUrl += '&detail6='+$('input:checkbox[name="wifi"]').val();
				self.location = locationUrl
			}else if($('input:checkbox[name=companionDog]').is(":checked")){
				locationUrl += '&detail7='+$('input:checkbox[name="companionDog"]').val();
				self.location = locationUrl
			}else if($('input:checkbox[name=parkingSpace]').is(":checked")){
				locationUrl += '&detail8='+$('input:checkbox[name="parkingSpace"]').val();
				self.location = locationUrl
			}else if($('input:checkbox[name=noKidsZone]').is(":checked")){
				locationUrl += '&detail9='+$('input:checkbox[name="noKidsZone"]').val();
				self.location = locationUrl
			}else if($('input:checkbox[name=smokingArea]').is(":checked")){
				locationUrl += '&detail10='+$('input:checkbox[name="smokingArea"]').val();
				self.location = locationUrl
			}
		});
	}); */
 </script>

<!-- <script>
	$(function(){
		$("#orderBy").change(function(){
			var orderby = $(this.val());
			
			$.ajax({
				type:'get',
				url:'/storeList',
				headers: {
					"Content-Type": "application/json",
					"X-HTTP-Metehod-Override": "GET" },
				dataType: 'text',
				data: JSON.stringify({storeno:storeno, storename:storename, address:address}),
				success: function(result){  // 정상 처리
					console.log("result:" + result);
					if(result == 'SUCCESS'){
						alert("리스트 변경");
						getPage("/storeList?orderBy="+orderby);
					}
				}
			}
		});
	});

</script> -->

<script id="template" type="text/x-handlebars-template">
{{#each .}}
<div class="col-lg-4 col-md-6 col-sm-12">
	<!-- Grid Box Starts -->
	<div class="grid-box">
		<!-- Images Starts -->
		<div class="image text-center">
			<imgW
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
{{/each}}
</script>

<!-- <script> 

	var printData = function(storeArr, target, templateObject){
	
		var template = Handlebars.compile(templateObject.html());

		var html = template(storeArr)
		$("storeLi").remove();
		tartget.after(html);
	
	}
	
	var storeno = ${storeinfo.storeNo}
	
	var storePage = 1;
	
	function getPage(pageInfo){
	
		$.getJSON(pageInfo, function(data){
			printData(data.list, $())
		}
	}
 
	
 </script>  -->

<!--  <script> 
 
 var source = $("#template").html();
 	var template = Handlebars.complie(source);
 	var data = [];
	
 	$("#replies").html(template(data));
 	var printData = function(replyArr, target, templateObject){
 		var template = Handlebars.compile(templateObject.html());
		
 		var html = template(replyArr);
 		$(".row").remove();
 		target.after(html);
 	}
	
 	var storeNo = ${storeInfo.storeNo};
 	var PageNo = 1;
	
 	function getPage(pageInfo){
		
 		$.getJSON(pageInfo, function(data){
 			printData(data.list, $("#replisDiv"), $('#template'));
 			printPaging(data.pageMaker, $(".pagination"));
			
 			$("#modifyModal").modal('hide');
 			$("#replycntSmall").html("[ " + data.pageMaker.totalCount + " ]");
 		});
 	}
	
 	$("#repliesDiv").on("click", function(){
 		if($(".timeline li").size() > 1){
 			return;
 		}
 		getPage("/replies/"+storeNo+"/"+replyPage)
 	});
 	
 	var orderBy = $("#orderBy").val();
 	$("#orderBy").change(function(){
 		getPage("/orderBy="+orderBy)
 	});
	
 </script> --> 

<%@ include file="../include/footer.jspf"%>