<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-BR">

        <head>
            <meta charset="UTF-8">
            <title>Cadastro de Médicos</title>
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

            <h1>Cadastro de Médicos</h1>

            <a href="cadastroMedicos?action=new" class="button">Novo Médico</a>

            <table>
                <tr>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>CPF</th>
                    <th>Celular</th>
                    <th>Ações</th>
                </tr>
                <c:forEach var="medico" items="${medicos}">
                    <tr>
                        <td>${medico.nome}</td>
                        <td>${medico.email}</td>
                        <td>${medico.cpf}</td>
                        <td>${medico.celular}</td>
                        <td>
                            <a href="cadastroMedicos?action=edit&id=${medico.id}">Editar</a> |
                            <a href="cadastroMedicos?action=delete&id=${medico.id}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </body>

        </html>