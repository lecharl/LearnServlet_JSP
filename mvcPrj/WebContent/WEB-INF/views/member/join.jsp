<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>

	<form action="/mvc/memberJoin" method="post">
		아이디 : <input type="text" name="userId"><br>
		비밀번호 : <input type="password" name="userPwd"><br>
		이름 : <input type="text" name="userName"><br>
		나이 : <input type="number" name="userAge"><br>
		전화번호 : <input type="text" name="userPhone"><br>
		<input type="reset" value="취소">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>
