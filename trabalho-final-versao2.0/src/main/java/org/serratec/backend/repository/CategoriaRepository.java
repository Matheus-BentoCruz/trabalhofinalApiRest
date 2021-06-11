package org.serratec.backend.repository;

import java.util.Optional;

import org.serratec.backend.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{

	Optional<CategoriaEntity> findByNome(String nome);

	void deleteByNome(String nome);


}
