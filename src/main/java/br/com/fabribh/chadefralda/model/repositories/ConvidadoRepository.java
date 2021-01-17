package br.com.fabribh.chadefralda.model.repositories;

import br.com.fabribh.chadefralda.model.entities.Convidado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvidadoRepository extends JpaRepository<Convidado, Integer> {
}

