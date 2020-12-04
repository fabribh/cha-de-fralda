package br.com.fabribh.chadefralda.services;

import br.com.fabribh.chadefralda.model.entities.Presente;
import br.com.fabribh.chadefralda.model.repositories.PresenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresenteService {

    @Autowired
    private PresenteRepository presenteRepository;

    public List<Presente> listar() {
        return presenteRepository.findAll();
    }

}
