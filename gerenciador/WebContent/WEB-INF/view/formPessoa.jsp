<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?acao=NovaPessoa" var="novaPessoa" />
<c:import url="cabecalho.jsp"/>


		<div class="row">
			<div class="col-md-12">
				<h2>Criar Nova Pessoa</h2>
			</div>
		</div>

		<form action="${novaPessoa}" method="post">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">
					<label for="user">Nome</label>
					<input  class = "form-control" type="text" name="user"> 
					</div>
					
					<div class="form-group">
					<label for="data">Data de Nascimento</label>
					<input type="text" class = "form-control"  name="data"> 
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