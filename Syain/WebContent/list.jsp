<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css.css">
<title>一覧画面</title>
</head>
<body>
	<div class="header">
		<label> ユーザーID: <s:property value="#session.nameKey" /> 様
		</label>
	</div>
	<div class="namesearch">
		<s:form theme="simple" action="list" >
			<label>検索条件 :</label>
			<s:textfield key="name" label="氏名" />
			<s:submit name="search" value="検索" />
			<input type="button" value="戻る" onClick="location.href='loginSuccess.jsp'">
		</s:form>
	</div>

	<hr width="100%" size="5" color="#000">

	<table class="list" border="1">
		<tr bgcolor="#dddddd">
			<th>社員ID</th>
			<th>氏名</th>
			<th>性別</th>
			<th>生年月日</th>
			<th>&nbsp;</th>
		</tr>
	</table>
</body>
</html>