<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<link href="css/toastr.css" rel="stylesheet">
</head>
<body id="page-top">

<%
	String retorno = String.valueOf(request.getAttribute("retorno"));
    		
    String displaySuccess = (retorno.equals("true")) ? "block" : "none";
    String displayDanger = (retorno.equals("false")) ? "block" : "none";	
%>

	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="secNav">
      <div class="container">
          <a href="index.jsp">Voltar</a>
      </div>
    </nav>

    <section id="sobeForm">
        <div class="container">
            <div class="row">
                <div class="form_main">
                    <h4 class="heading" id="titleForm">Informar Evento</h4>
                    <hr>
                    <p>Apenas funcionários autorizados da prefeitura podem registrar eventos para aumentar o policiamento da área</p>
                    
                    <div id="formEvento" class="form" >
                    	<div class="alert alert-success" role="alert" style="display: <%= displaySuccess %>">Evento registrado com sucesso!</div>
                    	<div class="alert alert-danger" role="alert" style="display: <%= displayDanger %>">Registro não autorizado!</div>
                        <form action="RegistrarEvento" method="post" id="contactFrm" name="contactFrm">
                        
                        	<div class="row">
		                       <div class="col-md-4" style="color: black;">
		                           <h6><b>Matrícula</b></h6>
		                           <input id="matriculaPref" class="txt" type="text" required="" placeholder="Matrícula" name="matriculaPref">
		                           </br></br>
		                       </div>
		                   </div>
 							
 							<h6><b>Nome do evento</b></h6>
                            <input type="text" required="" placeholder="Nome do evento" value="" name="nomeEvento" class="txt">
                            
                            </br></br>
                            <div class="row">
                                <div class="col-md-4" style="color: black;">
                                    <h6><b>Data início</b></h6>
                                    <input type="date" required="" placeholder="Data início" value="" name="dataInicio" class="data">
                                    </br></br>
                                </div>
                                <div class="col-md-4" style="color: black;">
                                    <h6><b>Data fim</b></h6>
                                    <input type="date" required="" placeholder="Data fim" value="" name="dataFim" class="data">
                                    </br></br>
                                </div>
                            </div>    
                            <div class="row">
                                <div class="col-md-4" style="color: black;">
                                    <h6><b>Hora início</b></h6>
                                    <input type="time" required="" placeholder="Hora início" value="" name="hrInicio" class="hora"> 
                                    </br></br>
                                </div>
                                <div class="col-md-4" style="color: black;">
                                    <h6><b>Hora fim</b></h6>
                                    <input type="time" required="" placeholder="Hora fim" value="" name="hrFim" class="hora">
                                    </br></br></br>
                                </div>
                            </div>
                           

                            <input type="submit" value="Registrar evento" name="submit" class="btn btn-primary">
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/creative.min.js"></script>
    
    <script src="js/toastr.js"></script>
    <script src="js/script.js"></script>

</body>
</html>