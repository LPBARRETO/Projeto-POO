<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <%@ page import="com.mack.clinica.model.Usuario" %>
        <% Usuario usuario=(Usuario) request.getAttribute("usuario"); %>
            <!DOCTYPE html>
            <html lang="pt-BR">

            <head>
                <meta charset="UTF-8">
                <title>Meu Cadastro</title>
                <link rel="stylesheet" href="/css/style.css">
            </head>



            <body>
                <!-- Menu de Navegação -->
                <div class="navbar">
                    <div class="nav-links">
                        <a href="paciente_dashboard">Home</a>
                        <a href="agendarConsulta">Agendamento de Consultas</a>
                        <a href="minhaAgenda">Minha Agenda</a>
                        <a href="meuCadastro">Meu Cadastro</a>
                        <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
                    </div>
                </div>

                <div class="content">
                <h1>Meu Cadastro</h1>

                <p><strong>Nome:</strong>
                    <%= usuario.getNome() %>
                </p>
                <p><strong>Email:</strong>
                    <%= usuario.getEmail() %>
                </p>
                <p><strong>Celular:</strong>
                    <%= usuario.getCelular() %>
                </p>
                <p><strong>CPF:</strong>
                    <%= usuario.getCpf() %>
                </p>
            </div>

            </body>

            </html>