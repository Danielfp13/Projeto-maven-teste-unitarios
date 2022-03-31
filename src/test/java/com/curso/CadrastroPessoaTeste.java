package com.curso;

import com.curso.exceptions.CadastroVazioException;
import com.curso.exceptions.PessoaSemNomeException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;


public class CadrastroPessoaTeste {

    CadastroPessoa cadastroPessoa;
    Pessoa pessoa;

    @Before
    public void setup() {
        cadastroPessoa = new CadastroPessoa();
        pessoa = new Pessoa();
    }

    @Test
    public void CriarCadastroPessoaTeste() {

        Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();
    }

    @Test
    public void deveAdicionarPessoa() {
        pessoa.setNome("Maria");
        cadastroPessoa.adicionar(pessoa);
        Assertions.assertThat(cadastroPessoa.getPessoas()).isNotEmpty().hasSize(1).contains(pessoa);
        Assertions.assertThat(pessoa.getNome()).isNotBlank();
    }

    @Test(expected = PessoaSemNomeException.class)
    public void naoDeveAdcionarPessoaComNomeVazio(){
        cadastroPessoa.adicionar(pessoa);
    }

    @Test
    public void removerUmaPessoa(){
        pessoa.setNome("Luana");
        cadastroPessoa.adicionar(pessoa);
        cadastroPessoa.remover(pessoa);
        Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();
    }

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoRemoverPessoaInexistente(){
        cadastroPessoa.remover(pessoa);
    }

}


