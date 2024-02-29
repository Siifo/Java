package com.cursoPA.t2r.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cursoPA.t2r.entity.Empleado;
import java.util.List;


@Repository
public interface empleadoRepository extends JpaRepository<Empleado, Long>{
    @Query(value = "SELECT * FROM cursoubv.empleado Where correo_electronico= :correo_electronico AND ciudad = :ciudad", nativeQuery = true)
    Empleado findByCorreo_electronico(String correo_electronico, String ciudad);
}
