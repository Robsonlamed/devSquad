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
				<c:if test="${empty quadros}">
					<div id="criarQuadro">
						<form name="frmCriaQuadro" action="quadro">
							<input class="criaQuadro" type="text" id="inputCriaQuadro" name="criaQuadro" value="" >
							<span class="criaQuadroBotao" onclick="criaQuadro()" >Crie um quadro</span>
						</form>
					</div>
				</c:if>
				<c:if test="${not empty quadros }">
					<div class="quadroCriado" id="quadroCriado"> ${quadros} </div>
				</c:if>
					<input class="criaQuadro" type="text" id="inputCriaQuadroValido" name="criaQuadro" hidden="true" value="${quadros}" >
				<div class=menuUsuarioLogado onclick="configuracao()">
					<div class="botaoSair"  id="usuarioLogado"></div>
					<i class="fas fa-cog " ></i>
				</div>
			</div>
		</div>

		<div class="quadros" id="quadro" >
			<div class="pontos" >
				<div class="botao4" onclick="abreModalPontoPositivo()" >Ponto positivo</div> 
				<div class="quadroPP"  >
					<c:forEach var="pontosPositivo" items="${pontosPositivo}">
						<div  class="${pontosPositivo.cor}" draggable="true" id="postit" >
							<div class="botoesEditaExclui">
								<a href="selecionaPontoPositivo?id=${pontosPositivo.id}" class="botaoEditarExcluir"><i class="fas fa-edit"></i></a>
								<a href="javascript: deletaPositivo(${pontosPositivo.id})" class="botaoEditarExcluir"><i class="fas fa-trash"></i></a>
							</div>
							${pontosPositivo.pontoPositivo}
						</div>
					</c:forEach>
				</div>
			</div>
		
			<div class="pontos">
				<div class="botao4" onclick="abreModalPontoSerMelhorado()" >Ponto a ser melhorado</div> 
				<div class="quadroPP" >
					<c:forEach var="pontosSerMelhorado" items="${pontosSerMelhorado}">
						<div class="${pontosSerMelhorado.cor}" draggable="true" >
							<div class="botoesEditaExclui">
								<a href="selecionaPontoSerMelhorado?id=${pontosSerMelhorado.id}" class="botaoEditarExcluir"><i class="fas fa-edit"></i></a>
								<a href="javascript: deletaSerMelhorado(${pontosSerMelhorado.id})" class="botaoEditarExcluir"><i class="fas fa-trash"></i></a>
							</div>
							${pontosSerMelhorado.pontoSerMelhorado}
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="containerModal" id="containerModal">
			<div class="modal">
				<div class="iconesModal">
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
				</div>
				<form name="frmModalPontoPositivo" action="pontoPositivo">
					<textarea maxlength="50" class="textoCard" id="textArea" name="textAreaPontoPositivo" rows="3" cols="38" ></textarea>
					<input type="text" id="inputPontoPositivo" name="corBackGroundTextArea" value="" hidden="true">
				</form>
				<div class="botoesModal">
					<div class="botaoModalCancelar" onclick="fechaModalPontoPositivo()" >Cancelar </div> 
					<div class="botaoModalSalvar" onclick="validarPontoPositivo()" >Salvar</div>
				</div>
			</div>
		</div>
		<div class="containerModal" id="containerModal2">
			<div class="modal">
				<div class="iconesModal">
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
				</div>
				<form name="frmModalPontoSerMelhorado" action="pontoSerMelhorado">
					<textarea maxlength="50" class="textoCard" id="textArea1" name="textAreaPontoSerMelhorado" rows="3" cols="38" ></textarea>
					<input type="text" id="inputPontoSerMelhorado" name="corBackGroundTextArea" value="" hidden="true">
				</form>
				<div class="botoesModal">
					<div class="botaoModalCancelar" onclick="fechaModalPontoSerMelhorado()" >Cancelar </div> 
					<div class="botaoModalSalvar" onclick="validarPontoSerMelhorado()" >Salvar</div> 
				</div>
			</div>
		</div>
		<div class="containerModalConfiguracao" id="containerModalConfiguracao">
			<div class="modalConfiguracao" id="modalConfiguracao">
					<p class="download" id="download" onclick="download()"> <i class="fas fa-download"></i>  Download</p>
					<p class="clear" id="clear" onclick="limpaQuadro()"><i class="fas fa-times"></i> Limpar quadros</p>
				<p class="sair" onclick="logout()"> Sair <i class="fas fa-sign-out-alt"></i></p>
			</div>
		</div>
		
		<form name="frmNomeRelatorio" action="report">
			<input type="text" id="nomeRelatorio" name="nomeRelatorio" value="" hidden="true" >
		</form>
	 <script src="assets/script/validaTextArea.js"> </script> 
	  <script>
		window.onload = function() {
			var quadroCriado = document.getElementById('inputCriaQuadroValido').value
			localStorage.setItem('quadro', quadroCriado);
			var usuarioLogado = localStorage.getItem('usuarioLogado');
	    	if (usuarioLogado !== '') {
		        document.getElementById('usuarioLogado').textContent = usuarioLogado;
    		}
	    	if (usuarioLogado !== 'admin') {
	    		document.getElementById('criarQuadro').style.display = 'none';
	    	}
		}
	</script>
</body>
</html>
