package com.gestao.escolar.controller;

import com.gestao.escolar.entity.InstituicaoEntity;
import com.gestao.escolar.repository.InstituicaoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/instituicoes")
public class InstituicoesController {

    private InstituicaoRepository instituicaoRepository;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView resultado = new ModelAndView("instituicao/index"); //Retornando o arquivo html index
        List<InstituicaoEntity> instituicoes = instituicaoRepository.findAll();  //Transação Banco por todos os registros
        resultado.addObject("instituicoes",instituicoes);            //Populando o View index.html, com os dados vindo pela transação no BD
        return resultado;                                                        //Retornando o View populado com o Model[Dados]
    }
}
