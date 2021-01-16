package br.com.fabribh.chadefralda.services;

import br.com.fabribh.chadefralda.api.dto.ConvidadoDTO;
import br.com.fabribh.chadefralda.model.entities.Convidado;
import br.com.fabribh.chadefralda.model.entities.Estoque;
import br.com.fabribh.chadefralda.model.entities.Presente;
import br.com.fabribh.chadefralda.model.repositories.EstoqueRepository;
import br.com.fabribh.chadefralda.model.repositories.PresenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresenteService {

    @Autowired
    private PresenteRepository repository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    public Presente salvarPresente(ConvidadoDTO dto, Estoque estoque, Convidado convidadoSaved) throws Exception {

        Presente presente = new Presente();
        presente.setEstoque(estoque);
        presente.setQuantidade(dto.getQuantidade());
        presente.setConvidado(convidadoSaved);

        validarEstoque(estoque, dto);

        return repository.save(presente);
    }

    private void validarEstoque(Estoque estoque, ConvidadoDTO dto) throws Exception {

        Estoque estoqueDisponivel = estoqueRepository.getOne(estoque.getId());

        if(estoqueDisponivel.getQuantidade() < dto.getQuantidade()) {
            throw new Exception("Saldo em estoque insuficiente! Qauntidade disponnivel: " + estoqueDisponivel.getQuantidade());
        }

    }
}
