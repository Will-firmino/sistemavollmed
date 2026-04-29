package com.github.app.model.consulta;

import java.time.LocalDateTime;

import com.github.app.model.medico.Medico;
import com.github.app.model.paciente.Paciente;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "consultas")
public class Consulta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "medicoId") // Define o nome da coluna "alias" na tabela consulta. Ou seja, pega a PK do médico e transformar em FK em consulta, com o nome da coluna de medicoId.
    @ManyToOne
    private Integer medico;

    @JoinColumn(name = "pacienteId")
    @ManyToOne
    private Integer paciente;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String observacao;

    private LocalDateTime data;

    // Terceiro Constructor da classe Consulta que recebe a conversão que a classe DTO DadosAgendamentoConsulta está realizando. Json -> OBJ(dict)
    public Consulta(DadosAgendamentoConsulta dados) {
        this.medico = dados.medicoId();
        this.paciente = dados.pacienteId();
        this.status = dados.status();
        this.observacao = dados.observacao();
        this.data = dados.data();
    }


}
