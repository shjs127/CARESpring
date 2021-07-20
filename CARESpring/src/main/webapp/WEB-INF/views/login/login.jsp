<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Main Menu Ends -->
<!-- Main Container Starts -->
<div class="main-container container">
	<!-- Content Login Wrap Starts -->
	<div class="content-login-wrap">
		<!-- Nested Row Starts -->
		<div class="row">
			<!-- Login Col Starts -->
			<div class="col-md-5 col-sm-12">
				<h4 class="text-spl-color">기존 회원 로그인</h4>
				<!-- Login Form Starts -->
				<p class="login-box-msg">

					<script type="text/javascript">
						<c:if test="${errors.idOrPwNotMatch}">
						alert("아이디와 암호가 일치하지 않습니다.")
						</c:if>
						</script>
						</p>
						
						<script>
						$(function() {
							$("#a").submit(function() {
								var nameChk = /^[가-힣a-zA-Z0-9]{1,20}$/;
								if (!nameChk.test($("#ID").val())) {
									alert("아이디를 확인해주세요.");
									$("#ID").focus();
									return false;
								}
							});
						});

						$(function() {
							$("#a").submit(function() {
								var PwChk = /^[가-힣a-zA-Z0-9]{1,20}$/;
								if (!PwChk.test($("#PW").val())) {
									alert("비밀번호를 확인해주세요.");
									$("#PW").focus();
									return false;
								}
							});
						});
					</script>
				<form action="login/joinSuccess"
					method="post" id="a">

					<div class="form-group">

						<input type="text" class="form-control" name="userId" id="ID"
							placeholder="ID">
					</div>
					<div class="form-group">

						<input type="password" class="form-control" name="password"
							id="PW" placeholder="Password">
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" name="useCookie"> Remember me
						</label>
					</div>
					<button type="submit" class="btn btn-block btn-prime animation">
						Login <i class="fa fa-caret-right"></i>
					</button>
					<br> <a href="register" class="text-center">회원 가입</a>

					<div class="form-group">
						<p class="help-block">
							비밀번호를 잃어버리셨습니까? <a href="#">Click here</a>
						</p>
					</div>
				</form>
				<!-- Login Form Ends -->
			</div>
			<!-- Login Col Ends -->
			<!-- Divider For Small Devices -->
			<div class="w-10 d-xs-block d-sm-block d-md-none">
				<br>
				<hr>
				<br>
			</div>
			<!-- Divider For Small Ends -->
			<!-- Register Col Starts -->
			<div class="col-md-5 col-sm-12 offset-md-2">
				<h4 class="text-spl-color">기업 회원 로그인</h4>
				<!-- Login Form Starts -->
				<p class="login-box-msg"></p>

				<script>
					/* $(function() {
						$("#b").submit(function() {
							var nameChk = /^[0-9]{1,20}$/;
							if (!nameChk.test($("#Login-Id").val())) {
								alert("기업회원 번호를 확인해주세요.");
								$("#Login-Id").focus();
								return false;
							}
						});
					}); */

					$(function() {
						$("#b").submit(function() {
							var nameChk = /^[0-9]{1,20}$/;
							if (!nameChk.test($("#Login-password").val())) {
								alert("매장 번호를 확인해주세요.");
								$("#Login-password").focus();
								return false;
							}
						});
					});
				</script>

				<form action="login/storeinSuccess"
					method="post" id="b">

					<div class="form-group">

						<input type="text" class="form-control" name="manageNo"
							id="Login-Id" placeholder="manageNo">
					</div>
					<div class="form-group">

						<input type="password" class="form-control" name="storeNo"
							id="Login-password" placeholder="storeNo">
					</div>
					<div class="checkbox">
						<label> <input type="checkbox"> Remember me
						</label>
					</div>
					<button type="submit" class="btn btn-block btn-prime animation">
						Login <i class="fa fa-caret-right"></i>
					</button>
					<br> <a href="<%=request.getContextPath()%>/main/storage.do"
						class="text-center">매장 등록</a>

					<div class="form-group">
						<p class="help-block">
							비밀번호를 잃어버리셨습니까? <a href="#">Click here</a>
						</p>
					</div>
				</form>
				<!-- Login Form Ends -->
			</div>
			<!-- Register Col Ends -->
		</div>
		<!-- Nested Row Ends -->
	</div>
	<!-- Content Login Wrap Ends -->
	<!-- Banners Starts -->
	<div class="row">
	
	</div>
	<!-- Banners Ends -->
</div>
<!-- Main Container Ends -->
<!-- Register Modal Window Starts -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
	aria-labelledby="registerModal">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content no-boxshadow text-center">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title text-spl-color" id="registerModalLabel">Register
					Here</h4>
			</div>
			<div class="modal-body">

				<!-- Register Form Starts -->
				<form>
					<div class="form-group">
						<label class="sr-only" for="register-fname">First Name</label> <input
							type="text" class="form-control" id="register-fname"
							placeholder="First Name">
					</div>
					<div class="form-group">
						<label class="sr-only" for="register-lname">Last Name</label> <input
							type="text" class="form-control" id="register-lname"
							placeholder="Last Name">
					</div>
					<div class="form-group">
						<label class="sr-only" for="register-address">Last Name</label>
						<textarea class="form-control" id="register-address"
							placeholder="Address" rows="4"></textarea>
					</div>
					<div class="form-group">
						<label class="sr-only" for="register-zipcode">Zip Code</label> <input
							type="text" class="form-control" id="register-zipcode"
							placeholder="Zip Code">
					</div>
					<div class="form-group">
						<label class="sr-only" for="register-country">Country</label> <select
							class="form-control" id="register-country">
							<option>Country</option>
							<option>India</option>
							<option>USA</option>
							<option>China</option>
							<option>Australia</option>
						</select>
					</div>
					<div class="form-group">
						<label class="sr-only" for="register-phoneno">Phone No</label> <input
							type="text" class="form-control" id="register-phoneno"
							placeholder="Phone No">
					</div>
					<div class="form-group">
						<label class="sr-only" for="register-email">Email address</label>
						<input type="email" class="form-control" id="register-email"
							placeholder="Email">
					</div>
					<div class="form-group">
						<label class="sr-only" for="register-password">Password</label> <input
							type="password" class="form-control" id="register-password"
							placeholder="Password">
					</div>
					<div class="form-group">
						<div class="checkbox">
							<label> <input type="checkbox"> Yes, I would like
								to receive emails with deals and discount codes
							</label>
						</div>
						
					</div>
				
				</form>
				<!-- Register Form Ends -->
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jspf"%>