package com.cursoPA.t2r.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="empleado")
public class Empleado {
    //constructor, las fechas por defecto se guardan igual, solo se debe
    // sobrescribir una

    
    public Empleado(){
        fecha_hora_modifica= LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;
    private String documento_tipo;
    //data list en le formulario (RC, TI, CC, CE);
    private String documento_numero;
    private String nombres;
    private String apellidos;
    private String ciudad;
    private String direccion;
    //quiero encriptarlo de prueba
    private String correo_electronico;
    private String telefono;
    
    //
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "fecha_hora_crea")
    private String fecha_hora_crea; //(Solo visual)
    
    //
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "fecha_hora_modifica")
    private LocalDateTime fecha_hora_modifica;

    @ManyToOne
    @JoinColumn(name="departamento_id", nullable=false)
    private Departamento departamento_id; //llave foranea

}