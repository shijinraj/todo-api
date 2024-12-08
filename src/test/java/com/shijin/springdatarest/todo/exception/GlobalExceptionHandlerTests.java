package com.shijin.springdatarest.todo.exception;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.context.request.WebRequest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

class GlobalExceptionHandlerTest {

   private GlobalExceptionHandler globalExceptionHandler;
   private WebRequest mockWebRequest;

   @BeforeEach
   void setUp() {
      globalExceptionHandler = new GlobalExceptionHandler();
      mockWebRequest = mock( WebRequest.class );
   }

   @Test
   void handleInvalidInputException_withTaskNameBlankViolation_returnsProblemDetail() {
      // Prepare mock constraint violations
      final ConstraintViolation<?> mockViolation = mock( ConstraintViolation.class );
      when( mockViolation.getMessage() ).thenReturn( GlobalExceptionHandler.TASK_NAME_SHOULD_NOT_BE_BLANK );

      final Set<ConstraintViolation<?>> violations = Stream.of( mockViolation ).collect( Collectors.toSet() );
      final ConstraintViolationException exception = new ConstraintViolationException( violations );

      // Invoke the method
      final ProblemDetail problemDetail = globalExceptionHandler.handleInvalidInputException( exception, mockWebRequest );

      // Assertions
      assertNotNull( problemDetail );
      assertEquals( HttpStatus.BAD_REQUEST.value(), problemDetail.getStatus() );
      assertEquals( GlobalExceptionHandler.TASK_NAME_SHOULD_NOT_BE_BLANK, problemDetail.getDetail() );
   }

   @Test
   void handleInvalidInputException_withTodoNameBlankViolation_returnsProblemDetail() {
      // Prepare mock constraint violations
      final ConstraintViolation<?> mockViolation = mock( ConstraintViolation.class );
      when( mockViolation.getMessage() ).thenReturn( GlobalExceptionHandler.TODO_NAME_SHOULD_NOT_BE_BLANK );

      final Set<ConstraintViolation<?>> violations = Stream.of( mockViolation ).collect( Collectors.toSet() );
      final ConstraintViolationException exception = new ConstraintViolationException( violations );

      // Invoke the method
      final ProblemDetail problemDetail = globalExceptionHandler.handleInvalidInputException( exception, mockWebRequest );

      // Assertions
      assertNotNull( problemDetail );
      assertEquals( HttpStatus.BAD_REQUEST.value(), problemDetail.getStatus() );
      assertEquals( GlobalExceptionHandler.TODO_NAME_SHOULD_NOT_BE_BLANK, problemDetail.getDetail() );
   }

   @Test
   void handleInvalidInputException_withUnknownViolation_returnsDefaultErrorMessage() {
      // Prepare mock constraint violations
      final ConstraintViolation<?> mockViolation = mock( ConstraintViolation.class );
      when( mockViolation.getMessage() ).thenReturn( "Some unknown validation error" );

      final Set<ConstraintViolation<?>> violations = Stream.of( mockViolation ).collect( Collectors.toSet() );
      final ConstraintViolationException exception = new ConstraintViolationException( violations );

      // Invoke the method
      final ProblemDetail problemDetail = globalExceptionHandler.handleInvalidInputException( exception, mockWebRequest );

      // Assertions
      assertNotNull( problemDetail );
      assertEquals( HttpStatus.BAD_REQUEST.value(), problemDetail.getStatus() );
      assertEquals( "Validation error occurred.", problemDetail.getDetail() );
   }

   @Test
   void handleInvalidInputException_withMultipleViolations_returnsFirstMatchingMessage() {
      // Prepare multiple mock constraint violations
      final ConstraintViolation<?> violation1 = mock( ConstraintViolation.class );
      final ConstraintViolation<?> violation2 = mock( ConstraintViolation.class );

      when( violation1.getMessage() ).thenReturn( "Unrelated error" );
      when( violation2.getMessage() ).thenReturn( GlobalExceptionHandler.TASK_NAME_SHOULD_NOT_BE_BLANK );

      final Set<ConstraintViolation<?>> violations = Stream.of( violation1, violation2 ).collect( Collectors.toSet() );
      final ConstraintViolationException exception = new ConstraintViolationException( violations );

      // Invoke the method
      final ProblemDetail problemDetail = globalExceptionHandler.handleInvalidInputException( exception, mockWebRequest );

      // Assertions
      assertNotNull( problemDetail );
      assertEquals( HttpStatus.BAD_REQUEST.value(), problemDetail.getStatus() );
      assertEquals( GlobalExceptionHandler.TASK_NAME_SHOULD_NOT_BE_BLANK, problemDetail.getDetail() );
   }
}