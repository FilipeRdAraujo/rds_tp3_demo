package br.edu.infnet.awsdemo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.awsdemo.model.Endereco;

@FeignClient(url = "http://viacep.com.br/ws/", name = "EnderecoService")
public interface EnderecoService {
    @GetMapping(value = "{cep}/json")
    Endereco pegarEndereco(@PathVariable("cep") String cep);
}
