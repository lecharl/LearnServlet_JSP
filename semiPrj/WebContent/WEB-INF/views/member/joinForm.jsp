<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #div-main{
        width: 50vw;
        height: 50vh;
        margin: auto;
        background-color: cadetblue;
    }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <%@ include file="/WEB-INF/views/common/header.jsp"%>
    
    <div id="div-main">
        <form action="join" method="post" enctype="multipart/form-data">
            <label>아이디   : </label> <input type="text" name="id" id="idInput"> <button type="button" id="dupCheck">중복확인</button> <br>
            <label>비밀번호 : </label> <input type="text" name="pwd"><br>
            <label>이름 : </label> <input type="text" name="name"><br>
            <label>프로필 사진 : </label> <input type="file" name="profile"><br>
            <input type="submit" value="가입하기">
        </form>
    </div>
    
    <script>
    	$('#dupCheck').on('click', function(){
    		$.ajax({
    			url: '/semi/memberDupCheck',
    			type: 'get',
    			data: {
    				"k1": "v1",
    				"k2": "v2",
    				id: $('#idInput').val()
    			},
    			success: function(data){
    				alert(data);
    			},
    			error: function(err){
    				alert('서버에러ㅠ_ㅠ..')
    			}
    		})
    	})
    </script>

</body>
</html>