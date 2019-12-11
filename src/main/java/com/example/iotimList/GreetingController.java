package com.example.iotimList;

import com.example.iotimList.domain.Task;
import com.example.iotimList.repos.TaskRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private TaskRepos taskRepos;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String,Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String , Object> model){
        Iterable<Task> tasks = taskRepos.findAll();

        model.put("tasks",tasks);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String , Object> model){
        Task task = new Task(text,tag);
        taskRepos.save(task);

        Iterable<Task> tasks = taskRepos.findAll();
        model.put("tasks",tasks);

        return "main";
    }
}