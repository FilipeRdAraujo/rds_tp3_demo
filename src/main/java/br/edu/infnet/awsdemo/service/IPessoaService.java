package br.edu.infnet.awsdemo.service;

import java.util.Collection;

import br.edu.infnet.awsdemo.model.Pessoa;

public interface IPessoaService {
    void store( Pessoa pessoa );
    void deletePessoaById( Long id );
    Pessoa getPessoaPorId( Long id );
    Collection<Pessoa> getPessoasPorEmail(String email);
    Collection<Pessoa> getPessoas();
}
