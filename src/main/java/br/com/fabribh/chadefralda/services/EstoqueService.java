package br.com.fabribh.chadefralda.services;

import br.com.fabribh.chadefralda.api.dto.ConvidadoDTO;
import br.com.fabribh.chadefralda.model.entities.Estoque;
import br.com.fabribh.chadefralda.model.entities.Presente;
import br.com.fabribh.chadefralda.model.modelExceptions.ChaException;
import br.com.fabribh.chadefralda.model.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    public List<Estoque> listAll() {

        return repository.listaFraldasQuantidadePostivo();
    }

    public Estoque findOne(Integer estoqueId) {

        return repository.getOne(estoqueId);

    }

    public Estoque atualizarEstoque(Estoque estoque, Presente presente) {

        Integer atualizar = atualizar(estoque.getQuantidade(), presente.getQuantidade());

        estoque.setQuantidade(atualizar);

        return repository.save(estoque);

    }

    private Integer atualizar(Integer emEstoque, Integer saidaEstoque) {

        int resultado = emEstoque - saidaEstoque;

        if (resultado < 0) {
            return 0;
        }

        return resultado;
    }

    public void validarEstoque(Estoque estoque, ConvidadoDTO dto) throws Exception {

        Estoque estoqueDisponivel = repository.getOne(estoque.getId());

        if(estoqueDisponivel.getQuantidade() < dto.getQuantidade()) {
            throw new ChaException("Saldo em estoque insuficiente! Quantidade disponivel: " + estoqueDisponivel.getQuantidade() + ". Por favor selecione outra quantidade ou outro presente.");
        }

    }
}
