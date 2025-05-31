package com.mack.clinica.controller;

import java.io.IOException;

import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.HashMap;
import java.util.function.BiConsumer;

import com.mack.clinica.model.Medico;
import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.Paciente;
import com.mack.clinica.model.MedicoService;
import com.mack.clinica.model.UsuarioService;
import com.mack.clinica.model.PacienteService;


public abstract class UsuarioCrudServlet<T extends Usuario> extends HttpServlet {

    protected abstract UsuarioService<T> getService();

    protected abstract String getTipo();

    protected abstract T criarUsuario(HttpServletRequest request);

    private final Map<String, BiConsumer<HttpServletRequest, HttpServletResponse>> actions = new HashMap<>();

    @Override
    public void init()  {
        actions.put("new", (request, response) -> {
            try {
                nova(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        });
        actions.put("edit", (request, response) -> {
            try {
                editar(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        });
        actions.put("delete", (request, response) -> {
            try {
                deletar(request, response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String realPath = getServletContext().getRealPath("/WEB-INF/db.db");
        // String realPath = getServletContext().getRealPath("/");

        if (action == null || !actions.containsKey(action)) {
            listar(request, response, realPath);
        } else {
            actions.get(action).accept(request, response);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response, String realPath)
            throws ServletException, IOException {
        List<T> usuarios = getService().listarTodos(realPath);
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/" + getTipo() + "s.jsp").forward(request, response);
    }

    private void nova(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/" + getTipo() + "_form.jsp").forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String realPath = getServletContext().getRealPath("/WEB-INF/db.db");
        // String realPath = getServletContext().getRealPath("/");
        int id = Integer.parseInt(request.getParameter("id"));
        T usuario = getService().buscarPorId(id, realPath);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("/" + getTipo() + "_form.jsp").forward(request, response);
    }

    private void deletar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = getServletContext().getRealPath("/WEB-INF/db.db");
        // String realPath = getServletContext().getRealPath("/");
        int id = Integer.parseInt(request.getParameter("id"));
        getService().deletar(id, realPath);
        response.sendRedirect("cadastro" + getTipo() + "s");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String realPath = getServletContext().getRealPath("/WEB-INF/db.db");
        // String realPath = getServletContext().getRealPath("/");
        T usuario = criarUsuario(request);

        if (usuario.getId() == 0) {
            getService().inserir(usuario, realPath);
        } else {
            getService().atualizar(usuario, realPath);
        }
        response.sendRedirect("cadastro" + getTipo() + "s");
    }
}