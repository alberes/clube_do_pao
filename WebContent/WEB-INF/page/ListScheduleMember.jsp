<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resource/css/coreClubeDoPao.css">
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

table td, th {
	border: 1px solid #999;
	padding: 0.1em 1em;
}
</style>
<title>Clube do Pão</title>
</head>
<body>
<div id="container">
	<jsp:include page="_inc/Menu.html"/>
	<div id="content">	
		<div>
			<h3>Lista de membros designados</h3>
		</div>
		<table id="listTable">
			<tr>
				<td><strong>Dia</strong></td><td><strong>Dia da semana</strong></td><td><strong>Nome</strong></td>
			</tr>
			<s:iterator value="scheduleMembers" var="schedule">
				<tr>
					<td><s:date name="#schedule.date" format="dd/MM"/></td>
					<td><s:date name="#schedule.date" format="EEEE"/></td>
					<s:if test="#schedule.memberBean == null">
						<td>SEM PAO - Remanejar membro</td>
					</s:if>
					<s:else>
						<td><s:property value="#schedule.memberBean.name"/></td>
					</s:else>
				</tr>
			</s:iterator>			
		</table>
	</div>
</div>
</body>
</html>