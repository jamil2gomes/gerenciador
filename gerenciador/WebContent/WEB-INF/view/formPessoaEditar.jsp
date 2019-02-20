<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada?acao=AlteraPessoa" var="pessoaAtualizada" />

<c:import url="cabecalho.jsp"/>


		<div class="row">
			<div class="col-md-12">
				<h2>Editar Pessoa</h2>
			</div>
		</div>

		<form action="${pessoaAtualizada}" method="post">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">

						<input type="hidden" name="id" value="${pessoa.id}"> Nome:
						<input type="text" name="user"  class = "form-control"  value="${pessoa.nome}">
						<input type="text"  class = "form-control" name="data"
							value="<fmt:formatDate value="${pessoa.data}" pattern="dd/MM/yyyy"/>">
					</div>
					<div class="form-group">		
						<label for="sexo">Sexo</label>
							<select class="form-control"  name="sexo">
								<option value="feminino">feminino</option>
								<option value="masculino">masculino</option>
								<option value="outro">outro</option>
							</select>
					</div>
					
					<input type="submit" class="btn btn-success btn-block" value="Salvar">
				</div>
			</div>
		</form>
<c:import url="rodape.jsp"/>