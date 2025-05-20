<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-BR">

        <head>
            <meta charset="UTF-8">
            <title>Minha Agenda</title>
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

            <!-- Conteúdo principal -->
            <div class="content">
                <h1>Minha Agenda</h1>

                <c:if test="${empty consultas}">
                    <p>Você não possui consultas agendadas.</p>
                </c:if>

                <c:if test="${not empty consultas}">
                    <table>
                        <thead>
                            <tr>
                                <th>Data e Hora</th>
                                <th>Médico</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="consulta" items="${consultas}">
                                <tr>
                                    <td>${consulta.dataHora}</td>
                                    <td>${consulta.nomeMedico}</td>
                                    <td>${consulta.status}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>

        </body>

        </html>