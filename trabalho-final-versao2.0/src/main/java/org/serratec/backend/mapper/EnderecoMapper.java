package org.serratec.backend.mapper;

import org.serratec.backend.dto.EnderecoDTO;
import org.serratec.backend.entity.EnderecoEntity;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

	public EnderecoEntity toEntity(EnderecoDTO dto) {
		EnderecoEntity entity = new EnderecoEntity();
		
		entity.setCep(dto.getCep());
		entity.setEstado(dto.getEstado());
		entity.setBairro(dto.getBairro());
		entity.setRua(dto.getRua());
		entity.setNumero(dto.getNumero());
		entity.setComplemento(dto.getComplemento());
		entity.setTipoEndereco(dto.getTipoEndereco());
		entity.setCidade(dto.getCidade());
		
		return entity;
	}
	
	public EnderecoDTO toDto(EnderecoEntity entity) {
		EnderecoDTO dto = new EnderecoDTO();
		
		dto.setCep(entity.getCep());
		dto.setEstado(entity.getEstado());
		dto.setBairro(entity.getBairro());
		dto.setRua(entity.getRua());
		dto.setNumero(entity.getNumero());
		dto.setComplemento(entity.getComplemento());
		dto.setTipoEndereco(entity.getTipoEndereco());
		dto.setCidade(entity.getCidade());
		
		return dto;
	}
	
}
