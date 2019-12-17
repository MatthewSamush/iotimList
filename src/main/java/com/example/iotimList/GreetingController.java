package com.example.iotimList;

import com.example.iotimList.domain.Task;
import com.example.iotimList.repos.TaskRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public String main(Map<String,Object> model){
        Iterable<Task> task = taskService.getAllTasks();

        model.put("task",task);
        return "main";
    }


    @PostMapping
    public String addTask(String task,String status,Map<String,Object> model) {
        taskService.addTask(task,status);
        Iterable<Task> tasks = taskService.getAllTasks();
        model.put("myTasks", tasks);

        return "main";
    }


    @PostMapping("filter")
    public String filter(String filter, Map<String , Object> model){
        Iterable<Task> filteredList = taskService.filterTasks(filter);
        model.put("myTasks",filteredList);

        return "main";
    }
}