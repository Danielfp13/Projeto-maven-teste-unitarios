package com.curso;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;


public class PrimeiroTeste {

    Calculadora calculadora;

    @Before
    public void setup() {
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomarDoisNumeros() {
        //cenario
        int num1 = 10;
        int num2 = 5;
        //execução teste
        int res = calculadora.somar(num1, num2);
        //verificação
        Assertions.assertThat(res).isEqualTo(15);
    }

    @Test(expected = RuntimeException.class)
    public void NaodeveSomarNumerosNegativos() {

        //cenario
        int num1 = -10;
        int num2 = 5;
        //execução teste
       int res =  calculadora.somar(num1, num2);
    }

    @Test()
    public void deveSubtrairDoisNumeros() {
        //cenario
        int num1 = 10;
        int num2 = 5;
        //execução teste
       int res =  calculadora.subtrair(num1, num2);
       Assertions.assertThat(res).isEqualTo(5);
    }

    @Test()
    public void deveMultiplicarDoisNumeros() {
        //cenario
        int num1 = 10;
        int num2 = 5;
        //execução teste
        int res = calculadora.multplicar(num1, num2);
        Assertions.assertThat(res).isEqualTo(50);
    }

    @Test()
    public void deveDividirDoisNumeros() {
        //cenario
        int num1 = 10;
        int num2 = 5;
        //execução teste
        float res = calculadora.dividir(num1, num2);
        Assertions.assertThat(res).isEqualTo(2);
    }

    @Test(expected = ArithmeticException.class)
    public void naoDeveDividirPorZero() {
        //cenario
        int num1 = 10;
        int num2 = 0;
        //execução teste
        float res = calculadora.dividir(num1, num2);
    }


}

class Calculadora {
    int somar(int num1, int num2) {
        if (num1 <= 0 || num2 <= 0) {
            throw new RuntimeException("Não é permitido somar numeros negativos");
        }
        return num1 + num2;
    }

    int subtrair(int num1, int num2) {
        return num1 - num2;
    }

    int multplicar(int num1, int num2) {
        return num1 * num2;
    }

    float dividir(int num1, int num2) {
        if (num1 <= 0 || num2 <= 0) {
            throw new ArithmeticException("Não é pertido divisão por ZERO");
        }
        return(float) num1 / num2;
    }
}
