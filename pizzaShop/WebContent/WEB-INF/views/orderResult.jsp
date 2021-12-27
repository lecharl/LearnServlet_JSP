<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--JSTL 쓰겠다, prefix는 아무거나 써도 됨 --%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문 결과 페이지</h1>
	
	<%-- EL(expression language) ${아하!!} --%>
	<!-- 재스퍼가 인식, 알아서 바꿔줌.. request의 속성 pizzaModel의 ~를 가져온다. 
	request.getAtttribute("pizzaModel").getOrderResult(); 이런식으로?	
	-->
	
	주문 성공 여부 : <span style="color : red;">${pizzaModel.orderResult}</span>
	
	<h3>주문 내역</h3>
	피자 : <span style="color : rebeccapurple">${pizzaModel.pizza}</span><br>
	
	<!-- 배열은 반복문으로 하나씩 꺼내야 한다. 아래는 하나만-->
	<%-- 토핑 : <span style="color : rebeccapurple">${(pizzaModel.topping)[0]}</span><br> --%>
	
	<!-- JSTL(Java standard tag library), prefix를 갖다 쓰기 -->
	토핑 : 
	<c:forEach items="${pizzaModel.topping}" var="t">
		<span style="color : rebeccapurple">${t}, </span>
	</c:forEach>
	<br>
	사이드 : 
	<c:forEach items="${pizzaModel.side}" var="s">
		<span style="color : rebeccapurple">${s}, </span>
	</c:forEach>
	<hr> 
	
	<h1>${key01}</h1>
	<h1>${sessionKey}</h1>
	
	<!-- 가장 작은 영역인 request의 것을 가져온다. -->
	<h1>${testKey}</h1>
	
	<!-- 만약 다른 걸 가져오고 싶으면 scope를 지정한다.-->
	<h1>${sessionScope.testKey}</h1>
	<h1>${ApplicationScope.testKey}</h1>
	
	<hr><hr><hr>
	
	<!-- jstl if문 -->
	<%-- <c:if test="${pizzaModel.pizza} == combination">--%>
	<c:if test="${pizzaModel.pizza eq '콤비네이션피자'}">
		<h1>콤비 ㅇㅋ</h1>
	</c:if>
	
	<c:if test="${1 == 1}">
		<h1>true~</h1>
	</c:if>
		
	<c:set var="myVar" value="myValue"></c:set>
	<h1>${myVar}</h1>

	<hr>	
	<c:set target="${pizzaModel}" property="orderResult" value="changed result~~"/>
	주문 성공 여부 : <span style="color : red;">${pizzaModel.orderResult}</span>
</body>
</html>