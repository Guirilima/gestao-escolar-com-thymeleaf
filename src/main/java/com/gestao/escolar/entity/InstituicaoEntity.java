package com.gestao.escolar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
