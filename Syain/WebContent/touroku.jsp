<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css.css">
<title>登録画面</title>
</head>
<body>
	<div class="header">
		<label>
			  ユーザーID: <s:property value="#session.nameKey"/> 様
		</label>
	</div>


	<s:form theme="simple" action="touroku" method="post">



			<table class="main" width="500px">
				<tr><th colspan="2" bgcolor="#dddddd" width=100%>社員登録画面</th></tr>
				<tr>
				<tr><th colspan="2" ><s:actionerror /></th></tr>
				<tr>
					<th>氏名: </th>
					<td><s:textfield key="name" /></td>
				</tr>
				<tr>
					<th>性別: </th>
					<td><s:radio key="gender" list="#{'1':'男','2':'女'}" /></td>
				</tr>
				<tr>
					<th>生年月日: </th>
					<td><s:textfield key="birthday" value="例)2016-01-01"
						onfocus="if(this.value=='例)2016-01-01'){this.value='';}"/></td>
				</tr>
				<tr>
				<th>&nbsp;</th>
				<td align="right"><s:submit name="touroku" value="登録" align="left"/>
					<input type="button" value="戻る" onClick="location.href='loginSuccess.jsp'"></td>
				</tr>
			</table>
	</s:form>

</body>
</html>