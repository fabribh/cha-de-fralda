package br.com.fabribh.chadefralda.model.entities;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_convidado")
public class Convidado implements Serializable {

    private static final long serialVersionUID = -3489222657680959303L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(unique = true)
    private String telefone;
    private ZonedDateTime criado_em;

    public Convidado(Integer id, String nome, String telefone, ZonedDateTime criado_em) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.criado_em = criado_em;
    }
}
