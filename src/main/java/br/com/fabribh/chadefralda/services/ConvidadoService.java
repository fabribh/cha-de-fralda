package br.com.fabribh.chadefralda.services;

import br.com.fabribh.chadefralda.api.dto.ConvidadoDTO;
import br.com.fabribh.chadefralda.model.entities.Convidado;
import br.com.fabribh.chadefralda.model.repositories.ConvidadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ConvidadoDTO save(ConvidadoDTO convidadoDTO) {
        Convidado convidado = new Convidado();
        modelMapper.map(convidadoDTO, convidado);
        convidadoRepository.save(convidado);
        return convidadoDTO;
    }

}
