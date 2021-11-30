<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BoardVO data = (BoardVO)request.getAttribute("data");
    UserVO loginUser = (UserVO)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${requestScope.data.title}</title>
</head>
<body>
<h1>디테일</h1>
<div><a href="/board/list">리스트</a></div>
<% if(loginUser != null && data.getWriter() == loginUser.getIuser()) { %>
<a href="/board/mod?iboard=${requestScope.data.iboard}"><input type="button" value="수정"></a>
<a href="/board/del?iboard=${requestScope.data.iboard}"><input type="button" value="삭제"></a>
<% } %>
<div>${requestScope.err}</div>
<div>번호 : ${requestScope.data.iboard}</div>
<div>제목 : ${requestScope.data.title}</div>
<div>작성자 : ${requestScope.data.writerNm}</div>
<div>작성일시 : ${requestScope.data.rdt}</div>
<div>- 내용 - </div>
<div>${requestScope.data.ctnt}</div>
</body>
</html>