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
						Ainda não é cadastrado <br> na plataforma de feedback?
					</div>
					<a href="cadastro.jsp" class="botao1" >Cadastre-se</a>
				</div>
			</div>
		</div>
		
		<div class="login">
			<div class="mensagem">
				<c:if test="${ not empty usuarioInvalido}">
					<div class="erro">
							${usuarioInvalido}
					</div>	
				</c:if>
			</div>
			<img src="assets//imagem/logo.png" width="150px">
			<div class="subTitulo">
				Login
			</div>
			<form name="frmLogin" action="login">
				<label class="labelLogin"> E-mail </label>
				<input type="text" placeholder="digite seu e-mail" name="email" id="email">
				<label class="labelSenha"> Senha </label>
				<input type="password" placeholder="digite sua senha" name="senha" id="senha">
			</form>

			<div class="botao1" onclick="autorizacao()" >Login</div> 
		</div>
	</div>
	 <script src="assets/script/validaTextArea.js"></script> 
	 <script>
		window.onload = function() {
			localStorage.removeItem('usuarioLogado')
			localStorage.removeItem('quadro')
		}
	</script>
</body>
</html>