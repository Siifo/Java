package com.siifo.siifo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "metodoDePago")
public class Metodo_de_pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmetodoDePago;

    @Column(name = "nombreMetodoDePago", nullable = true, columnDefinition = "ENUM('Tarjeta Debito', 'Efectivo', 'Medio_Mano', 'Tarjeta Credito')")
    private String nombreMetodoDePago;
}
