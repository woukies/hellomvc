<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th colspan="2">
					<h1>ȸ�� ���� ��û</h1><br>
					* ǥ�� �׸�: �ʼ� �Է�
				</th>
			</tr>
		</thead>
		<tbody>
			<form action="register_check" method="post">
			<tr>
				<td>���̵�</td>
				<td><input type="text" name="mem_uid"></td>
			</tr>
			<tr>
				<td>��ȣ</td>
				<td><input type="password" name="mem_pwd"></td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="mem_name"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="���">
				</td>
			</tr>
			</form>
		</tbody>
	</table>
</body>
</html>