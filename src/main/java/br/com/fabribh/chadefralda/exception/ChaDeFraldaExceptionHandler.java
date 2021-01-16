package br.com.fabribh.chadefralda.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ChaDeFraldaExceptionHandler  extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;



    public static class Erro {
        private String mensagemUsuario;
        private String getMensagemDesenvolvedor;

        public Erro(String mensagemUsuario, String getMensagemDesenvolvedor) {
            this.mensagemUsuario = mensagemUsuario;
            this.getMensagemDesenvolvedor = getMensagemDesenvolvedor;
        }

        public String getMensagemUsuario() { return mensagemUsuario; }

        public String getGetMensagemDesenvolvedor() { return getMensagemDesenvolvedor; }
    }
}
