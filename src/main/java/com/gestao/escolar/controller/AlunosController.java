package com.gestao.escolar.controller;

import com.gestao.escolar.entity.AlunoEntity;
import com.gestao.escolar.entity.InstituicaoEntity;
import com.gestao.escolar.repository.AlunoRepository;
import com.gestao.escolar.repository.InstituicaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/alunos")
@AllArgsConstructor
public class AlunosController {

    private final AlunoRepository alunoRepository;

    private final InstituicaoRepository instituicaoRepository;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView resultado = new ModelAndView("aluno/index");
        resultado.addObject("alunos", alunoRepository.findAll());
        return resultado;
    }

    @GetMapping("/inserir")
    public ModelAndView inserir() {
        ModelAndView resultado = new ModelAndView("aluno/inserir");
        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setInstituicao(new InstituicaoEntity());
        resultado.addObject("alunoEntity", alunoEntity);
        resultado.addObject("instituicoes", instituicaoRepository.findAll());
        return resultado;
    }

    @PostMapping("/inserir")
    public String inserir(AlunoEntity aluno) {
        alunoRepository.save(aluno);
        return "redirect:/alunos/index";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        AlunoEntity alunoEntity = alunoRepository.getOne(id);
        ModelAndView resultado = new ModelAndView("aluno/editar");
        resultado.addObject("alunoEntity", alunoEntity);
        resultado.addObject("instituicoes", instituicaoRepository.findAll());
        return resultado;
    }

    @PostMapping("/editar")
    public String editar(AlunoEntity aluno) {
        alunoRepository.save(aluno);
        return "redirect:/alunos/index";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return "redirect:/alunos/index";
    }
}
