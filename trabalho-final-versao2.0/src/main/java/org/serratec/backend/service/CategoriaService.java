package org.serratec.backend.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.dto.CategoriaDTO;
import org.serratec.backend.entity.CategoriaEntity;
import org.serratec.backend.mapper.CategoriaMapper;
import org.serratec.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	CategoriaMapper categoriaMapper;
	
// metodo para listar tds as categorias
	public List<CategoriaEntity> getAll() {
		List<CategoriaEntity> dto = categoriaRepository.findAll();
		return dto;
	}
//metodo para pesquisar por id
	public CategoriaEntity getByNome(String nome) throws NotFoundException {
		Optional<CategoriaEntity> categoria = categoriaRepository.findByNome(nome);
		if (categoria.isEmpty()) {
			throw new NotFoundException("Não achei");
		}
		return categoria.get();
	}
//metodo para criar um n
	public CategoriaDTO create(CategoriaDTO categoria) {
		CategoriaEntity categoriaNova = categoriaMapper.toEntity(categoria);
		return categoriaMapper.toDto(categoriaRepository.save(categoriaNova));
	}
//meteodo para dar update em uma categoria
	public CategoriaDTO update(String nome, CategoriaDTO categoria) throws NotFoundException {
		CategoriaEntity categoriaEntity = this.getByNome(nome);
		if(categoria.getNome() != null) {
			categoriaEntity.setNome(categoria.getNome());
		}
		if(categoria.getDescricao() != null) {
			categoriaEntity.setDescricao(categoria.getDescricao());
		}
		return categoriaMapper.toDto(categoriaRepository.save(categoriaEntity));
	}
//metodo para deletar uma categoria
	public void delete(String nome) throws NotFoundException {
		Optional<CategoriaEntity> ctgo = categoriaRepository.findByNome(nome);
		CategoriaEntity ctgo2=ctgo.get();
		Long idctgo2 = ctgo2.getId();
		categoriaRepository.deleteById(idctgo2);
		
	}
	
//	public void ProdutoToCategroria(String nome, ProdutoEntity produto) {
//		
//		CategoriaEntity ctgo = this.getByNome(nome);
//		ctgo.setProdutos(produto);
//	}
	
	
}
