package br.com.fabribh.chadefralda.api.controllers;

import br.com.fabribh.chadefralda.model.entities.Estoque;
import br.com.fabribh.chadefralda.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @GetMapping
    public ResponseEntity<List<Estoque>> getEstoque() {

        return ResponseEntity.status(HttpStatus.OK).body(service.listAll());
    }
}
