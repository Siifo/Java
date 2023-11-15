package com.siifo.siifo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siifo.siifo.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long>{
 
    
}