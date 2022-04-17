package com.anrojas.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anrojas.web.entity.Proveedor;
import com.anrojas.web.service.IProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService service;
					
	@GetMapping("/pageable")
	public ResponseEntity<Page<Proveedor>> listarPageable(Pageable page) throws Exception{
		Page<Proveedor> objeto = service.listarPageable(page);		
		return new ResponseEntity<>(objeto, HttpStatus.OK);
	}
	
	@GetMapping("/{nombre}")
	public ResponseEntity<List<Proveedor>> consultaByNombre(@PathVariable("nombre")String nombre) throws Exception{
		List<Proveedor> objeto = service.listarPorNombre(nombre);		
		return new ResponseEntity<>(objeto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Proveedor> registrar(@RequestBody Proveedor proveedor) throws Exception{
		System.out.println(proveedor.toString());
		List<Proveedor> lista = service.listarPorNombre(proveedor.getNombre());
		Proveedor objeto;
		if(lista.size()>0) {
			objeto = lista.get(0);
		}else{
			objeto = service.registrar(proveedor);	
		}				
		return new ResponseEntity<Proveedor>(objeto, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Proveedor> modificar(@RequestBody Proveedor proveedor) throws Exception{
		System.out.println(proveedor.toString());
		Proveedor objeto = service.modificar(proveedor);		
		return new ResponseEntity<Proveedor>(objeto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		System.out.println(id);
		service.eliminar(id);	
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
