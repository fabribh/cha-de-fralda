package br.com.fabribh.chadefralda.services;

import br.com.fabribh.chadefralda.api.dto.ConvidadoDTO;
import br.com.fabribh.chadefralda.model.entities.Convidado;
import br.com.fabribh.chadefralda.model.entities.Estoque;
import br.com.fabribh.chadefralda.model.entities.Presente;
import br.com.fabribh.chadefralda.model.modelExceptions.ChaException;
import br.com.fabribh.chadefralda.model.repositories.ConvidadoRepository;
import org.modelmapper.ModelMapper;
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
    private EstoqueService estoqueService;

    @Autowired
    private PresenteService presenteService;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public ConvidadoDTO save(ConvidadoDTO dto) throws Exception {

        if (telefoneJaExiste(dto)) {
            throw new ChaException("Telefone já existente.");
        }

        Convidado convidado = new Convidado(null,
                dto.getNome(),
                dto.getTelefone(),
                setDataDaCriacao());

        Estoque estoque = estoqueService.findOne(dto.getEstoque().getId());

        estoqueService.validarEstoque(estoque, dto);

        Convidado convidadoSaved = convidadoRepository.save(convidado);

        Presente presente = presenteService.salvarPresente(dto, estoque, convidadoSaved);

        estoqueService.atualizarEstoque(estoque, presente);

        return new ConvidadoDTO(convidadoSaved);
    }

    private ZonedDateTime setDataDaCriacao() {

        Instant agora = Instant.now();
        ZoneId brasilSP = ZoneId.of("America/Sao_Paulo");

        return ZonedDateTime.ofInstant(agora, brasilSP);
    }

    public ConvidadoDTO sorteio() {

        ConvidadoDTO convidadoSorteado = new ConvidadoDTO();
        List<Convidado> convidados = convidadoRepository.findAll();
        Convidado convidado = getConvidadoSorteado(convidados);
        modelMapper.map(convidado, convidadoSorteado);
         return convidadoSorteado;
    }

    private Convidado getConvidadoSorteado(List<Convidado> convidados) {
        int quantidadeConvidados = convidados.size();
        Integer idSorteado = ThreadLocalRandom.current().nextInt(1, quantidadeConvidados);
        return convidadoRepository.findById(idSorteado)
                .orElseThrow();
    }

    private boolean telefoneJaExiste(ConvidadoDTO convidadoDTO) {
        Convidado convidado;
        List<Convidado> convidados = convidadoRepository.findAll();
        for (Convidado c : convidados) {
            if (c.getTelefone().equals(convidadoDTO.getTelefone())) {
                return true;
            }
        }
        return false;
    }
}
