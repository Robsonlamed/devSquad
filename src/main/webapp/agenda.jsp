<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="assets/imagem/favicon.png">
<link rel="stylesheet" href="style.css">

</head>

<body>
	<h1>Agenda de Contatos</h1>
	<div class="botoes">
	<a href="novo.html" class="botao1" >Novo contato</a> 
	<a href="report" class="botao4" >Relatório</a> 
	</div>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Phone</th>
				<th>E-mail</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="contato" items="${contatos}">
			<tr>
				<td> ${contato.id} </td>
				<td> ${contato.nome} </td>
				<td> ${contato.phone} </td>
				<td> ${contato.email} </td>
				<td class="botoes">
					<a href="select?id=${contato.id}" class="botao2">Editar</a>
					<a href="javascript: confirmar(${contato.id})" class="botao3">Excluir</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<script src="assets/script/confirmador.js"></script>
</body>
</html>
