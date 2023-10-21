package com.example.CrudSiifo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name= "productos")
@Getter
@Setter
public class producto {

    @Id
    @Column(name = "idproductos")
    @Getter
    @Setter
    private Long idproductos;

    @Column(name = "nombre_producto")
    @Getter
    @Setter
    private String nombre_producto;

    @Column(name = "precio_compra")
    @Getter
    @Setter
    private double precio_compra;

    @Column(name = "cantidad")
    @Getter
    @Setter
    private int cantidad;

    @Column(name = "fecha_entrega")
    @Getter
    @Setter
    private Date fecha_entrega;

    @Column(name = "estado")
    @Getter
    @Setter
    private String estado;
}
