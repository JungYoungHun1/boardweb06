<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%BoardVO vo = (BoardVO) request.getAttribute("detail");%>
<% String err = (String) request.getAttribute("err");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>수정</title>
</head>
<body>
<%if(err != null) { %>
<div><%=err%></div>
<%}%>
<form action="/board/mod" method="post">
    <div><input type="hidden" name="iboard" value="<%=vo.getIboard()%>"></div>
    <div><input type="text" name="title" value="<%=vo.getTitle()%>"></div>
    <div><textarea name="ctnt"><%=vo.getCtnt()%></textarea></div>
    <div><input type="submit" name="mod" value="완료"></div>
</form>

</body>
</html>
