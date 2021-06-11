package org.serratec.backend.repository;

import java.util.Optional;

import org.serratec.backend.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	Optional<ProdutoEntity> findByNome(String nome);

}
