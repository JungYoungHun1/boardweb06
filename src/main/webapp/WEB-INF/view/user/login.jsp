<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String err = (String) request.getAttribute("err");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<%if(err != null){%>
<div class="err"><%=err%></div>
<%}%>
<form action="/user/login" method="post">
<div><input type="text" name="uid" value="mic"></div>
<div><input type="password" name="upw" value="1212"></div>
<div><input type="submit" name="login" value="Login"></div>

</form>
<div>
    <a href="/user/join"><input type="button" name="join" value="회원가입"></a>

</div>

</body>
</html>
