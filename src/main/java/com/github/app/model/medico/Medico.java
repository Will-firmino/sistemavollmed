package com.github.app.model.medico;

import com.github.app.model.endereco.Endereco;

import jakarta.persistence.*;
import lombok.*;

// Classe modelo responsável por criar uma tabela e suas colunas no BD.

@Getter // Lombok - Cria get para todos os atributos.
@Setter // Lombok - Cria set para todos os atributos.
@AllArgsConstructor // Lombok - Cria um construtor com todos os atributos.
@NoArgsConstructor // Lombok - Cria um construtor com nenhum atributo.
@EqualsAndHashCode(of = "id") // Lombok - Cria uma lógica de comparação através do campo "id".
@Entity // SPRING JPA - Informa que a classe abaixo é uma entidade, ou seja, será uma tabela no BD.
@Table(name = "medicos") // SPRING JPA *Opcional, gera uma tabela com o nome medicos no BD.
public class Medico {

    @Id // SPRING JPA - Informa para o BD que a chave primária PK, é o id.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // SPRING JPA - Cria o id único de forma automática
    private Integer id; // Não está vindo do insomnia 

    private String nome;
    private String email;
    private String crm;
 
    @Enumerated(EnumType.STRING) // SPRING JPA - Informa para o BD que o atributo é do tipo enum.
    private Especialidade especialidade;

    @Embedded // Utilizada na classe pai, associa uma entidade a uma tabela auxiliar
    private Endereco endereco;
    
    // Constructor com o recebimento dos dados convertendo para objeto
    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    // Método para verificar a atualização do médico, recebendo um objeto do tipo DadosAtualizacaoMedico e atualizando os atributos do médico com os dados recebidos na requisição.
    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        // Verifica se o nome recebido é diferente de null, ou seja, se o nome foi enviado na requisição da atualização (PUT), e se for diferente de null, atualiza o nome do médico com o novo nome recebido.
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.email() != null) {
            this.email = dados.email();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }


    }



}
