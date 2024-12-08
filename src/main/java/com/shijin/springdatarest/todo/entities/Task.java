package com.shijin.springdatarest.todo.entities;

import com.shijin.springdatarest.todo.exception.GlobalExceptionHandler;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Task {
   @NotBlank( message = GlobalExceptionHandler.TASK_NAME_SHOULD_NOT_BE_BLANK )
   @Column( nullable = false )
   private String name;

   private String description;

}
