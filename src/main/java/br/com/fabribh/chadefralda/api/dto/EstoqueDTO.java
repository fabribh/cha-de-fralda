package br.com.fabribh.chadefralda.api.dto;

import br.com.fabribh.chadefralda.model.entities.Estoque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO implements Serializable {

    private static final long serialVersionUID = 7346538388203733141L;

    private Integer id;
    private String nome;
    private Integer quantidade;

    public EstoqueDTO(Estoque estoque) {
        id = estoque.getId();
        nome = estoque.getNome();
        quantidade = estoque.getQuantidade();
    }

}
