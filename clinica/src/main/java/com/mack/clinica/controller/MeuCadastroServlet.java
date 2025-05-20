package com.mack.clinica.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;

@WebServlet("/meuCadastro")
public class MeuCadastroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer idUsuario = (Integer) session.getAttribute("id");

        if (idUsuario == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String path = request.getServletContext().getRealPath("/");
        Usuario usuario = UsuarioDAO.buscarPorId(idUsuario, path);

        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("meu_cadastro.jsp").forward(request, response);
    }
}
