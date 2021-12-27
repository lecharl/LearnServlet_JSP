<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 테스트</h1>
	
	<!-- 파일을 제출할 때 인코딩타입으로 저렇게 해야함! -->
	<form action="fileTest" method="post" enctype="multipart/form-data">
		<input type="text" name="id"><br>
		<input type="file" name="f"><br>
		<input type="file" name="f"><br>
		<input type="file" name="f"><br>
		<input type="submit" value="파일제출">
	
	</form>
	
	<hr><hr><hr>
	
	<img alt="nothing" src="upload/${path}">
	<a href="upload/${path}" download>이미지 다운로드하기</a>
</body>
</html>