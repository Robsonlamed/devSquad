<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="assets/imagem/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar contato</h1>
	
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td>Id: <input type="text" name="id" id="caixa2" readonly
					value="${param.id}">
				</td>
			</tr>
			 
			<tr>
				<td>Nome: <input type="text" name="nome" maxlength="20"
					class="caixa1"  value="${contato.nome}">
				</td>
			</tr>
			<tr>
				<td>Telefone: <input type="text" name="phone" maxlength="15"
					class="caixa1" value="${contato.phone}">
				</td>
			</tr>
			<tr>
				<td>E-mail: <input type="text" name="email" maxlength="20"
					class="caixa1" value="${contato.email}">
				</td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="botao1" onclick="validar()">
	</form>
	<script src="assets/script/validador.js"></script>
</body>
</html>