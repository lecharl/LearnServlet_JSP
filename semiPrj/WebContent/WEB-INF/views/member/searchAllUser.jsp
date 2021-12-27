<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#div-wrap{
        width : 70vw;
        background-color : skyblue;
        margin : 0 auto;
    }
    table{
        width : 100%;
    }

</style>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<h1>탐색</h1>

	<c:forEach items="${memberList}" var="m">
		<h1>${m.name}</h1>
	</c:forEach>

	<div id="div-wrap">
		<form action="search" method="get">
			<select name="searchType" id="">
				<option value="MEMBER_NO">번호</option>
				<option value="ID">아이디</option>
				<option value="NAME">이름</option>
			</select>
			<input type="text" name="searchValue" id="">
			<input type="submit" value="검색">
		</form>

		<table border="1">
			<tr>
				<td>회원번호</td>
				<td>아이디</td>
				<td>이름</td>
			</tr>
			<c:forEach items="${memberList}" var="m">
			<tr>
				<td>${m.memberNo}</td>
				<td>${m.id}</td>
				<td>${m.name}</td>
			</tr>
			</c:forEach>
	</table>
	
	<!-- ?씩 증가하게 하려면 step="숫자", 디폴트는 step="1" -->
	<div class="page-area" style="text-align:center">
	<c:forEach var="i" begin="${startPage}" end="${maxPage}" >
		<c:if test="${i le maxPage}">
			<a href="search?currentPage=${i}">${i}</a>
		</c:if>
	</c:forEach>
	</div>

	<%-- <h1>${memberList[0].name}</h1>
	<h1>${memberList[1].name}</h1> --%>
	</div>
</body>
</html>
