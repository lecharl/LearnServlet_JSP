<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><span style = "color: pink;">코코네</span> 피자 가게</h1>
	
	<img src="imgs/menu.png">

	<form action="order" method="post">

        피자 :
    <select name="pizza">
        <option value="치즈피자">치즈피자</option>
        <option value="콤비네이션피자">콤비네이션피자</option>
        <option value="포테이토피자">포테이토피자</option>
        <option value="고구마피자">고구마피자</option>
        <option value="불고기피자">불고기피자</option>
    </select>

    <br>

    토핑 :
	    <label><input type="checkbox" name="topping" value="고구마무스">고구마무스</label>
    	<label><input type="checkbox" name="topping" value="콘크림무스">콘크림무스</label>
    	<label><input type="checkbox" name="topping" value="파인애플토핑">파인애플토핑</label>
    	<label><input type="checkbox" name="topping" value="치즈토핑">치즈토핑</label>
    	<label><input type="checkbox" name="topping" value="치즈크러스트">치즈크러스트</label>
    	<label><input type="checkbox" name="topping" value="치즈바이트">치즈바이트</label>
    	<!-- <label><input type="hidden" name="topping" value=""></label> -->
    <br>

    사이드 :
    	<label><input type="checkbox" name="side" value="오븐구이통닭">오븐구이통닭</label>
    	<label><input type="checkbox" name="side" value="치킨스틱과윙">치킨스틱과윙</label>
    	<label><input type="checkbox" name="side" value="치즈오븐스파게티">치즈오븐스파게티</label>
    	<label><input type="checkbox" name="side" value="새우링과웨지감자">새우링과웨지감자</label>
    	<label><input type="checkbox" name="side" value="갈릭포테이토">갈릭포테이토</label>
    	<label><input type="checkbox" name="side" value="콜라">콜라</label>
    	<label><input type="checkbox" name="side" value="사이다">사이다</label>
    	<label><input type="checkbox" name="side" value="갈릭소스">갈릭소스</label>
    	<label><input type="checkbox" name="side" value="피클">피클</label>
    	<label><input type="checkbox" name="side" value="핫소스">핫소스</label>
    	<label><input type="checkbox" name="side" value="파마산치즈가루">파마산치즈가루</label>
<!--     	<label><input type="hidden" name="side" value=""></label>
 -->
    <br><br>

    <input type="submit" value="주문">

    </form>
</body>
</html>