<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalogo Produtos - Academia do Java</title>
<link href= '<%=request.getContextPath()%>/resource/css/jw.css' rel='stylesheet' type='text/css'>
<script type="text/javascript"src="<%=request.getContextPath()%>/resource/js/geral.js"></script>
</head>
<body>

	<h2>Bem vindo! <c:out value="${usuario.nome}" /></h2>
	<H3>Catalogo de produtos </H3>
	
	<table width = '700' border='0'>

		<c:forEach var="item" items="${catalogoProduto}"> 
			<tr class='tituloCampo'>
					<td width = '%20'><img alt="${item.image}" src="resource/img/${item.image}" /></td>
					<td width = '%20'>${item.nome}</td>
					<td width = '%20'>${item.codigo}</td>
					<td width = '%20'>${item.descricao}</td>
					<td width = '%20'>${item.precoFormat}</td>
					<td width = '%20'><a href="controller?service=addProdutoCarrinho&id=${item.id}"><img alt="Carrinho" src="resource/img/carrinho.gif" /></a></td>
				</tr>
		</c:forEach>
	
	</table>
	
</body>
</html>