package com.github.app.model.endereco;

public record DadosCadastroEndereco(
    String logradouro,
    String bairro,
    String cep,
    String complemento,
    String cidade,
    String uf
) {
    
}
