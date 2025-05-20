<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <%@ page import="com.mack.clinica.model.Usuario" %>
        <% Usuario usuario=(Usuario) request.getAttribute("usuario"); %>
        

        <!DOCTYPE html>
            <html>

            <head>
                <title>Meu Cadastro</title>
                <link rel="stylesheet" type="text/css" href="css/styles.css">
            </head>

            <body>
                <h2>Meu Cadastro</h2>

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

            </body>

            </html>