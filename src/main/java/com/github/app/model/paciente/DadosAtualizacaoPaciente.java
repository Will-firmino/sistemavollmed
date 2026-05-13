package com.github.app.model.paciente;

import com.github.app.model.endereco.DadosCadastroEndereco;

public record DadosAtualizacaoPaciente(
    Integer id,
    String nome,
    String telefone,
    DadosCadastroEndereco endereco

) {
    
}
