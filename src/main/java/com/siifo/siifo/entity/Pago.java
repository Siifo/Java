package com.siifo.siifo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagos;

    @ManyToOne
    @JoinColumn(name = "metodoDePagoPrincipal_idMetodoDePagoPrincipal")
    private Metodo_de_pago metodoDePagoPrincipal;

    @Column(name = "fechaPago", nullable = true)
    private Date fechaPago;

    @ManyToOne
    @JoinColumn(name = "detalleEvento_idDetalleEvento")
    private Detalle_evento detalleEvento;

    @Column(name = "numeroTarjeta", nullable = true, columnDefinition = "INT(11)")
    private int numeroTarjeta;

    @Column(name = "valor", nullable = true, columnDefinition = ("FLOAT"))
    private double valor;
}

