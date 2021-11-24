<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String err = (String) request.getAttribute("err");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<%if(err != null){%>
<div class="err"><%=err%></div>
<%}%>
<form action="/user/join" method="post">
    <div><input type="text" name="uid" placeholder="ID"></div>
    <div><input type="password" name="upw" placeholder="PASSWORD"></div>
    <div><input type="text" name="nm" placeholder="NAME"></div>
    <div>gender : <label>woman<input type="radio" name="gender" value="0" checked></label>
    <label>man<input type="radio" name="gender" value="1"></label></div>
    <div><input type="submit" name="join" value="완료"></div>
</form>



</body>
</html>
