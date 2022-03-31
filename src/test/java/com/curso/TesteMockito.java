package com.curso;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TesteMockito {
    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMokito() {
        Mockito.when(lista.size()).thenReturn(20);
        int size;
        if (2 == 2) {
            lista.size();
        }
        // Assertions.assertThat(size).isEqualTo(20);
        Mockito.verify(lista, Mockito.times(1)).size();//verifica se ocorreram chamada de metodos
        Mockito.verify(lista, Mockito.never()).isEmpty();//verifica não houve chamadas dos metodos
    }
}
