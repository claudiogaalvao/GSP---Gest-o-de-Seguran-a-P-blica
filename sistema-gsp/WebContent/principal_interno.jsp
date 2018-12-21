<!DOCTYPE html>
<html lang="en">

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

  <body id="page-top" style="padding-left: 10%; padding-right: 10%;">
  
  	<%
  	
  	if(session.getAttribute("cargo")==null || request.getAttribute("cargo")!=null) {
  		session.setAttribute("cargo", request.getAttribute("cargo"));
  		session.setAttribute("solicitacoes", request.getAttribute("solicitacoes"));
  		session.setAttribute("nome", request.getAttribute("nome"));
  	}
  	
  	String cargo = (String)session.getAttribute("cargo");  	
  	String nome = (String)session.getAttribute("nome");
  	int solic = 0;
  	
  	if(cargo.equals("Delegado")) {
  		solic = (Integer)session.getAttribute("solicitacoes");
  	}
  	
  	if(request.getAttribute("solicitacoes") != null) {
  		int solicNovo = (Integer)request.getAttribute("solicitacoes");
  		if(solic != solicNovo) {
  			solic = solicNovo;
  		}
  	}
  	
  	%>
    
    <jsp:include page="cabecalho_interno.jsp" />

    <section style="text-align: right; margin-top: -45px;">
        <h2>Olá, <%= cargo %> <%= nome %></h2>
        
        <%
        if(cargo.equals("Delegado")) {
        %>
        <p style="color:red;"><a href="GerenciaSolicitacao">
        <%
        	if(solic==1) {
        		out.println("Existe 1 solicitação de acesso pendente");
        	} else if(solic==0) {
        		
        	} else {
        		out.println("Existem " + solic + " solicitações de acesso pendentes");
        	}
        %>
        
        </a></p>
        <%
        }
        %>
        
    </section>

    <section style="margin-top: -120px; padding:0;">
        <!-- Icon Cards-->
        <div class="row">
            <div class="col-xl-6 col-sm-6 mb-3">
                <h5 style="font-weight: bold;">Próximos horários de pico previstos</h5>
                <p>22:12 às 23:33 >> Morro do Alemão </p>
                <p>22:12 às 23:33 >> Rocinha </p>
                <p>22:12 às 23:33 >> Rocinha </p>
            </div>
            <div class="col-xl-3 col-sm-6 mb-3">
                <div class="card text-white bg-success o-hidden h-100">
                    <div class="card-body">
                        <div class="mr-5">
                            <p>Policiais atendendo: <strong>07</strong></p>
                            <p>Policiais ociosas: <strong>07</strong></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-sm-6 mb-3">
                <div class="card text-white bg-danger o-hidden h-100">
                    <div class="card-body">
                        <div class="mr-5">
                            <p>Viaturas atendendo: <strong>07</strong></p>
                            <p>Viaturas ociosas: <strong>07</strong></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3677.159691552596!2d-47.05107198442816!3d-22.83358064100478!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94c8c428eba81223%3A0xa8d0efb710aadd9d!2sPontif%C3%ADcia+Universidade+Cat%C3%B3lica+de+Campinas!5e0!3m2!1spt-BR!2sbr!4v1538607997082" width="100%" height="600" frameborder="0" style="border:0" allowfullscreen></iframe>
    

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
