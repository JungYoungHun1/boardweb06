<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% BoardVO vo = (BoardVO) request.getAttribute("detail");%>
<% UserVO loginUser = (UserVO) session.getAttribute("loginUser");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>디테일</title>
</head>
<body>
<h1>디테일</h1>
<div>번호 : <%=vo.getIboard()%></div>
<div>제목 : <%=vo.getTitle()%></div>
<div>내용 : <%=vo.getCtnt()%></div>
<div>작성자 : <%=vo.getWriterNm()%></div>
<div>작성일시 : <%=vo.getRdt()%></div>
<div><a href="/board/list"><input type="button" name="list" value="이전"></a></div>
<div><% if(loginUser != null && vo.getWriter() == loginUser.getIuser()) { %>
<a href="/board/mod?iboard=<%=vo.getIboard()%>"><input type="button" name="mod" value="수정"></a>
    <a href="/board/delete?iboard=<%=vo.getIboard()%>"><input type="button" name="delete" value="삭제"></a></div>
<%}%>
</body>
</html>
