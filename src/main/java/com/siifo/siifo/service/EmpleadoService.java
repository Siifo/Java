package com.siifo.siifo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siifo.siifo.entity.Usuario;
import com.siifo.siifo.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Usuario> getProductoList(){
        return (List<Usuario>) empleadoRepository.findAll();
    }

    public Optional<Usuario> getProducto(Long id){
        return (Optional<Usuario>) empleadoRepository.findById(id);
    }

    public int saveOrUpdate(Usuario e){
        int res =0;
        Usuario producto = empleadoRepository.save(e);
        if (!producto.equals(null)) {
            res = 1;
        }
        return res;
    }

    public void delete(Long id){
        empleadoRepository.deleteById(id);
    }
}
