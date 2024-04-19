package com.example.altiushub_task.Exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleGeneralException(Exception e) {
            return new ResponseEntity<>("An unexpected error occured" + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<String> handleDataIntegritiy(DataIntegrityViolationException e){
            return new ResponseEntity<>("Failed to save invoice due to possible same invoice number ",HttpStatus.CONFLICT);
        }
    }

