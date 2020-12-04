package br.com.fabribh.chadefralda.services;

import br.com.fabribh.chadefralda.api.dto.ConvidadoDTO;
import br.com.fabribh.chadefralda.model.entities.Convidado;
import br.com.fabribh.chadefralda.model.repositories.ConvidadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ConvidadoDTO save(ConvidadoDTO convidadoDTO) {
        Convidado convidado = new Convidado();
        modelMapper.map(convidadoDTO, convidado);
        Convidado convidadoSaved = convidadoRepository.save(convidado);
        modelMapper.map(convidadoSaved, convidadoDTO);
        return convidadoDTO;
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
        return convidadoRepository.buscarSorteado(idSorteado);
    }
}
