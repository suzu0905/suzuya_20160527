<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css.css">
<title>更新完了画面</title>
</head>
<body>
	<div class="header">
		<label>
			  ユーザーID: <s:property value="#session.nameKey"/> 様
		</label>
	</div>
	<form>
		<div class="body">
			<table>
				<tr><th>社員ID :</th>
				<th><s:property value="syain_id" /></th>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr><th>氏名 :</th>
					<th><s:property value="name" /></th>

				</tr>
				<tr><th>性別 :</th>
					<th><s:property value="ge"  /></th>

				</tr>
				<tr><th>誕生日 :</th>
					<th><s:property value="birthday"  /></th>
				</tr>
			</table>
		</div>
		<div class="input">
			<input type="button" value="戻る" onClick="location.href='loginSuccess.jsp'">
		</div>
	</form>
</body>
</html>