package com.david.games.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.david.games.dto.UsuarioDto;
import com.david.games.model.Usuario;
import com.david.games.repository.UsuarioRepository;
import com.david.games.security.Token;
import com.david.games.security.TokenUtil;

@Service
public class UsuarioService {
    
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> list = usuarioRepository.findAll();
        return list;
    }

    public Usuario criarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = usuarioRepository.save(usuario);
        return usuarioNovo;
    }

    public Usuario editarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo =usuarioRepository.save(usuario);
        return usuarioNovo;
    }

    public boolean excluirUsuario(Integer id) {
        usuarioRepository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = usuarioRepository.getReferenceById(usuario.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return valid;
    }

    public Token gerarToken(@Valid UsuarioDto usuario) {
        Usuario user = usuarioRepository.findByUsernameOrEmail(usuario.getUsername(), usuario.getEmail());
        if (user != null) {
            Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());
            if (valid) {
                return new Token(TokenUtil.createToken(user));
            }
        }
        return null;
    }
}
