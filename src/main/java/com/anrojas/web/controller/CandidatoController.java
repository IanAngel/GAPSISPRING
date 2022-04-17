package com.anrojas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/candidato")
public class CandidatoController {
				
	@Autowired
	BuildProperties buildProperties;
	
	@GetMapping("/detalle")
	public ResponseEntity<String> consultarDetalle() throws Exception{			
		return new ResponseEntity<String>("Bienvenido Candidato 1", HttpStatus.OK);
	}
	
	@GetMapping("/version")
	public ResponseEntity<String> consultarVersion() throws Exception{			
		return new ResponseEntity<String>(buildProperties.getVersion(), HttpStatus.OK);
	}
	
}
