package br.com.fabribh.chadefralda.model.repositories;

import br.com.fabribh.chadefralda.model.entities.Presente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresenteRepository extends JpaRepository<Presente, Integer> {
}
