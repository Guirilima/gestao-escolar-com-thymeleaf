package com.gestao.escolar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstituicaoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 30)
    private String nome;

    @Column(length = 100)
    private String endereco;

    @OneToMany(mappedBy = "instituicao")
    private Set<AlunoEntity> alunoEntities;
}
