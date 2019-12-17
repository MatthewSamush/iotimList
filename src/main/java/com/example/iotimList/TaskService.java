package com.example.iotimList;

import com.example.iotimList.domain.Task;
import com.example.iotimList.repos.TaskRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepos taskRepos;

    public void addTask(String task,String status){
        Task newTask = new Task(task,status);
        taskRepos.save(newTask);
    }

    public Iterable<Task> getAllTasks(){
        return taskRepos.findAll();
    }
    public Iterable<Task> filterTasks(String filter){
        Iterable<Task> filteredList;
        if(filter !=null && !filter.isEmpty()){
            filteredList = taskRepos.findByStatus(filter);
        } else {
            filteredList = getAllTasks();
        }
        return filteredList;
    }
}
