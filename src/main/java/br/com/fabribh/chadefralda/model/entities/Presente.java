package br.com.fabribh.chadefralda.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_presente")
public class Presente {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer quantidade;
}
