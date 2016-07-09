<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css.css">
<title>ログイン画面</title>
</head>
<body>
	<div>
		<p>ログインID:test</p>
		<p>パスワード:test</p>
	</div>

	<s:form theme="simple" action="login" method="post">
		<Div Align="center"><s:actionerror /></Div>
		<table class="main">
			<tr>
			<th><label>ユーザID :</label></th>
			<td><s:textfield key="id" /></td></tr>
			<tr>
			<th><label>パスワード :</label></th>
			<td><s:password key="pass" /></td></tr>
			<tr>
			<th>&nbsp;</th>
			<td align="right"><s:submit value="ログイン"/></td>
			</tr>
		</table>

	</s:form>
</body>
</html>