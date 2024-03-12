/**
 * Vaslidação de formulário
 * @author Robson dos Santos
 * 
 */

function abreModalPontoPositivo() {
	 var usuarioLogado = localStorage.getItem('usuarioLogado');
	 let criaQuadro = localStorage.getItem('quadro');
	 if (usuarioLogado === 'admin') {
		 if(criaQuadro !== ""){
		 	document.getElementById('containerModal').style.display = 'block';
		 } else {
			 alert("Crie um quadro para começar")
		 }
	 } else if(criaQuadro !== "") {
		 document.getElementById('containerModal').style.display = 'block';
	 } else {
		 alert("Um administrador deve criar um quadro primeiro.")
	 }
}

function abreModalPontoSerMelhorado() {
	 var usuarioLogado = localStorage.getItem('usuarioLogado');
	 let criaQuadro = localStorage.getItem('quadro');
	 if (usuarioLogado === 'admin') {
		 if(criaQuadro !== ""){
		 	document.getElementById('containerModal2').style.display = 'block';
		 } else {
			 alert("Crie um quadro para começar")
		 }
	 } else if(criaQuadro !== "") {
		 document.getElementById('containerModal').style.display = 'block';
	 } else {
		 alert("Um administrador deve criar um quadro primeiro.")
	 }
}

function fechaModalPontoPositivo() {
	document.getElementById('textArea').style.backgroundColor = 'white';
	document.getElementById('containerModal').style.display = 'none';
	document.getElementById('textArea').value = "";
}

function fechaModalPontoSerMelhorado() {
	document.getElementById('textArea1').style.backgroundColor = 'white';
	document.getElementById('containerModal2').style.display = 'none';
	document.getElementById('textArea1').value = "";
}

 function configuracao() {
	var modal = document.getElementById('containerModalConfiguracao');
	var displayStatus = getComputedStyle(modal).display;
	var usuario = localStorage.getItem('usuarioLogado');
	
	if(usuario !== "admin"){
		document.getElementById('download').style.display = 'none';
		document.getElementById('clear').style.display = 'none';
	} 
	
	if(displayStatus === 'none') {
		document.getElementById('containerModalConfiguracao').style.display = 'block';
	} else {
		document.getElementById('containerModalConfiguracao').style.display = 'none';
	}
	
 }
 

 function validarPontoPositivo() {
	 let pontoPositivo = frmModalPontoPositivo.textAreaPontoPositivo.value
	 let cor = document.getElementById('inputPontoPositivo').value
	 
	 if(pontoPositivo === "") {
		 alert('*Não esqueça de deixar o seu ponto positivo!')
		 frmModalPontoPositivo.textAreaPontoPositivo.focus()
		 return false
	 } else if (cor === "") {
		 alert("Escolha uma cor!")
		 return false
	   } else {
		   document.forms["frmModalPontoPositivo"].submit()
	   }
 }
 
 function validarPontoSerMelhorado() {
	 let pontoSerMelhorado = frmModalPontoSerMelhorado.textAreaPontoSerMelhorado.value
	 let cor = document.getElementById('inputPontoSerMelhorado').value
	 
	 if(pontoSerMelhorado === "") {
		 alert('*Não esqueça de deixar o seu ponto a ser melhorado!')
		 frmModalPontoSerMelhorado.textAreaPontoSerMelhorado.focus()
		 return false
	 } else if (cor === "") {
		 alert("Escolha uma cor!")
		 return false
	   } else {
		   document.forms["frmModalPontoSerMelhorado"].submit()
	   }
 }
 
 function autorizacao(){
	let email = frmLogin.email.value
	let senha = frmLogin.senha.value
	localStorage.setItem('usuarioLogado', email);
	localStorage.setItem('quadro', "");
	 if(email === "") {
		 alert('*Campo e-mail é obrigatório.')
		 frmLogin.email.focus()
		 return false
	 } else if (senha === "") {
		 alert("Campo senha é obrigatório.")
		 return false
	   } else {
		   document.forms["frmLogin"].submit()
	   }
}
 
