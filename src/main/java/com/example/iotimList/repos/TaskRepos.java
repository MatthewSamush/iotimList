package com.example.iotimList.repos;

import com.example.iotimList.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepos extends CrudRepository<Task, Integer> {
}
