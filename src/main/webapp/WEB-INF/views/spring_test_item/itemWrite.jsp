<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<form method="post" action="writeResult">
		<tr>
			<td>��ǰ��</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>����</td>
			<td><input type="number" name="price"></td>
		</tr>
		<tr>
			<td>��ǰ��</td>
			<td><input type="text" name="description"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="����">
				<input type="reset" value="���">
			</td>
		</tr>
		</form>
	</table>
</body>
</html>