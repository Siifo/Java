package com.siifo.siifo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siifo.siifo.entity.Orden_Compra;

@Repository
public interface OrdenCompraRepository extends CrudRepository<Orden_Compra, Long> {
    
}
