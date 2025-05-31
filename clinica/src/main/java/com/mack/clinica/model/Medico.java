package com.mack.clinica.model;

public class Medico extends Usuario {
    public Medico() {
        super();
    }

    public Medico(int id, String nome, String email, String cpf, String celular, String senha) {
        super(id, nome, email, cpf, celular, "medico", senha);
    }
}
