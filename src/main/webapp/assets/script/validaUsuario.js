/**
 * Vaslidação de formulário
 * @author Robson dos Santos
 * 
 */

function validaUsuarioSenha() {
	let email = frmCadastro.email.value
	let senha = frmCadastro.senha.value
	let confirmaSenha =  document.getElementById('confirmaSenha').value
    console.log(confirmaSenha) 
	
	if (email === "") {
        alert("*O campo e-mail é obrigatório!");
        frmCadastro.email.focus();
        return false;
    }
    if (senha === "") {
		 alert("*O campo senha é obrigatório!");
        return false;
    }
    if (confirmaSenha === "") {
		 alert("*O campo confirmar senha é obrigatório!");
        return false;
    }
    if (senha !== confirmaSenha) {
        alert("*As senhas não coincidem. Tente novamente.");
        frmCadastro.senha.focus();
        return false;
    }
	   
    document.forms["frmCadastro"].submit();
}
 
 
 
 
 
 
 
 
 