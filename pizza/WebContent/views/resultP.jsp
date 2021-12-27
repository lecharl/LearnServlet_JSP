<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주문 내역</h2>
	<p style="font-weight: bold;">
		피자는 <span style="color: red;">
<% 
	String pizza = request.getParameter("pizza");
	out.print(pizza);
%>		
		</span>,
		토핑은 <span style="color: green;">
<%
	String[] topping = request.getParameterValues("topping");
	if(topping != null){
		for (String t : topping) {
				out.print(t +", ");
		}
	} else{
		out.print("없고, ");
	}
%>
		</span>
		사이드는 <span style="color: blue;">
<%
	String[] side = request.getParameterValues("side");
	if(side != null){
		for (String s : side) {
				out.print(s +", ");
		}
	} else{
		out.print("없이 ");
	}
%>		
		</span> 주문하셨습니다.
	</p>
<%
	int pPrice = 0;
	switch(pizza){
	case("치즈피자"):
		pPrice = 5000;
		break;
	case("콤비네이션피자"):
		pPrice = 5000;
		break;
	case("포테이토피자"):
		pPrice = 7000;
		break;
	case("고구마피자"):
		pPrice = 7000;
		break;
	case("불고기피자"):
		pPrice = 8000;
		break;
	default:
		pPrice = 0;
	}
	
//	if("콤비네이션피자".equals(pizza)){
//		pPrice = 6000;
//	} else if("포테이토피자".equals(pizza)){
//		pPrice = 7000;
//	} else if("고구마피자".equals(pizza)){
//		pPrice = 7000;
//	} else if("불고기피자".equals(pizza)){
//		pPrice = 8000;
//	} 
	
	int tPrice = 0;
	for (String t : topping){
		if("고구마무스".equals(t)){
			tPrice += 1000;
		} else if("콘크림무스".equals(t)){
			tPrice += 1500;
		} else if("파인애플토핑".equals(t)){
			tPrice += 2000;
		} else if("치즈토핑".equals(t)){
			tPrice += 2000;
		} else if("치즈크러스트".equals(t)){
			tPrice += 2000;
		} else {
			tPrice += 3000;
		}
	}
	
	int sPrice = 0;
	for (String s : side){
		if("오븐구이통닭".equals(s)){
			sPrice += 9000;
		} else if("치킨스틱과윙".equals(s)){
			sPrice += 4900;
		} else if("치즈오븐스파게티".equals(s)){
			sPrice += 4000;
		} else if("새우링과웨지감자".equals(s)){
			sPrice += 3500;
		} else if("갈릭포테이토".equals(s)){
			sPrice += 3000;
		} else if("콜라".equals(s)){
			sPrice += 1500;
		} else if("사이다".equals(s)){
			sPrice += 1500;
		} else if("갈릭소스".equals(s)){
			sPrice += 500;
		} else if("피클".equals(s)){
			sPrice += 300;
		} else if("핫소스".equals(s)){
			sPrice += 100;
		} else {
			sPrice += 100;
		}
	}
	
	int total = pPrice+tPrice+sPrice;

%>
<!-- 가격 : ${100+123} 원-->
	<br><br>
	<h3>총합 : <span style="text-decoration: underline;"><%=total%>원</span></h3>
	<br>
	<h2 style="color: pink;">즐거운 식사시간 되세요 ~</h2>
</body>
</html>
