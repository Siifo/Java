package com.siifo.siifo.interfaceService;


import org.springframework.stereotype.Component;

import com.siifo.siifo.model.producto;
@Component
public interface IproductoService {
	
	
	public int register(producto p);
	public void delete(int id);
}
