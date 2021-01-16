package br.com.fabribh.chadefralda.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_estoque")
public class Estoque implements Serializable {

    private static final long serialVersionUID = 3854154998651732560L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer quantidade;

    @JsonIgnore
    @OneToMany(mappedBy = "estoque")
    private Set<Presente> presente = new HashSet<>();

}
