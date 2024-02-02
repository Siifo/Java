package com.cursoPA.t2r.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoPA.t2r.entity.Usuario;
import com.cursoPA.t2r.repository.usuarioRepository;

@Service
public class usuarioService {

    @Autowired
    usuarioRepository UsuarioRepository;

    public List<Usuario> getUsuarioList(){
        return UsuarioRepository.findAll();
    }
    public Optional<Usuario> getUsuario(Long id){
        return UsuarioRepository.findById(id);
    }

    public void saveOrUpdate(Usuario usuario){
        UsuarioRepository.save(usuario);
    }

    public void delete(Long id){
        UsuarioRepository.deleteById(id);
    }
}
