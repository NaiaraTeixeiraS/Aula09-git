package org.example;

import java.util.regex.Pattern;

public class NotificacaoService {

    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public boolean enviarEmail(String destinatario, String mensagem) {
        if (!emailValido(destinatario)) {
            throw new IllegalArgumentException("Email inválido: " + destinatario);
        }
        if (mensagem == null || mensagem.isBlank()) {
            throw new IllegalArgumentException("Mensagem não pode ser vazia");
        }
        // Simulação do envio
        System.out.println("Enviando email para " + destinatario + ": " + mensagem);
        return true;
    }

    private boolean emailValido(String email) {
        return email != null && EMAIL_REGEX.matcher(email).matches();
    }
}
