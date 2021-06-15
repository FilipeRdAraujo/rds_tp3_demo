package br.edu.infnet.awsdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.awsdemo.model.Endereco;
import br.edu.infnet.awsdemo.model.Pessoa;
import br.edu.infnet.awsdemo.service.EnderecoService;
import br.edu.infnet.awsdemo.service.PessoaService;
import feign.FeignException.FeignClientException;

@Controller
@RequestMapping(value = "/editar", method = RequestMethod.GET)
public class EdicaoController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EnderecoService enderecoService;

    @ModelAttribute("nPessoa")
    public Pessoa FormPessoa() {
        return new Pessoa();
    }

    @GetMapping
    public String editar() {
        return "redirect:/";
    }

    @GetMapping(value = "/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("pessoa", pessoaService.getPessoaPorId(id));
        return "editar_pessoas";
    }

    @PostMapping(value = "/{id}/")
    public String editarPessoa(@PathVariable("id") Long id, @ModelAttribute("nPessoa") @Valid Pessoa pessoa,
            BindingResult result) {
        try {
            Endereco endereco = enderecoService.pegarEndereco(pessoa.getCep());
            if (endereco.getErro() || result.hasErrors()) {
                result.rejectValue("cep", null, "CEP inserido é inválido.");
                return "editar_pessoas";
            } else {
                pessoa.setId(id);
                pessoa.setEndereco(new StringBuilder().append(endereco.getLogradouro()).append(" ")
                        .append(endereco.getBairro()).append(" ").append(endereco.getLocalidade()).append(" ")
                        .append(endereco.getUf()).toString());
                pessoaService.store(pessoa);
            }
            return "redirect:/";
        } catch (FeignClientException e) {
            result.rejectValue("cep", null, "CEP inserido é inválido");
            return "editar_pessoas";
        }
    }

}
