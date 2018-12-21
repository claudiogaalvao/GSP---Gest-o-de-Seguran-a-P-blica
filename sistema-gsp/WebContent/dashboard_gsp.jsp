<%@page import="java.util.regex.Pattern"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="DBO.Item"
    import = "javax.servlet.RequestDispatcher"
    %>
<!doctype html>


<html>
        <head>
            <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		    <meta name="description" content="">
		    <meta name="author" content="">
		
		    <title>GSP - Dashboard</title>
		
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

            <div align="center">
            <h3>Dashboards - Gest„o de SeguranÁa P˙blica </h3>
            </div>
        </head>
        <body>
        <!-- Navigation -->
    	<jsp:include page="cabecalho_interno.jsp" />
                <div align="center">
                    <br>
                    <br>
                    <br>
                    <p><strong>- Frequencia por Idade</strong> </p>

                <figure>
                    <img src="img/idade.jpeg">
                </figure>
                    <br>
                    <br>
                    <br>
                 <p><strong>- Boxplot Idade</strong> </p>
                    <figure>
                        <img src="img/idade2.jpeg">
                    </figure>    
                    <br>
                    <br>
                    <br>
                    <p><strong>- Frequencia por Sexo</strong> </p>
                    <figure>
                        <img src="img/sexo.jpeg">
                    </figure> 
                    <br>
                    <br>
                    <br>
                    <p><strong>- Previs√µes de quais hor√°rios ocorrer√° mais crimes</strong> </p>
                    <figure>
                        <img src="img/horapico.jpg">
                    </figure> 
                    <br>
                    <br>
                    <br>
                    <p><strong>- Profiss√µes que mais possuem vitimas </strong> </p>
                    <figure>
                        <img src="img/profissoes.png">
                    </figure> 
                </div>
            

            

        </body>
        
        
</html>
