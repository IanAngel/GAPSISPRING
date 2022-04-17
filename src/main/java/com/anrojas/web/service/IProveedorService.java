package com.anrojas.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.anrojas.web.entity.Proveedor;

public interface IProveedorService extends ICRUD<Proveedor, Integer>{
	
	public Page<Proveedor> listarPageable(Pageable page);
	public List<Proveedor> listarPorNombre(String nombre);
		
}
