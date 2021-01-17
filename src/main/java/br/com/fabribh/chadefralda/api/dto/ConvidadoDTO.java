package br.com.fabribh.chadefralda.api.dto;

import br.com.fabribh.chadefralda.model.entities.Convidado;
import br.com.fabribh.chadefralda.model.entities.Estoque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConvidadoDTO implements Serializable {

    private static final long serialVersionUID = -5355347461259550128L;

    private Integer id;
    private String nome;
    private String telefone;
    private ZonedDateTime criado_em;
    private Integer quantidade;
    private Estoque estoque;

    public ConvidadoDTO (Convidado convidado) {
        id = convidado.getId();
        nome = convidado.getNome();
        telefone = convidado.getTelefone();
        criado_em = convidado.getCriado_em();
    }

}
