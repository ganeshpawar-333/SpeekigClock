package com.org.test.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class SpeakingClockExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(SpeakingClockExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("Generic Error", ex);
        return new ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = DateTimeParseException.class)
    public final ResponseEntity<String> handleDateTimeParseException(Exception ex) {
        logger.error("Datetime parsing Exception", ex);
        return new ResponseEntity("Error in Date Time Conversion.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
