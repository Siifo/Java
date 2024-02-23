package com.cursoPA.t2r.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoPA.t2r.entity.Empleado;

@Repository
public interface empleadoRepository extends JpaRepository<Empleado, Long>{

}
