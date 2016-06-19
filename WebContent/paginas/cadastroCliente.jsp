<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuario</title>
<link href= '<%=request.getContextPath()%>/resource/css/jw.css' rel='stylesheet' type='text/css'>
<script type="text/javascript"src="<%=request.getContextPath()%>/resource/js/geral.js"></script>
</head>
<body>
	
	<span id="msg" class="msg">
			<a href="#" style="float:right;width:30px;text-align: right;" onclick="closeMsg('msg');">X</a>
		<span id="tipoMsg">${tipoMsg}</span>
		<script type="text/javascript">msg('msg', tipoMsg.innerHTML);</script>
		${msg}
	</span>
	
	<br />

	<form action="controller?service=cadastraCliente" method="post">
		<input id="form" name="form" type="hidden" value="cadastroCliente"/>
		<input id="id" name="id" type="hidden" value="${form.id}"/>
		
		<table>
		
			<tr>
				<td>Nome:</td>
				<td><input id="nome" name="nome" type="text" value="${form.nome}"/></td>
			</tr>
			<tr>
				<td>CPF:</td>
				<td><input id="cpf" name="cpf" type="text" value="${form.cpf}" onkeypress="mascara(this, mascaraCpf)" maxlength="14"/></td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td><input id="telefone" name="telefone" type="text" value="${form.telefone}" onkeypress="mascara(this, mascaraTel)" maxlength="11" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input id="email" name="email" type="text" value="${form.email}"/></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input id="senha" name="senha" type="password" value="${form.senha}"/></td>
			</tr>
			<tr>
				<td>Confirma Senha:</td>
				<td><input id="senha2" name="senha2" type="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar"/></td>
			</tr>
		</table>
		
		<a href="controller?service=paginas/index.jsp">Voltar</a>
		
	</form>

</body>
</html>