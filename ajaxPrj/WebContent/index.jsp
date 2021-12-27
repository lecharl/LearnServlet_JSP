<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>index page</h1>
	
	age : <input type="text" id="age">
	<br>
	<span id="isAdult"></span>
	<br>
	<button onclick="ajaxTest();">ajax test</button>
	
	<script>
		function ajaxTest(){
			//ajax는 JS, jQuery 둘다 사용가능
			
			/* 클라이언트->서버 요청 보내고 받는 거 
			*/
			//ajax 호출 : $.ajax({});
			$.ajax({
				// /myServlet 에게 요청
				url : "/ajax/myServlet",
				method : "GET",
				//ajax로 데이터 보내기
				data : {
					name : "sim",
					age : $('#age').val(),
					addr : "korea"
				},
				// 요청이 정상적으로 처리가 됐을 때
				success : function(result){
					console.log("success : "+result);
					$("#isAdult").text(result);
				},
				// 실패했을 때
				error : function(result){
					console.log(result);
				},
				// success, error 에서의 콜백함수가 수행된 후에 실행, finally
				complete : function(result){
					console.log(result);
				}
			});
		}
	</script>
</body>
</html>