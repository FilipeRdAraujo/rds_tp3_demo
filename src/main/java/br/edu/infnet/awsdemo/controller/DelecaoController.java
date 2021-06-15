package br.edu.infnet.awsdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.awsdemo.service.PessoaService;

@Controller
@RequestMapping(value = "/deletar", method = RequestMethod.GET)
public class DelecaoController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public String deletar() {
        return "redirect:/";
    }

    @GetMapping(value = "/{id}")
    public String editar(@PathVariable("id") Long id) {
        pessoaService.deletePessoaById(id);
        return "redirect:/";
    }
}
