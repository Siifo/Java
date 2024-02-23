package com.cursoPA.t2r.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * cada nueva instacia de departamento debe tener una fecha de creacion y 
 * de moficacion
 */
@Data
@Table(name="departamento")
@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int departamento_codigo2;
    private String departamento_nombre;
    private Date fecha_hora_crea_dep; //(Solo visual)
    private Date fecha_hora_modifica_dep; //(Solo visual)

}
