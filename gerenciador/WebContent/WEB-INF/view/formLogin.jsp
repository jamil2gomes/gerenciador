<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?acao=Login" var="login" />


<c:import url="cabecalho.jsp"/>
		<div class="row">
			<div class="col-md-12">
				<h2>Log in</h2>
			</div>
		</div>

		<form action="${login}" method="post">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">
						<label>Username</label>
						<input type="text" class = "form-control" name="login"> 
					</div>
					
					<div class="form-group">
						 <label for="senha">Senha</label>
						 <input type="password" class = "form-control" name="senha">
					</div>
					
					<input type="submit" class="btn btn-success btn-block" value="Entrar">
				</div>
			</div>
		</form>
<c:import url="rodape.jsp"/>