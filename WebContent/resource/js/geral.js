
function msg(id, tipoMsg){
	
	elemento = document.getElementById(id);
	
	var cor = "";
	if(tipoMsg == "ERRO"){
		cor = "#F00";
	}else if(tipoMsg == "WARN"){
		cor = "#FFD700";
	}else if(tipoMsg == "SUCESS"){
		cor = "#1E90FF";
	}else {
		elemento.style.visibility = "hidden";
		return;
	}
	elemento.style.visibility = "visible";
	elemento.style.backgroundColor = cor;
}

function closeMsg(id){
	document.getElementById(id).style.display="none";
}




var _campoMascara;

var _funcaoMascara;



function mascara(campo, funcao){
	
	_campo = campo;
	_funcao = funcao;
	setTimeout("execMascara()", 1);
	
}


function execMascara(){
	_campo.value = _funcao(_campo.value);
}



function mascaraCep(valor){
	var cep = valor;
	cep = cep.replace(/\D/g, "");
	cep = cep.replace(/(\d{5})(\d)/, "$1-$2");
	return cep;
}

function mascaraCpf(valor){
	
	var cpf = valor;
	cpf = cpf.replace(/\D/g, "");
	cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
	cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
	cpf = cpf.replace(/(\d{3})(\d)/, "$1-$2");
	return cpf;
}


function mascaraTel(valor){
	
	var tel = valor;
	tel = tel.replace(/\D/g, "");
	telLen = tel.length;
	if(telLen >= 9){
		tel = tel.replace(/(\d{5})(\d)/, "$1-$2");
	}else{
		tel = tel.replace(/(\d{4})(\d)/, "$1-$2");
	}

	if(tel.length > 10){
		tel = tel.substring(0,10);
	}
	
	return tel;
}