<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="secNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="principal_interno.jsp">GSP - Campinas</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="principal_interno.jsp">Início</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="dashboard_gsp.jsp">Dashboard</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="BuscaOcorrencias">Ocorrências</a>
            </li>
            <% if(session.getAttribute("cargo").equals("Delegado")) { %>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="BuscaEscalas">Escalas</a>
            </li>
            <% } %>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="ConsultaEstoque">Estoque</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="index.jsp">Sair</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>