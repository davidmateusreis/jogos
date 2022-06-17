package com.david.games.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.games.model.Jogo;
import com.david.games.repository.JogoRepository;


@Service
public class JogoService {
    
    private JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> listarJogos() {
        List<Jogo> list = jogoRepository.findAll();
        return list;
    }

    public Jogo criarJogo(Jogo jogo) {
        Jogo jogoNovo =jogoRepository.save(jogo);
        return jogoNovo;
    }

    public Jogo editarJogo(Jogo jogo) {
        Jogo jogoNovo =jogoRepository.save(jogo);
        return jogoNovo;
    }

    public boolean excluirJogo(Integer id) {
        jogoRepository.deleteById(id);
        return true;
    }
}
