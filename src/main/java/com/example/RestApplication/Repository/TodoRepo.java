package com.example.RestApplication.Repository;

import com.example.RestApplication.Entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
