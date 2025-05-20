package com.mack.clinica.controller;

import com.mack.clinica.model.AgendarConsultaDAO;
import com.mack.clinica.model.Consulta;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// import com.mack.clinica.model.Usuario;
// import com.mack.clinica.model.UsuarioDAO;

@WebServlet("/minhaAgenda")
public class MinhaAgendaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer pacienteId = (Integer) session.getAttribute("id");
        String realPath = request.getServletContext().getRealPath("/");

        if (pacienteId != null) {
            List<Consulta> consultas = AgendarConsultaDAO.buscarPorPaciente(pacienteId, realPath);
            request.setAttribute("consultas", consultas);
            request.getRequestDispatcher("/minha_agenda.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
    
}