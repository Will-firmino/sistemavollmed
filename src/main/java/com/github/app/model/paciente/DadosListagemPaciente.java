package com.github.app.model.paciente;

public record DadosListagemPaciente(
    Integer id,
    String nome,
    String email,
    String telefone,
    String cpf
) {
    
}
