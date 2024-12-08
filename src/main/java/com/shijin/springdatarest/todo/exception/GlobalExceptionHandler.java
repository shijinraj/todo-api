package com.shijin.springdatarest.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

   public static final String TASK_NAME_SHOULD_NOT_BE_BLANK = "Task name should not be Blank.";
   public static final String TODO_NAME_SHOULD_NOT_BE_BLANK = "Todo name should not be Blank.";

   @ExceptionHandler( ConstraintViolationException.class )
   public ProblemDetail handleInvalidInputException( final ConstraintViolationException constraintViolationException, final WebRequest request ) {

      log.error( "handleInvalidInputException ", constraintViolationException );

      final String errorDetails = constraintViolationException.getConstraintViolations()
            .stream()
            .map( violation -> violation.getMessage() ) // Extract the interpolated messages
            .filter( message -> message.equals( TASK_NAME_SHOULD_NOT_BE_BLANK ) || message.equals(
                  TODO_NAME_SHOULD_NOT_BE_BLANK ) ) // Focus on the specific message
            .findFirst() // Get the first occurrence of the relevant message
            .orElse( "Validation error occurred." ); // Default fallback message if no relevant message is found

      return ProblemDetail.forStatusAndDetail( HttpStatus.BAD_REQUEST, errorDetails );
   }

}


