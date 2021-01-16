package br.com.fabribh.chadefralda.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_presente")
public class Presente implements Serializable {

    private static final long serialVersionUID = 923308440522470358L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "convidado_id", referencedColumnName = "id")
    private Convidado convidado = new Convidado();

    @ManyToOne
    @JoinColumn(name = "estoque_id", nullable = false)
    private Estoque estoque = new Estoque();
}

