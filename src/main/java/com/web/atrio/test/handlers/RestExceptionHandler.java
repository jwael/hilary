package com.web.atrio.test.handlers;

import com.web.atrio.test.domain.HttpResponse;
import com.web.atrio.test.exception.EntityNotFoundException;
import com.web.atrio.test.exception.InvalidEntityExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.time.LocalTime.now;
/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<?> handleException(EntityNotFoundException exception, WebRequest webRequest) {

    final HttpStatus notFound = HttpStatus.NOT_FOUND;
    final HttpResponse httpResponse = HttpResponse.builder()
            .httpStatus(notFound)
            .statusCode(notFound.value())
            .message(exception.getMessage())
            .timeStamp(now().toString())
            .build();


    return new ResponseEntity<>(httpResponse, notFound);
  }



  @ExceptionHandler(InvalidEntityExeption.class)
  public ResponseEntity<?> handleException(InvalidEntityExeption exception, WebRequest webRequest) {
    final HttpStatus badRequest = HttpStatus.BAD_REQUEST;


    final HttpResponse httpResponse = HttpResponse.builder()
            .httpStatus(badRequest)
            .statusCode(badRequest.value())
            .message(exception.getMessage())
            .timeStamp(now().toString())
            .build();


    return new ResponseEntity<>(httpResponse, badRequest);
  }



}
