package com.mack.clinica.controller;


import java.io.IOException;

import java.util.List;

import com.mack.clinica.model.AgendarConsultaDAO;
import com.mack.clinica.model.Consulta;
import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;
import com.mack.clinica.model.Medico;
import com.mack.clinica.model.Paciente;
import com.mack.clinica.model.PacienteService;
import com.mack.clinica.model.MedicoService;
import com.mack.clinica.model.UsuarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastroPacientes")
public class CadastroPacientesServlet extends UsuarioCrudServlet<Paciente> {

    private final PacienteService service = new PacienteService();

    @Override
    protected UsuarioService<Paciente> getService() {
        return service;
    }

    @Override
    protected String getTipo() {
        return "paciente";
    }

    @Override
    protected String getListagemJsp() {
        return "/cadastro_pacientes.jsp";
    }

    @Override
    protected String getFormularioJsp() {
        return "/pacientes_form.jsp";
    }

@Override
    protected String getRedirectUrl() {
    return "cadastroPacientes";
    }

    @Override
    protected Paciente criarUsuario(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String celular = request.getParameter("celular");
        String senha = request.getParameter("senha");
        return new Paciente(id, nome, email, cpf, celular, senha);
    }
}
