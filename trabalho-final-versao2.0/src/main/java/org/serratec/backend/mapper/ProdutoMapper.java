package org.serratec.backend.mapper;

import org.serratec.backend.dto.ProdutoDTO;
import org.serratec.backend.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

	public ProdutoEntity toEntity(ProdutoDTO dto) {
		ProdutoEntity entity = new ProdutoEntity();
		
		entity.setNome(dto.getNome());
		entity.setPreco(dto.getPreco());
		entity.setDescricao(dto.getDescricao());
		entity.setQtdEstoque(dto.getQtdEstoque());
		
		return entity;
	}
	
	public ProdutoDTO toDto(ProdutoEntity entity) {
		ProdutoDTO dto = new ProdutoDTO();
		
		dto.setNome(entity.getNome());
		dto.setPreco(entity.getPreco());
		dto.setDescricao(entity.getDescricao());
		dto.setDateCadastro(entity.getDateCadastro());
		dto.setQtdEstoque(entity.getQtdEstoque());
		dto.setDateAtualizacao(entity.getDateAtualizacao());
		
		return dto;
	}
	
}