function mudarCorDoFundoTextArea(cor, ponto) {
	let inputElementoPontoPositivo = document.getElementById('inputPontoPositivo');
	let inputElementoPontoSerMelhorado = document.getElementById('inputPontoSerMelhorado');
	switch (cor) {
		case "rgb(255, 131, 0)":
			if(ponto === 'positivo'){
				document.getElementById('textArea').style.backgroundColor = cor;
				inputElementoPontoPositivo.value = "laranja"
			} else {
				document.getElementById('textArea1').style.backgroundColor = cor;
				inputElementoPontoSerMelhorado.value = "laranja"
			}
		break;
		case "rgb(255, 0, 127)":
			if(ponto === 'positivo'){
				document.getElementById('textArea').style.backgroundColor = cor;
				inputElementoPontoPositivo.value = "rosa"
			} else {
				document.getElementById('textArea1').style.backgroundColor = cor;
				inputElementoPontoSerMelhorado.value = "rosa"
			}
		break;
		case "rgb(173, 216, 230)":
			if(ponto === 'positivo'){
				document.getElementById('textArea').style.backgroundColor = cor;
				inputElementoPontoPositivo.value = "azul"
			} else {
				document.getElementById('textArea1').style.backgroundColor = cor;
				inputElementoPontoSerMelhorado.value = "azul"
			}
		break;
		case "rgb(124, 8, 249)":
			if(ponto === 'positivo'){
				document.getElementById('textArea').style.backgroundColor = cor;
				inputElementoPontoPositivo.value = "roxo"
			} else {
				document.getElementById('textArea1').style.backgroundColor = cor;
				inputElementoPontoSerMelhorado.value = "roxo"
			}
		break;
		case "yellow":
			if(ponto === 'positivo'){
				document.getElementById('textArea').style.backgroundColor = cor;
				inputElementoPontoPositivo.value = "amarelo"
			} else {
				document.getElementById('textArea1').style.backgroundColor = cor;
				inputElementoPontoSerMelhorado.value = "amarelo"
			}
		break
		case "rgb(204, 255, 51)":
			if(ponto === 'positivo'){
				document.getElementById('textArea').style.backgroundColor = cor;
				inputElementoPontoPositivo.value = "verde"
			} else {
				document.getElementById('textArea1').style.backgroundColor = cor;
				inputElementoPontoSerMelhorado.value = "verde"
			}
		break;
	default:
		alert(cor)
	}
}

function deletaPositivo (id) {
	 let resposta = confirm("Confirmar a exclusão do ponto positivo " +  id + " ? ")
	 if (resposta === true ) {
		 alert("Ponto positivo " + id + " foi excluído com sucesso.")
		 window.location.href = "delete?id=" + id 
	 }
 }
 
function deletaSerMelhorado (id) {
	 let resposta = confirm("Confirmar a exclusão do ponto a ser melhorado " +  id + " ? ")
	 if (resposta === true ) {
		 alert("Ponto a ser melhorado " + id + " foi excluído com sucesso.")
		 window.location.href = "deletePontoSerMelhorado?id=" + id 
	 }
 }
 
 function editar () {
	document.forms["frmEditaPontoPositivo"].submit()
	document.getElementById('containerModalEditaPositivo').style.display = 'block';
 }
 
 function cancelaEditar() {
	 window.location.href = 'main'
 }
 
  function criaQuadro () {
	 let criaQuadro = document.getElementById('inputCriaQuadro').value;
	  localStorage.setItem('quadro', criaQuadro);
	if(criaQuadro !== ""){
		document.forms["frmCriaQuadro"].submit()
	}
 }
 
 function download(){
	 let criaQuadro = document.getElementById('quadroCriado').innerText;
	 if(criaQuadro !== ""){
		document.getElementById('nomeRelatorio').value = criaQuadro;
		document.forms["frmNomeRelatorio"].submit()
	} else {
		alert("Seus quadros precisam de um título.")
	}
}
 
 function limpaQuadro(){
	 let criaQuadro = document.getElementById('quadroCriado').innerText;
	 if(criaQuadro !== ""){
		 let resposta = confirm("Tem certeza que quer excluir os quadros?")
		 if (resposta === true ) {
			window.location.href = 'limparQuadros'
 	     }
	 }
} 

 function logout(){
	 var usuarioLogado = localStorage.getItem('usuarioLogado');
	 if(usuarioLogado === "admin") {
		 let resposta = confirm("Tem certeza que deseja sair? Os quadros serão apagados.")
		 if (resposta === true ) {
			window.location.href = 'logout'
     	 } 
	 } else {
		 let resposta = confirm("Tem certeza que deseja sair?")
		 if (resposta === true ) {
			window.location.href = 'login.jsp'
     	 } 
	 }
 }







