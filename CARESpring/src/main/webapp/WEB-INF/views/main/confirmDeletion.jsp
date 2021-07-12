<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <title>방명록 메시지 삭제 확인</title>
</head>
<body>

<form action="deleteMessage.jsp" method="post">
<input type="hidden" name="messageId" value="${message.userno}">
메시지를 삭제하시려면 자신의 userno를 입력하세요:<br>
USERNO: <input type="userno" name="userno"> <br>
<input type="submit" value="삭제">
</form>
</body>
</html>