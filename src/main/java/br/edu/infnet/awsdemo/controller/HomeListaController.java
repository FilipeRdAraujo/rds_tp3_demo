package br.edu.infnet.awsdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import br.edu.infnet.awsdemo.model.AmazonClient;
import br.edu.infnet.awsdemo.model.Endereco;
import br.edu.infnet.awsdemo.model.Pessoa;
import br.edu.infnet.awsdemo.service.EnderecoService;
import br.edu.infnet.awsdemo.service.PessoaService;
import feign.FeignException.FeignClientException;

@EnableFeignClients
@Controller
public class HomeListaController {
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private AmazonClient amazonClient;

    @ModelAttribute("nPessoa")
    public Pessoa FormPessoa() {
        return new Pessoa();
    }

    @GetMapping("/")
    public String listarPessoas(Model model) {
        model.addAttribute("pessoas", pessoaService.getPessoas());
        return "lista_pessoas";
    }

    @PostMapping("/cadastrar")
    public String cadastrarPessoa(@RequestPart(value = "file") MultipartFile file,
            @ModelAttribute("nPessoa") @Valid Pessoa pessoa, BindingResult result) {
        try {
            System.out.println(file);
            if(file != null || !file.isEmpty()) this.amazonClient.uploadFile(file);
            Endereco endereco = enderecoService.pegarEndereco(pessoa.getCep());
            if (endereco.getErro() || result.hasErrors()) {
                result.rejectValue("cep", null, "CEP inserido é inválido.");
                return "lista_pessoas";
            } else {
                pessoa.setEndereco(new StringBuilder().append(endereco.getLogradouro()).append(" ")
                        .append(endereco.getBairro()).append(" ").append(endereco.getLocalidade()).append(" ")
                        .append(endereco.getUf()).toString());
                pessoaService.store(pessoa);
            }
            return "redirect:/";
        } catch (FeignClientException e) {
            result.rejectValue("cep", null, "CEP inserido é inválido");
            return "lista_pessoas";
        }
    }
}
