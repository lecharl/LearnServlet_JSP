<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 현재 페이지(index.jsp)에서 에러가 나면 아래 페이지로 이동하라 -->
<%@ page errorPage="views/error/errorResult.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- header.jsp 가져오기 -->
	<%@ include file="views/common/header.jsp" %>

	<!-- 예외 발생시키는 코드 -->
	<%
		int x = 1/0;
	%>

	<h1>index.jsp page</h1>
	<!-- 
	주석
	지시자 : 앞에 @붙임
	선언문 : 앞에 !붙임 
	스크립트릿 : 자바코드 영역
	표현식 : 앞에 =붙임
	 -->
	 
	 <%
	 /* 주석 */
	 //주석
	 
	 System.out.println("syso test");
	 int num1 = 10;
	 int num2 = 20;
	 %>
	 
	 <%--
	 jsp 주석
	  --%>
	 
	 <span>num의 값은 : <%=num1+num2 %></span>
	 
	 <%
	 //_jspService() 밖에 메소드를 만들어야 한다!!
	 //어떻게??? 선언문 활용하기!!!
	 myMethod();
	 
	 %>

	<%!
	 public void myMethod(){
		 System.out.println("myMethod called....");
	 }
	
	int member_num = 100;
	%>	 
	<%@ include file="views/common/footer.jsp" %>
</body>
</html>