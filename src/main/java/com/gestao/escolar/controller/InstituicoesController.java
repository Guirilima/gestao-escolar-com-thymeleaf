package com.gestao.escolar.controller;

import com.gestao.escolar.entity.InstituicaoEntity;
import com.gestao.escolar.repository.InstituicaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/instituicoes")
@AllArgsConstructor
public class InstituicoesController {

    private final InstituicaoRepository instituicaoRepository;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView resultado = new ModelAndView("instituicao/index"); //Retornando o arquivo html index
        List<InstituicaoEntity> instituicoes = instituicaoRepository.findAll();  //Transação Banco por todos os registros
        resultado.addObject("instituicoes",instituicoes);            //Populando o View index.html, com os dados vindo pela transação no BD
        return resultado;                                                        //Retornando o View populado com o Model[Dados]
    }

    @GetMapping("/inserir")
    public ModelAndView inserir() {
        ModelAndView resultado = new ModelAndView("instituicao/inserir");
        resultado.addObject("InstituicaoEntity",new InstituicaoEntity());
        return resultado;
    }

    @PostMapping("/inserir")
    public String inserir(InstituicaoEntity newInstituicaoEntity) {
        instituicaoRepository.save( newInstituicaoEntity );                      //Salvando nova instituicao no BD.
        return "redirect:/instituicoes/index";                                   //Após ter salvo, iremos retornar o Usuário a página inicial.
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        InstituicaoEntity instituicaoEntity = instituicaoRepository.getOne(id);
        ModelAndView resultado = new ModelAndView("instituicao/editar");    //Enviando por View os dados da Instituicao que será editada
        resultado.addObject("instituicaoEntity", instituicaoEntity);
        return resultado;
    }

    @PostMapping("/editar")
    public String editar(InstituicaoEntity instituicao) {
        instituicaoRepository.save(instituicao);
        return "redirect:/instituicoes/index";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        instituicaoRepository.deleteById(id);
        return "redirect:/instituicoes/index";
    }

    @GetMapping({"/pesquisarPorNome/{nome}", "/pesquisarPorNome"})
    public @ResponseBody List<InstituicaoEntity> pesquisarPorNome(@PathVariable Optional<String> nome){
        if (nome.isPresent()){
            return instituicaoRepository.findByNomeContaining(nome.get());
        } else {
            return instituicaoRepository.findAll();
        }
    }

    @GetMapping("/inserir2000")
    public String inserir2() {
        InstituicaoEntity newIn = new InstituicaoEntity();
        for ( int i = 0 ;i <= 2000;i++ ) {
            newIn = new InstituicaoEntity();
            newIn.setEndereco("TEST");
            newIn.setNome("TEST " + i);
            instituicaoRepository.save( newIn );                      //Salvando nova instituicao no BD.
        }
        return "redirect:/instituicoes/index";                                   //Após ter salvo, iremos retornar o Usuário a página inicial.
    }
}
