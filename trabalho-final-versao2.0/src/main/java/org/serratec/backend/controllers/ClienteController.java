package org.serratec.backend.controllers;

import java.util.List;

import org.serratec.backend.dto.ClienteDTO;
import org.serratec.backend.entity.ClienteEntity;
import org.serratec.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<ClienteEntity> getAll() throws NotFoundException{
		
		return service.getAll();
		
	}
	
	@GetMapping("/{id}")
	public ClienteEntity getById(@PathVariable Long id) throws NotFoundException {
		return service.getById(id);
		
	}
	
	@PostMapping
	public ClienteEntity create(@RequestBody ClienteEntity cliente) {
		return service.create(cliente);
	}
	
//	@PostMapping("/create")
//	public ClienteEntity create(@RequestBody ClienteEntity entity) {
//		
//		return service.createLongin(entity);
//	}
	
	@PutMapping("/{id}")
	public ClienteDTO update(@PathVariable Long id,@RequestBody ClienteDTO cliente) throws NotFoundException {
		return service.update(id, cliente);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) throws NotFoundException {
		service.delete(id);
	}

}
