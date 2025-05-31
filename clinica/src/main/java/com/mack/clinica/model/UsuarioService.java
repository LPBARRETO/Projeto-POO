package com.mack.clinica.model;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;

import java.util.List;

public abstract  class UsuarioService <T extends Usuario> {

    protected abstract String usuarioTipo();
    // protected abstract UsuarioService<T> getService();

    public void inserir(T usuario, String realPath) {
        UsuarioDAO.inserir(usuario, realPath);
    }

    public void atualizar(T usuario, String realPath) {
        UsuarioDAO.atualizar(usuario, realPath);
    }

    public void deletar(int id, String realPath) {
        UsuarioDAO.deletar(id, realPath);
    }

    public T buscarPorId(int id, String realPath) {
        return (T) UsuarioDAO.buscarPorId(id, realPath);
    }

    public List<T> listarTodos(String realPath) {
        return (List<T>) UsuarioDAO.listarPorTipo(usuarioTipo(), realPath);
       }
    
}
