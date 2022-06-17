package com.david.games.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
import com.david.games.service.JogoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/jogos")
public class JogoController {

    private JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> listarJogos() {
        return ResponseEntity.status(200).body(jogoService.listarJogos());
    }

    @PostMapping
    public ResponseEntity<Jogo> criarJogo(@RequestBody Jogo jogo) {
        return ResponseEntity.status(201).body(jogoService.criarJogo(jogo));
    }

    @PutMapping
    public ResponseEntity<Jogo> editarJogo(@RequestBody Jogo jogo) {
        return ResponseEntity.status(200).body(jogoService.editarJogo(jogo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirJogo(@PathVariable Integer id) {
        jogoService.excluirJogo(id);
        return ResponseEntity.status(204).build();
    }

}
