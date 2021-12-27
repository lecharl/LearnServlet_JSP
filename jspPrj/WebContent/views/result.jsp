<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 자바 코드 쓰기 -->
	<%
		//PrintWriter out = resp.getWriter(); 
		//jsp에선 위에 거 안써도 바로 사용 가능하다!!!
		out.println("java 코드 가능???");
		
		//req ㄴㄴㄴ 애초부터 JSP 내장객체 request, response로 받아온다!
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
	%>	
	<hr>
	<% 
		out.println("id : " + id);
		out.println("<br>");
		out.println("pwd : " + pwd);
	%>

	<h1>result.jsp page</h1>

	<table border="1">
		<tr>
			<td>아이디 : </td>
			<!-- <td><% out.println(id);%></td> -->
			<td><%=id%></td>
		</tr>
		<tr>
			<td>비번 : </td>
			<td><%=pwd%></td>
		</tr>
	</table>
	
	<hr>
	<%--주석 --%>
	
	<%	if("admin".equals(id)){%>
			<h1>관리자입니다.</h1>
	<%} else{%>
			<h1>유저입니다.</h1>
	<%}%>
	
	<hr>
	
	<% 
        if("admin".equals(id)){
            out.println("<h1>관리자입니다.</h1>");
        } else{
            out.println("<h1>유저 입니다.</h1>");
        }    
    %>
	

</body>
</html>