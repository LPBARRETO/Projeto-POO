<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-BR">

        <head>
            <meta charset="UTF-8">
            <title>Cadastro de Pacientes</title>
            <link rel="stylesheet" href="/css/style.css">
        </head>

        <body>

            <div class="navbar">
                <div class="nav-links">
                    <a href="admin_dashboard">Home</a>
                    <a href="cadastroPacientes">Cadastro de Pacientes</a>
                    <a href="cadastroMedicos">Cadastro de Médicos</a>
                    <a href="#">Consultar Agenda</a>
                    <a href="#">Ficha Clínica</a>
                    <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
                </div>
            </div>
            <h1>Formulário de Paciente</h1>

            <form action="cadastroPacientes" method="post">
                <input type="hidden" name="id" value="${paciente.id != null ? paciente.id : 0}" />

                <label>Nome:</label>
                <input type="text" name="nome" value="${paciente.nome != null ? paciente.nome : ''}" required /><br>

                <label>Email:</label>
                <input type="email" name="email" value="${paciente.email != null ? paciente.email : ''}" required /><br>

                <label>CPF:</label>
                <input type="text" name="cpf" value="${paciente.cpf != null ? paciente.cpf : ''}" required /><br>

                <label>Celular:</label>
                <input type="text" name="celular" value="${paciente.celular != null ? paciente.celular : ''}"
                    required /><br>

                <label>Senha:</label>
                <input type="password" name="senha" value="${paciente.senha != null ? paciente.senha : ''}"
                    required /><br>

                <button type="submit">Salvar</button>
            </form>

        </body>

        </html>