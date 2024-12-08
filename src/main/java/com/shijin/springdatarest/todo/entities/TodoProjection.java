package com.shijin.springdatarest.todo.entities;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder( { "id" } )
@Projection( name = "todoWithId", types = Todo.class )
public interface TodoProjection {
   Long getId();

   String getName();

   String getDescription();

   List<Object> getTasks();
}
