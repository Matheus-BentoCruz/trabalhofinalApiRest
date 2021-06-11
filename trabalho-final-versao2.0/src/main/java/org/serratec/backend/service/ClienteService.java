package org.serratec.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.dto.ClienteDTO;
import org.serratec.backend.entity.ClienteEntity;
import org.serratec.backend.mapper.ClienteMapper;
import org.serratec.backend.repository.ClienteRepository;
import org.serratec.backend.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	EnderecoService enderecoService;
	
	@Autowired
	ClienteMapper mapper;
	
	@Autowired
	BCryptPasswordEncoder bCrypt;

	public List<ClienteEntity> getAll() throws NotFoundException {
		return repository.findAll();
	}

	public ClienteEntity getById(Long id) throws NotFoundException {
		Optional<ClienteEntity> cliente = repository.findById(id);
		if (cliente.isEmpty()) {
			throw new NotFoundException("Não achei");
		}
		return cliente.get();
	}

	public ClienteEntity create(ClienteEntity cliente) {
		cliente.setSenha(bCrypt.encode(cliente.getSenha()));
//		ClienteEntity clienteNovo = mapper.toDto(cliente);
		
		cliente.setDataCadastro(LocalDate.now());
		
		return repository.save(cliente);
	}
	
	public ClienteEntity createLongin(ClienteEntity entity) {
		entity.setSenha(bCrypt.encode(entity.getSenha()));
		return repository.save(entity);
	}

	public ClienteDTO update(Long id, ClienteDTO cliente) throws NotFoundException {
		ClienteEntity clienteEntity = this.getById(id);

		if (cliente.getNome() != null) {
			clienteEntity.setNome(cliente.getNome());
		}

		if (cliente.getEmail() != null) {
			clienteEntity.setEmail(cliente.getEmail());
		}

		if (cliente.getUsername() != null) {
			clienteEntity.setUsername(cliente.getUsername());
		}

		if (cliente.getSenha() != null) {
			clienteEntity.setSenha(cliente.getSenha());
		}

		if (cliente.getTelefone() != null) {
			clienteEntity.setTelefone(cliente.getTelefone());
		}

		if (cliente.getDataNascimento() != null) {
			clienteEntity.setDataNascimento(cliente.getDataNascimento());
		}

		
		clienteEntity.setDataAtualizacao(LocalDate.now());
		return mapper.toDto(repository.save(clienteEntity));
	}

	
	public void delete(Long id) throws NotFoundException {
		repository.deleteById(id);
	}



}
