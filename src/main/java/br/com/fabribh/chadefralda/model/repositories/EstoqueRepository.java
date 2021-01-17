package br.com.fabribh.chadefralda.model.repositories;

import br.com.fabribh.chadefralda.model.entities.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

    @Query("SELECT e FROM Estoque e WHERE e.quantidade >= 1")
    List<Estoque> listaFraldasQuantidadePostivo();
}

