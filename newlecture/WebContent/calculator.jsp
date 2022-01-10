<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input {
		width:50px;
		height:50px;
	}

	.output {
		height:50px;
		background: #e9e9e9;
		font-size: 24px;
		font-weight: bold;
		text-align: right;
		padding: 0px 5px;
	}
</style>

</head>
<body>
	<form action="/calc3" method="post">
		<table>
			<tr>
				<!-- 아래 부분을 동적으로 바뀌게 해야 한다! -->
				<td class="output" colspan="4">${3+4}</td>
			</tr>
			<tr>
				<td><input type="submit" name="op" value="CE"></td>
				<td><input type="submit" name="op" value="C"></td>
				<td><input type="submit" name="op" value="BS"></td>
				<td><input type="submit" name="op" value="/"></td>
			</tr>
			<tr>
				<td><input type="submit" name="val" value="7"></td>
				<td><input type="submit" name="val" value="8"></td>
				<td><input type="submit" name="val" value="9"></td>
				<td><input type="submit" name="op" value="*"></td>
			</tr>
			<tr>
				<td><input type="submit" name="val" value="4"></td>
				<td><input type="submit" name="val" value="5"></td>
				<td><input type="submit" name="val" value="6"></td>
				<td><input type="submit" name="op" value="-"></td>
			</tr>
			<tr>
				<td><input type="submit" name="val" value="1"></td>
				<td><input type="submit" name="val" value="2"></td>
				<td><input type="submit" name="val" value="3"></td>
				<td><input type="submit" name="op" value="+"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="val" value="0"></td>
				<td><input type="submit" name="dot" value="."></td>
				<td><input type="submit" name="op" value="="></td>
			</tr>
		</table>
		<!-- <div>
			<label>입력 : <input type="text" name="v"> </label>
		</div>
		<div>
			<input type="submit" name="op" value="+">
			<input type="submit" name="op" value="-">
			<input type="submit" name="op" value="곱셈">
			<input type="submit" name="op" value="나눗셈">
			<input type="submit" name="op" value="=">
		</div> -->
	</form>

</body>
</html>
