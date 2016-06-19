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
		<a href="#" onclick="closeMsg('msg');">X</a>
		<span id="tipoMsg">${tipoMsg}</span>
		<script type="text/javascript">msg('msg', tipoMsg.innerHTML);</script>
		${msg}
	</span>
	
	<br />

	<form action="controller?service=login" method="post">
		
		<input id="form" name="form" type="hidden" value="login"/>
		
		<table>
		
			<tr>
				<td>Digite seu Email:</td>
				<td>Digite sua Senha:</td>
			</tr>
			<tr>
				<td><input id="email" name="email" type="text" value="${form.email}"/></td>
				<td><input id="senha" name="senha" type="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" style="float: right;"/></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: left;"><a href="controller?service=paginas/cadastroCliente.jsp">Cadastrar</a></td>
			</tr>
		</table>
		
	</form>

</body>
</html>