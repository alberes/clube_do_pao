<%@page import="br.com.grupo.pao.util.ValueUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resource/css/coreClubeDoPao.css">
<title>Clube do Pão</title>
</head>
<body>
<div id="container">
	<jsp:include page="_inc/Menu.html"/>
	<div id="content">
		<fieldset>
			<legend>Cadastro de membro</legend>
			<s:form action="saveMember.action">
				<s:textfield label="Nome" name="name"/>
				<s:textfield label="E-Mail" name="email"/>
				<s:radio label="Dia" name="dayOfWeek" list="#{2:'Segunda',3:'Terca',4:'Quarta',5:'Quinta',6:'Sexta'}"/>
				<s:submit/>
			</s:form>
		</fieldset>
		<s:if test="hasActionErrors()">
			<br /><br />
		   	<div class="errors">
		      <s:actionerror/>
		   	</div>
		</s:if>
	</div>	
</div>
</body>
</html>