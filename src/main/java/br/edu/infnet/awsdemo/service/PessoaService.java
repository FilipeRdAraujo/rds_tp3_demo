package br.edu.infnet.awsdemo.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.awsdemo.model.Pessoa;
import br.edu.infnet.awsdemo.repository.PessoaRepository;

@Service
public class PessoaService implements IPessoaService{
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Collection<Pessoa> getPessoas() {
        return (Collection<Pessoa>) pessoaRepository.findAll();
    }

    @Override
    public void store(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        
    }

    @Override
    public void deletePessoaById(Long id) {
        pessoaRepository.deleteById(id);;
    }

    @Override
    public Pessoa getPessoaPorId(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Pessoa> getPessoasPorEmail(String email) {
        Collection<Pessoa> pessoas = new ArrayList<>();
        pessoaRepository.findAll().forEach(o -> {
            if(o.getEmail().equals(email)) pessoas.add(o);
        });
        return pessoas;
    }
}
