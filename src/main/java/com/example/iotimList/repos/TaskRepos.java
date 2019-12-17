package com.example.iotimList.repos;

import com.example.iotimList.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepos extends CrudRepository<Task, Long> {
    List<Task> findByStatus(String filter);
}
