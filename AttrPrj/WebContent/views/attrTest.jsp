<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp page</h1>
	
	<%
	String id_param = request.getParameter("id");
	//getAttribute의 반환타입이 Object 이므로 캐스팅 필수
	String id_attr = String.valueOf(request.getAttribute("id"));
	
	%>
	
	<span>파라미터로 가져온 아이디 : <%=id_param %></span><br>
	<span>attr로 가져온 아이디 : <%=id_attr %></span>
</body>
</html>