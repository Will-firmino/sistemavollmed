package com.github.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.github.app.model.medico.DadosAtualizacaoMedico;
import com.github.app.model.medico.DadosCadastroMedico;
import com.github.app.model.medico.DadosListagemMedico;
import com.github.app.model.medico.Medico;
import com.github.app.model.medico.MedicoRepository;

@RestController // SSPRING WEB- Informa para o Springboot que abaixo é uma classe controladora de requisições (GET-POST-PUT-DELETE).
@RequestMapping("medicos") // // SPRING WEB- Cria um caminho(endpoint) para a classe MedicoController. 
public class MedicoController {

    @Autowired // Sobrescrevendo algo. É um padrão utilizado na injeção de depêndecia.
    private MedicoRepository repository;
    
    @PostMapping // SPRING WEB - Informa que o método abaixo é do tipo POST (cadastrar).
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping("todos")  // SPRING WEB - Informa que o método abaixo é do tipo GET (buscar/ler)
    public List<Medico> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("listar")           
    public List<DadosListagemMedico> listar() {
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
        // findAll() -> Método que retorna uma lista de objetos do tipo DadosListagemMedico. 
        // stream() -> Método utilizado para transformar a lista em um fluxo de dados, permitindo aplicar operações de transformação.
        // map(DadosListagemMedico::new) -> Método utilizado para converter cada objeto do tipo medico em um json DadosListagemMedico, utilizando o constructor que criamos em DadosListagemMedico.
        // toList() -> Método utilizado para coletar os resultados em uma nova lista do tipo DadosListagemMedico, que é o formato que queremos retornar para a API.
    }

    @GetMapping         
    public Page<DadosListagemMedico> listarPorPagina(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
        //return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }

    @PutMapping
    public void atualizar(@RequestBody DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        // var é uma palavra reservada em Java que permite declarar uma variável sem especificar seu tipo. O tipo da variável é inferido pelo compilador com base no valor que foi atribuído a ela.
    }



    




   
}
