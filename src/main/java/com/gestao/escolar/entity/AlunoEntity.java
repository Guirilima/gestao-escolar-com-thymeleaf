package com.gestao.escolar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50)
    private String nome;

    @Column(precision = 0) //para não ter nenhuma casa decimal.
    private int idade;

    @ManyToOne
    private InstituicaoEntity instituicao;
}
