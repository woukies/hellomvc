<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="500" border="1">
		<form method="post" action="modify">
			<input type="hidden" name="bId" value="${content_view.bId}">
			<tr>
				<th>��ȣ</th>
				<td>${content_view.bId}</td>
			</tr>
			<tr>
				<th>��Ʈ</th>
				<td>${content_view.bHit}</td>
			</tr>
			<tr>
				<th>�̸�</th>
				<td>
					<input type="text" name="bName" value="${content_view.bName}">
				</td>
			</tr>
			<tr>
				<th>����</th>
				<td>
					<input type="text" name="bTitle" value="${content_view.bTitle}">
				</td>
			</tr>
			<tr>
				<th>����</th>
				<td>
					<input type="text" name="bContent" value="${content_view.bContent}">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="����"> &nbsp;
					<a href="delete?bId=${content_view.bId}">����</a> &nbsp;
					<a href="list">��Ϻ���</a>
				</td>
			</tr>
		</form>
	</table>
</body>
</html>