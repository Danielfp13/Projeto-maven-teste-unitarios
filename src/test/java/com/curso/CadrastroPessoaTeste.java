package com.curso;

import com.curso.exceptions.CadastroVazioException;
import com.curso.exceptions.PessoaSemNomeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CadrastroPessoaTeste {

    CadastroPessoa cadastroPessoa;
    Pessoa pessoa;

    @BeforeEach
    public void setup() {
        cadastroPessoa = new CadastroPessoa();
        pessoa = new Pessoa();
    }

    @Test
    @DisplayName("Deve criar cadrastro de pessoa")
    public void CriarCadastroPessoaTeste() {

        Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve adcionar uma pessoa")
    public void deveAdicionarPessoa() {
        pessoa.setNome("Maria");
        cadastroPessoa.adicionar(pessoa);
        Assertions.assertThat(cadastroPessoa.getPessoas()).isNotEmpty().hasSize(1).contains(pessoa);
        Assertions.assertThat(pessoa.getNome()).isNotBlank();
    }

    @DisplayName("Não deve adicionar pessoa com nome vazio")
    public void naoDeveAdcionarPessoaComNomeVazio() {
        org.junit.jupiter.api.Assertions
                .assertThrows(PessoaSemNomeException.class, () -> cadastroPessoa.adicionar(pessoa));

    }

    @Test
    @DisplayName("Deve remover uma pessoa")
    public void removerUmaPessoa() {
        pessoa.setNome("Luana");
        cadastroPessoa.adicionar(pessoa);
        cadastroPessoa.remover(pessoa);
        Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve lançar erro se pessoa não existir")
    public void deveLancarErroAoRemoverPessoaInexistente() {
        org.junit.jupiter.api.Assertions
                .assertThrows(CadastroVazioException.class, () -> cadastroPessoa.remover(pessoa));
    }

}


