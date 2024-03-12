<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>devSquad</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="icon" href="assets/imagem/logo-icone.png">
<link rel="stylesheet" href="style.css">
</head>

<body >
	<div class="container">
		<div class="degrade">
			<div class="icone">
				<div class="cadastro">
					<div class="cadastreSe">
						Já é cadastrado?
					</div>
					<a href="login.jsp" class="botao1" >Fazer login</a>
				</div>
			</div>
		</div>
		<div class="cadastroUsuario">
			<div class="mensagem">
				<c:if test="${ not empty errorMessage}">
					<div class="erro">
							${errorMessage}
					</div>	
				</c:if>
			</div>
			<img src="assets//imagem/logo.png" width="150px">
			<div class="subTitulo">
				Cadastre-se
			</div>
			<form name="frmCadastro" action="cadastro">
				<label class="labelLogin"> E-mail </label>
				<input type="text" name="email" placeholder="digite seu login">
				<label class="labelSenha"> Senha </label>
				<input type="password" name="senha" placeholder="criar senha">
				<label class="labelConfirmarSenha"> Confirmar senha </label>
				<input type="password" id="confirmaSenha" placeholder="repita a senha">
			</form>
			<div class="confirmacaoDeCadastro">
				Ao realizar seu cadastro, enviaremos um e-mail de confirmação.
				<div class="botao1" onclick="validaUsuarioSenha()" >Cadastrar</div>
			</div>
		</div>
	</div>
	<script src="assets/script/validaUsuario.js"></script> 
</body>
</html>