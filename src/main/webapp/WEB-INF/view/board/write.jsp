<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String err = (String) request.getAttribute("err");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글쓰기</title>
</head>
<body>
<h1>글쓰기</h1>
<% if(err != null) { %>
<div><%=err%></div>
<%}%>
<form action="/board/write" method="post">
    <div><input type="text" name="title" placeholder="제목" value="${requestScope.data.title}"></div>
    <div><textarea name="ctnt" placeholder="내용">${requestScope.data.ctnt}</textarea></div>
    <div><input type="submit" name="write" value="작성"></div>
</form>

</body>
</html>
