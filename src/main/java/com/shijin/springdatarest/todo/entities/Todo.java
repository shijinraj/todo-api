package com.shijin.springdatarest.todo.entities;

import java.util.ArrayList;
import java.util.List;

import com.shijin.springdatarest.todo.exception.GlobalExceptionHandler;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Todo {
   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY )
   private Long id;

   @NotBlank( message = GlobalExceptionHandler.TODO_NAME_SHOULD_NOT_BE_BLANK )
   @Column( nullable = false )
   private String name;

   private String description;

   @ElementCollection( fetch = FetchType.EAGER )
   @CollectionTable( name = "todo_tasks", joinColumns = @JoinColumn( name = "todo_id" ) )
   private List<Task> tasks = new ArrayList<>();
}
