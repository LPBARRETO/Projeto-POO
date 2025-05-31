package com.mack.clinica.model;

public class Paciente extends Usuario {
    public Paciente() {
        super();
    }

    public Paciente(int id, String nome, String email, String cpf, String celular, String senha) {
        super(id, nome, email, cpf, celular, "paciente", senha);
    }
}
