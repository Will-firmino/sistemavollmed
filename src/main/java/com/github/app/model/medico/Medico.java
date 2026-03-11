package com.github.app.model.medico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
