package com.siifo.siifo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class producto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombreProducto;
	private int cantidad;
	private int precio;
	private String categoria;
	private String fecha;
	
	public producto() {
		
	}


	public producto(int id, String nombreProducto, int cantidad, int precio, String categoria,
			String fecha) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precio= precio;
		this.categoria = categoria;
		this.fecha = fecha;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getCantidadProducto() {
		return cantidad;
	}
	public void setCantidadProducto(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio= precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "producto [nombreProducto=" + nombreProducto + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", categoria=" + categoria + ", fecha=" + fecha + "]";
	}
	
	
	

}
