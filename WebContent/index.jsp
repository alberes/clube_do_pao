<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resource/css/coreClubeDoPao.css">
<title>Clube do Pão</title>
</head>
<body>
<div id="container">
	<div id="content">
		<fieldset>
			<legend>Login</legend>
			<s:form action="login.action">
				<s:textfield label="E-Mail" name="email" value="admin@clubedopao.com.br"/>
				<s:password label="Password" name="password" value="admin"/>
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
	<br />
	<div>
		<strong>Dados para logar:</strong><br />
		<br />
		admin@clubedopao.com.br<br />
		admin
	</div>
	<br />
	<div>
		Para cadastrar o membro foi utilizado o atributo email como identificado único.
		Caso queira alterar o dia da semana basta inserir os dados novamente e alterar o dia.
	</div>
	<br />
	<div>
		O agendamento é uma data no formato dd/mm/aaaa.
	</div>
	<br />	
	<div>
		<strong>Ambiente de desenvolvimento:</strong><br />
		<strong>JDK</strong><br />
		java version "1.7.0_51"<br />
		Java(TM) SE Runtime Environment (build 1.7.0_51-b13)<br />
		Java HotSpot(TM) 64-Bit Server VM (build 24.51-b03, mixed mode)<br />
		<strong>Container:</strong> Tomcat 7<br />
		<strong>Framework MVC:</strong> Struts 2.3<br />
		<strong>JPA:</strong> Versão 2.0<br />
		<strong>Banco de dado:</strong> objectdb-2.5.4_04<br />
		<br />
		<br />
		<strong>Requisitos minimos: JDK versao 5 ou superior</strong>
	</div>
	<br /><br />
	<div>
<pre>
	<strong>A ideia é basicamente a seguinte:</strong>

O clube do pão da Bluesoft consiste em um rodízio entre seus membros, de modo que cada dia da semana um membro diferente compra pães franceses frescos, pela manhã, para os demais membros.
Exemplo: Em um clube do pão com 10 membros, na Segunda-feira o Fulano ficou encarregado de comprar 10 pães (1 para ele + 9 para os demais). Na terça, a vez é do Siclano comprar 10 pães, e assim por diante.

Sua tarefa é criar um sistema simples onde um usuário administrador manteria um cadastro de membros de um clube do pão. Cada membro tem:
Nome

E-mail

Disponbilidade: quais dias da semana ele pode trazer o pão (de segunda até sexta)

O usuário deverá dispor de uma tela para manter os cadastros.

Também haverá outra tela para gerar uma relação dos encarregados de comprar o pão em qual dia. Nesta tela, o usuário deverá informar uma data inicial para geração da tabela. Algo assim:
Data incial: __/__/____
 Gerar 

Ao clicar em “gerar”, o sistema gera uma tabela de 30 dias a partir da data inicial informada, com o dia do mês, dia da semana e nome. Exemplo: 
Data inicial: 01/01/2014

--------------------------------------
| 01/01 | Quinta  |      Cabelo      |
| 02/01 | Sexta   |      Wendola     |
| 03/01 | Segunda |      Diego       |
|  ...  |   ...   |       ...        |
--------------------------------------

Essa tabela será impressa e fixada em local visível para que todos saibam qual é o dia de cada um trazer o pão. A tabela deverá:
formar um ciclo pelos membros de maneira que um membro não precise trazer o pão mais de uma vez por semana
pular os finais de semana
somente designar o membro caso o dia da semana esteja entre os dias de disponibilidade

Caso não seja possível decidir quem irá trazer o pão em um determinado dia, por falta de disponibilidade, gerar “SEM PÃO” no dia e avisar o usuário para que remaneje os dias de disponibilidade dos membros.

Observação: a descrição é breve propositalmente para que possamos avaliar sua criatividade. 

Quanto ao prazo é o mais rápido que você puder, assim que você terminar, poderemos partir para o segundo desafio e marcar a entrevista.

É essencial que o código tenha ao menos testes de unidade para que possamos avaliar seu projeto, e que os arquivos de código sejam enviados para o github (não envie um arquivo .zip ou .rar).

É preciso também deixar o projeto rodando para que seja acessado pela equipe via Internet  (AWS, RackSpace, Linode, openshift, Heroku, etc.)

Se tiver alguma dúvida, envie um e-mail para talentos@bluesoft.com.br
</pre>
	</div>
</div>
</body>
</html>