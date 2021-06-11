package org.serratec.backend.controllers;

import java.util.List;

import org.serratec.backend.dto.CategoriaDTO;
import org.serratec.backend.entity.CategoriaEntity;
import org.serratec.backend.service.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService service;
	

	@GetMapping
	public List<CategoriaEntity> getAll() throws NotFoundException{
		return service.getAll();
	}
	
	@GetMapping("/{nome}")
	public CategoriaEntity getById(@PathVariable("nome") String nome) throws NotFoundException {
		return service.getByNome(nome);
	}
	
	@PostMapping
	public CategoriaDTO create(@RequestBody CategoriaDTO Categoria) {
		return service.create(Categoria);
	}
	
	@PutMapping("/{nome}")
	public CategoriaDTO update(@PathVariable("nome") String nome, @RequestBody CategoriaDTO Categoria) throws NotFoundException {
		return service.update(nome, Categoria);
	}
	
	@DeleteMapping("/{nome}")
	public void deleteNome(@PathVariable("nome") String nome) throws NotFoundException {
		service.delete(nome);
	}
	

}
