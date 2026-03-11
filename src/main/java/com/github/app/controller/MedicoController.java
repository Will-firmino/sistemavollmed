package com.github.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.app.model.medico.DadosCadastroMedico;

@RestController // SSPRING WEB- Informa para o Springboot que abaixo é uma classe controladora de requisições (GET-POST-PUT-DELETE).
@RequestMapping("medicos") // // SPRING WEB- Cria um caminho(endpoint) para a classe MedicoController. 
public class MedicoController {
    
    @PostMapping // SPRING WEB - Informa que o método abaixo é do tipo POST (cadastrar).
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        System.out.println(dados);
    }

   
}
