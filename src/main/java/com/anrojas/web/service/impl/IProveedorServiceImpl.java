package com.anrojas.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.anrojas.web.entity.Proveedor;
import com.anrojas.web.repo.IGenericRepo;
import com.anrojas.web.repo.IProveedorRepo;
import com.anrojas.web.service.CRUDImpl;
import com.anrojas.web.service.IProveedorService;

@Service
public class IProveedorServiceImpl extends CRUDImpl<Proveedor, Integer> implements IProveedorService{

	@Autowired
    private IProveedorRepo repository;

	@Override
	protected IGenericRepo<Proveedor, Integer> getRepo() {
		return repository;
	}
	
	@Override
	public Page<Proveedor> listarPageable(Pageable page){
		return repository.findAll(page);
	}

	@Override
	public List<Proveedor> listarPorNombre(String nombre) {
		return repository.listarPorNombre(nombre);
	}

}
