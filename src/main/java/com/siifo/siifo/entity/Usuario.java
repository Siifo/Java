package com.siifo.siifo.entity;

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
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "tipoIdentificacion", nullable = true, columnDefinition = "ENUM('C.C','T.I', 'C.E', 'Pasaporte')")
    private String tipoIdentificacion;

    @Column(name = "numeroIdentificacion", nullable = true, columnDefinition = "VARCHAR(10)")
    private String numeroIdentificacion;

    @Column(name = "nombreUsario", nullable = true, columnDefinition = "VARCHAR(45)")
    private String nombreUsuario;
    
    @Column(name = "apellidoUsuario", nullable = true, columnDefinition = "VARCHAR(45)")
    private String apellidoUsuario;

    @Column(name = "numeroUsuario", nullable = true, columnDefinition = "VARCHAR(15)")
    private String numeroUsuario;

    @Column(name = "correoUsuario", nullable = true, columnDefinition = "VARCHAR(200)")
    private String correoUsuario;

    @Column(name = "contraseñaUsuario", nullable = true, columnDefinition = "VARCHAR(45)")
    private String contraseñaUsuario;

    @ManyToOne
    @JoinColumn(name = "rol_idRol")
    private Rol rol;

}
