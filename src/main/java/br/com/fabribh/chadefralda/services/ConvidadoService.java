package br.com.fabribh.chadefralda.services;

import br.com.fabribh.chadefralda.api.dto.ConvidadoDTO;
import br.com.fabribh.chadefralda.api.dto.EstoqueDTO;
import br.com.fabribh.chadefralda.model.entities.Convidado;
import br.com.fabribh.chadefralda.model.entities.Estoque;
import br.com.fabribh.chadefralda.model.entities.Presente;
import br.com.fabribh.chadefralda.model.repositories.ConvidadoRepository;
import br.com.fabribh.chadefralda.model.repositories.EstoqueRepository;
import br.com.fabribh.chadefralda.model.repositories.PresenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private PresenteRepository presenteRepository;

    @Transactional
    public ConvidadoDTO save(ConvidadoDTO dto) {

        Instant agora = Instant.now();
        ZoneId brasilSP = ZoneId.of("America/Sao_Paulo");

        Convidado convidado = new Convidado(null,
                dto.getNome(),
                dto.getTelefone(),
                ZonedDateTime.ofInstant(agora, brasilSP));

        Estoque estoque = estoqueRepository.getOne(dto.getEstoque().getId());

        Convidado convidadoSaved = convidadoRepository.save(convidado);

        Presente presente = new Presente();
        presente.setQuantidade(dto.getQuantidade());
        presente.setConvidado(convidadoSaved);
        presente.setEstoque(estoque);

        presenteRepository.save(presente);

        return new ConvidadoDTO(convidadoSaved);
    }

    public ConvidadoDTO sorteio() {

        ConvidadoDTO convidadoSorteado = new ConvidadoDTO();
        List<Convidado> convidados = convidadoRepository.findAll();
        Convidado convidado = getConvidadoSorteado(convidados);
//        modelMapper.map(convidado, convidadoSorteado);
        return convidadoSorteado;
    }

    private Convidado getConvidadoSorteado(List<Convidado> convidados) {
        int quantidadeConvidados = convidados.size();
        Integer idSorteado = ThreadLocalRandom.current().nextInt(1, quantidadeConvidados);
        return convidadoRepository.findById(idSorteado)
                .orElseThrow();
    }
}
