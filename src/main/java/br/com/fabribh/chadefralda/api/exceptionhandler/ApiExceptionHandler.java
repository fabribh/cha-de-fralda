package br.com.fabribh.chadefralda.api.exceptionhandler;

import br.com.fabribh.chadefralda.model.modelExceptions.ChaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ChaException.class)
  public ResponseEntity<Object> handlePsqlException(ChaException ex, WebRequest request) {
    var status = HttpStatus.BAD_REQUEST;

    var problema = new Problema();
    problema.setStatus(status.value());
    problema.setTitulo(ex.getMessage());
    problema.setDataHora(OffsetDateTime.now());

    return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
  }
}
