package org.serratec.backend.mapper;

import org.serratec.backend.dto.CategoriaDTO;
import org.serratec.backend.entity.CategoriaEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {
	
	public CategoriaEntity toEntity(CategoriaDTO dto) {
		CategoriaEntity entity = new CategoriaEntity();
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		return entity;
	}
	
	public CategoriaDTO toDto(CategoriaEntity categoria) {
		CategoriaDTO dto = new CategoriaDTO();
		dto.setNome(categoria.getNome());
		dto.setDescricao(categoria.getDescricao());
		return dto;
	}
}