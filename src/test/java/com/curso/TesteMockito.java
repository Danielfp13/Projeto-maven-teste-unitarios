package com.curso;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TesteMockito {
    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMokito() {
        Mockito.when(lista.size()).thenReturn(20);
        int size;
        if(2 == 2){
            lista.size();
        }
       // Assertions.assertThat(size).isEqualTo(20);
        Mockito.verify(lista,Mockito.times(1) ).size();//verifica se ocorreram chamada de metodos
        Mockito.verify(lista,Mockito.never() ).isEmpty();//verifica não houve chamadas dos metodos
    }
}
