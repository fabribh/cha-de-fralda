package br.com.fabribh.chadefralda.api.dto;

import br.com.fabribh.chadefralda.model.entities.Presente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PresenteDTO implements Serializable {

    private static final long serialVersionUID = 5645364346967217334L;

    private Integer id;
    private Integer quantidade;

    private ConvidadoDTO convidadoDTO;
    private EstoqueDTO estoqueDTO = new EstoqueDTO();

    public PresenteDTO(Presente presente) {
        id = presente.getId();
        quantidade = presente.getQuantidade();
        convidadoDTO = new ConvidadoDTO(presente.getConvidado());
    }
}
