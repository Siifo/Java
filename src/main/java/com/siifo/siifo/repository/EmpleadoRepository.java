package com.siifo.siifo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siifo.siifo.entity.Usuario;

@Repository
public interface EmpleadoRepository extends CrudRepository<Usuario, Long> {
    
}
