package br.com.fabribh.chadefralda.model.repositories;

import br.com.fabribh.chadefralda.model.entities.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
}

