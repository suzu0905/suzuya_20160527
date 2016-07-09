<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css.css">
<title>メニュー画面</title>
</head>
<body>
	<div class="header">
		<label>
			  ユーザーID: <s:property value="#session.nameKey"/> 様
		</label>
	</div>
	<br>
	<div class="body">
		<table>
			<tr>
				<th>メニュー : </th>
				<td><a href="touroku.jsp">登録画面</a></td>
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td><a href="list.jsp">一覧画面</a></td>
			</tr>
		</table>
	</div>
</body>
</html>