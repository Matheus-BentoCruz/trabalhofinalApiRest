package org.serratec.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.dto.ProdutoDTO;
import org.serratec.backend.entity.CategoriaEntity;
import org.serratec.backend.entity.ProdutoEntity;
import org.serratec.backend.mapper.ProdutoMapper;
import org.serratec.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import javassist.tools.web.BadHttpRequest;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;
	
	@Autowired
	ProdutoMapper mapper;
	
	@Autowired
	CategoriaService catoService;
	
	public List<ProdutoEntity> getAll() throws NotFoundException{
		
		return repository.findAll();
		
	}
	
	public ProdutoEntity getByNome(String nome) throws NotFoundException{
		Optional<ProdutoEntity> produto = repository.findByNome(nome);
		if(produto.isEmpty()) {
			throw new NotFoundException("Não achei");
		}
		
		
		return produto.get();
		
	}
	
	public ProdutoDTO create(ProdutoDTO produto) throws NotFoundException {
		
		CategoriaEntity catgo = catoService.getByNome(produto.getCategoria());
		ProdutoEntity pdto = mapper.toEntity(produto);
		pdto.setCategoriaId(catgo);
		pdto.setDateCadastro(LocalDate.now());
		return mapper.toDto(repository.save(pdto));
	}
	
	public ProdutoDTO update(String  nome, ProdutoDTO produto) throws NotFoundException, BadHttpRequest{
		ProdutoEntity produtoEntity = this.getByNome(nome);
		
		if(produto.getNome() != null) {
			produtoEntity.setNome(produto.getNome());
		}
		
		if(produto.getDescricao() != null) {
			produtoEntity.setDescricao(produto.getDescricao());
		}
		
		if(produto.getQtdEstoque() != null) {
			if(produto.getQtdEstoque() < 0) {
				throw new BadHttpRequest();
			}else {
			produtoEntity.setQtdEstoque(produto.getQtdEstoque());
			}
		}
		
		if(produto.getPreco() != null) {
			if(produto.getPreco() < 0) {
				throw new BadHttpRequest();
				
			}else {
			produtoEntity.setPreco(produto.getPreco());
			}
		}
		
		produtoEntity.setDateAtualizacao(LocalDate.now());
		
		return mapper.toDto(repository.save(produtoEntity));
	}
	
	public void delete(String nome) throws NotFoundException {
		ProdutoEntity pdto = getByNome(nome);
		Long idPdto = pdto.getId();
		
		repository.deleteById(idPdto);
	}

}
