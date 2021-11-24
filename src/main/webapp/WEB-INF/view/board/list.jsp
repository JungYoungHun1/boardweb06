<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page import="com.koreait.board2.model.BoardParamVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");%>
<% UserVO loginUser = (UserVO) session.getAttribute("loginUser");%>
<% int maxPage = (int)request.getAttribute("maxPage");%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리스트</title>
</head>
<body>
<h1>리스트</h1>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일시</th>
    </tr>
    <%for(BoardVO vo : list) { %>
    <tr>
        <td><%=vo.getIboard()%></td>
        <td><a href="/board/detail?iboard=<%=vo.getIboard()%>"><%=vo.getTitle()%></a></td>
        <td><%=vo.getWriterNm()%></td>
        <td><%=vo.getRdt()%></td>
    </tr>
    <%}%>




</table>

<% if(loginUser != null) {%>
<a href="/board/write"><div><input type="button" name="write" value="글쓰기"></div></a>
<a href="/user/logout"><div><input type="button" name="logout" value="로그아웃"></div></a>
<%} else {%>
<a href="/user/login"><div><input type="button" name="login" value="로그인"></div></a>
<%}%>

<div style ="margin-top: 20px;">
    <% for(int i=1; i<=maxPage; i++) { %>
    <span><a href="/board/list?page=<%=i%>"><%=i%></a></span>&nbsp;
    <% } %>
</div>

</body>
</html>
