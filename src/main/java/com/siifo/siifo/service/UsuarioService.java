package com.siifo.siifo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siifo.siifo.entity.Usuario;
import com.siifo.siifo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;


    public List<Usuario> getProductoList(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Optional<Usuario> getProducto(Long id){
        return (Optional<Usuario>) usuarioRepository.findById(id);
    }

    public int saveOrUpdate(Usuario u){
        int res =0;
        Usuario usuario = usuarioRepository.save(u); 
        if (!usuario.equals(null)) {
            res = 1;
        }
        return res;
    }

    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }
}
