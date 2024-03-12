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

<body>
		<div class="degradeMenu">
			<div class="menu">
				<img src="assets//imagem/logo-branca.png" width="100px">
				<div class=menuUsuarioLogado>
					<div class="botaoSair" onclick="configuracao()" id="usuarioLogado"></div>
					<i class="fas fa-cog " onclick="configuracao()"></i>
				</div>
			</div>
		</div>

		<div class="containerModalEditar" id="containerModal">
			<div class="modal">
				<div class="iconesModal">
				<c:if test="${ not empty pontosPositivo.pontoPositivo}">
					<div class="textoModal">
						Ponto <br> positivo 
					</div>
					<div class="coresModal">
						<div class="corRosa" style="background-color: #ff007f;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor, 'positivo')"></div>
						<div class="corAzul" style="background-color: #add8e6;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor, 'positivo')"></div>
						<div class="corRoxo" style="background-color: #7C08F9;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor, 'positivo')"></div>
						<div class="corAmarelo" style="background-color: yellow;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor, 'positivo')"></div>
						<div class="corLaranja" style="background-color: #ff8300;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor, 'positivo')"></div>
						<div class="corVerde" style="background-color: #ccff33;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor, 'positivo')"></div>
					</div>
				</c:if>
				<c:if test="${ not empty pontosSerMelhorado.pontoSerMelhorado}">
					<div class="textoModal">
						Ponto a ser <br> melhorado 
					</div>
					<div class="coresModal">
						<div class="corRosa" style="background-color: #ff007f;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor)"></div>
						<div class="corAzul" style="background-color: #add8e6;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor)"></div>
						<div class="corRoxo" style="background-color: #7C08F9;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor)"></div>
						<div class="corAmarelo" style="background-color: yellow;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor)"></div>
						<div class="corLaranja" style="background-color: #ff8300;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor)"></div>
						<div class="corVerde" style="background-color: #ccff33;" onclick="mudarCorDoFundoTextArea(this.style.backgroundColor)"></div>
					</div>
				</c:if>
				</div>
				<c:if test="${ not empty pontosPositivo.pontoPositivo}">
					<form name="frmModalPontoPositivo" action="updatePontoPositivo">
						<textarea maxlength="50" class="textoCard" id="textArea" name="textAreaPontoPositivo" rows="3" cols="38" >${pontosPositivo.pontoPositivo}</textarea>
						<input type="text" id="inputPontoPositivo" name="corBackGroundTextArea" value="" hidden="true">
						<input type="text" id="idEditaPositivo" name="idEditaPositivo" value="${param.id}" hidden="true">
					</form>
				</c:if>
				<c:if test="${ not empty pontosSerMelhorado.pontoSerMelhorado}">
					<form name="frmModalPontoSerMelhorado" action="updatePontoSerMelhorado">
						<textarea maxlength="50" class="textoCard" id="textArea1" name="textAreaPontoSerMelhorado" rows="3" cols="38" >${pontosSerMelhorado.pontoSerMelhorado}</textarea>
						<input type="text" id="inputPontoSerMelhorado" name="corBackGroundTextArea" value="" hidden="true">
						<input type="text" id="idEditaPontoSerMelhorado" name="idEditaPontoSerMelhorado" value="${param.id}" hidden="true">
					</form>
				</c:if>
				<div class="botoesModal">
					<div class="botaoModalCancelar" onclick="cancelaEditar()" >Cancelar </div> 
				<c:if test="${ not empty pontosPositivo.pontoPositivo}">
					<div class="botaoModalSalvar" onclick="validarPontoPositivo()" >Salvar</div>
				</c:if>
				<c:if test="${ not empty pontosSerMelhorado.pontoSerMelhorado}">
					<div class="botaoModalSalvar" onclick="validarPontoSerMelhorado()" >Salvar</div>
				</c:if>
				</div>
			</div>
		</div>
	 <script src="assets/script/validaTextArea.js"></script> 
	 <script>
		window.onload = function() {
	    	var usuarioLogado = localStorage.getItem('usuarioLogado');
	    	if (usuarioLogado !== null) {
		        document.getElementById('usuarioLogado').textContent = usuarioLogado;
    		}
		}
	</script>
</body>
</html>
