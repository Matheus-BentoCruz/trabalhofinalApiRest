package org.serratec.backend.controllers;

import java.util.List;

import org.serratec.backend.dto.EnderecoDTO;
import org.serratec.backend.entity.EnderecoEntity;
import org.serratec.backend.service.EnderecoService;
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
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public List<EnderecoEntity> getAll() throws NotFoundException {
		return service.getAll();

	}

	@GetMapping("/{id}")
	public List<EnderecoEntity> getById(@PathVariable Long id) throws NotFoundException {
		return service.getById(id);

	}

	@PostMapping("/{id}")
	public EnderecoDTO create(@PathVariable("id") Long id,@RequestBody EnderecoDTO endereco) throws NotFoundException {
		return service.create(id, endereco);
	}

	@PutMapping("/{id}")
	public EnderecoDTO update(@PathVariable Long id, @RequestBody EnderecoDTO endereco) throws NotFoundException, BadHttpRequest {
		return service.update(id, endereco);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) throws NotFoundException {
		service.delete(id);
	}

}
