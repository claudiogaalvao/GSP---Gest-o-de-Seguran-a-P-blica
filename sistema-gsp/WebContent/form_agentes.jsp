<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
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
<body>

<%     		
    String displaySuccess = (request.getAttribute("sucesso")==null) ? "none" : "block";
    String displayDanger = (request.getAttribute("erro")==null) ? "none" : "block";	
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
                    <h4 class="heading" id="titleForm">Solicitação de acesso</span>
                    </h4>
                    <hr>
                    <div class="alert alert-success" role="alert" style="display: <%= displaySuccess %>">Solicitação enviada com sucesso!</div>
                    <div class="alert alert-danger" role="alert" style="display: <%= displayDanger %>">Algo deu errado. Tente novamente mais tarde.</div>
                    <div class="alert alert-warning" role="alert" style="display: none">Mensagem de erro</div>
                    <p>Preencha a ficha com seus dados para solicitar acesso ao sistema de Gerenciamento da Segurança Pública
                        de Campinas</p>
                    <div class="form">
                        <form action="SolicitaAcesso" method="post" id="contactFrm" name="contactFrm" onsubmit="return validaFormulario();">
                            <input type="text" required="required" placeholder="Nome" value="" name="nome" class="txt">
                            <input type="text" required="required" placeholder="Sobrenome" value="" name="sobrenome" class="txt">
                            <input type="text" required="required" placeholder="Matrícula" value="" name="matricula" id="matricula" class="txt" minlength="8" maxlength="8" onkeyup="somenteNumeros(this);">
							<input type="password" required="required" placeholder="Senha" value="" name="senha" id="senha" class="password" minlength="8" maxlength="8">
							<input type="password" required="required" placeholder="Confirmar senha" value="" name="conf_senha" id="confSenha" class="password" minlength="8" maxlength="8">
							
                            <select  id="cargo" class="form-control" name="cargo" required="required">
                            	<option value="" disabled selected hidden>Selecione um cargo</option>
                                <option>Policial</option>
                                <option>Delegado</option>
                            </select>

                            </br></br></br>

                            <input type="submit" value="Solicitar acesso" name="submit" class="btn btn-primary">
                        </form>
                    </div>
                </div>
            </div>
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
    
    <script>
    function validaFormulario() {
    	var senha = $("#senha").val();
    	var confSenha = $("#confSenha").val();
    	var retorno = false;
    	var mensagem;
    	
    	if(senha==confSenha) {     		
    		//ENTRA SE SENHA E CONFIRMAÇÃO DE SENHA SÃO IGUAIS    		
    		if(IsAlphaNum(senha)) {
    			//ENTRA SE TIVER LETRAS E NUMEROS NA SENHA
    			retorno = true;
    		} else {
    			mensagem = "A senha precisa conter LETRAS E NUMEROS, obrigatóriamente";
    		}
    	} else {
    		mensagem = "Senhas não conferem";
    	}    	
    	
    	if(!retorno) {
    		$(".alert-warning").text(mensagem);
    		$(".alert-warning").show();    		
    	} else {
    		$(".alert-warning").hide();
    	}
    	
    	return retorno;
    }
    
    function somenteNumeros(num) {
        var er = /[^0-9.]/;
        er.lastIndex = 0;
        var campo = num;
        if (er.test(campo.value)) {
          campo.value = "";
        }
    }
    
    function IsAlphaNum( str ) {
    	// Return immediately if an invalid value was passed in
    	if (str+"" == "undefined" || str+"" == "null" || str+"" == "")	
    		return false;
    	var isValid = false;
    	var hasNumber = false;
    	var hasWord = false;
    	
    	// convert to a string for performing string comparisons.
       	str += "";	
    	// Loop through length of string and test for any alpha numeric 
    	// characters
       	for (i = 0; i < str.length; i++)
       	{
    			// Alphanumeric must be between "0"-"9", "A"-"Z", or "a"-"z"
          	if ((str.charAt(i) >= "0") && (str.charAt(i) <= "9")) {
    			hasNumber = true;
    		}
    		if(((str.charAt(i) >= "a") && (str.charAt(i) <= "z")) ||
    			((str.charAt(i) >= "A") && (str.charAt(i) <= "Z"))) {
    			hasWord = true;
    		}
    		
    		if(hasNumber && hasWord) {
    			isValid = true;
    			break;
    		}
       	} 
       
       	return isValid;
    }
    /*
    function tem_numeros(texto){
   	   for(i=0; i<texto.length; i++){
   	      if (numeros.indexOf(texto.charAt(i),0)!=-1){
   	         return true;
   	      }
   	   }
   	   return false;
   	} 
    
    function tem_letras(texto){
   	   texto = texto.toLowerCase();
   	   for(i=0; i<texto.length; i++){
   	      if (letras.indexOf(texto.charAt(i),0)!=-1){
   	         return true;
   	      }
   	   }
   	   return false;
   	} 
    */
    
    </script>

</body>
</html>