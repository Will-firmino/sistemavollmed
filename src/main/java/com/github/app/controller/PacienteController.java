package com.github.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.app.model.paciente.DadosAtualizacaoPaciente;
import com.github.app.model.paciente.DadosCadastroPaciente;
import com.github.app.model.paciente.DadosListagemPaciente;
import com.github.app.model.paciente.Paciente;
import com.github.app.model.paciente.PacienteRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping("todos")  // SPRING WEB - Informa que o método abaixo é do tipo GET (buscar/ler)
    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("listar")           
    public List<DadosListagemPaciente> listar() {
        return repository.findAll().stream().map(DadosListagemPaciente::new).toList();
    }

     @GetMapping         
    public Page<DadosListagemPaciente> listarPorPagina(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional  // SPRING DATA JPA - Informa ao spring boot que o método irá alterar o BD.
    public void atualizar(@RequestBody DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    // Exclusão - AQUI ESTOU EXCLUINDO MESMO
    @DeleteMapping("/{id}")
    @Transactional // SPRING DATA JPA - Informa ao spring boot que o método irá exluir algo no BD.
    public void excluir(@PathVariable Integer id) { //@PathVarialbe - Informa que o springboot precisa pegar o caminho variável {id} e entender que é um campo chamado id do Médico.
        repository.deleteById(id);
    }

    // Exclusão lógica - Uma regra de negócio que permite que um registro seja "excluído" sem ser apagado do banco de dados. 
    // @DeleteMapping("/{id}")
    // @Transactional
    // public void alterarStatus(@PathVariable Integer id) {
    //     var paciente = repository.getReferenceById(id);
    //     paciente.exclusaoLogica();
    // }


    
}
