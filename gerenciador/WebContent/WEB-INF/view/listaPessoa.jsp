<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="removePessoa" />
<c:url value="/entrada" var="mostraPessoa" />
<c:url value="/entrada?acao=LogOut" var="logout" />
<c:url value="/entrada?acao=NovaPessoaForm" var="novaPessoa" />

<c:import url="cabecalho.jsp"/>

		<p>Usuário logado:${usuarioLogado.login}</p>
		<hr>
		<br>
		<h1><fmt:message key="mensagem.tituloLista" /></h1>
		<div class="row">
    <div class="col-md-4">
        <a href="${novaPessoa}" class="btn btn-info btn-block"><fmt:message key="mensagem.novapessoa" /></a>
    </div>
</div>
		
		<div class="row">
    <div class="col-md-12">
        <table class="table">
            <thead>
                <tr>
                	<th>Nº</th>
                    <th><fmt:message key="mensagem.nome" /></th>
                    <th><fmt:message key="mensagem.data" /></th>
                    <th><fmt:message key="mensagem.sexo" /></th>
                    <th class="acao"><fmt:message key="mensagem.editar" /></th>
                    <th class="acao"><fmt:message key="mensagem.excluir" /></th>
                </tr>
            </thead>
            <tbody>
                	<c:forEach items="${pessoas}" var="pessoa" varStatus="st">
	                    <tr>
	                    	<td>${st.count}</td>
	                        <td>${pessoa.nome}</td>
	                        <td><fmt:formatDate value="${pessoa.data}" pattern="dd/MM/yyyy" /></td>
	                        <td>${pessoa.sexo}</td>
	                        <td><a href="${mostraPessoa}?acao=MostraPessoa&id=${pessoa.id}" class="btn btn-info"><fmt:message key="mensagem.editar" /></a></td>
	                        <td><a href="${removePessoa}?acao=RemoverPessoas&id=${pessoa.id}" class="btn btn-danger"><fmt:message key="mensagem.excluir" /></a></td>
	                    </tr>
               		</c:forEach>
            </tbody>
        </table>
    </div>
</div>
<hr>
<a href="${logout}"><fmt:message key="mensagem.sair" /></a>
<c:import url="rodape.jsp"/>