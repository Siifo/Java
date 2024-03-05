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
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;  

    @Column(name = "tipoIdentificacionCliente", nullable = true, columnDefinition = "ENUM('C.C','T.I')")
    private String tipoIdentificacionCliente;

    @Column(name = "numeroIdentificacionCliente", nullable = true, columnDefinition = "INT(10)")
    private int numeroIdentificacionCliente;

    @Column(name = "nombresCliente", nullable = true, columnDefinition = "VARCHAR(200)")
    private String nombresCliente;

    @Column(name = "apellidossCliente", nullable = true, columnDefinition = "VARCHAR(200)")
    private String apellidossCliente;
    
    @Column(name = "numeroCliente", nullable = true, columnDefinition = "INT(15)")
    private int numeroCliente;

    @Column(name = "direccionCliente", nullable = true, columnDefinition = "VARCHAR(200)")
    private String direccionCliente;

    @Column(name = "correoCliente", nullable = true, columnDefinition = "VARCHAR(200)")
    private String correoCliente;

}
