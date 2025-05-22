<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!-- mensagem quado o a agneda falha -->

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Consulta Agendada</title>
    <script>
        window.onload = function() {
            alert("Não é possível agendar uma consulta para uma data passada!"); // Abre a janela pop-up
            //Depois que o usuário clicar em OK, redireciona para o painel
            window.location.href = "/agendarConsulta";
        };
    </script>
</head>
<body>
</body>
</html>
