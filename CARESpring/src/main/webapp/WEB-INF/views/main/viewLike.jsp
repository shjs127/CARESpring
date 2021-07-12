<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.*"%>



<%!// 변수 선언
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String uid = "CARE";
	String pwd = "CARE";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String sql = "SELECT USERINFO.userId,FAVORITE.storeNo, FAVORITE.favoriteCheck, STOREINFO.storeName, STOREINFO.callNumber, storeinfo.address, storeinfo.closedDays FROM FAVORITE, STOREINFO,USERINFO WHERE USERINFO.userNo=favorite.userNo AND favorite.storeNo=storeinfo.storeNo AND FAVORITE.userNo='1'";%>

<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>즐겨찾기 조회</title>
</head>
<body>


	<%
		try {
		// 데이터베이스를 접속하기 위한 드라이버 SW 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 데이터베이스에 연결하는 작업 수행
		conn = DriverManager.getConnection(url, uid, pwd);
		// 쿼리를 생성gkf 객체 생성
		stmt = conn.createStatement();
		// 쿼리 생성
		rs = stmt.executeQuery(sql);
	%>
	<table border="1">
		<tr>
			<td>사용자 ID</td>
			<td>즐겨찾기 여부</td>
			<td>매장 이름</td>
			<td>매장 번호</td>
			<td>매장 주소</td>
			<td>휴무일</td>

		</tr>


		<%
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("userId")%></td>
			<td><%=rs.getString("favoriteCheck")%></td>
			<td><%=rs.getString("storeName")%></td>
			<td><%=rs.getInt("callNumber")%></td>
			<td><%=rs.getString("address")%></td>
			<td><%=rs.getString("closedDays")%></td>


		</tr>


		<%
			}
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		try {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		%>
	</table>

	<br>
	<br>
	<br>

	<br>
	<br>
	<br>


</body>

