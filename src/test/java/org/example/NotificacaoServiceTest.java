package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificacaoServiceTest {

    private final NotificacaoService service = new NotificacaoService();

    @Test
    void enviaEmailComDestinatarioValido() {
        assertTrue(service.enviarEmail("aluno@fatec.sp.gov.br", "Olá!"));
    }

    @Test
    void lancaExcecaoParaEmailSemArroba() {
        assertThrows(IllegalArgumentException.class,
                () -> service.enviarEmail("alunofatec.com", "Olá!"));
    }

    @Test
    void lancaExcecaoParaEmailSemDominio() {
        assertThrows(IllegalArgumentException.class,
                () -> service.enviarEmail("aluno@", "Olá!"));
    }

    @Test
    void lancaExcecaoParaEmailNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> service.enviarEmail(null, "Olá!"));
    }

    @Test
    void lancaExcecaoParaMensagemNula() {
        assertThrows(IllegalArgumentException.class,
                () -> service.enviarEmail("aluno@teste.com", null));
    }

    @Test
    void lancaExcecaoParaMensagemVazia() {
        assertThrows(IllegalArgumentException.class,
                () -> service.enviarEmail("aluno@teste.com", "   "));
    }
}
