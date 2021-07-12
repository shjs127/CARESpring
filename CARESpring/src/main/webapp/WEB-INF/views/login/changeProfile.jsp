<%@ page contentType = "text/html; charset=utf-8" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<script>
	alert("성공적으로 회원정보가 수정되었습니다.");
	location.href="${pageContext.request.contextPath }/login.do"; 
</script>
