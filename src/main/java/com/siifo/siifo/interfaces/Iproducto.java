package com.siifo.siifo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siifo.siifo.model.producto;

@Repository
public interface Iproducto extends CrudRepository<producto, Integer>{

}
