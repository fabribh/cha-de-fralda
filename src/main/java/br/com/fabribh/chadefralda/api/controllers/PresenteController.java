package br.com.fabribh.chadefralda.api.controllers;

import br.com.fabribh.chadefralda.model.entities.Presente;
import br.com.fabribh.chadefralda.services.PresenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/presente")
public class PresenteController {

    @Autowired
    private PresenteService presenteService;

    @GetMapping
    public ResponseEntity<List<Presente>> getPresentes() {

        return ResponseEntity.ok().body(presenteService.listar());

    }
}
