package org.serratec.backend.mapper;

import org.serratec.backend.dto.ClienteDTO;
import org.serratec.backend.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

	public ClienteEntity toEntity(ClienteDTO dto) {
		ClienteEntity clienteNovo = new ClienteEntity();
		clienteNovo.setNome(dto.getNome());
		clienteNovo.setCpf(dto.getCpf());
		clienteNovo.setDataNascimento(dto.getDataNascimento());
		clienteNovo.setEmail(dto.getEmail());
		clienteNovo.setTelefone(dto.getTelefone());
		clienteNovo.setSenha(dto.getSenha());
		clienteNovo.setUsername(dto.getUsername());
		
		return clienteNovo;
	
	}

	public ClienteDTO toDto(ClienteEntity cliente) {
		ClienteDTO dto = new ClienteDTO();
		dto.setNome(cliente.getNome());
		dto.setCpf(cliente.getCpf());
		dto.setDataNascimento(cliente.getDataNascimento());
		dto.setEmail(cliente.getEmail());
		dto.setTelefone(cliente.getTelefone());
		dto.setSenha(cliente.getSenha());
		dto.setUsername(cliente.getUsername());
		
		
		return dto;
	}

}
