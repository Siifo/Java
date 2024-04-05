package com.siifo.siifo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siifo.siifo.entity.Detalle_evento;

@Repository
public interface DetalleEventoRepository extends CrudRepository <Detalle_evento, Long> {
    
}
