<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrinho Produtos - Academia do Java</title>
<link href= '<%=request.getContextPath()%>/resource/css/jw.css' rel='stylesheet' type='text/css'>
<script type="text/javascript"src="<%=request.getContextPath()%>/resource/js/geral.js"></script>
</head>
<body>

	<H3>Adicionar produtos no carrinho</H3>
	
	<br />
	
	<table>
		
		<tr>
			<td>Id:</td>
			<td>${produto.id}</td>
		</tr>	
		<tr>
			<td>Código:</td>
			<td>${produto.codigo}</td>
		</tr>	
		<tr>
			<td>Nome:</td>
			<td>${produto.nome}</td>
		</tr>
		<tr>
			<td>Descrição:</td>
			<td>${produto.descricao}</td>
		</tr>
		<tr>
			<td>Preco</td>
			<td>${produto.precoFormat}</td>
		</tr>
		<tr>
			<td>Imagem:</td>
			<td><img alt="${item.image}" src="resource/img/${produto.image}" /></td>
		</tr>
	
	</table>	
	
	<br />
	
	<a href="controller?service=catalogoProdutos">Voltar</a>
</body>
</html>