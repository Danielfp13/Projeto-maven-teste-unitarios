package com.curso;

import com.curso.exceptions.CadastroVazioException;
import com.curso.exceptions.PessoaSemNomeException;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoa {

    private List<Pessoa> pessoas;

    public List<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public CadastroPessoa() {
        this.pessoas = new ArrayList<>();
    }

    public void adicionar(Pessoa pessoa) {
        if (pessoa.getNome() == null) {
            throw new PessoaSemNomeException("Essa pessoa não possui nome.");
        }
        this.pessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa) {
        if (!this.pessoas.contains(pessoa)) {
            throw new CadastroVazioException("Essa pessoa não esta cadastrada");
        }

    }
}
