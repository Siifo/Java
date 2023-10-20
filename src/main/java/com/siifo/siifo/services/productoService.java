package com.siifo.siifo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siifo.siifo.interfaceService.IproductoService;
import com.siifo.siifo.interfaces.Iproducto;
import com.siifo.siifo.model.producto;

@Service
public class productoService implements IproductoService{
	@Autowired
	private Iproducto data;
	
	@Override
	public int save(producto p) {
		int res=0;
		producto product=data.save(p);
		if (!product.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
