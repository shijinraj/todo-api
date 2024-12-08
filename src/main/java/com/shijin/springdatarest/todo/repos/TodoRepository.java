package com.shijin.springdatarest.todo.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shijin.springdatarest.todo.entities.Todo;
import com.shijin.springdatarest.todo.entities.TodoProjection;

@RepositoryRestResource(
      collectionResourceRel = "todos",
      path = "todos",
      excerptProjection = TodoProjection.class
)
public interface TodoRepository extends CrudRepository<Todo, Long>, PagingAndSortingRepository<Todo, Long> {
}
