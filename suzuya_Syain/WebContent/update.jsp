<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css.css">
<title>更新画面</title>

<script language="javascript">
<!--
    function update(id){
    	var sid = id;
    	document.frm.syain_id.value = sid;
    	document.frm.submit();
    }
-->
</script>

</head>
<body>
	<div class="header">
		<label>
			  ユーザーID: <s:property value="#session.nameKey"/> 様
		</label>
	</div>
	<Div Align="center"><s:actionerror /></Div>
	<s:form name="frm" theme="simple" action = "upsuccess">
		<div class="body">
			<table>

				<tr>
					<th>社員ID :</th>
					<th><s:property value="syain_id" /></th>
				<tr>
					<th>氏名 :</th>
					<td colspan="2"><input type="text" name="name" maxlength="20"
						value="<s:property value="name" />"></td>
				</tr>
				<tr>
					<th>性別 :</th>
					<th><s:radio key="gender" list="#{'1':'男','2':'女'}"  label="性別"
						value="gender"/></th>
				</tr>
				<tr>
					<th>生年月日 :</th>
					<td colspan="2"><input type="text" name="birthday"
						maxlength="10" value="<s:property value="birthday" />" ></td>
				</tr>
			</table>

			<s:hidden name="syain_id" value=""/>

		</div>
		<div class="input">
			<input type="button" value="更新" onclick="update('<s:property value="syain_id" />')">
			<input type="button" value="戻る" onClick="location.href='list.jsp'">
		</div>
	</s:form>
</body>
</html>