package com.github.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping           
    public List<DadosListagemMedico> listar() {
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
        
    }

    




   
}
