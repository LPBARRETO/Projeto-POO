package com.mack.clinica.model;

public class MedicoService extends UsuarioService<Medico> {

    @Override
    protected String usuarioTipo() {
    return "medico";
    }
}
    