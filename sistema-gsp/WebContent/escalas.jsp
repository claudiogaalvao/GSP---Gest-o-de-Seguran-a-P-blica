<%@page import="java.util.regex.Pattern"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="DBO.Funcionario"
    import = "javax.servlet.RequestDispatcher"
    %>
<!DOCTYPE html>
<html lang="pt">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>GSP - Escalas</title>

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

  <body id="page-top" style="padding-left: 100px; padding-right: 100px;">
    
    <!-- Navigation -->
    <jsp:include page="cabecalho_interno.jsp" />

    <section>
    
    <% 
	  
	  List<Funcionario> funcionarios = (List<Funcionario>)request.getAttribute("listFunc");
      String flSeg = null, flTer = null, flQua = null, flQui = null, flSex = null, flSab = null, flDom = null;
      String opUm = null, opDois = null, opTres = null, opQuatro = null;
	   
	  for (Funcionario funcionario : funcionarios) {
		  String diasDaSemana = funcionario.getEscala().getDiasDaSemana();
		  diasDaSemana = diasDaSemana.replace(" ", "");
		  String vDiasDaSemana[] = diasDaSemana.split(Pattern.quote(","));
		  
		  String hrInicio = funcionario.getEscala().getHrInicio();
		  
		  flSeg = null;
		  flTer = null;
		  flQua = null;
		  flQui = null;
		  flSex = null;
		  flSab = null;
		  flDom = null;
		  
		  for (String dia : vDiasDaSemana) {
			  if(dia.equals("SEG")) {
				  flSeg = "checked";
			  } else if(dia.equals("TER")) {
				  flTer = "checked";
			  } else if(dia.equals("QUA")) {
				  flQua = "checked";
			  } else if(dia.equals("QUI")) {
				  flQui = "checked";
			  } else if(dia.equals("SEX")) {
				  flSex = "checked";
			  } else if(dia.equals("SAB")) {
				  flSab = "checked";
			  } else {
				  flDom = "checked";
			  }
			  
		  }
		  
		  if(hrInicio.equals("03:00")) {
			  opUm="selected";
		  } else if(hrInicio.equals("09:00")) {
			  opDois="selected";
		  } else if(hrInicio.equals("16:00")) {
			  opTres="selected";
		  } else if(hrInicio.equals("22:00")) {
			  opQuatro="selected";
		  } else {
			  opUm="selected";
		  }
	%>
	<div>
      <div class="col-xl-12 col-sm-6 mb-3">
        <div class="card text-white o-hidden h-100">
          <div class="card-body">
            <div class="row">
              <div class="col-md-6" style="color: black;">
                <p><strong>Nome do(a) Policial</strong>: <%= funcionario.getNomeCompleto() %></p>
                <p><strong>Dias da semana:</strong></p>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="checkSeg" value="SEG" <%= flSeg %> onchange="mudarDiaDaSemana(this, '<%=funcionario.getNome() %>', '<%=funcionario.getSobrenome() %>');">
					<label class="form-check-label" for="inlineCheckbox1">SEG</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="checkTer" value="TER" <%= flTer %> onchange="mudarDiaDaSemana(this, '<%=funcionario.getNome() %>', '<%=funcionario.getSobrenome() %>');">
					<label class="form-check-label" for="inlineCheckbox2">TER</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="checkQua" value="QUA" <%= flQua %> onchange="mudarDiaDaSemana(this, '<%=funcionario.getNome() %>', '<%=funcionario.getSobrenome() %>');">
					<label class="form-check-label" for="inlineCheckbox1">QUA</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="checkQui" value="QUI" <%= flQui %> onchange="mudarDiaDaSemana(this, '<%=funcionario.getNome() %>', '<%=funcionario.getSobrenome() %>');">
					<label class="form-check-label" for="inlineCheckbox2">QUI</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="checkSex" value="SEX" <%= flSex %> onchange="mudarDiaDaSemana(this, '<%=funcionario.getNome() %>', '<%=funcionario.getSobrenome() %>');">
					<label class="form-check-label" for="inlineCheckbox1">SEX</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="checkSab" value="SAB" <%= flSab %> onchange="mudarDiaDaSemana(this, '<%=funcionario.getNome() %>', '<%=funcionario.getSobrenome() %>');">
					<label class="form-check-label" for="inlineCheckbox2">SAB</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="checkDom" value="DOM" <%= flDom %> onchange="mudarDiaDaSemana(this, '<%=funcionario.getNome() %>', '<%=funcionario.getSobrenome() %>');">
					<label class="form-check-label" for="inlineCheckbox2">DOM</label>
				</div>
              </div>
              <div class="col-md-4" style="color: black;">
              	<p><strong>Horário:</strong></p>
              	<select id="horarioEscala" onchange="mudarHorario(this, '<%=funcionario.getNome() %>', '<%=funcionario.getSobrenome() %>');">
              		<option value="03:00,10:00" <%= opUm %>>03:00 às 10:00</option>
			    	<option value="09:00,16:00" <%= opDois %>>09:00 às 16:00</option>
			    	<option value="16:00,23:00" <%= opTres %>>16:00 às 23:00</option>
			    	<option value="22:00,04:00" <%= opQuatro %>>22:00 às 04:00</option>
			    </select>
              </div>
            </div>
          </div>
        </div>
      </div>
    <% } %>
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
    
    <script src="js/script.js"></script>
    <script src="js/toastr.js"></script>
    
    <script>
    	function mudarHorario(elemento, nomeFunc, sobrenomeFunc) {
    		var itemSelecionado = elemento.options[elemento.selectedIndex].value;
    		
    		toastr.options = {
       			"closeButton": false,
   				  "debug": false,
   				  "newestOnTop": false,
   				  "progressBar": true,
   				  "positionClass": "toast-bottom-right",
   				  "preventDuplicates": false,
   				  "onclick": null,
   				  "showDuration": "200",
   				  "hideDuration": "2000",
   				  "timeOut": "3000",
   				  "extendedTimeOut": "2000",
   				  "showEasing": "swing",
   				  "hideEasing": "linear",
   				  "showMethod": "fadeIn",
   				  "hideMethod": "fadeOut"
   			}
    		
    		$.post("http://localhost:8080/sistema-gsp/BuscaEscalas", { horario: itemSelecionado, nome: nomeFunc, sobrenome: sobrenomeFunc },
            function (data) {
            	toastr.success("Horário alterado com sucesso");
            }
            , "html");
    		
    	}
    	
    	function mudarDiaDaSemana(elemento, nomeFunc, sobrenomeFunc) {
    		var valorItem = elemento.value;
    		var estadoItem = elemento.checked;
    		
    		toastr.options = {
       			"closeButton": false,
   				  "debug": false,
   				  "newestOnTop": false,
   				  "progressBar": true,
   				  "positionClass": "toast-bottom-right",
   				  "preventDuplicates": false,
   				  "onclick": null,
   				  "showDuration": "200",
   				  "hideDuration": "2000",
   				  "timeOut": "3000",
   				  "extendedTimeOut": "2000",
   				  "showEasing": "swing",
   				  "hideEasing": "linear",
   				  "showMethod": "fadeIn",
   				  "hideMethod": "fadeOut"
   			}
    		
    		if(estadoItem == true) {
    			
    			$.post("http://localhost:8080/sistema-gsp/BuscaEscalas", { acao: "inserir", dia: valorItem, nome: nomeFunc, sobrenome: sobrenomeFunc },
	            function (data) {
	            	toastr.success("Dias da semana alterado com sucesso");
	            }
	            , "html");
    		} else {
    			$.post("http://localhost:8080/sistema-gsp/BuscaEscalas", { acao: "remover", dia: valorItem, nome: nomeFunc, sobrenome: sobrenomeFunc },
	            function (data) {
	            	toastr.success("Dias da semana alterado com sucesso");
	            }
	            , "html");
    			
    		}
    	}
    </script>

  </body>

</html>
