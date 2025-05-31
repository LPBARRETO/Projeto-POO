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

            <h1>Cadastro de Pacientes</h1>

            <a href="cadastroPacientes?action=new" class="button">Novo Paciente</a>

            <table>
                <tr>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>CPF</th>
                    <th>Celular</th>
                    <th>Ações</th>
                </tr>
                <c:forEach var="paciente" items="${pacientes}">
                    <tr>
                        <td>${paciente.nome}</td>
                        <td>${paciente.email}</td>
                        <td>${paciente.cpf}</td>
                        <td>${paciente.celular}</td>
                        <td>
                            <a href="cadastroPacientes?action=edit&id=${paciente.id}">Editar</a> |
                            <a href="cadastroPacientes?action=delete&id=${paciente.id}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </body>

        </html>