package com.david.games.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.games.model.Jogo;
import com.david.games.repository.JogoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/jogos")
public class JogoController {
    
    @Autowired
    private JogoRepository jogoRepository;

    @GetMapping
    public List<Jogo> listarJogos() {
        return (List<Jogo>) jogoRepository.findAll();
    }

    @PostMapping
    public Jogo criarJogo(@RequestBody Jogo jogo) {
        Jogo jogoNovo = jogoRepository.save(jogo);
        return jogoNovo;
    }

    @PutMapping
    public Jogo editarJogo(@RequestBody Jogo jogo) {
        Jogo jogoNovo = jogoRepository.save(jogo);
        return jogoNovo;
    }

    @DeleteMapping("/{id}")
    public Optional<Jogo> excluirJogo(@PathVariable Integer id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        jogoRepository.deleteById(id);
        return jogo;
    }

}
