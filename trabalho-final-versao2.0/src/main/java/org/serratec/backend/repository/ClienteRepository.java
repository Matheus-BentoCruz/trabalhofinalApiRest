package org.serratec.backend.repository;

import org.serratec.backend.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	ClienteEntity findByNome(String username);

}
