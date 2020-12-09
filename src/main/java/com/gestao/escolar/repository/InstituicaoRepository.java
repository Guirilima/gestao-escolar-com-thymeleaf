package com.gestao.escolar.repository;

import com.gestao.escolar.entity.InstituicaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends JpaRepository<InstituicaoEntity, Long> {

}
