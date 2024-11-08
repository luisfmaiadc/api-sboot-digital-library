package com.portfolio.api_sboot_digital_library.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleInvalidArgument(MethodArgumentNotValidException exception) {
        var error =exception.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(DadosErro::new).toList());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ViaCepException.class)
    public ResponseEntity handleInvalidCep(ViaCepException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(AgeException.class)
    public ResponseEntity handleInvalidAge(AgeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    private record DadosErro(String campo, String mensagem) {
        DadosErro(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

}
