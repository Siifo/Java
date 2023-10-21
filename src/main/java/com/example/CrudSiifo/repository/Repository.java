package com.example.CrudSiifo.repository;

import com.example.CrudSiifo.models.producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<producto, Long> {

}
