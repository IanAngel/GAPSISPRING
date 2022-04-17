package com.anrojas.web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.anrojas.web.entity.Proveedor;

public interface IProveedorRepo extends IGenericRepo<Proveedor, Integer>{

	@Query("FROM Proveedor p where p.nombre = :pNombre")
	List<Proveedor> listarPorNombre(@Param("pNombre") String nombre);
}
