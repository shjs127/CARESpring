<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jspf"%>

<!-- Main Heading Starts -->
<h2 class="main-heading text-center">
	매장 등록
</h2>
<!-- Main Heading Ends -->
<!-- Registration Section Starts -->
<section class="registration-area">
	<div class="row">
	
	<script>
	$(function() {
		$("form").submit(function() {
			var nameChk = /^{1,100}$/;
			if (!nameChk.test($("#storeName").val())) {
				alert("매장 이름을 입력하여 주십시오!");
				$("#storeName").focus();
				return false;
			}
		});
	});
	
	/* $(function() {
		$("form").submit(function() {
			var nameChk = /^[가-힣a-zA-Z0-9]{1,100}$/;
			if (!nameChk.test($("#storePic").val())) {
				alert("매장 사진을 등록하여 주십시오!");
				$("#storePic").focus();
				return false;
			}
		});
	}); */
	
	$(function() {
		$("form").submit(function() {
			var nameChk = /^{1,100}$/;
			if (!nameChk.test($("#address").val())) {
				alert("매장 주소를 입력하여 주십시오!");
				$("#address").focus();
				return false;
			}
		});
	});
	
	$(function() {
		$("form").submit(function() {
			var nameChk = /^[가-힣a-zA-Z0-9]{1,100}$/;
			if (!nameChk.test($("#hours").val())) {
				alert("영업 시간을 입력하여 주십시오!");
				$("#hours").focus();
				return false;
			}
		});
	});
	
	$(function() {
		$("form").submit(function() {
			var nameChk = /^[가-힣a-zA-Z0-9]{1,100}$/;
			if (!nameChk.test($("#closedDays").val())) {
				alert("휴무일을 입력하여 주십시오!");
				$("#closedDays").focus();
				return false;
			}
		});
	});
	
	$(function() {
		$("form").submit(function() {
			var nameChk = /^[가-힣a-zA-Z0-9]{1,100}$/;
			if (!nameChk.test($("#callNumber").val())) {
				alert("매장 전화번호를 입력하여 주십시오!");
				$("#callNumber").focus();
				return false;
			}
		});
	});
	
	$(function() {
		$("form").submit(function() {
			var nameChk = /^[가-힣a-zA-Z0-9]{1,100}$/;
			if (!nameChk.test($("#manageNo").val())) {
				alert("사업자 번호를 입력하여 주십시오!");
				$("#manageNo").focus();
				return false;
			}
		});
	});
	
	</script>
	
		<div class="col-sm-6">
			<!-- Registration Block Starts -->
			<div class="panel panel-smart">
				<div class="panel-heading">
					<h3 class="panel-title">매장 정보</h3>
				</div>
				<div class="panel-body">
					<!-- Registration Form Starts -->
					<form class="form-horizontal"
						action="StoreRegister"
						method="post" 
						enctype="multipart/form-data">
						
						<!-- Personal Information Starts -->
						<div class="form-group row">
							<label for="inputFname"
								class="col-sm-3 col-form-label text-right">매장 이름 :</label>
							<div class="col-sm-9">
								<input id="storeName" type="text" class="form-control" name="storeName"
									placeholder="storeName">
							</div>
						</div>
						<!-- <div class="form-group row">
							<label for="inputLname"
								class="col-sm-3 col-form-label text-right">매장 사진 :</label>
								<input  type="file" id="storeImg" name="file">
								<img src="" /></div>
							<div class="col-sm-9">
							</div>
						</div> -->
						
						
						<div class="form-group row">
 						<label for="inputFname" class="col-sm-3 col-form-label text-right">매장 사진</label>
 						
 						<input type="file" id="storeImg" name="file" />
 						<div class="select_img"><img src="" /></div>
 
 						<script>
 						 $("#storeImg").change(function(){
  							 if(this.files && this.files[0]) {
   								 var reader = new FileReader;
   								 reader.onload = function(data) {
   									  $(".select_img img").attr("src", data.target.result).width(500);        
   										 }
   										 reader.readAsDataURL(this.files[0]);
  									 }
 								 });
 								</script>
								</div>
					
						
						<div class="form-group row">
							<label for="inputEmail"
								class="col-sm-3 col-form-label text-right">매장 주소:</label>
							<div class="col-sm-9">
								<input id="address" type="text" class="form-control" name="address"
									placeholder="address">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPhone"
								class="col-sm-3 col-form-label text-right">영업 시간:</label>
							<div class="col-sm-9">
								<input id="hours" type="text" class="form-control" name="hours"
									placeholder="hours">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputFax" class="col-sm-3 col-form-label text-right">휴무일
								:</label>
							<div class="col-sm-9">
								<input id="closedDays" type="text" class="form-control" name="closedDays"
									placeholder="closedDays">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputFax" class="col-sm-3 col-form-label text-right">전화
								번호 :</label>
							<div class="col-sm-9">
								<input id="callNumber" type="text" class="form-control" name="callNumber"
									placeholder="callNumber">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputFax" class="col-sm-3 col-form-label text-right">사업자
								번호 :</label>
							<div class="col-sm-9">
								<input id="manageNo" type="text" class="form-control" name="manageNo"
									placeholder="manageNo">
							</div>
						</div>

						<!-- Personal Information Ends -->

						<h3 class="panel-heading inner">매장 상세정보</h3>

						<div class="form-group row">
							<label for="inputFax" class="col-sm-3 col-form-label text-right">총
								테이블수 :</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="totalSeat"
									placeholder="totalSeat">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputFax" class="col-sm-3 col-form-label text-right">콘센트
								테이블 수 :</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="socketSeat"
									placeholder="socketSeat">
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3 col-form-label text-right">디저트 판매 :</span>
							<div class="col-sm-9">
								<div class="radio">
									<label> <input type="radio" name="dessertSales"
										value="Y"> 있음(가능) <input type="radio"
										name="dessertSales" value="N" checked> 없음(불가능)
									</label>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3 col-form-label text-right">테라스 :</span>
							<div class="col-sm-9">
								<div class="radio">
									<label> <input type="radio" name="terrace" value="Y">
										있음(가능) <input type="radio" name="terrace" value="N" checked>
										없음(불가능)
									</label>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3 col-form-label text-right">루프탑 :</span>
							<div class="col-sm-9">
								<div class="radio">
									<label> <input type="radio" name="roofTop" value="Y">
										있음(가능) <input type="radio" name="roofTop" value="N" checked>
										없음(불가능)
									</label>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3 col-form-label text-right">와이파이 :</span>
							<div class="col-sm-9">
								<div class="radio">
									<label> <input type="radio" name="wifi" value="Y">
										있음(가능) <input type="radio" name="wifi" value="N" checked>
										없음(불가능)
									</label>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3 col-form-label text-right">애견동반:</span>
							<div class="col-sm-9">
								<div class="radio">
									<label> <input type="radio" name="companionDog"
										value="Y"> 있음(가능) <input type="radio"
										name="companionDog" value="N" checked> 없음(불가능)
									</label>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3 col-form-label text-right">주차공간 :</span>
							<div class="col-sm-9">
								<div class="radio">
									<label> <input type="radio" name="parkingSpace"
										value="Y"> 있음(가능) <input type="radio"
										name="parkingSpace" value="N" checked> 없음(불가능)
									</label>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3 col-form-label text-right">노키즈존 :</span>
							<div class="col-sm-9">
								<div class="radio">
									<label> <input type="radio" name="noKidsZone" value="Y">
										있음(가능) <input type="radio" name="noKidsZone" value="N" checked>
										없음(불가능)
									</label>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3 col-form-label text-right">흡연구역 :</span>
							<div class="col-sm-9">
								<div class="radio">
									<label> <input type="radio" name="smokingArea"
										value="Y"> 있음(가능) <input type="radio"
										name="smokingArea" value="N" checked> 없음(불가능)
									</label>
								</div>
							</div>
						</div>

						<button type="submit" class="btn btn-block btn-prime animation">
							저장 <i class="fa fa-caret-right"></i>
						</button>
					</form>
					<!-- Delivery Information Ends -->



					<!-- Registration Form Starts -->
				</div>
			</div>
			<!-- Registration Block Ends -->
		</div>

	</div>
</section>
<!-- Registration Section Ends -->

<!-- Main Container Ends -->

<%@ include file="../include/footer.jspf"%>