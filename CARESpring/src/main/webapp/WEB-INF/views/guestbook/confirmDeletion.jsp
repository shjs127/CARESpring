<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jspf"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			방명록 삭제 <small>it all starts here</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Examples</a></li>
			<li class="active">Blank page</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">Title</h3>

				<div class="box-tools pull-right">
					<button type="button" class="btn btn-box-tool"
						data-widget="collapse" data-toggle="tooltip" title="Collapse">
						<i class="fa fa-minus"></i>
					</button>
					<button type="button" class="btn btn-box-tool" data-widget="remove"
						data-toggle="tooltip" title="Remove">
						<i class="fa fa-times"></i>
					</button>
				</div>
			</div>
			<div class="box-body">

				<form action="deleteMessage.jsp" method="post">
					<input type="hidden" name="messageId" value="${param.messageId}">
					메시지를 삭제하시려면 암호를 입력하세요:<br> 암호: <input type="password"
						name="password"> <br> <input type="submit"
						value="메시지 삭제하기">
				</form>

			</div>
			<!-- /.box-body -->
			<div class="box-footer">Footer</div>
			<!-- /.box-footer-->
		</div>
		<!-- /.box -->

	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->



<%@ include file="../include/footer.jspf"%>