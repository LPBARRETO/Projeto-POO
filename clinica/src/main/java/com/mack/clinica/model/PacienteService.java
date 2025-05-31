package com.mack.clinica.model;


public class PacienteService extends UsuarioService<Paciente> {
    @Override
    protected String usuarioTipo() {
        return "paciente";
    }
}
