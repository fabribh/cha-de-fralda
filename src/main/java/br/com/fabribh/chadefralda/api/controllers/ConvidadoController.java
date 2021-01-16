package br.com.fabribh.chadefralda.api.controllers;

import br.com.fabribh.chadefralda.api.dto.ConvidadoDTO;
import br.com.fabribh.chadefralda.api.dto.EstoqueDTO;
import br.com.fabribh.chadefralda.services.ConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/convidado")
public class ConvidadoController {

    @Autowired
    private ConvidadoService convidadoService;

    @PostMapping
    public ResponseEntity<EstoqueDTO> salvarConvidado(@Valid @RequestBody ConvidadoDTO convidadoDTO) {

        return new ResponseEntity(convidadoService.save(convidadoDTO),HttpStatus.CREATED);
    }

    @GetMapping(value = "/sorteio")
    public ResponseEntity<ConvidadoDTO> sorteio(){
        return ResponseEntity.ok().body(convidadoService.sorteio());
    }

}
