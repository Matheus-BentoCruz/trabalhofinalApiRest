package org.serratec.backend.repository;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

	EnderecoEntity findByclienteIdIdAndTipoEndereco(Long id, String tipoendereco);

	Optional<List<EnderecoEntity>> findByclienteIdId(Long id);

}
