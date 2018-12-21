<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="DBO.Funcionario"
    import = "javax.servlet.RequestDispatcher"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>GSP - Gestão de Segurança Pública</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/creative.css" rel="stylesheet">
</head>
<body id="page-top" style="padding-left: 100px; padding-right: 100px;">
    
    <jsp:include page="cabecalho_interno.jsp" />
    <section id="sobeForm">
      <div class="container">
        <div class="row">
          <div class="form_main">
            <h4 class="heading" id="titleForm">Solicitações de acesso pendentes</span>
            </h4>
            <hr>
          </div>
        </div>
      </div>
	  <% 
	  
	  List<Funcionario> funcionarios = (List<Funcionario>)request.getAttribute("listFunc");
	  
	  for (Funcionario funcionario : funcionarios) {
	%>
		<div class="col-xl-12 col-sm-6 mb-3">
	        <div class="card text-white o-hidden h-100">
	          <div class="card-body">
	            <div class="row">
	              <div class="col-md-3" style="color: black;">
	                <p>Nome: <strong><%= funcionario.getNomeCompleto() %></strong></p>
	                <p>Matrícula: <strong><%= funcionario.getMatricula() %></strong></p>
	              </div>
	              <div class="col-md-6" style="color: black;">
	                <p>Data da solicitação: <strong><%= funcionario.getDtSolic() %></strong></p>
	              </div>
	              <div class="col-md-3">
	              	<a href="GerenciaSolicitacao?matricula=<%= funcionario.getMatricula() %>&ordem=aprovar">
	              		<button class="btn btn-success" style="width: 100%">Aprovar</button>
	              	</a>	                
	                <p></p>
	                <a href="GerenciaSolicitacao?matricula=<%= funcionario.getMatricula() %>&ordem=reprovar">
	              		<button class="btn btn-danger" style="width: 100%">Recusar</button>
	              	</a>	                
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	<%
		}
	  
	  %>

    </section>

        

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/creative.min.js"></script>

</body>
</html>